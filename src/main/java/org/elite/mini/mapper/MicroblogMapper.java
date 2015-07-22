package org.elite.mini.mapper;

import org.elite.mini.bean.Microblog;

public interface MicroblogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Microblog record);

    int insertSelective(Microblog record);

    Microblog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Microblog record);

    int updateByPrimaryKey(Microblog record);
}