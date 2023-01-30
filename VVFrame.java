package com.vv.vvclock;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.Date;

public class VVFrame extends Frame {
	private static final int PAD = 50;
	private int HOURHAND_LENGTH;
	private int MINUTE_HAND_LENGTH;
	private int SECOND_HAND_LENGTH;

	public void paint(Graphics g) {
		super.paint(g);
		HOURHAND_LENGTH = (getWidth() - 2 * PAD) / 4;
		MINUTE_HAND_LENGTH = ((getWidth() - 2 * PAD) / 2) - PAD;
		SECOND_HAND_LENGTH = ((getWidth() - 2 * PAD) / 2) - PAD;
		paintClock(g);
		paintMinutes(g);
		Date now = new Date();
		drawTime(g, now.getHours() % 12, now.getMinutes(), now.getSeconds());
		
	}

	private void paintClock(Graphics g) {
		g.drawOval(PAD, PAD, getWidth() - PAD * 2, getHeight() - PAD * 2);

	}

	private void paintMinutes(Graphics g) {
		for (int i = 1; i <= 12; i++) {
			double degrees = i * 30;
			if (i % 3 == 0) {
				int radius = (getWidth() - 2 * PAD) / 2;
				int markerLength = PAD;
				Point minutetick = getClockHandPos(degrees, radius);
				int x1 = minutetick.getX();
				int y1 = minutetick.getY();
				Point secondMinuteTick = getClockHandPos(degrees, radius - markerLength);
				int x2 = secondMinuteTick.getX();
				int y2 = secondMinuteTick.getY();
				g.drawLine(getWidth() / 2 + x1, getHeight() / 2 - y1, getWidth() / 2 + x2, getHeight() / 2 - y2);
			} else {
				int radius = (getWidth() - 2 * PAD) / 2;
				int markerLength = PAD / 2;
				Point minutetick = getClockHandPos(degrees, radius);
				int x1 = minutetick.getX();
				int y1 = minutetick.getY();
				Point secondMinuteTick = getClockHandPos(degrees, radius - markerLength);
				int x2 = secondMinuteTick.getX();
				int y2 = secondMinuteTick.getY();
				g.drawLine(getWidth() / 2 + x1, getHeight() / 2 - y1, getWidth() / 2 + x2, getHeight() / 2 - y2);
			}
		}
		for (int i = 1; i <= 60; i++) {
			double degrees = i * 6;
			int radius = (getWidth() - 2 * PAD) / 2;
			int markerLength = PAD / 4;
			Point secondtick = getClockHandPos(degrees, radius);
			int x1 = secondtick.getX();
			int y1 = secondtick.getY();
			Point secondMinuteTick = getClockHandPos(degrees, radius - markerLength);
			int x2 = secondMinuteTick.getX();
			int y2 = secondMinuteTick.getY();
			g.drawLine(getWidth() / 2 + x1, getHeight() / 2 - y1, getWidth() / 2 + x2, getHeight() / 2 - y2);
		}
	}

	private void drawTime(Graphics g, int hour, int minutes, int seconds) {
		double hourAngle = (hour * 30.0) + ((minutes / 60.0) * 30.0);
		double minuteAngle = (minutes / 60.0) * 360.0;
		double secondAngle = (seconds / 60.0) * 360.0;
		paintHourHand(g, hourAngle);
		paintMinuteHand(g, minuteAngle);
		paintSecondHand(g, secondAngle);
	}

	private void paintHourHand(Graphics g, double hourAngle) {
		// Hour Hand
		int x1 = getWidth() / 2;
		int y1 = getHeight() / 2;
		Point hourpoint = getClockHandPos(hourAngle, HOURHAND_LENGTH);
		int x2 = hourpoint.getX() + x1;
		int y2 = y1 - hourpoint.getY();
		g.drawLine(x1, y1, x2, y2);
	}

	private void paintMinuteHand(Graphics g, double minuteAngle) {
		// Minute Hand
		int x1 = getWidth() / 2;
		int y1 = getHeight() / 2;
		Point minutepoint = getClockHandPos(minuteAngle, MINUTE_HAND_LENGTH);
		int x2 = minutepoint.getX() + x1;
		int y2 = y1 - minutepoint.getY();
		g.drawLine(x1, y1, x2, y2);
	}

	private void paintSecondHand(Graphics g, double secondAngle) {
		int x1 = getWidth() / 2;
		int y1 = getHeight() / 2;
		Point minutepoint = getClockHandPos(secondAngle, SECOND_HAND_LENGTH);
		int x2 = minutepoint.getX() + x1;
		int y2 = y1 - minutepoint.getY();
		g.setColor(Color.GREEN);
		g.drawLine(x1, y1, x2, y2);
		g.setColor(Color.BLACK);
	}

	private Point getClockHandPos(double degrees, int length) {
		degrees = (6.28 / 360.0) * degrees;
		int x = (int) (length * Math.sin(degrees));
		int y = (int) (length * Math.cos(degrees));
		Point p = new Point();
		p.setX(x);
		p.setY(y);
		return p;
	}

}
