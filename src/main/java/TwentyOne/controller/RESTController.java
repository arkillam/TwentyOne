package TwentyOne.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
