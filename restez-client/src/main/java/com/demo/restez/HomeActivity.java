package com.demo.restez;

import com.demo.restez.restlist.DefaultRestListPresenter;
import com.demo.restez.servicesProxy.RestEzServiceProxy;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {

	private final HomeView view;
	private final PlaceController placeController;
	private AppFactory restEzService;

	@Inject
	HomeActivity(HomeView view, PlaceController placeController, AppFactory restEzService) {
		this.view = view;
		this.placeController = placeController;
		this.restEzService = restEzService;
	}

	@Override
	public void start(AcceptsOneWidget panel,
			@SuppressWarnings("deprecation") com.google.gwt.event.shared.EventBus eventBus) {
		view.setPresenter(this);
		view.setEnabled(true);
		panel.setWidget(view);
		
		DefaultRestListPresenter restListPrester = new DefaultRestListPresenter(view.getRestList(), restEzService);
		restListPrester.start(eventBus);
	}
}

