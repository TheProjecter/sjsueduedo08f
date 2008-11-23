package edu.sjsu.edo08f.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import edu.sjsu.edo08f.support.EventInformation;

import java.util.*;

/**
 * Created by: Alex Yarmula
 * Date: Nov 15, 2008
 */
public class CommonDao extends SqlMapClientDaoSupport {

    private final String NAMESPACE = "Common.";

    public Long getLocationIdByName (String name) {
        return (Long) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getLocationIdByName", name);
    }

    public Long createLocation (String name) {
        getSqlMapClientTemplate().insert(NAMESPACE + "createLocation", name);
        return getLocationIdByName(name);
    }

    public Long getEventInformationId (EventInformation eventInformation) {
        return (Long) getSqlMapClientTemplate().queryForObject(NAMESPACE + "findEventInformationId", eventInformation);
    }

    public void createEventInformation (EventInformation eventInformation) {
        getSqlMapClientTemplate().insert(NAMESPACE + "createEventInformation", eventInformation);
    }

    public void createMeetingHours (Long courseId, Long eventInformationId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put ("courseId", courseId);
        parameters.put("eventInformationId", eventInformationId);
        getSqlMapClientTemplate().insert(NAMESPACE + "createMeetingHours", parameters);
    }

    public void deleteAllMeetingHoursForCourse (Long courseId) {
        getSqlMapClientTemplate().delete(NAMESPACE + "deleteAllMeetingHoursForCourse", courseId);
    }

    public void createOfficeHours (Long courseId, Long eventInformationId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put ("instructorId", courseId);
        parameters.put("eventInformationId", eventInformationId);
        getSqlMapClientTemplate().insert(NAMESPACE + "createOfficeHours", parameters);
    }

    public void deleteAllOfficeHoursForInstructor (Long instructorId) {
        getSqlMapClientTemplate().delete(NAMESPACE + "deleteAllOfficeHoursForInstructor", instructorId);
    }


    public Long provideCourseLocation(String locationName) {
        if (getLocationIdByName(locationName) == null) {
            return createLocation(locationName);
        } else {
            return getLocationIdByName(locationName);
        }
    }

}