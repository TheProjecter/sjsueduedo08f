package edu.sjsu.edo08f.dao;

import com.ibatis.sqlmap.client.extensions.*;
import java.sql.*;
import edu.sjsu.edo08f.exceptions.GeneralException;
import edu.sjsu.edo08f.support.DayOfWeek;

/**
 * Created by: Oleksiy Yarmula
 * Date: Nov 11, 2008
 */
public class DayOfWeekTypeHandler implements TypeHandlerCallback {

    public void setParameter(ParameterSetter parameterSetter, Object o) throws SQLException {
        if (o == null) {
            parameterSetter.setNull(Types.VARCHAR);
        } else {

            if (!(o instanceof DayOfWeek)) {
                throw new GeneralException("Expected type is DayOfWeek and found  " + o.getClass());
            }
            DayOfWeek day = (DayOfWeek) o;
            parameterSetter.setString(day.getShortcutName());

        }
    }

    public Object getResult(ResultGetter resultGetter) throws SQLException {

        String dayOfWeek = resultGetter.getString();
        if (dayOfWeek == null) throw new GeneralException("Illegal conversion: expected string representing day of week from database");
        if (DayOfWeek.isCorrectDayOfWeek(dayOfWeek)) {
            return DayOfWeek.getDayByShortcutName(dayOfWeek);
        } else {
            throw new GeneralException ("Data error in database: wrong enum type for day of week");
        }
    }

    public Object valueOf(String s) {
        return DayOfWeek.getDayByShortcutName(s);
    }
}
