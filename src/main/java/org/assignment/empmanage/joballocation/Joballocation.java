"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation Service

    Description - Joballocation Model.
"""

package org.assignment.empmanage.joballocation;

import org.assignment.empmanage.department.Department;
import org.assignment.empmanage.employee.Employee;
import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "joballocations")
public class Joballocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer job_id;

    @Column(unique = true)
    private  String job_no;

    @Column(name = "dep_fid")
    private Integer dep_fid;

    @ManyToOne
    @JoinColumn(name = "dep_fid", insertable = false, updatable = false)
    private Department department;

    @Column(name = "emp_fid")
    private Integer emp_fid;

    @ManyToOne
    @JoinColumn(name = "emp_fid", insertable = false, updatable = false)
    private Employee employee;

    private Timestamp job_fromdate;

    private Timestamp job_todate;

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public String getJob_no() {
        return job_no;
    }

    public void setJob_no(String job_no) {
        this.job_no = job_no;
    }

    public Integer getDep_fid() {
        return dep_fid;
    }

    public void setDep_fid(Integer dep_fid) {
        this.dep_fid = dep_fid;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmp_fid() {
        return emp_fid;
    }

    public void setEmp_fid(Integer emp_fid) {
        this.emp_fid = emp_fid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getJob_fromdate() {
        return job_fromdate;
    }

    public void setJob_fromdate(Timestamp job_fromdate) {
        this.job_fromdate = job_fromdate;
    }

    public Timestamp getJob_todate() {
        return job_todate;
    }

    public void setJob_todate(Timestamp job_todate) {
        this.job_todate = job_todate;
    }
}
