package com.komarmoss.service;

import com.komarmoss.model.dao.OwnerDAO;
import com.komarmoss.model.dao.TypeOfVehicleDAO;
import com.komarmoss.model.dao.VehicleDAO;
import com.komarmoss.model.entity.VehicleEntity;
import com.komarmoss.model.vo.TypeOfVehicleVO;
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
    private final TypeOfVehicleDAO typeOfVehicleDAO;
    private final OwnerDAO ownerDAO;

    @Autowired
    public VehicleServiceImpl(VehicleDAO vehicleDAO, TypeOfVehicleDAO typeOfVehicleDAO, OwnerDAO ownerDAO) {
        this.vehicleDAO = vehicleDAO;
        this.typeOfVehicleDAO = typeOfVehicleDAO;
        this.ownerDAO = ownerDAO;
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
    public VehicleVO saveOrUpdateVehicle(VehicleVO vehicle) {
        VehicleEntity vehicleEntity = vehicle.createEntity();
        /*TypeOfVehicleEntity typeOfVehicleEntity = typeOfVehicleDAO.getItemById(vehicleEntity.getType().getId());
        vehicleEntity.setType(typeOfVehicleEntity);
        OwnerEntity ownerEntity = ownerDAO.getItemById(vehicleEntity.getOwner().getId());
        vehicleEntity.setOwner(ownerEntity);
        */
        vehicleDAO.saveOrUpdateItem(vehicleEntity);
        return findVehicle(vehicleEntity.getId());
    }

    @Override
    public boolean removeVehicle(Integer id) {
        if (id != null) {
            vehicleDAO.removeItemById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TypeOfVehicleVO> getTypesOfVehicles() {
        return typeOfVehicleDAO.getAllItems()
                .parallelStream()
                .map(TypeOfVehicleVO::new)
                .collect(Collectors.toList());
    }

}
