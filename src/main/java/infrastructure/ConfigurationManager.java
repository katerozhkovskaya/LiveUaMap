package infrastructure;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getEnvironmentVariableOrDefault(String envVar, String defaultValue) {
        String currentVarValue = System.getenv(envVar);
        return currentVarValue == null || currentVarValue.isEmpty() ?
                defaultValue : currentVarValue;
    }

    public BrowserType getTestBrowser() {
        return BrowserType.valueOf(getEnvironmentVariableOrDefault("browser", "chrome").toUpperCase());
    }
    public PlatformType getTestPlatform() {
        return PlatformType.valueOf(getEnvironmentVariableOrDefault("platform", "desctop").toUpperCase());
    }

    public String getTestEnvironment() {
        return getEnvironmentVariableOrDefault("environment", "qa");
    }

    public String getCurrentEnvironment() {
        return getEnvironmentVariableOrDefault("runEnv", "local");
    }

    public RunEnv getRunOn() {
        return RunEnv.valueOf(getEnvironmentVariableOrDefault("runOn", "local").toUpperCase());
    }

public String getRemouteHubUrl(){
    return getEnvironmentVariableOrDefault("hubUrl", "http://hubUrl.test");
}
}
