package com.komarmoss.model.vo;

import com.komarmoss.model.entity.CategoryEntity;
import com.komarmoss.model.entity.LicenseOfDriverEntity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LicenseOfDriverVO implements Serializable {
    private Integer id;
    private String series;
    private Date dateOfIssue;
    private List<CategoryVO> categories = Collections.emptyList();

    public LicenseOfDriverVO() {
    }

    public LicenseOfDriverVO(LicenseOfDriverEntity entity) {
        if (entity != null) {
            id = entity.getId();
            series = entity.getSeries();
            dateOfIssue = entity.getDateOfIssue();
            List<CategoryEntity> categories = entity.getCategories();
            if (categories != null)
                this.categories = categories.stream().map(CategoryVO::new).filter(Objects::nonNull).collect(Collectors.toList());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public List<CategoryVO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryVO> categories) {
        this.categories = categories;
    }
}
