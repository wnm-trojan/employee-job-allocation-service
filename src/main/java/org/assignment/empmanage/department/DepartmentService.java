"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation Service

    Description - Department Service.
"""

package org.assignment.empmanage.department;

import org.assignment.empmanage.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/departments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @GetMapping
    public List<Department> getAllDepartments(){ return repository.findAll(); }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping
    @Transactional
    public void saveDepartment(@RequestBody Department department) {
        repository.save(department);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String log = "New Department added. Department register number is "+department.getDep_regNo();
        repository.createWorklog(formatter.format(date), "departments", log);
    }

    @PutMapping("/{id}")
    @Transactional
    public void updateDepartment(@RequestBody Department department, @PathVariable Integer id) {
        Department existDepartment = getById(id);
        existDepartment.setDep_regNo(department.getDep_regNo());
        existDepartment.setDep_name(department.getDep_name());
        existDepartment.setDep_status(department.getDep_status());
        repository.save(existDepartment);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String log = "Department updated. Changed values are "+existDepartment.getDep_regNo()+", "+existDepartment.getDep_name()+", "+existDepartment.getDep_status();
        repository.createWorklog(formatter.format(date), "departments", log);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDepartment(@PathVariable Integer id) {
        Department department = getById(id);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String log = "Department deleted. Department register number is "+department.getDep_regNo();
        repository.createWorklog(formatter.format(date), "departments", log);
        getById(id);
        repository.deleteById(id);
    }

}
