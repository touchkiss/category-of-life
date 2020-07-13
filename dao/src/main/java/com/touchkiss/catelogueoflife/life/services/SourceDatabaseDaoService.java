package com.touchkiss.catelogueoflife.life.services;

import com.github.pagehelper.Page;
import com.touchkiss.catelogueoflife.life.bean.SourceDatabase;
import java.util.Map;
import java.util.List;

/**
 * Created on 2020-03-19 13:41:20
 *
 * @author Touchkiss
 */
public interface SourceDatabaseDaoService {
	boolean insert(SourceDatabase sourceDatabase);

	boolean deleteById(Integer id);

    int deleteByMap(Map<String, String> wheres);

    boolean updateById(SourceDatabase sourceDatabase, Integer id);

    boolean updateSelectiveById(SourceDatabase sourceDatabase, Integer id);

    int updateSelectiveByMap(SourceDatabase sourceDatabase, Map<String, String> wheres);

	SourceDatabase selectById(Integer id);

	List<SourceDatabase> querySourceDatabaseList(Map<String, String> map);

	Page<SourceDatabase> findByPage(int pageNo, int pageSize, Map<String, String> map);
}
