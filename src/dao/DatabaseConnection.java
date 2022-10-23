package dao;

import utils.DatabaseInformation;
import utils.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            preparedStatement.setInt(3, donor.getAge());
            preparedStatement.setInt(4, donor.getIdentityNumber());
            preparedStatement.setString(5, donor.getBloodGroup());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Donor> findDonorList() throws SQLException {

        statement = con.createStatement();
        final List<Donor> donorList = new ArrayList<>();
        String query = Query.findAllDonor + "donor";

        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                int identityNumber = resultSet.getInt("identity_number");
                String bloodGroup = resultSet.getString("blood_group");
                donorList.add(new Donor(name,lastname,age,identityNumber,bloodGroup));
            }
            return donorList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getBloodByIdentiyNumber(int identityNumber){
        String query = Query.getBlood;

        try {
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,identityNumber); //
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
