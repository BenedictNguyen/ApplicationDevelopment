/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Entity.Ban;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class HoaDon_DAO {
   public ArrayList<HoaDon> getAllTableHoaDon() {
        ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
        try {
                ConnectDB.getInstance();
                Connection con = ConnectDB.getConnection();
                String sql = "select * from HoaDon";
                Statement statement = con.createStatement();
                //thuc thi cau lenh sql tra ve doi tuong result
                ResultSet rs = statement.executeQuery(sql);
                //duyet tren ket qua tra ve
                while(rs.next()) {
                        String maHD = rs.getString(1);
                        LocalDate ngayLap = rs.getDate(2).toLocalDate();
                        String phuongThuc = rs.getString(3);
                        String trangThai = rs.getString(4);
                        NhanVien maNV = new NhanVien(rs.getString(5));
                        KhachHang maKH = new KhachHang(rs.getString(6));
                        Ban maBan = new Ban(rs.getString(7));
                        float thanhTien = rs.getFloat(8);
                        HoaDon hd = new HoaDon(maHD, ngayLap, phuongThuc, trangThai, maNV, maKH, maBan,thanhTien);
                        dshd.add(hd);
                }
        }catch(SQLException e) {
                e.printStackTrace();
        }
        return dshd;
    }
   
   public boolean insert(HoaDon hd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into HoaDon values (?,?,?,?,?,?,?,?)");
            stmt.setString(1, hd.getMaHD());
            stmt.setDate(2, java.sql.Date.valueOf(hd.getNgayLap()));
            stmt.setString(3, hd.getPhuongThuc());
            stmt.setString(4, hd.getTrangThai());
            stmt.setString(5, hd.getMaNV().getMaNV());
            stmt.setString(6, hd.getMaKH().getMaKH());
            stmt.setString(7, hd.getMaBan().getMaBan());
            stmt.setFloat(8, hd.getThanhTien());
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
   
   public boolean updateTrangThai(String maHD) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update HoaDon set TrangThai = ? where MaHD =?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "Đã thanh toán");
            stmt.setString(2, maHD);
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
}
