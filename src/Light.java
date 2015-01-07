public class Light {
    private int greenLight;
    private int timeCycle;

    Light(int timeCycle) {
        this.timeCycle = timeCycle * 2;
        this.greenLight = timeCycle - 5;
    }

    public int getGreenLight() {
        return greenLight;
    }

    public int getTimeCycle() {
        return timeCycle;
    }

}
