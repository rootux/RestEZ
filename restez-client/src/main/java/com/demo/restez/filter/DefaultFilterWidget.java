package com.demo.restez.filter;

import com.demo.restez.avgprice.DefaultAveragePriceSelector;
import com.demo.restez.enums.PriceCategory;
import com.demo.restez.proxies.RestaurantProxy;
import com.demo.restez.rating.DefaultRatingSelector;
import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;

public class DefaultFilterWidget extends Composite implements FilterWidget
{
	private static DefaultFilterWidgetUiBinder uiBinder = GWT.create(DefaultFilterWidgetUiBinder.class);

	interface DefaultFilterWidgetUiBinder extends UiBinder<Widget, DefaultFilterWidget>
	{
	}
	
	@Path("name")
	@UiField
	TextBox nameTextBox;
	
	@Path("desc")
	@UiField
	TextBox descTextBox;
	
	@Path("address")
	@UiField
	TextBox addrTextBox;
	
	@Path("isKosher")
	@UiField
	CheckBox kosherCb;
	
	@Path("isFancy")
	@UiField
	CheckBox fancyCb;
	
	@Path("isTakeAway")
	@UiField
	CheckBox takeAwayCb;
	
	@Path("avgPrice")
	@UiField
	DefaultAveragePriceSelector avgSelector;
	
	@Path("rating")
	@UiField
	DefaultRatingSelector ratingSelector;
	
	@Ignore
	@UiField
	Button resetFilter;
	
	Presenter presenter;
	
	interface Driver extends RequestFactoryEditorDriver<RestaurantProxy, DefaultFilterWidget>{}
	
	private final Driver driver = GWT.create(Driver.class);
	

	public DefaultFilterWidget()
	{
		initWidget(uiBinder.createAndBindUi(this));
		driver.initialize(this);
	}
	
	@UiHandler({"nameTextBox", "descTextBox", "addrTextBox"})
	public void onKeyUp(KeyUpEvent event)
	{
		fireChangeEvent();
	}
	
	@UiHandler({"kosherCb", "fancyCb", "takeAwayCb"})
    public void onValueChange(ValueChangeEvent<Boolean> event)
    {
		fireChangeEvent();
    }
	
	@UiHandler("avgSelector")
    public void onPriceValueChange(ValueChangeEvent<PriceCategory> event)
    {
		fireChangeEvent();
    }
	
	@UiHandler("ratingSelector")
    public void onRatingValueChange(ValueChangeEvent<Integer> event)
    {
		fireChangeEvent();
    }
	
	@UiHandler("resetFilter")
	public void onClick(ClickEvent event)
	{
		clearEditor();
		presenter.resetFilter();
	}	

	public void fireChangeEvent()
    {
    	presenter.filterChanged();
    }

	@Override
    public void setPresenter(Presenter presenter)
    {
		this.presenter = presenter;
    }

	@Override
    public RequestFactoryEditorDriver<RestaurantProxy, ?> getEditorDriver()
    {
	    return driver;
    }
	
    private void clearEditor()
    {
		nameTextBox.setValue(null);
		descTextBox.setValue(null);
		addrTextBox.setValue(null);
		kosherCb.setValue(false);
		fancyCb.setValue(false);
		takeAwayCb.setValue(false);
		avgSelector.setValue(null);
		ratingSelector.setValue(null);	    
    }

}
