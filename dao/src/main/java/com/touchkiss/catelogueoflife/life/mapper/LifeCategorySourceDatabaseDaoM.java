package com.touchkiss.catelogueoflife.life.mapper;

import com.touchkiss.catelogueoflife.life.bean.LifeCategorySourceDatabase;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created on 2020-03-19 13:41:20
 *
 * @author Touchkiss
 */
@Mapper
public interface LifeCategorySourceDatabaseDaoM {
	int insert(LifeCategorySourceDatabase lifeCategorySourceDatabase);

	int insertWithoutId(LifeCategorySourceDatabase lifeCategorySourceDatabase);

    int deleteById(Integer id);

    int deleteByMap(@Param("wheres") Map<String, String> wheres);

    int updateById(@Param("lifeCategorySourceDatabase") LifeCategorySourceDatabase lifeCategorySourceDatabase, @Param("id") Integer id);

    int updateSelectiveById(@Param("lifeCategorySourceDatabase") LifeCategorySourceDatabase lifeCategorySourceDatabase, @Param("id") Integer id);

    int updateSelectiveByMap(@Param("lifeCategorySourceDatabase") LifeCategorySourceDatabase lifeCategorySourceDatabase, @Param("wheres") Map<String, String> wheres);

    LifeCategorySourceDatabase selectById(Integer id);

    List<LifeCategorySourceDatabase> queryLifeCategorySourceDatabaseList(@Param("wheres") Map<String, String> wheres);

	Page<LifeCategorySourceDatabase> findByPage(@Param("wheres") Map<String, String> wheres);
}
