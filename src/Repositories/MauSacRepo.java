/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Connections.jdbcUtils;
import DomainModel.MauSac_SanphamModel;
import ITFService.MauSacITF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CQTRUONG
 */
public class MauSacRepo implements MauSacITF{
    

    @Override
    public ArrayList<MauSac_SanphamModel> All() {
         ArrayList<MauSac_SanphamModel> listMS = new ArrayList<MauSac_SanphamModel>();
       try {
            Connection conn = jdbcUtils.getConnection();
            String puery = "SELECT * FROM MauSac";
            
            PreparedStatement ps = conn.prepareStatement(puery);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            
            while(rs.next() == true){
               
                String ma = rs.getString("MaMS");
                String ten = rs.getString("TenMS");
                
                MauSac_SanphamModel ms = new MauSac_SanphamModel(ma, ten,null);
                listMS.add(ms);
            }
        } catch (Exception ex) {
            
        }
        return listMS;
        
        
    }

    @Override
    public void insert(MauSac_SanphamModel ms) {
       try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "insert into MauSac "
                    + "(MaMS,TenMS)"
                    + "VALUES(?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ms.getMaMS());
            ps.setString(2, ms.getTenMS());
            
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(String ma, MauSac_SanphamModel ms) {
          try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "UPDATE MauSac set "
                    + "TenMS = ? WHERE MaMS = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
          
            ps.setString(1, ms.getTenMS());
            ps.setString(2, ma);
            
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String ma) {
       try {
            Connection conn = jdbcUtils.getConnection();
            String sql = "DELETE MauSac "
                    + "  WHERE MaMS = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
          
            
            ps.setString(1, ma);
            
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public ArrayList<MauSac_SanphamModel> CbxMauSac() {
        ArrayList<MauSac_SanphamModel> list = new ArrayList<>();
        try {
            Connection con = jdbcUtils.getConnection();
            String sql = "select id,tenms from MauSac";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac_SanphamModel ms = new MauSac_SanphamModel();
                ms.setId(rs.getString("id"));
                ms.setTenMS(rs.getString("tenms"));
                list.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
