package Project.mappers;

import Project.DTOs.UsserDTO;
import Project.DTOs.UsserDtoWrite;
import Project.enties.Usser;
import org.springframework.stereotype.Component;

@Component
public class UsserMapper {

    public Usser map(UsserDtoWrite usserDtoWrite)
    {
        return Usser.builder()
                .name(usserDtoWrite.getName())
                .surrname(usserDtoWrite.getSurrname())
                .build();

    }

    public UsserDTO map(Usser usser)
    {
        UsserDTO usserDTO = UsserDTO.builder()
                .Id(usser.getId())
                .name(usser.getName())
                .surrname(usser.getSurrname())
                .build();
        return usserDTO;
    }
}
