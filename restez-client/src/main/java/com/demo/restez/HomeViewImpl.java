package com.demo.restez;

import com.demo.restez.filter.DefaultFilterWidget;
import com.demo.restez.filter.FilterWidget;
import com.demo.restez.restlist.DefaultResturantsList;
import com.demo.restez.restlist.ResturantsList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class HomeViewImpl implements HomeView
{




	public interface Binder extends UiBinder<Widget, HomeViewImpl>
	{
	}

	private static final Binder binder = GWT.create(Binder.class);

	private final Widget w = binder.createAndBindUi(this);

	private Presenter presenter;

	@UiField
	DefaultResturantsList restList;

	@UiField
	DefaultFilterWidget restFilter;

	@UiField
	ImageElement taykeylogo;


	public HomeViewImpl()
    {
	    super();
	    taykeylogo.setSrc("https://www.google.com/a/taykey.com/images/logo.gif?alpha=1&service=google_default");
    }

	@Override
	public void setEnabled(boolean enabled)
	{
	}



	@Override
	public void setError(String error)
	{
	}



	@Override
	public void setPresenter(Presenter presenter)
	{
		this.presenter = presenter;
	}



	@Override
	public Widget asWidget()
	{
		return w;
	}



	@Override
	public ResturantsList getRestList()
	{
		return restList;
	}



	@Override
	public FilterWidget getRestFilter()
	{
		return restFilter;
	}
}
