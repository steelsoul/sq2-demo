package ua.luxoft.odessa.apushkar.sq2d.controller;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataEngine;
import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataModel;
import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataSet;

public class DemoController extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private DataModel mModel;
	private DataSet mDataSet;
	private JComboBox<Integer> mSelector;

	public DemoController(DataModel model) {
		mModel = model;
		mSelector = new JComboBox<Integer>();
	}
	
	public void createGUI() {
		// fill selector with items
		for (int i = 0; i < mModel.getCaseN(); i++)
			mSelector.addItem(i+1);
		this.setLayout(new BorderLayout(10, 10));
		this.add(mSelector, BorderLayout.NORTH);
		this.add(new JButton("RUN"), BorderLayout.WEST);
	}
	
	
	public void startDemonstration(int n) {
		DataEngine engine = new DataEngine(mDataSet);
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
	

	/**
	 *  Private methods
	 * */
	
}
