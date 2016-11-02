/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testingapi_s.export1.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testingapi_s.export1.ServerDefTable1;

/**
 * Service object for domain model class {@link ServerDefTable1}.
 */
public interface ServerDefTable1Service {

    /**
     * Creates a new ServerDefTable1. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on ServerDefTable1 if any.
     *
     * @param serverDefTable1 Details of the ServerDefTable1 to be created; value cannot be null.
     * @return The newly created ServerDefTable1.
     */
	ServerDefTable1 create(ServerDefTable1 serverDefTable1);


	/**
	 * Returns ServerDefTable1 by given id if exists.
	 *
	 * @param serverdeftable1Id The id of the ServerDefTable1 to get; value cannot be null.
	 * @return ServerDefTable1 associated with the given serverdeftable1Id.
     * @throws EntityNotFoundException If no ServerDefTable1 is found.
	 */
	ServerDefTable1 getById(Integer serverdeftable1Id) throws EntityNotFoundException;

    /**
	 * Find and return the ServerDefTable1 by given id if exists, returns null otherwise.
	 *
	 * @param serverdeftable1Id The id of the ServerDefTable1 to get; value cannot be null.
	 * @return ServerDefTable1 associated with the given serverdeftable1Id.
	 */
	ServerDefTable1 findById(Integer serverdeftable1Id);


	/**
	 * Updates the details of an existing ServerDefTable1. It replaces all fields of the existing ServerDefTable1 with the given serverDefTable1.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on ServerDefTable1 if any.
     *
	 * @param serverDefTable1 The details of the ServerDefTable1 to be updated; value cannot be null.
	 * @return The updated ServerDefTable1.
	 * @throws EntityNotFoundException if no ServerDefTable1 is found with given input.
	 */
	ServerDefTable1 update(ServerDefTable1 serverDefTable1) throws EntityNotFoundException;

    /**
	 * Deletes an existing ServerDefTable1 with the given id.
	 *
	 * @param serverdeftable1Id The id of the ServerDefTable1 to be deleted; value cannot be null.
	 * @return The deleted ServerDefTable1.
	 * @throws EntityNotFoundException if no ServerDefTable1 found with the given id.
	 */
	ServerDefTable1 delete(Integer serverdeftable1Id) throws EntityNotFoundException;

	/**
	 * Find all ServerDefTable1s matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ServerDefTable1s.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<ServerDefTable1> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all ServerDefTable1s matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching ServerDefTable1s.
     *
     * @see Pageable
     * @see Page
	 */
    Page<ServerDefTable1> findAll(String query, Pageable pageable);

    /**
	 * Exports all ServerDefTable1s matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ServerDefTable1s in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the ServerDefTable1.
	 */
	long count(String query);


}

