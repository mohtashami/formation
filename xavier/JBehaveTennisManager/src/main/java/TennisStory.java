import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class TennisStory extends Embedder {
    private PlayerManager playerManager = new PlayerManager();
    private Map<String, Player> playerList = new HashMap<String, Player>();
    private Map<String, Player> playerSaved = new HashMap<String, Player>();
    private Player resultPlayer;
    private ResponseType responseType;

    @Given("a player with following information : firstName ($firstName), lastName ($lastName), gender ($gender), email ($email)")
    public void fillPlayer(String firstName, String lastName, String gender, String email) {
        playerList = new HashMap<String, Player>();
        playerList.put((email != null)?(email):(""), new Player(firstName, lastName, gender, email));
    }

    @When("I save the player with email : $email")
    public void savePlayer(String email) {
        responseType = playerManager.savePlayer(email, playerList);

        if (responseType.equals(ResponseType.SUCCESS)){
            resultPlayer = playerManager.getResult();

            playerSaved.put(email, resultPlayer);
        }
    }

    @When("I delete the player with email : $email")
    public void deletePlayer(String email) {
        responseType = playerManager.deleteByEmail(email, playerSaved);
    }

    @Then("I should be able to find a player with email : $email")
    public void findPlayerExisting(String email) {
        Assert.assertNotNull(playerManager.findByEmail(email, playerSaved));
    }

    @Then("I should'nt be able to find a player with email : $email")
    public void findPlayerInexisting(String email) {
        Assert.assertNull(playerManager.findByEmail(email, playerSaved));
    }

    @Then("I should see a response $response")
    public void checkResponse(String response) {
//        System.out.print("\nResponse : " + response + "\n");

        Assert.assertEquals(responseType.getValue(), response.replace("\n", "").replace("\r", ""));
    }
}