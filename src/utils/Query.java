package utils;

public interface Query {
    String login = "Select * From admin where name = ? and lastname = ? and password = ?";
    String addDonor = "Insert into donor (name,lastname,age,identity_number,blood_group) VALUES(?,?,?,?,?)";
}
