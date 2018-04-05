package TwentyOne.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import TwentyOne.beans.CardBean;
import TwentyOne.factories.CardFactory;

@RestController
public class RESTController {

/**
 * @return "Hello, world!"
 */
@RequestMapping("/helloWorld")
public String helloWorld() {
	return "Hello, world!";
}

@RequestMapping("/pickACard")
public CardBean pickACard() {
	return CardFactory.pickACard();
}

/**
 * Returns a list of cards. This is written to demonstrate calling and getting data from REST APIs - it is otherwise
 * obviously an overly complicated and poor way to complete the job.
 * 
 * @param the
 *            incoming request object
 * @param number
 *            the number of cards to return
 * @return a list of cards
 */
@RequestMapping("/pickCards/{number}")
public List<CardBean> pickCards(HttpServletRequest request, @PathVariable(value = "number") Integer number) {
	// number is required
	Objects.requireNonNull(number);

	// must be at least 1
	if (number < 1)
		return null;

	// the URL for the "pick a card" method; we take the port from the request, to avoid looking up or assuming what
	// port we are listening on
	String url = String.format("http://127.0.0.1:%d/TwentyOne/pickACard", request.getServerPort());

	// build the list of cards
	List<CardBean> cards = new ArrayList<>(number);
	for (int x = 0; x < number; x++) {

		// request each card for the "pick a card" method via a REST call
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		RestTemplate restTemplate = new RestTemplate();
		CardBean card = restTemplate.getForObject(builder.toUriString(), CardBean.class);

		cards.add(card);
	}

	// return the list
	return cards;
}

}
