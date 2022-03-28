package Project.controller;

import Project.enties.JobToDo;
import Project.serives.JobService;
import Project.serives.UsserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/job")
public class JobController {

    private final UsserService usserServicel;
    private final JobService jobService;

    @GetMapping("/all")
    public ResponseEntity<List<JobToDo>> getAll ()
    {
        return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JobToDo> addJob(@RequestBody JobToDo jobToDo)
    {
        return new ResponseEntity<>(jobService.addJob(jobToDo), HttpStatus.ACCEPTED);
    }

    @PutMapping("/add/{id}/{id1}")
    public ResponseEntity<Void> addUsserToJob(@PathVariable("id") int id, @PathVariable("id1") int id1)
    {
        jobService.addUsserTonJob(id,id1);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
