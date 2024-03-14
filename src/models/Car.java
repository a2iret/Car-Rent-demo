package models;

import models.enums.TypeOfCar;

import java.util.Date;

public class Car {

    private int id;
    private String model;
    private Date year;
    private TypeOfCar type;
    private String gos_num;
    private String mark;

    public Car() {
    }

    public Car(String model, Date year, TypeOfCar type, String gos_num, String mark){
        this.model = model;
        this.year = year;
        this.type = type;
        this.gos_num = gos_num;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public TypeOfCar getType() {
        return type;
    }

    public void setType(TypeOfCar type) {
        this.type = type;
    }

    public String getGos_num() {
        return gos_num;
    }

    public void setGos_num(String gos_num) {
        this.gos_num = gos_num;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "№: "+getId()+"\nMark: " + getMark() + "\nType: " + type + "\nModel: " + getModel() + "\nyear: "+getYear()
               + "\nnumber: "+getGos_num()+"\n----------------";
    }
}
