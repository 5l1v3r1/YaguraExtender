package yagura.view;

import burp.BurpExtender;
import burp.IMessageEditorController;
import burp.IMessageEditorTab;
import burp.IRequestInfo;
import burp.IResponseInfo;
import extend.model.base.DefaultObjectTableModel;
import extend.view.base.HttpMessage;
import extend.view.base.HttpRequest;
import extend.view.base.HttpResponse;
import extend.util.BurpWrap;
import extend.util.SwingUtil;
import yagura.external.FormatUtil;
import extend.util.Util;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.text.ParseException;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.swing.Icon;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledEditorKit;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import yagura.external.JsonUtil;

/**
 *
 * @author isayan
 */
public class JSONViewTab extends javax.swing.JPanel implements IMessageEditorTab {

    private boolean isRequest = true;
    
    private final EditorKit jsonStyleEditorKit = new StyledEditorKit()
    {
         public Document createDefaultDocument()
         {
              return new JSONSyntaxDocument();
         }
    };    
    
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
    }

    private DefaultTreeModel modelJSON;
    
    private QuickSearchTab quickSearchTab = new QuickSearchTab();

    @SuppressWarnings("unchecked")
    private void customizeComponents() {
        this.quickSearchTab.setSelectedTextArea(this.txtJSON);
        this.quickSearchTab.getEncodingComboBox().addItemListener(encodingItemStateChanged);

        this.txtJSON.setEditable(false);

        this.txtJSON.setEditorKitForContentType("text/json", this.jsonStyleEditorKit);
        this.txtJSON.setContentType("text/json");

        Icon emptyIcon = SwingUtil.createEmptyIcon();
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) this.treeJSON.getCellRenderer();
        renderer.setOpenIcon(emptyIcon);
        renderer.setClosedIcon(emptyIcon);
        renderer.setLeafIcon(emptyIcon);
        this.modelJSON = (DefaultTreeModel)this.treeJSON.getModel();
                
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

        popQuick = new javax.swing.JPopupMenu();
        mnuRegex = new javax.swing.JCheckBoxMenuItem();
        mnuIgnoreCase = new javax.swing.JCheckBoxMenuItem();
        tabbetJSON = new javax.swing.JTabbedPane();
        scrollJSON = new javax.swing.JScrollPane();
        txtJSON = new javax.swing.JEditorPane();
        pnlTree = new javax.swing.JPanel();
        scrollTree = new javax.swing.JScrollPane();
        treeJSON = new javax.swing.JTree();

        mnuRegex.setSelected(true);
        mnuRegex.setText("regex");
        popQuick.add(mnuRegex);

        mnuIgnoreCase.setText("case sensitive");
        popQuick.add(mnuIgnoreCase);

        setLayout(new java.awt.BorderLayout());

        txtJSON.setEditable(false);
        scrollJSON.setViewportView(txtJSON);

        tabbetJSON.addTab("pretty", scrollJSON);

        pnlTree.setLayout(new java.awt.BorderLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeJSON.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        scrollTree.setViewportView(treeJSON);

        pnlTree.add(scrollTree, java.awt.BorderLayout.CENTER);

        tabbetJSON.addTab("Tree", pnlTree);

        add(tabbetJSON, java.awt.BorderLayout.CENTER);
        tabbetJSON.getAccessibleContext().setAccessibleName("");
        tabbetJSON.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem mnuIgnoreCase;
    private javax.swing.JCheckBoxMenuItem mnuRegex;
    private javax.swing.JPanel pnlTree;
    private javax.swing.JPopupMenu popQuick;
    private javax.swing.JScrollPane scrollJSON;
    private javax.swing.JScrollPane scrollTree;
    private javax.swing.JTabbedPane tabbetJSON;
    private javax.swing.JTree treeJSON;
    private javax.swing.JEditorPane txtJSON;
    // End of variables declaration//GEN-END:variables
        
    public void setMessageView(String encoding) {
        Logger.getLogger(JSONViewTab.class.getName()).log(Level.INFO, "encoding:" + encoding);
        try {
            if (this.message == null) {
                return;
            }
            BurpExtender burp = BurpExtender.getInstance();
            if (this.message != null) {
                String msg = Util.decodeMessage(this.message.getBodyBytes(), encoding);
                // Raw
                this.txtJSON.setText(FormatUtil.prettyJSON(msg));
                this.txtJSON.setCaretPosition(0);
                // Tree View
                DefaultTreeModel model = toJSONTreeModel(JsonUtil.parse(msg));

                DefaultObjectTableModel.allNodesChanged(this.treeJSON);
                this.treeJSON.setModel(model);                
            } else {
                this.txtJSON.setText("");
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) modelJSON.getRoot();
                root.removeAllChildren();
            }
            this.quickSearchTab.clearViewAndSearch();
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

    public DefaultTreeModel toJSONTreeModel(JsonStructure json) {
        DefaultMutableTreeNode rootJSON = new DefaultMutableTreeNode("JSON");
        DefaultTreeModel model = new DefaultTreeModel(rootJSON);
        toJSONTreeNode(json, rootJSON);
        return model;
    }
    
    private void toJSONTreeNode(JsonValue json, DefaultMutableTreeNode parentNode) {
        switch (json.getValueType()) {
            case ARRAY: {
                JsonArray jsonArray = (JsonArray) json;
                for (int i = 0; i < jsonArray.size(); i++) {
                    toJSONTreeNode(jsonArray.get(i), parentNode);                    
                }
                break;                
            }
            case OBJECT: {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode("{}");
                parentNode.add(node);                
                JsonObject jsonObject = (JsonObject) json;
                Set<Map.Entry<String, JsonValue>> set = jsonObject.entrySet();
                for (Map.Entry<String, JsonValue> s : set) {
                    JsonValue value = s.getValue();
                    switch (value.getValueType()) {
                        case STRING: {                            
                            JsonString jsonValue = (JsonString) value;
                            DefaultMutableTreeNode jsonKeySet = new DefaultMutableTreeNode(s.getKey() + ":" + jsonValue.getString());                            
                            node.add(jsonKeySet);                            
                            break;                            
                        }
                        case NUMBER: {
                            JsonNumber jsonValue = (JsonNumber) value;
                            DefaultMutableTreeNode jsonKeySet = new DefaultMutableTreeNode(s.getKey() + ":" + jsonValue.bigDecimalValue());                            
                            node.add(jsonKeySet);
                            break;                            
                        }                        
                        case TRUE: {
                            DefaultMutableTreeNode jsonKeySet = new DefaultMutableTreeNode(s.getKey() + ":" + "true");                            
                            node.add(jsonKeySet);
                            break;                            
                        }
                        case FALSE: {
                            DefaultMutableTreeNode jsonKeySet = new DefaultMutableTreeNode(s.getKey() + ":" + "false");                            
                            node.add(jsonKeySet);
                            break;                            
                        }
                        case NULL: {
                            DefaultMutableTreeNode jsonKeySet = new DefaultMutableTreeNode(s.getKey() + ":" + "null");                            
                            node.add(jsonKeySet);
                            break;                            
                        }
                        default: {
                            DefaultMutableTreeNode jsonKeySet = new DefaultMutableTreeNode(s.getKey());                            
                            node.add(jsonKeySet);
                            toJSONTreeNode(value, jsonKeySet);                            
                            break;                            
                        }
                    }
                }
                break;                
            }
            case STRING: {
                JsonString jsonValue = (JsonString) json;
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(jsonValue.getString());
                parentNode.add(node);
                break;
            }            
            case NUMBER: {
                JsonNumber jsonValue = (JsonNumber) json;
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(jsonValue.bigDecimalValue());
                parentNode.add(node);
                break;                
            }            
            case TRUE: {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode("true");
                parentNode.add(node);
                break;                
            }
            case FALSE: {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode("false");
                parentNode.add(node);
                break;                
            }
            case NULL: {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode("null");
                parentNode.add(node);
                break;                
            }
        }
    }
    
}
