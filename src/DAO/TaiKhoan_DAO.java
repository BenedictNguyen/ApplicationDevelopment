/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Entity.Ban;
import Entity.NhanVien;
import Entity.TaiKhoan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author ADMIN
 */
public class TaiKhoan_DAO {
    public ArrayList<TaiKhoan> getAllTableTaiKhoan() {
        ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
        try {
                ConnectDB.getInstance();
                Connection con = ConnectDB.getConnection();
                String sql = "select * from TaiKhoan";
                Statement statement = con.createStatement();
                //thuc thi cau lenh sql tra ve doi tuong result
                ResultSet rs = statement.executeQuery(sql);
                //duyet tren ket qua tra ve
                while(rs.next()) {
                        NhanVien maNV = new NhanVien(rs.getString(1));
                        String mk = rs.getString(2);
                        TaiKhoan tk = new TaiKhoan(maNV, mk);
                        dstk.add(tk);
                }
        }catch(SQLException e) {
                e.printStackTrace();
        }
        return dstk;
    }
    
    public boolean update(TaiKhoan tk) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update TaiKhoan set MatKhau=? where MaNV =?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tk.getMk());
            stmt.setString(2, tk.getTk().getMaNV());
            
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
    
    public boolean insert(TaiKhoan tk) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into TaiKhoan values (?,?)");
            stmt.setString(1, tk.getTk().getMaNV());
            stmt.setString(2, "test");
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
}
