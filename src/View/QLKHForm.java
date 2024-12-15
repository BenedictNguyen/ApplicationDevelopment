package View;

import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import Entity.KhachHang;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DatePickerSettings.DateArea;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class QLKHForm extends javax.swing.JPanel {

    private final KhachHang_DAO kh_dao;
    private DefaultTableModel modelTable;

    /**
     * Creates new form QLKHForm
     */
    public QLKHForm() {
        initComponents();
        Date d = new Date();
        try {
            ConnectDB.ConnectDB.getInstance().connect();
            System.out.println("Connected!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        kh_dao = new KhachHang_DAO();
        docDuLieuDatabaseVaoTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timKiem = new javax.swing.JDialog();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        timKiemTheoMa = new javax.swing.JDialog();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        timKiemTheoSDT = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        timKiemTheoTen = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        timKiemTheoEmail = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        scrollPaneWin112 = new Utils.scroll.win11.ScrollPaneWin11();
        String[] colHeader = {"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Email", "Ngày sinh", "Ngày đăng ký","Điểm thường","Cấp bậc"};
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
        jTable1 = new javax.swing.JTable(modelTable);
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        maKHTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tenKHTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sdtTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        diemThuongTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        capBacTxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        DatePickerSettings dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
        ngaySinhTxt = new com.github.lgooddatepicker.components.DatePicker(dateSettings);
        DatePickerSettings dateSettings2 = new DatePickerSettings();
        dateSettings2.setFormatForDatesCommonEra("dd/MM/yyyy");
        dateSettings2.setColor(DateArea.DatePickerTextDisabled, Color.BLACK);
        ngayDangKyTxt = new com.github.lgooddatepicker.components.DatePicker(dateSettings2);

        timKiem.setModal(true);

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setText("Tìm theo mã khách hàng");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton6.setText("Tìm theo số điện thoại khách hàng");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton7.setText("Tìm theo tên khách hàng");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton8.setText("Tìm theo email");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 0, 51));
        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton14.setText("Hủy");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout timKiemLayout = new javax.swing.GroupLayout(timKiem.getContentPane());
        timKiem.getContentPane().setLayout(timKiemLayout);
        timKiemLayout.setHorizontalGroup(
            timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        timKiemLayout.setVerticalGroup(
            timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(18, 18, 18)
                .addComponent(jButton14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timKiemTheoMa.setModal(true);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Nhập mã khách hàng");

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField8.setToolTipText("");

        jButton10.setBackground(new java.awt.Color(51, 204, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton10.setText("Tìm");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 0, 51));
        jButton15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton15.setText("Hủy");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout timKiemTheoMaLayout = new javax.swing.GroupLayout(timKiemTheoMa.getContentPane());
        timKiemTheoMa.getContentPane().setLayout(timKiemTheoMaLayout);
        timKiemTheoMaLayout.setHorizontalGroup(
            timKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemTheoMaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8))
                .addContainerGap())
        );
        timKiemTheoMaLayout.setVerticalGroup(
            timKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemTheoMaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timKiemTheoSDT.setModal(true);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Nhập số điện thoại khách hàng");

        jTextField9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField9.setToolTipText("");

        jButton11.setBackground(new java.awt.Color(51, 204, 0));
        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton11.setText("Tìm");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(255, 0, 51));
        jButton16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton16.setText("Hủy");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout timKiemTheoSDTLayout = new javax.swing.GroupLayout(timKiemTheoSDT.getContentPane());
        timKiemTheoSDT.getContentPane().setLayout(timKiemTheoSDTLayout);
        timKiemTheoSDTLayout.setHorizontalGroup(
            timKiemTheoSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemTheoSDTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timKiemTheoSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField9))
                .addContainerGap())
        );
        timKiemTheoSDTLayout.setVerticalGroup(
            timKiemTheoSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemTheoSDTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timKiemTheoTen.setModal(true);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nhập tên khách hàng");

        jTextField10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField10.setToolTipText("");

        jButton12.setBackground(new java.awt.Color(51, 204, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton12.setText("Tìm");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton17.setBackground(new java.awt.Color(255, 0, 51));
        jButton17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton17.setText("Hủy");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout timKiemTheoTenLayout = new javax.swing.GroupLayout(timKiemTheoTen.getContentPane());
        timKiemTheoTen.getContentPane().setLayout(timKiemTheoTenLayout);
        timKiemTheoTenLayout.setHorizontalGroup(
            timKiemTheoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemTheoTenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timKiemTheoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField10))
                .addContainerGap())
        );
        timKiemTheoTenLayout.setVerticalGroup(
            timKiemTheoTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemTheoTenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timKiemTheoEmail.setModal(true);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Nhập email khách hàng");

        jTextField11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField11.setToolTipText("");

        jButton13.setBackground(new java.awt.Color(51, 204, 0));
        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton13.setText("Tìm");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(255, 0, 51));
        jButton18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton18.setText("Hủy");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout timKiemTheoEmailLayout = new javax.swing.GroupLayout(timKiemTheoEmail.getContentPane());
        timKiemTheoEmail.getContentPane().setLayout(timKiemTheoEmailLayout);
        timKiemTheoEmailLayout.setHorizontalGroup(
            timKiemTheoEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemTheoEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timKiemTheoEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField11))
                .addContainerGap())
        );
        timKiemTheoEmailLayout.setVerticalGroup(
            timKiemTheoEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timKiemTheoEmailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        scrollPaneWin112.setViewportView(jTable1);
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
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
        jTable1.setRowHeight(jTable1.getRowHeight() + 10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Mã khách hàng");

        maKHTxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        maKHTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        maKHTxt.setEnabled(false);
        maKHTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maKHTxtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tên khách hàng");

        tenKHTxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        tenKHTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Số điện thoại");

        sdtTxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Email");

        emailTxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Ngày sinh");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Ngày đăng ký");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Điểm thưởng");

        diemThuongTxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        diemThuongTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        diemThuongTxt.setEnabled(false);
        diemThuongTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diemThuongTxtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Cấp bậc");

        capBacTxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        capBacTxt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        capBacTxt.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add32.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tools32.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/research32.png"))); // NOI18N
        jButton3.setText("Tìm");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reload32.png"))); // NOI18N
        jButton4.setText("Làm mới");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        ngaySinhTxt.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N

        ngayDangKyTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maKHTxt)
                            .addComponent(tenKHTxt)
                            .addComponent(sdtTxt)
                            .addComponent(diemThuongTxt)
                            .addComponent(capBacTxt)
                            .addComponent(emailTxt)
                            .addComponent(ngaySinhTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ngayDangKyTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maKHTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tenKHTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sdtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ngaySinhTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ngayDangKyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(diemThuongTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(capBacTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        ngaySinhTxt.setDate(LocalDate.now());
        ngayDangKyTxt.setDate(LocalDate.now());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneWin112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void maKHTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maKHTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maKHTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!maKHTxt.getText().isEmpty()) {
            if (!tenKHTxt.getText().trim().isEmpty() || !sdtTxt.getText().trim().isEmpty()) {
                if (ngaySinhTxt.getDate().getYear() <= LocalDate.now().getYear() - 18) {
                    String maKH = maKHTxt.getText();
                    String tenKH = tenKHTxt.getText();
                    String sdtKH = sdtTxt.getText();
                    String emailKH = emailTxt.getText();
                    LocalDate ngaySinhKH = ngaySinhTxt.getDate();
                    LocalDate ngayDangKyKH = ngayDangKyTxt.getDate();
                    int diemThuongKH = Integer.parseInt(diemThuongTxt.getText());
                    String capBacKH = capBacTxt.getText();
                    KhachHang kh = new KhachHang(maKH, tenKH, sdtKH, emailKH, ngaySinhKH, ngayDangKyKH, diemThuongKH, capBacKH);
                    try {
                        if (kh_dao.insert(kh)) {
                            JOptionPane.showMessageDialog(null, "Đã thêm khách hàng thành công");
                            modelTable.setRowCount(0);
                            maKHTxt.setText(generateMaKH(LocalDate.now()));
                            tenKHTxt.setText("");
                            sdtTxt.setText("");
                            emailTxt.setText("");
                            ngayDangKyTxt.setDate(LocalDate.now());
                            ngaySinhTxt.setDate(LocalDate.now());
                            diemThuongTxt.setText("");
                            capBacTxt.setText("");
                            jTable1.clearSelection();
                            jTextField8.setText("");
                            timKiemTheoMa.dispose();
                            docDuLieuDatabaseVaoTable();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Vui lòng làm mới trước khi thêm");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Khách hàng chưa đủ 18 tuổi!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng làm mới trước khi thêm");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        timKiem.setSize(400, 320);
        timKiem.setLocationRelativeTo(null);
        timKiem.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        timKiem.dispose();
        timKiemTheoMa.setSize(300, 250);
        timKiemTheoMa.setLocationRelativeTo(null);
        timKiemTheoMa.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        ngayDangKyTxt.setEnabled(false);
        diemThuongTxt.setEnabled(false);
        capBacTxt.setEnabled(false);

        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            maKHTxt.setText((String) modelTable.getValueAt(row, 0));
            tenKHTxt.setText((String) modelTable.getValueAt(row, 1));
            sdtTxt.setText((String) modelTable.getValueAt(row, 2));
            emailTxt.setText((String) modelTable.getValueAt(row, 3));
            ngaySinhTxt.setDate((LocalDate) modelTable.getValueAt(row, 4));
            ngayDangKyTxt.setDate((LocalDate) modelTable.getValueAt(row, 5));
            diemThuongTxt.setText(String.valueOf(modelTable.getValueAt(row, 6)));
            capBacTxt.setText((String) modelTable.getValueAt(row, 7));
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        timKiem.dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String ma = jTextField8.getText();

        if (!ma.isEmpty()) {
            ArrayList<KhachHang> khs = kh_dao.searchTheoMa(ma);
            modelTable.setRowCount(0);
            for (KhachHang kh : khs) {
                modelTable.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getEmail(), kh.getNgaySinh(), kh.getNgayDangKy(), kh.getDiemThuong(), kh.getCapBac()});
            }
            maKHTxt.setText("");
            tenKHTxt.setText("");
            sdtTxt.setText("");
            emailTxt.setText("");
            ngayDangKyTxt.setDate(LocalDate.now());
            ngaySinhTxt.setDate(LocalDate.now());
            diemThuongTxt.setText("");
            capBacTxt.setText("");
            jTable1.clearSelection();
            jTextField8.setText("");
            timKiemTheoMa.dispose();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        timKiemTheoMa.dispose();
        timKiem.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String sdt = jTextField9.getText();

        if (!sdt.isEmpty()) {
            ArrayList<KhachHang> khs = kh_dao.searchTheoSDT(sdt);
            modelTable.setRowCount(0);
            for (KhachHang kh : khs) {
                modelTable.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getEmail(), kh.getNgaySinh(), kh.getNgayDangKy(), kh.getDiemThuong(), kh.getCapBac()});
            }
            maKHTxt.setText("");
            tenKHTxt.setText("");
            sdtTxt.setText("");
            emailTxt.setText("");
            ngayDangKyTxt.setDate(LocalDate.now());
            ngaySinhTxt.setDate(LocalDate.now());
            diemThuongTxt.setText("");
            capBacTxt.setText("");
            jTable1.clearSelection();
            jTextField9.setText("");
            timKiemTheoSDT.dispose();
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        timKiemTheoSDT.dispose();
        timKiem.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        timKiem.dispose();
        timKiemTheoSDT.setSize(400, 250);
        timKiemTheoSDT.setLocationRelativeTo(null);
        timKiemTheoSDT.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String ten = jTextField10.getText();

        if (!ten.isEmpty()) {
            ArrayList<KhachHang> khs = kh_dao.searchTheoTen(ten);
            modelTable.setRowCount(0);
            for (KhachHang kh : khs) {
                modelTable.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getEmail(), kh.getNgaySinh(), kh.getNgayDangKy(), kh.getDiemThuong(), kh.getCapBac()});
            }
            maKHTxt.setText("");
            tenKHTxt.setText("");
            sdtTxt.setText("");
            emailTxt.setText("");
            ngayDangKyTxt.setDate(LocalDate.now());
            ngaySinhTxt.setDate(LocalDate.now());
            diemThuongTxt.setText("");
            capBacTxt.setText("");
            jTable1.clearSelection();
            jTextField10.setText("");
            timKiemTheoTen.dispose();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        timKiemTheoTen.dispose();
        timKiem.setVisible(true);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        timKiem.dispose();
        timKiemTheoTen.setSize(400, 250);
        timKiemTheoTen.setLocationRelativeTo(null);
        timKiemTheoTen.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String email = jTextField11.getText();

        if (!email.isEmpty()) {
            ArrayList<KhachHang> khs = kh_dao.searchTheoEmail(email);
            modelTable.setRowCount(0);
            for (KhachHang kh : khs) {
                modelTable.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getEmail(), kh.getNgaySinh(), kh.getNgayDangKy(), kh.getDiemThuong(), kh.getCapBac()});
            }
            maKHTxt.setText("");
            tenKHTxt.setText("");
            sdtTxt.setText("");
            emailTxt.setText("");
            ngayDangKyTxt.setDate(LocalDate.now());
            ngaySinhTxt.setDate(LocalDate.now());
            diemThuongTxt.setText("");
            capBacTxt.setText("");
            jTable1.clearSelection();
            jTextField11.setText("");
            timKiemTheoEmail.dispose();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        timKiemTheoEmail.dispose();
        timKiem.setVisible(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        timKiem.dispose();
        timKiemTheoEmail.setSize(400, 250);
        timKiemTheoEmail.setLocationRelativeTo(null);
        timKiemTheoEmail.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        modelTable.setRowCount(0);
        maKHTxt.setText(generateMaKH(LocalDate.now()));
        tenKHTxt.setText("");
        sdtTxt.setText("");
        emailTxt.setText("");
        ngayDangKyTxt.setDate(LocalDate.now());
        ngaySinhTxt.setDate(LocalDate.now());
        diemThuongTxt.setText("0");
        capBacTxt.setText("Đồng");
        jTable1.clearSelection();
        docDuLieuDatabaseVaoTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            modelTable.setValueAt(tenKHTxt.getText(), row, 1);
            modelTable.setValueAt(sdtTxt.getText(), row, 2);
            modelTable.setValueAt(emailTxt.getText(), row, 3);
            modelTable.setValueAt(ngaySinhTxt.getDate().toString(), row, 4);

            String maKH = maKHTxt.getText();
            String tenKH = tenKHTxt.getText();
            String sdtKH = sdtTxt.getText();
            String emailKH = emailTxt.getText();
            LocalDate ngaySinhKH = ngaySinhTxt.getDate();
            LocalDate ngayDangKyKH = ngayDangKyTxt.getDate();
            int diemThuong = Integer.parseInt(diemThuongTxt.getText());
            String capBacKH = capBacTxt.getText();
            KhachHang kh = new KhachHang(maKH, tenKH, sdtKH, emailKH, ngaySinhKH, ngayDangKyKH,diemThuong,capBacKH);
            if (kh_dao.update(kh)) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void diemThuongTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diemThuongTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diemThuongTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField capBacTxt;
    private javax.swing.JTextField diemThuongTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField maKHTxt;
    private com.github.lgooddatepicker.components.DatePicker ngayDangKyTxt;
    private com.github.lgooddatepicker.components.DatePicker ngaySinhTxt;
    private Utils.scroll.win11.ScrollPaneWin11 scrollPaneWin112;
    private javax.swing.JTextField sdtTxt;
    private javax.swing.JTextField tenKHTxt;
    private javax.swing.JDialog timKiem;
    private javax.swing.JDialog timKiemTheoEmail;
    private javax.swing.JDialog timKiemTheoMa;
    private javax.swing.JDialog timKiemTheoSDT;
    private javax.swing.JDialog timKiemTheoTen;
    // End of variables declaration//GEN-END:variables

    private void docDuLieuDatabaseVaoTable() {
        List<KhachHang> list = kh_dao.getAllTableKhachHang();
        for (KhachHang kh : list) {
            modelTable.addRow(new Object[]{kh.getMaKH(), kh.getTenKH(), kh.getSdt(), kh.getEmail(), kh.getNgaySinh(), kh.getNgayDangKy(), kh.getDiemThuong(), kh.getCapBac()});
        }
    }

    public int kiemTraTT(int year) {
        int tt = 1;
        List<KhachHang> khs = kh_dao.getAllTableKhachHang();
        for (KhachHang kh : khs) {
            if (kh.getMaKH().substring(4, 6).equals(String.valueOf(year))) {
                tt += 1;
            }
        }
        return tt;
    }

    public String generateMaKH(LocalDate date) {
        int day = date.getDayOfMonth(); // Lấy ngày
        int month = date.getMonthValue(); // Lấy tháng
        int year = date.getYear() % 100; // Lấy hai chữ số cuối của năm
        int tt = kiemTraTT(year);
        // Tạo mã phiếu theo định dạng PXXYYZZAA
        return String.format("KH%02d%02d%04d", month, year, tt);
    }
}
