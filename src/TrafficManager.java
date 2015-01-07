import java.util.List;

public class TrafficManager {

    public static final int MAX_TIME = 18000;

    //This method return time when all lights is green.
    public String getTime(List<Light> lightList) {
        int time = getSameTime(lightList);
        if (time != 0) {
            int hours = time / 3600;
            int minutes = (time % 3600) / 60;
            int seconds = time % 60;
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            return "Signals fail to synchronise in 5 hours";
        }
    }

    //This method checks which colour all the traffic lights have in a certain period of time
    private boolean checkLight(List<Light> lightList, int time) {
        int count;
        for (count = 1; count < lightList.size(); count++) {
            if (time % lightList.get(count).getTimeCycle()
                    >= lightList.get(count).getGreenLight()) {
                break;
            }
        }
        return count == lightList.size();
    }

    //This method gets the starting and the ending point of the first traffic light showing green.
    //Every second of the interval it checks if the other traffic lights show green.
    private int getGreenTime(List<Light> lightList, int startTime, int endTime) {
        for (int greenTime = startTime; greenTime < endTime; greenTime++) {
            if (checkLight(lightList, greenTime)) {
                return greenTime;
            }

        }
        return 0;
    }

    //This method calculates the interval of time when the first traffic light shows green.
    //The method can return 0 if the signals are not synchronised during the next 5 hours
    private int getSameTime(List<Light> lightList) {
        int startTime = lightList.get(0).getTimeCycle();
        int endTime = startTime + lightList.get(0).getGreenLight();
        int sameTime = 0;
        while (startTime <= MAX_TIME) {
            sameTime = getGreenTime(lightList, startTime, endTime);
            if (sameTime == 0) {
                startTime += lightList.get(0).getTimeCycle();
                endTime = startTime + lightList.get(0).getGreenLight();
                continue;
            } else {
                return sameTime;
            }

        }
        return sameTime;
    }
}
