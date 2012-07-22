package com.demo.restez.services;

import java.util.Collections;
import java.util.List;

import com.demo.restez.model.Restaurant;

public class RestEzService
{
	public List<Restaurant> getRestaurants(Restaurant filter)
	{
		if (filter == null)
			return Collections.emptyList();
		
		return Collections.emptyList();
	}
}
