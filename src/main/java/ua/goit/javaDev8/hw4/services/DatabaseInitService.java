package ua.goit.javaDev8.hw4.services;

import ua.goit.javaDev8.hw4.Database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {


    public static void main(String[] args) {
        final String INIT_DB_PATH = "sql/init_db.sql";
        StringBuilder sql = new StringBuilder();

        Connection conn = Database.getConnection();
        Statement st = null;



        try {
            st = conn.createStatement();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(INIT_DB_PATH)));
            while (true) {
                String s = reader.readLine();
                if (s != null) {
                    sql.append(s);
                    if (s.contains(";")) {
                        boolean executeResult = st.execute(sql.toString().trim());
                        System.out.println(executeResult);
                        sql.setLength(0);
                    }
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
