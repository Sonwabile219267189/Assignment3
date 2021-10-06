package za.ac.cput.Repository;

import za.ac.cput.Entity.Secretary;

import java.util.Set;

public interface ISecretaryRepository extends IRepository<Secretary, String> {

    Set<Secretary> getAll();
}
