package yagura.view;

import burp.BurpExtender;
import burp.IMessageEditorController;
import burp.IMessageEditorTab;
import burp.IRequestInfo;
import burp.IResponseInfo;
import extend.view.base.HttpMessage;
import extend.view.base.HttpRequest;
import extend.view.base.HttpResponse;
import extend.util.BurpWrap;
import yagura.external.FormatUtil;
import extend.util.Util;
import java.awt.Component;
import java.awt.Font;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.JTextComponent;

/**
 *
 * @author isayan
 */
public class JSONViewTab extends javax.swing.JPanel implements IMessageEditorTab {

    private boolean isRequest = true;

    /**
     * Creates new form JSONView
     */
    public JSONViewTab(boolean isResuest) {
        this(null, false, isResuest);
    }

    /**
     * Creates new form JSONView
     */
    public JSONViewTab(IMessageEditorController controller, boolean editable, boolean isResuest) {
        this.isRequest = isResuest;
        initComponents();
        customizeComponents();
        this.txtJSON.setEditable(false);
    }

    private QuickSearchTab quickSearchTab = new QuickSearchTab();

    @SuppressWarnings("unchecked")
    private void customizeComponents() {
        this.quickSearchTab.setSelectedTextArea(this.txtJSON);
        this.quickSearchTab.getEncodingComboBox().addItemListener(encodingItemStateChanged);
        add(this.quickSearchTab, java.awt.BorderLayout.SOUTH);
    }

    private final java.awt.event.ItemListener encodingItemStateChanged = new java.awt.event.ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            String encoding = quickSearchTab.getSelectedEncoding();
            if (encoding != null) {
                setMessageView(encoding);
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popBurpMenu = new javax.swing.JPopupMenu();
        grpGene = new javax.swing.ButtonGroup();
        popQuick = new javax.swing.JPopupMenu();
        mnuRegex = new javax.swing.JCheckBoxMenuItem();
        mnuIgnoreCase = new javax.swing.JCheckBoxMenuItem();
        scrollJSON = new javax.swing.JScrollPane();
        txtJSON = new javax.swing.JTextArea();

        mnuRegex.setSelected(true);
        mnuRegex.setText("regex");
        popQuick.add(mnuRegex);

        mnuIgnoreCase.setText("case sensitive");
        popQuick.add(mnuIgnoreCase);

        setLayout(new java.awt.BorderLayout());

        txtJSON.setColumns(20);
        txtJSON.setLineWrap(true);
        txtJSON.setRows(5);
        txtJSON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtJSONMouseClicked(evt);
            }
        });
        scrollJSON.setViewportView(txtJSON);

        add(scrollJSON, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtJSONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJSONMouseClicked
    }//GEN-LAST:event_txtJSONMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup grpGene;
    private javax.swing.JCheckBoxMenuItem mnuIgnoreCase;
    private javax.swing.JCheckBoxMenuItem mnuRegex;
    private javax.swing.JPopupMenu popBurpMenu;
    private javax.swing.JPopupMenu popQuick;
    private javax.swing.JScrollPane scrollJSON;
    private javax.swing.JTextArea txtJSON;
    // End of variables declaration//GEN-END:variables
        
    public void setMessageView(String encoding) {
        Logger.getLogger(JSONViewTab.class.getName()).log(Level.INFO, "encoding:" + encoding);
        try {
            if (this.message == null) {
                return;
            }
            BurpExtender burp = BurpExtender.getInstance();
//            if (burp != null) {
//                this.setMessageFont(burp.getMessageFont());
//            }
            if (this.message != null) {
                // Raw
                this.txtJSON.setText(FormatUtil.prettyJSON(Util.decodeMessage(this.message.getBodyBytes(), encoding)));
                this.txtJSON.setCaretPosition(0);
                // View                
            } else {
                this.txtJSON.setText("");
            }
            this.quickSearchTab.clearView();
        } catch (Exception ex) {
            Logger.getLogger(JSONViewTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setMessageFont(Font font) {
        this.txtJSON.setFont(font);
        this.quickSearchTab.setMessageFont(font);
    }

    protected JTextComponent getSelectedTextArea() {
        return this.txtJSON;
    }

    public String getSelectedText() {
        JTextComponent area = this.getSelectedTextArea();
        return area.getSelectedText();
    }

    public boolean isExtendVisible() {
        return false;
    }

    @Override
    public String getTabCaption() {
        return "JSON";
    }

    @Override
    public Component getUiComponent() {
        return this;
    }

    @Override
    public boolean isEnabled(byte[] content, boolean isMessageRequest) {
        if (content == null || content.length == 0) {
            return false;
        }
        boolean mimeJsonType = false;
        byte[] body = new byte[0];
        if (this.isRequest && isMessageRequest) {
            IRequestInfo reqInfo = BurpExtender.getHelpers().analyzeRequest(content);
            mimeJsonType = (reqInfo.getContentType() == IRequestInfo.CONTENT_TYPE_JSON);
            body = BurpWrap.getRequestBody(reqInfo, content);
        } else if (!this.isRequest && !isMessageRequest) {
            IResponseInfo resInfo = BurpExtender.getHelpers().analyzeResponse(content);
            String mimeType = resInfo.getInferredMimeType();
            mimeJsonType = "JSON".equals(mimeType);
            body = BurpWrap.getResponseBody(resInfo, content);
        }
        if (body.length > 0 && mimeJsonType) {
            return FormatUtil.isJSON(Util.getRawStr(body));
        } else {
            return FormatUtil.isJSON(Util.getRawStr(body));
        }
    }

    private HttpMessage message = null;

    @Override
    public void setMessage(byte[] content, boolean isMessageRequest) {
        try {
            BurpExtender extenderImpl = BurpExtender.getInstance();
            String guessCharset = null;
            HttpMessage httpmessage = null;
            if (isMessageRequest) {
                HttpRequest request = HttpRequest.parseHttpRequest(content);
                httpmessage = request;
                guessCharset = request.getGuessCharset();
            } else {
                HttpResponse response = HttpResponse.parseHttpResponse(content);
                httpmessage = response;
                guessCharset = response.getGuessCharset();
            }
            this.message = httpmessage;
            this.quickSearchTab.getEncodingComboBox().removeItemListener(encodingItemStateChanged);
            this.quickSearchTab.renewEncodingList(guessCharset, extenderImpl.getSelectEncodingList());
            encodingItemStateChanged.itemStateChanged(null);
            this.quickSearchTab.getEncodingComboBox().addItemListener(encodingItemStateChanged);

        } catch (ParseException ex) {
            Logger.getLogger(JSONViewTab.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public byte[] getMessage() {
        if (this.message != null) {
            return this.message.getMessageBytes();
        } else {
            return new byte[]{};
        }
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public byte[] getSelectedData() {
        return null;
    }

    public void clearView() {
        this.quickSearchTab.clearView();
    }

}
