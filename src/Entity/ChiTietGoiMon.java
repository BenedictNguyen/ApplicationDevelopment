/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class ChiTietGoiMon {
    private String maCTGM;
    private NhanVien maNV;
    private MonAn maMA;
    private Ban maB;
    private int soLuong;
    private String ghiChu;
    private String trangThai;
    private LocalDateTime thoiDiem;
    private String thanhToan;

    public ChiTietGoiMon() {
    }

    public ChiTietGoiMon(String maCTGM, NhanVien maNV, MonAn maMA, Ban maB, int soLuong, String ghiChu, String trangThai, LocalDateTime thoiDiem, String thanhToan) {
        this.maCTGM = maCTGM;
        this.maNV = maNV;
        this.maMA = maMA;
        this.maB = maB;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.thoiDiem = thoiDiem;
        this.thanhToan = thanhToan;
    }

    public LocalDateTime getThoiDiem() {
        return thoiDiem;
    }

    public void setThoiDiem(LocalDateTime thoiDiem) {
        this.thoiDiem = thoiDiem;
    }

    

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    

    public ChiTietGoiMon(String maCTGM) {
        this.maCTGM = maCTGM;
    }

    public String getMaCTGM() {
        return maCTGM;
    }

    public void setMaCTGM(String maCTGM) {
        this.maCTGM = maCTGM;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public MonAn getMaMA() {
        return maMA;
    }

    public void setMaMA(MonAn maMA) {
        this.maMA = maMA;
    }

    public Ban getMaB() {
        return maB;
    }

    public void setMaB(Ban maB) {
        this.maB = maB;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ChiTietGoiMon{" + "maCTGM=" + maCTGM + ", maNV=" + maNV + ", maMA=" + maMA + ", maB=" + maB + ", soLuong=" + soLuong + ", ghiChu=" + ghiChu + ", trangThai=" + trangThai + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.maCTGM);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChiTietGoiMon other = (ChiTietGoiMon) obj;
        return Objects.equals(this.maCTGM, other.maCTGM);
    }
    
    
}
