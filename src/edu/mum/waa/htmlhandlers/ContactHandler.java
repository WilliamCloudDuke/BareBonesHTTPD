package edu.mum.waa.htmlhandlers;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;
import edu.mum.waa.annotation.WebResource;

@WebResource(path = "/contacts.web")
public class ContactHandler implements HtmlHandler {
	@Override
	public void doGet(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		StringBuilder response = new StringBuilder();
		response.append("<!DOCTYPE html>");
		response.append("<html>");
		response.append("<head>");
		response.append("<title>" + this.getClass().getName() + "</title>");
		response.append("</head>");
		response.append("<body>");
		response.append("<p>Contact information: waa@mum.edu</p>");
		response.append("</body>");
		response.append("</html>");

		httpResponse.setMessage(response.toString());
	}
}
