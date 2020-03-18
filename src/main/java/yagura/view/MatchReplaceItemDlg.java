package yagura.view;

import extend.view.base.CustomDialog;
import yagura.model.MatchReplaceItem;
import javax.swing.JOptionPane;

/**
 *
 * @author isayan
 */
public class MatchReplaceItemDlg extends CustomDialog {

    /**
     * Creates new form MatchReplaceItemDlg
     *
     * @param parent
     * @param modal
     */
    public MatchReplaceItemDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        pnlMain = new javax.swing.JPanel();
        cmbRepType = new javax.swing.JComboBox();
        txtRepMatch = new javax.swing.JTextField();
        txtRepReplace = new javax.swing.JTextField();
        chkSmartMatch = new javax.swing.JCheckBox();
        chkRegExp = new javax.swing.JCheckBox();
        chkIgnoreCase = new javax.swing.JCheckBox();
        lblType = new javax.swing.JLabel();
        lblMatch = new javax.swing.JLabel();
        lblReplace = new javax.swing.JLabel();
        chkMetaChar = new javax.swing.JCheckBox();
        pnlApply = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbRepType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbRepTypeItemStateChanged(evt);
            }
        });
        cmbRepType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRepTypeActionPerformed(evt);
            }
        });

        txtRepMatch.setName(""); // NOI18N

        txtRepReplace.setName(""); // NOI18N
        txtRepReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepReplaceActionPerformed(evt);
            }
        });

        chkSmartMatch.setText("Smart Match");
        chkSmartMatch.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkSmartMatchStateChanged(evt);
            }
        });

        chkRegExp.setSelected(true);
        chkRegExp.setText("RegExp");

        chkIgnoreCase.setText("IgnoreCase");
        chkIgnoreCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkIgnoreCaseActionPerformed(evt);
            }
        });

        lblType.setText("Type:");

        lblMatch.setText("Match:");

        lblReplace.setText("Replace:");

        chkMetaChar.setText("MetaChar(\\r,\\n,\\b,\\f,\\t\\v,\\\\,\\xhh,\\uhhhh)");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReplace)
                            .addComponent(lblMatch))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(chkSmartMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkRegExp)
                                .addGap(18, 18, 18)
                                .addComponent(chkIgnoreCase))
                            .addComponent(chkMetaChar)
                            .addComponent(txtRepMatch, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                            .addComponent(txtRepReplace)))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblType)
                        .addGap(35, 35, 35)
                        .addComponent(cmbRepType, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRepType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkIgnoreCase)
                    .addComponent(chkRegExp)
                    .addComponent(chkSmartMatch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRepMatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMatch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRepReplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReplace))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkMetaChar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

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
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(pnlApply, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("yagura/resources/Resource");

    @SuppressWarnings("unchecked")
    private void customizeComponents() {
        for (String t : MatchReplaceItem.getTypes()) {
            this.cmbRepType.addItem(t);
        }
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setModalResult(JOptionPane.CANCEL_OPTION);
        this.closeDialog(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        MatchReplaceItem item = getItem();
        if (!item.isValidRegex()) {
            JOptionPane.showMessageDialog(this, BUNDLE.getString("view.replaceitem.regex"), "MatchReplace", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.setModalResult(JOptionPane.OK_OPTION);
            this.closeDialog(null);
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void cmbRepTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRepTypeActionPerformed
   }//GEN-LAST:event_cmbRepTypeActionPerformed

    private void txtRepReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepReplaceActionPerformed
    }//GEN-LAST:event_txtRepReplaceActionPerformed

    private void chkIgnoreCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkIgnoreCaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkIgnoreCaseActionPerformed

    private void cmbRepTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbRepTypeItemStateChanged
    }//GEN-LAST:event_cmbRepTypeItemStateChanged

    private void chkSmartMatchStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkSmartMatchStateChanged
        this.chkRegExp.setEnabled(!this.chkSmartMatch.isSelected());
    }//GEN-LAST:event_chkSmartMatchStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatchReplaceItemDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatchReplaceItemDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatchReplaceItemDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatchReplaceItemDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MatchReplaceItemDlg dialog = new MatchReplaceItemDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox chkIgnoreCase;
    private javax.swing.JCheckBox chkMetaChar;
    private javax.swing.JCheckBox chkRegExp;
    private javax.swing.JCheckBox chkSmartMatch;
    private javax.swing.JComboBox cmbRepType;
    private javax.swing.JLabel lblMatch;
    private javax.swing.JLabel lblReplace;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel pnlApply;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JTextField txtRepMatch;
    private javax.swing.JTextField txtRepReplace;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the item
     */
    public MatchReplaceItem getItem() {
        MatchReplaceItem item = new MatchReplaceItem();
        item.setSelected(true);
        item.setType((String) this.cmbRepType.getSelectedItem());
        item.setMatch(this.txtRepMatch.getText());
        item.setSmartMatch(this.chkSmartMatch.isSelected());
        item.setRegexp(this.chkRegExp.isSelected());
        item.setIgnoreCase(this.chkIgnoreCase.isSelected());
        item.setReplace(this.txtRepReplace.getText());
        item.setMetaChar(this.chkMetaChar.isSelected());
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(MatchReplaceItem item) {
        this.cmbRepType.getModel().setSelectedItem(item.getType());
        this.txtRepMatch.setText(item.getMatch());
        this.chkSmartMatch.setSelected(item.isSmartMatch());
        this.chkRegExp.setSelected(item.isRegexp());
        this.chkIgnoreCase.setSelected(item.isIgnoreCase());
        this.txtRepReplace.setText(item.getReplace());
        this.chkMetaChar.setSelected(item.isMetaChar());
    }
}
