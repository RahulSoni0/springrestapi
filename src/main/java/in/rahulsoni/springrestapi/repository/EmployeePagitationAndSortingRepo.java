package in.rahulsoni.springrestapi.repository;

import in.rahulsoni.springrestapi.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface EmployeePagitationAndSortingRepo extends PagingAndSortingRepository<Employee, Long> {


}
