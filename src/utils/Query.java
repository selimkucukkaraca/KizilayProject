package utils;

public interface Query {
    String login = "Select * From admin where name = ? and lastname = ? and password = ?";
    String addDonor = "Insert into donor (name,lastname,age,identity_number,blood_group) VALUES(?,?,?,?,?)";
    String findAllDonor = "Select * from ";  // sonuna bosluk birakmak lazim dao'da + "donor" yaptigin icin
    String getBlood = "Delete from donor where identity_number = ?";
}
