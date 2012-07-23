package com.demo.restez.filter;

import com.demo.restez.AppFactory;
import com.demo.restez.events.FilterChangedEvent;
import com.demo.restez.proxies.RestaurantProxy;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class FilterWidgetPresenter implements FilterWidget.Presenter
{
	private EventBus eventBus;
	private RestaurantProxy filter;
	private FilterWidget widget;
	private AppFactory restEzService;
	private RequestContext currentContext;
	
	public FilterWidgetPresenter(FilterWidget widget, AppFactory restEzService)
	{
		this.widget = widget;
		this.restEzService = restEzService;		
	}
	
	@Override
    public void start(EventBus eventBus)
    {
		this.eventBus = eventBus;
		widget.setPresenter(this);
		
		currentContext = restEzService.getRestEzService();
		filter = currentContext.create(RestaurantProxy.class);
		widget.getEditorDriver().edit(filter, currentContext);
    }

	@Override
    public void filterChanged()
    {
		widget.getEditorDriver().flush();
	    eventBus.fireEvent(new FilterChangedEvent(filter));
    }

	@Override
    public void resetFilter()
    {
		eventBus.fireEvent(new FilterChangedEvent(null));
    }
	
}
