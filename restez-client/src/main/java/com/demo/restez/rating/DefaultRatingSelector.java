package com.demo.restez.rating;

import com.github.gwtbootstrap.client.ui.Icon;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.adapters.TakesValueEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public class DefaultRatingSelector extends Composite implements HasValue<Integer>, IsEditor<TakesValueEditor<Integer>>
{

	private static DefaultRatingSelectorUiBinder uiBinder = GWT.create(DefaultRatingSelectorUiBinder.class);

	interface DefaultRatingSelectorUiBinder extends UiBinder<Widget, DefaultRatingSelector>
	{
	}
	
	@UiField
	FocusPanel star1Panel;
	
	@UiField
	Icon star1;
	
	@UiField
	FocusPanel star2Panel;
	
	@UiField
	Icon star2;
	
	@UiField
	FocusPanel star3Panel;

	@UiField
	Icon star3;
	
	private Integer rating;
	
	private TakesValueEditor<Integer> editor;

	public DefaultRatingSelector()
	{
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
    public Integer getValue()
    {
	    return rating;
    }

	@Override
    public void setValue(Integer value)
    {
		setValue(value, false);
    }

	@Override
    public void setValue(Integer value, boolean fireEvents)
    {
	    if (value == null)
	    {
	    	value = 1;
	    	rating = 1;
	    }
	    
	    onStarClick(value);
		if (fireEvents)
			fireChangeEvent();
    }

	@Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Integer> handler)
    {
		return addHandler(handler, ValueChangeEvent.getType());
    }
	
	@UiHandler({"star1Panel", "star2Panel", "star3Panel"})
	public void onClick(ClickEvent event)
	{
		FocusPanel panel = (FocusPanel)event.getSource();
		if (panel.equals(star1Panel))
			onStarClick(1);
		else if (panel.equals(star2Panel))
			onStarClick(2);
		else
			onStarClick(3);	
	}
	
	private void onStarClick(int rating)
    {
		if (rating == 1)
		{
			selectStar(star1);
			deselectStar(star2);
			deselectStar(star3);
		}
		else if (rating == 2)
		{
			selectStar(star1);
			selectStar(star2);
			deselectStar(star3);
		}
		else
		{
			selectStar(star1);
			selectStar(star2);
			selectStar(star3);
		}
    }
	
	private void selectStar(Icon star)
	{
		star.setType(IconType.STAR);
	}
	
	private void deselectStar(Icon star)
	{
		star.setType(IconType.STAR_EMPTY);
	}	
	
    public void fireChangeEvent()
    {
		ValueChangeEvent.fire(DefaultRatingSelector.this, getValue());	    
    }

	@Override
    public TakesValueEditor<Integer> asEditor()
    {
	    if (editor == null)
	    {
	    	editor = TakesValueEditor.of(this);
	    }
	    return editor;
    }	

}
