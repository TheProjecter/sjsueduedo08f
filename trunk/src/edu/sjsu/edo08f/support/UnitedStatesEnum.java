package edu.sjsu.edo08f.support;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public enum UnitedStatesEnum {

    // add all the other states and abbreviations
    //AZ ("Arizona"), CA ("California");
	AL ("ALABAMA"),
	AK ("ALASKA"),
	AZ ("ARIZONA"),
	AR ("ARKANSAS"),
	CA ("CALIFORNIA"),
	CO ("COLORADO"),
	CT ("CONNECTICUT"),
	DE ("DELAWARE"),
	FL ("FLORIDA"),
	GA ("GEORGIA"),
	HI ("HAWAII"),
	ID ("IDAHO"),
	IL ("ILLINOIS"),
	IN ("INDIANA"),
	IA ("IOWA"),
	KS ("KANSAS"),
	KY ("KENTUCKY"),
	LA ("LOUISIANA"),
	ME ("MAINE"),
	MD ("MARYLAND"),
	MA ("MASSACHUSETTS"),
	MI ("MICHIGAN"),
	MN ("MINNESOTA"),
	MS ("MISSISSIPPI"),
	MO ("MISSOURI"),
	MT ("MONTANA"),
	NE ("NEBRASKA"),
	NV ("NEVADA"),
	NH ("NEW_HAMPSHIRE"),
	NJ ("NEW_JERSEY"),
	NM ("NEW_MEXICO"),
	NY ("NEW_YORK"),
	NC ("NORTH_CAROLINA"),
	ND ("NORTH_DAKOTA"),
	OH ("OHIO"),
	OK ("OKLAHOMA"),
	OR ("OREGON"),
	PA ("PENNSYLVANIA"),
	RI ("RHODE_ISLAND"),
	SC ("SOUTH_CAROLINA"),
	SD ("SOUTH_DAKOTA"),
	TN ("TENNESSEE"),
	TX ("TEXAS"),
	UT ("UTAH"),
	VT ("VERMONT"),
	VA ("VIRGINIA"),
	WA ("WASHINGTON"),
	WV ("WEST_VIRGINIA"),
	WI ("WISCONSIN"),
	WY ("WYOMING");
    
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
