package com.test.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.test.pojo.Cost;

public interface ICostDao {

	/**
	 * 查询所有数据
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<Cost> findAll() throws DataAccessException;

	/**
	 * 查询某页数据
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DataAccessException
	 */
	List<Cost> findByPage(int page, int pageSize) throws DataAccessException;

	/**
	 * 查询页数
	 * 
	 * @param pageSize
	 *            每页条数
	 * @return
	 * @throws DataAccessException
	 */
	int findTotalPage(int pageSize) throws DataAccessException;

	/**
	 * 删除数据
	 * 
	 * @param id
	 * @throws DataAccessException
	 */
	void deleteById(Integer id) throws DataAccessException;

	/**
	 * 根据名称查询资费数据
	 * 
	 * @param feeName
	 * @return
	 * @throws DataAccessException
	 */
	Cost findByName(String feeName) throws DataAccessException;

	/**
	 * 根据id查询资费数据
	 * 
	 * @param id
	 * @return
	 * @throws DataAccessException
	 */
	Cost findById(Integer id) throws DataAccessException;

	/**
	 * 根据传入的cost对象，更新数据库
	 * 
	 * @param cost
	 * @throws DataAccessException
	 */
	void updateCost(Cost cost) throws DataAccessException;
}
