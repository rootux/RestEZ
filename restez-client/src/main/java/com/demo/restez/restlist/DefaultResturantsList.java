package com.demo.restez.restlist;

import com.demo.restez.proxies.RestaurantProxy;
import com.demo.restez.restlist.cell.resturantCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasData;

public class DefaultResturantsList extends Composite implements ResturantsList
{

	private static DefaultResturantsListUiBinder uiBinder = GWT.create(DefaultResturantsListUiBinder.class);

	interface DefaultResturantsListUiBinder extends UiBinder<Widget, DefaultResturantsList>
	{

	}

	@UiField(provided = true)
	CellList<RestaurantProxy> resturantList;



	public DefaultResturantsList()
	{

		resturantCell restaurantCell = new resturantCell();
		resturantList = new CellList<RestaurantProxy>(restaurantCell);
		resturantList.setPageSize(30);
		resturantList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);

		initWidget(uiBinder.createAndBindUi(this));

	}



	@Override
	public void setPresenter(Presenter presenter)
	{

	}



	@Override
	public HasData<RestaurantProxy> getDataDisplay()
	{
		// TODO Auto-generated method stub
		return resturantList;
	}

}
