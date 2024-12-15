/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.MonAn;
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
public class ChiTietHoaDon_DAO {
    public ArrayList<ChiTietHoaDon> getAllTableChiTietHoaDon() {
        ArrayList<ChiTietHoaDon> dsct = new ArrayList<ChiTietHoaDon>();
        try {
                ConnectDB.getInstance();
                Connection con = ConnectDB.getConnection();
                String sql = "select * from ChiTietHoaDon";
                Statement statement = con.createStatement();
                //thuc thi cau lenh sql tra ve doi tuong result
                ResultSet rs = statement.executeQuery(sql);
                //duyet tren ket qua tra ve
                while(rs.next()) {
                        HoaDon maHD = new HoaDon(rs.getString(1));
                        MonAn maMA = new MonAn(rs.getString(2));
                        int soLuong = rs.getInt(3);
                        float tongTien = rs.getFloat(4);              
                        ChiTietHoaDon ct = new ChiTietHoaDon(maHD, maMA, soLuong, tongTien);
                        dsct.add(ct);
                }
        }catch(SQLException e) {
                e.printStackTrace();
        }
        return dsct;
    }
    
    public boolean insert(ChiTietHoaDon cthd) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into ChiTietHoaDon values (?,?,?,?)");
            stmt.setString(1, cthd.getMaHD().getMaHD());
            stmt.setString(2, cthd.getMaMA().getMaMA());
            stmt.setInt(3, cthd.getSoLuong());
            stmt.setFloat(4, cthd.getTongTien());
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
