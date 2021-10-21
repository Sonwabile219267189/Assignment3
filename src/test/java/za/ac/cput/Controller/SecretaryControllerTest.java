package za.ac.cput.Controller;
//
//import org.junit.FixMethodOrder;
//import org.junit.Ignore;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import za.ac.cput.Entity.Secretary;
//import za.ac.cput.Factory.SecretaryFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)//fixes methods to run in a sequence
//@RunWith(SpringRunner.class)
//public class SecretaryControllerTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate; // specifically used to test sping framework controllers
//
//    private static final String Authenticate_Username = "Boss";
//    private static final String Authenticate_Password = "123";
//
//    String baseUrl = "http://localhost:8080/Assignment3/secretary";
//
//    private static Secretary secretary = SecretaryFactory.createSecretary("Xolani", "Ganta", 12000.00);
//
//    @Test
//    public void a_create() {
//        String url = baseUrl + "/create";
//        ResponseEntity<Secretary> responseEntity = restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).postForEntity(url, secretary, Secretary.class);
//        System.out.println("Created: " + secretary);
//        if (secretary != responseEntity.getBody()) {
//            secretary = responseEntity.getBody(); // this is to ensure that the created auditor has the same attributes as the one provided by the response entity.
//        }
//        assertEquals(secretary, responseEntity.getBody());
//        System.out.println("Saved auditor: " + responseEntity.getBody());
//    }
//
//    @Test
//    public void b_read() {
//        String url = baseUrl + "/read/" + secretary.getId();
//        ResponseEntity<Secretary> responseEntity = restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).getForEntity(url, Secretary.class);
//        assertEquals(secretary.getId(), responseEntity.getBody().getId());
//        System.out.println("Secretary created: " + secretary.getId() + "\n" + "Auditor read: " + responseEntity.getBody().getId());
//
//    }
//
//    @Test
//    public void c_update() {
//        Secretary updatedSecretary = new Secretary.Builder().copy(secretary).setLastName("Bali").build();
//        String url = baseUrl + "/update";
//        HttpEntity<Secretary> secretaryHttpEntity = new HttpEntity<>(updatedSecretary, null);
//        ResponseEntity<Secretary> responseUpdated = restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).exchange(url, HttpMethod.PUT, secretaryHttpEntity, Secretary.class);
//        assertEquals(updatedSecretary.getLastName(), responseUpdated.getBody().getLastName());
//        System.out.println("Secretary: " + updatedSecretary.getId() + "\n" + "Response from update: " + responseUpdated.getBody().getId());
//
//    }
//
//    @Test
//    @Ignore
//    public void e_delete() {
//        String url = baseUrl + "/delete/" + secretary.getId();
//        System.out.println("Deleting user: " + url);
//        restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).delete(url);
//     //   assertTrue("Deleted: " + secretary.getId(), true);
//    }
//
//    @Test
//    public void d_getAll() {
//        String url = baseUrl + "/all";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> retrievingAll = restTemplate.withBasicAuth(Authenticate_Username, Authenticate_Password).exchange(url, HttpMethod.GET, entity, String.class);
//        assertNotNull(retrievingAll);
//        System.out.println("Secretary: " + secretary + "\n" + "Secretary on DB: " + retrievingAll.getBody());
//
//    }
//}
//
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Entity.Secretary;
import za.ac.cput.Factory.SecretaryFactory;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // Defined port so it uses to 8080
public class SecretaryControllerTest {

    private static Secretary secretary = SecretaryFactory.createSecretary("Xolani", "Ganta", 12000.00);
    private static Secretary secretary1 = SecretaryFactory.createSecretary("Lionel", "Messi", 12000.00);

    private String securityUsername = "adminUser";
    private String securityPassword = "";

    private final String baseURL = "http://localhost:8080/secretary";

    @Autowired
    private TestRestTemplate restTemplate;

    // Create Test
    @Order(1)
    @Test
    void create() {
        String url = baseURL + "/create";

        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        ResponseEntity<Secretary> response;
        HttpEntity<Secretary> request = new HttpEntity<>(secretary, header);
        response = restTemplate.exchange(url, HttpMethod.POST, request, Secretary.class);
        assertEquals(secretary.getId(), response.getBody().getId());
        System.out.println(response.getBody());
    }

    // Read Test
    @Order(2)
    @Test
    void read() {
        String url = baseURL + "/read/" + secretary.getId();
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        System.out.println("URL: " + url);
        HttpEntity<Secretary> request = new HttpEntity<>(null, header);
        ResponseEntity<Secretary> response = restTemplate.exchange(url, HttpMethod.GET, request, Secretary.class);

        assertEquals(secretary.getId(), response.getBody().getId());
        System.out.println(response);
    }

    // Update Test
    @Order(3)
    @Test
    void update() {
        Secretary SecretaryUpdated = new Secretary.Builder().copy(secretary).setLastName("Dig").build();
        String url = baseURL + "/update";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);

        System.out.println("Updated Secretary: " + SecretaryUpdated);
        HttpEntity<Secretary> request = new HttpEntity<>(SecretaryUpdated, header);
        ResponseEntity<Secretary> response = restTemplate.exchange(url, HttpMethod.POST, request, Secretary.class);
        assertNotNull(response.getBody());
        System.out.println(response);
    }

    // Get All Test
    @Order(4)
    @Test
    void getAllTest1() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Get All Test (Customers): ");
        System.out.println(responseGetAll);
        System.out.println(responseGetAll.getBody());
    }

    // Delete Test
    @Order(5)
    @Test
    void delete() {
        String url = baseURL + "/delete/" + secretary.getId();

        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> request = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
        System.out.println(response);
        System.out.println("Deleted Secretary: " + secretary);
        assertEquals(200, response.getStatusCodeValue());
    }

    // Get All Test
    @Order(6)
    @Test
    void getAllTest2() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Get All Test (Customers): ");
        System.out.println(responseGetAll);
        System.out.println(responseGetAll.getBody());
    }

}
