package com.touchkiss.catelogueoflife.kuaishou.mapper;

import com.touchkiss.catelogueoflife.kuaishou.bean.KsRecVideo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created on 2020-08-26 21:20:44
 *
 * @author Touchkiss
 */
@Mapper
public interface KsRecVideoDaoM {
	int insert(KsRecVideo ksRecVideo);

    int deleteByPhotoId(String photoId);

    int deleteByMap(@Param("wheres") Map<String,String> wheres);

    int updateByPhotoId(@Param("ksRecVideo") KsRecVideo ksRecVideo, @Param("photoId") String photoId);

    int updateSelectiveByPhotoId(@Param("ksRecVideo") KsRecVideo ksRecVideo, @Param("photoId") String photoId);

    int updateSelectiveByMap(@Param("ksRecVideo") KsRecVideo ksRecVideo, @Param("wheres") Map<String,String> wheres);

    KsRecVideo selectByPhotoId(String photoId);

    List<KsRecVideo> queryKsRecVideoList(@Param("wheres") Map<String,String> wheres);

	Page<KsRecVideo> findByPage(@Param("wheres") Map<String, String> wheres);
}
