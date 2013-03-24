package ua.luxoft.odessa.apushkar.sq2d.model.impl;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class DataEngine {
	private DataSet mDataSet;
	private Vector<Integer> mDistance;
	
	public DataEngine(DataSet data) {
		mDataSet = data;
		mDistance = new Vector<Integer>(0);
	}
	
	private int getDistance(Point a, Point b) {
		return Math.max(Math.abs(a.x - b.x), Math.abs(a.y - b.y));
	}
	
	private int getBound(Vector<Point>p, Point a) {
		if (p.isEmpty())
			return 0;
		Vector<Point> temp = new Vector<Point>(p);
		temp.add(a);
		Point minp, maxp;
		minp = maxp = a;
		for (Point t: temp) {
			if (t.x >= maxp.x) maxp.x = t.x;
			if (t.x <= minp.x) minp.x = t.x;
			if (t.y >= maxp.y) maxp.y = t.y;
			if (t.y <= minp.y) minp.y = t.y;
		}
		return getDistance(maxp, minp);		
	}
	
	private void sortByDistance() {
		if (mDataSet.getPointsN() < 2)
			return;
		mDistance.clear();
		
		Set<Integer> ds = new HashSet<Integer>();
		Vector<Point> points = new Vector<Point>(0);
		mDataSet.getPoints(points);
		
		for (int i = 0; i < points.size() - 1; i++) 
			for (int j = i + 1; j < points.size(); j++)
				ds.add(getDistance(points.get(i), points.get(j)));
		mDistance.addAll(ds);
		java.util.Collections.sort(mDistance);
	}
	
	
	
	public boolean isCovered(int side) {
		return false;
	}
	
	
}
