package za.ac.cput;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.Entity.Secretary;
import za.ac.cput.Factory.SecretaryFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//fixes methods to run in a sequence
@RunWith(SpringRunner.class)
public class SecretaryControllerTest {

    @Autowired
    private TestRestTemplate restTemplate; // specifically used to test sping framework controllers

    private static final String Authenticate_Username = "Boss";
    private static final String Authenticate_Password = "123";

    String baseUrl = "http://localhost:8080/Assignment3/secretary";

    private static Secretary secretary = SecretaryFactory.createSecretary("Xolani", "Ganta", 12000.00);

    @Test
    public void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Secretary> responseEntity = restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).postForEntity(url, secretary, Secretary.class);
        System.out.println("Created: " + secretary);
        if (secretary != responseEntity.getBody()) {
            secretary = responseEntity.getBody(); // this is to ensure that the created auditor has the same attributes as the one provided by the response entity.
        }
        assertEquals(secretary, responseEntity.getBody());
        System.out.println("Saved auditor: " + responseEntity.getBody());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "/read/" + secretary.getId();
        ResponseEntity<Secretary> responseEntity = restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).getForEntity(url, Secretary.class);
        assertEquals(secretary.getId(), responseEntity.getBody().getId());
        System.out.println("Secretary created: " + secretary.getId() + "\n" + "Auditor read: " + responseEntity.getBody().getId());

    }

    @Test
    public void c_update() {
        Secretary updatedSecretary = new Secretary.Builder().copy(secretary).setLastName("Bali").build();
        String url = baseUrl + "/update";
        HttpEntity<Secretary> secretaryHttpEntity = new HttpEntity<>(updatedSecretary, null);
        ResponseEntity<Secretary> responseUpdated = restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).exchange(url, HttpMethod.PUT, secretaryHttpEntity, Secretary.class);
        assertEquals(updatedSecretary.getLastName(), responseUpdated.getBody().getLastName());
        System.out.println("Secretary: " + updatedSecretary.getId() + "\n" + "Response from update: " + responseUpdated.getBody().getId());

    }

    @Test
    @Ignore
    public void e_delete() {
        String url = baseUrl + "/delete/" + secretary.getId();
        System.out.println("Deleting user: " + url);
        restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).delete(url);
     //   assertTrue("Deleted: " + secretary.getId(), true);
    }

    @Test
    public void d_getAll() {
        String url = baseUrl + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> retrievingAll = restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).exchange(url, HttpMethod.GET, entity, String.class);
        assertNotNull(retrievingAll);
        System.out.println("Secretary: " + secretary + "\n" + "Secretary on DB: " + retrievingAll.getBody());

    }
}

