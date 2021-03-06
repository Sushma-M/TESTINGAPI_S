/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testingapi_s.export1.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testingapi_s.export1.ServerDefTable1;


/**
 * ServiceImpl object for domain model class ServerDefTable1.
 *
 * @see ServerDefTable1
 */
@Service("Export1.ServerDefTable1Service")
public class ServerDefTable1ServiceImpl implements ServerDefTable1Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerDefTable1ServiceImpl.class);


    @Autowired
    @Qualifier("Export1.ServerDefTable1Dao")
    private WMGenericDao<ServerDefTable1, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ServerDefTable1, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "Export1TransactionManager")
    @Override
	public ServerDefTable1 create(ServerDefTable1 serverDefTable1) {
        LOGGER.debug("Creating a new ServerDefTable1 with information: {}", serverDefTable1);
        ServerDefTable1 serverDefTable1Created = this.wmGenericDao.create(serverDefTable1);
        return serverDefTable1Created;
    }

	@Transactional(readOnly = true, value = "Export1TransactionManager")
	@Override
	public ServerDefTable1 getById(Integer serverdeftable1Id) throws EntityNotFoundException {
        LOGGER.debug("Finding ServerDefTable1 by id: {}", serverdeftable1Id);
        ServerDefTable1 serverDefTable1 = this.wmGenericDao.findById(serverdeftable1Id);
        if (serverDefTable1 == null){
            LOGGER.debug("No ServerDefTable1 found with id: {}", serverdeftable1Id);
            throw new EntityNotFoundException(String.valueOf(serverdeftable1Id));
        }
        return serverDefTable1;
    }

    @Transactional(readOnly = true, value = "Export1TransactionManager")
	@Override
	public ServerDefTable1 findById(Integer serverdeftable1Id) {
        LOGGER.debug("Finding ServerDefTable1 by id: {}", serverdeftable1Id);
        return this.wmGenericDao.findById(serverdeftable1Id);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "Export1TransactionManager")
	@Override
	public ServerDefTable1 update(ServerDefTable1 serverDefTable1) throws EntityNotFoundException {
        LOGGER.debug("Updating ServerDefTable1 with information: {}", serverDefTable1);
        this.wmGenericDao.update(serverDefTable1);

        Integer serverdeftable1Id = serverDefTable1.getId();

        return this.wmGenericDao.findById(serverdeftable1Id);
    }

    @Transactional(value = "Export1TransactionManager")
	@Override
	public ServerDefTable1 delete(Integer serverdeftable1Id) throws EntityNotFoundException {
        LOGGER.debug("Deleting ServerDefTable1 with id: {}", serverdeftable1Id);
        ServerDefTable1 deleted = this.wmGenericDao.findById(serverdeftable1Id);
        if (deleted == null) {
            LOGGER.debug("No ServerDefTable1 found with id: {}", serverdeftable1Id);
            throw new EntityNotFoundException(String.valueOf(serverdeftable1Id));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "Export1TransactionManager")
	@Override
	public Page<ServerDefTable1> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ServerDefTable1s");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "Export1TransactionManager")
    @Override
    public Page<ServerDefTable1> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ServerDefTable1s");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "Export1TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service Export1 for table ServerDefTable1 to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "Export1TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }



}

