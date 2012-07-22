package com.demo.restez.widgets.avgprice;

import com.demo.restez.enums.PriceCategory;
import com.github.gwtbootstrap.client.ui.Button;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public class DefaultAveragePriceSelector extends Composite implements HasValue<PriceCategory>
{

	private static DefaultAveragePriceSelectorUiBinder uiBinder = GWT.create(DefaultAveragePriceSelectorUiBinder.class);

	interface DefaultAveragePriceSelectorUiBinder extends UiBinder<Widget, DefaultAveragePriceSelector>
	{
	}
	
	@UiField
	Button lowBtn;
	
	@UiField
	Button medBtn;
	
	@UiField
	Button highBtn;
	
	PriceCategory priceCategory;

	public DefaultAveragePriceSelector()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
    public PriceCategory getValue()
    {
	    return priceCategory;
    }

	@Override
    public void setValue(PriceCategory value)
    {
		setValue(value);
    }

	@Override
    public void setValue(PriceCategory value, boolean fireEvents)
    {
		if (value == null)
			value = PriceCategory.Low;
		
		onBtnClick(value);
		this.priceCategory = value;
    }

	@Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<PriceCategory> handler)
    {
		return addHandler(handler, ValueChangeEvent.getType());
    }
	
	@UiHandler({"lowBtn", "medBtn", "highBtn"})
	public void onClick(ClickEvent event)
	{
		Button btn = (Button)event.getSource();
		if (btn.equals(lowBtn))
			onBtnClick(PriceCategory.Low);
		else if (btn.equals(medBtn))
			onBtnClick(PriceCategory.Medium);
		else
			onBtnClick(PriceCategory.High);
	}
	
	private void onBtnClick(PriceCategory value)
	{
		if (value.equals(PriceCategory.Low))
		{
			lowBtn.getElement().addClassName("active");
			medBtn.getElement().removeClassName("active");
			highBtn.getElement().removeClassName("active");
		}
		else if (value.equals(PriceCategory.Medium))
		{
			lowBtn.getElement().removeClassName("active");
			medBtn.getElement().addClassName("active");
			highBtn.getElement().removeClassName("active");
		}
		else
		{
			lowBtn.getElement().removeClassName("active");
			medBtn.getElement().removeClassName("active");
			highBtn.getElement().addClassName("active");
		}	
	}

}
