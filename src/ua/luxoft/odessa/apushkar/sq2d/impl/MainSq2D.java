package ua.luxoft.odessa.apushkar.sq2d.impl;

import java.awt.Dimension;

import javax.swing.JFrame;

import ua.luxoft.odessa.apushkar.sq2d.controller.DemoController;
import ua.luxoft.odessa.apushkar.sq2d.model.impl.DataModel;
import ua.luxoft.odessa.apushkar.sq2d.view.impl.DemoView;

public class MainSq2D extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;

	private JFrame mMainWindow;
	private static MainSq2D mMain;
	private static DataModel mModel;
	private static DemoView mView;
	private static DemoController mController;
	
	public void createGUI() {
		mMainWindow = new JFrame("sq2 - demo");
		mMainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mMainWindow.setPreferredSize(new Dimension(400, 300));
		mMainWindow.add(mView);
		mMainWindow.pack();
		mMainWindow.setResizable(false);
		mMainWindow.setVisible(true);		
	}
	
	public void start()
	{
		new Thread(this).start();
	}
	
	public static void main(String[] args) {
		mModel = new DataModel();
		mView = new DemoView(mModel);
		mController = new DemoController(mModel);
		if (args.length > 0) mController.parse(args[0]);
		
		mMain = new MainSq2D();
		mMain.start();
	}

	@Override
	public void run() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				createGUI();
			}
		});
	}

}
