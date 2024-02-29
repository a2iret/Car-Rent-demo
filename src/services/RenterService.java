package services;

import models.Renter;
import repository.RenterRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RenterService {

    RenterRepo renterRepo = new RenterRepo();
    public void saveRenter(Renter renter){
        Connection connection = renterRepo.ConnectToDb();
        try {
            PreparedStatement prs = connection.prepareStatement("INSERT INTO renter(first_name, last_name, inn, phone_num) values(?,?,?,?)");
            prs.setString(1, renter.getFirst_name());
            prs.setString(2, renter.getLast_name());
            prs.setString(3, renter.getInn());
            prs.setString(4, renter.getPhoneNum());
            prs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRenterInfo(String inn, String newFirstName, String newLastName){
        PreparedStatement prs = null;
        try {
            prs = renterRepo.ConnectToDb().prepareStatement("UPDATE renter SET first_name = ?, last_name = ? WHERE inn = ?");
            prs.setString(1, newFirstName);
            prs.setString(2, newLastName);
            prs.setString(3, inn);
            prs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Renter> getAllUsers(){
        try {
            PreparedStatement prs = renterRepo.ConnectToDb().prepareStatement("SELECT * FROM renter");
            ArrayList<Renter> allUsers = new ArrayList<>();
            ResultSet resultSet = prs.executeQuery();
            while (resultSet.next()){
                Renter renter = new Renter();
                renter.setFirst_name(resultSet.getString("first_name"));
                renter.setLast_name(resultSet.getString("last_name"));
                renter.setInn(resultSet.getString("inn"));
                renter.setPhoneNum("phone_num");
                allUsers.add(renter);
            }return  allUsers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] getDriveCategory(String category ){
        return category.split(",");
    }
}
