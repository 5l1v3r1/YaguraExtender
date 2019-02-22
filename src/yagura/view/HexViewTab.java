package yagura.view;

import burp.IMessageEditorController;
import burp.IMessageEditorTab;
import burp.IMessageEditorTabFactory;
import extend.model.base.CustomTableModel;
import extend.util.ConvertUtil;
import yagura.external.TransUtil;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author isayan
 */
public class HexViewTab extends javax.swing.JPanel implements IMessageEditorTabFactory, IMessageEditorTab {

    /**
     * Creates new form HexViewTab
     */
    public HexViewTab() {
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

        scrollHex = new javax.swing.JScrollPane();
        tableHex = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        tableHex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Position", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "String"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableHex.getTableHeader().setReorderingAllowed(false);
        scrollHex.setViewportView(tableHex);
        if (tableHex.getColumnModel().getColumnCount() > 0) {
            tableHex.getColumnModel().getColumn(1).setResizable(false);
            tableHex.getColumnModel().getColumn(2).setResizable(false);
            tableHex.getColumnModel().getColumn(3).setResizable(false);
            tableHex.getColumnModel().getColumn(4).setResizable(false);
            tableHex.getColumnModel().getColumn(5).setResizable(false);
            tableHex.getColumnModel().getColumn(6).setResizable(false);
            tableHex.getColumnModel().getColumn(7).setResizable(false);
            tableHex.getColumnModel().getColumn(8).setResizable(false);
            tableHex.getColumnModel().getColumn(9).setResizable(false);
            tableHex.getColumnModel().getColumn(10).setResizable(false);
            tableHex.getColumnModel().getColumn(11).setResizable(false);
            tableHex.getColumnModel().getColumn(12).setResizable(false);
            tableHex.getColumnModel().getColumn(13).setResizable(false);
            tableHex.getColumnModel().getColumn(14).setResizable(false);
            tableHex.getColumnModel().getColumn(15).setResizable(false);
            tableHex.getColumnModel().getColumn(16).setResizable(false);
        }

        add(scrollHex, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollHex;
    private javax.swing.JTable tableHex;
    // End of variables declaration//GEN-END:variables

    private static final DecimalFormat FORMAT_POSITION = new DecimalFormat("000000"); // @jve:decl-index=0:

    private byte[] data = new byte[]{};
    private CustomTableModel modelHex = null;

    private final Action copyAction = new AbstractAction() {
        public void actionPerformed(ActionEvent evt) {
            //選択されている行の列コピーの値を取得
            JTable table = (JTable)evt.getSource();
            CustomTableModel.tableCopy(table);
        } 
    };     
    
    private void customizeComponents() {
        this.modelHex = new CustomTableModel(this.tableHex.getModel()) {
        
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        
        };
        this.tableHex.getActionMap().put("copytAction", copyAction); 
        this.tableHex.setColumnSelectionAllowed(false);

        this.tableHex.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.tableHex.setCellSelectionEnabled(true);
        this.tableHex.setRowSelectionAllowed(true);
    
        this.tableHex.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.tableHex.setShowGrid(true);
        this.tableHex.setFont(new Font("DialogInput", Font.PLAIN, 12));
        this.tableHex.setModel(this.modelHex);
        JTableHeader theader = this.tableHex.getTableHeader();
        theader.setReorderingAllowed(false);

        TableColumnModel colmodel = this.tableHex.getColumnModel();
        colmodel.getColumn(0).setPreferredWidth(60);
        for (int i = 0; i < 16; i++) {
            colmodel.getColumn(i + 1).setPreferredWidth(30);
        }
        colmodel.getColumn(17).setPreferredWidth(150);
//        for (int i = 0; i < colmodel.getColumnCount(); i++) {
//            colmodel.getColumn(i).setHeaderRenderer(new SimpleTableHeaderRenderer());
//            colmodel.getColumn(i).setCellRenderer(new SimpleTableCellRenderer());
//        }
//        theader.setResizingAllowed(false);
//        theader.setReorderingAllowed(false);
        this.modelHex.removeAll();
    }

    private String encode = StandardCharsets.ISO_8859_1.name();

    public String getSelectEncode() {
        return this.encode;
    }

    public void setSelectEncode(String encode) {
        this.encode = encode;
    }

    public void setData(byte[] output) {
        this.data = output;
        try {
            this.modelHex.removeAll();
            /*
             * HEX文字列に変換
             */
            String[] hexs = new String[output.length];
            for (int i = 0; i < output.length; i++) {
                hexs[i] = ConvertUtil.toHexString(output[i]);
            }
            /*
             * HEX表示の作成
             */
            String[] hexmod = new String[16 + 2];
            byte[] partout = new byte[16];
            int row = 0;
            int j = 1;
            for (int i = 0; i < hexs.length; i++) {
                hexmod[j++] = hexs[i];
                if (i > 0 && (j - 1) % 16 == 0) {
                    System.arraycopy(output, row * 16, partout, 0, partout.length);
                    String hexText = new String(partout, this.getSelectEncode());
                    hexmod[0] = FORMAT_POSITION.format(row);
                    hexmod[17] = hexText;
                    this.modelHex.addRow(hexmod);
                    hexmod = new String[16 + 2];
                    partout = new byte[16];
                    j = 1;
                    row++;
                }
            }
            /*
             * 16で割れなかった余り
             */
            if ((j - 1) > 0) {
                System.arraycopy(output, row * 16, partout, 0, j - 1);
                String hexText = new String(partout, this.getSelectEncode());
                hexmod[0] = FORMAT_POSITION.format(row);
                hexmod[17] = hexText;
                this.modelHex.addRow(hexmod);
            }
        } catch (UnsupportedEncodingException e1) {
            Logger.getLogger(HexViewTab.class.getName()).log(Level.SEVERE, null, e1);
        } catch (Exception e2) {
            Logger.getLogger(HexViewTab.class.getName()).log(Level.SEVERE, null, e2);
        }
    }

    public byte[] getData() {
        return this.data;
    }

    @Override
    public IMessageEditorTab createNewInstance(IMessageEditorController controller, boolean editable) {
        return this;
    }

    @Override
    public String getTabCaption() {
        return "Hex";
    }

    @Override
    public Component getUiComponent() {
        return this;
    }

    @Override
    public boolean isEnabled(byte[] content, boolean isRequest) {
        return false;
    }

    @Override
    public void setMessage(byte[] content, boolean isRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public byte[] getMessage() {
        return this.data;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public byte[] getSelectedData() {
        return null;
    }

    public CustomTableModel getModel() {
        return this.modelHex;
    }

    public void setMessageFont(Font font) {
        this.tableHex.setFont(font);
    }
        
    // TableColumn.createDefaultHeaderRenderer
    class SimpleTableHeaderRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
            if (table != null) {
                JTableHeader header = table.getTableHeader();
                if (header != null) {
                    setForeground(header.getForeground());
                    setBackground(header.getBackground());
                    setFont(header.getFont());
                }
            }
            setText((value == null) ? "" : value.toString());
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return this;
        }

        @Override
        public void paintComponent(Graphics g) {
            Insets i = getInsets();
            FontMetrics fontMetrics = g.getFontMetrics();
            g.drawString(getText(), i.left, i.top + fontMetrics.getAscent());
        }
    }

    // TableColumn.createDefaultHeaderRenderer
    class SimpleTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }

        @Override
        public void paintComponent(Graphics g) {
            Insets i = getInsets();
            FontMetrics fontMetrics = g.getFontMetrics();
            g.drawString(getText(), i.left, i.top + fontMetrics.getAscent());
        }
    }

}
