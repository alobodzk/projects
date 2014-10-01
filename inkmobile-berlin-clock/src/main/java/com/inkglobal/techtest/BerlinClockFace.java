package com.inkglobal.techtest;

import java.io.PrintStream;
import java.util.Calendar;
import java.util.TimeZone;

public class BerlinClockFace implements ClockFace {

	private static final int FIRST_ROW_LAMPS_COUNT = 4;
	private static final int SECOND_ROW_LAMPS_COUNT = 4;
	private static final int THIRD_ROW_LAMP_COUNT = 11;
	private static final int FOURT_ROW_LAMP_COUNT = 4;
	private static final String YELLOW_LAMP = "B";
	private static final String LAMP_OFF = "O";
	private static final String RED_LAMP = "R";

	private final PrintStream printStream;

	public BerlinClockFace(PrintStream printStream) {
		this.printStream = printStream;
	}

	private void newMethod() {
		
	}

	@Override
	public void showTime(long time) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.setTimeInMillis(time);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		StringBuilder outputTime = new StringBuilder();

		setYellowLamp(second, outputTime);
		setFirstRow(hour, outputTime);
		setSecondRow(hour, outputTime);
		setThirdRow(minute, outputTime);
		setFourthRow(minute, outputTime);
		outputTime.append("\n");
		printStream.print(outputTime.toString());
	}

	private void setYellowLamp(int second, StringBuilder outputTime) {
		if (second % 2 == 0) {
			outputTime.append(YELLOW_LAMP);
		} else {
			outputTime.append(LAMP_OFF);
		}
		outputTime.append(" ");
	}

	private void setFirstRow(int hour, StringBuilder outputTime) {
		int lampsCount = hour / (FIRST_ROW_LAMPS_COUNT + 1);
		for (int i = 0; i < lampsCount; i++) {
			outputTime.append(RED_LAMP);
		}
		for (int i = 0; i < FIRST_ROW_LAMPS_COUNT - lampsCount; i++) {
			outputTime.append(LAMP_OFF);
		}
		outputTime.append(" ");
	}

	private void setSecondRow(int hour, StringBuilder outputTime) {
		int lampsCount = hour % (SECOND_ROW_LAMPS_COUNT + 1);
		for (int i = 0; i < lampsCount; i++) {
			outputTime.append(RED_LAMP);
		}
		for (int i = 0; i < SECOND_ROW_LAMPS_COUNT - lampsCount; i++) {
			outputTime.append(LAMP_OFF);
		}
		outputTime.append(" ");
	}

	private void setThirdRow(int minute, StringBuilder outputTime) {
		int lampsCount = minute / 5;
		for (int i = 1; i <= lampsCount; i++) {
			if (i % 3 == 0) {
				outputTime.append(RED_LAMP);
			} else {
				outputTime.append(YELLOW_LAMP);
			}
		}
		for (int i = 0; i < THIRD_ROW_LAMP_COUNT - lampsCount; i++) {
			outputTime.append(LAMP_OFF);
		}
		outputTime.append(" ");
	}

	private void setFourthRow(int minute, StringBuilder outputTime) {
		int lampsCount = minute % (FOURT_ROW_LAMP_COUNT + 1);
		for (int i = 0; i < lampsCount; i++) {
			outputTime.append(YELLOW_LAMP);
		}
		for (int i = 0; i < FOURT_ROW_LAMP_COUNT - lampsCount; i++) {
			outputTime.append(LAMP_OFF);
		}
	}
}
