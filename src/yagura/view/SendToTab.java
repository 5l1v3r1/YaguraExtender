/*
 * SendToTab.java
 *
 * Created on 2010/11/27, 13:21:00
 */
package yagura.view;

import burp.ITab;
import extend.model.base.CustomTableModel;
import yagura.model.SendToItem;
import yagura.model.SendToProperty;
import extend.util.SwingUtil;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isayan
 */
public class SendToTab extends javax.swing.JPanel implements ITab {

    /**
     * Creates new form SendToTab
     */
    public SendToTab() {
        initComponents();
        customizeComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabSendTo = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        btnSendToEdit = new javax.swing.JButton();
        btnSendToRemove = new javax.swing.JButton();
        btnSendToAdd = new javax.swing.JButton();
        scrollSendTo = new javax.swing.JScrollPane();
        tableSendTo = new javax.swing.JTable();
        btnSendToDownArraw = new javax.swing.JButton();
        btnSendToUpArraw = new javax.swing.JButton();
        chkSubmenu = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(550, 450));
        setLayout(new java.awt.BorderLayout());

        tabSendTo.setPreferredSize(new java.awt.Dimension(550, 300));
        tabSendTo.setLayout(new java.awt.BorderLayout());

        btnSendToEdit.setText("Edit");
        btnSendToEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToEditActionPerformed(evt);
            }
        });

        btnSendToRemove.setText("Remove");
        btnSendToRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToRemoveActionPerformed(evt);
            }
        });

        btnSendToAdd.setText("Add");
        btnSendToAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToAddActionPerformed(evt);
            }
        });

        tableSendTo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "MenuCaption", "Server", "Target", "Req Header", "Req Body", "Res Header", "Res Body", "Rev Order", "Extend"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSendTo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableSendToKeyTyped(evt);
            }
        });
        scrollSendTo.setViewportView(tableSendTo);
        if (tableSendTo.getColumnModel().getColumnCount() > 0) {
            tableSendTo.getColumnModel().getColumn(2).setResizable(false);
            tableSendTo.getColumnModel().getColumn(4).setResizable(false);
            tableSendTo.getColumnModel().getColumn(5).setResizable(false);
            tableSendTo.getColumnModel().getColumn(6).setResizable(false);
            tableSendTo.getColumnModel().getColumn(6).setPreferredWidth(0);
            tableSendTo.getColumnModel().getColumn(7).setResizable(false);
            tableSendTo.getColumnModel().getColumn(8).setResizable(false);
            tableSendTo.getColumnModel().getColumn(9).setResizable(false);
        }

        btnSendToDownArraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/arrow_down.png"))); // NOI18N
        btnSendToDownArraw.setText("down");
        btnSendToDownArraw.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSendToDownArraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToDownArrawActionPerformed(evt);
            }
        });

        btnSendToUpArraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/arrow_up.png"))); // NOI18N
        btnSendToUpArraw.setText("up");
        btnSendToUpArraw.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSendToUpArraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToUpArrawActionPerformed(evt);
            }
        });

        chkSubmenu.setText("Send To Submenu");
        chkSubmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSubmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(scrollSendTo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSendToEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSendToRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSendToDownArraw, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCenterLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnSendToUpArraw, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnSendToAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(chkSubmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(560, Short.MAX_VALUE))))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkSubmenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(scrollSendTo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(btnSendToEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendToRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendToUpArraw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendToDownArraw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSendToAdd)
                        .addContainerGap(98, Short.MAX_VALUE))))
        );

        tabSendTo.add(pnlCenter, java.awt.BorderLayout.CENTER);

        add(tabSendTo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public String getTabCaption() {
        return "SendTo";
    }

    @Override
    public Component getUiComponent() {
        return this;
    }
    
    protected final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("yagura/resources/Resource");
    private CustomTableModel modelSendTo = null;
    private final SendToItemDlg sendtoItemDlg = new SendToItemDlg(null, true);

    @SuppressWarnings("unchecked")
    private void customizeComponents() {

        // SendTo Tab
//        this.lblSendToTip.setText(BUNDLE.getString("view.sendto.tip"));

        this.modelSendTo = new CustomTableModel(this.tableSendTo.getModel());
        this.tableSendTo.setModel(this.modelSendTo);
        this.btnSendToEdit.setEnabled(this.tableSendTo.getSelectedRowCount() > 0);
        this.modelSendTo.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                firePropertyChange(TabbetOption.SENDTO_PROPERTY, null, getSendToProperty());
            }
        });

        this.tableSendTo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int rowCount = tableSendTo.getSelectedRowCount();
                btnSendToEdit.setEnabled((rowCount > 0));
            }
        });

        // selected
        this.tableSendTo.getColumnModel().getColumn(0).setMinWidth(20);
        this.tableSendTo.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.tableSendTo.getColumnModel().getColumn(0).setMaxWidth(30);

        // Caption
        this.tableSendTo.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.tableSendTo.getColumnModel().getColumn(1).setMaxWidth(180);

        // server
        this.tableSendTo.getColumnModel().getColumn(2).setMinWidth(20);
        this.tableSendTo.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.tableSendTo.getColumnModel().getColumn(2).setMaxWidth(40);

        // Target
        this.tableSendTo.getColumnModel().getColumn(3).setMinWidth(50);
        this.tableSendTo.getColumnModel().getColumn(3).setPreferredWidth(180);
        this.tableSendTo.getColumnModel().getColumn(3).setMaxWidth(250);

        // request header
        this.tableSendTo.getColumnModel().getColumn(4).setMinWidth(20);
        this.tableSendTo.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.tableSendTo.getColumnModel().getColumn(4).setMaxWidth(60);

        // request body
        this.tableSendTo.getColumnModel().getColumn(5).setMinWidth(20);
        this.tableSendTo.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.tableSendTo.getColumnModel().getColumn(5).setMaxWidth(60);
        
        // response header
        this.tableSendTo.getColumnModel().getColumn(6).setMinWidth(20);
        this.tableSendTo.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.tableSendTo.getColumnModel().getColumn(6).setMaxWidth(60);

        // response body
        this.tableSendTo.getColumnModel().getColumn(7).setMinWidth(20);
        this.tableSendTo.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.tableSendTo.getColumnModel().getColumn(7).setMaxWidth(60);
        
        // reverse order
        this.tableSendTo.getColumnModel().getColumn(8).setMinWidth(0);
        this.tableSendTo.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.tableSendTo.getColumnModel().getColumn(8).setMaxWidth(0);

        // Extend
        this.tableSendTo.getColumnModel().getColumn(9).setMinWidth(0);
        this.tableSendTo.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.tableSendTo.getColumnModel().getColumn(9).setMaxWidth(0);

        // 
        this.tableSendTo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

    }

    private void btnSendToEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToEditActionPerformed
        this.showSendToItemDlg(true);
        //this.firePropertyChange(TabbetOption.SENDTO_PROPERTY, null, this.getSendToProperty());                                
}//GEN-LAST:event_btnSendToEditActionPerformed

    private void btnSendToRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToRemoveActionPerformed
        SwingUtil.removeItem(this.tableSendTo);
        //this.firePropertyChange(TabbetOption.SENDTO_PROPERTY, null, this.getSendToProperty());                                
}//GEN-LAST:event_btnSendToRemoveActionPerformed

    private void btnSendToUpArrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToUpArrawActionPerformed
        int index = this.tableSendTo.getSelectedRow();
        index = this.modelSendTo.moveUp(index);
        this.tableSendTo.getSelectionModel().setSelectionInterval(index, index);
        //this.firePropertyChange(TabbetOption.SENDTO_PROPERTY, null, this.getSendToProperty());                                
}//GEN-LAST:event_btnSendToUpArrawActionPerformed

    private void btnSendToDownArrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToDownArrawActionPerformed
        int index = this.tableSendTo.getSelectedRow();
        index = this.modelSendTo.moveDn(index);
        this.tableSendTo.getSelectionModel().setSelectionInterval(index, index);
        //this.firePropertyChange(TabbetOption.SENDTO_PROPERTY, null, this.getSendToProperty());                        
}//GEN-LAST:event_btnSendToDownArrawActionPerformed

    private void btnSendToAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToAddActionPerformed
        this.showSendToItemDlg(false);
        //this.firePropertyChange(TabbetOption.SENDTO_PROPERTY, null, this.getSendToProperty());                
}//GEN-LAST:event_btnSendToAddActionPerformed

    private void chkSubmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSubmenuActionPerformed
        this.firePropertyChange(TabbetOption.SENDTO_PROPERTY, null, this.getSendToProperty());
    }//GEN-LAST:event_chkSubmenuActionPerformed

    private void tableSendToKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableSendToKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_SPACE) {
            int[] rowSelect = this.tableSendTo.getSelectedRows();
            for (int i = 0; i < rowSelect.length; i++) {
                int rowIndex = this.tableSendTo.convertRowIndexToModel(rowSelect[i]);
                DefaultTableModel modelTable = (DefaultTableModel) this.tableSendTo.getModel();                
                Object[] editRows = new Object[this.tableSendTo.getColumnCount()];
                for (int k = 0; k < editRows.length; k++) {
                    editRows[k] = modelTable.getValueAt(rowIndex, this.tableSendTo.convertColumnIndexToModel(k));
                }
                SendToItem item = SendToItem.fromObjects(editRows);
                item.setSelected(!item.isSelected());
                editRows = SendToItem.toObjects(item);
                SwingUtil.updateItem(this.tableSendTo, editRows, rowSelect[i]);
            }            
        }
    }//GEN-LAST:event_tableSendToKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendToAdd;
    private javax.swing.JButton btnSendToDownArraw;
    private javax.swing.JButton btnSendToEdit;
    private javax.swing.JButton btnSendToRemove;
    private javax.swing.JButton btnSendToUpArraw;
    private javax.swing.JCheckBox chkSubmenu;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JScrollPane scrollSendTo;
    private javax.swing.JPanel tabSendTo;
    private javax.swing.JTable tableSendTo;
    // End of variables declaration//GEN-END:variables

    public void setSendToItemList(List<SendToItem> list) {
        if (list == null) {
        } else {
            this.modelSendTo.beginUpdate();
            this.modelSendTo.removeAll();
            Object editRows[] = new Object[0];
            for (int i = 0; i < list.size(); i++) {
                SendToItem sendToItem = list.get(i);
                editRows = SendToItem.toObjects(sendToItem);
                this.modelSendTo.addRow(editRows);
            }
            this.modelSendTo.endUpdate();
        }
    }

    public List<SendToItem> getSendToItemList() {
        javax.swing.JTable srcTable = this.tableSendTo;
        List<SendToItem> list = new ArrayList<SendToItem>();
        for (int i = 0; i < srcTable.getRowCount(); i++) {
            Object editRows[] = this.modelSendTo.getRows(i);
            list.add(SendToItem.fromObjects(editRows));
        }
        return list;
    }

    private SendToItem getEditItem() {
        SendToItem item = new SendToItem();
        Object editRows[] = SwingUtil.editItem(this.tableSendTo);
        if (editRows != null) {
            item = SendToItem.fromObjects(editRows);
        }
        return item;
    }

    private void setEditItem(SendToItem item, boolean update) {
        Object[] rows = SendToItem.toObjects(item);
        SwingUtil.addOrUpdateItem(this.tableSendTo, rows, update);
    }

    @SuppressWarnings("unchecked")
    private void showSendToItemDlg(boolean editMode) {
        this.sendtoItemDlg.setLocationRelativeTo(this);
        this.sendtoItemDlg.setItemList(this.getSendToItemList());
        if (editMode) {
            this.sendtoItemDlg.setItem(getEditItem());
        } else {
            SendToItem item = new SendToItem();
            this.sendtoItemDlg.setItem(item);
        }
        this.sendtoItemDlg.setVisible(true);
        if (this.sendtoItemDlg.getModalResult() == JOptionPane.OK_OPTION) {
            SendToItem item = this.sendtoItemDlg.getItem();
            setEditItem(item, editMode);
        }
    }

    public void setSendToProperty(SendToProperty sendToProperty) {
        this.setSendToItemList(sendToProperty.getSendToItemList());
        this.chkSubmenu.setSelected(sendToProperty.isSubMenu());
    }

    public SendToProperty getSendToProperty() {
        SendToProperty sendToProperty = new SendToProperty();
        sendToProperty.setSendToItemList(this.getSendToItemList());
        sendToProperty.setSubMenu(this.chkSubmenu.isSelected());
        return sendToProperty;
    }

}
