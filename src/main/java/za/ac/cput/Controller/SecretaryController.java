package za.ac.cput.Controller;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Secretary;
import za.ac.cput.Factory.SecretaryFactory;
import za.ac.cput.Service.SecretaryService;


@RestController
@RequestMapping("/Assignment3/secretary") // class will be listening to requests through this path
public class SecretaryController {

    @Autowired
    // injecting the object of Auditor services into controllers so it can be manipulated over internet requests
    private SecretaryService secretaryService;

    // methods as per the Auditor service impl

    @PostMapping("/create") // Post is used to create a new record
    public Secretary create(@RequestBody Secretary secretary){
        Secretary creatingNewSecretary = SecretaryFactory.createSecretary(secretary.getName(), secretary.getLastName(), secretary.getSalary());
        return secretaryService.create(creatingNewSecretary);
    }

    @GetMapping("/read/{id}") // makes the variable part of the path, to specify what you actually trying to read
    public Secretary read (@PathVariable String id)
    {
        Secretary reading = secretaryService.read(id);
        return reading;
    }

    @PutMapping("/update") // Put is to update an existing record
    public Secretary update(@RequestBody Secretary secretary)
    {
        Secretary updated = secretaryService.update(secretary);
        return updated;
    }

    @DeleteMapping("/delete/{id}") // makes the variable part of the path, to specify what you actually trying to delete
    public boolean delete(@PathVariable String id)
    {
        boolean deleted = secretaryService.delete(id);
        return deleted;
    }

    @GetMapping("/all")
    public Set getAll(){
        return (Set) secretaryService.getAll();
    }
}
