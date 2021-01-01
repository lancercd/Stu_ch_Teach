package com.choose.stu_tea.utils;

import com.choose.stu_tea.config.Config;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DB {

    private Connection connection = null;
    private Statement st = null;
    private ResultSet resultSet = null;

    public DB(){

    }


    /**
     * 数据库连接
     */
    public void connect(){
        if(connection != null) return;
        try {
            Class.forName(Config.MYSQL_DRIVER_CLASS_NAME);
            this.connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PWD);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * 执行sql语句
     * @param sql sql语句
     * @return ResultSet
     */
    public static ResultSet exe(String sql){
        DB db = new DB();
        db.connect();
        try {
            db.st = db.connection.createStatement();
            db.resultSet = db.st.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return db.resultSet;
    }


    /**
     * 执行sql并返回格式化的数据
     * @param sql sql语句
     * @return ArrayList
     */
    public static ArrayList<HashMap<String, Object>> query(String sql){
        ArrayList<HashMap<String, Object>> list = listConstractor(exe(sql));
        return list;
    }


    public static HashMap<String, Object> find(String sql){
        return MapConstractor(exe(sql));
    }

    /**
     * 数据格式化
     * @param resultSet 查询结果
     * @return ArrayList
     */
    private static ArrayList<HashMap<String, Object>> listConstractor(ResultSet resultSet) {
        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        try {
            while (resultSet.next()) {
                list.add(MapConstractor(resultSet));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    private static HashMap<String, Object> MapConstractor(ResultSet resultSet) {
        HashMap<String, Object> map = new HashMap<String, Object>();

        ResultSetMetaData resultSetMetaData = null;
        try {
            resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                map.put(resultSetMetaData.getColumnLabel(i), resultSet.getObject(i));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return map;
    }

}
