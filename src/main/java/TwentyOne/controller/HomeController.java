package TwentyOne.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import TwentyOne.beans.SimpleMessageBean;

/**
 * This class simply delivers the homepage.
 */

@Controller
public class HomeController {

/**
 * Uses the "TitleAndMessage" JSP to send a page back to the requester containing a "hello world" message.
 * 
 * @param response
 *            the response object
 * 
 * @return a model and view object referencing the "TitleAndMessage" JSP and containing a "hello world" message
 * 
 * @throws IOException
 */
@RequestMapping(value = "/")
public ModelAndView test(HttpServletResponse response) throws IOException {
	ModelAndView rc = new ModelAndView("TitleAndMessage");

	SimpleMessageBean smb = new SimpleMessageBean();
	smb.setTitle("Hello World!");
	// smb.addErrorMessage("This is an error message.");
	// smb.addErrorMessage("This is also an error message.");
	smb.setMessage(
			"Hello World!  This is the homepage.  To play the game, <a href=\"/TwentyOne/Game\">click here</a>.");

	rc.getModel().put("smb", smb);

	return rc;
}

}
