package ua.luxoft.odessa.apushkar.sq2d.model.impl;

import java.awt.Point;
import java.util.Vector;

public class DataModel {
	private Vector<DataSet> mData;
	
	public DataModel() {
		mData = new Vector<DataSet>(0); 
	}
	
	public void add(DataSet s) {
		mData.add(s);
	}
	
	public int getCaseN() {
		return mData.size();
	}
	
	public DataSet getData(int n) {
		return mData.get(n);
	}
	
	public int getDimensionX(int n) {
		if (n >= mData.size())
			return 0;
		
		Vector<Point> temp = new Vector<Point>(0);
		mData.get(n).getPoints(temp);
		if (temp.isEmpty())
			return 0;
	
		Point minp, maxp;
		minp = maxp = temp.get(0);
		for (Point t: temp) {
			if (t.x >= maxp.x) maxp.x = t.x;
			if (t.x <= minp.x) minp.x = t.x;
			if (t.y >= maxp.y) maxp.y = t.y;
			if (t.y <= minp.y) minp.y = t.y;
		}
		return DataEngine.getDistance(maxp, minp);		
	}
	
}
