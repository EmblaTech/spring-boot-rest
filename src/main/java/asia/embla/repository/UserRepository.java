package asia.embla.repository;

import asia.embla.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tharsan on 8/23/18.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
