package kukulam.http.anapioficeandfire;

import kukulam.http.HTTPResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class CharactersRestService {

    HTTPResponse allCharacters() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.anapioficeandfire.com/api/characters";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse only2Characters() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.anapioficeandfire.com/api/characters";
        String uriString = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("pageSize", 2)
                .build()
                .toUriString();
        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse only5CharactersFromPage2() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.anapioficeandfire.com/api/characters";
        String uriString = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("pageSize", 5)
                .queryParam("page", 2)
                .build()
                .toUriString();
        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse character1() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.anapioficeandfire.com/api/characters/1";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse characterAryaStark() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.anapioficeandfire.com/api/characters";
        String uriString = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("name", "Arya Stark")
                .build()
                .toUriString();
        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse femaleCharacters() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.anapioficeandfire.com/api/characters";
        String uriString = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("gender", "Female")
                .build()
                .toUriString();
        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    HTTPResponse aliveMenCharacters() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.anapioficeandfire.com/api/characters";
        String uriString = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("gender", "Male")
                .queryParam("isAlive", true)
                .build()
                .toUriString();
        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);
        return new HTTPResponse(response.getBody(), response.getStatusCode().value());
    }

    public static void main(String[] args) {
        CharactersRestService service = new CharactersRestService();

        HTTPResponse allCharacters = service.allCharacters();
        System.out.println(allCharacters);

        HTTPResponse only2Characters = service.only2Characters();
        System.out.println(only2Characters);

        HTTPResponse only5CharactersFromPage2 = service.only5CharactersFromPage2();
        System.out.println(only5CharactersFromPage2);

        HTTPResponse character1 = service.character1();
        System.out.println(character1);

        HTTPResponse aryaStark = service.characterAryaStark();
        System.out.println(aryaStark);

        HTTPResponse femaleCharacters = service.femaleCharacters();
        System.out.println(femaleCharacters);

        HTTPResponse aliveMenCharacters = service.aliveMenCharacters();
        System.out.println(aliveMenCharacters);
    }
}
