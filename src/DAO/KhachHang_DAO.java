/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Entity.KhachHang;
import Entity.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author ADMIN
 */
public class KhachHang_DAO {

    public ArrayList<KhachHang> getAllTableKhachHang() {
        ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from KhachHang";
            Statement statement = con.createStatement();
            //thuc thi cau lenh sql tra ve doi tuong result
            ResultSet rs = statement.executeQuery(sql);
            //duyet tren ket qua tra ve
            while (rs.next()) {
                String maKH = rs.getString(1);
                String tenKH = rs.getString(2);
                String sdt = rs.getString(3);
                String email = rs.getString(4);
                LocalDate ngaySinh = rs.getDate("ngaySinh") != null
                         ? rs.getDate("ngaySinh").toLocalDate(): null;
                LocalDate ngayDangKy = rs.getDate(6).toLocalDate();
                int diemThuong = rs.getInt(7);
                String capBac = rs.getString(8);
                KhachHang kh = new KhachHang(maKH, tenKH, sdt, email, ngaySinh, ngayDangKy, diemThuong, capBac);
                dskh.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dskh;
    }

    public ArrayList<KhachHang> searchTheoMa(String maKH) {
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE MaKH like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + maKH + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maKhach = rs.getString(1);
                String tenKhach = rs.getString(2);
                String sdt = rs.getString(3);
                String email = rs.getString(4);
                LocalDate ngaySinh = rs.getDate(5).toLocalDate();
                LocalDate ngayDangKy = rs.getDate(6).toLocalDate();
                int diemThuong = rs.getInt(7);
                String capBac = rs.getString(8);
                KhachHang kh = new KhachHang(maKhach, tenKhach, sdt, email, ngaySinh, ngayDangKy, diemThuong, capBac);
                dsKH.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKH;
    }

    public ArrayList<KhachHang> searchTheoSDT(String sdt) {
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE SDT like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + sdt + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maKhach = rs.getString(1);
                String tenKhach = rs.getString(2);
                String sDT = rs.getString(3);
                String email = rs.getString(4);
                LocalDate ngaySinh = rs.getDate(5).toLocalDate();
                LocalDate ngayDangKy = rs.getDate(6).toLocalDate();
                int diemThuong = rs.getInt(7);
                String capBac = rs.getString(8);
                KhachHang kh = new KhachHang(maKhach, tenKhach, sDT, email, ngaySinh, ngayDangKy, diemThuong, capBac);
                dsKH.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKH;
    }

    public ArrayList<KhachHang> searchTheoTen(String ten) {
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE TenKH like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + ten + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maKhach = rs.getString(1);
                String tenKhach = rs.getString(2);
                String sDT = rs.getString(3);
                String email = rs.getString(4);
                LocalDate ngaySinh = rs.getDate(5).toLocalDate();
                LocalDate ngayDangKy = rs.getDate(6).toLocalDate();
                int diemThuong = rs.getInt(7);
                String capBac = rs.getString(8);
                KhachHang kh = new KhachHang(maKhach, tenKhach, sDT, email, ngaySinh, ngayDangKy, diemThuong, capBac);
                dsKH.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKH;
    }

    public ArrayList<KhachHang> searchTheoEmail(String email) {
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM KhachHang WHERE Email like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + email + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maKhach = rs.getString(1);
                String tenKhach = rs.getString(2);
                String sDT = rs.getString(3);
                String emaiL = rs.getString(4);
                LocalDate ngaySinh = rs.getDate(5).toLocalDate();
                LocalDate ngayDangKy = rs.getDate(6).toLocalDate();
                int diemThuong = rs.getInt(7);
                String capBac = rs.getString(8);
                KhachHang kh = new KhachHang(maKhach, tenKhach, sDT, emaiL, ngaySinh, ngayDangKy, diemThuong, capBac);
                dsKH.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsKH;
    }

    public boolean insert(KhachHang kh) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into KhachHang values (?,?,?,?,?,?,?)");
            stmt.setString(1, kh.getMaKH());
            stmt.setString(2, kh.getTenKH());
            stmt.setString(3, kh.getSdt());
            stmt.setString(4, kh.getEmail());
            if (kh.getNgaySinh() == null) {
                stmt.setNull(5, java.sql.Types.DATE); // Đặt giá trị NULL vào SQL
            } else {
                stmt.setDate(5, java.sql.Date.valueOf(kh.getNgaySinh())); // Lưu LocalDate
            }
            stmt.setDate(6, java.sql.Date.valueOf(kh.getNgayDangKy()));
            stmt.setInt(7, kh.getDiemThuong());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public boolean update(KhachHang kh) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update KhachHang set TenKH=?,SDT=?,Email=?,NgaySinh=? where MaKH =?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, kh.getTenKH());
            stmt.setString(2, kh.getSdt());
            stmt.setString(3, kh.getEmail());
            stmt.setDate(4, java.sql.Date.valueOf(kh.getNgaySinh()));
            stmt.setString(5, kh.getMaKH());
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }

    public String searchMaTheoSDT(String sdt) {
        String maKH = "";
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MaKH FROM KhachHang WHERE SDT like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + sdt + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                maKH = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maKH;
    }
    
    public boolean capNhatDiem(String sdt,int diemThuong) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update KhachHang set DiemThuong = ? where SDT = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, diemThuong);
            stmt.setString(2, sdt);
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return n > 0;
    }
    
    public int searchDiemTheoSDT(String sdt) {
        int diem = 0;
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT DiemThuong FROM KhachHang WHERE SDT like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + sdt + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                diem = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diem;
    }
}
