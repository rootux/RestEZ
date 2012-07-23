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
		if (filter == null)
		{
			return restaurants;
		}
		
		return filterRestaurants(filter);
	}



	private List<Restaurant> filterRestaurants(Restaurant filter)
    {
	    List<Restaurant> filtered = new ArrayList<Restaurant>();

		for (Restaurant restaurant : restaurants)
		{
			boolean adRestaurant = false;
			if (restaurant.getAddress().toLowerCase().contains(filter.getAddress().toLowerCase()))
			{
				adRestaurant = true;
			}
			if (restaurant.getAvgPrice() == filter.getAvgPrice())
			{
				adRestaurant = true;
			}
			if (restaurant.getDesc().toLowerCase().contains(filter.getDesc().toLowerCase()))
			{
				adRestaurant = true;
			}
			if (restaurant.getName().toLowerCase().contains(filter.getName().toLowerCase()))
			{
				adRestaurant = true;
			}
			if (restaurant.getRating() == filter.getRating())
			{
				adRestaurant = true;
	        }
			if (restaurant.getServiceQuality().equals(filter.getServiceQuality()))
			{
				adRestaurant = true;
	        }
			
			if (adRestaurant)
			{
				filtered.add(restaurant);
			}
		}

		return filtered;
    }
}
