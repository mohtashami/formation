import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerManager {
    private Player result;
    ResponseType responseType;

    // Patterns
    private Pattern patternEmail;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private Pattern patternName;
    private static final String NAME_PATTERN = "^([a-zA-Z -]*)$";

    private Pattern patternGender;
    private static final String GENDER_PATTERN = "^[M|F]{1}$";

    public PlayerManager() {
        patternEmail = Pattern.compile(EMAIL_PATTERN);
        patternName = Pattern.compile(NAME_PATTERN);
        patternGender = Pattern.compile(GENDER_PATTERN);
    }

    public ResponseType savePlayer(String email, Map<String, Player> playerList) {
        if (validateEmail(email)) {
            if ( (playerList != null) && (playerList.size() > 0) ){
                result = findByEmail(email, playerList);

                if (result != null) {
                    if (validatePlayer(result)){
                        responseType = ResponseType.SUCCESS;
                    }
                }
                else {
                    responseType = ResponseType.PLAYER_NOT_FOUND;
                }
            }
            else {
                responseType = ResponseType.PLAYER_NOT_FOUND;
            }
        }

        return responseType;
    }

    public ResponseType deleteByEmail(String email, Map<String, Player> playerList) {
        Player player = findByEmail(email, playerList);

        if (player != null){
            playerList.remove(email);
        }
        else {
            responseType = ResponseType.PLAYER_NOT_FOUND;
        }

        return responseType;
    }

    public Player findByEmail(String email, Map<String, Player> playerList) {
        return playerList.get(email);
    }

    private Boolean validatePlayer(Player player) {
        Boolean isValid = true;

        // Validate all fields
        if (!validate(player.getFirstName(), patternName, "Player first name is invalid", ResponseType.FIRST_NAME_MAL_FORMATTED, ResponseType.FIRST_NAME_REQUIRED)){
            isValid = false;
        }
        else if (!validate(player.getLastName(), patternName, "Player last name is invalid", ResponseType.LAST_NAME_MAL_FORMATTED, ResponseType.LAST_NAME_REQUIRED)){
            isValid = false;
        }
        else if (!validate(player.getGender(), patternGender, "Player genderis invalid", ResponseType.GENDER_MAL_FORMATTED, ResponseType.GENDER_REQUIRED)){
            isValid = false;
        }
        else if (!validate(player.getEmail(), patternEmail, "Player email is invalid", ResponseType.EMAIL_MAL_FORMATTED, ResponseType.EMAIL_REQUIRED)){
            isValid = false;
        }

        return isValid;
    }

    private Boolean validateEmail(String email) {
        return validate(email, patternEmail, "Email is invalid", ResponseType.EMAIL_MAL_FORMATTED, ResponseType.EMAIL_REQUIRED);
    }

    public Player getResult() {
        return result;
    }

    public Boolean validate(String value, Pattern pattern, String errorMsg, ResponseType responseTypeMalFormatted, ResponseType responseTypeRequired) {
        Boolean result = false;

        if (StringUtils.isNotBlank(value)){
            String valueCopy = value.replaceAll("\\s", "");

            Matcher matcher = pattern.matcher(valueCopy);

            result = matcher.matches();

            if (!result){
                responseType = responseTypeMalFormatted;
            }
        }
        else {
            responseType = responseTypeRequired;
        }

        errorMsgManagement(value, errorMsg, result);

        return result;
    }

    private void errorMsgManagement(String value, String errorMsg, Boolean result) {
        if (!result){
            System.out.print("Error Message : " + errorMsg);
            System.out.print("Current Value : " + value);
        }
    }
}