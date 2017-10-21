package com.komarmoss.model.vo;

import com.komarmoss.model.entity.TypeOfVehicleEntity;
import com.komarmoss.model.entity.VehicleEntity;

import java.io.Serializable;

public class VehicleVO implements Serializable {
    private Integer id;
    private String name;
    private String brand;
    private int yearOfIssue;
    private VehicleTypeVO type;

    public VehicleVO() {
    }

    public VehicleVO(VehicleEntity entity) {
        if (entity != null) {
            id = entity.getId();
            name = entity.getName();
            brand = entity.getBrand();
            yearOfIssue = entity.getYearOfIssue();
            TypeOfVehicleEntity vehicleType = entity.getType();
            if (vehicleType != null)
                type = new VehicleTypeVO(vehicleType);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public VehicleTypeVO getType() {
        return type;
    }

    public void setType(VehicleTypeVO type) {
        this.type = type;
    }
}
