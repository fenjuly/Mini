package org.elite.mini.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elite.mini.bean.Microblog;
import org.elite.mini.common.QueryBase;
import org.elite.mini.common.Status;
import org.elite.mini.mapper.MicroblogMapper;
import org.elite.mini.service.MicroblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fenjuly
 * Date: 15/7/24
 * Time: 上午9:24
 */
@Service
public class MicroblogServiceImpl implements MicroblogService {

    private Log logger = LogFactory.getLog(MicroblogServiceImpl.class);

    @Autowired
    private MicroblogMapper microblogMapper;

    @Override
    public int add(Microblog microblog) {
        if (microblogMapper.insert(microblog) > 0) {
            logger.debug("添加微博成功");
            return Status.SUCCESS;
        }
        return Status.ERROR;
    }

    @Override
    public int update(Microblog microblog) {
        Microblog m = microblogMapper.selectByPrimaryKey(microblog.getId());
        if (m == null) {
            logger.warn("尝试更新微博，但是不存在");
            return Status.NOT_EXISTS;
        }
        microblogMapper.updateByPrimaryKeySelective(microblog);
        logger.debug("修改微博成功");
        return Status.SUCCESS;
    }

    @Override
    public int delete(Microblog microblog) {
        Microblog m = microblogMapper.selectByPrimaryKey(microblog.getId());
        if (m == null) {
            logger.warn("尝试删除微博，但是不存在");
            return Status.NOT_EXISTS;
        }
        microblogMapper.deleteByPrimaryKey(microblog.getId());
        logger.debug("删除微博成功");
        return Status.SUCCESS;
    }

    @Override
    public Microblog get(int id) {
        Microblog microblog = microblogMapper.selectByPrimaryKey(id);
        if (microblog == null) {
            logger.warn("微博ID:" + id + " 不存在");
        } else {
            logger.debug("微博 ID:" + id + " 成功");
        }
        return microblog;
    }

    @Override
    public void query(QueryBase queryBase) {

    }
}
