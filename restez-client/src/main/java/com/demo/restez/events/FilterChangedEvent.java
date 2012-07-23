package com.demo.restez.events;

import com.demo.restez.proxies.RestaurantProxy;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class FilterChangedEvent extends GwtEvent<FilterChangedEvent.Handler>
{
	public interface Handler extends EventHandler
	{
		void onFilterChanged(FilterChangedEvent event);
	}
	
	RestaurantProxy filter;
	public static final Type<FilterChangedEvent.Handler> TYPE =
	        new Type<FilterChangedEvent.Handler>();
	
	
	
	public FilterChangedEvent(RestaurantProxy filter)
	{
		this.filter = filter;
	}

	public RestaurantProxy getFilter()
    {
    	return filter;
    }

	@Override
	public final Type<FilterChangedEvent.Handler> getAssociatedType()
	{
		return TYPE;
	}

	@Override
	protected void dispatch(FilterChangedEvent.Handler handler)
	{
		handler.onFilterChanged(this);
	}
}
