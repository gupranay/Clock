package com.vv.vvclock.ui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.vv.vvclock.VVFrame;

public class Clock {
	private VVFrame f;

	public void init() {
		f = new VVFrame();
		f.setLayout(null);
		f.setBounds(400, 100, 600, 600);
		f.setTitle("VVClock");
		// create alarm button
		Button alarm = new Button("Alarm");
		
		alarm.setBounds(f.getWidth()/2, (int) (f.getHeight()*(3.0/4)), 60, 20);
		alarm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Alarm Button clicked");
				
			}
			
		});
		f.add(alarm);
		f.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

		});
		f.setVisible(true);
	}

	public void refresh() {
		f.repaint();
		
	}

}
