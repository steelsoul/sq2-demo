package ua.luxoft.odessa.apushkar.sq2d.controller;

import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataModel;
import ua.luxoft.odessa.apushkar.sq2d.view.impl.DemoView;

public class DemoController {
	private DemoView mView;
	private DataModel mModel;

	public DemoController(DataModel model, DemoView view) {
		mView = view;
		mModel = model;
	}
	
	
	
}
