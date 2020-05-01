/*
"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation API Service

    @Description - Employee Model
"""
*/

package org.assignment.empmanage.employee;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emp_id;

    @Column(unique = true)
    private String emp_regNo;

    private String emp_name;

    private String emp_gender;

    private String emp_address;

    private Integer emp_phone;

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_regNo() { return emp_regNo; }

    public void setEmp_regNo(String emp_regNo) { this.emp_regNo = emp_regNo; }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public void setEmp_gender(String emp_gender) {
        this.emp_gender = emp_gender;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public Integer getEmp_phone() {
        return emp_phone;
    }

    public void setEmp_phone(Integer emp_phone) {
        this.emp_phone = emp_phone;
    }
}
