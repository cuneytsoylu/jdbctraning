package jdbcPractice;

import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1) Driver Yükle
        Class.forName("org.postgresql.Driver");

        //2) Bağlantı Oluştur.
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","aSDFGH1.@?-");

        //3) Statament
        Statement st = con.createStatement();

        //4) ResultSet
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        //5) Sonuçları Al
        while (veri.next()){

            //index kullanarak
            //System.out.println(veri.getInt(1) + veri.getString(2) +veri.getString(3) + veri.getString(4));

            //sutun ismi kullanarak
            //System.out.println(veri.getInt("okul_no") + veri.getString("ogrenci_ismi")+ veri.getString("sinif") + veri.getString("cinsiyet"));

            System.out.printf("%-8d %-15.15s %-10s %-10s\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));
        }


        //6) Kapatma
        con.close();
        st.close();
        veri.close();
    }
}
