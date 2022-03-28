package Project.serives;

import Project.enties.JobToDo;
import Project.enties.Usser;
import Project.repositories.JobToDoRepo;
import Project.repositories.UsserRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@Service
public class JobService {


    private final JobToDoRepo jobToDoRepo;
    private final UsserRepo usserRepo;

    public List<JobToDo> getAllJobs()
    {
        List<JobToDo> jobToDos = jobToDoRepo.findAll();

        return jobToDos;
    }

    public JobToDo addJob(JobToDo jobToDo)
    {

        return jobToDoRepo.save(jobToDo);

    }

    public  JobToDo findById(int id)
    {
        return  jobToDoRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono"));
    }

    public JobToDo addUsserTonJob(int id, int id1)
    {
        JobToDo job = jobToDoRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Nie znaleziono"));
        job.addUsser(usserRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Cant")));
        return jobToDoRepo.save(job);
    }


}
