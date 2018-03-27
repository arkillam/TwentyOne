package TwentyOne.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * For now, this class simply delivers the homepage, with a "hello world" message.
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
	rc.getModel().put("title", "Hello World!");
	rc.getModel().put("message", "This is the homepage.");
	return rc;
}

}
