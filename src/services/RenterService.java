package services;

import models.Car;
import models.RentInfo;
import models.Renter;
import models.enums.TypeOfCar;
import repository.Repo;

import java.sql.*;
import java.util.ArrayList;

public class RenterService {

    Repo renterRepo = new Repo();
    Connection connection = renterRepo.ConnectToDb();

    public void saveRenter(Renter renter){
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

    public ArrayList<Car> showCars(){
        try {
            PreparedStatement prs = connection.prepareStatement("select * from cars WHERE id NOT IN (\n" +
                    "\tselect car_id from rent_info \n" +
                    "\twhere end_date > CURRENT_TIMESTAMP\n" +
                    ")");
            ArrayList<Car> cars = new ArrayList<>();
            ResultSet resultSet = prs.executeQuery();
            while (resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getDate("year"));
                car.setType(TypeOfCar.valueOf(resultSet.getString("type")));
                car.setGos_num(resultSet.getString("gos_num"));
                car.setMark(resultSet.getString("mark"));
                cars.add(car);
            }return cars;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    public void updateRenterInfo(String inn, String newFirstName, String newLastName){
        PreparedStatement prs = null;
        try {
            prs = connection.prepareStatement("UPDATE renter SET first_name = ?, last_name = ? WHERE inn = ?");
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
            PreparedStatement prs = connection.prepareStatement("SELECT * FROM renter");
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

    public void createRentInfo(RentInfo rentInfo){
        try {
            PreparedStatement prs = connection.prepareStatement("INSERT INTO rent_info(start_date, end_date, car_id, renter_id, status) VALUES(?,?,?,?,?)");
            prs.setDate(1, rentInfo.getStartDate());
            prs.setDate(2, rentInfo.getEndDate());
            prs.setInt(3, rentInfo.getCarId());
            prs.setInt(4, rentInfo.getRenterId());
            prs.setObject(5, rentInfo.getStatus(), Types.OTHER);
            prs.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public String[] getDriveCategory(String category ){
        return category.split(",");
    }
}
