package com.demo.restez;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

@ImplementedBy(HomeViewImpl.class)
public interface HomeView extends IsWidget {

	public interface Presenter {

	}

	void setEnabled(boolean enabled);

	void setError(String error);

	void setPresenter(Presenter presenter);
}

