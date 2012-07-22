package com.demo.restez.restlist;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class DefaultResturantsList extends Composite implements ResturantsList
{

	private static DefaultResturantsListUiBinder uiBinder = GWT.create(DefaultResturantsListUiBinder.class);

	interface DefaultResturantsListUiBinder extends UiBinder<Widget, DefaultResturantsList>
	{

	}

	@UiField(provided = true)
	CellList<String> resturantList;



	public DefaultResturantsList()
	{

		  ListDataProvider<String> resturants = new ListDataProvider<String>();
		  
		  

		resturants.getList().add("avazi");
		resturants.getList().add("gute");
		resturants.getList().add("McDonalds");
		resturants.getList().add("the fat");
		resturants.getList().add("Meat Bar");
		
		Cell<String> cell = new TextCell();
		resturantList = new CellList<String>(cell);
		resturantList.setPageSize(30);
		resturantList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.BOUND_TO_SELECTION);
		
		

		initWidget(uiBinder.createAndBindUi(this));
		
		resturants.addDataDisplay(resturantList);
	}



	@Override
	public void setPresenter(Presenter presenter)
	{

	}

}
