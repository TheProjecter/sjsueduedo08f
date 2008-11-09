package edu.sjsu.edo08f.objectWrappers;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by: Alex Yarmula
 * Date: Nov 8, 2008
 */
public class XmlParsingError {

    private List<String> errors;

    public XmlParsingError() {
        errors = new ArrayList<String>();
    }

    public String getErrorMessage () {
        if (isEmpty()) return "No errors found.";

        String errorMessage = "";
        for (int i=0; i < errors.size(); i ++ ) {
            errorMessage += String.format ("%d. %s", i, errors.get(i));
        }

        return errorMessage;
    }

    public void add (String error) {
        errors.add(error);
    }

    public int size() {
        return errors.size();
    }

    public boolean isEmpty () {
        return errors.isEmpty();
    }

    public boolean isNotEmpty () {
        return ! isEmpty();
    }
}
