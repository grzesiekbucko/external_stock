package pl.bucko.external_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bucko.external_stock.entity.User;
import pl.bucko.external_stock.entity.UserJoinInterface;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    @Query(value = "SELECT p.user_id AS id, p.email AS email, p.name AS name, p.active AS active, role.role AS role from ((user_role c \n" +
            "INNER JOIN users p ON c.user_id=p.user_id)\n" +
            "INNER JOIN role ON role.role_id = c.role_id);", nativeQuery = true)
    List<UserJoinInterface> findAUsersAndRole();


}
