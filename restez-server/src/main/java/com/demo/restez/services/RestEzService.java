package com.demo.restez.services;

import java.util.ArrayList;
import java.util.List;

import uk.co.jemos.podam.api.PodamFactoryImpl;

import com.demo.restez.enums.PriceCategory;
import com.demo.restez.enums.ServiceQuality;
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
		
		restaurants.add(new Restaurant("Avazi", "too much food", "aba even 1", true, false, PriceCategory.Low, ServiceQuality.Good, 3, true));
		restaurants.add(new Restaurant("BBB", "amburgeramburgeramburgeramburgeramburgeramburgeramburgeramburgeramburgeramburgeramburgeramburgeramburgeramburgeramburgeramburger", "mul moses", true, false, PriceCategory.High, ServiceQuality.Good, 2, true));
		restaurants.add(new Restaurant("Gute", "Anti Antibaiotics", "mul yarden", true, false, PriceCategory.Medium, ServiceQuality.Good, 3, true));
		restaurants.add(new Restaurant("שניצל קומפני", "shnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzel", "mul yarden", true, false, PriceCategory.Medium, ServiceQuality.Good, 3, true));
		restaurants.add(new Restaurant("חומוס צנעני", "all day all night eating humus its not good, i love humus but it makes me feel bad. i love humus", "mul the dat guy 3", true, false, PriceCategory.Low, ServiceQuality.Good, 1, true));
		
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
			if (filter.getAddress() != null)
			{
				if (restaurant.getAddress().toLowerCase().contains(filter.getAddress().toLowerCase()))
				{
					adRestaurant = true;
				}
			}
			if (filter.getAvgPrice() != null)
			{
				if (restaurant.getAvgPrice() == filter.getAvgPrice())
				{
					adRestaurant = true;
				}
			}
			if (filter.getDesc() != null)
				if (restaurant.getDesc().toLowerCase().contains(filter.getDesc().toLowerCase()))
				{
					adRestaurant = true;
				}
			if (filter.getName() != null)
			{
				if (restaurant.getName().toLowerCase().contains(filter.getName().toLowerCase()))
				{
					adRestaurant = true;
				}
			}
			if (filter.getRating() != null)
			{
				if (restaurant.getRating() == filter.getRating())
				{
					adRestaurant = true;
				}
			}
			if (filter.getServiceQuality() != null)
			{
				if (restaurant.getServiceQuality().equals(filter.getServiceQuality()))
				{
					adRestaurant = true;
				}
			}

			if (adRestaurant)
			{
				filtered.add(restaurant);
			}
		}

		return filtered;
	}
}
