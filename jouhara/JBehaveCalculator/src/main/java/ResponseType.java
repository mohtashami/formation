public enum ResponseType {
    SUCCESS("SUCCESS"),
    SECOND_OPERAND_CANT_BE_ZERO("SECOND_OPERAND_CANT_BE_ZERO"),
    UNKNOWN_OPERATION("UNKNOWN_OPERATION");

    private String value;

    ResponseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}