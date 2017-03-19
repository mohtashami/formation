public enum AccountOperationResultType {
    SUCCESS("SUCCESS"),
    NOT_ENOUGH_CREDIT("NOT_ENOUGH_CREDIT"),
    AMOUNT_TOO_HIGH("AMOUNT_TOO_HIGH"),
    TARGET_ACCOUNT_DISABLED("TARGET_ACCOUNT_DISABLED"),
    UNKNOWN("UNKNOWN");

    private String value;

    AccountOperationResultType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}