/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DAO.Ban_DAO;
import DAO.PhieuDatBan_DAO;
import Entity.Ban;
import Entity.PhieuDatBan;
import Utils.Component.Header;
import Utils.Component.Item;
import Utils.Event.EventItem;
import Utils.Swing.ScrollBar;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import java.util.Timer;
import javax.swing.JViewport;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ADMIN
 */
public class DatBanForm extends javax.swing.JPanel {

    private Timer timer;
    private EventItem event;
    private DatePickerSettings DatePickerSetting;
    private PhieuDatBan_DAO phieuDatBan_DAO;
    private DefaultTableModel modelTable;

    public void setEvent(EventItem event) {
        this.event = event;
    }
    private final Ban_DAO ban_DAO;

    /**
     * Creates new form DatBanForm
     */
    public DatBanForm() {
        initComponents();
        try {
            ConnectDB.ConnectDB.getInstance().connect();
            System.out.println("Connected!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ban_DAO = new Ban_DAO();
        phieuDatBan_DAO = new PhieuDatBan_DAO();
        docDuLieuVaoDataBase();
        scroll.setVerticalScrollBar(new ScrollBar());

        setEvent(new EventItem() {
            @Override
            public void itemClick(Component com, Ban ban) {

                setSelected(com);
            }
        });

        timeTxt.addDateTimeChangeListener(event -> {
            LocalDateTime selectedDateTime = timeTxt.getDateTimeStrict();
            if (selectedDateTime != null) {
                String maPhieu = generateMaPhieu(selectedDateTime);
                maPhieuTxt.setText(maPhieu);
            }
        });
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTableStatus();
            }
        }, 0, 60000);

        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                modelTable.setRowCount(0);
                find(jTextField1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                modelTable.setRowCount(0);
                find(jTextField1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    public void addItem(Ban data) {
        Item item = new Item();
        item.setData(data);
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    event.itemClick(item, data);
                }
            }
        });
        dBPanelItem.add(item);
        dBPanelItem.repaint();
        dBPanelItem.revalidate();
    }

    private void docDuLieuVaoDataBase() {
        // Sử dụng background thread
        SwingWorker<Void, Ban> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Đọc dữ liệu từ SQL
                List<Ban> list = ban_DAO.getAllTableBan();
                for (Ban ban : list) {
                    publish(ban); // Gửi từng item lên giao diện
                }
                return null;
            }

            @Override
            protected void process(List<Ban> chunks) {
                // Thêm item vào giao diện trong EDT
                for (Ban ban : chunks) {
                    addItem(ban);
                }
            }
        };
        worker.execute(); // Bắt đầu chạy thread
    }

    public void setSelected(Component item) {
        for (Component com : dBPanelItem.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                i.setSelected(false);
            }
        }
        ((Item) item).setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datBanDialog = new javax.swing.JDialog();
        title = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        maPhieuTxt = new javax.swing.JTextField();
        maBanTxt = new javax.swing.JTextField();
        sdtTxt = new javax.swing.JTextField();
        huyBtn = new javax.swing.JButton();
        datBtn = new javax.swing.JButton();
        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
        TimePickerSettings timeSettings = new TimePickerSettings();
        timeSettings.use24HourClockFormat();
        timeTxt = new com.github.lgooddatepicker.components.DateTimePicker(dateSettings,timeSettings);
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        scrollPaneWin112 = new Utils.scroll.win11.ScrollPaneWin11();
        String[] colHeader = {"Mã phiếu","Số bàn","Số điện thoại","Thời điểm khách tới"};
        modelTable = new DefaultTableModel(colHeader, 0) {
            /**
            *
            */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable2 = new javax.swing.JTable(modelTable);
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        datBan = new javax.swing.JButton();
        phucVu = new javax.swing.JButton();
        baoTri = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        dBPanelItem = new Utils.Swing.DBPanelItem();

        datBanDialog.setModal(true);

        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Phiếu đặt bàn");
        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel9.setText("Mã phiếu");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel10.setText("Mã bàn");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel11.setText("Số điện thoại");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel13.setText("Thời gian");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        maPhieuTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        maPhieuTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        maPhieuTxt.setEnabled(false);
        maPhieuTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maPhieuTxtActionPerformed(evt);
            }
        });

        maBanTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        maBanTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        maBanTxt.setEnabled(false);

        sdtTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        huyBtn.setText("Hủy");
        huyBtn.setBackground(new java.awt.Color(255, 102, 102));
        huyBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        huyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyBtnActionPerformed(evt);
            }
        });

        datBtn.setText("Đặt bàn");
        datBtn.setBackground(new java.awt.Color(51, 204, 0));
        datBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        datBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datBtnActionPerformed(evt);
            }
        });

        timeTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeTxt.setInheritsPopupMenu(true);

        javax.swing.GroupLayout datBanDialogLayout = new javax.swing.GroupLayout(datBanDialog.getContentPane());
        datBanDialog.getContentPane().setLayout(datBanDialogLayout);
        datBanDialogLayout.setHorizontalGroup(
            datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datBanDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(datBanDialogLayout.createSequentialGroup()
                        .addGroup(datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(huyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maPhieuTxt)
                            .addComponent(maBanTxt)
                            .addComponent(sdtTxt)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datBanDialogLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(datBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(timeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))))
                .addContainerGap())
        );
        datBanDialogLayout.setVerticalGroup(
            datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datBanDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(maPhieuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(maBanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(sdtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(datBanDialogLayout.createSequentialGroup()
                        .addComponent(timeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(datBanDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datBtn)
                    .addComponent(huyBtn))
                .addGap(23, 23, 23))
        );

        jLabel1.setBackground(new java.awt.Color(102, 255, 102));
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setOpaque(true);

        jLabel2.setText("Đang phục vụ");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setOpaque(true);

        jLabel4.setText("Đã đặt");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 204, 204));
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);

        jLabel6.setText("Trống");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);

        jLabel8.setText("Bảo trì");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(118, 118, 118))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Danh sách đặt bàn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel12.setText("Tìm kiếm theo số điện thoại");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        scrollPaneWin112.setViewportView(jTable2);
        scrollPaneWin112.setColumnHeader(new JViewport() {
            /**
            *
            */
            private static final long serialVersionUID = 1L;

            @Override
            public Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                d.height = 32;
                return d;
            }
        });
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
        jTable2.setRowHeight(jTable2.getRowHeight() + 10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        datBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/notes.png"))); // NOI18N
        datBan.setText("Đặt bàn");
        datBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        datBan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        datBan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        datBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datBanActionPerformed(evt);
            }
        });

        phucVu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/serving-dish.png"))); // NOI18N
        phucVu.setText("Phục vụ");
        phucVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phucVu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        phucVu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        phucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phucVuActionPerformed(evt);
            }
        });

        baoTri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools.png"))); // NOI18N
        baoTri.setText("Bảo trì");
        baoTri.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        baoTri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        baoTri.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        baoTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baoTriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datBan, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(phucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(baoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(datBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(baoTri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);
        scroll.setViewportView(dBPanelItem);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scroll)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void datBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datBanActionPerformed
        for (Component com : dBPanelItem.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                if (i.getData().getTrangThai().equals("Đã đặt trước")) {
                    JOptionPane.showMessageDialog(null, "Bàn đã được đặt trước rồi!");
                    break;
                } else if (i.getData().getTrangThai().equals("Trống")) {
                    maBanTxt.setText(i.getData().getMaBan());
                    timeTxt.setDateTimeStrict(LocalDateTime.now());
                    datBanDialog.setSize(450, 400);
                    datBanDialog.setLocationRelativeTo(null);
                    datBanDialog.setVisible(true);
                    maPhieuTxt.setText(generateMaPhieu(LocalDateTime.now()));
                    break;
                } else if (i.getData().getTrangThai().equals("Bảo trì")) {
                    JOptionPane.showMessageDialog(null, "Bàn đang bảo trì không thể đặt trước");
                    break;
                } else if (i.getData().getTrangThai().equals("Đang sử dụng")) {
                    JOptionPane.showMessageDialog(null, "Bàn đang được phục vụ không thể đặt trước");
                    break;
                }
            }
        }
    }//GEN-LAST:event_datBanActionPerformed

    private void maPhieuTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maPhieuTxtActionPerformed

    }//GEN-LAST:event_maPhieuTxtActionPerformed

    private void huyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyBtnActionPerformed
        datBanDialog.dispose();
    }//GEN-LAST:event_huyBtnActionPerformed

    private void datBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datBtnActionPerformed
        if (sdtTxt.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại khách hàng");
            return;
        }
        datBanDialog.dispose();
        String maBan = maBanTxt.getText();
        String trangThai = "Đã đặt trước";
        Ban ban = new Ban(maBan, trangThai);
        if (ban_DAO.update(ban)) {
            JOptionPane.showMessageDialog(null, "Đặt bàn thành công");
            dBPanelItem.removeAll();
            docDuLieuVaoDataBase();
            String maPhieu = maPhieuTxt.getText();
            String sdt = sdtTxt.getText();
            LocalDateTime time = timeTxt.getDatePicker().getDate().atTime(timeTxt.getTimePicker().getTime());
            PhieuDatBan phieu = new PhieuDatBan(maPhieu, ban, sdt, time, "Chưa hoàn thành");
            phieuDatBan_DAO.insert(phieu);
            sdtTxt.setText("");
            modelTable.setRowCount(0);
            docDuLieuDatabaseVaoTable();
            maPhieuTxt.setText("");

        }

    }//GEN-LAST:event_datBtnActionPerformed

    private void baoTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baoTriActionPerformed
        for (Component com : dBPanelItem.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                if (i.getData().getTrangThai().equals("Đã đặt trước")) {
                    JOptionPane.showMessageDialog(null, "Bàn đã được đặt trước không thể bảo trì");
                    break;
                } else if (i.getData().getTrangThai().equals("Trống")) {
                    String maBan = i.getData().getMaBan();
                    String trangThai = "Bảo trì";
                    Ban ban = new Ban(maBan, trangThai);
                    if (ban_DAO.update(ban)) {
                        JOptionPane.showMessageDialog(null, "Bàn đã được chuyển thành bảo trì");
                        dBPanelItem.removeAll();
                        docDuLieuVaoDataBase();
                    }
                    break;
                } else if (i.getData().getTrangThai().equals("Bảo trì")) {
                    String maBan = i.getData().getMaBan();
                    String trangThai = "Trống";
                    Ban ban = new Ban(maBan, trangThai);
                    if (ban_DAO.update(ban)) {
                        JOptionPane.showMessageDialog(null, "Kết thúc bảo trì thành công");
                        dBPanelItem.removeAll();
                        docDuLieuVaoDataBase();
                    }
                    break;
                } else if (i.getData().getTrangThai().equals("Đang sử dụng")) {
                    JOptionPane.showMessageDialog(null, "Bàn đang được phục vụ không thể bảo trì");
                    break;
                }
            }
        }
    }//GEN-LAST:event_baoTriActionPerformed

    private void phucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phucVuActionPerformed
        for (Component com : dBPanelItem.getComponents()) {
            Item i = (Item) com;
            if (i.isSelected()) {
                if (i.getData().getTrangThai().equals("Đã đặt trước")) {
                    String maBan = i.getData().getMaBan();
                    String trangThai = "Đang sử dụng";
                    Ban ban = new Ban(maBan, trangThai);
                    if (ban_DAO.update(ban)) {
                        phieuDatBan_DAO.updateTrangThai(phieuDatBan_DAO.searchMaTheoMaBan(maBan));
                        JOptionPane.showMessageDialog(null, "Nhận khách vào bàn thành công");
                        dBPanelItem.removeAll();
                        docDuLieuVaoDataBase();
                        modelTable.setRowCount(0);
                        docDuLieuDatabaseVaoTable();
                    }
                } else if (i.getData().getTrangThai().equals("Trống")) {
                    String maBan = i.getData().getMaBan();
                    String trangThai = "Đang sử dụng";
                    Ban ban = new Ban(maBan, trangThai);
                    if (ban_DAO.update(ban)) {
                        JOptionPane.showMessageDialog(null, "Nhận khách vào bàn thành công");
                        dBPanelItem.removeAll();
                        docDuLieuVaoDataBase();
                    }
                    break;
                } else if (i.getData().getTrangThai().equals("Bảo trì")) {
                    JOptionPane.showMessageDialog(null,"Bàn đang bảo trì không thể nhận khách vào!");
                    break;
                }
            }
        }
    }//GEN-LAST:event_phucVuActionPerformed

    public String generateMaPhieu(LocalDateTime dateTime) {
        int hour = dateTime.getHour(); // Lấy giờ
        int day = dateTime.getDayOfMonth(); // Lấy ngày
        int month = dateTime.getMonthValue(); // Lấy tháng
        int year = dateTime.getYear() % 100; // Lấy hai chữ số cuối của năm
        int tt = kiemTraTT(day, month, year);
        // Tạo mã phiếu theo định dạng PXXYYZZAA
        return String.format("P%02d%02d%02d%02d%02d", hour, day, month, year, tt);
    }

    public int kiemTraTT(int day, int month, int year) {
        int tt = 1;
        List<PhieuDatBan> phieuDatBan = phieuDatBan_DAO.getAllTablePhieuDatBan();
        for (PhieuDatBan p : phieuDatBan) {
            if (p.getMaPhieu().substring(3, 9).equals(String.valueOf(day) + String.valueOf(month) + String.valueOf(year))) {
                tt += 1;
            }
        }
        return tt;
    }

    private void updateTableStatus() {
        modelTable.setRowCount(0);
        docDuLieuDatabaseVaoTable();
        dBPanelItem.removeAll();
        docDuLieuVaoDataBase();
    }

    private void docDuLieuDatabaseVaoTable() {
        List<PhieuDatBan> list = phieuDatBan_DAO.getAllTablePhieuDatBan();
        List<Ban> listB = ban_DAO.getAllTableBan();
        for (PhieuDatBan pdb : list) {
            if (pdb.getTrangThai().equals("Chưa hoàn thành") && Duration.between(LocalDateTime.now(), pdb.getThoiGianDat()).isPositive()) {
                modelTable.addRow(new Object[]{pdb.getMaPhieu(), pdb.getMaBan().getMaBan().substring(1), pdb.getSdt(), String.valueOf(pdb.getThoiGianDat())});
            } else if (pdb.getTrangThai().equals("Chưa hoàn thành") && Duration.between(LocalDateTime.now(), pdb.getThoiGianDat()).isNegative()) {
                if (Duration.between(LocalDateTime.now(), pdb.getThoiGianDat()).toHours() <= -1) {
                    phieuDatBan_DAO.updateTrangThai(pdb.getMaPhieu());
                    for (Ban ban : listB) {
                        if (ban.getMaBan().equals(pdb.getMaBan().getMaBan()) && ban.getTrangThai().equals("Đã đặt trước")) {
                            ban_DAO.updateTrangThaiTrong(ban.getMaBan());
                            break;
                        }
                    }
                } else {
                    modelTable.addRow(new Object[]{pdb.getMaPhieu(), pdb.getMaBan().getMaBan().substring(1), pdb.getSdt(), String.valueOf(pdb.getThoiGianDat())});
                }
            }
        }
    }

    public void find(String sdt) {
        List<PhieuDatBan> list = phieuDatBan_DAO.getAllTablePhieuDatBan();
        for (PhieuDatBan pdb : list) {
            if(pdb.getTrangThai().equals("Chưa hoàn thành")) {
                if(pdb.getSdt().contains(sdt)) {
                    modelTable.addRow(new Object[]{pdb.getMaPhieu(), pdb.getMaBan().getMaBan().substring(1), pdb.getSdt(), String.valueOf(pdb.getThoiGianDat())});
                } else if(pdb.getSdt().equals("")) {
                    docDuLieuDatabaseVaoTable();
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baoTri;
    private Utils.Swing.DBPanelItem dBPanelItem;
    private javax.swing.JButton datBan;
    private javax.swing.JDialog datBanDialog;
    private javax.swing.JButton datBtn;
    private javax.swing.JButton huyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField maBanTxt;
    private javax.swing.JTextField maPhieuTxt;
    private javax.swing.JButton phucVu;
    private javax.swing.JScrollPane scroll;
    private Utils.scroll.win11.ScrollPaneWin11 scrollPaneWin112;
    private javax.swing.JTextField sdtTxt;
    private com.github.lgooddatepicker.components.DateTimePicker timeTxt;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
