/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import hw2.Operands.Instruction;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author cahn
 */
public class MainDisplay extends javax.swing.JFrame {

    private String instructionRaw = new String();
    private String[] instructionLines = new String[300];
    private final ArrayList<Instruction> instructions = new ArrayList<>();
    private int instructionIndex;
    public static final int REGISTER_TABLE_VALUE = 2;
    public static final int MEMORY_TABLE_VALUE = 1;
    private final String[][] memoryModelTable = new String[128][9];
    private final TableModel memoryModel;
    public final static String[] REGISTER_NAMES
            = {"$zero", "$at", "$v0", "$v1",
                "$a0", "$a1", "$a2", "$a3", "$t0",
                "$t1", "$t2", "$t3", "$t4", "$t5",
                "$t6", "$t7", "$s0", "$s1", "$s2",
                "$s3", "$s4", "$s5", "$s6",
                "$k0", "$k1", "$gp", "$sp",
                "$fp", "$ra", "pc", "hi", "lo"};
    public final static String[] REGISTER_VALUES = new String[REGISTER_NAMES.length];

    public final int EditPage = 0;
    public final int OpcodePage = 1;

    /**
     * Creates new form MainDisplay
     */
    public MainDisplay() {
        memoryModel = CreateMemoryModel();
        initComponents();
        initModels();
        stepOneButton.setEnabled(false);
        runButton.setEnabled(false);

        for (int i = 0; i < REGISTER_VALUES.length; i++) {
            REGISTER_VALUES[i] = Integer.toBinaryString(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        compileButton = new javax.swing.JButton();
        stepOneButton = new javax.swing.JButton();
        runButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        textEditor = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        codeModel = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        memoryTable = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        registerBuffer = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        compileButton.setText("Compile");
        compileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compileButtonActionPerformed(evt);
            }
        });

