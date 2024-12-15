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
public class TaiKhoan {
    private NhanVien tk;
    private String mk;

    public TaiKhoan() {
    }

    public TaiKhoan(NhanVien tk, String mk) {
        this.tk = tk;
        this.mk = mk;
    }

    public TaiKhoan(NhanVien tk) {
        this.tk = tk;
    }

    public NhanVien getTk() {
        return tk;
    }

    public void setTk(NhanVien tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.tk);
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
        final TaiKhoan other = (TaiKhoan) obj;
        return Objects.equals(this.tk, other.tk);
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "tk=" + tk + ", mk=" + mk + '}';
    }
    
    
}
