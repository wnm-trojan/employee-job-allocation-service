package org.assignment.empmanage.worklog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorklogRepository extends JpaRepository<Worklog, Integer> {
}
