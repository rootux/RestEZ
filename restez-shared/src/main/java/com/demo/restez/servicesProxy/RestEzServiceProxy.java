package com.demo.restez.servicesProxy;

import java.util.List;

import com.demo.restez.proxies.RestaurantProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName(value="com.demo.restez.services.RestEzService", locator="com.demo.restez.GuiceServiceLocator")
public interface RestEzServiceProxy extends RequestContext
{
	Request<List<RestaurantProxy>>  getRestaurants(RestaurantProxy filter);
}
