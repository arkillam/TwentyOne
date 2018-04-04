package TwentyOne.factories;

import java.util.Random;

import TwentyOne.beans.CardBean;

public class CardFactory {

public static Random random = new Random();

/**
 * Copied with thanks form 'https://www.mkyong.com/java/java-generate-random-integers-in-a-range/';
 * 
 * @param min
 *            smallest acceptable value
 * @param max
 *            highest acceptable value
 * @return a random value between min and max
 */
private static int getRandomNumberInRange(int min, int max) {

	if (min >= max) {
		throw new IllegalArgumentException("max must be greater than min");
	}

	return random.nextInt((max - min) + 1) + min;
}

/**
 * @return a randomly generated CardBean
 */
public static CardBean pickACard() {
	CardBean.Face face = CardBean.Face.values()[getRandomNumberInRange(0, CardBean.Face.values().length - 1)];
	CardBean.Suit suit = CardBean.Suit.values()[getRandomNumberInRange(0, CardBean.Suit.values().length - 1)];
	CardBean cardBean = new CardBean();
	cardBean.setFace(face);
	cardBean.setSuit(suit);
	return cardBean;
}

}
