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
public class KhachHang {
    private String maKH;
    private String tenKH;
    private String sdt;
    private String email;
    private LocalDate ngaySinh;
    private LocalDate ngayDangKy;
    private int diemThuong;
    private String capBac;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String sdt, String email, LocalDate ngaySinh, LocalDate ngayDangKy, int diemThuong, String capBac) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.ngayDangKy = ngayDangKy;
        this.diemThuong = diemThuong;
        this.capBac = capBac;
    }

    public KhachHang(String maKH) {
        this.maKH = maKH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public int getDiemThuong() {
        return diemThuong;
    }

    public void setDiemThuong(int diemThuong) {
        this.diemThuong = diemThuong;
    }

    public String getCapBac() {
        return capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.maKH);
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
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maKH, other.maKH);
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", email=" + email + ", ngaySinh=" + ngaySinh + ", ngayDangKy=" + ngayDangKy + ", diemThuong=" + diemThuong + ", capBac=" + capBac + '}';
    }
    
    
}
