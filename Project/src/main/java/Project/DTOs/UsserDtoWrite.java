package Project.DTOs;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UsserDtoWrite {



    private String name;
    private String surrname;
}
