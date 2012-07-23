package com.demo.restez.restlist.cell;

import com.demo.restez.proxies.RestaurantProxy;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiRenderer;

public class resturantCell extends AbstractCell<RestaurantProxy>
{
	interface MyUiRenderer extends UiRenderer
	{
		void render(SafeHtmlBuilder sb, String name, String desc, String address, String price, String fancy,
		        String kosher, String rating, String service, String takeAway, String index);

	}

	private static MyUiRenderer renderer = GWT.create(MyUiRenderer.class);



	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context, RestaurantProxy value, SafeHtmlBuilder sb)
	{
		String rowIndex = String.valueOf(context.getIndex() + 1);
		String ResturantName = value.getName();
		String Description = value.getDesc();
		String Address = value.getAddress();

		String Kosher = value.isKosher() ? "Kosher" : "Goy";
		String fancy = value.isFancy() ? "Fancy Place" : "Simple Place";
		String takeAway = value.isTakeAway() ? "Take Away" : "NO Take Away";
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
