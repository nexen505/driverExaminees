package com.komarmoss.service;

import com.komarmoss.model.vo.VehicleVO;

import java.util.List;

public interface VehicleService {

    List<VehicleVO> findVehicles();

    VehicleVO findVehicle(Integer id);

    Integer saveOrUpdateVehicle(VehicleVO owner);

    boolean removeVehicle(Integer id);

}
