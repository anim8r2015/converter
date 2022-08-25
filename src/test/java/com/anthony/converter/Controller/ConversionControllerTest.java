package com.anthony.converter.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConversionControllerTest {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();
    private final HttpHeaders httpHeaders = new HttpHeaders();

    @LocalServerPort
    private int port;


    @Test
    public void givenACelsiusValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double fahrenheitValue = 55.2;
        double celsiusValue = 12.89;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/temperature/metric/" + fahrenheitValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(celsiusValue), responseEntity.getBody());
    }

    @Test
    public void givenAFahrenheitValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double celsiusValue = 55.2;
        double fahrenheitValue = 131.36;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/temperature/imperial/" + celsiusValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(fahrenheitValue), responseEntity.getBody());
    }


    @Test
    public void givenAnAcreValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double acreValue = 55.2;
        double hectareValue = 22.34;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/area/metric/" + acreValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(hectareValue), responseEntity.getBody());
    }

    @Test
    public void givenAHectareValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double hectareValue = 55.2;
        double acreValue = 136.40;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/area/imperial/" + hectareValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(acreValue), responseEntity.getBody());
    }

    @Test
    public void givenAMileValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double mileValue = 55.2;
        double kilometerValue = 88.82;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/length/metric/" + mileValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(kilometerValue), responseEntity.getBody());
    }

    @Test
    public void givenKilometerValueToConvert_whenExecuted_thenResponseContainsValueAndCorrectCode() {
        double mileValue = 61.78;
        double kilometerValue = 99.40;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/length/imperial/" + kilometerValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(mileValue), responseEntity.getBody());
    }

    @Test
    public void givenAGallonValueToConvert_whenExecuted_thenResponseContainsCorrectLitreValueAndCorrectCode() {
        double gallonValue = 5.2;
        double litreValue = 23.64;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/volume/metric/" + gallonValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(litreValue), responseEntity.getBody());
    }

    @Test
    public void givenLitreValueToConvert_whenExecuted_thenResponseContainsCorrectGallonValueAndCorrectCode() {
        double gallonValue = 2.07;
        double litreValue = 9.40;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/volume/imperial/" + litreValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(gallonValue), responseEntity.getBody());
    }

    @Test
    public void givenPoundValueToConvert_whenExecuted_thenResponseContainsCorrectKilogramValueAndCorrectCode() {
        double poundValue = 5.2;
        double kilogramValue = 2.36;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/weight/metric/" + poundValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(kilogramValue), responseEntity.getBody());
    }

    @Test
    public void givenKilogramValueToConvert_whenExecuted_thenResponseContainsCorrectPoundValueAndCorrectCode() {
        double poundValue = 20.73;
        double kilogramValue = 9.40;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/weight/imperial/" + kilogramValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
        assertEquals(String.valueOf(poundValue), responseEntity.getBody());
    }

    @Test
    public void givenAnUnknownMeasurement_whenExecuted_thenResponseWithErrorCodeAndMessage() {
        double kilogramValue = 9.40;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/test-measurement/imperial/" + kilogramValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void givenAnUnknownSystem_whenExecuted_thenResponseWithErrorCodeAndMessage() {
        double kilogramValue = 9.40;
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createUrlWithPort("/weight/test-system/" + kilogramValue),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.BAD_REQUEST.value(), responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    private String createUrlWithPort(final String uri) {
        return "http://localhost:" + port + "/convert" + uri;
    }
}
