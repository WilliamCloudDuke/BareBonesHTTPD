package edu.mum.waa.handler;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;

public class DefaultHandler implements ProcessHandler {
	@Override
	public void process(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		StringBuilder response = new StringBuilder();
		response.append("<!DOCTYPE html>");
		response.append("<html>");
		response.append("<head>");
		response.append("<title>Almost an HTTP Server</title>");
		response.append("</head>");
		response.append("<body>");
		response.append("<h1>This is the HTTP Server</h1>");
		response.append("<h2>Your request was:</h2>\r\n");
		response.append("<h3>Request Line:</h3>\r\n");
		response.append(httpRequest.getStartLine());
		response.append("<br />");
		response.append("<h3> Header Fields: </h3>");
		for (String headerField : httpRequest.getFields()) {
			response.append(headerField.replace("<", "&lt;").replace(">", "&gt;").replace("&", "&amp;"));
			response.append("<br />");
		}
		response.append("<h3> Payload: </h3>");
		for (String messageLine : httpRequest.getMessage()) {
			response.append(messageLine.replace("<", "&lt;").replace("&", "&amp;"));
			response.append("<br />");
		}
		response.append("</body>");
		response.append("</html>");

		httpResponse.setStatusCode(200);
		httpResponse.setMessage(response.toString());
	}
}
