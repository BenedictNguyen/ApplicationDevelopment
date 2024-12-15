/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Entity.Ban;
import Entity.ChiTietGoiMon;
import Entity.MonAn;
import Entity.NhanVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class ChiTietGoiMon_DAO {

    public ArrayList<ChiTietGoiMon> getAllTableChiTietGoiMon() {
        ArrayList<ChiTietGoiMon> dsct = new ArrayList<ChiTietGoiMon>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from ChiTietGoiMon";
            Statement statement = con.createStatement();
            //thuc thi cau lenh sql tra ve doi tuong result
            ResultSet rs = statement.executeQuery(sql);
            //duyet tren ket qua tra ve
            while (rs.next()) {
                String maCTGM = rs.getString(1);
                NhanVien maNV = new NhanVien(rs.getString(2));
                MonAn maMA = new MonAn(rs.getString(3));
                Ban maB = new Ban(rs.getString(4));
                int soLuong = rs.getInt(5);
                String ghiChu = rs.getString(6);
                String trangThai = rs.getString(7);
                LocalDateTime thoiDiem = rs.getTimestamp(8).toLocalDateTime();
                String thanhToan = rs.getString(9);
                ChiTietGoiMon ctgm = new ChiTietGoiMon(maCTGM, maNV, maMA, maB, soLuong, ghiChu, trangThai,thoiDiem ,thanhToan);
                dsct.add(ctgm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsct;
    }

    public ArrayList<ChiTietGoiMon> searchBanChuaThanhToan(String maBan) {
        ArrayList<ChiTietGoiMon> dsGM = new ArrayList<ChiTietGoiMon>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from ChiTietGoiMon CTGM join Ban B on B.MaB=CTGM.MaB"
                    + " where CTGM.MaB=? and CTGM.ThanhToan = ? and B.TrangThai = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maBan);
            statement.setString(2, "Chưa thanh toán");
            statement.setString(3, "Đang sử dụng");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maCTGM = rs.getString(1);
                NhanVien maNV = new NhanVien(rs.getString(2));
                MonAn maMA = new MonAn(rs.getString(3));
                Ban ban = new Ban(rs.getString(4));
                int soLuong = rs.getInt(5);
                String ghiChu = rs.getString(6);
                String trangThai = rs.getString(7);
                LocalDateTime thoiDiem = rs.getTimestamp(8).toLocalDateTime();
                String thanhToan = rs.getString(9);
                ChiTietGoiMon ctgm = new ChiTietGoiMon(maCTGM, maNV, maMA, ban, soLuong, ghiChu, trangThai,thoiDiem,thanhToan);
                dsGM.add(ctgm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsGM;
    }
    
    public boolean delete(String maPhieu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietGoiMon where MaCTGM=?");
			stmt.setString(1, maPhieu);
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
    
    public ArrayList<ChiTietGoiMon> searchBanChuaThanhToanDaHoanThanh(String maBan) {
        ArrayList<ChiTietGoiMon> dsGM = new ArrayList<ChiTietGoiMon>();
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "select * from ChiTietGoiMon CTGM join Ban B on B.MaB=CTGM.MaB"
                    + " where CTGM.MaB=? and CTGM.ThanhToan = ? and B.TrangThai = ? and CTGM.TrangThai = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maBan);
            statement.setString(2, "Chưa thanh toán");
            statement.setString(3, "Đang sử dụng");
            statement.setString(4, "Hoàn thành");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String maCTGM = rs.getString(1);
                NhanVien maNV = new NhanVien(rs.getString(2));
                MonAn maMA = new MonAn(rs.getString(3));
                Ban ban = new Ban(rs.getString(4));
                int soLuong = rs.getInt(5);
                String ghiChu = rs.getString(6);
                String trangThai = rs.getString(7);
                LocalDateTime thoiDiem = rs.getTimestamp(8).toLocalDateTime();
                String thanhToan = rs.getString(9);
                ChiTietGoiMon ctgm = new ChiTietGoiMon(maCTGM, maNV, maMA, ban, soLuong, ghiChu, trangThai,thoiDiem,thanhToan);
                dsGM.add(ctgm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsGM;
    }
    
    public boolean insert(ChiTietGoiMon gm) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("insert into ChiTietGoiMon values (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, gm.getMaCTGM());
            stmt.setString(2, gm.getMaNV().getMaNV());
            stmt.setString(3, gm.getMaMA().getMaMA());
            stmt.setString(4, gm.getMaB().getMaBan());
            stmt.setInt(5, gm.getSoLuong());
            stmt.setString(6, gm.getGhiChu());
            stmt.setString(7, gm.getTrangThai());
            stmt.setTimestamp(8, Timestamp.valueOf(gm.getThoiDiem()));
            stmt.setString(9, gm.getThanhToan());
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
    
    public boolean updateTrangThai(String trangThai,String maCTGM) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update ChiTietGoiMon set TrangThai=? where MaCTGM =?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, trangThai);
            stmt.setString(2, maCTGM);
            
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
    
    public boolean updateThanhToan(String thanhToan,String maCTGM) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            String sql = "update ChiTietGoiMon set ThanhToan=? where MaCTGM =?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, thanhToan);
            stmt.setString(2, maCTGM);
            
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
