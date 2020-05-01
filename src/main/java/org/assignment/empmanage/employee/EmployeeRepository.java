"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation Service

    Description - Employee Repository.
"""

package org.assignment.empmanage.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "insert into worklog (datetime, entity, descr) values (:datetime, :entity, :descr)",
            nativeQuery = true)
    void createWorklog(@Param("datetime") String datetime, @Param("entity") String entity, @Param("descr") String descr);

}
