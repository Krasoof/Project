package Project.repositories;

import Project.enties.JobToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobToDoRepo extends JpaRepository<JobToDo, Integer> {
}
