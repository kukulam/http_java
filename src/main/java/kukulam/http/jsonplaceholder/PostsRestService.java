package kukulam.http.jsonplaceholder;

import kukulam.http.HTTPResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class PostsRestService {

    HTTPResponse allPosts() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse post1() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse createPost() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts";
        String bodyJson = "{\n" +
        "    \"userId\": 999,\n" +
        "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
        "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
        "}";
        HttpEntity<String> httpEntity = new HttpEntity<>(bodyJson, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse updatePost() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        String bodyJson = "{\n" +
        "    \"userId\": 1,\n" +
        "    \"id\": 1,\n" +
        "    \"title\": \"delectus aut autemmmmm\",\n" +
        "    \"completed\": false\n" +
        "}";
        HttpEntity<String> httpEntity = new HttpEntity<>(bodyJson, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.PUT, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse deletePost() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers());
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    private MultiValueMap<String, String> headers() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("Accept", Collections.singletonList("application/json"));
        headers.put("Content-Type", Collections.singletonList("application/json"));
        return headers;
    }

    public static void main(String[] args) {
        PostsRestService service = new PostsRestService();

        HTTPResponse allPosts = service.allPosts();
        System.out.println(allPosts);

        HTTPResponse post1 = service.post1();
        System.out.println(post1);

        HTTPResponse createPost = service.createPost();
        System.out.println(createPost);

        HTTPResponse updatePost = service.updatePost();
        System.out.println(updatePost);

        HTTPResponse deletePost = service.deletePost();
        System.out.println(deletePost);
    }
}
