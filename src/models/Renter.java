package models;

public class Renter {
    private String first_name;
    private String last_name;
    private String inn;
    private String phoneNum;
    private String[] drive_category;


    public Renter(String first_name, String last_name, String inn, String phoneNum, String[] drive_category) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.inn = inn;
        this.phoneNum = phoneNum;
        this.drive_category = drive_category;
    }

    public Renter() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String[] getDrive_category() {
        return drive_category;
    }

    public void setDrive_category(String[] drive_category) {
        this.drive_category = drive_category;
    }

    @Override
    public String toString() {
        return "first and last name: " + getFirst_name() + " " + getLast_name() + "\ninn: " + getInn() + "\nphone number:" + getPhoneNum()
                + "\n----------------";
    }
}
