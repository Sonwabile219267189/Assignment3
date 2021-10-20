package za.ac.cput.Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Cashier;
import za.ac.cput.Factory.CashierFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class CashierControllerTest {

    private static Cashier cashier = CashierFactory.createsCashier("1001","Panado",1,100.00,0.00,100.00,100.00);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL ="http://localhost:8080/cashier";

    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Cashier> postResponse = restTemplate.postForEntity(url , cashier, Cashier.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        cashier = postResponse.getBody();
        System.out.println(" The created data is: "+cashier);
        assertEquals(cashier.getItemID(),postResponse.getBody().getItemID());


    }

    @Test
    void update() {
        Cashier update = new Cashier.Builder().copy(cashier).setItem("Panado").build();
        String url = baseURL + "/update";
        System.out.println("Updated data: " +update);
        ResponseEntity<Cashier> response = restTemplate.postForEntity(url,update,Cashier.class);
        assertNotNull(response.getBody());

    }

    @Test
    void read() {
        String url = baseURL + "/read/" + cashier.getItemID();
        System.out.println("URL "+url);
        ResponseEntity<Cashier> response = restTemplate.getForEntity(url,Cashier.class);
    }

    @Test
    void delete() {
        String url = baseURL + "/delete" + cashier.getItemID();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show data available ");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}