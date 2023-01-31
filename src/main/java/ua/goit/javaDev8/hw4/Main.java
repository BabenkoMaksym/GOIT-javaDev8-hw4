package ua.goit.javaDev8.hw4;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = Database.getConnection();
        System.out.println(connection);
        Connection connection2 = Database.getConnection();
        System.out.println(connection2);
        Connection connection3 = Database.getConnection();
        System.out.println(connection3);
        Connection connection4 = Database.getConnection();
        System.out.println(connection4);

    }
}