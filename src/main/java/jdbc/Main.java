package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        //DBWork objesini oluştur.
        DBWork db = new DBWork();

        //Connection methodunu çağır.
        Connection con = db.connect_to_db("techproed","postgres","aSDFGH1.@?-");

        //Yeni table oluşturma methodunu çağır.
        db.createTable(con,"employees");





    }
}