package TwentyOne.beans;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Used to pass the details of the game back and forth between the UI and the backend code. When passed to the UI,
 * values are preserved in the form used to play the game.
 */

public class GameObject extends SimpleMessageBean {

/** how many dollars the player has left */
private int money;

/** the player's name */
private String name;

public int getMoney() {
	return money;
}

public String getName() {
	return name;
}

public void setMoney(int money) {
	this.money = money;
}

public void setName(String name) {
	this.name = name;
}

/**
 * @return the object, in JSON format
 */
public String toString() {
	try {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this);
	} catch (JsonProcessingException e) {
		e.printStackTrace();
		return "(an error occured)";
	}
}

}
