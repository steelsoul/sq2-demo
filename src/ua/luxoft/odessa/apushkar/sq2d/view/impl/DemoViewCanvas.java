package ua.luxoft.odessa.apushkar.sq2d.view.impl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public class DemoViewCanvas extends Canvas {
	private static final long serialVersionUID = 1L;
	private static Vector<Point> mPoints = new Vector<Point>();

	private class SquarePoints {
		public Point lp;
		public Point rp;
	}
	
	private Vector<SquarePoints> mSquares = new Vector<SquarePoints>();
	
	private int mXBound;
	private int mYBound;
	private int mXMin;
	private int mYMin;
	
	public DemoViewCanvas() {
		this.setMinimumSize(new Dimension(300, 300));
		this.setMaximumSize(new Dimension(500, 500));
		this.setPreferredSize(new Dimension(300, 300));
		mXBound = mYBound = 0;
	}
	
	public void reset() {
		mXBound = mYBound = 0;
		mPoints.clear();
		mSquares.clear();
	}
	
	public void eraseRemoved() {
		mSquares.clear();
		this.repaint();
	}
	
	public void setPoints(Vector<Point> p) {
		mPoints.clear();
		mPoints.addAll(p);
		
		Point minp = new Point(mPoints.get(0).x, mPoints.get(0).y); 
		Point maxp = new Point(mPoints.get(0).x, mPoints.get(0).y); 

		for (Point tp: mPoints) {
			if (tp.x < minp.x) minp.x = tp.x;
			if (tp.x > maxp.x) maxp.x = tp.x;
			if (tp.y < minp.y) minp.y = tp.y;
			if (tp.y > maxp.y) maxp.y = tp.y;
		}

		mXBound = maxp.x - minp.x;
		mYBound = maxp.y - minp.y;
		mXMin = minp.x;
		mYMin = minp.y;
		
		this.repaint();
	}
	
	public void setRemovePoints(Vector<Point> p, int side) {
		
		Point minp = new Point(p.get(0).x, p.get(0).y);
		
		for (Point tp: p) {
			if (tp.x < minp.x) minp.x = tp.x;
			if (tp.y < minp.y) minp.y = tp.y;
		}
		
		SquarePoints sp = new SquarePoints();

		sp.lp = new Point(minp.x, minp.y);
		sp.rp = new Point(minp.x + side, minp.y + side);
		
		mSquares.add(sp);
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		Rectangle r = g.getClipBounds();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, r.width, r.height);

		double kx = (double) mXBound / (r.width - 50);
		double ky = (double) mYBound / (r.height - 50);
		double k = Math.max(kx, ky);
		
		if (!mPoints.isEmpty()) {
			g.setColor(Color.WHITE);			
			for (Point p: mPoints)
			{
				int posx = (int)((double)p.x / k) - (int)((double)mXMin / k) + 3;
				int posy = (int)((double)p.y / k)- (int)((double)mYMin / k) + 3;
				g.fillArc(posx - 2, posy - 2, 4, 4, 0, 360);
			}			
		}
		
		if (!mSquares.isEmpty()) {
			g.setColor(Color.RED);
			for (SquarePoints sp: mSquares) {
				int lpx = (int)((double)sp.lp.x / k) - (int)((double)mXMin / k) + 3;
				int lpy = (int)((double)sp.lp.y / k)- (int)((double)mYMin / k) + 3;
				int rpx = (int)((double)sp.rp.x / k) - (int)((double)mXMin / k) + 3;
				int rpy = (int)((double)sp.rp.y / k)- (int)((double)mYMin / k) + 3;
				g.drawRect(lpx, lpy, rpx - lpx, rpy - lpy);
			}
		}
		
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);	
	}
}
