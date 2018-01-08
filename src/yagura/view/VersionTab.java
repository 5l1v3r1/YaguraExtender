/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * VersionTab.java
 *
 * Created on 2010/11/27, 15:00:30
 */
package yagura.view;

import burp.BurpExtender;
import yagura.Config;
import yagura.model.OptionProperty;
import yagura.Version;
import extend.view.model.VerticalFlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author isayan
 */
public class VersionTab extends javax.swing.JPanel {

    private OptionProperty option;

    /**
     * Creates new form VersionTab
     */
    public VersionTab() {
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

        pnlCenter = new javax.swing.JPanel();
        scrollVersion = new javax.swing.JScrollPane();
        txtVersion = new javax.swing.JTextArea();
        pnlConfig = new javax.swing.JPanel();
        btnExport = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        chkDebugMode = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(550, 450));
        setLayout(null);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        txtVersion.setEditable(false);
        txtVersion.setColumns(20);
        txtVersion.setRows(5);
        scrollVersion.setViewportView(txtVersion);

        pnlCenter.add(scrollVersion, java.awt.BorderLayout.CENTER);

        pnlConfig.setBorder(javax.swing.BorderFactory.createTitledBorder("Config"));

        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnImport.setText("Import");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConfigLayout = new javax.swing.GroupLayout(pnlConfig);
        pnlConfig.setLayout(pnlConfigLayout);
        pnlConfigLayout.setHorizontalGroup(
            pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImport)
                .addGap(18, 18, 18)
                .addComponent(btnExport)
                .addContainerGap(387, Short.MAX_VALUE))
        );
        pnlConfigLayout.setVerticalGroup(
            pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfigLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExport)
                    .addComponent(btnImport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCenter.add(pnlConfig, java.awt.BorderLayout.NORTH);

        add(pnlCenter);
        pnlCenter.setBounds(0, 0, 559, 96);

        chkDebugMode.setText("DebugMode");
        chkDebugMode.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkDebugModeStateChanged(evt);
            }
        });
        add(chkDebugMode);
        chkDebugMode.setBounds(0, 259, 559, 21);
    }// </editor-fold>//GEN-END:initComponents

    private void chkDebugModeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkDebugModeStateChanged
        this.firePropertyChange(TabbetOption.VERSION_PROPERTY, null, this);
    }//GEN-LAST:event_chkDebugModeStateChanged

    final static FileFilter burp_config_filter = new FileNameExtensionFilter("burp configファイル(*.bcxml)", "bcxml");

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        filechooser.addChoosableFileFilter(burp_config_filter);
        filechooser.setFileFilter(burp_config_filter);
        int selected = filechooser.showOpenDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION) {
            try {
                File file = filechooser.getSelectedFile();
                Config.loadFromXml(file, BurpExtender.getInstance().getProperty());
            } catch (IOException ex) {
                Logger.getLogger(VersionTab.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.firePropertyChange(TabbetOption.LOAD_CONFIG_PROPERTY, null, this);
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        filechooser.addChoosableFileFilter(burp_config_filter);
        filechooser.setFileFilter(burp_config_filter);
        int selected = filechooser.showSaveDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION) {
            try {
                File file = filechooser.getSelectedFile();
                if (!burp_config_filter.accept(file)) {
                    file = new File(file.getAbsolutePath() + ".bcxml");
                }
                Config.saveToXML(file, BurpExtender.getInstance().getProperty());
            } catch (IOException ex) {
                Logger.getLogger(VersionTab.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnExportActionPerformed

    @SuppressWarnings("unchecked")
    private void customizeComponents() {
        this.setLayout(new VerticalFlowLayout());
        // Version Info
        this.txtVersion.setText(Version.getInstance().getVersionInfo());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JCheckBox chkDebugMode;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlConfig;
    private javax.swing.JScrollPane scrollVersion;
    private javax.swing.JTextArea txtVersion;
    // End of variables declaration//GEN-END:variables

    public boolean getDebugMode() {
        return this.chkDebugMode.getModel().isSelected();
    }

    public void setDebugMode(boolean debugMode) {
        this.chkDebugMode.getModel().setSelected(debugMode);
    }

}
