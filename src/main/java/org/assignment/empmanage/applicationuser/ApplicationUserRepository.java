/*
"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation API Service

    @Description - ApplicationUser Repository
"""
*/

package org.assignment.empmanage.applicationuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Integer> {

    ApplicationUser findByUsername(String username);

}
