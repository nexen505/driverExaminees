package com.komarmoss.controllers;

import com.komarmoss.model.vo.OwnerVO;
import com.komarmoss.model.vo.WebResponseVO;
import com.komarmoss.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(value = "/owners", method = RequestMethod.GET)
    public WebResponseVO findOwner(@RequestParam(name = "id", required = false) Integer id) {
        return id != null ?
                new WebResponseVO(ownerService.findOwner(id)) :
                new WebResponseVO(ownerService.findOwners());
    }

    @RequestMapping(value = "/owners", method = {RequestMethod.POST, RequestMethod.PUT})
    public WebResponseVO saveOrUpdateOwner(@RequestBody OwnerVO owner) {
        return new WebResponseVO(ownerService.saveOrUpdateOwner(owner));
    }

    @RequestMapping(value = "/owners", method = RequestMethod.DELETE)
    public WebResponseVO removeOwner(@RequestParam(name = "id") Integer id) {
        return new WebResponseVO(ownerService.removeOwner(id));
    }
}
