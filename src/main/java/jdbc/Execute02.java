package jdbc;

import java.sql.*;

public class Execute02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con=  DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","aSDFGH1.@?-");
        Statement st= con.createStatement();


//1.ornek
        String sql1="SELECT country_name FROM countries WHERE region_id = 1 ";
        st.execute(sql1);

        ResultSet result1=st.executeQuery(sql1);
        //recordları gormek icin executeQuery() methodu kullanmalıyız.
        while (result1.next()){

            System.out.println(result1.getString("country_name"));
        }


        //2.ornek
        String sql2="SELECT country_id, country_name FROM countries WHERE region_id > 2";
ResultSet result2=st.executeQuery(sql2);

while(result2.next()){
    System.out.println(result2.getString("country_id")+"-->"+ result2.getString("country_name"));
}


//3.ornek
        String sql3="select * from companies where  number_of_employees = (select min(number_of_employees) from companies)";
        ResultSet result3=st.executeQuery(sql3);
        while(result3.next()){
            System.out.println(result3.getInt("company_id"/*1*/)+"-->"+ result3.getString("company"/*2*/)+"-->"+ result3.getInt("number_of_employees")/*3*/);
        }
        con.close();
        st.close();


    }
}
