public class Calculator {
    private Integer firstOperand;
    private Integer secondOperand;
    private Integer result = 0;

    public Calculator(Integer firstOperand, Integer secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public ResponseType process(String operation) {
        ResponseType responseType;

        if (OperationType.ADDITION.getValue().equals(operation)) {
            result = firstOperand + secondOperand;

            responseType = ResponseType.SUCCESS;
        }
        else if (OperationType.SUBSTRACTION.getValue().equals(operation)){
            result = firstOperand - secondOperand;

            responseType = ResponseType.SUCCESS;
        }
        else if (OperationType.MULTIPLICATION.getValue().equals(operation)){
            result = firstOperand * secondOperand;

            responseType = ResponseType.SUCCESS;
        }
        else if (OperationType.DIVISION.getValue().equals(operation)){
            if (secondOperand != 0){
                result = Math.round(firstOperand / secondOperand);

                responseType = ResponseType.SUCCESS;
            }
            else {
                responseType = ResponseType.SECOND_OPERAND_CANT_BE_ZERO;
            }
        }
        else {
            responseType = ResponseType.UNKNOWN_OPERATION;
        }

        return responseType;
    }

    public Integer getResult() {
        return result;
    }
}