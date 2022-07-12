package home.tur.CrudApp.dao;

import home.tur.CrudApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
