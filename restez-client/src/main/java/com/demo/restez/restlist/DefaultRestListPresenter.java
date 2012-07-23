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
		restProxy.setIsFancy(false);
		restProxy.setIsKosher(true);
		restProxy.setRating(8);
		restProxy.setServiceQuality(ServiceQuality.Great);
		restProxy.setIsTakeAway(true);
		
		RestaurantProxy restProxy1 = restEzService.getRestEzService().create(RestaurantProxy.class);
		restProxy1.setName("McDonalds");
		restProxy1.setAddress("abu ibn 1");
		restProxy1.setAvgPrice(PriceCategory.Low);
		restProxy1.setDesc("best hamburget in the world.");
		restProxy1.setIsFancy(false);
		restProxy1.setIsKosher(false);
		restProxy1.setRating(10);
		restProxy1.setServiceQuality(ServiceQuality.Great);
		restProxy1.setIsTakeAway(true);

		ListDataProvider<RestaurantProxy> resturants = new ListDataProvider<RestaurantProxy>();
		resturants.getList().add(restProxy);
		resturants.getList().add(restProxy1);

		resturants.addDataDisplay(widget.getDataDisplay());

	}

}
