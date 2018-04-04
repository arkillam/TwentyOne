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

	if (result.hasErrors()) {
		go = new GameObject();
		go.setTitle("Twenty One");
		go.setMessage("Something went wrong.  :(");
		go.getErrorMessages().clear();
		for (ObjectError oe : result.getAllErrors()) {
			go.addErrorMessage(oe.getDefaultMessage());
		}
		model.put("go", go);
		return "GameStart";
	}

	model.put("go", go);

	return "GamePlay";
}

}
