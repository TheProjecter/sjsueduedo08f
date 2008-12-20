/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFrameCourse.java
 *
 * Created on Dec 13, 2008, 2:15:50 AM
 */

package edu.sjsu.edo08f.gui;

import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.support.converters.ConvertFromXML;
import javax.jms.JMSException;
/**
 *
 * @author Tan Tan
 */
public class JFrameCourse extends javax.swing.JFrame {

    /** Creates new form JFrameCourse */
    public JFrameCourse() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Section = new javax.swing.JTextField();
        jTextField_MeetingHours = new javax.swing.JTextField();
        jTextField_Id = new javax.swing.JTextField();
        jTextField_Name = new javax.swing.JTextField();
        jTextField_Location = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Units = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton_Delete = new javax.swing.JButton();
        jButton_Change = new javax.swing.JButton();
        jButton_New = new javax.swing.JButton();
        jButton_Clear = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jComboBox_SearchName = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1_SearchValue = new javax.swing.JTextField();
        jButton_Search = new javax.swing.JButton();
        jButton_GetAll = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCourseResultList = new javax.swing.JTable();
        jButton_getPerson = new javax.swing.JButton();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1ResultList1 = new javax.swing.JTable();
        jButton_Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(MainApp.class).getContext().getResourceMap(JFrameCourse.class);
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jLayeredPane1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jLayeredPane1.border.titleFont"))); // NOI18N
        jLayeredPane1.setName("jLayeredPane1"); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setBounds(20, 30, 100, 14);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jLabel2.setBounds(20, 70, 100, 14);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        jLabel3.setBounds(20, 90, 100, 14);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        jLabel4.setBounds(20, 130, 100, 14);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_Section.setText(resourceMap.getString("jTextField_Section.text")); // NOI18N
        jTextField_Section.setName("jTextField_Section"); // NOI18N
        jTextField_Section.setBounds(160, 70, 173, 20);
        jLayeredPane1.add(jTextField_Section, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_MeetingHours.setText(resourceMap.getString("jTextField_MeetingHours.text")); // NOI18N
        jTextField_MeetingHours.setName("jTextField_MeetingHours"); // NOI18N
        jTextField_MeetingHours.setBounds(160, 90, 173, 20);
        jLayeredPane1.add(jTextField_MeetingHours, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_Id.setText(resourceMap.getString("jTextField_Id.text")); // NOI18N
        jTextField_Id.setName("jTextField_Id"); // NOI18N
        jTextField_Id.setBounds(160, 30, 173, 20);
        jLayeredPane1.add(jTextField_Id, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_Name.setText(resourceMap.getString("jTextField_Name.text")); // NOI18N
        jTextField_Name.setName("jTextField_Name"); // NOI18N
        jTextField_Name.setBounds(160, 50, 173, 20);
        jLayeredPane1.add(jTextField_Name, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_Location.setText(resourceMap.getString("jTextField_Location.text")); // NOI18N
        jTextField_Location.setName("jTextField_Location"); // NOI18N
        jTextField_Location.setBounds(160, 110, 173, 20);
        jLayeredPane1.add(jTextField_Location, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setBounds(20, 110, 100, 14);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_Units.setText(resourceMap.getString("jTextField_Units.text")); // NOI18N
        jTextField_Units.setName("jTextField_Units"); // NOI18N
        jTextField_Units.setBounds(160, 130, 173, 20);
        jLayeredPane1.add(jTextField_Units, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        jLabel8.setBounds(20, 50, 100, 14);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Delete.setText(resourceMap.getString("jButton_Delete.text")); // NOI18N
        jButton_Delete.setName("jButton_Delete"); // NOI18N
        jButton_Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_DeleteMouseClicked(evt);
            }
        });
        jButton_Delete.setBounds(460, 120, 138, 23);
        jLayeredPane1.add(jButton_Delete, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Change.setText(resourceMap.getString("jButton_Change.text")); // NOI18N
        jButton_Change.setName("jButton_Change"); // NOI18N
        jButton_Change.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ChangeMouseClicked(evt);
            }
        });
        jButton_Change.setBounds(460, 90, 138, 23);
        jLayeredPane1.add(jButton_Change, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_New.setText(resourceMap.getString("jButton_New.text")); // NOI18N
        jButton_New.setName("jButton_New"); // NOI18N
        jButton_New.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_NewMouseClicked(evt);
            }
        });
        jButton_New.setBounds(460, 60, 138, 23);
        jLayeredPane1.add(jButton_New, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Clear.setText(resourceMap.getString("jButton_Clear.text")); // NOI18N
        jButton_Clear.setName("jButton_Clear"); // NOI18N
        jButton_Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ClearMouseClicked(evt);
            }
        });
        jButton_Clear.setBounds(460, 30, 138, 23);
        jLayeredPane1.add(jButton_Clear, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jLayeredPane4.border.title"))); // NOI18N
        jLayeredPane4.setName("jLayeredPane4"); // NOI18N

        jComboBox_SearchName.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Course ID", "Name", "Section", "Meeting Hours", "Location", "Units" }));
        jComboBox_SearchName.setName("jComboBox_SearchName"); // NOI18N
        jComboBox_SearchName.setBounds(90, 20, 148, 20);
        jLayeredPane4.add(jComboBox_SearchName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        jLabel5.setBounds(20, 20, 60, 20);
        jLayeredPane4.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setBounds(270, 20, 40, 20);
        jLayeredPane4.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField1_SearchValue.setName("jTextField1_SearchValue"); // NOI18N
        jTextField1_SearchValue.setBounds(320, 20, 120, 20);
        jLayeredPane4.add(jTextField1_SearchValue, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Search.setText(resourceMap.getString("jButton_Search.text")); // NOI18N
        jButton_Search.setName("jButton_Search"); // NOI18N
        jButton_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SearchMouseClicked(evt);
            }
        });
        jButton_Search.setBounds(487, 20, 100, 23);
        jLayeredPane4.add(jButton_Search, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_GetAll.setText(resourceMap.getString("jButton_GetAll.text")); // NOI18N
        jButton_GetAll.setName("jButton_GetAll"); // NOI18N
        jButton_GetAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_GetAllMouseClicked(evt);
            }
        });
        jButton_GetAll.setBounds(630, 20, 80, 23);
        jLayeredPane4.add(jButton_GetAll, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jLayeredPane3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jLayeredPane3.border.titleFont"))); // NOI18N
        jLayeredPane3.setName("jLayeredPane3"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTableCourseResultList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Section", "Meeting Hours", "Location", "Units"
            }
        ));
        jTableCourseResultList.setName("jTableCourseResultList"); // NOI18N
        jTableCourseResultList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCourseResultListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCourseResultList);

        jScrollPane2.setBounds(20, 20, 690, 140);
        jLayeredPane3.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_getPerson.setText(resourceMap.getString("jButton_getPerson.text")); // NOI18N
        jButton_getPerson.setName("jButton_getPerson"); // NOI18N
        jButton_getPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_getPersonMouseClicked(evt);
            }
        });

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jLayeredPane5.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jLayeredPane5.border.titleFont"))); // NOI18N
        jLayeredPane5.setName("jLayeredPane5"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1ResultList1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code", "Type"
            }
        ));
        jTable1ResultList1.setName("jTable1ResultList1"); // NOI18N
        jTable1ResultList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1ResultList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1ResultList1);

        jScrollPane1.setBounds(20, 20, 690, 140);
        jLayeredPane5.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Back.setText(resourceMap.getString("jButton_Back.text")); // NOI18N
        jButton_Back.setName("jButton_Back"); // NOI18N
        jButton_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_BackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton_getPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addComponent(jButton_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_getPerson)
                    .addComponent(jButton_Back))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SearchMouseClicked
        CourseClient courseClient = new CourseClient();
        ConvertFromXML convert = new ConvertFromXML();
        String xml = new String();

       String selectedFieldName = (String)jComboBox_SearchName.getSelectedItem();
       String fieldName = new String();
                String fieldValue = new String();
                if (selectedFieldName.equals( "Course ID" )){
                    fieldName = "id";
                }else if (selectedFieldName.equals("Name")){
                    fieldName = "name";
                }else if (selectedFieldName.equals("Section")){
                    fieldName = "section";
                }else if (selectedFieldName.equals("Meeting Hours")){
                    fieldName = "metting-hours";
                }else if (selectedFieldName.equals("Location")){
                    fieldName = "location";
                }else if (selectedFieldName.equals("Units")){
                    fieldName = "units";
                }
                fieldValue = jTextField1_SearchValue.getText();
                try {
        //            if (fieldName == "id"){
        //                xml = courseClient.getById(fieldValue);
        //            }else{
                        xml = courseClient.search(fieldName, fieldValue);
        //            }
                    System.out.println(xml);
                    String[][] CourseTable = convert.CourseConvertFromXML(xml);
                    System.out.println(xml);

                    jTableCourseResultList.setModel(new javax.swing.table.DefaultTableModel( CourseTable,
                        new String [] {"ID", "Name", "Section", "Meeting Hours", "Location", "Units"} ));

                } catch (JMSException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
}//GEN-LAST:event_jButton_SearchMouseClicked

    private void jButton_GetAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_GetAllMouseClicked
        CourseClient courseClient = new CourseClient();
        ConvertFromXML convert = new ConvertFromXML();
        String xml = new String();
        try {
            xml = courseClient.getAll();
            String[][] CourseTable = convert.CourseConvertFromXML(xml);
            jTableCourseResultList.setModel(new javax.swing.table.DefaultTableModel( CourseTable,
                new String [] {"ID", "Name", "Section", "Meeting Hours", "Location", "Units"} ));
            } catch (JMSException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            System.out.println(xml);
}//GEN-LAST:event_jButton_GetAllMouseClicked


    private void jTableCourseResultListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCourseResultListMouseClicked
        //        PersonClient personclient = new PersonClient();
        //        ConvertFromXML convert = new ConvertFromXML();
        //        String xml = new String();
        //        if (evt.getClickCount() == 2) {
        javax.swing.JTable target = (javax.swing.JTable)evt.getSource();
        int row = target.getSelectedRow();

        jTextField_Id.setText((String)target.getValueAt(row, 0));
        jTextField_Name.setText((String)target.getValueAt(row, 1));
        jTextField_Section.setText((String)target.getValueAt(row, 2));
        jTextField_MeetingHours.setText((String)target.getValueAt(row, 3));
        jTextField_Location.setText((String)target.getValueAt(row, 4));
        jTextField_Units.setText((String)target.getValueAt(row, 5));

        String id = (String)target.getValueAt(row, 0);
        System.out.println("row: " + row + "Id: " + id);

        //            try {
        ////            if (fieldName == "id"){
        ////                xml = personclient.getById(fieldValue);
        ////            }else{
        //                xml = personclient.search(fieldName, fieldValue);
        ////            }
        //            String[][] PersonTable = convert.PersonConvertFromXML(xml);
        //            System.out.println(xml);
        //
        //            jTable1ResultList.setModel(new javax.swing.table.DefaultTableModel( PersonTable,
        //                new String [] {"ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code"} ));
        //
        //            } catch (JMSException e) {
        //                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        //            }
        //        }
}//GEN-LAST:event_jTableCourseResultListMouseClicked

    private void jButton_ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ClearMouseClicked

        jTextField_Id.setText("");
        jTextField_Name.setText("");
        jTextField_Section.setText("");
        jTextField_MeetingHours.setText("");
        jTextField_Location.setText("");
        jTextField_Units.setText("");

        jTableCourseResultList.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
        },
                new String [] {
            "ID", "Name", "Section", "Meeting Hours", "Location", "Units" }
        ));

        jTable1ResultList1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code", "Type" }
        ));
    }//GEN-LAST:event_jButton_ClearMouseClicked

    private void jButton_NewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_NewMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_jButton_NewMouseClicked

    private void jButton_ChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ChangeMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_jButton_ChangeMouseClicked

    private void jButton_DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_DeleteMouseClicked
        // TODO add your handling code here:
}//GEN-LAST:event_jButton_DeleteMouseClicked

    private void jButton_getPersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_getPersonMouseClicked
        // TODO add your handling code here:
        CourseClient courseClient = new CourseClient();
        ConvertFromXML convert = new ConvertFromXML();
        String xml = new String();
        try {
            xml = courseClient.getPersonByCourse(
                               jTextField_Id.getText(),
                               jTextField_Name.getText(),
                               jTextField_Section.getText(),
                               jTextField_MeetingHours.getText(),
                               jTextField_Location.getText(),
                               jTextField_Units.getText()
                                                );
            String[][] PersonTable = convert.PersonConvertFromXML(xml);
            jTable1ResultList1.setModel(new javax.swing.table.DefaultTableModel( PersonTable,
                new String [] {"ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code", "Type"} ));
            } catch (JMSException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

}//GEN-LAST:event_jButton_getPersonMouseClicked

    private void jTable1ResultList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1ResultList1MouseClicked
        //        PersonClient personclient = new PersonClient();
        //        ConvertFromXML convert = new ConvertFromXML();
        //        String xml = new String();
        //        if (evt.getClickCount() == 2) {
        javax.swing.JTable target = (javax.swing.JTable)evt.getSource();
        int row = target.getSelectedRow();
        jTextField_Id.setText((String)target.getValueAt(row, 0));
        jTextField_Name.setText((String)target.getValueAt(row, 1));
        jTextField_Section.setText((String)target.getValueAt(row, 2));
        jTextField_MeetingHours.setText((String)target.getValueAt(row, 3));
        jTextField_Location.setText((String)target.getValueAt(row, 4));
        jTextField_Units.setText((String)target.getValueAt(row, 5));
        
        String id = (String)target.getValueAt(row, 0);
        System.out.println("row: " + row + "Id: " + id);

        //            try {
        ////            if (fieldName == "id"){
        ////                xml = personclient.getById(fieldValue);
        ////            }else{
        //                xml = personclient.search(fieldName, fieldValue);
        ////            }
        //            String[][] PersonTable = convert.PersonConvertFromXML(xml);
        //            System.out.println(xml);
        //
        //            jTable1ResultList.setModel(new javax.swing.table.DefaultTableModel( PersonTable,
        //                new String [] {"ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code"} ));
        //
        //            } catch (JMSException e) {
        //                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        //            }
        //        }
    }//GEN-LAST:event_jTable1ResultList1MouseClicked

    private void jButton_BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_BackMouseClicked
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButton_BackMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameCourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Change;
    private javax.swing.JButton jButton_Clear;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_GetAll;
    private javax.swing.JButton jButton_New;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JButton jButton_getPerson;
    private javax.swing.JComboBox jComboBox_SearchName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1ResultList1;
    private javax.swing.JTable jTableCourseResultList;
    private javax.swing.JTextField jTextField1_SearchValue;
    private javax.swing.JTextField jTextField_Id;
    private javax.swing.JTextField jTextField_Location;
    private javax.swing.JTextField jTextField_MeetingHours;
    private javax.swing.JTextField jTextField_Name;
    private javax.swing.JTextField jTextField_Section;
    private javax.swing.JTextField jTextField_Units;
    // End of variables declaration//GEN-END:variables

}
