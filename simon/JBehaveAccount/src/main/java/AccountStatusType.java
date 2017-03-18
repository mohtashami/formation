public enum AccountStatusType {
    GOLD("GOLD"),
    ACTIVE("ACTIVE"),
    LOCKED("LOCKED"),
    INACTIVE("INACTIVE");

    private String value;

    AccountStatusType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}