package com.demo.restez;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class App implements EntryPoint {

	public void onModuleLoad() {
		AppGinjector injector = GWT.create(AppGinjector.class);

		SimpleLayoutPanel mainContainer = new SimpleLayoutPanel();
		MainActivityMapper mainMapper = injector.mainActivityMapper();
		ActivityManager mainManager = new ActivityManager(mainMapper, injector.eventBus());
		mainManager.setDisplay(mainContainer);

		RootLayoutPanel.get().add(mainContainer);

		injector.placeHistoryHandler().handleCurrentHistory();
	}
}
