/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDon {
    private HoaDon maHD;
    private MonAn maMA;
    private int soLuong;
    private float tongTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(HoaDon maHD, MonAn maMA, int soLuong, float tongTien) {
        this.maHD = maHD;
        this.maMA = maMA;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public ChiTietHoaDon(HoaDon maHD, MonAn maMA) {
        this.maHD = maHD;
        this.maMA = maMA;
    }

    public HoaDon getMaHD() {
        return maHD;
    }

    public void setMaHD(HoaDon maHD) {
        this.maHD = maHD;
    }

    public MonAn getMaMA() {
        return maMA;
    }

    public void setMaMA(MonAn maMA) {
        this.maMA = maMA;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.maHD);
        hash = 89 * hash + Objects.hashCode(this.maMA);
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
        final ChiTietHoaDon other = (ChiTietHoaDon) obj;
        if (!Objects.equals(this.maHD, other.maHD)) {
            return false;
        }
        return Objects.equals(this.maMA, other.maMA);
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "maHD=" + maHD + ", maMA=" + maMA + ", soLuong=" + soLuong + ", tongTien=" + tongTien + '}';
    }
    
    
}
