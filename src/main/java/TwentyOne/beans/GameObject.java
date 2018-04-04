package TwentyOne.beans;

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

}
