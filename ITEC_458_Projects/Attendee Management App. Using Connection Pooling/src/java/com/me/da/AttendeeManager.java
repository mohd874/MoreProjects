package com.me.da;

import com.me.model.Attendee;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendeeManager {

    private ConnectionPool pool = null;

    public AttendeeManager() {
        pool = ConnectionPool.getInstance();
    }

    public Attendee getAttendeeByLogin(String login) {
        AttendeeDAO attendeeDAO = null;
        Attendee attendee = null;

        try {
            attendeeDAO = new AttendeeDAO(pool.getConnection());
            attendee = attendeeDAO.getAttendeeeByLogin(login);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (attendeeDAO != null) {
                attendeeDAO.releaseResources();
            }
        }
        return attendee;
    }

    public Attendee getAttendeeById(int id) {
        AttendeeDAO attendeeDAO = null;
        Attendee attendee = null;
        try {
            attendeeDAO = new AttendeeDAO(pool.getConnection());
            attendee = attendeeDAO.getAttendeeById(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (attendeeDAO != null) {
                attendeeDAO.releaseResources();
            }
        }
        return attendee;
    }

    public void addAttendee(Attendee attendee) {
        AttendeeDAO attendeeDAO = null;
        try {
            attendeeDAO = new AttendeeDAO(pool.getConnection());
            attendeeDAO.addAttendee(attendee);
            for (String email : attendee.getEmails()) {
                attendeeDAO.addEmail(attendee.getId(), email);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (attendeeDAO != null) {
                attendeeDAO.releaseResources();
            }
        }
    }

    public List<Attendee> getAttendees() {
        AttendeeDAO attendeeDAO = null;
        List<Attendee> attendees = new ArrayList<Attendee>();
        try {
            attendeeDAO = new AttendeeDAO(pool.getConnection());
            attendees = attendeeDAO.getAttendees();
        } catch (SQLException ex) {
            System.out.println("getAttendees() Method: " + ex.getMessage());
        } finally {
            if (attendeeDAO != null) {
                attendeeDAO.releaseResources();
            }
        }
        return attendees;
    }

    public void addEmailsToAttendee(int id, List<String> emails) {
        for (String email : emails) {
            addEmailToAttendee(id, email);
        }
    }

    public void addEmailToAttendee(int id, String email) {
        AttendeeDAO attendeeDAO = null;
        try {
            attendeeDAO = new AttendeeDAO(pool.getConnection());
            attendeeDAO.addEmail(id, email);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (attendeeDAO != null) {
                attendeeDAO.releaseResources();
            }
        }
    }
}
