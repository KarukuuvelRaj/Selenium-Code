package week3.day1;
public abstract class SmartWatch implements Watch {

	public void getTime() {
		System.out.println("Show the current time");
	}

	public boolean isAlarmOn() {
		return true;
	}

	public abstract void heartBeatRate();

}