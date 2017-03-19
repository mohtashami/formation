public enum OperationType {
    ADDITION("ADDITION"),
    SUBSTRACTION("SUBSTRACTION"),
    MULTIPLICATION("MULTIPLICATION"),
    DIVISION("DIVISION");

    private String value;

    OperationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}