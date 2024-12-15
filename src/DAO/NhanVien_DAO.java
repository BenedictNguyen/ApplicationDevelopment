/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import ConnectDB.ConnectDB;
import Entity.NhanVien;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class NhanVien_DAO {
    public ArrayList<NhanVien> getAllTableNhanVien() {
        ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
        try {
                ConnectDB.getInstance();
                Connection con = ConnectDB.getConnection();
                String sql = "select * from NHANVIEN";
                Statement statement = con.createStatement();
                //thuc thi cau lenh sql tra ve doi tuong result
                ResultSet rs = statement.executeQuery(sql);
                //duyet tren ket qua tra ve
                while(rs.next()) {
                        String maNV = rs.getString(1);
                        String tenNV = rs.getString(2);
                        String chucVu = rs.getString(3);
                        String gioiTinh = rs.getString(4);
                        String sdt = rs.getString(5);
                        String email = rs.getString(6);
                        LocalDate ngaySinh = rs.getDate(7).toLocalDate();
                        LocalDate ngayVaoLam = rs.getDate(8).toLocalDate();
                        String tinhTrang = rs.getString(9);
                        NhanVien nv = new NhanVien(maNV, tenNV, chucVu, gioiTinh, sdt,email, ngaySinh, ngayVaoLam,tinhTrang);
                        dsnv.add(nv);
                }
        }catch(SQLException e) {
                e.printStackTrace();
        }
        return dsnv;
    }
    
    public boolean insert(NhanVien nv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into NhanVien values (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, nv.getMaNV());
            stmt.setString(2, nv.getTenNV());
            stmt.setString(3, nv.getChucVu());
            stmt.setString(4, nv.getGioiTinh());
            stmt.setString(5, nv.getSdt());
            stmt.setString(6, nv.getEmail());
            stmt.setDate(7, java.sql.Date.valueOf(nv.getNgaySinh()));
            stmt.setDate(8, java.sql.Date.valueOf(nv.getNgayVaoLam()));
            stmt.setString(8, nv.getTinhTrang());
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
    
    public boolean update(NhanVien nv) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update NhanVien set TenNV=?,ChucVu = ?,GioiTinh = ?,SDT = ?,Email=?,TinhTrang=? where MaNV =?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nv.getTenNV());
            stmt.setString(2, nv.getChucVu());
            stmt.setString(3, nv.getGioiTinh());
            stmt.setString(4, nv.getSdt());
            stmt.setString(5, nv.getEmail());
            stmt.setString(6, nv.getTinhTrang());
            stmt.setString(7, nv.getMaNV());
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
