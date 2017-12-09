package com.komarmoss.service;

import com.komarmoss.model.dao.VehicleDAO;
import com.komarmoss.model.entity.VehicleEntity;
import com.komarmoss.model.vo.VehicleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final VehicleDAO vehicleDAO;

    @Autowired
    public VehicleServiceImpl(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    public List<VehicleVO> findVehicles() {
        return vehicleDAO.getAllItems()
                .parallelStream()
                .map(VehicleVO::new)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleVO findVehicle(Integer id) {
        return new VehicleVO(vehicleDAO.getItemById(id));
    }

    @Override
    public Integer saveOrUpdateVehicle(VehicleVO vehicle) {
        VehicleEntity ownerEntity = vehicle.createEntity();
        vehicleDAO.saveOrUpdateItem(ownerEntity);
        return ownerEntity.getId();
    }

    @Override
    public boolean removeVehicle(Integer id) {
        if (id != null) {
            vehicleDAO.removeItemById(id);
            return true;
        }
        return false;
    }

}
