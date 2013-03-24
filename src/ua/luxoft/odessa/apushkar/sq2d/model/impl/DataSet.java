package ua.luxoft.odessa.apushkar.sq2d.model.impl;

import java.awt.Point;
import java.util.Vector;

public class DataSet {
	
	private int mSquaresN;
	private Vector<Point> mPoints;
	
	public DataSet() {
		mSquaresN = 0;
		mPoints = new Vector<Point>(0);
	}
	
	public DataSet(int sqN, Vector<Point> p) {
		mSquaresN = sqN;
		mPoints = p;
	}
	
	public int getSquaresN() {
		return mSquaresN;
	}
	
	public void setSquaresN(int n) {
		if (n >= 0) mSquaresN = n;
	}
	
	public int getPointsN() {
		return mPoints.size();
	}
	
	public void getPoints(Vector<Point> p) {
		p.clear();
		for (Point a: mPoints)
			p.add(a);			
	}
	
	public Point getPoint(int n) {
		if (n < mPoints.size())
			return mPoints.get(n);
		else
			return null;
	}
	
	public void addPoint(Point p) {
		mPoints.add(p);
	}
	
	public void addPoint(int x, int y) {
		mPoints.add(new Point(x, y));
	}
	
}
