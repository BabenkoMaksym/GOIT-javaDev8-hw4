package ua.goit.javaDev8.hw4.dbServices;

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
        DatabaseServices dbServices = new DatabaseServices();
        dbServices.initDB();
    }
}
