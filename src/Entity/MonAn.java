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
public class MonAn {
    private String maMA;
    private String tenMA;
    private float donGia;
    private int soLuong;
    private String trangThai;
    private Loai maLoai;
    public String imageName;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public MonAn() {
    }

    public MonAn(String maMA, String tenMA, float donGia, int soLuong, String trangThai, Loai maLoai, String imageName) {
        this.maMA = maMA;
        this.tenMA = tenMA;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.maLoai = maLoai;
        this.imageName = imageName;
    }

    public MonAn(String maMA) {
        this.maMA = maMA;
    }

    public String getMaMA() {
        return maMA;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Loai getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(Loai maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.maMA);
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
        final MonAn other = (MonAn) obj;
        return Objects.equals(this.maMA, other.maMA);
    }

    @Override
    public String toString() {
        return "MonAn{" + "maMA=" + maMA + ", tenMA=" + tenMA + ", donGia=" + donGia + ", soLuong=" + soLuong + ", trangThai=" + trangThai + ", maLoai=" + maLoai + '}';
    }
}
