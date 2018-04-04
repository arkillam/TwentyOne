package TwentyOne.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import TwentyOne.beans.GameObject;
import TwentyOne.beans.SimpleMessageBean;

@Controller
public class GameController {

/**
 * Shows the player a form to start playing the game.
 * 
 * @param response
 *            the response object
 * 
 * @return a model and view object
 * 
 * @throws IOException
 */
@RequestMapping(value = "/Game/Start")
public ModelAndView getstarted(HttpServletResponse response) throws IOException {
	ModelAndView rc = new ModelAndView("GameStart");

	GameObject go = new GameObject();
	go.setTitle("Let's Play Twenty One");

	rc.getModel().put("go", go);

	return rc;
}

/**
 * @param go
 *            the game object, contains the current state of the game
 * @param result
 *            the result of the binding attempt
 * @param model
 *            the model
 * @return the name of the view to use
 * @throws IOException
 */
@RequestMapping(value = "/Game")
public String play(@ModelAttribute("GameObject") GameObject go, BindingResult result, ModelMap model)
		throws IOException {

	if (go != null)
		System.out.println(go.toString());

	if (result.hasErrors()) {
		SimpleMessageBean smb = new SimpleMessageBean();
		smb.setTitle("Twenty One");
		smb.setMessage("Something went wrong.  :(");
		for (ObjectError oe : result.getAllErrors()) {
			smb.addErrorMessage(oe.getDefaultMessage());
		}
		model.put("smb", smb);
		return "TitleAndMessage";
	}

	// if the player's name is not set, we have not started the game, so send them the game start page
	if ((go == null) || (go.getName() == null) || (go.getName().trim().length() < 1)) {
		go.setTitle("Twenty One");
		model.put("go", go);
		return "GameStart";
	}

	// if the player ran out of money, send them the game start page
	go.setMoney(0);
	if ((go != null) && (go.getMoney() < 1)) {
		go.setTitle("Twenty One");
		// using an error instead of a normal message just to get the red formatting ...
		go.addErrorMessage("You busted!");
		model.put("go", go);
		return "GameStart";
	}

	return "GamePlay";
}

}
