package kukulam.http;

public class HTTPResponse {
    private String body;
    private int status;

    public HTTPResponse(String body, int status) {
        this.body = body;
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CharactersResponse{" +
                "status='" + status + '\'' +
                ", body=" + body +
                '}';
    }
}
