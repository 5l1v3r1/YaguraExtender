package yagura.view;

import burp.BurpExtender;
import burp.IHttpRequestResponse;
import burp.IRequestInfo;
import burp.IResponseInfo;
import extend.model.base.DefaultObjectTableModel;
import extend.util.Util;
import extend.view.base.MatchItem;
import extend.view.base.NamedColor;
import extend.view.base.RegexItem;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import yagura.external.TransUtil;
import yagura.model.FilterProperty;
import yagura.model.HttpMessageItem;
import yagura.model.JSearchProperty;
import yagura.model.ResultView;

/**
 *
 * @author isayan
 */
public class JSearchTab extends javax.swing.JPanel {

    /**
     * Creates new form JSerchTab
     */
    public JSearchTab() {
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
        pnlSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        chkRegExp = new javax.swing.JCheckBox();
        chkIgnoreCase = new javax.swing.JCheckBox();
        chkComment = new javax.swing.JCheckBox();
        pnlSearchEnc = new javax.swing.JPanel();
        rdoRepEnc_8859_1 = new javax.swing.JRadioButton();
        rdoRepEnc_AutoRecognise = new javax.swing.JRadioButton();
        pnlRequest = new javax.swing.JPanel();
        chkRequestHeader = new javax.swing.JCheckBox();
        chkRequestBody = new javax.swing.JCheckBox();
        pnlRequest1 = new javax.swing.JPanel();
        chkResponseHeader = new javax.swing.JCheckBox();
        chkResponseBody = new javax.swing.JCheckBox();
        lblProgress = new javax.swing.JLabel();
        chkScopeOnly = new javax.swing.JCheckBox();
        chkSmartMatch = new javax.swing.JCheckBox();
        pnlResult = new javax.swing.JPanel();
        pnlResultView = new javax.swing.JPanel();
        lblFilter = new javax.swing.JLabel();
        splitResult = new javax.swing.JSplitPane();
        scrollResult = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        pnlView = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        chkRegExp.setSelected(true);
        chkRegExp.setText("RegExp");
        chkRegExp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRegExpStateChanged(evt);
            }
        });

        chkIgnoreCase.setText("IgnoreCase");
        chkIgnoreCase.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkIgnoreCaseStateChanged(evt);
            }
        });

        chkComment.setSelected(true);
        chkComment.setText("Comment");
        chkComment.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkCommentStateChanged(evt);
            }
        });

        pnlSearchEnc.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Encoding"));
        pnlSearchEnc.setLayout(new javax.swing.BoxLayout(pnlSearchEnc, javax.swing.BoxLayout.Y_AXIS));

        rdoEncodeingGrp.add(rdoRepEnc_8859_1);
        rdoRepEnc_8859_1.setSelected(true);
        rdoRepEnc_8859_1.setText("Raw(8859_1)");
        pnlSearchEnc.add(rdoRepEnc_8859_1);

        rdoEncodeingGrp.add(rdoRepEnc_AutoRecognise);
        rdoRepEnc_AutoRecognise.setText("AutoRecognise");
        rdoRepEnc_AutoRecognise.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdoRepEnc_AutoRecogniseStateChanged(evt);
            }
        });
        pnlSearchEnc.add(rdoRepEnc_AutoRecognise);

        pnlRequest.setBorder(javax.swing.BorderFactory.createTitledBorder("Request"));

        chkRequestHeader.setSelected(true);
        chkRequestHeader.setText("Header");
        chkRequestHeader.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRequestHeaderStateChanged(evt);
            }
        });

        chkRequestBody.setSelected(true);
        chkRequestBody.setText("Body");
        chkRequestBody.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkRequestBodyStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlRequestLayout = new javax.swing.GroupLayout(pnlRequest);
        pnlRequest.setLayout(pnlRequestLayout);
        pnlRequestLayout.setHorizontalGroup(
            pnlRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkRequestHeader)
                    .addComponent(chkRequestBody))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlRequestLayout.setVerticalGroup(
            pnlRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRequestLayout.createSequentialGroup()
                .addComponent(chkRequestHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkRequestBody))
        );

        pnlRequest1.setBorder(javax.swing.BorderFactory.createTitledBorder("Response"));

        chkResponseHeader.setSelected(true);
        chkResponseHeader.setText("Header");
        chkResponseHeader.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkResponseHeaderStateChanged(evt);
            }
        });

        chkResponseBody.setSelected(true);
        chkResponseBody.setText("Body");
        chkResponseBody.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkResponseBodyStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlRequest1Layout = new javax.swing.GroupLayout(pnlRequest1);
        pnlRequest1.setLayout(pnlRequest1Layout);
        pnlRequest1Layout.setHorizontalGroup(
            pnlRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRequest1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkResponseHeader)
                    .addComponent(chkResponseBody))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlRequest1Layout.setVerticalGroup(
            pnlRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRequest1Layout.createSequentialGroup()
                .addComponent(chkResponseHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkResponseBody))
        );

        lblProgress.setText("100.0%");

        chkScopeOnly.setText("in-scope only");

        chkSmartMatch.setText("Smart Match");
        chkSmartMatch.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkSmartMatchStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(pnlRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkComment))
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(chkScopeOnly, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkSmartMatch)
                            .addComponent(chkRegExp)
                            .addComponent(chkIgnoreCase, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(pnlSearchEnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(lblProgress))
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSearchLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chkScopeOnly)
                            .addComponent(chkSmartMatch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkRegExp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkIgnoreCase)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSearchLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(chkComment)
                        .addGap(30, 30, 30))
                    .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlRequest1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(pnlSearchEnc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(pnlSearch, java.awt.BorderLayout.NORTH);

        pnlResult.setLayout(new java.awt.BorderLayout());

        pnlResultView.setPreferredSize(new java.awt.Dimension(100, 20));
        pnlResultView.setLayout(new java.awt.BorderLayout());

        lblFilter.setText("Filter:");
        lblFilter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblFilterMousePressed(evt);
            }
        });
        pnlResultView.add(lblFilter, java.awt.BorderLayout.CENTER);

        pnlResult.add(pnlResultView, java.awt.BorderLayout.NORTH);

        splitResult.setDividerLocation(100);
        splitResult.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "#", "host", "method", "URL", "status", "length", "comment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableResult.setMinimumSize(new java.awt.Dimension(105, 100));
        tableResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableResultMouseClicked(evt);
            }
        });
        scrollResult.setViewportView(tableResult);

        splitResult.setLeftComponent(scrollResult);

        pnlView.setLayout(new java.awt.BorderLayout());
        splitResult.setRightComponent(pnlView);

        pnlResult.add(splitResult, java.awt.BorderLayout.CENTER);

        add(pnlResult, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private DefaultObjectTableModel<ResultView> modelSearch = null;
    private MessageViewTab tabMessageView = new MessageViewTab();
    private JComboBox cmbColor = new JComboBox();
    private DefaultTableCellRenderer colorTableRenderer = new DefaultTableCellRenderer() {

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {
            Object c = table.getValueAt(row, 1);
            NamedColor namedColor = null;
            if (c instanceof NamedColor) {
                namedColor = (NamedColor) c;
            }
            Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
            } else {
                if (namedColor != null) {
                    component.setForeground(namedColor.getTextColor());
                    component.setBackground(namedColor);
                } else {
                    component.setForeground(SystemColor.textText);
                    component.setBackground(SystemColor.text);
                }
            }
            return component;
        }
    };
    private final BasicComboBoxRenderer colorComboBoxRenderer = new BasicComboBoxRenderer() {

        @Override
        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {

            NamedColor c = null;
            if (value instanceof NamedColor) {
                c = (NamedColor) value;
                value = c.getText();
            }
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (c != null) {
                component.setBackground(c);
                component.setForeground(c.getTextColor());
            } else {
                component.setForeground(SystemColor.textText);
                component.setBackground(SystemColor.text);
            }
            return component;
        }
    };

    private final ResultFilterPopup filterPopup = new ResultFilterPopup();

    @SuppressWarnings("unchecked")
    private void customizeComponents() {

        // group
        this.rdoEncodeingGrp.add(this.rdoRepEnc_8859_1);
        this.rdoEncodeingGrp.add(this.rdoRepEnc_AutoRecognise);

        this.filterPopup.addWindowListener(new WindowAdapter() {

            @Override
            public void windowDeactivated(WindowEvent e) {
                setVisibleFilter(false);
            }
        });
        this.filterPopup.addWindowListener(new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {
                // 値の設定
                showFilter();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // 値の取得
                hideFilter();
            }

        });
        
        this.pnlView.add(this.tabMessageView, BorderLayout.CENTER);
        this.tabMessageView.setVisible(false);

        this.modelSearch = new DefaultObjectTableModel<>(this.tableResult.getModel());
        this.modelSearch.setCellEditable(true);
        this.tableResult.setModel(this.modelSearch);

        this.tableResult.getSelectionModel().addListSelectionListener(newListSelectionListener());

        this.txtSearch.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    search();
                }
            }
        });

        // #                
        this.cmbColor.setMaximumRowCount(10);
        this.cmbColor.setRenderer(this.colorComboBoxRenderer);
        this.cmbColor.addItem(""); // nonselect
        for (MatchItem.HighlightColor c : MatchItem.HighlightColor.values()) {
            if (c == MatchItem.HighlightColor.WHITE) {
                continue;
            }
            this.cmbColor.addItem(new NamedColor(c.toColor(), c.name().toLowerCase()));
        }

        this.tableResult.setDefaultRenderer(Object.class, this.colorTableRenderer);
        this.tableResult.setDefaultRenderer(Integer.class, this.colorTableRenderer);

        TableColumn colorColumn = this.tableResult.getColumnModel().getColumn(1);
        colorColumn.setCellEditor(new DefaultCellEditor(this.cmbColor));

        // Data        
        this.tableResult.getColumnModel().getColumn(0).setMinWidth(0);
        this.tableResult.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.tableResult.getColumnModel().getColumn(0).setMaxWidth(0);

        // #        
        this.tableResult.getColumnModel().getColumn(1).setMinWidth(20);
        this.tableResult.getColumnModel().getColumn(1).setPreferredWidth(60);
        this.tableResult.getColumnModel().getColumn(1).setMaxWidth(80);

        // host
        this.tableResult.getColumnModel().getColumn(2).setPreferredWidth(120);

        // method
        this.tableResult.getColumnModel().getColumn(3).setMinWidth(30);
        this.tableResult.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.tableResult.getColumnModel().getColumn(3).setMaxWidth(50);

        // url
        this.tableResult.getColumnModel().getColumn(4).setPreferredWidth(120);

        // status
        this.tableResult.getColumnModel().getColumn(5).setMinWidth(30);
        this.tableResult.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.tableResult.getColumnModel().getColumn(5).setMaxWidth(50);

        // length
        this.tableResult.getColumnModel().getColumn(6).setPreferredWidth(40);

        // comment
        this.tableResult.getColumnModel().getColumn(7).setPreferredWidth(80);

        this.tableResult.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
    }

    private void lblFilterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFilterMousePressed
        this.setVisibleFilter(true);
    }//GEN-LAST:event_lblFilterMousePressed

    private void tableResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableResultMouseClicked
        this.showBurpMenu(evt);
    }//GEN-LAST:event_tableResultMouseClicked

    private void chkResponseBodyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkResponseBodyStateChanged
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());
    }//GEN-LAST:event_chkResponseBodyStateChanged

    private void chkResponseHeaderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkResponseHeaderStateChanged
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());
    }//GEN-LAST:event_chkResponseHeaderStateChanged

    private void chkRequestBodyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRequestBodyStateChanged
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());
    }//GEN-LAST:event_chkRequestBodyStateChanged

    private void chkRequestHeaderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRequestHeaderStateChanged
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());
    }//GEN-LAST:event_chkRequestHeaderStateChanged

    private void rdoRepEnc_AutoRecogniseStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdoRepEnc_AutoRecogniseStateChanged
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());
    }//GEN-LAST:event_rdoRepEnc_AutoRecogniseStateChanged

    private void chkCommentStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkCommentStateChanged
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());
    }//GEN-LAST:event_chkCommentStateChanged

    private void chkIgnoreCaseStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkIgnoreCaseStateChanged
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());
    }//GEN-LAST:event_chkIgnoreCaseStateChanged

    private void chkRegExpStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkRegExpStateChanged
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());
    }//GEN-LAST:event_chkRegExpStateChanged

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void chkSmartMatchStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkSmartMatchStateChanged
        this.chkRegExp.setEnabled(!this.chkSmartMatch.isSelected());
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());
    }//GEN-LAST:event_chkSmartMatchStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkComment;
    private javax.swing.JCheckBox chkIgnoreCase;
    private javax.swing.JCheckBox chkRegExp;
    private javax.swing.JCheckBox chkRequestBody;
    private javax.swing.JCheckBox chkRequestHeader;
    private javax.swing.JCheckBox chkResponseBody;
    private javax.swing.JCheckBox chkResponseHeader;
    private javax.swing.JCheckBox chkScopeOnly;
    private javax.swing.JCheckBox chkSmartMatch;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblProgress;
    private javax.swing.JPanel pnlRequest;
    private javax.swing.JPanel pnlRequest1;
    private javax.swing.JPanel pnlResult;
    private javax.swing.JPanel pnlResultView;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JPanel pnlSearchEnc;
    private javax.swing.JPanel pnlView;
    private javax.swing.ButtonGroup rdoEncodeingGrp;
    private javax.swing.JRadioButton rdoRepEnc_8859_1;
    private javax.swing.JRadioButton rdoRepEnc_AutoRecognise;
    private javax.swing.JScrollPane scrollResult;
    private javax.swing.JSplitPane splitResult;
    private javax.swing.JTable tableResult;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    protected boolean getAutoRecogniseEncoding() {
        return this.rdoRepEnc_AutoRecognise.isSelected();
    }

    protected HttpMessageItem getSelectedMessageItem() {
        HttpMessageItem item = null;
        int row = this.tableResult.getSelectedRow();
        if (row == -1) {
            return null;
        }
        int rowIndex = this.tableResult.convertRowIndexToModel(row);
        if (rowIndex > -1) {
            IHttpRequestResponse msgItem = this.modelSearch.getData(rowIndex);
            item = new HttpMessageItem(msgItem);
        }
        return item;
    }

    private ListSelectionListener newListSelectionListener() {
        return new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                HttpMessageItem item = getSelectedMessageItem();
                if (item != null) {
                    tabMessageView.setVisible(true);
                    tabMessageView.setMessageInfo(item);
                } else {
                    tabMessageView.setVisible(false);
                    tabMessageView.clearView();
                }
            }
        };
    }
    private volatile boolean querying = false;
    private volatile boolean cancel = false;

    protected final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("yagura/resources/Resource");
    
    private final ExecutorService threadExecutor = Executors.newSingleThreadExecutor();    
    
    public void search() {
        if (!this.cancel && this.querying) {
            // キャンセル前かつ検索中
            this.cancel = true;
        } else if (!this.cancel && !this.querying) {
            String queryText = this.txtSearch.getText();
            if (queryText.length() > 0) {
                if (!isValidRegex(queryText)) {
                    lblProgress.setText(BUNDLE.getString("view.invalid.regex"));
                    return ;
                }
                Runnable search = new Runnable() {

                    @Override
                    public void run() {
                        modelSearch.removeAll();
                        search(txtSearch.getText());
                    }
                };
                this.threadExecutor.submit(search);
            }
        }
    }

    private final String SEARCH_PROGRESS = "%1$.1f%%";

    private boolean isValidRegex(String text) {
        int flags = 0;
        if (this.chkIgnoreCase.isSelected()) {
            flags |= Pattern.CASE_INSENSITIVE;
        }
        return RegexItem.compileRegex(text, flags, !this.chkRegExp.isSelected()) != null;
    }
    
    public /*synchronized*/ void search(String text) {
        this.querying = true;
        this.btnSearch.setText("Stop");
        // all clear
        this.modelSearch.removeAll();
        int flags = 0;
        if (this.chkIgnoreCase.isSelected()) {
            flags |= Pattern.CASE_INSENSITIVE;
        }
        Pattern p = RegexItem.compileRegex(text, flags, !this.chkRegExp.isSelected());
        if (this.chkSmartMatch.isSelected()) {
            String smartRegex = TransUtil.toSmartMatch(text);
            p = RegexItem.compileRegex(smartRegex, flags, false);            
        }
        
        IHttpRequestResponse messageInfo[] = BurpExtender.getCallbacks().getProxyHistory();
        try {
            this.lblProgress.setText(String.format(SEARCH_PROGRESS, 0.0));
            for (int i = 0; i < messageInfo.length; i++) {
                HttpMessageItem item = new HttpMessageItem(messageInfo[i], i);
                Matcher m = null;
                boolean find = false;
                do {
                    String encoding = StandardCharsets.ISO_8859_1.name();
                    if (this.getAutoRecogniseEncoding()) {
                        encoding = item.getGuessCharset();
                    }
                    if(this.chkScopeOnly.isSelected()) {
                        if (!BurpExtender.getCallbacks().isInScope(item.getUrl())) {
                            continue;
                        }
                    }                    
                    if ((this.chkRequestHeader.isSelected() || this.chkRequestBody.isSelected()) && item.getRequest() != null) {
                        byte reqMessage[] = item.getRequest();
                        if (!(this.chkRequestHeader.isSelected() && this.chkRequestBody.isSelected())) {
                            IRequestInfo reqInfo = BurpExtender.getHelpers().analyzeRequest(reqMessage);
                            if (this.chkRequestHeader.isSelected()) {
                                reqMessage = Arrays.copyOfRange(item.getRequest(), 0, reqInfo.getBodyOffset());
                            }
                            else if (this.chkRequestBody.isSelected()) {
                                reqMessage = Arrays.copyOfRange(item.getRequest(), reqInfo.getBodyOffset(), item.getRequest().length);                            
                            }                                                    
                        }
                        String req = Util.decodeMessage(reqMessage, encoding);
                        m = p.matcher(req);
                        if (m.find()) {
                            find = true;
                            break;
                        }
                    }
                    if ((this.chkResponseHeader.isSelected() || this.chkResponseBody.isSelected()) && item.getResponse() != null) {
                        byte resMessage[] = item.getResponse();
                        if (!(this.chkResponseHeader.isSelected() && this.chkResponseBody.isSelected())) {
                            IResponseInfo resInfo = BurpExtender.getHelpers().analyzeResponse(resMessage);
                            if (this.chkResponseHeader.isSelected()) {
                                resMessage = Arrays.copyOfRange(item.getResponse(), 0, resInfo.getBodyOffset());
                            }
                            else if (this.chkResponseBody.isSelected()) {
                                resMessage = Arrays.copyOfRange(item.getResponse(), resInfo.getBodyOffset(), item.getResponse().length);                            
                            }                                                    
                        }
                        String res = Util.decodeMessage(resMessage, encoding);
                        m = p.matcher(res);
                        if (m.find()) {
                            find = true;
                            break;
                        }
                    }
                    if (this.chkComment.isSelected() && item.getComment() != null) {
                        m = p.matcher(item.getComment());
                        if (m.find()) {
                            find = true;
                            break;
                        }
                    }
                    this.lblProgress.setText(String.format(SEARCH_PROGRESS, (double)i / messageInfo.length * 100.0));
                } while (false);
                if (m != null && find) {
                    //item.dump(); // debug
                    this.modelSearch.addRow(new ResultView(item, item.getOrdinal()));
                }
                if (this.cancel) {
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JSearchTab.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.cancel = false;
            this.querying = false;
            this.btnSearch.setText("Search");
            this.lblProgress.setText(String.format(SEARCH_PROGRESS, 100.0));
        }
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }
    private HttpMessageItem messageItem = null;

    /**
     * @return the messageItem
     */
    public HttpMessageItem getMessageItem() {
        return this.messageItem;
    }

    /**
     * @param messageItem
     */
    public void setMessageItem(HttpMessageItem messageItem) {
        this.messageItem = messageItem;
    }

    public void setVisibleFilter(boolean value) {
        if (value) {
            this.filterPopup.setLocation(this.scrollResult.getLocationOnScreen());
            this.filterPopup.setVisible(true);
            this.filterPopup.toFront();
        } else {
            this.filterPopup.setVisible(false);
        }
    }

    protected void showFilter() {
        this.filterPopup.setProperty(this.getProperty().getFilterProperty());
    }

    protected void hideFilter() {
        FilterProperty filterProp = this.getProperty().getFilterProperty();
        this.tableResult.getSelectionModel().clearSelection();
        TableModel model = this.tableResult.getModel();
        TableRowSorter<TableModel> sorter = new ResultFilterPopup.PropertyRowSorter<TableModel>(model);
        sorter.setRowFilter(new ResultFilterPopup.PropertyRowFilter(filterProp));
        this.tableResult.setRowSorter(sorter);
        firePropertyChange(TabbetOption.JSEARCH_FILTER_PROPERTY, null, this.getProperty());        
    }

    public void setProperty(JSearchProperty searchProp) {
        this.chkSmartMatch.setSelected(searchProp.isSmartMatch());
        this.chkRegExp.setSelected(searchProp.isRegexp());
        this.chkIgnoreCase.setSelected(searchProp.isIgnoreCase());  
        if (searchProp.isAutoRecogniseEncoding()) {
            this.rdoRepEnc_AutoRecognise.setSelected(true);    
        }
        else {
            this.rdoRepEnc_8859_1.setSelected(true);            
        }

        this.chkRequestHeader.setSelected(searchProp.isRequestHeader());
        this.chkRequestBody.setSelected(searchProp.isRequestBody());
        this.chkResponseHeader.setSelected(searchProp.isResponseHeader());
        this.chkResponseBody.setSelected(searchProp.isResponseBody());

        this.chkComment.setSelected(searchProp.isComment());
        
        this.filterPopup.setProperty(searchProp.getFilterProperty());
        this.hideFilter();
    }

    public JSearchProperty getProperty() {
        final JSearchProperty searchProp = new JSearchProperty();

        searchProp.setSmartMatch(this.chkSmartMatch.isSelected());
        searchProp.setRegexp(this.chkRegExp.isSelected());
        searchProp.setIgnoreCase(this.chkIgnoreCase.isSelected());  
        searchProp.setAutoRecogniseEncoding(this.rdoRepEnc_AutoRecognise.isSelected());

        searchProp.setRequestHeader(this.chkRequestHeader.isSelected());
        searchProp.setRequestBody(this.chkRequestBody.isSelected());
        searchProp.setResponseHeader(this.chkResponseHeader.isSelected());
        searchProp.setResponseBody(this.chkResponseBody.isSelected());

        searchProp.setComment(this.chkComment.isSelected());
        
        searchProp.setFilterProperty(this.filterPopup.getProperty());        
        return searchProp;        
    }

    private void showBurpMenu(MouseEvent evt) {
        this.tabMessageView.showBurpMenu(evt);
    }
        
}
