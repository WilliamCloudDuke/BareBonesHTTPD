package edu.mum.waa.handler;

import edu.mum.waa.BBHttpRequest;
import edu.mum.waa.BBHttpResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StaticResourceHandler implements ProcessHandler {
	private static final String DOCUMENT_ROOT_FOLDER = "resources";
	@Override
	public void process(BBHttpRequest httpRequest, BBHttpResponse httpResponse) {
		StringBuilder stringBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(DOCUMENT_ROOT_FOLDER + httpRequest.getUri()))) {
			stream.forEach(stringBuilder::append);
			httpResponse.setMessage(stringBuilder.toString());
			httpResponse.setStatusCode(200);
		} catch (IOException e) {
			httpResponse.setMessage("404: Resource not found");
			httpResponse.setStatusCode(404);
		}
	}
}
