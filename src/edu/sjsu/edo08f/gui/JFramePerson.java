/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFramePerson.java
 *
 * Created on Dec 12, 2008, 4:03:50 PM
 */

package edu.sjsu.edo08f.gui;

import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.support.converters.ConvertFromXML;
import javax.jms.JMSException;

/**
 *
 * @author francist
 */
public class JFramePerson extends javax.swing.JFrame {

    /** Creates new form JFramePerson */
    public JFramePerson() {
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

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jButton_Clear = new javax.swing.JButton();
        jButton_Save = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_CourseList = new javax.swing.JTable();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_PersonType = new javax.swing.JTextField();
        jTextField_ZipCode = new javax.swing.JTextField();
        jTextField_State = new javax.swing.JTextField();
        jTextField_City = new javax.swing.JTextField();
        jTextField_Address = new javax.swing.JTextField();
        jTextField_LastName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_FirstName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_PersonID = new javax.swing.JTextField();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1ResultList = new javax.swing.JTable();
        jButton_Back = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jComboBox_SearchName = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1_SearchValue = new javax.swing.JTextField();
        jButton_Search = new javax.swing.JButton();
        jButton_GetAll = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jFrame1.setName("jFrame1"); // NOI18N

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jFrame2.setName("jFrame2"); // NOI18N

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jFrame3.setName("jFrame3"); // NOI18N

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jDialog1.setName("jDialog1"); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(MainApp.class).getContext().getResourceMap(JFramePerson.class);
        jButton_Clear.setText(resourceMap.getString("jButton_Clear.text")); // NOI18N
        jButton_Clear.setName("jButton_Clear"); // NOI18N
        jButton_Clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_ClearMouseClicked(evt);
            }
        });

        jButton_Save.setText(resourceMap.getString("jButton_Save.text")); // NOI18N
        jButton_Save.setName("jButton_Save"); // NOI18N
        jButton_Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SaveMouseClicked(evt);
            }
        });

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jLayeredPane1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jLayeredPane1.border.titleFont"))); // NOI18N
        jLayeredPane1.setName("jLayeredPane1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable_CourseList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Section", "Meeting Times", "Location"
            }
        ));
        jTable_CourseList.setEnabled(false);
        jTable_CourseList.setName("jTable_CourseList"); // NOI18N
        jScrollPane2.setViewportView(jTable_CourseList);
        jTable_CourseList.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("jTable_CourseList.columnModel.title0")); // NOI18N
        jTable_CourseList.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable_CourseList.columnModel.title1")); // NOI18N
        jTable_CourseList.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable_CourseList.columnModel.title2")); // NOI18N
        jTable_CourseList.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable_CourseList.columnModel.title3")); // NOI18N

        jScrollPane2.setBounds(20, 20, 370, 160);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jLayeredPane2.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jLayeredPane2.border.titleFont"))); // NOI18N
        jLayeredPane2.setName("jLayeredPane2"); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        jLabel4.setBounds(20, 80, 80, 20);
        jLayeredPane2.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N
        jLabel8.setBounds(20, 60, 80, 20);
        jLayeredPane2.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setBounds(20, 120, 80, 20);
        jLayeredPane2.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        jLabel3.setBounds(20, 140, 80, 20);
        jLayeredPane2.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        jLabel9.setBounds(20, 160, 80, 20);
        jLayeredPane2.add(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N
        jLabel5.setBounds(20, 100, 80, 20);
        jLayeredPane2.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_PersonType.setText(resourceMap.getString("jTextField_PersonType.text")); // NOI18N
        jTextField_PersonType.setName("jTextField_PersonType"); // NOI18N
        jTextField_PersonType.setBounds(110, 160, 179, 20);
        jLayeredPane2.add(jTextField_PersonType, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_ZipCode.setText(resourceMap.getString("jTextField_ZipCode.text")); // NOI18N
        jTextField_ZipCode.setName("jTextField_ZipCode"); // NOI18N
        jTextField_ZipCode.setBounds(110, 140, 179, 20);
        jLayeredPane2.add(jTextField_ZipCode, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_State.setText(resourceMap.getString("jTextField_State.text")); // NOI18N
        jTextField_State.setName("jTextField_State"); // NOI18N
        jTextField_State.setBounds(110, 120, 179, 20);
        jLayeredPane2.add(jTextField_State, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_City.setText(resourceMap.getString("jTextField_City.text")); // NOI18N
        jTextField_City.setName("jTextField_City"); // NOI18N
        jTextField_City.setBounds(110, 100, 179, 20);
        jLayeredPane2.add(jTextField_City, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_Address.setText(resourceMap.getString("jTextField_Address.text")); // NOI18N
        jTextField_Address.setName("jTextField_Address"); // NOI18N
        jTextField_Address.setBounds(110, 80, 179, 20);
        jLayeredPane2.add(jTextField_Address, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_LastName.setText(resourceMap.getString("jTextField_LastName.text")); // NOI18N
        jTextField_LastName.setName("jTextField_LastName"); // NOI18N
        jTextField_LastName.setBounds(110, 60, 179, 20);
        jLayeredPane2.add(jTextField_LastName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setBounds(20, 40, 80, 20);
        jLayeredPane2.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_FirstName.setText(resourceMap.getString("jTextField_FirstName.text")); // NOI18N
        jTextField_FirstName.setName("jTextField_FirstName"); // NOI18N
        jTextField_FirstName.setBounds(110, 40, 179, 20);
        jLayeredPane2.add(jTextField_FirstName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setBounds(20, 20, 80, 20);
        jLayeredPane2.add(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_PersonID.setEditable(false);
        jTextField_PersonID.setText(resourceMap.getString("jTextField_PersonID.text")); // NOI18N
        jTextField_PersonID.setName("jTextField_PersonID"); // NOI18N
        jTextField_PersonID.setBounds(110, 20, 180, 20);
        jLayeredPane2.add(jTextField_PersonID, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jLayeredPane3.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jLayeredPane3.border.titleFont"))); // NOI18N
        jLayeredPane3.setName("jLayeredPane3"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1ResultList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code"
            }
        ));
        jTable1ResultList.setEnabled(false);
        jTable1ResultList.setName("jTable1ResultList"); // NOI18N
        jScrollPane1.setViewportView(jTable1ResultList);
        jTable1ResultList.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("jTable1ResultList.columnModel.title1")); // NOI18N
        jTable1ResultList.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("jTable1ResultList.columnModel.title2")); // NOI18N
        jTable1ResultList.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("jTable1ResultList.columnModel.title3")); // NOI18N
        jTable1ResultList.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("jTable1ResultList.columnModel.title4")); // NOI18N
        jTable1ResultList.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("jTable1ResultList.columnModel.title5")); // NOI18N
        jTable1ResultList.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("jTable1ResultList.columnModel.title6")); // NOI18N

        jScrollPane1.setBounds(20, 20, 690, 140);
        jLayeredPane3.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Back.setText(resourceMap.getString("jButton_Back.text")); // NOI18N
        jButton_Back.setName("jButton_Back"); // NOI18N
        jButton_Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_BackMouseClicked(evt);
            }
        });

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("jLayeredPane4.border.title"))); // NOI18N
        jLayeredPane4.setName("jLayeredPane4"); // NOI18N

        jComboBox_SearchName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Person ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code" }));
        jComboBox_SearchName.setName("jComboBox_SearchName"); // NOI18N
        jComboBox_SearchName.setBounds(90, 20, 148, 20);
        jLayeredPane4.add(jComboBox_SearchName, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jLabel1.setBounds(20, 20, 60, 20);
        jLayeredPane4.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jLabel2.setBounds(270, 20, 40, 20);
        jLayeredPane4.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField1_SearchValue.setText(resourceMap.getString("jTextField1_SearchValue.text")); // NOI18N
        jTextField1_SearchValue.setName("jTextField1_SearchValue"); // NOI18N
        jTextField1_SearchValue.setBounds(310, 20, 120, 20);
        jLayeredPane4.add(jTextField1_SearchValue, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Search.setText(resourceMap.getString("jButton_Search.text")); // NOI18N
        jButton_Search.setName("jButton_Search"); // NOI18N
        jButton_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_SearchMouseClicked(evt);
            }
        });
        jButton_Search.setBounds(470, 20, 67, 23);
        jLayeredPane4.add(jButton_Search, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_GetAll.setText(resourceMap.getString("jButton_GetAll.text")); // NOI18N
        jButton_GetAll.setName("jButton_GetAll"); // NOI18N
        jButton_GetAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_GetAllMouseClicked(evt);
            }
        });
        jButton_GetAll.setBounds(560, 20, 70, 23);
        jLayeredPane4.add(jButton_GetAll, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton8.setText(resourceMap.getString("jButton8.text")); // NOI18N
        jButton8.setName("jButton8"); // NOI18N

        jButton7.setText(resourceMap.getString("jButton7.text")); // NOI18N
        jButton7.setName("jButton7"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Back)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane1)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Back)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton_Save)
                    .addComponent(jButton_Clear))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ClearMouseClicked

        jTextField_PersonID.setText("");
        jTextField_FirstName.setText("");
        jTextField_LastName.setText("");
        jTextField_Address.setText("");
        jTextField_City.setText("");
        jTextField_State.setText("");
        jTextField_ZipCode.setText("");
        jTextField_PersonType.setText("");

        jTable1ResultList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code"
            }
        ));

       jTable_CourseList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Section", "Meeting Times", "Location"
            }
        ));

}//GEN-LAST:event_jButton_ClearMouseClicked

    private void jButton_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SearchMouseClicked
        PersonClient personclient = new PersonClient();
        ConvertFromXML convert = new ConvertFromXML();
        String xml = new String();

        String selectedFieldName = (String)jComboBox_SearchName.getSelectedItem();
        String fieldName = new String();
        String fieldValue = new String();
        if (selectedFieldName ==  "Person ID"){
            fieldName = "id";
        }else if (selectedFieldName ==  "First Name"){
            fieldName = "firstName";
        }else if (selectedFieldName ==  "Last Name"){
            fieldName = "lastName";
        }else if (selectedFieldName ==  "Address"){
            fieldName = "address";
        }else if (selectedFieldName ==  "City"){
            fieldName = "city";
        }else if (selectedFieldName ==  "State"){
            fieldName = "state";
        }else if (selectedFieldName ==  "Zip Code"){
            fieldName = "zipCode";
        }else if (selectedFieldName ==  "Type"){
            fieldName = "type";
        }
        fieldValue = jTextField1_SearchValue.getText();
        try {
            if (fieldName == "id"){
                xml = personclient.getById(fieldValue);
            }else{
                xml = personclient.search(fieldValue, fieldValue);
            }
            xml = personclient.getAll();
            String[][] PersonTable = convert.PersonConvertFromXML(xml);
            jTable1ResultList.setModel(new javax.swing.table.DefaultTableModel( PersonTable,
                new String [] {"ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code"} ));
        } catch (JMSException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

//        jTable_CourseList.setValueAt("aaa", 1, 1);
    }//GEN-LAST:event_jButton_SearchMouseClicked

    private void jButton_BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_BackMouseClicked
        // TODO add your handling code here:
        //MainApp.getApplication().hide(this);
        //this.removeAll();
        this.dispose();
}//GEN-LAST:event_jButton_BackMouseClicked

    private void jButton_GetAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_GetAllMouseClicked
        PersonClient personclient = new PersonClient();
        ConvertFromXML convert = new ConvertFromXML();
        String xml = new String();
        try {
            xml = personclient.getAll();
            String[][] PersonTable = convert.PersonConvertFromXML(xml);
            jTable1ResultList.setModel(new javax.swing.table.DefaultTableModel( PersonTable,
                new String [] {"ID", "First Name", "Last Name", "Address", "City", "State", "Zip Code"} ));
        } catch (JMSException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(xml);
    }//GEN-LAST:event_jButton_GetAllMouseClicked

    private void jButton_SaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_SaveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SaveMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePerson().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Clear;
    private javax.swing.JButton jButton_GetAll;
    private javax.swing.JButton jButton_Save;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JComboBox jComboBox_SearchName;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1ResultList;
    private javax.swing.JTable jTable_CourseList;
    private javax.swing.JTextField jTextField1_SearchValue;
    private javax.swing.JTextField jTextField_Address;
    private javax.swing.JTextField jTextField_City;
    private javax.swing.JTextField jTextField_FirstName;
    private javax.swing.JTextField jTextField_LastName;
    private javax.swing.JTextField jTextField_PersonID;
    private javax.swing.JTextField jTextField_PersonType;
    private javax.swing.JTextField jTextField_State;
    private javax.swing.JTextField jTextField_ZipCode;
    // End of variables declaration//GEN-END:variables

}
