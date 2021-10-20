package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.Secretary;
import za.ac.cput.Repository.ISecretaryRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service //acts as a service over the internet
public class SecretaryService implements ISecretaryService {

    @Autowired //enforces singleton
    private ISecretaryRepository secretaryRepository;


    @Override
    public Secretary create(Secretary t) {
        return this.secretaryRepository.save(t);
    }

    @Override
    public Secretary read(String s) {
        return this.secretaryRepository.findById(s).orElseGet(null);
    }

    @Override
    public Secretary update(Secretary t) {
        return this.secretaryRepository.save(t);
    }

    @Override
    public boolean delete(String s) {
        this.secretaryRepository.deleteById(s);
        if (this.secretaryRepository.existsById(s)) return false;
        else return true;
    }

    @Override
    public Set<Secretary> getAll() {
        return this.secretaryRepository.findAll().stream().collect(Collectors.toSet());
    }
}