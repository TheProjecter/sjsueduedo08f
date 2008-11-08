package edu.sjsu.edo08f.support;

import edu.sjsu.edo08f.exceptions.InvalidOperationException;

import java.util.Map;

/**
 * Created by: Alex Yarmula
 * Date: Nov 7, 2008
 */
public enum DayOfWeek {

    Monday ("M"),
    Tuesday ("T"),
    Wednesday ("W"),
    Thursday ("R"),
    Friday ("F"),
    Saturday ("S"),
    Sunday ("U");

    DayOfWeek(String shortcutName) {
        this.shortcutName = shortcutName;
    }
    private String shortcutName;
    private static Map<String, DayOfWeek> daysShortToFull;

    static {
        for (DayOfWeek day : DayOfWeek.values()) {
            daysShortToFull.put(day.shortcutName, day);
        }
    }

    public DayOfWeek getDayByShortcutName (String shortcutName) {
        if (daysShortToFull.containsKey(shortcutName)) {
            return daysShortToFull.get(shortcutName);
        } else {
            throw new InvalidOperationException ("This type of day doesn't exist");
        }
    }

}
