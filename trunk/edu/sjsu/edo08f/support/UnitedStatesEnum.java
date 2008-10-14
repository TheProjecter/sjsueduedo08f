package edu.sjsu.edo08f.support;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public enum UnitedStatesEnum {

    // need to add all the other states and abbreviations
    AZ ("Arizona"), CA ("California");
    
    private String fullName;
    private static Map<String, String> states = new HashMap<String, String>();

    UnitedStatesEnum (String fullName) {
        this.fullName = fullName;
    }

    String getFullName() { return fullName; }

    static {
        for (UnitedStatesEnum state : UnitedStatesEnum.values()) {
            states.put(state.toString(), state.getFullName());
        }
    }

    public static boolean verifyState (String stateName) {
        return states.containsKey(stateName) || states.containsValue(stateName);
    }

}
