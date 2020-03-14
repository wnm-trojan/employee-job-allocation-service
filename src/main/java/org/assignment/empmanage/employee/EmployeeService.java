package org.assignment.empmanage.employee;

import org.assignment.empmanage.joballocation.Joballocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping
    @Transactional
    public void saveEmployee(@RequestBody Employee employee) {
        repository.save(employee);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String log = "New employee added. Employee register number is "+employee.getEmp_regNo();
        repository.createWorklog(formatter.format(date), "employees", log);
    }

    @PutMapping("/{id}")
    @Transactional
    public void updateEmployee(@RequestBody Employee employee, @PathVariable Integer id) {
        Employee existEmployee = getById(id);
        existEmployee.setEmp_regNo(employee.getEmp_regNo());
        existEmployee.setEmp_address(employee.getEmp_address());
        existEmployee.setEmp_gender(employee.getEmp_gender());
        existEmployee.setEmp_name(employee.getEmp_name());
        existEmployee.setEmp_phone(employee.getEmp_phone());
        repository.save(existEmployee);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String log = "Employee updated. Changed values are "+existEmployee.getEmp_regNo()+", "+existEmployee.getEmp_name()+", "+existEmployee.getEmp_gender()+", "+existEmployee.getEmp_address()+", "+existEmployee.getEmp_phone();
        repository.createWorklog(formatter.format(date), "employees", log);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteEmployee(@PathVariable Integer id) {
        Employee employee = getById(id);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String log = "Employee deleted. Employee register number is "+employee.getEmp_regNo();
        repository.createWorklog(formatter.format(date), "employees", log);
        getById(id);
        repository.deleteById(id);
    }

}
