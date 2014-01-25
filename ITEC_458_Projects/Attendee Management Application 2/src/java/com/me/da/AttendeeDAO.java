package com.me.da;

import com.me.model.Attendee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AttendeeDAO {

    private Connection connection;

    public AttendeeDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Attendee> getAttendees() throws SQLException {
        List<Attendee> attendees = new ArrayList<Attendee>();
        PreparedStatement stmt = null;
        try {
            String sqlGetAttendees = "SELECT * FROM attendees";
            stmt = connection.prepareStatement(sqlGetAttendees);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String name = rs.getString("name");

                List<String> emails = getEmailsByAttendeeId(id);
                Attendee a = new Attendee(id, login, password, name, emails);
                attendees.add(a);
            }
        } catch (SQLException sqle) {
            //do whatever you want before throwing the exception
            throw sqle;
        } finally {
            safeClose(stmt);
        }
        return attendees;
    }

    public Attendee getAttendeeById(int id) throws SQLException {
        Attendee attendee = null;
        PreparedStatement stmt = null;

        try {
            String sqlGetAttendee = "SELECT * FROM attendees WHERE id = ?";
            stmt = connection.prepareStatement(sqlGetAttendee);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String login = rs.getString("login");
                String password = rs.getString("password");
                List<String> emails = getEmailsByAttendeeId(id);
                attendee = new Attendee(id, login, password, name, emails);
            }
        } catch (SQLException unexpected) {
            throw unexpected;
        } finally {
            safeClose(stmt);
        }
        return attendee;
    }

    public Attendee getAttendeeeByLogin(String login) throws SQLException {
        Attendee attendee = null;
        PreparedStatement stmt = null;

        try {
            String sqlGetAttendee = "SELECT * FROM attendees WHERE login = ?";
            stmt = connection.prepareStatement(sqlGetAttendee);
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                List<String> emails = getEmailsByAttendeeId(id);
                attendee = new Attendee(id, login, password, name, emails);
            }
        } catch (SQLException unexpected) {
            throw unexpected;
        } finally {
            safeClose(stmt);
        }
        return attendee;
    }

    public List<String> getEmailsByAttendeeId(int id) throws SQLException {
        List<String> emails = new ArrayList<String>();
        PreparedStatement stmt = null;

        try {
            String sqlGetEmailsByAttendeeeId = "SELECT * FROM emails WHERE attendeeId = ?";
            stmt = connection.prepareStatement(sqlGetEmailsByAttendeeeId);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String email = rs.getString("email");
                emails.add(email);
            }
        } catch (SQLException unexpected) {
            throw unexpected;
        } finally {
            safeClose(stmt);
        }
        return emails;
    }

    public int addAttendee(Attendee attendee) throws SQLException {
        PreparedStatement stmt = null;
        int id = -1;
        try {
            String sqlAddAttendee = "INSERT INTO attendees (login, password, name) VALUES (?, ?, ?)";
            stmt = connection.prepareStatement(sqlAddAttendee);
            stmt.setString(1, attendee.getLogin());
            stmt.setString(2, attendee.getPassword());
            stmt.setString(3, attendee.getName());

            int rowsAffected = stmt.executeUpdate();

            String sqlGetAttendeeId = "SELECT id FROM attendees WHERE login = ?";
            PreparedStatement stmt2 = connection.prepareStatement(sqlGetAttendeeId);
            stmt2.setString(1, attendee.getLogin());
            ResultSet rs = stmt2.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
                attendee.setId(id);
            }
        } catch (SQLException sqle) {
            throw sqle;
        } finally {
            safeClose(stmt);
        }

        return id;
    }

    public void addEmail(int id, String email) throws SQLException {
        PreparedStatement stmt = null;
        try {
            String sqlAddEmail = "INSERT INTO emails (email, attendeeId) VALUES(?, ?)";
            stmt = connection.prepareStatement(sqlAddEmail);
            stmt.setString(1, email);
            stmt.setInt(2, id);

            int rowsAffected = stmt.executeUpdate();
        } catch (SQLException sqle) {
            throw sqle;
        } finally {
            safeClose(stmt);
        }
    }

    private void safeClose(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException sqle) {
        //ignore
        }
    }

    public void releaseResources() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException sqle) {
            //ignore
            }
        }
    }

    public static void main(String[] args) {
        AccessHelper jh;
        try {
            jh = new AccessHelper();
            Connection conn = jh.getConnection();
            AttendeeDAO attendeeDAO = new AttendeeDAO(conn);
            attendeeDAO.releaseResources();
        } catch (SQLException sqle) {

        }
    }
}
