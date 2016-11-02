/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testingapi_s.api_testing_db.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

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

import com.testingapi_s.api_testing_db.Departments;
import com.testingapi_s.api_testing_db.Employee;


/**
 * ServiceImpl object for domain model class Departments.
 *
 * @see Departments
 */
@Service("API_TESTING_DB.DepartmentsService")
public class DepartmentsServiceImpl implements DepartmentsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentsServiceImpl.class);

    @Autowired
	@Qualifier("API_TESTING_DB.EmployeeService")
	private EmployeeService employeeService;

    @Autowired
    @Qualifier("API_TESTING_DB.DepartmentsDao")
    private WMGenericDao<Departments, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Departments, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "API_TESTING_DBTransactionManager")
    @Override
	public Departments create(Departments departments) {
        LOGGER.debug("Creating a new Departments with information: {}", departments);
        Departments departmentsCreated = this.wmGenericDao.create(departments);
        if(departmentsCreated.getEmployee() != null) {
            Employee employee = departmentsCreated.getEmployee();
            LOGGER.debug("Creating a new child Employee with information: {}", employee);
            employee.setDepartments(departmentsCreated);
            employeeService.create(employee);
        }
        return departmentsCreated;
    }

	@Transactional(readOnly = true, value = "API_TESTING_DBTransactionManager")
	@Override
	public Departments getById(Integer departmentsId) throws EntityNotFoundException {
        LOGGER.debug("Finding Departments by id: {}", departmentsId);
        Departments departments = this.wmGenericDao.findById(departmentsId);
        if (departments == null){
            LOGGER.debug("No Departments found with id: {}", departmentsId);
            throw new EntityNotFoundException(String.valueOf(departmentsId));
        }
        return departments;
    }

    @Transactional(readOnly = true, value = "API_TESTING_DBTransactionManager")
	@Override
	public Departments findById(Integer departmentsId) {
        LOGGER.debug("Finding Departments by id: {}", departmentsId);
        return this.wmGenericDao.findById(departmentsId);
    }

    @Transactional(readOnly = true, value = "API_TESTING_DBTransactionManager")
    @Override
    public Departments getByDeptCode(String deptCode) {
        Map<String, Object> deptCodeMap = new HashMap<>();
        deptCodeMap.put("deptCode", deptCode);

        LOGGER.debug("Finding Departments by unique keys: {}", deptCodeMap);
        Departments departments = this.wmGenericDao.findByUniqueKey(deptCodeMap);

        if (departments == null){
            LOGGER.debug("No Departments found with given unique key values: {}", deptCodeMap);
            throw new EntityNotFoundException(String.valueOf(deptCodeMap));
        }

        return departments;
    }

	@Transactional(rollbackFor = EntityNotFoundException.class, value = "API_TESTING_DBTransactionManager")
	@Override
	public Departments update(Departments departments) throws EntityNotFoundException {
        LOGGER.debug("Updating Departments with information: {}", departments);
        this.wmGenericDao.update(departments);

        Integer departmentsId = departments.getDeptId();

        return this.wmGenericDao.findById(departmentsId);
    }

    @Transactional(value = "API_TESTING_DBTransactionManager")
	@Override
	public Departments delete(Integer departmentsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting Departments with id: {}", departmentsId);
        Departments deleted = this.wmGenericDao.findById(departmentsId);
        if (deleted == null) {
            LOGGER.debug("No Departments found with id: {}", departmentsId);
            throw new EntityNotFoundException(String.valueOf(departmentsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "API_TESTING_DBTransactionManager")
	@Override
	public Page<Departments> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all Departments");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "API_TESTING_DBTransactionManager")
    @Override
    public Page<Departments> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all Departments");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "API_TESTING_DBTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service API_TESTING_DB for table Departments to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "API_TESTING_DBTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeeService instance
	 */
	protected void setEmployeeService(EmployeeService service) {
        this.employeeService = service;
    }

}
