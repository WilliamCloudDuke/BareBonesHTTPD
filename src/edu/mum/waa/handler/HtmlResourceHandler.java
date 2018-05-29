package edu.mum.waa.handler;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;
import edu.mum.waa.annotation.WebResource;
import edu.mum.waa.htmlhandlers.HtmlHandler;
import edu.mum.waa.utils.AnnotationReader;

public class HtmlResourceHandler implements ProcessHandler {
	@Override
	public void process(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		try {
			Iterable<Class> classes = AnnotationReader.getInstance().readPackage("edu.mum.waa.htmlhandlers");
			boolean handlerFound = false;
			for (Class<?> clazz : classes) {
				WebResource annotation = clazz.getAnnotation(WebResource.class);
				if (annotation != null && annotation.path().equals(httpRequest.getUri())) {
					HtmlHandler handler= (HtmlHandler) clazz.newInstance();
					httpResponse.setStatusCode(200);
					handler.doGet(httpRequest, httpResponse);
					handlerFound = true;
					break;
				}
			}
			if (!handlerFound) {
				httpResponse.setMessage("404: Resource not found");
				httpResponse.setStatusCode(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
