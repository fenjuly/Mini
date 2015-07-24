package org.elite.mini.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elite.mini.bean.GraduateDestination;
import org.elite.mini.common.QueryBase;
import org.elite.mini.common.Status;
import org.elite.mini.mapper.GraduateDestinationMapper;
import org.elite.mini.service.GraduateDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fenjuly
 * Date: 15/7/23
 * Time: 上午10:10
 */
@Service
public class GratuateDestinationServiceImpl implements GraduateDestinationService{

    private Log logger = LogFactory.getLog(GratuateDestinationServiceImpl.class);

    @Autowired
    private GraduateDestinationMapper graduateDestinationMapper;

    @Override
    public int add(GraduateDestination graduateDestination) {
        if (graduateDestinationMapper.insert(graduateDestination) > 0) {
            logger.debug("添加大学生毕业去向成功");
            return Status.SUCCESS;
        }
        return Status.ERROR;
    }

    @Override
    public int update(GraduateDestination graduateDestination) {
        GraduateDestination g = graduateDestinationMapper.selectByPrimaryKey(graduateDestination.getId());
        if (g == null) {
            logger.warn("尝试更新大学生毕业去向，但是不存在");
            return Status.NOT_EXISTS;
        }
        graduateDestinationMapper.updateByPrimaryKeySelective(graduateDestination);
        logger.debug("修改毕业去向成功");
        return Status.SUCCESS;
    }

    @Override
    public int delete(GraduateDestination graduateDestination) {
        GraduateDestination g = graduateDestinationMapper.selectByPrimaryKey(graduateDestination.getId());
        if (g == null) {
            logger.warn("尝试删除大学生毕业去向，但是不存在");
            return Status.NOT_EXISTS;
        }
        graduateDestinationMapper.deleteByPrimaryKey(graduateDestination.getId());
        logger.debug("删除大学生毕业去向成功");
        return Status.SUCCESS;
    }

    @Override
    public GraduateDestination get(int id) {
        GraduateDestination graduateDestination = graduateDestinationMapper.selectByPrimaryKey(id);
        if (graduateDestination == null) {
            logger.warn("大学生毕业去向 ID:" + id + " 不存在");
        } else {
            logger.debug("毕业去向 ID:" + id + " 成功");
        }
        return graduateDestination;
    }

    @Override
    public void query(QueryBase queryBase) {

    }
}
