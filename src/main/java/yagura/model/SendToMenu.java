package yagura.model;

import burp.BurpExtender;
import burp.IBurpExtenderCallbacks;
import burp.IContextMenuFactory;
import burp.IContextMenuInvocation;
import burp.IHttpRequestResponse;
import burp.IHttpService;
import burp.IScanIssue;
import extend.util.BurpWrap;
import extend.util.HttpUtil;
import extend.util.Util;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.FocusManager;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 * burp new IF
 *
 * @author isayan
 */
public class SendToMenu implements IContextMenuFactory, SendToListener {

    private final SendToProperty property;
    private final IBurpExtenderCallbacks callbacks;
    private IContextMenuInvocation invocation;

    private final javax.swing.JMenu mnuSendTo = new javax.swing.JMenu();

    public SendToMenu(IBurpExtenderCallbacks cb, SendToProperty property) {
        this.callbacks = cb;
        this.property = property;

    }
    private final List<JMenuItem> menuList = new ArrayList<JMenuItem>();
    private final List<SendToMenuItem> sendToList = new ArrayList<>();

    @Override
    public List<JMenuItem> createMenuItems(IContextMenuInvocation invocation) {
        this.invocation = invocation;
        this.renewMenu(this.property);
        return this.menuList;
    }

    public void renewMenu(SendToProperty property) {
        this.mnuSendTo.setText("Send To");
        this.sendToList.clear();
        this.menuList.clear();
        if (property.isSubMenu()) {
            this.mnuSendTo.removeAll();
            this.menuList.add(this.mnuSendTo);
        }
        List<SendToItem> sendToItemList = property.getSendToItemList();
        for (SendToItem item : sendToItemList) {
            if (item.isSelected()) {
                if (item.getExtend() != null) {
                    SendToExtend sendToItem = new SendToExtend(item, this.invocation);
                    if (sendToItem.getExtend() == SendToItem.ExtendType.PASTE_FROM_CLIPBOARD) {
                        javax.swing.JMenu mnuItem = new javax.swing.JMenu();
                        mnuItem.setText(item.getCaption());
                        List<String> encodingList = BurpExtender.getInstance().getSelectEncodingList();
                        for (String encoding : encodingList) {
                            javax.swing.JMenuItem mnuItemEncoding = new javax.swing.JMenuItem();
                            mnuItemEncoding.setText(encoding);
                            mnuItemEncoding.addActionListener(sendToItem);                    
                            mnuItem.add(mnuItemEncoding);
                        }
                        if (property.isSubMenu()) {
                            if (sendToItem.isEnabled()) {
                                this.mnuSendTo.add(mnuItem);
                            }
                        } else {
                            if (sendToItem.isEnabled()) {
                                this.menuList.add(mnuItem);
                            }
                        }
                    }
                    else {
                        javax.swing.JMenuItem mnuItem = new javax.swing.JMenuItem();
                        mnuItem.setText(item.getCaption());
                        sendToList.add(sendToItem);
                        mnuItem.addActionListener(sendToItem);
                        if (property.isSubMenu()) {
                            if (sendToItem.isEnabled()) {
                                this.mnuSendTo.add(mnuItem);
                            }
                        } else {
                            if (sendToItem.isEnabled()) {
                                this.menuList.add(mnuItem);
                            }
                        }                    
                    }

                } else {
                    javax.swing.JMenuItem mnuItem = new javax.swing.JMenuItem();
                    mnuItem.setText(item.getCaption());
                    if (item.isServer()) {
                        SendToMenuItem sendToItem = new SendToServer(item, this.invocation);
                        sendToList.add(sendToItem);
                        mnuItem.addActionListener(sendToItem);
                        if (property.isSubMenu()) {
                            if (sendToItem.isEnabled()) {
                                this.mnuSendTo.add(mnuItem);
                            }
                        } else {
                            if (sendToItem.isEnabled()) {
                                this.menuList.add(mnuItem);
                            }
                        }
                    } else {
                        SendToMenuItem sendToItem = new SendToMultiEditor(item, this.invocation);
                        sendToList.add(sendToItem);
                        mnuItem.addActionListener(sendToItem);
                        if (property.isSubMenu()) {
                            if (sendToItem.isEnabled()) {
                                this.mnuSendTo.add(mnuItem);
                            }
                        } else {
                            if (sendToItem.isEnabled()) {
                                this.menuList.add(mnuItem);
                            }
                        }
                    }
                }
            }
        }

    }

    private final javax.swing.JPopupMenu popBurpMenu = new javax.swing.JPopupMenu();

