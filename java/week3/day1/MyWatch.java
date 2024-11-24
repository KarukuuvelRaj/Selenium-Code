package week3.day1;

public class MyWatch {

	public static void main(String[] args) {
		AppleWatch obj = new AppleWatch();
		obj.getTime();
		boolean alarmOn = obj.isAlarmOn();
		System.out.println(alarmOn);
		boolean stopWatchAvailable = obj.isStopWatchAvailable();
		System.out.println(stopWatchAvailable);
		obj.heartBeatRate();
	}

}
