package com.me.db;

import com.me.model.Department;
import com.me.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public Employee getEmployeeById(int id) throws SQLException{
        Employee emp = null;
        PreparedStatement stmt = null;
        try {
            String sqlGetEmployees = "SELECT * FROM employees e WHERE e.employee_id = ?";
            stmt = connection.prepareStatement(sqlGetEmployees);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                emp = new Employee();
                emp.setId(rs.getInt("employee_id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));
                emp.setAddress(rs.getString("address"));
                emp.setMobile(rs.getString("mobile"));
                emp.setDepartment(rs.getInt("department_id"));
            }
        } catch (SQLException sqle) {
            System.out.println("getEmployeeById");
            throw sqle;
        } finally {
            safeClose(stmt);
        }
        return emp;
    }

    
    public int addEmployee(Employee emp) throws SQLException{
        int changedRows = 0;
        PreparedStatement stmt = null;
        try {
            String addEmployee = "INSERT INTO employees (employee_id," +
                    "first_name,last_name,email,address,mobile,department_id)" +
                    "values (?,?,?,?,?,?,?)";
            stmt = connection.prepareStatement(addEmployee);
            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getFirstName());
            stmt.setString(3, emp.getLastName());
            stmt.setString(4, emp.getEmail());
            stmt.setString(5, emp.getAddress());
            stmt.setString(6, emp.getMobile());
            stmt.setInt(7, emp.getDepartment());
            changedRows = stmt.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println("addEmployee");
            throw sqle;
        } finally {
            safeClose(stmt);
        }
        return changedRows;
    }

    public List<Department> getAllDepartments() throws SQLException{
        List<Department> departments = new ArrayList<Department>();
        Department department = null;
        PreparedStatement stmt = null;
        try {
            String sqlGetEmployees = "SELECT * FROM departments";
            stmt = connection.prepareStatement(sqlGetEmployees);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                department = new Department();
                department.setId(rs.getInt("department_id"));
                department.setName(rs.getString("department_name"));
                
                departments.add(department);
            }
        } catch (SQLException sqle) {
            System.out.println("getAllDepartments");
            throw sqle;
        } finally {
            safeClose(stmt);
        }
        return departments;
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
            EmployeeDAO attendeeDAO = new EmployeeDAO(conn);
            attendeeDAO.releaseResources();
        } catch (SQLException sqle) {

        }
    }
}
