package com.demo.restez.restlist;

import com.demo.restez.AppFactory;
import com.demo.restez.enums.PriceCategory;
import com.demo.restez.enums.ServiceQuality;
import com.demo.restez.proxies.RestaurantProxy;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.view.client.ListDataProvider;

public class DefaultRestListPresenter implements ResturantsList.Presenter
{

	private ResturantsList widget;

	private AppFactory restEzService;



	public DefaultRestListPresenter(ResturantsList restList, AppFactory restEzService)
	{
		this.widget = restList;
		this.restEzService = restEzService;
	}



	public void start(EventBus eventBus)
	{
		RestaurantProxy restProxy = restEzService.getRestEzService().create(RestaurantProxy.class);
		restProxy.setName("avazi");
		restProxy.setAddress("abu ibn 18");
		restProxy.setAvgPrice(PriceCategory.Low);
		restProxy.setDesc("best service in town, very low prices!");
		restProxy.setFancy(false);
		restProxy.setKosher(true);
		restProxy.setRating(8);
		restProxy.setServiceQuality(ServiceQuality.Great);
		restProxy.setTakeAway(true);
		
		RestaurantProxy restProxy1 = restEzService.getRestEzService().create(RestaurantProxy.class);
		restProxy1.setName("McDonalds");
		restProxy1.setAddress("abu ibn 1");
		restProxy1.setAvgPrice(PriceCategory.Low);
		restProxy1.setDesc("best hamburget in the world.");
		restProxy1.setFancy(false);
		restProxy1.setKosher(false);
		restProxy1.setRating(10);
		restProxy1.setServiceQuality(ServiceQuality.Great);
		restProxy1.setTakeAway(true);
		
		
		RestaurantProxy restProxy2 = restEzService.getRestEzService().create(RestaurantProxy.class);
		restProxy2.setName("MeatBar");
		restProxy2.setAddress("maskit 88");
		restProxy2.setAvgPrice(PriceCategory.Medium);
		restProxy2.setDesc("Many options and great taste.");
		restProxy2.setFancy(true);
		restProxy2.setKosher(true);
		restProxy2.setRating(7);
		restProxy2.setServiceQuality(ServiceQuality.Good);
		restProxy2.setTakeAway(false);

		ListDataProvider<RestaurantProxy> resturants = new ListDataProvider<RestaurantProxy>();
		resturants.getList().add(restProxy);
		resturants.getList().add(restProxy1);
		resturants.getList().add(restProxy2);
		resturants.addDataDisplay(widget.getDataDisplay());

	}

}
