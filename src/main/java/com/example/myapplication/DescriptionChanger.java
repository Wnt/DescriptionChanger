package com.example.myapplication;

import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

public class DescriptionChanger extends AbstractExtension {


	protected DescriptionChanger(TextField tf, Component target) {
	}

	public static DescriptionChanger extend(TextField tf, Component target) {
		return new DescriptionChanger(tf, target);
	}
}
