package com.komarmoss.service;

import com.komarmoss.model.dao.OwnerDAO;
import com.komarmoss.model.entity.OwnerEntity;
import com.komarmoss.model.vo.OwnerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

    private final OwnerDAO ownerDAO;

    @Autowired
    public OwnerServiceImpl(OwnerDAO ownerDAO) {
        this.ownerDAO = ownerDAO;
    }

    @Override
    public List<OwnerVO> findOwners() {
        return ownerDAO.getAllItems().stream().map(OwnerVO::new).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public OwnerVO findOwner(Integer id) {
        return new OwnerVO(ownerDAO.getItemById(id));
    }

    @Override
    public Integer saveOrUpdateOwner(OwnerVO owner) {
        OwnerEntity ownerEntity = owner.createEntity();
        ownerDAO.saveOrUpdateItem(ownerEntity);
        return ownerEntity.getId();
    }

    @Override
    public boolean removeOwner(Integer id) {
        if (id != null) {
            ownerDAO.removeItemById(id);
            return true;
        }
        return false;
    }
}
