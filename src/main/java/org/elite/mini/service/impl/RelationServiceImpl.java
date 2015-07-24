package org.elite.mini.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elite.mini.bean.GraduateDestination;
import org.elite.mini.bean.Relation;
import org.elite.mini.common.QueryBase;
import org.elite.mini.common.Status;
import org.elite.mini.mapper.RelationMapper;
import org.elite.mini.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fenjuly
 * Date: 15/7/24
 * Time: 上午9:36
 */
@Service
public class RelationServiceImpl implements RelationService {

    private Log logger = LogFactory.getLog(RelationServiceImpl.class);

    @Autowired
    private RelationMapper relationMapper;

    @Override
    public int add(Relation relation) {
        if (relationMapper.insert(relation) > 0) {
            logger.debug("添加关系成功");
            return Status.SUCCESS;
        }
        return Status.ERROR;
    }

    @Override
    public int update(Relation relation) {
        Relation r = relationMapper.selectByPrimaryKey(relation.getId());
        if (r == null) {
            logger.warn("尝试更新关系，但是不存在");
            return Status.NOT_EXISTS;
        }
        relationMapper.updateByPrimaryKeySelective(relation);
        logger.debug("修改关系成功");
        return Status.SUCCESS;
    }

    @Override
    public int delete(Relation relation) {
        Relation r = relationMapper.selectByPrimaryKey(relation.getId());
        if (r == null) {
            logger.warn("尝试删除关系，但是不存在");
            return Status.NOT_EXISTS;
        }
        relationMapper.deleteByPrimaryKey(relation.getId());
        logger.debug("删除关系成功");
        return Status.SUCCESS;
    }

    @Override
    public Relation get(int id) {
        Relation relation = relationMapper.selectByPrimaryKey(id);
        if (relation == null) {
            logger.warn("大学生关系 ID:" + id + " 不存在");
        } else {
            logger.debug("关系 ID:" + id + " 成功");
        }
        return relation;
    }

    @Override
    public void query(QueryBase queryBase) {

    }
}
