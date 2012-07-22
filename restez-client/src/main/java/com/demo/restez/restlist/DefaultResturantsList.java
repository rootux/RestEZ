package com.demo.restez.restlist;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

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
		Cell<String> cell = new TextCell();
		resturantList = new CellList<String>(cell);
		initWidget(uiBinder.createAndBindUi(this));
	}



	@Override
	public void setPresenter(Presenter presenter)
	{

	}

}
