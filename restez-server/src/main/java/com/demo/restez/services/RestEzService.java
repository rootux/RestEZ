package com.demo.restez.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.demo.restez.enums.PriceCategory;
import com.demo.restez.enums.ServiceQuality;
import com.demo.restez.model.Restaurant;

public class RestEzService
{
	public List<Restaurant> getRestaurants(Restaurant filter)
	{
		if (filter == null)
			return Arrays.asList(new Restaurant("1", "1", "1", true, true, PriceCategory.High, ServiceQuality.Bad, 1, true));
		
		return Collections.emptyList();
	}
}
