package in.rahulsoni.springrestapi.controller;

import in.rahulsoni.springrestapi.model.Employee;
import in.rahulsoni.springrestapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  @Controller -- we are dealing with rest annotations so directly use rest controller to reduce boilerplate annotations.
@RestController
//@RequestMapping("/api/v1") //uri mapping at class level now all the handler methods wil be after this uri...
public class EmployeeController {

    //autoWireService
    @Autowired //injection of service // eService will be injected to this Controller...
    //this will automatically creates a new object for this service.
    private EmployeeService eService;


//    // @Value("${app.name}")// used to read the applications properties..
//    //                    v  if we want to add default values then
//    @Value("${app.name: Employee Tracker}")
//    private String appName;
//
//    //    @Value("${app.version}")// used to read the applications properties..
//    @Value("${app.version: v1.0}")
//    private String appVersion;


//    // handler method that will return app name and version.. which is defined in applicaton.properties
//    @GetMapping("/name")
//    public String getAppName() {
//        return "App name : " + appName;
//    }
//
//    @GetMapping("/version")
//    public String getAppVersion() {
//        return "App version : " + appVersion;
//    }
//

//    @RequestMapping(value = "/employees" , method = RequestMethod.GET)
//    @ResponseBody
    //  ^ all the above are when we use @controller annotation

    @GetMapping("/employees") //with @RestController Annotation we can directly use http methods Mapping Annotation
    public ResponseEntity<List<Employee>> getEmployees() {

        return new ResponseEntity<>(eService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}") //with @RestController Annotation we can directly use http methods Mapping Annotation
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {

        return new ResponseEntity<>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    ///employees     ?user=34 & name="testDev" ....
    //              ^ passed as key: value pairs
    //               ^ QueryParams , we can add multiple queries by adding &

    @DeleteMapping("/employees")
    public ResponseEntity<String> deleteEmployee(@RequestParam("id") Long id) { //
        eService.deleteEmployee(id);
        return new ResponseEntity<>("Deleted the employee with id " + id, HttpStatus.NO_CONTENT);

    }

    @PostMapping("employees") //this will create new employee
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        System.out.println(" saving the employeee details to the database" + employee.toString());
        eService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    @PutMapping("employees/{id}") // this will update the whole employee details with the specified id//
    //   > here return type is Employee itself
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        employee.setId(id);
        eService.updateDetails(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);// directly returns the json response body..
    }

    @GetMapping("employees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {

        return new ResponseEntity<>(eService.getEmployeeByName(name), HttpStatus.OK);


    }

    @GetMapping("employees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeywords(@RequestParam String keyword) {
        return new ResponseEntity<>(eService.getEmployeeByKeyword(keyword), HttpStatus.OK);


    }

}
