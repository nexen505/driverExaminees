package com.komarmoss.controllers;

import com.komarmoss.model.vo.VehicleVO;
import com.komarmoss.model.vo.WebResponseVO;
import com.komarmoss.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public WebResponseVO findOwner(@RequestParam(name = "id", required = false) Integer id) {
        return new WebResponseVO(id != null ? vehicleService.findVehicle(id) : vehicleService.findVehicles());
    }

    @RequestMapping(value = "/vehicles", method = {RequestMethod.POST, RequestMethod.PUT})
    public WebResponseVO saveOrUpdateOwner(@RequestBody VehicleVO vehicleVO) {
        return new WebResponseVO(vehicleService.saveOrUpdateVehicle(vehicleVO));
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.DELETE)
    public WebResponseVO removeOwner(@RequestParam(name = "id") Integer id) {
        return new WebResponseVO(vehicleService.removeVehicle(id));
    }
}
