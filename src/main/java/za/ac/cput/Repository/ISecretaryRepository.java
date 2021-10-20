package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Entity.Secretary;

import java.util.Set;

public interface ISecretaryRepository extends JpaRepository<Secretary, String> {

    Set<Secretary> getAll();
}
