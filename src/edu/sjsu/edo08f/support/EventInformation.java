package edu.sjsu.edo08f.support;

/**
 * Created by: Alex Yarmula
 * Date: Nov 7, 2008
 */
public class EventInformation {

    private DayOfWeek dayOfWeek;
    private String startTime;
    private String endTime;

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
