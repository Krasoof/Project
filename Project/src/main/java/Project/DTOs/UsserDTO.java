package Project.DTOs;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UsserDTO {


 private int Id;

    private String name;

    private String surrname;

}
