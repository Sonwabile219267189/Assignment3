package za.ac.cput.Controller;

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
import za.ac.cput.Entity.Pharmacy;
import za.ac.cput.Factory.PharmacyFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class PharmacyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    String baseUrl = "http://localhost:8080/Assignment3/pharmacy";

    private static Pharmacy pharmacy = PharmacyFactory.createPharmacyItem(5, 50.00);

    @Test
    public void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Pharmacy> postResponse = restTemplate.postForEntity(url, pharmacy, Pharmacy.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        pharmacy = postResponse.getBody();
        System.out.println("Saved data: " + pharmacy);
        assertEquals(pharmacy.getMedicineID(), postResponse.getBody().getMedicineID());

    }

    @Test
    public void b_read() {
        String url = baseUrl + "/read/" + pharmacy.getMedicineID();
        System.out.println("URL: "+ url);
        ResponseEntity<Pharmacy> responseEntity = restTemplate.getForEntity(url, Pharmacy.class);
        assertEquals(pharmacy.getMedicineID(), Objects.requireNonNull(responseEntity.getBody()).getMedicineID());


    }

    @Test
    public void c_update() {
        Pharmacy updated = new Pharmacy.Builder().copy(pharmacy).setPrice(65.00).build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Pharmacy> response = restTemplate.postForEntity(url,updated, Pharmacy.class );

    }

    @Test
    @Ignore
    public void e_delete() {
        String url = baseUrl + "/delete/" + pharmacy.getMedicineID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);

    }

    @Test
    public void d_getAll() {
        String url = baseUrl + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}

