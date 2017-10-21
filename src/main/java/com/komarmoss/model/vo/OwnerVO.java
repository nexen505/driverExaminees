package com.komarmoss.model.vo;

import com.komarmoss.model.entity.LicenseOfDriverEntity;
import com.komarmoss.model.entity.OwnerEntity;
import com.komarmoss.model.entity.VehicleEntity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OwnerVO implements Serializable {

    private Integer id;
    private String name;
    private String patronymic;
    private String surname;
    private Date dateOfBirth;
    private List<VehicleVO> vehicles = Collections.emptyList();
    private LicenseOfDriverVO license;

    public OwnerVO() {
    }

    public OwnerVO(OwnerEntity entity) {
        if (entity != null) {
            id = entity.getId();
            name = entity.getName();
            patronymic = entity.getPatronymic();
            surname = entity.getSurname();
            dateOfBirth = entity.getDateOfBirth();

            List<VehicleEntity> transportList = entity.getTransportList();
            if (transportList != null)
                vehicles = transportList.stream().map(VehicleVO::new).filter(Objects::nonNull).collect(Collectors.toList());

            LicenseOfDriverEntity entityLicense = entity.getLicense();
            if (entityLicense != null)
                this.license = new LicenseOfDriverVO(entityLicense);
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<VehicleVO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleVO> vehicles) {
        this.vehicles = vehicles;
    }

    public LicenseOfDriverVO getLicense() {
        return license;
    }

    public void setLicense(LicenseOfDriverVO license) {
        this.license = license;
    }
}
