import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Light> lightList = new ArrayList<Light>();
        TrafficManager trafficManager = new TrafficManager();
        int minCycle = TrafficManager.MAX_TIME;
        try {
            do {
                int integer = scanner.nextInt();
                if (integer == 0) {
                    //If list is empty it's mean that input data is 0 0 0
                    if (lightList.isEmpty()) {
                        break;
                    } else {
                        //Show the time when all light is green.
                        System.out.println(trafficManager.getTime(lightList));
                        lightList.clear();
                        continue;
                    }
                }
                //if the time is minimal it will be added to the beginning of ArrayList
                if (minCycle > integer) {
                    minCycle = integer;
                    lightList.add(0, new Light(integer));
                } else {
                    lightList.add(new Light(integer));
                }
            } while (true);

        } catch (Exception e) {

        }
    }
}