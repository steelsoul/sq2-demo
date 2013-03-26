package ua.luxoft.odessa.apushkar.sq2d.view.impl;


import java.awt.BorderLayout;
import java.awt.Point;
import java.util.Vector;
import javax.swing.JPanel;

import ua.luxoft.odessa.apushkar.sq2d.api.IPointsObserver;

public class DemoView extends JPanel implements IPointsObserver {
	
	private static final long serialVersionUID = 1L;
	private static DemoViewCanvas mCanvas;

		
	public DemoView() {
	}
	
	public void createGUI() {
		mCanvas = new DemoViewCanvas();
		this.setLayout(new BorderLayout());
		this.add(mCanvas);
		mCanvas.setVisible(true);
	}
	
	public void reset() {
		mCanvas.reset();
	}

	@Override
	public void notify(Vector<Point> p) {
		mCanvas.setPoints(p);		
	}

	@Override
	public void notifyForRemove(Vector<Point> p) {
		mCanvas.setRemovePoints(p);		
	}


}
