package com.touchkiss.catelogueoflife.species.services;

import com.github.pagehelper.Page;
import com.touchkiss.catelogueoflife.species.bean.SpeciesReferences;
import java.util.Map;
import java.util.List;

/**
 * Created on 2020-03-20 17:31:57
 *
 * @author Touchkiss
 */
public interface SpeciesReferencesDaoService {
	boolean insert(SpeciesReferences speciesReferences);

	boolean deleteById(Integer id);

    int deleteByMap(Map<String, String> wheres);

    boolean updateById(SpeciesReferences speciesReferences, Integer id);

    boolean updateSelectiveById(SpeciesReferences speciesReferences, Integer id);

    int updateSelectiveByMap(SpeciesReferences speciesReferences, Map<String, String> wheres);

	SpeciesReferences selectById(Integer id);

	List<SpeciesReferences> querySpeciesReferencesList(Map<String, String> map);

	Page<SpeciesReferences> findByPage(int pageNo, int pageSize, Map<String, String> map);
}
