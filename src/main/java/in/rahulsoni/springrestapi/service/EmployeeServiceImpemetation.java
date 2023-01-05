package in.rahulsoni.springrestapi.service;

import in.rahulsoni.springrestapi.model.Employee;
import in.rahulsoni.springrestapi.repository.EmployeePagitationAndSortingRepo;
import in.rahulsoni.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpemetation implements EmployeeService {

    private static List<Employee> list = new ArrayList<>();

    @Autowired
    private EmployeeRepository eRepository;


    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee e) {

        eRepository.save(e);
        return e;
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new RuntimeException("Employee is not found for the id" + id);
    }

    @Override
    public void deleteEmployee(Long id) {
        eRepository.deleteById(id);
    }

    @Override
    public Employee updateDetails(Employee e) {
        eRepository.save(e);
        return e;
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {

        return eRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmployeeByKeyword(String keyword) {

        return eRepository.findByNameContaining(keyword);
    }
}
