/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylib;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author QUANG
 */
public class DBUtils {
    //PE ko đụng
    public static Connection makeConnection() throws Exception {
        Connection cn = null;
        String IP = "localhost"; //server IP (e.g: azure)
        String instanceName = "QUANG-LAPTOP\\MQUANG"; //SQL/main db/properties
        String port = "1433";
        String uid = "sa";
        String pwd = "12345";
        String db = "WS_PRJ301"; //properties/copy
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://" + IP + "\\" + instanceName + ":" + port
                + ";databasename=" + db + ";user=" + uid + ";password=" + pwd;
        Class.forName(driver);
        cn = DriverManager.getConnection(url);
        return cn; //ra null: fail
    }

}
