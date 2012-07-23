package com.demo.restez.filter;

import com.demo.restez.proxies.RestaurantProxy;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

public interface FilterWidget extends Editor<RestaurantProxy>, IsWidget
{
	public interface Presenter
	{
		void start(EventBus eventBus);

		void filterChanged();

		void resetFilter();
	}
	
	void setPresenter(Presenter presenter);
	
	RequestFactoryEditorDriver<RestaurantProxy, ?> getEditorDriver();
}
