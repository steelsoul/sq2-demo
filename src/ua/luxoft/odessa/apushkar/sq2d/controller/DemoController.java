package ua.luxoft.odessa.apushkar.sq2d.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataEngine;
import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataModel;
import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataSet;

public class DemoController {
	private DataModel mModel;

	public DemoController(DataModel model) {
		mModel = model;
	}
	
	public void parse(String inFileName) {
		if (!inFileName.isEmpty())
			try {
				FileReader reader = new FileReader(inFileName);
				BufferedReader buffer = new BufferedReader(reader);
				Scanner scanner = new Scanner(buffer);

				if (scanner.nextInt() > 0)
				while (new Scanner(buffer).hasNext()) {
					DataSet tempDS = new DataSet();
					
					int pointsN = scanner.nextInt();
					tempDS.setSquaresN(scanner.nextInt());
					for (int i = 0; (i < pointsN) && scanner.hasNext(); i++)
						tempDS.addPoint(scanner.nextInt(), scanner.nextInt());
					
					mModel.add(tempDS);
				}
				scanner.close();
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
	}
	
	public void startDemonstration(int n) {
		DataEngine engine = new DataEngine();
	}
	
	
}
