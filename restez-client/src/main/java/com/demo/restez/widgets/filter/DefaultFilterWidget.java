package com.demo.restez.widgets.filter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class DefaultFilterWidget extends Composite implements FilterWidget
{

	private static DefaultFilterWidgetUiBinder uiBinder = GWT.create(DefaultFilterWidgetUiBinder.class);

	interface DefaultFilterWidgetUiBinder extends UiBinder<Widget, DefaultFilterWidget>
	{
	}

	public DefaultFilterWidget()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

}
