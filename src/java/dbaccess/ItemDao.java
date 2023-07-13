/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbaccess;

import basicobject.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author QUANG
 */
public class ItemDao {
    public static ArrayList<Item> getAll() throws Exception {
        ArrayList<Item> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select *\n"
                    + "from dbo.Items";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("ItemId"));
                    String name = rs.getString("ItemName");
                    int price = Integer.parseInt(rs.getString("Price"));
                    int CateId = Integer.parseInt(rs.getString("CateId"));
                    Item i = new Item(id, name, price, CateId); 
                    list.add(i);
                }
            }
            cn.close();
        }
        return list;
    }

    public static Item getOne(String itemId) throws Exception {
        Item us = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select *\n"
                    + "from dbo.Items where ItemId = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, itemId);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) { 
                    int id = Integer.parseInt(rs.getString("ItemId"));
                    String name = rs.getString("ItemName");
                    int price = Integer.parseInt(rs.getString("Price"));;
                    int CateId = Integer.parseInt(rs.getString("CateId"));
                    us = new Item(id, name, price, CateId); 
                }
            }
            cn.close();
        }
        return us;
    }
    
    public static int update(String id, String name, String price, String cateId
            , String oldId) throws Exception {
        Connection cn = DBUtils.makeConnection();
        int rs = 0;

        if (cn != null) {
            String sql = "update Items "
                    + "set ItemId = ?, ItemName = ?, Price = ?, CateId = ? "
                    + "where ItemId = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, id);
            pst.setString(2, name);
            pst.setString(3, price);
            pst.setString(4, cateId);
            pst.setString(5, oldId);
            rs = pst.executeUpdate();
            cn.close();
        }
        return rs;
    }
}
