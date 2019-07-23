package com.aaa.project.tool.swagger;

import com.aaa.framework.shiro.realm.UserRealm;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 陈建
 * @Date: 2019/4/22 0022 10:27
 * @Version 1.0
 */
public class BaseController {
    static String driver="com.mysql.cj.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/aaa?useSSL=false";
    static String user="root";
    static String password="root";
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection(){
        Connection connection=null;
        try {
             DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 查询通用方法
     * @return
     * @throws SQLException
     */
    public List<Map<String,Object>> executeQuery() throws SQLException {
        List<Map<String,Object>> list= new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from emp");
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        while(rs.next()){
            Map<String,Object> map = new HashMap();
            for(int i=0;i<metaData.getColumnCount();i++){
                map.put(metaData.getColumnName(i+1),rs.getObject(i+1));
            }
            list.add(map);
        }
        return list;

    }
}
