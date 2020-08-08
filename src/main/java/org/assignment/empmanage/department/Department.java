/*
"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation API Service

    @Description - Department Model
"""
*/

package org.assignment.empmanage.department;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dep_id;

    @Column(unique = true)
    private String dep_regNo;

    private String dep_name;

    private Boolean dep_status;

    public Integer getDep_id() {
        return dep_id;
    }

    public void setDep_id(Integer dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_regNo() { return dep_regNo; }

    public void setDep_regNo(String dep_regNo) { this.dep_regNo = dep_regNo; }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public Boolean getDep_status() {
        return dep_status;
    }

    public void setDep_status(Boolean dep_status) {
        this.dep_status = dep_status;
    }
}
