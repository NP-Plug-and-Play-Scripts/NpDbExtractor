/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naturalProductDbGui;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author ozing003
 */
public class NpDbGui extends javax.swing.JFrame {
    
    final DefaultListModel<String> model = new DefaultListModel<>();
    SqliteDBHandler sqlHandler = new SqliteDBHandler();
    private ArrayList<String> superClassList;
    private ArrayList<String> classList;
    private ArrayList<String> subClassList;
    
    /**
     * Creates new form NewJFrame
     */
    public NpDbGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        //Creates the label,textfield and file browser items for the gui
        setDBLabel = new javax.swing.JLabel();
        dbPathField = new javax.swing.JTextField();
        setDB = new javax.swing.JButton();
        browserButton = new javax.swing.JButton();
        //Creates the sslected classes label, textfield, remove and remove all buttons
        selectedClassesLabel = new javax.swing.JLabel();
        selectedClassesPane = new javax.swing.JScrollPane();
        selectedClassesList = new javax.swing.JList<>();
        remove = new javax.swing.JButton();
        removeAll = new javax.swing.JButton();
        //Creates the db result label, pane and table
        dbResultsLabel = new javax.swing.JLabel();
        tablePane = new javax.swing.JScrollPane();
        dbResultsTable = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        subClassAdd = new javax.swing.JButton();
        //Creates the superclass label, textfield and add buttons
        superClassSelectLabel = new javax.swing.JLabel();
        superClassSelect = new javax.swing.JComboBox();
        superClassAdd = new javax.swing.JButton();
        //Creates the class select label, textfield and class add button
        classSelectLabel = new javax.swing.JLabel();
        classSelect = new javax.swing.JComboBox();
        classAdd = new javax.swing.JButton();
        //Creates the subclass label, textfield and add buttons
        subClassSelectLabel = new javax.swing.JLabel();
        subClassSelect = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NpTree = new javax.swing.JTree();
        addSelectedClass = new javax.swing.JButton();
        startSearch = new javax.swing.JButton();
        dbGuiMenu = new javax.swing.JMenuBar();
        dbFileMenu = new javax.swing.JMenu();
        saveFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NP Database Extractor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        setDBLabel.setText("Set Database path");

