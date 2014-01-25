package com.me.db;

import com.me.model.Department;
import com.me.model.Employee;
import java.sql.SQLException;
import java.util.List;

public class EmployeeManager {

    private AccessHelper accessHelper = null;

    public EmployeeManager() {
        accessHelper = new AccessHelper();
    }

    public Employee getEmployeeById(int id) {
        EmployeeDAO employeeDAO = null;
        Employee emp = null;

        try {
            employeeDAO = new EmployeeDAO(accessHelper.getConnection());
            emp = employeeDAO.getEmployeeById(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (employeeDAO != null) {
                employeeDAO.releaseResources();
            }
        }
        return emp;
    }

    public List<Department> getAllDepartments() {
        EmployeeDAO employeeDAO = null;
        List<Department> departments = null;

        try {
            employeeDAO = new EmployeeDAO(accessHelper.getConnection());
            departments = employeeDAO.getAllDepartments();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (employeeDAO != null) {
                employeeDAO.releaseResources();
            }
        }
        return departments;
    }

    public int addEmployee(Employee emp){
        EmployeeDAO employeeDAO = null;
        int changedRows = 0;
        try {
            employeeDAO = new EmployeeDAO(accessHelper.getConnection());
            changedRows = employeeDAO.addEmployee(emp);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (employeeDAO != null) {
                employeeDAO.releaseResources();
            }
        }
        return changedRows;
    }
}
