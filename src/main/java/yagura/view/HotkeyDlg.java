package yagura.view;

import extend.model.base.CustomTableModel;
import extend.util.SwingUtil;
import extend.view.base.CustomDialog;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import yagura.model.HotKey;
import yagura.model.SendToItem;

/**
 *
 * @author isayan
 */
public class HotkeyDlg extends CustomDialog {

    /**
     * Creates new form NewJDialog
     */
    public HotkeyDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        customizeComponents();
    }

    private CustomTableModel modelHotkey = null;

    private void customizeComponents() {

        // SendTo Tab
        this.modelHotkey = new CustomTableModel(this.tableHotkey.getModel());
        this.tableHotkey.setModel(this.modelHotkey);

        this.tableHotkey.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        // Data
        this.tableHotkey.getColumnModel().getColumn(0).setMinWidth(0);
        this.tableHotkey.getColumnModel().getColumn(0).setMaxWidth(0);

        // Caption
        this.tableHotkey.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.tableHotkey.getColumnModel().getColumn(1).setMaxWidth(180);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlApply = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHotkey = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlApply.setPreferredSize(new java.awt.Dimension(550, 50));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlApplyLayout = new javax.swing.GroupLayout(pnlApply);
        pnlApply.setLayout(pnlApplyLayout);
        pnlApplyLayout.setHorizontalGroup(
            pnlApplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlApplyLayout.createSequentialGroup()
                .addContainerGap(323, Short.MAX_VALUE)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlApplyLayout.setVerticalGroup(
            pnlApplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApplyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlApplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlApply, java.awt.BorderLayout.SOUTH);

        tableHotkey.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Send To Action", "Hotkey"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHotkey.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableHotkeyKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tableHotkey);
        if (tableHotkey.getColumnModel().getColumnCount() > 0) {
            tableHotkey.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setModalResult(JOptionPane.CANCEL_OPTION);
        this.closeDialog(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        this.setModalResult(JOptionPane.OK_OPTION);
        this.closeDialog(null);
    }//GEN-LAST:event_btnOKActionPerformed

    private void tableHotkeyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableHotkeyKeyPressed
        KeyEvent keyEvent = null;
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_BACK_SPACE
                || evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE) {
        } else if (evt.getKeyCode() != java.awt.event.KeyEvent.CHAR_UNDEFINED
                && evt.getKeyCode() != java.awt.event.KeyEvent.VK_CONTROL
                && evt.getKeyCode() != java.awt.event.KeyEvent.VK_SHIFT
                && evt.getKeyCode() != java.awt.event.KeyEvent.VK_ALT
                && evt.getKeyCode() != java.awt.event.KeyEvent.VK_META
                && (evt.getModifiersEx() == 0)) {
        } else if (evt.getKeyCode() != java.awt.event.KeyEvent.CHAR_UNDEFINED
                && evt.getKeyCode() != java.awt.event.KeyEvent.VK_CONTROL
                && evt.getKeyCode() != java.awt.event.KeyEvent.VK_SHIFT
                && evt.getKeyCode() != java.awt.event.KeyEvent.VK_ALT
                && evt.getKeyCode() != java.awt.event.KeyEvent.VK_META
                && (evt.getModifiersEx() & java.awt.event.KeyEvent.CTRL_DOWN_MASK) != 0) {
            keyEvent = evt;
        }
        if (keyEvent != null) {
            String keyEventText = SwingUtil.getKeyText(evt);
            int[] rowSelect = this.tableHotkey.getSelectedRows();
            for (int i = 0; i < rowSelect.length; i++) {
                int rowIndex = this.tableHotkey.convertRowIndexToModel(rowSelect[i]);
                DefaultTableModel modelTable = (DefaultTableModel) this.tableHotkey.getModel();
                Object[] editRows = new Object[this.tableHotkey.getColumnCount()];
                for (int k = 0; k < editRows.length; k++) {
                    editRows[k] = modelTable.getValueAt(rowIndex, this.tableHotkey.convertColumnIndexToModel(k));
                }
                SendToItem item = fromObjects(editRows);
                item.setHotkey(new HotKey(keyEvent));
                editRows[2] = keyEventText;
                SwingUtil.updateItem(this.tableHotkey, editRows, rowSelect[i]);
            }

        }
    }//GEN-LAST:event_tableHotkeyKeyPressed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HotkeyDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HotkeyDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HotkeyDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotkeyDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HotkeyDlg dialog = new HotkeyDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlApply;
    private javax.swing.JTable tableHotkey;
    // End of variables declaration//GEN-END:variables

    public static Object[] toObjects(SendToItem item) {
        Object[] beans = new Object[3];
        beans[0] = item;
        beans[1] = item.getCaption();
        beans[2] = item.getHotkey() == null ? "" : SwingUtil.getKeyText(item.getHotkey());
        return beans;
    }

    public static SendToItem fromObjects(Object[] rows) {
        SendToItem item = (SendToItem) rows[0];
        return item;
    }

    public void setItemList(List<SendToItem> list) {
        if (list == null) {
        } else {
            this.modelHotkey.beginUpdate();
            this.modelHotkey.removeAll();
            for (int i = 0; i < list.size(); i++) {
                SendToItem sendToItem = list.get(i);
                Object editRows[] = toObjects(sendToItem);
                this.modelHotkey.addRow(editRows);
            }
            this.modelHotkey.endUpdate();
        }
    }

    public List<SendToItem> getItemList() {
        javax.swing.JTable srcTable = this.tableHotkey;
        List<SendToItem> list = new ArrayList<>();
        for (int i = 0; i < srcTable.getRowCount(); i++) {
            Object editRows[] = this.modelHotkey.getRows(i);
            SendToItem sendToItem = fromObjects(editRows);
            list.add(sendToItem);
        }
        return list;
    }

}
