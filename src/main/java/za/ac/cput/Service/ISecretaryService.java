package za.ac.cput.Service;

import za.ac.cput.Entity.Secretary;

import java.util.Set;

public interface ISecretaryService extends IService<Secretary, String> {
    Set<Secretary> getAll();
}

