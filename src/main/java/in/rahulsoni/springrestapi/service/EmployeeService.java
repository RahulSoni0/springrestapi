package in.rahulsoni.springrestapi.service;

import in.rahulsoni.springrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee saveEmployee(Employee e);

    Employee getSingleEmployee(Long id);

    void deleteEmployee(Long id);

    Employee updateDetails(Employee e);

    List<Employee> getEmployeeByName(String name);

    List<Employee> getEmployeeByKeyword(String keyword);


}
