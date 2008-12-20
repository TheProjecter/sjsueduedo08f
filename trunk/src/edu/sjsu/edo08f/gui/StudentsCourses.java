/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StudentsCourses.java
 *
 * Created on Dec 14, 2008, 6:00:16 AM
 */

package edu.sjsu.edo08f.gui;

import edu.sjsu.edo08f.services.StudentService;
import edu.sjsu.edo08f.services.PersonService;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.BeanRetriever;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.List;

/**
 * @author Anita
 */
public class StudentsCourses extends javax.swing.JFrame {


    public static String firstname;
   //  public static String lastname;

    /**
     * Creates new form StudentSearch
     */
    public StudentsCourses(String firstname) {
        this.firstname = firstname;
       // this.lastname = lastname;

        initComponents();
    }

    public void getAttributes(ArrayList studentSearch) {


        System.out.println("Array check : " + firstname);

    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {


        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jLabel1.setText("CmpE 273 - Project");

        PersonService personService = (PersonService) BeanRetriever.getBeanFactory().getBean("personService");
        List<Person> person = personService.search("last-name", firstname);
        StudentService studentService = (StudentService) BeanRetriever.getBeanFactory().getBean("studentService");

        System.out.println(firstname);

        JFrame frame = new JFrame("List of Associated Courses ");
        String data[][] = {{"CourseName ", "CourseSection", "Units"}};
        String col[] = {"CourseName ", "CourseSection", "Units"};
        DefaultTableModel model = new DefaultTableModel(data, col);
        JTable table = new JTable(model);

        if (person.size() == 1) {
            for (Person personToBeDisplayed : person) {

                Student student = studentService.getById(personToBeDisplayed.getId());
                List<Course> course = studentService.getAssociatedCourses(student);
                for (Course courseToBeDisplayed : course) {
                    model.insertRow(table.getRowCount(), new Object[]{courseToBeDisplayed.getName(), courseToBeDisplayed.getSection(), courseToBeDisplayed.getUnits()});

                }
            }
        } else {
            System.out.println("Cant find a unique student");
        }



    frame.add(table);
    frame.setSize(600,300);
    frame.setVisible(true);
}// </editor-fold>//GEN-END:initComponents

/**
 * @param args the command line arguments
 */
public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable(){
public void run(){
        new StudentsCourses("No Input");

}
        });
}

// Variables declaration - do not modify//GEN-BEGIN:variables
private javax.swing.JLabel jLabel1;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JSeparator jSeparator3;

// End of variables declaration//GEN-END:variables

}