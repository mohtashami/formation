import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.junit.Assert;

public class AccountStory extends Embedder {
    private Account accountA;
    private Account accountB;
    private AccountOperationResultType accountOperationResultType;

    @Given("an account with $amount euros")
    public void fillAcountA(int amount) {
        accountA = new Account(amount);
    }

    @Given("an account with $amount euros and status $status")
    public void fillAcountA(int amount, String status) {
        accountA = new Account(amount, status);
    }

    @Given("another with $amount euros")
    public void fillAcountB(int amount) {
        accountB = new Account(amount);
    }

    @Given("another with $amount euros with status $status")
    public void fillAcountBWhenDisabled(int amount, String status) {
        accountB = new Account(amount, status);
    }

    @When("I transfer $amount euros")
    public void transfertMoney(int amount) {
        accountOperationResultType = accountA.transfertTo(accountB,amount);
    }

    @Then("the first account should have $amount euros")
    public void checkAccountA(int amount) {
        Assert.assertEquals(amount, accountA.getAmount());
    }

    @Then("the second one $amount euros")
    public void checkAccountB(int amount) {
        Assert.assertEquals(amount,accountB.getAmount());
    }

    @Then("the second one status became $status")
    public void checkAccountBStatusChange(String status) {
        Assert.assertEquals(status, accountB.getStatus());
    }

    @Then("I should see as response $response")
    public void checkErrorRaised(String response) {
//        System.out.print("\nResponse : " + response + "\n");

        Assert.assertEquals(accountOperationResultType.getValue(), response.replace("\n", "").replace("\r", ""));
    }
}