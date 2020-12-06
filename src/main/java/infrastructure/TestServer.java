package infrastructure;

public class TestServer {
    public String getUrl() {
        String testEnvironment = ConfigurationManager.getInstance().getTestEnvironment();
        switch (testEnvironment) {
            case "production":
                return "https://liveuamap.com/";
            case "staging":
                return "https://liveuamap.com/";
            case "qa":
                return "https://liveuamap.com/";
            default:
                return "";
        }
    }
}
