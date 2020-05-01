"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation Service

    Description - Joballocation Service.
"""

package org.assignment.empmanage.joballocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/joballocations")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JoballocationService {

    @Autowired
    private JoballocationRepository repository;

    @GetMapping
    public List<Joballocation> getAllJoballocations() {
        return repository.listAllTable();
    }

    @GetMapping("/{id}")
    public Joballocation getById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @PostMapping
    @Transactional
    public void saveJoballocation(@RequestBody Joballocation joballocation) {
        repository.save(joballocation);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String log = "New job allocated. Job Number is "+joballocation.getJob_no();
        repository.createWorklog(formatter.format(date), "joballocations", log);
    }

    @PutMapping("/{id}")
    @Transactional
    public void updateJoballocation(@RequestBody Joballocation joballocation, @PathVariable Integer id) {
        Joballocation existJoballocation = getById(id);
        existJoballocation.setJob_no(joballocation.getJob_no());
        existJoballocation.setDep_fid(joballocation.getDep_fid());
        existJoballocation.setEmp_fid(joballocation.getEmp_fid());
        existJoballocation.setJob_fromdate(joballocation.getJob_fromdate());
        existJoballocation.setJob_todate(joballocation.getJob_todate());
        repository.save(existJoballocation);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String log = "Job updated. Changed values are "+existJoballocation.getJob_no()+", "+existJoballocation.getDep_fid()+", "+existJoballocation.getEmp_fid()+", "+existJoballocation.getJob_fromdate()+", "+existJoballocation.getJob_todate();
        repository.createWorklog(formatter.format(date), "joballocations", log);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteJoballocation(@PathVariable Integer id) {
        Joballocation joballocation = getById(id);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String log = "Job deleted. Job Number is "+joballocation.getJob_no();
        repository.createWorklog(formatter.format(date), "joballocations", log);
        getById(id);
        repository.deleteById(id);
    }

}
