package org.lrdz.SimpleInterface;

import org.lrdz.UtilPojos.Employee;

import java.util.List;

public class EmployeeDB implements IDatabaseService<Employee>{
    //implementing the interface, with a specific object is automatically inferred.
    @Override
    public Employee getById(Long id) {
        Employee employee = new Employee();
        employee.setDni("dni");
        employee.setName("carla");
        return employee;
    }

    @Override
    public List<Employee> getAllRecords() {
        return null;
    }
}
