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
public class PhieuDatBan {

    private String maPhieu;
    private Ban maBan;
    private String sdt;
    private LocalDateTime thoiGianDat;
    private String trangThai;

    public PhieuDatBan() {
    }

    public PhieuDatBan(String maPhieu, Ban maBan, String sdt, LocalDateTime thoiGianDat, String trangThai) {
        this.maPhieu = maPhieu;
        this.maBan = maBan;
        this.sdt = sdt;
        this.thoiGianDat = thoiGianDat;
        this.trangThai = trangThai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public PhieuDatBan(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Ban getMaBan() {
        return maBan;
    }

    public void setMaBan(Ban maBan) {
        this.maBan = maBan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public LocalDateTime getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(LocalDateTime thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    @Override
    public String toString() {
        return "PhieuDatBan{" + "maPhieu=" + maPhieu + ", maBan=" + maBan + ", sdt=" + sdt + ", thoiGianDat=" + thoiGianDat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.maPhieu);
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
        final PhieuDatBan other = (PhieuDatBan) obj;
        return Objects.equals(this.maPhieu, other.maPhieu);
    }

}
