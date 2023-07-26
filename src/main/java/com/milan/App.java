package com.milan;

import java.sql.*;


public class App 
{
    public static void main( String[] args ) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/aliens";
        String user = "postgres";
        String pass = "milan123";
        int userid = 5;
        String username = "Dipali";
        String query = "insert into student values(?,?)";
//        String query = "select userName from student where userid=2";
        //String query = "select * from student";
        //String query = "insert into student values(4,'KajalMagar')";
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,user,pass);
        //Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,userid);
        st.setString(2,username);
        //ResultSet rs = st.executeQuery(query);//DDL,DML,DML,TCL
        //int count = st.executeUpdate(query);
        int count = st.executeUpdate();

        //String name = rs.getString("username");
        //System.out.println(name);

//        String userData = "";
//        while(rs.next())
//        {
//            userData = rs.getInt(1) + ":" + rs.getString(2);
//            System.out.println(userData);
//        }
        System.out.println(count + " row/s affected");

        st.close();
        con.close();
    }
}
