/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Entity.Ban;
import Entity.PhieuDatBan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.PreparedStatement;

/**
 *
 * @author ADMIN
 */
public class PhieuDatBan_DAO {
    public ArrayList<PhieuDatBan> getAllTablePhieuDatBan() {
        ArrayList<PhieuDatBan> dsp = new ArrayList<PhieuDatBan>();
        try {
                ConnectDB.getInstance();
                Connection con = ConnectDB.getConnection();
                String sql = "select * from PhieuDatBan";
                Statement statement = con.createStatement();
                //thuc thi cau lenh sql tra ve doi tuong result
                ResultSet rs = statement.executeQuery(sql);
                //duyet tren ket qua tra ve
                while(rs.next()) {
                        String maPhieu = rs.getString(1);
                        Ban maBan = new Ban(rs.getString(2));
                        String sdt = rs.getString(3);
                        LocalDateTime time = rs.getTimestamp(4).toLocalDateTime();
                        String trangThai = rs.getString(5);
                        PhieuDatBan phieuDatBan = new PhieuDatBan(maPhieu, maBan, sdt, time,trangThai);
                        dsp.add(phieuDatBan);
                }
        }catch(SQLException e) {
                e.printStackTrace();
        }
        return dsp;
    }
    
    public boolean insert(PhieuDatBan phieu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n =0;
		try {
			stmt = con.prepareStatement("insert into PhieuDatBan values (?,?,?,?,?)");
			stmt.setString(1, phieu.getMaPhieu());
			stmt.setString(2, phieu.getMaBan().getMaBan());
			stmt.setString(3, phieu.getSdt());
                        stmt.setTimestamp(4, java.sql.Timestamp.valueOf(phieu.getThoiGianDat()));
                        stmt.setString(5, phieu.getTrangThai());
			n = stmt.executeUpdate();
		} catch(SQLException e) {
			throw new IllegalArgumentException(e);
		} finally {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
    
    public boolean updateTrangThai(String maPhieu) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update PhieuDatBan set TrangThai=? where MaP =?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "Hoàn thành");
            stmt.setString(2, maPhieu);
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
    
    public boolean updateTrangThaiTheoBan(String maBan) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update PhieuDatBan set TrangThai=? where MaB =? and TrangThai = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "Hoàn thành");
            stmt.setString(2, maBan);
            stmt.setString(3, "Chưa hoàn thành");
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
    
    public String searchMaTheoMaBan(String maBan) {
        String maP = "";
        ArrayList<PhieuDatBan> dsPhieu = new ArrayList<PhieuDatBan>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MaP FROM PhieuDatBan WHERE MaB like ? and TrangThai like ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "%" + maBan + "%");
            statement.setString(2, "%" + "Chưa hoàn thành" + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                maP = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maP;
    }
}
