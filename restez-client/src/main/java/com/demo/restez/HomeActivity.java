package com.demo.restez;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class HomeActivity extends AbstractActivity implements HomeView.Presenter {

	private final HomeView view;
	private final PlaceController placeController;

	@Inject
	HomeActivity(HomeView view, PlaceController placeController) {
		this.view = view;
		this.placeController = placeController;
	}

	@Override
	public void start(AcceptsOneWidget panel,
			@SuppressWarnings("deprecation") com.google.gwt.event.shared.EventBus eventBus) {
		view.setPresenter(this);
		view.setEnabled(true);
		panel.setWidget(view);
	}
}

