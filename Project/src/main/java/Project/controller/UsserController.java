package Project.controller;

import Project.DTOs.UsserDTO;
import Project.DTOs.UsserDtoWrite;
import Project.enties.Usser;
import Project.serives.UsserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/appi/ussers")
public class UsserController {
    private final UsserService usserService;

    @GetMapping("/all")
    public ResponseEntity<List<UsserDTO>> getAll()
    {
        return new ResponseEntity<>(usserService.getALl(),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Usser> saveUsser(@RequestBody UsserDtoWrite usserDtoWrite)
    {
        return new ResponseEntity<>(usserService.addUsser(usserDtoWrite), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsserById(@PathVariable("id") int id)
    {
        usserService.deleteUsser(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Usser> changeUsserParams(@PathVariable("id") int id,@RequestBody UsserDtoWrite usserDtoWrite)
    {
        return new ResponseEntity<>(usserService.setUsser(id,usserDtoWrite), HttpStatus.ACCEPTED);
    }

}
