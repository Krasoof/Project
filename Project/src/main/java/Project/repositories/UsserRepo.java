
package Project.repositories;

import Project.enties.Usser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsserRepo extends JpaRepository<Usser, Integer> {
}
