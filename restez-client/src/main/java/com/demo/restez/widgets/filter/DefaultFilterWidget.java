package com.demo.restez.widgets.filter;

import com.demo.restez.widgets.avgprice.DefaultAveragePriceSelector;
import com.demo.restez.widgets.rating.DefaultRatingSelector;
import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DefaultFilterWidget extends Composite
{

	private static DefaultFilterWidgetUiBinder uiBinder = GWT.create(DefaultFilterWidgetUiBinder.class);

	interface DefaultFilterWidgetUiBinder extends UiBinder<Widget, DefaultFilterWidget>
	{
	}
	
	@UiField
	TextBox nameTextBox;
	
	@UiField
	TextBox descTextBox;
	
	@UiField
	TextBox addrTextBox;
	
	@UiField
	CheckBox kosherCb;
	
	@UiField
	CheckBox fancyCb;
	
	@UiField
	CheckBox takeAwayCb;
	
	@UiField
	DefaultAveragePriceSelector avgSelector;
	
	@UiField
	DefaultRatingSelector ratingSelector;
	

	public DefaultFilterWidget()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	

}
