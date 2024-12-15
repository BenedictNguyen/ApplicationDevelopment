/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Entity.Ban;
import Entity.Loai;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Loai_DAO {
    public ArrayList<Loai> getAllTableLoaiMon() {
        ArrayList<Loai> dsl = new ArrayList<Loai>();
        try {
                ConnectDB.getInstance();
                Connection con = ConnectDB.getConnection();
                String sql = "select * from LoaiMon";
                Statement statement = con.createStatement();
                //thuc thi cau lenh sql tra ve doi tuong result
                ResultSet rs = statement.executeQuery(sql);
                //duyet tren ket qua tra ve
                while(rs.next()) {
                        String maLoai = rs.getString(1);
                        String tenLoai = rs.getString(2);
                        Loai loai = new Loai(maLoai, tenLoai);
                        dsl.add(loai);
                }
        }catch(SQLException e) {
                e.printStackTrace();
        }
        return dsl;
    }
}