    public void showBurpMenu(SendToMessage message, java.awt.event.MouseEvent evt) {
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            this.getPopupMenu(message);
            this.popBurpMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    protected javax.swing.JPopupMenu getPopupMenu(final SendToMessage message) {
        this.popBurpMenu.removeAll();
        javax.swing.JMenuItem mnuRepeater = new javax.swing.JMenuItem();
        mnuRepeater.setText("Sendto Repeater");
        mnuRepeater.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToRepeater(message);
            }
        });
        this.popBurpMenu.add(mnuRepeater);
        javax.swing.JMenuItem mnuIntruder = new javax.swing.JMenuItem();
        mnuIntruder.setText("Sndto Intruder");
        mnuIntruder.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToIntruder(message);
            }
        });
        this.popBurpMenu.add(mnuIntruder);
        javax.swing.JMenuItem mnuSpider = new javax.swing.JMenuItem();
        mnuSpider.setText("Sendto Spider");
        mnuSpider.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToSpider(message);
            }
        });
        this.popBurpMenu.add(mnuSpider);
        if (message.isExtendVisible()) {
            this.popBurpMenu.addSeparator();
            List<SendToItem> sendToItemList = property.getSendToItemList();
            for (SendToItem item : sendToItemList) {
                if (item.isSelected()) {
                    javax.swing.JMenuItem mnuItem = new javax.swing.JMenuItem();
                    mnuItem.setText(item.getCaption());
                    if (item.getExtend() != null) {
                        final SendToExtend sendToItem = new SendToExtend(item, this.invocation);
                        mnuItem.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                sendToItem.menuItemClicked(mnuItem.getText(), message.getSelectedMessages());
                            }
                        });
                        this.popBurpMenu.add(mnuItem);
                    } else {
                        if (item.isServer()) {
                            final SendToMenuItem sendToItem = new SendToServer(item, this.invocation);
                            sendToItem.addSendToListener(this);
                            mnuItem.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    sendToItem.menuItemClicked(mnuItem.getText(), message.getSelectedMessages());
                                }
                            });
                            this.popBurpMenu.add(mnuItem);
                        } else {
                            final SendToMenuItem sendToItem = new SendToMultiEditor(item, this.invocation);
                            mnuItem.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    sendToItem.menuItemClicked(mnuItem.getText(), message.getSelectedMessages());
                                }
                            });
                            this.popBurpMenu.add(mnuItem);
                        }
                    }
                }
            }
        }
        return popBurpMenu;
    }

    private int repeternum = 0;

    public void doKeyEventAction(KeyEvent evt) {
        List<IHttpRequestResponse> historyList = new ArrayList<>();
        FocusManager mgr = FocusManager.getCurrentManager();
        Component owner = mgr.getFocusOwner();
        if (owner instanceof JTable) {
            JTable table = (JTable) owner;
            int[] rowSelect = table.getSelectedRows();
            for (int i = 0; i < rowSelect.length; i++) {
                int rowIndex = table.convertRowIndexToModel(rowSelect[i]);
                TableModel modelTable = table.getModel();
                int historyIndex = Util.parseIntDefault(Util.toString(modelTable.getValueAt(rowIndex, 0)), -1);
                if (historyIndex > 0) {
                    IHttpRequestResponse[] history = BurpExtender.getCallbacks().getProxyHistory();
                    historyList.add(history[historyIndex - 1]);
                }
            }
        }
        createMenuItems(getContextMenuInvocation(evt, historyList.toArray(new IHttpRequestResponse[0])));
        //
        for (SendToMenuItem item : sendToList) {
            if (item.isSelected() && item.getHotkey() != null) {
                KeyEvent hotKey = item.getHotkey();
                if (evt.getModifiersEx() == hotKey.getModifiersEx()
                        && evt.getKeyCode() == hotKey.getKeyCode()) {
                    if (historyList.size() > 0) {
                        IHttpRequestResponse[] messageInfo = historyList.toArray(new IHttpRequestResponse[0]);
                        item.menuItemClicked("#", messageInfo);
                    }
                }
            }
        }
    }

    private IContextMenuInvocation getContextMenuInvocation(KeyEvent evt, IHttpRequestResponse[] messageInfo) {
        return new IContextMenuInvocation() {
            @Override
            public InputEvent getInputEvent() {
                return evt;
            }

            @Override
            public int getToolFlag() {
                return IBurpExtenderCallbacks.TOOL_PROXY;
            }

            @Override
            public byte getInvocationContext() {
                return IContextMenuInvocation.CONTEXT_PROXY_HISTORY;
            }

            @Override
            public int[] getSelectionBounds() {
                return null;
            }

            @Override
            public IHttpRequestResponse[] getSelectedMessages() {
                return messageInfo;
            }

            @Override
            public IScanIssue[] getSelectedIssues() {
                return null;
            }

        };
    }

    public void sendToRepeater(SendToMessage message) {
        try {
            IHttpRequestResponse[] messageItem = message.getSelectedMessages();
            IHttpService httpService = messageItem[0].getHttpService();
            callbacks.sendToRepeater(httpService.getHost(), httpService.getPort(), HttpUtil.isSSL(httpService.getProtocol()),
                    messageItem[0].getRequest(), "v" + this.repeternum++);
        } catch (Exception ex) {
            Logger.getLogger(SendToMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendToIntruder(SendToMessage message) {
        try {
            IHttpRequestResponse[] messageItem = message.getSelectedMessages();
            IHttpService httpService = messageItem[0].getHttpService();
            callbacks.sendToIntruder(httpService.getHost(), httpService.getPort(), HttpUtil.isSSL(httpService.getProtocol()),
                    messageItem[0].getRequest());
        } catch (Exception ex) {
            Logger.getLogger(SendToMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendToSpider(SendToMessage message) {
        try {
            IHttpRequestResponse[] messageItem = message.getSelectedMessages();
            callbacks.sendToSpider(BurpWrap.getURL(messageItem[0]));
        } catch (Exception ex) {
            Logger.getLogger(SendToMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void complete(SendToEvent evt) {
    }

    @Override
    public void warning(SendToEvent evt) {
    }

    @Override
    public void error(SendToEvent evt) {
        this.callbacks.issueAlert(evt.getMessage());
    }

}
