package com.touchkiss.catelogueoflife.species.services;

import com.github.pagehelper.Page;
import com.touchkiss.catelogueoflife.species.bean.SpeciesRecordScrutiny;
import java.util.Map;
import java.util.List;

/**
 * Created on 2020-03-20 17:31:57
 *
 * @author Touchkiss
 */
public interface SpeciesRecordScrutinyDaoService {
	boolean insert(SpeciesRecordScrutiny speciesRecordScrutiny);

	boolean deleteById(Integer id);

    int deleteByMap(Map<String, String> wheres);

    boolean updateById(SpeciesRecordScrutiny speciesRecordScrutiny, Integer id);

    boolean updateSelectiveById(SpeciesRecordScrutiny speciesRecordScrutiny, Integer id);

    int updateSelectiveByMap(SpeciesRecordScrutiny speciesRecordScrutiny, Map<String, String> wheres);

	SpeciesRecordScrutiny selectById(Integer id);

	List<SpeciesRecordScrutiny> querySpeciesRecordScrutinyList(Map<String, String> map);

	Page<SpeciesRecordScrutiny> findByPage(int pageNo, int pageSize, Map<String, String> map);
}
