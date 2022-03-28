package Project.enties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String kindOfJob;
    private LocalDate whenShouldBeDone;
    private BigDecimal payment;
    private String specialNotes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Usser_Job_Link",
            joinColumns = {@JoinColumn(name = "jobtodo_id")},
            inverseJoinColumns = {@JoinColumn(name = "usser_id")}
    )
   private Set<Usser> usserSet = new HashSet<>();

    public void addUsser(Usser usser)
    {
        usserSet.add(usser);
    }




}


