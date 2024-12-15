/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Entity.Ban;
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
public class Ban_DAO {
    public ArrayList<Ban> getAllTableBan() {
        ArrayList<Ban> dsb = new ArrayList<Ban>();
        try {
                ConnectDB.getInstance();
                Connection con = ConnectDB.getConnection();
                String sql = "select * from Ban";
                Statement statement = con.createStatement();
                //thuc thi cau lenh sql tra ve doi tuong result
                ResultSet rs = statement.executeQuery(sql);
                //duyet tren ket qua tra ve
                while(rs.next()) {
                        String maBan = rs.getString(1);
                        String trangThai = rs.getString(2);
                        Ban ban = new Ban(maBan, trangThai);
                        dsb.add(ban);
                }
        }catch(SQLException e) {
                e.printStackTrace();
        }
        return dsb;
    }
    
    public boolean update(Ban ban) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			String sql = "update BAN set TrangThai=? where MaB = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(2, ban.getMaBan());
			stmt.setString(1, ban.getTrangThai());
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
    
    public boolean updateTrangThaiTrong(String maBan) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			String sql = "update BAN set TrangThai=? where MaB = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(2, maBan);
			stmt.setString(1, "Trống");
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
