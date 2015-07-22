package org.elite.mini.mapper;

import org.elite.mini.bean.GraduateDestination;

public interface GraduateDestinationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GraduateDestination record);

    int insertSelective(GraduateDestination record);

    GraduateDestination selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GraduateDestination record);

    int updateByPrimaryKey(GraduateDestination record);
}