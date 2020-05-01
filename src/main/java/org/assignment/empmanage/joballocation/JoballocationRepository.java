"""
    @author - Waruna Nissanka
    @email - warunanissanka44@gmail.com
    @project - Job Allowcation Service

    Description - Joballocation Repository.
"""

package org.assignment.empmanage.joballocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface JoballocationRepository extends JpaRepository<Joballocation, Integer> {

    @Query(value = "SELECT * FROM joballocations j LEFT JOIN departments d ON j.dep_fid = d.dep_id LEFT JOIN employees e ON j.emp_fid = e.emp_id",
    nativeQuery = true)
    List<Joballocation> listAllTable();

    @Modifying
    @Query(value = "insert into worklog (datetime, entity, descr) values (:datetime, :entity, :descr)",
            nativeQuery = true)
    void createWorklog(@Param("datetime") String datetime, @Param("entity") String entity, @Param("descr") String descr);

}
