package edu.sjsu.edo08f.support.converters;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import edu.sjsu.edo08f.support.EventInformation;
import edu.sjsu.edo08f.support.ParserUtils;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by: Oleksiy Yarmula
 * Date: Dec 6, 2008
 */
public class EventInformationConverter implements Converter {

    public boolean canConvert(Class clazz) {
        return (clazz.equals(ArrayList.class));
    }

    public void marshal(Object value, HierarchicalStreamWriter writer,
                        MarshallingContext context) {

        List<EventInformation> eventInformation = (List<EventInformation>) value;
        if (eventInformation != null && eventInformation.size() > 0) {
            String parsedEventInfo = ParserUtils.convertOfficeHoursToLines(eventInformation).get(0);
            writer.setValue(parsedEventInfo);
        } else {
            writer.setValue("");
        }

    }

    public Object unmarshal(HierarchicalStreamReader reader,
                            UnmarshallingContext context) {
        return null;
    }

}