package edu.sjsu.edo08f.support.converters;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.gui.CourseDataForGUI;

/**
 * Created by IntelliJ IDEA.
 * User: Tan Tan
 * Date: Dec 18, 2008
 * Time: 4:21:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class CourseXMLConverter implements Converter{
    public boolean canConvert(Class clazz) {
            return clazz.equals(CourseDataForGUI.class);
    }

    public void marshal(Object value, HierarchicalStreamWriter writer,
                    MarshallingContext context) {
        CourseDataForGUI course = (CourseDataForGUI) value;

        writer.startNode("id");
        writer.setValue(course.id);
        writer.endNode();

        writer.startNode("name");
        writer.setValue(course.name);
        writer.endNode();

        writer.startNode("sectione");
        writer.setValue(course.section);
        writer.endNode();

        writer.startNode("meeting-hours");
        writer.setValue(course.meetingHours);
        writer.endNode();

        writer.startNode("location");
        writer.setValue(course.location);
        writer.endNode();

        writer.startNode("units");
        writer.setValue(course.units);
        writer.endNode();

    }

    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        CourseDataForGUI course = new CourseDataForGUI();

        reader.moveDown();
        course.id = reader.getValue();
        reader.moveUp();

        reader.moveDown();
        course.name = reader.getValue();
        reader.moveUp();

        reader.moveDown();
        course.section = reader.getValue();
        reader.moveUp();

        reader.moveDown();
        course.meetingHours = reader.getValue();
        reader.moveUp();

        reader.moveDown();
        course.location = reader.getValue();
        reader.moveUp();

        reader.moveDown();
        course.units = reader.getValue();
        reader.moveUp();

        return course;
    }
}
