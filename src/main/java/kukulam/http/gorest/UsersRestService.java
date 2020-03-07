package kukulam.http.gorest;

import kukulam.http.HTTPResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class UsersRestService {

    private static String OAUTH_TOKEN = "TOKEN VALUE";

    HTTPResponse findUsers() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gorest.co.in/public-api/users";
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse createUser() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gorest.co.in/public-api/users";
        String bodyJson = "{\n" +
        "    \"first_name\": \"Mikel\",\n" +
        "    \"last_name\": \"Example last name mm\",\n" +
        "    \"gender\": \"male\",\n" +
        "    \"email\": \"lew1911@roberts.com\",\n" +
        "    \"status\": \"active\"\n" +
        "}";
        HttpEntity<String> httpEntity = new HttpEntity<>(bodyJson, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse findUser() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gorest.co.in/public-api/users/4121";
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse updateUser() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gorest.co.in/public-api/users/4121";
        String bodyJson = "{\n" +
        "    \"first_name\": \"Mikel\",\n" +
                "    \"last_name\": \"Example last name meeeh\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"lew19asd@roberts.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        HttpEntity<String> httpEntity = new HttpEntity<>(bodyJson, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse deleteUser() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://gorest.co.in/public-api/users/4121";
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    private MultiValueMap<String, String> headers() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("Accept", Collections.singletonList("application/json; charset=UTF-8"));
        headers.put("Content-Type", Collections.singletonList("application/json"));
        headers.put("Authorization", Collections.singletonList("Bearer " + OAUTH_TOKEN));
        return headers;
    }

    public static void main(String[] args) {
        UsersRestService service = new UsersRestService();

        HTTPResponse allUsers = service.findUsers();
        System.out.println(allUsers);

        HTTPResponse createUser = service.createUser();
        System.out.println(createUser);

        HTTPResponse user = service.findUser();
        System.out.println(user);

        HTTPResponse updateUser = service.updateUser();
        System.out.println(updateUser);

        HTTPResponse deleteUser = service.deleteUser();
        System.out.println(deleteUser);
    }
}
