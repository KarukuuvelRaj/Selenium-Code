package week3.day1;

public class AppleWatch extends SmartWatch {

	public boolean isStopWatchAvailable() {
		return true;
	}
	@Override
	public void heartBeatRate() {
		System.out.println("Show the heart rate");
	}

}
