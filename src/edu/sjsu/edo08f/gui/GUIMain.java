/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIMain.java
 *
 * Created on Dec 19, 2008, 3:31:34 AM
 */

package edu.sjsu.edo08f.gui;

/**
 *
 * @author francist
 */
public class GUIMain extends javax.swing.JFrame {

     public static boolean personFlag = false;
    /** Creates new form GUIMain */
    public GUIMain() {
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton_Student = new javax.swing.JButton();
        jButton_Person = new javax.swing.JButton();
        jButton_Course = new javax.swing.JButton();
        jButton_Instructor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane1.setName("jLayeredPane1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(MainApp.class).getContext().getResourceMap(GUIMain.class);
        jButton_Student.setFont(resourceMap.getFont("jButton_Student.font")); // NOI18N
        jButton_Student.setText(resourceMap.getString("jButton_Student.text")); // NOI18N
        jButton_Student.setName("jButton_Student"); // NOI18N
        jButton_Student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_StudentMouseClicked(evt);
            }
        });
        jButton_Student.setBounds(90, 200, 280, 30);
        jLayeredPane1.add(jButton_Student, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Person.setFont(resourceMap.getFont("jButton_Person.font")); // NOI18N
        jButton_Person.setText(resourceMap.getString("jButton_Person.text")); // NOI18N
        jButton_Person.setName("jButton_Person"); // NOI18N
        jButton_Person.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_PersonMouseClicked(evt);
            }
        });
        jButton_Person.setBounds(90, 50, 280, 30);
        jLayeredPane1.add(jButton_Person, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Course.setFont(resourceMap.getFont("jButton_Course.font")); // NOI18N
        jButton_Course.setText(resourceMap.getString("jButton_Course.text")); // NOI18N
        jButton_Course.setName("jButton_Course"); // NOI18N
        jButton_Course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_CourseMouseClicked(evt);
            }
        });
        jButton_Course.setBounds(90, 100, 280, 30);
        jLayeredPane1.add(jButton_Course, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Instructor.setFont(resourceMap.getFont("jButton_Instructor.font")); // NOI18N
        jButton_Instructor.setText(resourceMap.getString("jButton_Instructor.text")); // NOI18N
        jButton_Instructor.setName("jButton_Instructor"); // NOI18N
        jButton_Instructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_InstructorMouseClicked(evt);
            }
        });
        jButton_Instructor.setBounds(90, 150, 280, 30);
        jLayeredPane1.add(jButton_Instructor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_PersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_PersonMouseClicked
        // Person management:
	    JFramePerson person = new JFramePerson();
	    person.setVisible(true);
    }//GEN-LAST:event_jButton_PersonMouseClicked

    private void jButton_CourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CourseMouseClicked
        // Course management:
        JFrameCourse course = new JFrameCourse();
        course.setVisible(true);
    }//GEN-LAST:event_jButton_CourseMouseClicked

    private void jButton_InstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_InstructorMouseClicked
        // Instructor management:
         InstructorGUI instructorgui = new InstructorGUI();
    this.setVisible(false);
    personFlag = true;
    instructorgui.setVisible(true);
    }//GEN-LAST:event_jButton_InstructorMouseClicked

    private void jButton_StudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_StudentMouseClicked
        // Student management:
         StudentGUI studentgui = new StudentGUI();
    this.setVisible(false);
    personFlag=false;
    studentgui.setVisible(true);
    }//GEN-LAST:event_jButton_StudentMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Course;
    private javax.swing.JButton jButton_Instructor;
    private javax.swing.JButton jButton_Person;
    private javax.swing.JButton jButton_Student;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables

}
