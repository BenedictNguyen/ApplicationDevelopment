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
public class Ban {
    private String maBan;
    private String trangThai;

    public Ban() {
    }

    public Ban(String maBan, String trangThai) {
        this.maBan = maBan;
        this.trangThai = trangThai;
    }
    
    public Ban(String maBan) {
        this.maBan = maBan;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Ban{" + "maBan=" + maBan + ", trangThai=" + trangThai + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.maBan);
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
        final Ban other = (Ban) obj;
        return Objects.equals(this.maBan, other.maBan);
    }
    
    
}
