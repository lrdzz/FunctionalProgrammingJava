package org.lrdz.SimpleInterface;

import org.lrdz.UtilPojos.Employee;

public class Main {
    public static void main(String[] args) {
        EmployeeDB employeeDB = new EmployeeDB();
        Employee employee = employeeDB.getById(1L);
        System.out.println(employee.toString());
    }
}
