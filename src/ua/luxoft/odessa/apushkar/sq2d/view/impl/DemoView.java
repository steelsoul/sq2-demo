package ua.luxoft.odessa.apushkar.sq2d.view.impl;

import java.awt.Canvas;
import java.awt.Graphics;

import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataModel;

public class DemoView extends Canvas {
	
	private static final long serialVersionUID = 1L;
	private DataModel mModel;
	private int mScaleX;
	private int mScaleY;
		
	public DemoView(DataModel model) {
		mModel = model;
		mScaleX = mScaleY = 0;
	}
	
	public void paint(Graphics g) {
		// TODO: Calculate dimension scales
//		mScaleX = getWidth() / mModel.get
	}
	
	public void update(Graphics g) {
		
	}
	
	

}
