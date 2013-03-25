package ua.luxoft.odessa.apushkar.sq2d.model.impl;

import java.awt.Point;
import java.util.Comparator;
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
	
	public void checkCovered() {
		Vector<Point> v = new Vector<Point>(0);
		mDataSet.getPoints(v);
		
		sortByDistance();

		// TODO: should notify about changes
		for (int d: mDistance)
			if (isCoveredW(v, d) || isCoveredH(v, d)) 
				break;
	}
	
	static public int getDistance(Point a, Point b) {
		return Math.max(Math.abs(a.x - b.x), Math.abs(a.y - b.y));
	}
	
	/**
	 *  Private elements
	 ***/
	
	static class PointComporatorX implements Comparator<Point> {

		@Override
		public int compare(Point p1, Point p2) {
			return p1.x - p2.x;
		}		
	}
	
	static class PointComparatorY implements Comparator<Point> {

		@Override
		public int compare(Point p1, Point p2) {
			return p1.y - p2.y;
		}
		
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
	
	private boolean isCoveredAnyway(Vector<Point> vv, int side) {
		Vector<Point> ep = new Vector<Point>(0);
		
		int iteration = 0;
		int asq = 0;
		int amountf = 0;
		
		for (;;) {
			ep.clear();
			if (vv.size() + asq <= mDataSet.getSquaresN()) return true;
			
			if (iteration + 1 >= vv.size()) return false;
			
			boolean sq_found = false;
			for (int j = iteration + 1; j < vv.size(); j++) {
				if (getDistance(vv.get(iteration), vv.get(j)) <= side) {
					if (!sq_found) ep.add(vv.get(iteration));
					if (getBound(ep, vv.get(j)) <= side) {
						sq_found = true;
						ep.add(vv.get(j));
						// TODO: inform view about points to remove.
					}						
				}
			}
			
			if (sq_found) {
				asq++;
				for (Point p: ep) {
					vv.remove(p);
					amountf++;
				}
				if (asq > mDataSet.getSquaresN()) return false;
				if (amountf >= mDataSet.getPointsN()) return true;					
			}
			else
				iteration++;
		}
	}
	
	private boolean isCoveredW(Vector<Point> v, int side) {
		Vector<Point> vv = new Vector<Point>(v);
		java.util.Collections.sort(vv, new PointComporatorX());
		return isCoveredAnyway(vv, side);
	}
	
	private boolean isCoveredH(Vector<Point> v, int side) {
		Vector<Point> vv = new Vector<Point>(v);
		java.util.Collections.sort(vv, new PointComparatorY());
		return isCoveredAnyway(vv, side);
	}
	
}
