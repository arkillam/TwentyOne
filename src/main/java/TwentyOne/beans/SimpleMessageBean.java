package TwentyOne.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to pass simple messages to be displayed in JSPs. Simple messages contain a title, error message(s) and/or a
 * normal message.
 */

public class SimpleMessageBean {

/** list of error message strings */
private List<String> errorMessages = null;

/** message to display */
private String message = null;

/** title to display */
private String title = "Default Title";

public void addErrorMessage(String s) {
	if (s == null)
		return;
	if (s.trim().length() < 1)
		return;
	if (errorMessages == null)
		errorMessages = new ArrayList<>();
	errorMessages.add(s);
}

public List<String> getErrorMessages() {
	return errorMessages;
}

public String getMessage() {
	return message;
}

public String getTitle() {
	return title;
}

public void setErrorMessages(List<String> errorMessages) {
	this.errorMessages = errorMessages;
}

public void setMessage(String message) {
	this.message = message;
}

public void setTitle(String title) {
	this.title = title;
}

}
