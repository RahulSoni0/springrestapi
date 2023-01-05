package in.rahulsoni.springrestapi.repository;

import in.rahulsoni.springrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

//                                          v jpa repo will provide the crud methods .
@Repository // annotation for making this class an repository
//                                          JpaRepository // instead of just jpa we can use v
//                                              v this will allow pagination and sorting...
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    List<Employee> findByName(String name);

    //SELECT * FROM TABLE WHERE name LIKE "%ram%"
    List<Employee> findByNameContaining(String keyword);


}
