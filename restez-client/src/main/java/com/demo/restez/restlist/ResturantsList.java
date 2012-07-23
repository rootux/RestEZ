package com.demo.restez.restlist;

import com.demo.restez.proxies.RestaurantProxy;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.HasData;

public interface ResturantsList extends IsWidget
{
	interface Presenter
	{
		
	}
	
	void setPresenter(Presenter presenter);

	HasData<RestaurantProxy> getDataDisplay();
}
