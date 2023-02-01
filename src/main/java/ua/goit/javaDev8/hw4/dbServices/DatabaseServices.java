package ua.goit.javaDev8.hw4.dbServices;

import ua.goit.javaDev8.hw4.Database;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseServices {

    Connection conn;
    StringBuilder sql;
    Statement st;

    public DatabaseServices() {
        conn = Database.getConnection();
        sql = new StringBuilder();
        st = null;
    }

    public void initDB() {
        String defaultFilePath = "sql/init_db.sql";
        initDB(defaultFilePath);
    }

    public void populateDB() {
        String defaultFilePath = "sql/populate_db.sql";
        populateDB(defaultFilePath);
    }

    public void initDB(String filePath) {
        try {
            st = conn.createStatement();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
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
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void populateDB(String filePath) {
        try {
            st = conn.createStatement();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            while (true) {
                String s = reader.readLine();
                if (s != null) {
                    sql.append(s);
                } else {
                    int executeResult = st.executeUpdate(sql.toString().trim());
                    System.out.println(executeResult);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }



}
