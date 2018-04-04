package TwentyOne.beans;

/**
 * Represents a playing card.
 */

public class CardBean {

/** card faces */
public enum Face {
	ACE("Ace"),
	EIGHT("8"),
	FIVE("5"),
	FOUR("4"),
	JACK("Jack"),
	KING("King"),
	NINE("9"),
	ONE("1"),
	QUEEN("Queen"),
	SEVEN("7"),
	SIX("6"),
	TEN("10"),
	THREE("3"),
	TWO("2");

	private String name;

	private Face(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

/** card suits */
public enum Suit {
	CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");

	private String name;

	private Suit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

/** the card's face */
private Face face = null;

/** the card's suit */
private Suit suit = null;

public Face getFace() {
	return face;
}

public Suit getSuit() {
	return suit;
}

public void setFace(Face face) {
	this.face = face;
}

public void setSuit(Suit suit) {
	this.suit = suit;
}

}
