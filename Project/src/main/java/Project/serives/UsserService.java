package Project.serives;

import Project.DTOs.UsserDTO;
import Project.DTOs.UsserDtoWrite;
import Project.enties.Usser;
import Project.mappers.UsserMapper;
import Project.repositories.UsserRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
@Service
public class UsserService {

    private final UsserRepo usserRepol;
    private final UsserMapper usserMapper;

    public List<UsserDTO> getALl()
    {
        List<Usser> ussers = usserRepol.findAll();
       List<UsserDTO> usserDTOS = ussers.stream().map(usser -> usserMapper.map(usser)).collect(Collectors.toList());
       return usserDTOS;

    }

    public UsserDTO getUsser(int id)
    {
        List<Usser> ussers = usserRepol.findAll();
        return  ussers.stream().filter(usser -> usser.getId() == id)
                .map(usser -> usserMapper.map(usser))
                .findAny().orElseThrow(() -> new EntityNotFoundException("Nie znaleziono uzytkownika"));

    }

    public Usser addUsser(UsserDtoWrite usserDtoWrite)
    {
      Usser usserToSave = Usser.builder()
               .name(usserDtoWrite.getName())
               .surrname(usserDtoWrite.getSurrname())
               .build();
      usserRepol.save(usserToSave);

      return usserToSave;
    }

    public void deleteUsser(int id)
    {
        List<Usser> ussers = usserRepol.findAll();
       usserRepol.delete(ussers.stream().filter(usser -> usser.getId()==id).findFirst()
               .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono")));
    }

    public void deleteAll()
    {
        usserRepol.deleteAll();
    }

    public Usser setUsser(int id, UsserDtoWrite usserDtoWrite)
    {
        Usser usser = usserRepol.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono"));


        usser.setName(usserDtoWrite.getName());
        usser.setSurrname(usserDtoWrite.getSurrname());
        usserRepol.save(usser);

        return usser;
    }



    }
