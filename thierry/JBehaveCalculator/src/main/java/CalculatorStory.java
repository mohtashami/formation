import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.junit.Assert;

public class CalculatorStory extends Embedder {
    private Calculator calculator;
    private Integer result;
    private ResponseType responseType;

    @Given("two values $firstOperand and $secondOperand")
    public void fillOperands(Integer firstOperand, Integer secondOperand) {
        calculator = new Calculator(firstOperand, secondOperand);
    }

    @When("I make the operation $operation")
    public void processOperation(String operation) {
        responseType = calculator.process(operation);

        result = calculator.getResult();
    }

    @Then("the result must be $value")
    public void checkResult(Integer value) {
        Assert.assertEquals(result, value);
    }

    @Then("I should see a response $response")
    public void checkResponse(String response) {
//        System.out.print("\nResponse : " + response + "\n");

        Assert.assertEquals(responseType.getValue(), response.replace("\n", "").replace("\r", ""));
    }
}