        stepOneButton.setText("Step One");
        stepOneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stepOneButtonMouseClicked(evt);
            }
        });
        stepOneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepOneButtonActionPerformed(evt);
            }
        });

        runButton.setText("Run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        textEditor.setColumns(20);
        textEditor.setRows(5);
        textEditor.setText("add $v1 1 9\nadd $t0 0 16\nstorr $v1 0($t0)");
        textEditor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEditorKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(textEditor);

        jTabbedPane2.addTab("Edit", jScrollPane1);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codeModel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Instructions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(codeModel);
        if (codeModel.getColumnModel().getColumnCount() > 0) {
            codeModel.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 280));

        memoryTable.setModel(memoryModel);
        jScrollPane3.setViewportView(memoryTable);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 740, 290));

        jTabbedPane2.addTab("Execute", jPanel1);

        registerBuffer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Number", "Value"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        registerBuffer.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(registerBuffer);
        if (registerBuffer.getColumnModel().getColumnCount() > 0) {
            registerBuffer.getColumnModel().getColumn(0).setResizable(false);
            registerBuffer.getColumnModel().getColumn(1).setResizable(false);
            registerBuffer.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(runButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stepOneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(compileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(compileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stepOneButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(runButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compileButtonActionPerformed
        Clear();
        instructionRaw = textEditor.getText();
        instructionLines = instructionRaw.split("\n");
        for (int i = 0; i < instructionLines.length; i++) {
            Instruction inst = new Instruction(instructionLines[i], registerBuffer, memoryTable);
            instructions.add(inst);
            codeModel.getModel().setValueAt(inst.getInstructionString(), i, 0);
        }
        if (instructions.size() > 0) {
            stepOneButton.setEnabled(true);
            runButton.setEnabled(true);
        }
        jTabbedPane2.setSelectedIndex(OpcodePage);
    }//GEN-LAST:event_compileButtonActionPerformed

    private void Clear() {
        instructionIndex = 0;
        instructions.clear();
        for (int i = 0; i < registerBuffer.getModel().getRowCount(); i++) {
            registerBuffer.getModel().setValueAt("0", i, REGISTER_TABLE_VALUE);
        }
        for (int i = 0; i < memoryTable.getModel().getRowCount(); i++) {
            for (int j = 1; j < memoryTable.getModel().getColumnCount(); j++) {
                memoryTable.getModel().setValueAt("0", i, j);
            }
        }
        for (int i = 0; i < codeModel.getModel().getRowCount(); i++) {
            codeModel.getModel().setValueAt("", i, 0);
        }
    }

    private void stepOneButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stepOneButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_stepOneButtonMouseClicked

    private void stepOneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepOneButtonActionPerformed
        if (instructionIndex < instructions.size()) {
            Instruction inst = instructions.get(instructionIndex);
            if (inst.getIsWriteOperation()) {
                memoryTable.getModel().setValueAt(inst.getResult(),
                        inst.getDestination(), MEMORY_TABLE_VALUE);
            } else {
                registerBuffer.getModel().setValueAt(inst.getResult(),
                        inst.getDestination(), REGISTER_TABLE_VALUE);
            }
            if (instructionIndex + 1 < instructions.size()) {
                instructionIndex++;
                updatePC(instructionIndex);
            } else {
                stepOneButton.setEnabled(false);
                runButton.setEnabled(false);
            }
        }
    }//GEN-LAST:event_stepOneButtonActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        while (instructionIndex < instructions.size()) {
            Instruction inst = instructions.get(instructionIndex);
            if (inst.getIsWriteOperation()) {
                memoryTable.getModel().setValueAt(inst.getResult(),
                        inst.getDestination(), MEMORY_TABLE_VALUE);
            } else {
                registerBuffer.getModel().setValueAt(inst.getResult(),
                        inst.getDestination(), REGISTER_TABLE_VALUE);
            }
            instructionIndex++;
        }
        stepOneButton.setEnabled(false);
        runButton.setEnabled(false);
    }//GEN-LAST:event_runButtonActionPerformed

    private void textEditorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEditorKeyTyped
        // EMPTY
    }//GEN-LAST:event_textEditorKeyTyped

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        Clear();
        jTabbedPane2.setSelectedIndex(EditPage);
    }//GEN-LAST:event_clearButtonActionPerformed

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
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JTable codeModel;
    private javax.swing.JButton compileButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable memoryTable;
    public javax.swing.JTable registerBuffer;
    private javax.swing.JButton runButton;
    private javax.swing.JButton stepOneButton;
    private javax.swing.JTextArea textEditor;
    // End of variables declaration//GEN-END:variables

    private TableModel CreateMemoryModel() {
        TableModel model = new TableModel() {
            @Override
            public int getRowCount() {

                return memoryModelTable.length;
            }

            @Override
            public int getColumnCount() {
                return memoryModelTable[0].length;
            }

            String[] colNames = {"Address", "Value(+0)", "Value(+4)", "Value(+8)",
                "Value(+12)", "Value(+16)", "Value(+20)", "Value(+24)", "Value(+30)"};

            @Override
            public String getColumnName(int arg0) {
                return colNames[arg0];
            }

            @Override
            public Class<?> getColumnClass(int arg0) {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }

            @Override
            public Object getValueAt(int arg0, int arg1) {
                return memoryModelTable[arg0][arg1];
            }

            @Override
            public void setValueAt(Object arg0, int arg1, int arg2) {
                memoryModelTable[arg1][arg2] = arg0.toString();
            }

            @Override
            public void addTableModelListener(TableModelListener arg0) {
                // Empty
            }

            @Override
            public void removeTableModelListener(TableModelListener arg0) {
                // Empty
            }
        };
        return model;
    }

    private void initModels() {
        for (int i = 0; i < registerBuffer.getModel().getRowCount(); i++) {
            registerBuffer.getModel().setValueAt(String.valueOf(i), i, REGISTER_TABLE_VALUE - 1);
            registerBuffer.getModel().setValueAt(REGISTER_NAMES[i], i, REGISTER_TABLE_VALUE - 2);
            registerBuffer.getModel().setValueAt("", i, REGISTER_TABLE_VALUE);
        }
        int memAddress = 0;
        for (int i = 0; i < memoryTable.getModel().getRowCount(); i++) {

            memoryTable.getModel().setValueAt(String.format("0x%1$08x", memAddress), i, MEMORY_TABLE_VALUE - 1);
            memAddress += 4;
        }
    }

    private void updatePC(int index) {
        registerBuffer.getModel().setValueAt(index, 29, REGISTER_TABLE_VALUE);
    }
}
