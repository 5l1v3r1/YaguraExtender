/*
 * ResultFilterPopup.java
 *
 * Created on 2010/08/07, 17:39:47
 */
package yagura.view;

import extend.util.BurpWrap;
import yagura.model.FilterProperty;
import extend.view.base.MatchItem;
import extend.view.base.MatchItem.HighlightColor;
import extend.util.Util;
import extend.view.model.VerticalFlowLayout;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import yagura.model.HttpMessageItem;

/**
 *
 * @author isayan
 */
public class ResultFilterPopup extends javax.swing.JFrame {

    /**
     * Creates new form ResultFilterPopup
     */
    public ResultFilterPopup() {
        this.setUndecorated(true);
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
        pnlCenter = new javax.swing.JPanel();
        pnlFilterByRequest = new javax.swing.JPanel();
        chkShowOnlyinscopeItem = new javax.swing.JCheckBox();
        chkHideItemsWithoutResponses = new javax.swing.JCheckBox();
        pnlExtension = new javax.swing.JPanel();
        txtShowOnly = new javax.swing.JTextField();
        txtHide = new javax.swing.JTextField();
        chkShowOnly = new javax.swing.JCheckBox();
        chkHide = new javax.swing.JCheckBox();
        pnlStatus = new javax.swing.JPanel();
        chkStat2xx = new javax.swing.JCheckBox();
        chkStat3xx = new javax.swing.JCheckBox();
        chkStat4xx = new javax.swing.JCheckBox();
        chkStat5xx = new javax.swing.JCheckBox();
        pnlRight = new javax.swing.JPanel();
        pnlComment = new javax.swing.JPanel();
        chkComment = new javax.swing.JCheckBox();
        pnlHighlightColor = new javax.swing.JPanel();
        chkWhite = new javax.swing.JCheckBox();
        chkRed = new javax.swing.JCheckBox();
        chkOrange = new javax.swing.JCheckBox();
        chkYellow = new javax.swing.JCheckBox();
        chkGreen = new javax.swing.JCheckBox();
        chkCyan = new javax.swing.JCheckBox();
        chkBlue = new javax.swing.JCheckBox();
        chkPink = new javax.swing.JCheckBox();
        chkMagenta = new javax.swing.JCheckBox();
        chkGray = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 250));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        pnlMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlMain.setMinimumSize(new java.awt.Dimension(500, 250));
        pnlMain.setName(""); // NOI18N
        pnlMain.setPreferredSize(new java.awt.Dimension(500, 300));
        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlCenter.setMinimumSize(new java.awt.Dimension(217, 250));
        pnlCenter.setName(""); // NOI18N
        pnlCenter.setPreferredSize(new java.awt.Dimension(500, 300));
        pnlCenter.setLayout(new javax.swing.BoxLayout(pnlCenter, javax.swing.BoxLayout.Y_AXIS));

        pnlFilterByRequest.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter by request type"));
        pnlFilterByRequest.setLayout(new javax.swing.BoxLayout(pnlFilterByRequest, javax.swing.BoxLayout.Y_AXIS));

        chkShowOnlyinscopeItem.setText("Show only in-scope items");
        pnlFilterByRequest.add(chkShowOnlyinscopeItem);

        chkHideItemsWithoutResponses.setText("Hide items without responses");
        pnlFilterByRequest.add(chkHideItemsWithoutResponses);

        pnlCenter.add(pnlFilterByRequest);

        pnlExtension.setBorder(javax.swing.BorderFactory.createTitledBorder("Filter by extension"));
        pnlExtension.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        pnlExtension.setMinimumSize(new java.awt.Dimension(133, 100));
        pnlExtension.setName(""); // NOI18N
        pnlExtension.setPreferredSize(new java.awt.Dimension(564, 100));

        txtShowOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShowOnlyActionPerformed(evt);
            }
        });

        chkShowOnly.setText("show only:");
        chkShowOnly.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkShowOnlyStateChanged(evt);
            }
        });

        chkHide.setText("hide:");

        javax.swing.GroupLayout pnlExtensionLayout = new javax.swing.GroupLayout(pnlExtension);
        pnlExtension.setLayout(pnlExtensionLayout);
        pnlExtensionLayout.setHorizontalGroup(
            pnlExtensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlExtensionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExtensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkHide)
                    .addComponent(chkShowOnly))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlExtensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtShowOnly, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(txtHide))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        pnlExtensionLayout.setVerticalGroup(
            pnlExtensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExtensionLayout.createSequentialGroup()
                .addGroup(pnlExtensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkShowOnly)
                    .addComponent(txtShowOnly))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlExtensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkHide))
                .addGap(86, 86, 86))
        );

        pnlCenter.add(pnlExtension);
        pnlExtension.getAccessibleContext().setAccessibleDescription("");

        pnlStatus.setBorder(javax.swing.BorderFactory.createTitledBorder("Status Filter"));
        pnlStatus.setMaximumSize(new java.awt.Dimension(133, 110));
        pnlStatus.setMinimumSize(new java.awt.Dimension(133, 110));
        pnlStatus.setPreferredSize(new java.awt.Dimension(200, 130));
        pnlStatus.setRequestFocusEnabled(false);
        pnlStatus.setLayout(new javax.swing.BoxLayout(pnlStatus, javax.swing.BoxLayout.Y_AXIS));

        chkStat2xx.setText("2xx [success]");
        pnlStatus.add(chkStat2xx);

        chkStat3xx.setText("3xx [redirection]");
        pnlStatus.add(chkStat3xx);

        chkStat4xx.setText("4xx [request error]");
        pnlStatus.add(chkStat4xx);

        chkStat5xx.setText("5xx [server error]");
        chkStat5xx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkStat5xxActionPerformed(evt);
            }
        });
        pnlStatus.add(chkStat5xx);

        pnlCenter.add(pnlStatus);

        pnlMain.add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlRight.setLayout(new java.awt.BorderLayout());

        pnlComment.setBorder(javax.swing.BorderFactory.createTitledBorder("Comment"));

        chkComment.setText("comment");
        chkComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCommentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCommentLayout = new javax.swing.GroupLayout(pnlComment);
        pnlComment.setLayout(pnlCommentLayout);
        pnlCommentLayout.setHorizontalGroup(
            pnlCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCommentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkComment)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        pnlCommentLayout.setVerticalGroup(
            pnlCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCommentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkComment)
                .addContainerGap())
        );

        pnlRight.add(pnlComment, java.awt.BorderLayout.SOUTH);

        pnlHighlightColor.setBorder(javax.swing.BorderFactory.createTitledBorder("Highlight Color"));
        pnlHighlightColor.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        pnlHighlightColor.setMinimumSize(new java.awt.Dimension(100, 250));
        pnlHighlightColor.setName(""); // NOI18N
        pnlHighlightColor.setPreferredSize(new java.awt.Dimension(100, 250));
        pnlHighlightColor.setLayout(new javax.swing.BoxLayout(pnlHighlightColor, javax.swing.BoxLayout.Y_AXIS));

        chkWhite.setText("white (unselect)");
        pnlHighlightColor.add(chkWhite);

        chkRed.setText("red");
        pnlHighlightColor.add(chkRed);

        chkOrange.setText("orange");
        pnlHighlightColor.add(chkOrange);

        chkYellow.setText("yellow");
        pnlHighlightColor.add(chkYellow);

        chkGreen.setText("green");
        pnlHighlightColor.add(chkGreen);

        chkCyan.setText("cyan");
        pnlHighlightColor.add(chkCyan);

        chkBlue.setText("blue");
        pnlHighlightColor.add(chkBlue);

        chkPink.setText("pink");
        pnlHighlightColor.add(chkPink);

        chkMagenta.setText("magenta");
        pnlHighlightColor.add(chkMagenta);

        chkGray.setText("gray");
        pnlHighlightColor.add(chkGray);

        pnlRight.add(pnlHighlightColor, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlRight, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("unchecked")
    private void customizeComponents() {
        this.pnlCenter.setLayout(new VerticalFlowLayout());
    }

    private void txtShowOnlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShowOnlyActionPerformed
    }//GEN-LAST:event_txtShowOnlyActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        this.setVisible(false);
    }//GEN-LAST:event_formWindowDeactivated

    private void chkShowOnlyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkShowOnlyStateChanged
        this.chkHide.setEnabled(!this.chkShowOnly.isSelected());
    }//GEN-LAST:event_chkShowOnlyStateChanged

    private void chkStat5xxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkStat5xxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkStat5xxActionPerformed

    private void chkCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCommentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkCommentActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ResultFilterPopup().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkBlue;
    private javax.swing.JCheckBox chkComment;
    private javax.swing.JCheckBox chkCyan;
    private javax.swing.JCheckBox chkGray;
    private javax.swing.JCheckBox chkGreen;
    private javax.swing.JCheckBox chkHide;
    private javax.swing.JCheckBox chkHideItemsWithoutResponses;
    private javax.swing.JCheckBox chkMagenta;
    private javax.swing.JCheckBox chkOrange;
    private javax.swing.JCheckBox chkPink;
    private javax.swing.JCheckBox chkRed;
    private javax.swing.JCheckBox chkShowOnly;
    private javax.swing.JCheckBox chkShowOnlyinscopeItem;
    private javax.swing.JCheckBox chkStat2xx;
    private javax.swing.JCheckBox chkStat3xx;
    private javax.swing.JCheckBox chkStat4xx;
    private javax.swing.JCheckBox chkStat5xx;
    private javax.swing.JCheckBox chkWhite;
    private javax.swing.JCheckBox chkYellow;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlComment;
    private javax.swing.JPanel pnlExtension;
    private javax.swing.JPanel pnlFilterByRequest;
    private javax.swing.JPanel pnlHighlightColor;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JTextField txtHide;
    private javax.swing.JTextField txtShowOnly;
    // End of variables declaration//GEN-END:variables

    public void setProperty(FilterProperty filterProp) {
        this.chkShowOnlyinscopeItem.setSelected(filterProp.getShowOnlyScopeItems());
        this.chkHideItemsWithoutResponses.setSelected(filterProp.isHideItemsWithoutResponses());
        this.chkShowOnly.setSelected(filterProp.getShowOnly());
        this.txtShowOnly.setText(filterProp.getShowOnlyExtension());
        this.chkHide.setSelected(filterProp.getHide());
        this.txtHide.setText(filterProp.getHideExtension());
        this.chkStat2xx.getModel().setSelected(filterProp.getStat2xx());
        this.chkStat3xx.getModel().setSelected(filterProp.getStat3xx());
        this.chkStat4xx.getModel().setSelected(filterProp.getStat4xx());
        this.chkStat5xx.getModel().setSelected(filterProp.getStat5xx());
        this.setHighlightColors(filterProp.getHighlightColors());
        this.setComments(filterProp.getComments());
    }

    public FilterProperty getProperty() {
        FilterProperty filterProp = new FilterProperty();
        filterProp.setShowOnlyScopeItems(this.chkShowOnlyinscopeItem.isSelected());
        filterProp.setHideItemsWithoutResponses(this.chkHideItemsWithoutResponses.isSelected());
        filterProp.setShowOnly(this.chkShowOnly.isSelected());
        filterProp.setShowOnlyExtension(this.txtShowOnly.getText());
        filterProp.setHide(this.chkHide.isSelected());
        filterProp.setHideExtension(this.txtHide.getText());
        filterProp.setStat2xx(this.chkStat2xx.getModel().isSelected());        
        filterProp.setStat3xx(this.chkStat3xx.getModel().isSelected());
        filterProp.setStat4xx(this.chkStat4xx.getModel().isSelected());
        filterProp.setStat5xx(this.chkStat5xx.getModel().isSelected());
        filterProp.setHighlightColors(this.getHighlightColors());
        filterProp.setComments(this.getComments());
        return filterProp;
    }

    public EnumSet<HighlightColor> getHighlightColors() {
        EnumSet<MatchItem.HighlightColor> colors = EnumSet.noneOf(MatchItem.HighlightColor.class);
        if (this.chkWhite.isSelected()) {
            colors.add(HighlightColor.WHITE);
        }
        if (this.chkRed.isSelected()) {
            colors.add(HighlightColor.RED);
        }
        if (this.chkOrange.isSelected()) {
            colors.add(HighlightColor.ORANGE);
        }
        if (this.chkYellow.isSelected()) {
            colors.add(HighlightColor.YELLOW);
        }
        if (this.chkGreen.isSelected()) {
            colors.add(HighlightColor.GREEN);
        }
        if (this.chkCyan.isSelected()) {
            colors.add(HighlightColor.CYAN);
        }
        if (this.chkBlue.isSelected()) {
            colors.add(HighlightColor.BLUE);
        }
        if (this.chkPink.isSelected()) {
            colors.add(HighlightColor.PINK);
        }
        if (this.chkMagenta.isSelected()) {
            colors.add(HighlightColor.MAGENTA);
        }
        if (this.chkGray.isSelected()) {
            colors.add(HighlightColor.GRAY);
        }
        return colors;
    }
    
    public void setHighlightColors(EnumSet<HighlightColor> colors) {
        this.chkWhite.setSelected(colors.contains(HighlightColor.WHITE));
        this.chkRed.setSelected(colors.contains(HighlightColor.RED));
        this.chkOrange.setSelected(colors.contains(HighlightColor.ORANGE));
        this.chkYellow.setSelected(colors.contains(HighlightColor.YELLOW));
        this.chkGreen.setSelected(colors.contains(HighlightColor.GREEN));
        this.chkCyan.setSelected(colors.contains(HighlightColor.CYAN));
        this.chkBlue.setSelected(colors.contains(HighlightColor.BLUE));
        this.chkPink.setSelected(colors.contains(HighlightColor.PINK));
        this.chkMagenta.setSelected(colors.contains(HighlightColor.MAGENTA));
        this.chkGray.setSelected(colors.contains(HighlightColor.GRAY));
    }

    public boolean getComments() {
        return this.chkComment.isSelected();
    }

    public void setComments(boolean comment) {
        this.chkComment.setSelected(comment);
    }
    
    public static class PropertyRowFilter extends RowFilter<Object, Object> {

        private final FilterProperty filterProp;

        public PropertyRowFilter(FilterProperty filterProp) {
            this.filterProp = filterProp;
        }

        @Override
        public boolean include(RowFilter.Entry<? extends Object, ? extends Object> entry) {
            boolean allFilter = false;

            try {
                HttpMessageItem item = HttpMessageItem.toHttpMessageItem(entry);
                boolean showOnlyScopFilter = true;
                // Filter by request type
                if (this.filterProp.getShowOnlyScopeItems()) {
                    showOnlyScopFilter = BurpWrap.isInScope(item.getUrl());
                }
                boolean hideItemsWithoutResponses = true;
                if (this.filterProp.isHideItemsWithoutResponses()) {
                    hideItemsWithoutResponses = (item.getResponse() != null);
                }
                // status filter
                boolean statusFilter = false;
                if (showOnlyScopFilter) {
                    // Response Status がない場合は無条件で含める
                    if (item.getStatusCode() == 0) {
                        statusFilter = true;
                    }

                    if (this.filterProp.getStat2xx() && (200 <= item.getStatusCode() && item.getStatusCode() < 300)) {
                        statusFilter = true;
                    }
                    if (this.filterProp.getStat3xx() && (300 <= item.getStatusCode() && item.getStatusCode() < 400)) {
                        statusFilter = true;
                    }
                    if (this.filterProp.getStat4xx() && (400 <= item.getStatusCode() && item.getStatusCode() < 500)) {
                        statusFilter = true;
                    }
                    if (this.filterProp.getStat5xx() && (500 <= item.getStatusCode() && item.getStatusCode() < 600)) {
                        statusFilter = true;
                    }

                }
                // color filter
                boolean colorFilter = false;
                if (statusFilter && showOnlyScopFilter) {
                    // cololr
                    EnumSet<HighlightColor> colors = this.filterProp.getHighlightColors();
                    MatchItem.HighlightColor hc = MatchItem.HighlightColor.parseValue(BurpWrap.getHighlightColor(item));
                    if (colors.contains(hc)) {
                        colorFilter = true;
                    }
                }
                // comment filter
                boolean commentFilter = true;
                if (statusFilter && showOnlyScopFilter) {                
                    // comment
                    if (this.filterProp.getComments()) {
                        commentFilter = (item.getComment() != null);                        
                    }
                }               
                // showOnly Filter
                boolean matchFilter = true;
                if (statusFilter && showOnlyScopFilter && colorFilter) {
                    if (this.filterProp.getShowOnly()) {
                        Pattern patternShowOnly = Pattern.compile(BurpWrap.parseFilterPattern(this.filterProp.getShowOnlyExtension()));
                        Matcher matchShowOnly = patternShowOnly.matcher(item.getUrl().getPath());
                        if (!matchShowOnly.find()) {
                            matchFilter = false;
                        }
                    } else {
                        if (this.filterProp.getHide()) {
                            Pattern patternHide = Pattern.compile(BurpWrap.parseFilterPattern(this.filterProp.getHideExtension()));
                            Matcher matchHide = patternHide.matcher(item.getUrl().getPath());
                            if (matchHide.find()) {
                                matchFilter = false;
                            }
                        }
                    }
                }
                // 条件のAND
                allFilter = (statusFilter && colorFilter && commentFilter && matchFilter && showOnlyScopFilter && hideItemsWithoutResponses);
            } catch (Exception ex) {
                Logger.getLogger(ResultFilterPopup.class.getName()).log(Level.SEVERE, null, ex);
            }
            return allFilter;
        }

    }

    public static class PropertyRowSorter<M extends TableModel> extends TableRowSorter {

        public PropertyRowSorter(M model) {
            super(model);
        }

        private final NumberComparator numberComparator = new NumberComparator();

        @Override
        public Comparator<?> getComparator(int column) {
            if (column == 1) {
                return numberComparator;
            } else {
                return super.getComparator(column);
            }
        }
    }

    private static class NumberComparator implements Comparator {

        @SuppressWarnings("unchecked")
        @Override
        public int compare(Object o1, Object o2) {
            try {
                int parseIntA = Integer.valueOf(o1.toString());
                int parseIntB = Integer.valueOf(o2.toString());
                return parseIntA - parseIntB;
            } catch (NumberFormatException e) {
                if (o1 instanceof Comparator) {
                    return ((Comparator) o1).compare(o1, o2);
                } else {
                    return Util.compareToString(o1.toString(), o2.toString());
                }
            }
        }
    }

}