        dbPathField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbPathFieldActionPerformed(evt);
            }
        });

        setDB.setText("Set Database");
        setDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDBActionPerformed(evt);
            }
        });

        browserButton.setText("file browser");
        browserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserButtonActionPerformed(evt);
            }
        });

        selectedClassesLabel.setText("Selected Classes");

        selectedClassesList.setModel(model);
        selectedClassesPane.setViewportView(selectedClassesList);

        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        removeAll.setText("Remove All");
        removeAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllActionPerformed(evt);
            }
        });

        dbResultsLabel.setText("Database Results");

        dbResultsTable.setModel(new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "SMILES", "Super Class", "Class", "Sub Class"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePane.setViewportView(dbResultsTable);

        subClassAdd.setText("Add");
        subClassAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subClassAddActionPerformed(evt);
            }
        });

        superClassSelectLabel.setText("Super-class Select");

        superClassSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                superClassSelectActionPerformed(evt);
            }
        });

        superClassAdd.setText("Add");
        superClassAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                superClassAddActionPerformed(evt);
            }
        });

        classSelectLabel.setText("Class Select");

        classSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classSelectActionPerformed(evt);
            }
        });

        classAdd.setText("Add");
        classAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classAddActionPerformed(evt);
            }
        });

        subClassSelectLabel.setText("Sub-class Select");

        subClassSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subClassSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(superClassSelectLabel)
                    .addComponent(subClassSelectLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(classSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(superClassSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subClassSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(classAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(superClassAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subClassAdd)))
                    .addComponent(classSelectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(superClassSelectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(superClassSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(superClassAdd))
                .addGap(18, 18, 18)
                .addComponent(classSelectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classAdd))
                .addGap(20, 20, 20)
                .addComponent(subClassSelectLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subClassSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subClassAdd))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        NpTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        NpTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NpTreeMouseClicked(evt);
            }
        });
        NpTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                NpTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(NpTree);

        addSelectedClass.setText("Add Selected ");
        addSelectedClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSelectedClassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
            .addComponent(addSelectedClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addSelectedClass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel4);

        startSearch.setEnabled(false);
        startSearch.setText("Search");
        startSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startSearchActionPerformed(evt);
            }
        });

        dbFileMenu.setText("File");
        dbFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbFileMenuActionPerformed(evt);
            }
        });

        saveFile.setText("Save File");
        saveFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveFileMouseClicked(evt);
            }
        });
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        dbFileMenu.add(saveFile);

        dbGuiMenu.add(dbFileMenu);

        setJMenuBar(dbGuiMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dbResultsLabel)
                    .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(removeAll, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dbPathField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(browserButton))
                            .addComponent(setDBLabel)
                            .addComponent(setDB)
                            .addComponent(selectedClassesLabel)
                            .addComponent(selectedClassesPane)
                            .addComponent(jTabbedPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(startSearch)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbResultsLabel)
                    .addComponent(setDBLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dbPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(browserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setDB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectedClassesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectedClassesPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(remove)
                            .addComponent(removeAll))
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tablePane, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        JFileChooser fc = new JFileChooser();   
        int returnVal = fc.showDialog(NpDbGui.this, "Attach");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            OutputWriter writer = new OutputWriter();
            File file = fc.getSelectedFile();
            writer.openFile(file);
            DefaultTableModel tModel  = (DefaultTableModel) dbResultsTable.getModel();
            int lineCount = tModel.getRowCount();
            for(int i=0; i < lineCount; i++){
                String writeLine = tModel.getValueAt(i,0) + "," + tModel.getValueAt(i,1);
                try {
                    writer.writeLine(writeLine);
                } catch (IOException ex) {
                    Logger.getLogger(NpDbGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                writer.closeFile();
            } catch (IOException ex) {
                Logger.getLogger(NpDbGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveFileActionPerformed

    private void saveFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveFileMouseClicked
        System.out.println("EGELS!");
    }//GEN-LAST:event_saveFileMouseClicked

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        ListSelectionModel selectionModel = selectedClassesList.getSelectionModel();
        int index = selectionModel.getMinSelectionIndex();
        if (index >= 0)
          this.model.remove(index);  
    }//GEN-LAST:event_removeActionPerformed

    private void classSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classSelectActionPerformed

    private void subClassSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subClassSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subClassSelectActionPerformed

    private void superClassSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_superClassSelectActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_superClassSelectActionPerformed

    private void classAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classAddActionPerformed
        model.addElement("class|" + (String) classSelect.getSelectedItem());
    }//GEN-LAST:event_classAddActionPerformed

    private void superClassAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_superClassAddActionPerformed
        model.addElement("super|" + (String) superClassSelect.getSelectedItem());
    }//GEN-LAST:event_superClassAddActionPerformed

    private void subClassAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subClassAddActionPerformed
        model.addElement("sub|" + (String) subClassSelect.getSelectedItem());
    }//GEN-LAST:event_subClassAddActionPerformed

    private void removeAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllActionPerformed
        this.model.removeAllElements();
    }//GEN-LAST:event_removeAllActionPerformed

    private void setDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDBActionPerformed
        File dbFile = new File(dbPathField.getText());
        if(dbFile.isFile()){
            if(dbPathField.getText().endsWith(".sqlite")){
                Connection con = sqlHandler.connect(dbPathField.getText());
                ResultSet rs = sqlHandler.runQuery(con, "select structure_id, smile, class, subclass,superclass from structure;");
                try {
                    if(rs.next()){
                        this.superClassList = createClassComboBoxData("select distinct(superclass) from structure;");
                        //changes the arraylist to a string array. the 0 indicates that it should be a string array.
                        String[] sortedSuperClassArray = superClassList.toArray(new String[superClassList.size()]);
                        //sort the array before adding it to the combobox
                        Arrays.sort(sortedSuperClassArray);
                        for(String molSuperClass : sortedSuperClassArray){
                            superClassSelect.addItem(molSuperClass);
                        }
                        AutoCompleteDecorator.decorate(superClassSelect);


                        this.classList = createClassComboBoxData("select distinct(class) from structure;");
                        //changes the arraylist to a string array. the 0 indicates that it should be a string array.
                        String[] sortedClassArray = classList.toArray(new String[classList.size()]);
                        //sort the array before adding it to the combobox
                        Arrays.sort(sortedClassArray);
                        for(String molClass : sortedClassArray){
                            classSelect.addItem(molClass);
                        }

                        AutoCompleteDecorator.decorate(classSelect);

                        this.subClassList = createClassComboBoxData("select distinct(subclass) from structure;");
                        //changes the arraylist to a string array. the 0 indicates that it should be a string array.
                        String[] sortedSubClassArray = subClassList.toArray(new String[subClassList.size()]);
                        //sort the array before adding it to the combobox
                        Arrays.sort(sortedSubClassArray);
                        for(String molSubClass : sortedSubClassArray){
                            subClassSelect.addItem(molSubClass);
                        }
                        AutoCompleteDecorator.decorate(subClassSelect);
                        DefaultTreeModel npTreeModel = NpTreeMaker();
                        NpTree.setModel(npTreeModel);
                        startSearch.setEnabled(true);
                    }else {
                        JOptionPane.showMessageDialog(null, "Database does not contain the correct columns!\nShould contain structure_id, smile, class, "
                                + "subclass and superclass.", "DB Content Warning",JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NpDbGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selected File is not a .sqlite file!","Wrong File Type Error", JOptionPane.ERROR_MESSAGE);
            }
           
        } else {
            JOptionPane.showMessageDialog(null, "Entered path does not lead to a existing file!\n","Not a File Error",JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_setDBActionPerformed

    private void browserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browserButtonActionPerformed
        JFileChooser input = new JFileChooser();
        int result = input.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            dbPathField.setText(input.getSelectedFile().toString());
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Cancel was selected");
        }
    }//GEN-LAST:event_browserButtonActionPerformed

    private void dbFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbFileMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dbFileMenuActionPerformed

    private void dbPathFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbPathFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dbPathFieldActionPerformed

    private void NpTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NpTreeMouseClicked

    }//GEN-LAST:event_NpTreeMouseClicked

    private void addSelectedClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSelectedClassActionPerformed
        String selectedNP = NpTree.getLastSelectedPathComponent().toString();
        if(classList.contains(selectedNP)){
            model.addElement("class|" + selectedNP);
        } else if(superClassList.contains(selectedNP)){
            model.addElement("super|" + selectedNP);
        } else {
            model.addElement("sub|" + selectedNP);
        }
        
        
    }//GEN-LAST:event_addSelectedClassActionPerformed

    private void NpTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_NpTreeValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_NpTreeValueChanged

    private void startSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startSearchActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel) dbResultsTable.getModel();
        int rowCount = tblModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }
        NPQueryMaker test = new NPQueryMaker();
        ArrayList<String> queryOutput = test.NPQueryMaker(model.toArray(),dbPathField.getText());
        Object[] tableInput = queryOutput.toArray();
        for(String rowEntry: queryOutput){
            Object[] splittedEntry = rowEntry.split("\\|");
            tblModel.addRow(splittedEntry);
        }
    }//GEN-LAST:event_startSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NpDbGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new NpDbGui().setVisible(true);
        });
    }
    /**
     * takes a query and turns it in to a result list containing the results of the query.
     * used to fill the comboboxes with the classes superclasses and subclasses.
     * @param query a query for the database in order to get a list of superclasses, classes, or subclasses
     * @return a list of strings containing (sub/super)class names 
     */
    private ArrayList createClassComboBoxData(String query){
        ArrayList resultList = new ArrayList();
        if(dbPathField.getText().isEmpty()){
            resultList.add("Noone");
        } else {
            Connection con = sqlHandler.connect(dbPathField.getText());
            ResultSet results = sqlHandler.runQuery(con, query); 
            try {
                while (results.next()) {
                    resultList.add(results.getString(1));
                }
            } catch (SQLException ex) {
                Logger.getLogger(NpDbGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlHandler.disconnect(con);
             
        }
        return resultList;
    }
    /**
     * creates a list of NpDbEntries with the given DB query.
     * @param query: query for the sqlite database 
     * @return a list of NpDbEntries.
     */
    private ArrayList<NpDbEntry> npObjectListMaker(String query){
        ArrayList<NpDbEntry> npObjectList = new ArrayList();
        //connects to the database
        Connection con = sqlHandler.connect(dbPathField.getText());
        //gets the results with the given query
        ResultSet results = sqlHandler.runQuery(con, query); 
        try {
            //while theres still lines in the results
            while (results.next()) {
                //create new NpDbObject with the results and add it to a list
                NpDbEntry object = new NpDbEntry(results.getString(1), results.getString(2), results.getString(3));
                npObjectList.add(object);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NpDbGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        sqlHandler.disconnect(con);
        //eturn the list of np objects.
        return npObjectList;
    }
    /**
     * fills the JTree model in the gui with all the superclasses classes and sub classes. it does so by taking the superclasses,
     * classes and subclasses from the database sorted on superclass class and finaly subclass. 
     * @return a filled model for the JTree
     */
    private DefaultTreeModel NpTreeMaker(){
        ArrayList<NpDbEntry> npEntryList = npObjectListMaker("select superclass, class, subclass from structure group by subclass order by superclass,class,subclass;");
        // new iterator that iterates over the npEntryList.
        Iterator npEntryListIter = npEntryList.iterator();
        //2 strings that will contain the previous SuperClass and Class
        String prevSuperClass = "";
        String prevClass = "";
        
        //new node the top which will be the root of the tree
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Natural Product DB");
        //another node this will be a superClass
        DefaultMutableTreeNode npSuperClass = null;
        // another one this will be a Class
        DefaultMutableTreeNode npClass  = null;

        //while the iterator still has another entry in the list.
        while (npEntryListIter.hasNext()) {
            //take next value as naturalProduct
            NpDbEntry naturalProduct = (NpDbEntry) npEntryListIter.next();
            //if the superclass name of naturalProduct does not equal the previous super class
            if (!naturalProduct.getNpSuperClass().equals(prevSuperClass)) {                
                //if npSuperClass is not null (first superclass to enter will pass this)
                if (npSuperClass != null) {  
                    //add the npSuperClasss to root
                    top.add(npSuperClass);
                }
                // create npSuperClass  node with the name of the superClass.
                npSuperClass = new DefaultMutableTreeNode(naturalProduct.getNpSuperClass());
                //set the name of the prevSuperClass as this superClass
                prevSuperClass = naturalProduct.getNpSuperClass();

            }
            //if name of the class does not equal the previous class
            if (!naturalProduct.getNpClass().equals(prevClass)) {  
                //if npClass is not null (first class to enter will pass this)
                if (npClass != null) {  
                    //add the previous NpClass to the superClass 
                    npSuperClass.add(npClass);
                }
                //npClass node is  made with the current class name
                npClass = new DefaultMutableTreeNode(naturalProduct.getNpClass());
                //set the name of the previous class to this one
                prevClass = naturalProduct.getNpClass();
            }
            //if the class does equal the previous class add the current subclass to the Class node
            npClass.add(new DefaultMutableTreeNode(naturalProduct.getNpSubClass()));
        }
        //if add the class to the superclass node. (does this if theres no more next in the iterator
        npSuperClass.add(npClass);
        //add the last superclass to the root
        top.add(npSuperClass);
        //creates a tree model with the root. the root now also contains all the info added.
        DefaultTreeModel boompje = new DefaultTreeModel(top);
        //return the tree model.
        return boompje;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree NpTree;
    private javax.swing.JButton addSelectedClass;
    private javax.swing.JButton browserButton;
    private javax.swing.JButton classAdd;
    private javax.swing.JComboBox<String> classSelect;
    private javax.swing.JLabel classSelectLabel;
    private javax.swing.JMenu dbFileMenu;
    private javax.swing.JMenuBar dbGuiMenu;
    private javax.swing.JTextField dbPathField;
    private javax.swing.JLabel dbResultsLabel;
    private javax.swing.JTable dbResultsTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton remove;
    private javax.swing.JButton removeAll;
    private javax.swing.JMenuItem saveFile;
    private javax.swing.JLabel selectedClassesLabel;
    private javax.swing.JList<String> selectedClassesList;
    private javax.swing.JScrollPane selectedClassesPane;
    private javax.swing.JButton setDB;
    private javax.swing.JLabel setDBLabel;
    private javax.swing.JButton startSearch;
    private javax.swing.JButton subClassAdd;
    private javax.swing.JComboBox<String> subClassSelect;
    private javax.swing.JLabel subClassSelectLabel;
    private javax.swing.JButton superClassAdd;
    private javax.swing.JComboBox<String> superClassSelect;
    private javax.swing.JLabel superClassSelectLabel;
    private javax.swing.JScrollPane tablePane;
    // End of variables declaration//GEN-END:variables
}


