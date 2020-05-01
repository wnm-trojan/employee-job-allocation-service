/*
"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation API Service

    @Description - Worklog Service
"""
*/

package org.assignment.empmanage.worklog;

import org.assignment.empmanage.employee.Employee;
import org.assignment.empmanage.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/worklogs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WorklogService {

    @Autowired
    private WorklogRepository repository;

    @GetMapping
    public List<Worklog> getAllWorklog() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Worklog getById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
