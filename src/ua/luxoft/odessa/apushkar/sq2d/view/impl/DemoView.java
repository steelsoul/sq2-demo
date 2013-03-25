package ua.luxoft.odessa.apushkar.sq2d.view.impl;


import javax.swing.JPanel;

import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataModel;

public class DemoView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static DemoViewCanvas mCanvas;
	private DataModel mModel;
	private int mScaleX;
	private int mScaleY;
		
	public DemoView(DataModel model) {
		mModel = model;
		mScaleX = mScaleY = 0;
	}
	
	public void createGUI() {
		mCanvas = new DemoViewCanvas();
		this.add(mCanvas);
		mCanvas.setVisible(true);
	}
	

}
