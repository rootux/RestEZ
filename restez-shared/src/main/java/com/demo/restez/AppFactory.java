package com.demo.restez;

import com.demo.restez.servicesProxy.RestEzServiceProxy;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface AppFactory extends RequestFactory {
	RestEzServiceProxy getRestEzService();
}