package task4;

public class VisitorsInTime {
    private int time;
    private int visitors;

    public VisitorsInTime(int time, int visitors) {
        this.time = time;
        this.visitors = visitors;
    }

    public VisitorsInTime() {

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getVisitors() {
        return visitors;
    }

    public void addVisitors() {
        visitors++;
    }
}
