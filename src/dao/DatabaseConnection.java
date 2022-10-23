package dao;

import utils.DatabaseInformation;
import utils.Query;

import java.sql.*;
import model.Donor;

public class DatabaseConnection {

    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;

    public DatabaseConnection() {
        String url = "jdbc:mysql://" + DatabaseInformation.host + ":" +
                DatabaseInformation.port + "/" + DatabaseInformation.db_name +
                "?useUnicode=true&characterEncoding=utf8";

        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }

        try {
            con = DriverManager.getConnection(url, DatabaseInformation.user_name, DatabaseInformation.password);
            System.out.println("Bağlantı Başarılı...");

        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
        }
    }

    public boolean Login(String name,String lastname,int password){
        String query = Query.login;

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastname);
            preparedStatement.setInt(3,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addDonor(Donor donor){

        try {
            preparedStatement = con.prepareStatement(Query.addDonor);
            preparedStatement.setString(1, donor.getName());
            preparedStatement.setString(2, donor.getLastname());
            preparedStatement.setString(3, String.valueOf(donor.getAge()));
            preparedStatement.setString(4, String.valueOf(donor.getIdentityNumber()));
            preparedStatement.setString(5, donor.getBloodGroup());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
