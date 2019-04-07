/*
 * MatchReplace.java
 *
 * Created on 2010/11/27, 13:11:37
 */
package yagura.view;

import burp.ITab;
import extend.model.base.CustomListModel;
import yagura.model.MatchReplaceItem;
import yagura.model.MatchReplaceProperty;
import extend.util.Util;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import yagura.model.MatchReplaceGroup;

/**
 *
 * @author isayan
 */
public class MatchReplaceTab extends javax.swing.JPanel implements ITab {

    /**
     * Creates new form MatchReplace
     */
    public MatchReplaceTab() {
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

        rdoEncodeingGrp = new javax.swing.ButtonGroup();
        rdoMathReplace = new javax.swing.ButtonGroup();
        tabMatchReplace = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        pnlRepEnc = new javax.swing.JPanel();
        rdoRepEnc_8859_1 = new javax.swing.JRadioButton();
        rdoRepEnc_AutoRecognise = new javax.swing.JRadioButton();
        btnRepDownArraw = new javax.swing.JButton();
        btnRepUpArraw = new javax.swing.JButton();
        btnRepRemove = new javax.swing.JButton();
        btnRepEdit = new javax.swing.JButton();
        btnRepNew = new javax.swing.JButton();
        scrollMatchReplace = new javax.swing.JScrollPane();
        listMatchReplace = new javax.swing.JList();
        btnSelect = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        tabMatchReplace.setPreferredSize(new java.awt.Dimension(550, 300));
        tabMatchReplace.setLayout(new java.awt.BorderLayout());

        pnlRepEnc.setBorder(javax.swing.BorderFactory.createTitledBorder("Replace Encoding"));
        pnlRepEnc.setLayout(new javax.swing.BoxLayout(pnlRepEnc, javax.swing.BoxLayout.PAGE_AXIS));

        rdoRepEnc_8859_1.setSelected(true);
        rdoRepEnc_8859_1.setText("8859_1");
        pnlRepEnc.add(rdoRepEnc_8859_1);

        rdoRepEnc_AutoRecognise.setText("AutoRecognise");
        rdoRepEnc_AutoRecognise.setEnabled(false);
        pnlRepEnc.add(rdoRepEnc_AutoRecognise);

        btnRepDownArraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/arrow_down.png"))); // NOI18N
        btnRepDownArraw.setText("down");
        btnRepDownArraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepDownArrawActionPerformed(evt);
            }
        });

        btnRepUpArraw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/arrow_up.png"))); // NOI18N
        btnRepUpArraw.setText("up");
        btnRepUpArraw.setHideActionText(true);
        btnRepUpArraw.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnRepUpArraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepUpArrawActionPerformed(evt);
            }
        });

        btnRepRemove.setText("Remove");
        btnRepRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepRemoveActionPerformed(evt);
            }
        });

        btnRepEdit.setText("Edit");
        btnRepEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepEditActionPerformed(evt);
            }
        });

        btnRepNew.setText("New");
        btnRepNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepNewActionPerformed(evt);
            }
        });

        listMatchReplace.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                listMatchReplaceKeyTyped(evt);
            }
        });
        scrollMatchReplace.setViewportView(listMatchReplace);

        btnSelect.setText("Selected");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollMatchReplace, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnRepRemove, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRepEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRepNew, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(pnlRepEnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnRepUpArraw, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRepDownArraw, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(btnSelect)
                        .addGap(18, 18, 18)
                        .addComponent(btnRepNew))
                    .addComponent(pnlRepEnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRepEdit)
                .addGap(18, 18, 18)
                .addComponent(btnRepRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRepUpArraw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRepDownArraw)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollMatchReplace, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabMatchReplace.add(pnlCenter, java.awt.BorderLayout.CENTER);

        add(tabMatchReplace, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public String getTabCaption() {
        return "MatchReplace";
    }

    @Override
    public Component getUiComponent() {
        return this;
    }

    protected final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("yagura/resources/Resource");
    private final CustomListModel modelReplace = new CustomListModel();
    private final ListDataListener listDataListener = new ListDataListener() {

        @Override
        public void intervalAdded(ListDataEvent e) {
            firePropertyChange(TabbetOption.MATCHREPLACE_PROPERTY, null, getMatchReplaceProperty());
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            firePropertyChange(TabbetOption.MATCHREPLACE_PROPERTY, null, getMatchReplaceProperty());
        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            firePropertyChange(TabbetOption.MATCHREPLACE_PROPERTY, null, getMatchReplaceProperty());
        }
    };

    private javax.swing.ImageIcon image_check = new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/tick.png"));
    private javax.swing.ImageIcon image_uncheck = new javax.swing.ImageIcon(getClass().getResource("/yagura/resources/untick.png"));

    @SuppressWarnings("unchecked")
    private void customizeComponents() {
        // group
        this.rdoEncodeingGrp.add(this.rdoRepEnc_8859_1);
        this.rdoEncodeingGrp.add(this.rdoRepEnc_AutoRecognise);
        // MatchReplace Tab
        this.listMatchReplace.setModel(this.modelReplace);
//        this.modelReplace.addListDataListener(listDataListener);

        this.listMatchReplace.setCellRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel l = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                String name = (String) value;
                if (Util.equalsString(name, selectedName)) {
                    l.setIcon(image_check);
                    l.setIconTextGap(2);
                }
                else {
                    l.setIcon(image_uncheck);
                    l.setIconTextGap(2);
                }                
                return l;
            }
        });

    }

    private void btnRepNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepNewActionPerformed
        this.showReplaceDlg(false);
}//GEN-LAST:event_btnRepNewActionPerformed

    private void btnRepEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepEditActionPerformed
        this.showReplaceDlg(true);
}//GEN-LAST:event_btnRepEditActionPerformed

    private void btnRepRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepRemoveActionPerformed
        if (JOptionPane.showConfirmDialog(this, BUNDLE.getString("view.matchreplace.remove"), "Match and Replace", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String name = this.getReplaceSelectedName();           
            this.modelReplace.removeElement(name);
            this.replaceMap.remove(name);
            firePropertyChange(TabbetOption.MATCHREPLACE_PROPERTY, null, getMatchReplaceProperty());
        }
}//GEN-LAST:event_btnRepRemoveActionPerformed

    private void btnRepUpArrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepUpArrawActionPerformed
        int index = this.modelReplace.moveUp(this.listMatchReplace.getSelectedIndex());
        this.listMatchReplace.setSelectedIndex(index);
        firePropertyChange(TabbetOption.MATCHREPLACE_PROPERTY, null, getMatchReplaceProperty());
}//GEN-LAST:event_btnRepUpArrawActionPerformed

    private void btnRepDownArrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepDownArrawActionPerformed
        int index = this.modelReplace.moveDown(this.listMatchReplace.getSelectedIndex());
        this.listMatchReplace.setSelectedIndex(index);
        firePropertyChange(TabbetOption.MATCHREPLACE_PROPERTY, null, getMatchReplaceProperty());

}//GEN-LAST:event_btnRepDownArrawActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        String name  = this.getReplaceSelectedName();
        if (Util.equalsString(this.selectedName, name)) {
            this.selectedName = "";
        }
        else {
            this.selectedName = name;        
        }
        this.listMatchReplace.updateUI();
        firePropertyChange(TabbetOption.MATCHREPLACE_PROPERTY, null, getMatchReplaceProperty());        
    }//GEN-LAST:event_btnSelectActionPerformed

    private void listMatchReplaceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listMatchReplaceKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_SPACE) {
            btnSelectActionPerformed(null);
        }
    }//GEN-LAST:event_listMatchReplaceKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRepDownArraw;
    private javax.swing.JButton btnRepEdit;
    private javax.swing.JButton btnRepNew;
    private javax.swing.JButton btnRepRemove;
    private javax.swing.JButton btnRepUpArraw;
    private javax.swing.JButton btnSelect;
    private javax.swing.JList listMatchReplace;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlRepEnc;
    private javax.swing.ButtonGroup rdoEncodeingGrp;
    private javax.swing.ButtonGroup rdoMathReplace;
    private javax.swing.JRadioButton rdoRepEnc_8859_1;
    private javax.swing.JRadioButton rdoRepEnc_AutoRecognise;
    private javax.swing.JScrollPane scrollMatchReplace;
    private javax.swing.JPanel tabMatchReplace;
    // End of variables declaration//GEN-END:variables

    private final JReplaceDialog replaceDlg = new JReplaceDialog(null, true);
    private String selectedName = "";

    @SuppressWarnings("unchecked")
    private void showReplaceDlg(boolean editMode) {
        this.replaceDlg.setLocationRelativeTo(this);
        String selectedName = "";
        if (editMode) {
            selectedName = this.getReplaceSelectedName();
            //BurpExtender.errPrintln("selectedName:" + "'" + selectedName + "'");
            if (selectedName == null || "".equals(selectedName)) {
                return;
            }
            this.replaceDlg.setReplaceName(selectedName);
            MatchReplaceGroup group = this.getSelectedReplaceGroup();
            this.replaceDlg.setInScopeOnly(group.isInScopeOnly());
            this.replaceDlg.setReplaceNameList(this.modelReplace.toList());
            this.replaceDlg.setMathReplaceList(group.getReplaceList());
        } else {
            this.replaceDlg.setReplaceNameList(this.modelReplace.toList());
            this.replaceDlg.setMathReplaceList(null);
        }
        this.replaceDlg.setVisible(true);
        if (this.replaceDlg.getModalResult() == JOptionPane.OK_OPTION) {
            String name = this.replaceDlg.getReplaceListName();

            MatchReplaceGroup grpup = new MatchReplaceGroup();
            List<MatchReplaceItem> list = this.replaceDlg.getMathReplaceList();
            grpup.setReplaceList(list);
            grpup.setInScopeOnly(this.replaceDlg.isInScopeOnly());
            this.replaceMap.put(name, grpup);

            if (this.modelReplace.contains(name)) {
                if (editMode) {
                    this.modelReplace.removeElement(name);
                } else {
                    this.modelReplace.removeElement(name);
                }
                this.modelReplace.addElement(name);
            } else {
                this.modelReplace.addElement(name);
            }
            this.listMatchReplace.setSelectedValue(name, true);
        }
        firePropertyChange(TabbetOption.MATCHREPLACE_PROPERTY, null, getMatchReplaceProperty());
    }
       
    private final Map<String, MatchReplaceGroup> replaceMap = new LinkedHashMap<String, MatchReplaceGroup>();

    private Map<String, MatchReplaceGroup> renewReplaceMap() {
        Map<String, MatchReplaceGroup> newMap = new LinkedHashMap<String, MatchReplaceGroup>();
        for (int i = 0; i < this.modelReplace.getSize(); i++) {
            String name = (String) this.modelReplace.get(i);
            MatchReplaceGroup group = this.replaceMap.get(name);
            List<MatchReplaceItem> list = group.getReplaceList();
            if (list == null) {
                continue;
            }
            newMap.put(name, group);
        }
        this.replaceMap.clear();
        this.replaceMap.putAll(newMap);
        return newMap;
    }

    protected String getReplaceSelectedName() {
        int index = this.listMatchReplace.getSelectedIndex();
        String name = null;
        if (index > -1) {
            name = (String) this.modelReplace.getElementAt(index);
        }
        return name;
    }
    protected MatchReplaceGroup getSelectedReplaceGroup() {
        String name = this.getReplaceSelectedName();
        return this.replaceMap.get(name);
    }
    
    protected List<MatchReplaceItem> getSelectedReplaceList() {
        String name = this.getReplaceSelectedName();
        MatchReplaceGroup group = this.replaceMap.get(name);
        return group.getReplaceList();
    }

    /**
     * @return the replaceMap
     */
    public Map<String, MatchReplaceGroup> getReplaceMap() {
        return this.replaceMap;
    }

    /**
     * @param replaceMap the replaceMap to set
     */
    public void setReplaceMap(Map<String, MatchReplaceGroup> replaceMap) {
        this.modelReplace.removeAllElements();
        List list = Util.toList(replaceMap.keySet().iterator());
        for (Object name : list) {
            this.modelReplace.addElement(name);
        }
        this.listMatchReplace.setSelectedIndex(0);
        this.replaceMap.clear();
        this.replaceMap.putAll(replaceMap);
    }

    @SuppressWarnings("unchecked")
    public List<String> getReplaceNameList() {
        return this.modelReplace.toList();
    }

    protected boolean getAutoRecogniseEncoding() {
        return this.rdoRepEnc_AutoRecognise.isSelected();
    }

    protected void setAutoRecogniseEncoding(boolean value) {
        this.rdoRepEnc_AutoRecognise.setSelected(value);
    }

    public void setMatchReplaceProperty(MatchReplaceProperty matchReplaceProperty) {
        this.selectedName = matchReplaceProperty.getSelectedName();
        this.setReplaceMap(matchReplaceProperty.getReplaceMap());
        this.setAutoRecogniseEncoding(matchReplaceProperty.getAutoRecogniseEncoding());
    }

    public MatchReplaceProperty getMatchReplaceProperty() {
        MatchReplaceProperty matchReplaceProperty = new MatchReplaceProperty();
        matchReplaceProperty.setSelectedName(this.selectedName);
        matchReplaceProperty.setReplaceMap(this.renewReplaceMap());
        matchReplaceProperty.setAutoRecogniseEncoding(this.getAutoRecogniseEncoding());
        return matchReplaceProperty;
    }

}
