package ua.luxoft.odessa.apushkar.sq2d.view.impl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class DemoViewCanvas extends Canvas {

	public DemoViewCanvas() {
		this.setPreferredSize(new Dimension(300, 300));
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public void update(Graphics g) {
		paint(g);
	}
}
