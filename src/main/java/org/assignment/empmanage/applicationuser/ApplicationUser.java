/*
"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation API Service

    @Description - ApplicationUser Model
"""
*/

package org.assignment.empmanage.applicationuser;

import javax.persistence.*;

@Entity
@Table(name="users")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(unique = true)
    private String user_regNo;

    private String email;

    private String username;

    private String password;

    private Boolean status;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_regNo() {
        return user_regNo;
    }

    public void setUser_regNo(String user_regNo) {
        this.user_regNo = user_regNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
