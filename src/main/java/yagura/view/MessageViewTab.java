package yagura.view;

import burp.IHttpRequestResponse;
import burp.BurpExtender;
import yagura.model.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import yagura.model.UniversalViewProperty.UniversalView;

/**
 *
 * @author isayan
 */
public class MessageViewTab extends javax.swing.JPanel implements SendToMessage {
    private final static Logger logger = Logger.getLogger(MessageViewTab.class.getName());

    /**
     * Creates new form MessageViewTab
     */
    public MessageViewTab() {
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

        popQuick = new javax.swing.JPopupMenu();
        mnuRegex = new javax.swing.JCheckBoxMenuItem();
        mnuIgnoreCase = new javax.swing.JCheckBoxMenuItem();
        grpGene = new javax.swing.ButtonGroup();
        popBurpMenu = new javax.swing.JPopupMenu();
        tabbetMessageView = new javax.swing.JTabbedPane();

        mnuRegex.setSelected(true);
        mnuRegex.setText("regex");
        popQuick.add(mnuRegex);

        mnuIgnoreCase.setText("case sensitive");
        popQuick.add(mnuIgnoreCase);

        setLayout(new java.awt.BorderLayout());

        tabbetMessageView.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbetMessageViewStateChanged(evt);
            }
        });
        add(tabbetMessageView, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private final javax.swing.JTabbedPane tabbetRequestView = new javax.swing.JTabbedPane();
    private final javax.swing.JTabbedPane tabbetResponseView = new javax.swing.JTabbedPane();

    private final RawViewTab tabRequestRawView = new RawViewTab(true);
    private final RawViewTab tabResponseRawView = new RawViewTab(false);
    private final HtmlCommetViewTab tabHtmlComment = new HtmlCommetViewTab();
    private final JSONViewTab tabRequestJSONViewTab = new JSONViewTab(true);
    private final JSONViewTab tabResponseJSONViewTab = new JSONViewTab(false);
    private final GeneratePoCTab tabGeneratePoC = new GeneratePoCTab();

    @SuppressWarnings("unchecked")
    private void customizeComponents() {

        // Request
        this.tabRequestRawView.getMessageComponent().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showBurpMenu(e);
            }        
        });
        this.tabbetMessageView.addTab("JRequest", this.tabbetRequestView);

        // Response
        this.tabResponseRawView.getMessageComponent().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showBurpMenu(e);
            }        
        });

        this.tabbetMessageView.addTab("JResponse", this.tabbetResponseView);
    }

    private void tabbetMessageViewStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbetMessageViewStateChanged
    }//GEN-LAST:event_tabbetMessageViewStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grpGene;
    private javax.swing.JCheckBoxMenuItem mnuIgnoreCase;
    private javax.swing.JCheckBoxMenuItem mnuRegex;
    private javax.swing.JPopupMenu popBurpMenu;
    private javax.swing.JPopupMenu popQuick;
    private javax.swing.JTabbedPane tabbetMessageView;
    // End of variables declaration//GEN-END:variables

    public void showBurpMenu(java.awt.event.MouseEvent evt) {
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            SendToMenu popMenu = BurpExtender.getInstance().getSendToMenu();
            popMenu.showBurpMenu(this, evt);
        }
    }

    public void setMessageFont(Font font) {
        this.tabRequestRawView.setFont(font);
        this.tabResponseRawView.setFont(font);
        this.tabHtmlComment.setFont(font);
        this.tabRequestJSONViewTab.setFont(font);
        this.tabResponseJSONViewTab.setFont(font);
        this.tabGeneratePoC.setFont(font);
    }

    private final EnumSet<UniversalView> mesageView = EnumSet.noneOf(UniversalView.class);

    public EnumSet<UniversalView> getMessageView() {
        return mesageView;
    }

    public void setMessageView(EnumSet<UniversalView> view) {
        this.mesageView.clear();
        this.mesageView.addAll(view);
    }
        
    private HttpMessageItem messageItem = null;

    /**
     * @return the messageInfo
     */
    public HttpMessageItem getMessageInfo() {
        return this.messageItem;
    }

    /**
     * @param messageInfo the messageItem to set
     */
    @SuppressWarnings("unchecked")
    public void setMessageInfo(IHttpRequestResponse messageInfo) {
        try {
            this.messageItem = new HttpMessageItem(messageInfo);
            this.clearView();
            this.tabGeneratePoC.createNewInstance(messageItem.getController(), false);
            if (this.messageItem.getRequest() != null) {
                this.setEnabled(messageItem.getRequest(), true);
                if (this.tabbetRequestView.indexOfComponent(this.tabRequestRawView) > -1) {
                    this.tabRequestRawView.setMessage(this.messageItem.getRequest(), true);
                }
                if (this.tabbetRequestView.indexOfComponent(this.tabRequestJSONViewTab) > -1) {
                    this.tabRequestJSONViewTab.setMessage(this.messageItem.getRequest(), true);
                }
                if (this.tabbetRequestView.indexOfComponent(this.tabGeneratePoC) > -1) {
                    this.tabGeneratePoC.setMessage(this.messageItem.getRequest(), true);
                }
            }
            if (this.messageItem.getResponse() != null) {
                this.setEnabled(messageItem.getResponse(), false);
                if (this.tabbetResponseView.indexOfComponent(this.tabResponseRawView) > -1) {
                    this.tabResponseRawView.setMessage(this.messageItem.getResponse(), false);
                }
                if (this.tabbetResponseView.indexOfComponent(this.tabResponseJSONViewTab) > -1) {
                    this.tabResponseJSONViewTab.setMessage(this.messageItem.getResponse(), false);
                }
                if (this.tabbetResponseView.indexOfComponent(this.tabHtmlComment) > -1) {
                    this.tabHtmlComment.setMessage(this.messageItem.getResponse(), false);
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void setMessageEncoding(String encoding) {
        try {
            if (this.messageItem == null) {
                return;
            }
            if (messageItem.getRequest() != null) {
                if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab(tabRequestRawView.getTabCaption())) {
                    this.tabRequestRawView.setMessageEncoding(encoding);
                    this.tabRequestRawView.clearView();
                } else if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab(tabResponseRawView.getTabCaption())) {
                    this.tabResponseRawView.setMessageEncoding(encoding);
                    this.tabResponseRawView.clearView();
                } else if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab("JSON")) {
                    this.tabRequestJSONViewTab.setMessageEncoding(encoding);
                    this.tabRequestJSONViewTab.clearView();
                    this.tabResponseJSONViewTab.setMessageEncoding(encoding);
                    this.tabResponseJSONViewTab.clearView();
                } else if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab(tabHtmlComment.getTabCaption())) {
                    this.tabHtmlComment.setMessageEncoding(encoding);
                    this.tabHtmlComment.clearView();
                } else if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab(tabGeneratePoC.getTabCaption())) {
                    this.tabGeneratePoC.setMessageEncoding(encoding);
                    this.tabGeneratePoC.clearView();
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

    public void setEnabled(byte[] content, boolean isMessageRequest) {
        if (isMessageRequest) {
            this.tabbetRequestView.removeAll();
            if (this.tabRequestRawView.isEnabled(content, isMessageRequest) || mesageView.contains(UniversalView.JRAW)) {
                this.tabbetRequestView.addTab("Raw", this.tabRequestRawView);
            }
            if (this.tabRequestJSONViewTab.isEnabled(content, isMessageRequest) || mesageView.contains(UniversalView.JSON)) {
                this.tabbetRequestView.addTab(this.tabRequestJSONViewTab.getTabCaption(), this.tabRequestJSONViewTab);
            }
            if (this.tabGeneratePoC.isEnabled(content, isMessageRequest) || mesageView.contains(UniversalView.GENERATE_POC)) {
                this.tabbetRequestView.addTab(this.tabGeneratePoC.getTabCaption(), this.tabGeneratePoC);
            }
        } else {
            this.tabbetResponseView.removeAll();
            if (this.tabResponseRawView.isEnabled(content, isMessageRequest) || mesageView.contains(UniversalView.JRAW)) {
                this.tabbetResponseView.addTab("Raw", this.tabResponseRawView);
            }
            if (this.tabResponseJSONViewTab.isEnabled(content, isMessageRequest) || mesageView.contains(UniversalView.JSON)) {
                this.tabbetResponseView.addTab(this.tabResponseJSONViewTab.getTabCaption(), this.tabResponseJSONViewTab);
            }
            if (this.tabHtmlComment.isEnabled(content, isMessageRequest) || mesageView.contains(UniversalView.HTML_COMMENT)) {
                this.tabbetResponseView.addTab(this.tabHtmlComment.getTabCaption(), this.tabHtmlComment);
            }
        }
    }

    public void clearView() {
        this.tabRequestRawView.clearView();
        this.tabResponseRawView.clearView();
        this.tabRequestJSONViewTab.clearView();
        this.tabResponseJSONViewTab.clearView();
        this.tabHtmlComment.clearView();
        this.tabGeneratePoC.clearView();;
    }

    @Override
    public IHttpRequestResponse[] getSelectedMessages() {
        return new IHttpRequestResponse[]{this.messageItem};
    }

    @Override
    public String getSelectedText() {
        String text = "";
        if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab(tabRequestRawView.getTabCaption())) {
            text = this.tabRequestRawView.getSelectedText();
        } else if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab(tabResponseRawView.getTabCaption())) {
            text = this.tabResponseRawView.getSelectedText();
        } else if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab("JSON")) {
            if (this.tabbetMessageView.getSelectedComponent() == this.tabResponseRawView) {
                text = this.tabResponseRawView.getSelectedText();
            } else if (this.tabbetMessageView.getSelectedComponent() == this.tabResponseJSONViewTab) {
                text = this.tabResponseJSONViewTab.getSelectedText();
            }
        } else if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab(tabHtmlComment.getTabCaption())) {
            text = this.tabHtmlComment.getSelectedText();
        } else if (this.tabbetMessageView.getSelectedIndex() == this.tabbetMessageView.indexOfTab(tabGeneratePoC.getTabCaption())) {
            text = this.tabGeneratePoC.getSelectedText();
        }
        return text;
    }

    @Override
    public boolean isExtendVisible() {
        return false;
    }
}
