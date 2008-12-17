/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StudentsAll.java
 *
 * Created on Dec 14, 2008, 6:00:16 AM
 */

package edu.sjsu.edo08f.gui;

import edu.sjsu.edo08f.services.StudentService;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.BeanRetriever;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author Anita
 */
public class StudentsAll extends javax.swing.JFrame {

    /** Creates new form StudentsAll */
    public StudentsAll() {
        initComponents();
    }

    /** This method is called from within the constructor to
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
   

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jLabel1.setText("CmpE 273 - Project");

          StudentService studentService = (StudentService) BeanRetriever.getBeanFactory().getBean("studentService");
        List<Student> students = studentService.getAll();
    JFrame frame = new JFrame("List of all students ");
    JPanel panel = new JPanel();
    //String data[][] = {{students.get(0).getId().toString(), students.get(0).getFirstName(), students.get(0).getLastName(),students.get(0).getAddress(),students.get(0).getCity(),students.get(0).getState(),students.get(0).getZipCode()}};
    String data[][] = {{null,null,null,null,null,null}};
    String col[] = {"Id", "FirstName", "Last Name", "Address", "City", "State", "Zip"};
    DefaultTableModel model = new DefaultTableModel(data,col);
    JTable table = new JTable(model);

        for (Student studentToBeDisplayed : students) {
       model.insertRow(table.getRowCount(),new Object[]{studentToBeDisplayed.getId(), studentToBeDisplayed.getFirstName(), studentToBeDisplayed.getLastName(),studentToBeDisplayed.getAddress(),studentToBeDisplayed.getCity(),studentToBeDisplayed.getState(),studentToBeDisplayed.getZipCode()});
     }
        panel.add(table);
    frame.add(panel);
    frame.setSize(300,300);
    frame.setVisible(true);
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentsAll().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;

    // End of variables declaration//GEN-END:variables

}
