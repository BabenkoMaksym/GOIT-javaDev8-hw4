package ua.goit.javaDev8.hw4.dbServices;

import ua.goit.javaDev8.hw4.Database;

public class DatabasePopulateService {
    public static void main(String[] args) {
       DatabaseServices dbServices = new DatabaseServices();
       dbServices.populateDB();
       Database.closeConnection();
    }
}
