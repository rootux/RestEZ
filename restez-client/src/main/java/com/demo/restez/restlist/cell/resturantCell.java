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
		void render(SafeHtmlBuilder sb, String name, String desc, String address, String price, String isFancy,
		        String isKosher, String rating, String serviceQuality, String takeAway, String index);
	}

	private static MyUiRenderer renderer = GWT.create(MyUiRenderer.class);



	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context, RestaurantProxy value, SafeHtmlBuilder sb)
	{
		String rowIndex = String.valueOf(context.getIndex() + 1);
		String ResturantName = value.getName();
		String Description = value.getDesc();
		String Address = value.getAddress();

		renderer.render(sb, ResturantName, Description, Address, "", "", "", "", "", "", rowIndex);

	}

}
