package ua.luxoft.odessa.apushkar.sq2d.controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import ua.luxoft.odessa.apushkar.sq2d.view.impl.DemoView;

public class DemoController extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private DataModel mModel;
	private DemoView mView;
	private DataEngine mEngine;
	private JComboBox<Integer> mSelector;

	public DemoController(DataModel model, DemoView view) {
		mModel = model;
		mView = view;
		mSelector = new JComboBox<Integer>();
		mEngine = null;
	}
	
	public void createGUI() {
		this.setLayout(new BorderLayout());
		this.add(mSelector, BorderLayout.NORTH);
		JButton runButton = new JButton("RUN");
		this.add(runButton, BorderLayout.CENTER);
		runButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				startDemonstration(mSelector.getSelectedIndex());
			}
			
		});
		
	}

	public void parse(String inFileName) {
		if (!inFileName.isEmpty())
			try {
				FileReader reader = new FileReader(inFileName);
				BufferedReader buffer = new BufferedReader(reader);
				Scanner scanner = new Scanner(buffer);

				if (scanner.nextInt() > 0)
				while (scanner.hasNext()) {
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
		fillSelector();
	}
	
	private void fillSelector() {
		// fill selector with items
		for (int i = 0; i < mModel.getCaseN(); i++)
			mSelector.addItem(i+1);
		mSelector.invalidate();
	}
	
	private void startDemonstration(int n) {
		if (mEngine != null) {
			mEngine.stopEngine();
			
			try {
				mEngine.join(200);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
				
//				mEngine.isAlive());
			
			mEngine = null;
			mView.reset();
			mEngine = new DataEngine(mModel.getData(n), mView);
			mEngine.start();
		} else
		{
			mView.reset();
			mEngine = new DataEngine(mModel.getData(n), mView);
			mEngine.start();
		}
	}


	
}
