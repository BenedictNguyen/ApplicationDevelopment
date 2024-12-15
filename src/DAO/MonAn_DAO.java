/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Entity.KhachHang;
import Entity.Loai;
import Entity.MonAn;
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
public class MonAn_DAO {

    public ArrayList<MonAn> getAllTableMonAn() {
        ArrayList<MonAn> dsma = new ArrayList<MonAn>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from MonAn";
            Statement statement = con.createStatement();
            //thuc thi cau lenh sql tra ve doi tuong result
            ResultSet rs = statement.executeQuery(sql);
            //duyet tren ket qua tra ve
            while (rs.next()) {
                String maMA = rs.getString(1);
                String tenMA = rs.getString(2);
                float donGia = rs.getFloat(3);
                int soLuong = rs.getInt(4);
                String trangThai = rs.getString(5);
                Loai maLoai = new Loai(rs.getString(6));
                String img = rs.getString(7);
                MonAn ma = new MonAn(maMA, tenMA, donGia, soLuong, trangThai, maLoai, img);
                dsma.add(ma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsma;
    }

    public boolean update(MonAn ma) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update MonAn set DonGia=?,SoLuong=?,TrangThai=? where MaMA =?";
            stmt = con.prepareStatement(sql);
            stmt.setFloat(1, ma.getDonGia());
            stmt.setInt(2, ma.getSoLuong());
            stmt.setString(3, ma.getTrangThai());
            stmt.setString(4, ma.getMaMA());
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

    public boolean insert(MonAn ma) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into MonAn values (?,?,?,?,?,?,?)");
            stmt.setString(1, ma.getMaMA());
            stmt.setString(2, ma.getTenMA());
            stmt.setFloat(3, ma.getDonGia());
            stmt.setInt(4, ma.getSoLuong());
            stmt.setString(5, ma.getTrangThai());
            stmt.setString(6, ma.getMaLoai().getMaLoai());
            stmt.setString(7, ma.getImageName());
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

    public ArrayList<MonAn> searchTheoMa(String maMA) {
//        String keyword = maMA;
//        keyword = "%" + keyword + "%";
        ArrayList<MonAn> dsMA = new ArrayList<MonAn>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM MonAn WHERE MaMA like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%"+maMA+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maMon = rs.getString(1);
                String tenMA = rs.getString(2);
                float donGia = rs.getFloat(3);
                int soLuong = rs.getInt(4);
                String trangThai = rs.getString(5);
                Loai maLoai = new Loai(rs.getString(6));
                String img = rs.getString(7);
                MonAn ma = new MonAn(maMon, tenMA, donGia, soLuong, trangThai, maLoai, img);
                dsMA.add(ma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMA;
    }

    public ArrayList<MonAn> searchTheoTen(String ten) {
        ArrayList<MonAn> dsMA = new ArrayList<MonAn>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM MonAn WHERE TenMA like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%"+ten+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maMon = rs.getString(1);
                String tenMA = rs.getString(2);
                float donGia = rs.getFloat(3);
                int soLuong = rs.getInt(4);
                String trangThai = rs.getString(5);
                Loai maLoai = new Loai(rs.getString(6));
                String img = rs.getString(7);
                MonAn ma = new MonAn(maMon, tenMA, donGia, soLuong, trangThai, maLoai, img);
                dsMA.add(ma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMA;
    }
    
    public ArrayList<MonAn> searchTheoLoaiMon(String maLoai) {
        ArrayList<MonAn> dsMA = new ArrayList<MonAn>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT * FROM MonAn WHERE MaLoai = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1,maLoai);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maMon = rs.getString(1);
                String tenMA = rs.getString(2);
                float donGia = rs.getFloat(3);
                int soLuong = rs.getInt(4);
                String trangThai = rs.getString(5);
                Loai maL = new Loai(rs.getString(6));
                String img = rs.getString(7);
                MonAn ma = new MonAn(maMon, tenMA, donGia, soLuong, trangThai, maL, img);
                dsMA.add(ma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMA;
    }
    
    public String searchTenMonAnTheoMa(String maMA) {
        String tenMon = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT TenMA FROM MonAn WHERE MaMA like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maMA);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                tenMon = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenMon;
    }
    
    public Float searchDonGiaMonAnTheoMa(String maMA) {
        float donGia = 0;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT DonGia FROM MonAn WHERE MaMA like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maMA);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                donGia = rs.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return donGia;
    }
}
