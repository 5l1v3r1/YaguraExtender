package yagura.view;

import extend.view.base.RegexItem;
import yagura.model.KeywordHighlighter;
import yagura.model.StartEndPosion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.text.JTextComponent;
import extend.util.external.TransUtil;
import javax.swing.event.EventListenerList;
import yagura.model.QuickSearchEvent;
import yagura.model.QuickSearchListener;

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
        if (this.cmbQuckSearch.getEditor().getEditorComponent() instanceof JTextComponent) {
            JTextComponent tc = (JTextComponent) this.cmbQuckSearch.getEditor().getEditorComponent();
            tc.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    clearView();
                    quickSearchPerformed(true);
                    fireBackPerformedhEvent(newQuickSearchEvent(true));
               }
            });
            tc.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    clearView();
                    quickSearchPerformed(true, false);
                    fireBackPerformedhEvent(newQuickSearchEvent(true));
                }
            });

        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popQuick = new javax.swing.JPopupMenu();
        mnuSmartMatch = new javax.swing.JCheckBoxMenuItem();
        mnuRegex = new javax.swing.JCheckBoxMenuItem();
        mnuIgnoreCase = new javax.swing.JCheckBoxMenuItem();
        pnlEncode = new javax.swing.JPanel();
        cmbEncoding = new javax.swing.JComboBox();
        pnlSearch = new javax.swing.JPanel();
        pnlSearchNavi = new javax.swing.JPanel();
        btnQuickBack = new javax.swing.JButton();
        btnQuckOption = new javax.swing.JButton();
        btnQuickForward = new javax.swing.JButton();
        cmbQuckSearch = new javax.swing.JComboBox();
        pnlStatus = new javax.swing.JPanel();
        chkUniq = new javax.swing.JCheckBox();
        lblMatch = new javax.swing.JLabel();

        popQuick.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                popQuickPopupMenuWillBecomeVisible(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        mnuSmartMatch.setText("Smart Match");
        popQuick.add(mnuSmartMatch);

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

        pnlSearch.setLayout(new java.awt.BorderLayout());

        pnlSearchNavi.setLayout(new javax.swing.BoxLayout(pnlSearchNavi, javax.swing.BoxLayout.LINE_AXIS));

        btnQuickBack.setText("<");
        btnQuickBack.setMargin(new java.awt.Insets(2, 6, 2, 6));
        btnQuickBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickBackActionPerformed(evt);
            }
        });
        pnlSearchNavi.add(btnQuickBack);

        btnQuckOption.setText("+");
        btnQuckOption.setMargin(new java.awt.Insets(2, 6, 2, 6));
        btnQuckOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuckOptionActionPerformed(evt);
            }
        });
        pnlSearchNavi.add(btnQuckOption);

        btnQuickForward.setText(">");
        btnQuickForward.setMargin(new java.awt.Insets(2, 6, 2, 6));
        btnQuickForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickForwardActionPerformed(evt);
            }
        });
        pnlSearchNavi.add(btnQuickForward);

        pnlSearch.add(pnlSearchNavi, java.awt.BorderLayout.WEST);

        cmbQuckSearch.setEditable(true);
        pnlSearch.add(cmbQuckSearch, java.awt.BorderLayout.CENTER);

        pnlStatus.setLayout(new java.awt.BorderLayout());

        chkUniq.setSelected(true);
        chkUniq.setText("Uniq");
        pnlStatus.add(chkUniq, java.awt.BorderLayout.EAST);

        lblMatch.setText("0 match");
        pnlStatus.add(lblMatch, java.awt.BorderLayout.CENTER);

        pnlSearch.add(pnlStatus, java.awt.BorderLayout.EAST);

        add(pnlSearch, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("yagura/resources/Resource");

    private void btnQuckOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuckOptionActionPerformed
        Dimension sz = this.btnQuckOption.getSize();
        this.popQuick.show(this.btnQuckOption, 0, sz.height);
    }//GEN-LAST:event_btnQuckOptionActionPerformed

    private void btnQuickBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickBackActionPerformed
        this.quickSearchPerformed(false);
        this.fireForwardPerformedhEvent(newQuickSearchEvent(false));
    }//GEN-LAST:event_btnQuickBackActionPerformed

    private void btnQuickForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickForwardActionPerformed
        this.quickSearchPerformed(true);
        this.fireBackPerformedhEvent(newQuickSearchEvent(false));
    }//GEN-LAST:event_btnQuickForwardActionPerformed

    private void popQuickPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_popQuickPopupMenuWillBecomeVisible
        this.mnuRegex.setEnabled(!this.mnuSmartMatch.isSelected());
        this.smartMatch = this.mnuSmartMatch.isSelected();
        this.regex = this.mnuRegex.isSelected();
        this.ignoreCase = this.mnuIgnoreCase.isSelected();
    }//GEN-LAST:event_popQuickPopupMenuWillBecomeVisible

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
    private javax.swing.JCheckBoxMenuItem mnuSmartMatch;
    private javax.swing.JPanel pnlEncode;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlSearchNavi;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JPopupMenu popQuick;
    // End of variables declaration//GEN-END:variables

    public void setMessageFont(Font font) {
        this.cmbQuckSearch.setFont(font);
    }

    private javax.swing.text.JTextComponent txtTextArea = null;

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
        quickSearchPerformed(forward, true);
    }

    private void quickSearchPerformed(boolean forward, boolean appendHistory) {
        javax.swing.text.JTextComponent ta = this.getSelectedTextArea();
        String searchText = (String) this.cmbQuckSearch.getEditor().getItem();
        if (searchText == null || searchText.length() == 0) {
            this.clearView();
            return;
        }
        // history
        if (appendHistory) {
            this.cmbQuckSearch.setVisible(false);
            DefaultComboBoxModel model = (DefaultComboBoxModel) this.cmbQuckSearch.getModel();
            model.removeElement(searchText);
            model.insertElementAt(searchText, 0);
            this.cmbQuckSearch.setSelectedIndex(0);
            this.cmbQuckSearch.setVisible(true);
        }

        if (ta.getHighlighter() instanceof KeywordHighlighter) {
            KeywordHighlighter high = (KeywordHighlighter) ta.getHighlighter();
            if (this.keyword != null
                    && this.smartMatch == this.mnuSmartMatch.isSelected()
                    && this.regex == this.mnuRegex.isSelected()
                    && this.ignoreCase == this.mnuIgnoreCase.isSelected()
                    && (this.keyword.equals(searchText)
                    || (this.mnuSmartMatch.isSelected()
                    && keyword.equals(TransUtil.toSmartMatch(searchText))))) {
                high.searchPosition(forward);
            } else {
                if (isValidRegex(searchText)) {
                    this.quickSearch(ta, searchText);
                } else {
                    this.lblMatch.setText(BUNDLE.getString("view.invalid.regex"));
                    return;
                }
            }
            //ta.requestFocus();
            this.lblMatch.setText(String.format("%d match", high.getPositionCount()));
            if (high.getPositionCount() > 0) {
                this.lblMatch.setBackground(Color.ORANGE);
                this.lblMatch.setOpaque(true);
                // 解除
                final Timer timer = new Timer(false);
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        lblMatch.setBackground(null);
                        lblMatch.setOpaque(false);
                        timer.cancel();
                    }
                };
                timer.schedule(task, 1000);
            }
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

    private String keyword = null;
    private boolean smartMatch = false;
    private boolean regex = false;
    private boolean ignoreCase = false;

    protected void quickSearch(javax.swing.text.JTextComponent ta, String keyword) {
        if (ta.getHighlighter() instanceof KeywordHighlighter) {
            KeywordHighlighter hc = (KeywordHighlighter) ta.getHighlighter();
            this.smartMatch = this.mnuSmartMatch.isSelected();
            this.regex = this.mnuRegex.isSelected();
            this.ignoreCase = this.mnuIgnoreCase.isSelected();
            if (this.mnuSmartMatch.isSelected()) {
                this.keyword = TransUtil.toSmartMatch(keyword);
                hc.setHighlightKeyword(ta.getDocument(), this.keyword, false, this.ignoreCase, Color.YELLOW);
            } else {
                this.keyword = keyword;
                hc.setHighlightKeyword(ta.getDocument(), this.keyword, !this.regex, this.ignoreCase, Color.YELLOW);
            }
        }
    }

    public void clearView() {
        this.keyword = null;
        this.highlightKeyword.clearHighlightKeyword();
        this.lblMatch.setText(String.format("%d match", 0));
    }

    public void clearViewAndSearch() {
        clearView();
        this.quickSearchPerformed(true);
        this.fireForwardPerformedhEvent(newQuickSearchEvent(true));        
    }

    public void renewEncodingList(String defaultCharset, List<String> encodingLiest) {
        this.cmbEncoding.removeAllItems();
        for (String enc : encodingLiest) {
            this.cmbEncoding.addItem(enc);
        }
        this.cmbEncoding.setSelectedItem(defaultCharset);
    }

    private final EventListenerList quickSearchEventList = new EventListenerList();
        
    protected void fireBackPerformedhEvent(QuickSearchEvent evt) {
        Object[] listeners = this.quickSearchEventList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == QuickSearchListener.class) {
                ((QuickSearchListener) listeners[i + 1]).quickBackPerformed(evt);
            }
        }
    }

    protected void fireForwardPerformedhEvent(QuickSearchEvent evt) {
        Object[] listeners = this.quickSearchEventList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == QuickSearchListener.class) {
                ((QuickSearchListener) listeners[i + 1]).quickForwardPerformed(evt);
            }
        }
    }

    public void addQuickSearchListener(QuickSearchListener l) {
        this.quickSearchEventList.add(QuickSearchListener.class, l);
    }

    public void removeQuickSearchListener(QuickSearchListener l) {
        this.quickSearchEventList.remove(QuickSearchListener.class, l);
    }

    private QuickSearchEvent newQuickSearchEvent(boolean clearView) {
        return new QuickSearchEvent(this, this.keyword, this.smartMatch, this.regex, this.ignoreCase, clearView);
    }
            
}
