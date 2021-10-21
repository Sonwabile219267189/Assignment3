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
import za.ac.cput.Entity.Receipt;
import za.ac.cput.Factory.ReceiptFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class ReceiptControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    String baseUrl = "http://localhost:8080/Assignment3/receipt";

    private static Receipt receipt = ReceiptFactory.createReceiptItem("zg8585");

    @Test
    public void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Receipt> postResponse = restTemplate.postForEntity(url, receipt, Receipt.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        receipt = postResponse.getBody();
        System.out.println("Saved data: " + receipt);
        assertEquals(receipt.getReceiptID(), postResponse.getBody().getReceiptID());

    }

    @Test
    public void b_read() {
        String url = baseUrl + "/read/" + receipt.getReceiptID();
        System.out.println("URL: "+ url);
        ResponseEntity<Receipt> responseEntity = restTemplate.getForEntity(url, Receipt.class);
        assertEquals(receipt.getReceiptID(), Objects.requireNonNull(responseEntity.getBody()).getReceiptID());


    }

    @Test
    public void c_update() {
        Receipt updated = new Receipt.Builder().copy(receipt).setReceiptID("fg4567").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Receipt> response = restTemplate.postForEntity(url,updated, Receipt.class );

    }

    @Test
    @Ignore
    public void e_delete() {
        String url = baseUrl + "/delete/" + receipt.getReceiptID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);

    }

    @Test
    public void d_getAll() {
        String url = baseUrl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());

    }
}

