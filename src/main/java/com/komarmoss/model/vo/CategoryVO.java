package com.komarmoss.model.vo;

import com.komarmoss.model.entity.CategoryEntity;
import com.komarmoss.model.entity.TypeOfVehicleEntity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CategoryVO implements Serializable {
    private Integer id;
    private String name;
    private List<VehicleTypeVO> types = Collections.emptyList();

    public CategoryVO() {
    }

    public CategoryVO(CategoryEntity entity) {
        if (entity != null) {
            id = entity.getId();
            name = entity.getName();
            List<TypeOfVehicleEntity> entityTypes = entity.getTypes();
            if (entityTypes != null)
                types = entityTypes.stream().map(VehicleTypeVO::new).filter(Objects::nonNull).collect(Collectors.toList());
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

    public List<VehicleTypeVO> getTypes() {
        return types;
    }

    public void setTypes(List<VehicleTypeVO> types) {
        this.types = types;
    }
}
