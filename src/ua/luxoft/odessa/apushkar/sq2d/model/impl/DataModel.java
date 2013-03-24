package ua.luxoft.odessa.apushkar.sq2d.model.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class DataModel {
	private Vector<DataSet> mData;
	
	public DataModel(String filename) {
		if (!filename.isEmpty())
			try {
				FileReader reader = new FileReader(filename);
				BufferedReader buffer = new BufferedReader(reader);
				Scanner scanner = new Scanner(buffer);

				if (scanner.nextInt() > 0)
				while (new Scanner(buffer).hasNext()) {
					DataSet tempDS = new DataSet();
					
					int pointsN = scanner.nextInt();
					tempDS.setSquaresN(scanner.nextInt());
					for (int i = 0; (i < pointsN) && scanner.hasNext(); i++)
						tempDS.addPoint(scanner.nextInt(), scanner.nextInt());
					
					mData.add(tempDS);
				}
				scanner.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
	}
	
}
