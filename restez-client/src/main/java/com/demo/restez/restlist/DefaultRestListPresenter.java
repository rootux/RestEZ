package com.demo.restez.restlist;

import java.util.List;

import com.demo.restez.AppFactory;
import com.demo.restez.events.FilterChangedEvent;
import com.demo.restez.proxies.RestaurantProxy;
import com.demo.restez.servicesProxy.RestEzServiceProxy;
import com.demo.restez.utils.ContextProjector;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.view.client.ListDataProvider;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class DefaultRestListPresenter implements ResturantsList.Presenter
{

	private ResturantsList widget;

	private AppFactory restEzService;

	ListDataProvider<RestaurantProxy> resturants = new ListDataProvider<RestaurantProxy>();



	public DefaultRestListPresenter(ResturantsList restList, AppFactory restEzService)
	{
		this.widget = restList;
		this.restEzService = restEzService;
		resturants.addDataDisplay(widget.getDataDisplay());
	}



	public void start(EventBus eventBus)
	{

		refreshData(null);

		eventBus.addHandler(FilterChangedEvent.TYPE, new FilterChangedEvent.Handler()
		{

			@Override
			public void onFilterChanged(FilterChangedEvent event)
			{
				refreshData(event.getFilter());

			}
		});

	}



	private void refreshData(RestaurantProxy filterProxy)
	{
		RestEzServiceProxy context = restEzService.getRestEzService();
		filterProxy = ContextProjector.copyBeanByContext(context, filterProxy, RestaurantProxy.class);
		context.getRestaurants(filterProxy).fire(new Receiver<List<RestaurantProxy>>()
		{
			@Override
			public void onSuccess(List<RestaurantProxy> response)
			{
				resturants.setList(response);
			}
		});
	}
}
