package com.demo.restez.services;

import java.util.ArrayList;
import java.util.List;

import uk.co.jemos.podam.api.PodamFactoryImpl;

import com.demo.restez.model.Restaurant;
import com.google.inject.Inject;

public class RestEzService
{
	PodamFactoryImpl podamFactory;
	
	List<Restaurant> restaurants;
	
	@Inject
	public RestEzService(PodamFactoryImpl podamFactory)
    {
	    super();
	    this.podamFactory = podamFactory;
	    
	    generateRests();
    }



	private void generateRests()
    {
		restaurants = new ArrayList<Restaurant>();
		for (int i = 0; i < 30; i++ )
        {
			restaurants.add(podamFactory.manufacturePojo(Restaurant.class));
        }
    }



	public List<Restaurant> getRestaurants(Restaurant filter)
	{
		return restaurants;
	}
}
