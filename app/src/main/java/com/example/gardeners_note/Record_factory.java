package com.example.gardeners_note;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public  class Record_factory {
    public Record_factory(){

    }
    public static void add() {

    }
    public static void edit() {

    }
    public static void delate() {

    }
    public  Calendar_record get(int day, int month, int year)  {
     //   conn.Conn();
        //   conn.CloseDB();
        return new Calendar_record(1, 5, 2025, "День труда");
    }
    public static class db {

        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            conn.Conn();
            //conn.CreateDB();
            //conn.WriteDB();
            //conn.ReadDB();
            conn.CloseDB();
        }
    }

    public static class conn {
        public static Connection conn;
        public static Statement statmt;
        public static ResultSet resSet;

        // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
        public static void Conn() throws ClassNotFoundException, SQLException {
            conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:gardeners_note.db");

            System.out.println("База Подключена!");
        }

        // --------Закрытие--------
        public static void CloseDB() throws ClassNotFoundException, SQLException
        {
            conn.close();
            statmt.close();
            resSet.close();

            System.out.println("Соединения закрыты");
        }

    }

}
