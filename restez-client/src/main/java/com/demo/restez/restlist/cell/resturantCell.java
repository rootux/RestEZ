package com.demo.restez.restlist.cell;

import com.demo.restez.proxies.RestaurantProxy;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiRenderer;

public class resturantCell extends AbstractCell<RestaurantProxy>
{
	interface MyUiRenderer extends UiRenderer
	{
		void render(SafeHtmlBuilder sb, String name, String desc, String address, String price, String fancy,
		        String kosher, String rating, String service, String takeAway, String index);



		void onBrowserEvent(resturantCell o, NativeEvent e, Element p, RestaurantProxy n);



		SpanElement getMoreLessDesc(Element p);



		SpanElement getRestDesc(Element p);

	}

	private static MyUiRenderer renderer = GWT.create(MyUiRenderer.class);

	@UiField
	SpanElement moreLessDesc;

	@UiField
	SpanElement restDesc;



	public resturantCell()
	{
		super("click");
	}



	@Override
	public void onBrowserEvent(Context context, Element parent, RestaurantProxy value, NativeEvent event,
	        ValueUpdater<RestaurantProxy> updater)
	{
		renderer.onBrowserEvent(this, event, parent, value);
	}



	@UiHandler("moreLessDesc")
	void onNameGotPressed(ClickEvent event, Element parent, RestaurantProxy resturant)
	{
		String text = renderer.getMoreLessDesc(parent).getInnerText();
		if (text.equals("more"))
		{
			renderer.getMoreLessDesc(parent).setInnerText("less");
			renderer.getRestDesc(parent).setInnerText(resturant.getDesc());
		}
		else
		{
			renderer.getMoreLessDesc(parent).setInnerText("more");
			renderer.getRestDesc(parent).setInnerText(resturant.getDesc().substring(0, 2) + "...");
		}

	}



	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context, RestaurantProxy value, SafeHtmlBuilder sb)
	{
		String rowIndex = String.valueOf(context.getIndex() + 1);
		String ResturantName = value.getName();
		String Description = value.getDesc().substring(0, 2) + "...";
		String Address = value.getAddress();

		String Kosher = value.getIsKosher() ? "Kosher" : "Goy";
		String fancy = value.getIsFancy() ? "Fancy Place" : "Simple Place";
		String takeAway = value.getIsTakeAway() ? "Take Away" : "NO Take Away";
		String price;
		switch (value.getAvgPrice())
		{
			case Low:
				price = "$";
				break;
			case Medium:
				price = "$$";
				break;
			case High:
				price = "$$$";
				break;

			default:
				price = "$?";
				break;
		}
		String serviceQuality;
		switch (value.getServiceQuality())
		{
			case Bad:
				serviceQuality = "BAD SERVICE!";
				break;
			case Good:
				serviceQuality = "Good Service";
				break;

			case Great:
				serviceQuality = "GREAT SERVICE";
				break;
			default:
				serviceQuality = "service N/A";
				break;
		}
		String rating = "";
		for (int i = 0; i < value.getRating(); i++ )
		{
			rating = rating + "*";
		}
		renderer.render(sb, ResturantName, Description, Address, price, fancy, Kosher, rating, serviceQuality,
		        takeAway, rowIndex);

	}
}
