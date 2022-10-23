package service;

import dao.DatabaseConnection;

public class AdminService {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public boolean Login(String name,String lastname,int password){
        return databaseConnection.Login(name,lastname,password);
    }

}
