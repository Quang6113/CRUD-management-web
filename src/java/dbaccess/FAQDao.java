/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbaccess;

import basicobject.FAQ;
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
public class FAQDao {
    public static ArrayList<FAQ> getAll() throws Exception {
        ArrayList<FAQ> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select *\n"
                    + "from dbo.FAQ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("Id"));
                    String custName = rs.getString("CustName");
                    String content = rs.getString("CustContent");
                    int ItemId = Integer.parseInt(rs.getString("ItemId"));
                    FAQ f = new FAQ(id, custName, content, ItemId);
                    list.add(f);
                }
            }
            cn.close();
        }
        return list;
    }
    
    public static ArrayList<FAQ> getAllByItem(String itemId) throws Exception {
        ArrayList<FAQ> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select *\n"
                    + "from dbo.FAQ where ItemId = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, itemId);
            ResultSet rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) { 
                    int id = Integer.parseInt(rs.getString("Id"));
                    String custName = rs.getString("CustName");
                    String content = rs.getString("CustContent");
                    int ItemId = Integer.parseInt(rs.getString("ItemId"));
                    FAQ f = new FAQ(id, custName, content, ItemId);
                    list.add(f);
                }
            }
            cn.close();
        }
        return list;
    }
}
