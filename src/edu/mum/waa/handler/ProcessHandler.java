package edu.mum.waa.handler;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;

public abstract interface ProcessHandler {
	public abstract void process(BBHttpRequest httpRequest, BBHttpResponse httpResponse);
}
