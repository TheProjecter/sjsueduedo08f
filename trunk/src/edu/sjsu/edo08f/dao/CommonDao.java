package edu.sjsu.edo08f.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

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
}
