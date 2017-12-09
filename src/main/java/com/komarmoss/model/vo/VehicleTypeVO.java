package com.komarmoss.model.vo;

import com.komarmoss.model.entity.TypeOfVehicleEntity;

import java.io.Serializable;

public class VehicleTypeVO implements Serializable {
    private Integer id;
    private String name;
    private float minimumWeight;
    private float maximumWeight;

    public VehicleTypeVO() {
    }

    public VehicleTypeVO(TypeOfVehicleEntity entity) {
        if (entity != null) {
            id = entity.getId();
            name = entity.getName();
            minimumWeight = entity.getMinimumWeight();
            maximumWeight = entity.getMaximumWeight();
        }
    }

    public TypeOfVehicleEntity createEntity() {
        TypeOfVehicleEntity typeOfVehicleEntity = new TypeOfVehicleEntity();
        typeOfVehicleEntity.setId(id);
        typeOfVehicleEntity.setName(name);
        typeOfVehicleEntity.setMaximumWeight(maximumWeight);
        typeOfVehicleEntity.setMinimumWeight(minimumWeight);
        return typeOfVehicleEntity;
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

    public float getMinimumWeight() {
        return minimumWeight;
    }

    public void setMinimumWeight(float minimumWeight) {
        this.minimumWeight = minimumWeight;
    }

    public float getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(float maximumWeight) {
        this.maximumWeight = maximumWeight;
    }
}
