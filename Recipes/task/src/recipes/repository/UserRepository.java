package recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipes.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
