package edu.mum.waa.htmlhandlers;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;

public abstract interface HtmlHandler {
	void doGet(BBHttpRequest httpRequest, BBHttpResponse httpResponse);
}
