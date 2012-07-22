package com.demo.restez;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

/**
 * The client side stub for the RequestFactory service.
 */
@ServiceName(value="com.demo.restez.GreetingService", locator="com.demo.restez.GuiceServiceLocator")
public interface GreetingContext extends RequestContext {
	Request<GreetingResponseProxy> greetServer(String name);
}
