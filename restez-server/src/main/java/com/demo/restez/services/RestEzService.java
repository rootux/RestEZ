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
		
		restaurants.add(new Restaurant("Avazi", "too much food", "aba even 1", true, false, PriceCategory.Low, ServiceQuality.Great, 3, true));
		restaurants.add(new Restaurant("BBB", "The worst burger to go", "mul moses", true, false, PriceCategory.Low, ServiceQuality.Bad, 2, true));
		restaurants.add(new Restaurant("Gute", "Anti Antibaiotics", "mul yarden", true, false, PriceCategory.Medium, ServiceQuality.Bad, 3, true));
		restaurants.add(new Restaurant("שניצל קומפני", "shnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzelshnitzel", "mul yarden", true, false, PriceCategory.Medium, ServiceQuality.Good, 3, true));
		restaurants.add(new Restaurant("חומוס צנעני", "all day all night eating humus its not good, i love humus but it makes me feel bad. i love humus", "mul the dat guy 3", true, false, PriceCategory.Low, ServiceQuality.Good, 1, true));
		
		restaurants.add(new Restaurant("Kyoto", "Best sushi in Herzelya, but Moon is much better!!", "Mul Giraffe", false, true, PriceCategory.High, ServiceQuality.Great, 3, true));
		restaurants.add(new Restaurant("Zuzobra", "Like Giraffe but worst", "Near Kyoto", false, false, PriceCategory.Medium, ServiceQuality.Good, 2, true));
		restaurants.add(new Restaurant("Giraffe", "Like Zouzobra but better", "Near meat bar", false, true, PriceCategory.Medium, ServiceQuality.Good, 3, false));
		restaurants.add(new Restaurant("McDonalds", "Better burger joint in town", "Under Amobee", false, false, PriceCategory.Low, ServiceQuality.Great, 2, true));
		restaurants.add(new Restaurant("Moses", "Better burger joint in town after McDonalds", "Mul Zozubra", false, true, PriceCategory.Medium, ServiceQuality.Bad, 1, true));
		
		restaurants.add(new Restaurant("Sebastian", "Best Schnizel in town", "Behind Nir", false, true, PriceCategory.High, ServiceQuality.Great, 3, false));
		restaurants.add(new Restaurant("Olive", "The best place to go when you don't have where to go", "Look right from Omer's office", false, false, PriceCategory.Medium, ServiceQuality.Good, 1, true));
		restaurants.add(new Restaurant("The Fat Guy", "When you feel fat", "Near meat bar", false, false, PriceCategory.Medium, ServiceQuality.Great, 3, true));
		restaurants.add(new Restaurant("Meat Bar", "Udy's favorite!", "Ask Udy", false, true, PriceCategory.Medium, ServiceQuality.Good, 3, true));
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
			boolean adRestaurant = true;
			if (filter.getAddress() != null)
			{
				if (!(restaurant.getAddress().toLowerCase().contains(filter.getAddress().toLowerCase())))
				{
					continue;
				}
			}
			if (filter.getAvgPrice() != null)
			{
				if (!(restaurant.getAvgPrice() == filter.getAvgPrice()))
				{
					continue;
				}
			}
			if (filter.getDesc() != null)
				if (!(restaurant.getDesc().toLowerCase().contains(filter.getDesc().toLowerCase())))
				{
					continue;
				}
			if (filter.getName() != null)
			{
				if (!(restaurant.getName().toLowerCase().contains(filter.getName().toLowerCase())))
				{
					continue;
				}
			}
			if (filter.getRating() != null)
			{
				if (!(restaurant.getRating() == filter.getRating()))
				{
					continue;
				}
			}
			if (filter.getServiceQuality() != null)
			{
				if (!(restaurant.getServiceQuality().equals(filter.getServiceQuality())))
				{
					continue;
				}
			}
			if (filter.getIsFancy() == true)
			{
				if (!(restaurant.getIsFancy()))
				{
					continue;
				}
			}
			if (filter.getIsKosher() == true)
			{
				if (!(restaurant.getIsKosher()))
				{
					continue;
				}
			}
			if (filter.getIsTakeAway() == true)
			{
				if (!(restaurant.getIsTakeAway()))
				{
					continue;
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
