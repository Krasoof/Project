package Project.enties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usser")
public class Usser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name = "surrname")
    private String surrname;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Usser_Job_Link",
            joinColumns = {@JoinColumn(name = "usser_id")},
            inverseJoinColumns = {@JoinColumn(name = "jobtodo_id")}
    )
    private Set<JobToDo> jobToDos = new HashSet<>();




}
