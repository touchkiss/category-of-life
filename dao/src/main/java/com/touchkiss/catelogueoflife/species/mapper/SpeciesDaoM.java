package com.touchkiss.catelogueoflife.species.mapper;

import com.touchkiss.catelogueoflife.species.bean.Species;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created on 2020-03-20 17:31:57
 *
 * @author Touchkiss
 */
@Mapper
public interface SpeciesDaoM {
	int insert(Species species);

    int deleteById(String id);

    int deleteByMap(@Param("wheres") Map<String, String> wheres);

    int updateById(@Param("species") Species species, @Param("id") String id);

    int updateSelectiveById(@Param("species") Species species, @Param("id") String id);

    int updateSelectiveByMap(@Param("species") Species species, @Param("wheres") Map<String, String> wheres);

    Species selectById(String id);

    List<Species> querySpeciesList(@Param("wheres") Map<String, String> wheres);

	Page<Species> findByPage(@Param("wheres") Map<String, String> wheres);
}
