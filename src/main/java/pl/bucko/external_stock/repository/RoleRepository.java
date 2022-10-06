package pl.bucko.external_stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bucko.external_stock.entity.Role;


@Repository()
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);

}
