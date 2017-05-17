package com.example.myapplication.client.mycomponent;

import com.example.myapplication.DescriptionChanger;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.AbstractComponentState;
import com.vaadin.shared.ui.Connect;

@Connect(DescriptionChanger.class)
public class DescriptionChangerConnector extends AbstractExtensionConnector {

	
	private TextFieldConnector inputConnector;
	private ChangeHandler changeHandler;
	private HandlerRegistration changeHangleRegistration;

	public DescriptionChangerConnector() {

	}

	@Override
	protected void extend(ServerConnector inputFieldConnector) {
		inputConnector = (TextFieldConnector) inputFieldConnector;
	}
	
	@OnStateChange("target")
	public void onTargetChange() {
		if (changeHangleRegistration != null) {
			changeHangleRegistration.removeHandler();
		}
		
		changeHandler = new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {
				AbstractComponentConnector targetConnector = (AbstractComponentConnector) getState().target;
				AbstractComponentState targetState = targetConnector.getState();
				targetState.caption = inputConnector.getWidget().getValue();
				
			}
		};
		changeHangleRegistration = inputConnector.getWidget().addChangeHandler(changeHandler);
		
	}
	@Override
	public DescriptionChangerState getState() {
		return (DescriptionChangerState) super.getState();
	}
	

}

