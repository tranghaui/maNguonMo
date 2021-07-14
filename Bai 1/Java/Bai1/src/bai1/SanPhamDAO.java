/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author haquo
 */
public class SanPhamDAO {
     private Connection conn;

    public SanPhamDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
                    + "databasename=PMMNM_Bai1;"
                    + "username=sa;"
                    + "password=admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<SanPham> dsSanPham() {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select * from LoaiSanPham inner join SanPham "
                + "on LoaiSanPham.MaLoaiSP = SanPham.MaLoaiSP";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham s = new SanPham();
                s.setMaSP(rs.getString("MaSP"));
                s.setTenSP(rs.getString("TenSP"));
                s.setNhaSanXuat(rs.getString("NhaSanXuat"));
                s.setMaLoaiSP(rs.getString("MaLoaiSP"));
                s.setTenLoaiSP(rs.getString("TenLoaiSP"));
                
                list.add(s);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public int themSanPham(SanPham s) {
        String sql = "insert into SanPham values(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getMaSP());
            ps.setString(2, s.getTenLoaiSP());
            ps.setString(3, s.getNhaSanXuat());
            ps.setString(4, s.getMaLoaiSP());
         
            if (ps.executeUpdate() > 0) {
                System.out.println("Successful!!!");
            } else {
                System.out.println("Failed :(((((");
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1;
    }
}
