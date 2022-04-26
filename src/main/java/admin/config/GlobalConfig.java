package admin.config;

public enum GlobalConfig {
    Paging("페이징 단위", 10);

    private final String configName;
    private final int value;

    GlobalConfig(String configName, int value) {
        this.configName = configName;
        this.value = value;
    }

    public String getConfigName() {
        return configName;
    }

    public int getValue() {
        return value;
    }
}
