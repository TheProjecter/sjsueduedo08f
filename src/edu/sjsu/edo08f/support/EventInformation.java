package edu.sjsu.edo08f.support;

/**
 * Created by: Oleksiy Yarmula
 * Date: Nov 7, 2008
 */
public class EventInformation {

    private DayOfWeek dayOfWeek;
    private String startTime;
    private String endTime;

    public EventInformation() {
    }

    public EventInformation(DayOfWeek dayOfWeek, String startTime, String endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
