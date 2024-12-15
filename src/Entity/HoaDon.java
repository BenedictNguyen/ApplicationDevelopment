/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class HoaDon {
    private String maHD;
    private LocalDate ngayLap;
    private String phuongThuc;
    private String trangThai;
    private NhanVien maNV;
    private KhachHang maKH;
    private Ban maBan;
    private float thanhTien;

    public HoaDon() {
    }

    public HoaDon(String maHD, LocalDate ngayLap, String phuongThuc, String trangThai, NhanVien maNV, KhachHang maKH, Ban maBan, float thanhTien) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.phuongThuc = phuongThuc;
        this.trangThai = trangThai;
        this.maNV = maNV;
        this.maKH = maKH;
        this.maBan = maBan;
        this.thanhTien = thanhTien;
    }

    public Ban getMaBan() {
        return maBan;
    }

    public void setMaBan(Ban maBan) {
        this.maBan = maBan;
    }

    

    public HoaDon(String maHD) {
        this.maHD = maHD;
    }
    
    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getPhuongThuc() {
        return phuongThuc;
    }

    public void setPhuongThuc(String phuongThuc) {
        this.phuongThuc = phuongThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public NhanVien getMaNV() {
        return maNV;
    }

    public void setMaNV(NhanVien maNV) {
        this.maNV = maNV;
    }

    public KhachHang getMaKH() {
        return maKH;
    }

    public void setMaKH(KhachHang maKH) {
        this.maKH = maKH;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.maHD);
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
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
        final HoaDon other = (HoaDon) obj;
        return Objects.equals(this.maHD, other.maHD);
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", ngayLap=" + ngayLap + ", phuongThuc=" + phuongThuc + ", trangThai=" + trangThai + ", maNV=" + maNV + ", maKH=" + maKH + ", thanhTien=" + thanhTien + '}';
    }
    
    
}
