package core;

//секундомер
public class Stopwatch {
    private static boolean isStarted;
    private static long startTimeStamp;
    private static long stopTimeStamp;

    public static void start() {
        if (!isStarted) {
            isStarted = true;
            startTimeStamp = System.currentTimeMillis();
            stopTimeStamp = 0L;
        }
    }

    public static void stop() {
        if (isStarted) {
            isStarted = false;
            stopTimeStamp = System.currentTimeMillis();
        }
    }

    public static long getTimePass() {
        if (!isStarted) {
            return stopTimeStamp - startTimeStamp;
        } else {
            return -1;
        }
    }
}