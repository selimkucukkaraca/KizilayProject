package service;

import dao.DatabaseConnection;
import model.Donor;

import java.sql.SQLException;
import java.util.List;

public class DonorService {

    private final DatabaseConnection databaseConnection = new DatabaseConnection();

    public void addDonor(Donor donor) {
        databaseConnection.addDonor(donor);
    }

    public List<Donor> getAll() {
        try {
            return databaseConnection.findDonorList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getBlood(int identiyNumber){
        databaseConnection.getBloodByIdentiyNumber(identiyNumber);
    }
}
