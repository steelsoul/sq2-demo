package ua.luxoft.odessa.apushkar.sq2d.api;
import java.util.Vector;
import java.awt.Point;;


public interface IPointsObserver {
	void notify(Vector<Point> p);
	void notifyForRemove(Vector<Point> p, int side);
	void notifyEraseRP();
}

