package yagura.view;

import extend.view.base.RegexItem;
import yagura.model.KeywordHighlighter;
import yagura.model.StartEndPosion;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author isayan
 */
public class QuickSearchTab extends javax.swing.JPanel {

    /**
     * Creates new form QuickSearch
     */
    public QuickSearchTab() {
        initComponents();
        customizeComponents();
    }

    @SuppressWarnings("unchecked")
    private void customizeComponents() {
        this.chkUniq.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popQuick = new javax.swing.JPopupMenu();
        mnuRegex = new javax.swing.JCheckBoxMenuItem();
        mnuIgnoreCase = new javax.swing.JCheckBoxMenuItem();
        pnlEncode = new javax.swing.JPanel();
        cmbEncoding = new javax.swing.JComboBox();
        pnlSearch = new javax.swing.JPanel();
        btnQuickBack = new javax.swing.JButton();
        btnQuckOption = new javax.swing.JButton();
        btnQuickForward = new javax.swing.JButton();
        cmbQuckSearch = new javax.swing.JComboBox();
        lblMatch = new javax.swing.JLabel();
        chkUniq = new javax.swing.JCheckBox();

        mnuRegex.setSelected(true);
        mnuRegex.setText("regex");
        popQuick.add(mnuRegex);

        mnuIgnoreCase.setText("case sensitive");
        popQuick.add(mnuIgnoreCase);

        setLayout(new java.awt.BorderLayout());

        pnlEncode.setLayout(new javax.swing.BoxLayout(pnlEncode, javax.swing.BoxLayout.LINE_AXIS));

        cmbEncoding.setMaximumRowCount(10);
        cmbEncoding.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Shift_JIS" }));
        cmbEncoding.setToolTipText("");
        cmbEncoding.setMaximumSize(new java.awt.Dimension(150, 32767));
        cmbEncoding.setMinimumSize(new java.awt.Dimension(100, 19));
        cmbEncoding.setName(""); // NOI18N
        cmbEncoding.setPreferredSize(new java.awt.Dimension(120, 19));
        pnlEncode.add(cmbEncoding);

        add(pnlEncode, java.awt.BorderLayout.EAST);

        pnlSearch.setLayout(new javax.swing.BoxLayout(pnlSearch, javax.swing.BoxLayout.LINE_AXIS));

        btnQuickBack.setText("<");
        btnQuickBack.setMargin(new java.awt.Insets(2, 6, 2, 6));
        btnQuickBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickBackActionPerformed(evt);
            }
        });
        pnlSearch.add(btnQuickBack);

        btnQuckOption.setText("+");
        btnQuckOption.setMargin(new java.awt.Insets(2, 6, 2, 6));
        btnQuckOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuckOptionActionPerformed(evt);
            }
        });
        pnlSearch.add(btnQuckOption);

        btnQuickForward.setText(">");
        btnQuickForward.setMargin(new java.awt.Insets(2, 6, 2, 6));
        btnQuickForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickForwardActionPerformed(evt);
            }
        });
        pnlSearch.add(btnQuickForward);

        cmbQuckSearch.setEditable(true);
        pnlSearch.add(cmbQuckSearch);

        lblMatch.setText("0 match");
        pnlSearch.add(lblMatch);

        chkUniq.setSelected(true);
        chkUniq.setText("Uniq");
        pnlSearch.add(chkUniq);

        add(pnlSearch, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    protected final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("yagura/resources/Resource");
    
    private void btnQuckOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuckOptionActionPerformed
        Dimension sz = this.btnQuckOption.getSize();
        this.popQuick.show(this.btnQuckOption, 0, sz.height);
    }//GEN-LAST:event_btnQuckOptionActionPerformed

    private void btnQuickBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickBackActionPerformed
        this.quickSearchPerformed(false);
    }//GEN-LAST:event_btnQuickBackActionPerformed

    private void btnQuickForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickForwardActionPerformed
        this.quickSearchPerformed(true);
    }//GEN-LAST:event_btnQuickForwardActionPerformed

    private final KeywordHighlighter highlightKeyword = new KeywordHighlighter();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuckOption;
    private javax.swing.JButton btnQuickBack;
    private javax.swing.JButton btnQuickForward;
    private javax.swing.JCheckBox chkUniq;
    private javax.swing.JComboBox cmbEncoding;
    private javax.swing.JComboBox cmbQuckSearch;
    private javax.swing.JLabel lblMatch;
    private javax.swing.JCheckBoxMenuItem mnuIgnoreCase;
    private javax.swing.JCheckBoxMenuItem mnuRegex;
    private javax.swing.JPanel pnlEncode;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPopupMenu popQuick;
    // End of variables declaration//GEN-END:variables

    private javax.swing.text.JTextComponent txtTextArea;

    public void setSelectedTextArea(javax.swing.text.JTextComponent textArea) {
        this.txtTextArea = textArea;
        this.txtTextArea.setHighlighter(this.highlightKeyword);
    }

    public javax.swing.text.JTextComponent getSelectedTextArea() {
        return this.txtTextArea;
    }

    public javax.swing.JComboBox getEncodingComboBox() {
        return this.cmbEncoding;
    }

    public String getSelectedEncoding() {
        return (String) this.cmbEncoding.getSelectedItem();
    }

    public javax.swing.JCheckBox getUniqCheckBox() {
        return this.chkUniq;
    }

    public javax.swing.JPanel getSearchPanel() {
        return this.pnlSearch;
    }
        
    private void quickSearchPerformed(boolean forward) {
        javax.swing.text.JTextComponent ta = this.getSelectedTextArea();
        String s = (String) this.cmbQuckSearch.getEditor().getItem();
        if (s == null || (s != null && s.length() == 0)) {
            this.clearView();
            return;
        }
        // history
        this.cmbQuckSearch.setVisible(false);
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbQuckSearch.getModel();
        model.removeElement(s);
        model.insertElementAt(s, 0);
        this.cmbQuckSearch.setSelectedIndex(0);
        this.cmbQuckSearch.setVisible(true);

        if (ta.getHighlighter() instanceof KeywordHighlighter) {
            KeywordHighlighter high = (KeywordHighlighter) ta.getHighlighter();

            if (s.equals(high.getHighlightKeyword())
                    && this.regex == this.mnuRegex.isSelected()
                    && this.ignoreCase == this.mnuIgnoreCase.isSelected()) {
                high.searchPosition(forward);
            } else {
                if (isValidRegex(s)) {
                    this.quickSearch(ta, s);
                }
                else {
                    this.lblMatch.setText(BUNDLE.getString("view.invalid.regex"));
                    return;
                }
            }
            ta.requestFocus();
            this.lblMatch.setText(String.format("%d match", high.getPositionCount()));
            if (high.getPositionCount() <= 0) {
                return;
            }
            StartEndPosion pos = high.getSelectPosition();
            ta.select(pos.getStartPos(), pos.getEndPos());
        }
    }

    private boolean isValidRegex(String text) {
        int flags = 0;
        if (this.mnuIgnoreCase.isSelected()) {
            flags |= Pattern.CASE_INSENSITIVE;
        }
        return RegexItem.compileRegex(text, flags, !this.mnuRegex.isSelected()) != null;
    }
    
    private boolean regex = true;
    private boolean ignoreCase = false;
    
    protected void quickSearch(javax.swing.text.JTextComponent ta, String keyword) {
        if (ta.getHighlighter() instanceof KeywordHighlighter) {
            KeywordHighlighter hc = (KeywordHighlighter) ta.getHighlighter();
            hc.setHighlightKeyword(ta.getDocument(), keyword, !this.mnuRegex.isSelected(), this.mnuIgnoreCase.isSelected(), Color.RED);
            //this.keyword = keyword;
            this.regex = this.mnuRegex.isSelected();
            this.ignoreCase = this.mnuIgnoreCase.isSelected();
        }
    }

    public void clearView() {
        this.cmbQuckSearch.getEditor().setItem("");
        this.highlightKeyword.clearHighlightKeyword();
        this.lblMatch.setText(String.format("%d match", 0));
    }

    public void renewEncodingList(String defaultCharset, List<String> encodingLiest) {
        this.cmbEncoding.removeAllItems();
        for (String enc : encodingLiest) {
            this.cmbEncoding.addItem(enc);
        }
        this.cmbEncoding.setSelectedItem(defaultCharset);
    }

}
