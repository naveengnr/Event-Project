package Event.Event.Repository;

import Event.Event.Entities.SnackOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnackOrderRepo extends JpaRepository<SnackOrder,Integer> {
}
