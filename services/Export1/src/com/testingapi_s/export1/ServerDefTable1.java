/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testingapi_s.export1;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * ServerDefTable1 generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ServerDef_Table1`")
public class ServerDefTable1 implements Serializable {

    private Integer id;
    private String id1;
    private Date curDate;
    @Type(type = "DateTime")
    private LocalDateTime curDatetime;
    private Date curTime;
    private Character charCol;
    private String uname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`ID1`", nullable = true, length = 255)
    public String getId1() {
        return this.id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "`CUR_DATE`", nullable = true)
    public Date getCurDate() {
        return this.curDate;
    }

    public void setCurDate(Date curDate) {
        this.curDate = curDate;
    }

    @Column(name = "`CUR_DATETIME`", nullable = true)
    public LocalDateTime getCurDatetime() {
        return this.curDatetime;
    }

    public void setCurDatetime(LocalDateTime curDatetime) {
        this.curDatetime = curDatetime;
    }

    @Temporal(TemporalType.TIME)
    @Column(name = "`CUR_TIME`", nullable = true)
    public Date getCurTime() {
        return this.curTime;
    }

    public void setCurTime(Date curTime) {
        this.curTime = curTime;
    }

    @Column(name = "`CHAR COL`", nullable = true, length = 1)
    public Character getCharCol() {
        return this.charCol;
    }

    public void setCharCol(Character charCol) {
        this.charCol = charCol;
    }

    @Column(name = "`U_NAME`", nullable = true, length = 255)
    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServerDefTable1)) return false;
        final ServerDefTable1 serverDefTable1 = (ServerDefTable1) o;
        return Objects.equals(getId(), serverDefTable1.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
