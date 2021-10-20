package za.ac.cput.Controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Factory.PatientFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ControllerPatientTest {

    private static Patient patient = PatientFactory.build("Stefan",20,"Male");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL ="http://localhost:8080/patient";

    public static  String Username ="Admin";
    public static String password  = "pass";
    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Patient> postResponse = restTemplate.postForEntity(url , patient, Patient.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        patient = postResponse.getBody();
        assertEquals(patient.getPatientID(),postResponse.getBody().getPatientID());


    }

    @Test
    void update() {
        Patient updated = new Patient.Builder().clone(patient).firstName("James").building();
        String url = baseURL + "/update";
        ResponseEntity<Patient> resposne = restTemplate.postForEntity(url,updated,Patient.class);
        assertNotNull(resposne.getBody());

    }

    @Test
    void read() {
        String url = baseURL + "/read/" + patient.getPatientID();
        System.out.println("URL "+url);
        ResponseEntity<Patient> response = restTemplate.getForEntity(url,Patient.class);
    }

    @Test
    void delete() {
        String url = baseURL + "/delete" + patient.getPatientID();
        System.out.println("URL: "+url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entitiy = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(Username,password)
                .exchange(url, HttpMethod.GET,entitiy,String.class);

        System.out.println(response);
        System.out.println(response.getBody());

    }
}