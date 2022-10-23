package service;

import dao.DatabaseConnection;
import model.Donor;

public class DonorService {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public void addDonor(Donor donor){
        databaseConnection.addDonor(donor);
    }
}
