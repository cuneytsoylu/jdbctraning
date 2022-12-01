package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.Adım:Driver a kaydol
        Class.forName("org.postgresql.Driver");

        //2.Adim: Database a baglan

      Connection con=  DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","aSDFGH1.@?-");

        //3.Adim: Statement oluştur.

       Statement st= con.createStatement();

       //4.Adim : Query çalıştır.

        //1.ornek
        String sq1="CREATE TABLE workers(worker_id VARCHAR(50),worker_name VARCHAR(50),worker_salary INT)";
        st.execute(sq1);

        //2.ornek

        String sql2="ALTER TABLE workers ADD worker_adress VARCHAR(80)";
        st.execute(sql2);

        //3.ornek
        String sql3="DROP TABLE workers";
        st.execute(sql3);

        //5.Adım :
        con.close();
        st.close();






    }
}
