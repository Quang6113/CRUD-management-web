/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbaccess;

import basicobject.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylib.DBUtils;

/**
 *
 * @author QUANG
 */
public class CategoryDao {
    public static ArrayList<Category> getAll() throws Exception {
        ArrayList<Category> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "select *\n"
                    + "from dbo.Categories";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    int id = Integer.parseInt(rs.getString("CateId"));
                    String name = rs.getString("CateName");
                    boolean status = Boolean.parseBoolean(rs.getString("Status"));
                    Category c = new Category(id, name, status);
                    list.add(c);
                }
            }
            cn.close();
        }
        return list;
    }
    
}
