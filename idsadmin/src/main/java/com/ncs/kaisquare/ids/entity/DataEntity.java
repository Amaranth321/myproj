package com.ncs.kaisquare.ids.entity;

import com.ncs.kaisquare.ids.utils.SnowFlake;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

public class DataEntity implements Serializable{
    @Id
    @Indexed
    private String id;
    private Date createDate;
    private String createBy;
    private Date lastUpdateDate;
    private String lastUpdateBy;

    public DataEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    protected void preSave(){
        if(StringUtils.isEmpty(this.id)){
            this.id = String.valueOf(SnowFlake.nextId());
        }
    }
}
