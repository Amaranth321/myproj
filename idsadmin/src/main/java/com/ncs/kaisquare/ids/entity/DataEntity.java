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
    private Date lastUpdateDate;

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

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void preSave(){
        if(StringUtils.isEmpty(this.id)){
            this.id = String.valueOf(SnowFlake.nextId());
            this.createDate = new Date();
            this.lastUpdateDate = new Date();
        }else{
            this.lastUpdateDate = new Date();
        }

    }
}
