package org.elite.mini.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elite.mini.bean.Comment;
import org.elite.mini.common.QueryBase;
import org.elite.mini.common.Status;
import org.elite.mini.mapper.CommentMapper;
import org.elite.mini.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fenjuly
 * Date: 15/7/23
 * Time: 下午9:52
 */
@Service
public class CommentServiceImpl implements CommentService {

    private Log logger = LogFactory.getLog(CommentServiceImpl.class);

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int add(Comment comment) {
        if (commentMapper.insert(comment) > 0) {
            logger.debug("添加评论去向成功");
            return Status.SUCCESS;
        }
        return Status.ERROR;
    }

    @Override
    public int update(Comment comment) {
        Comment c = commentMapper.selectByPrimaryKey(comment.getId());
        if (c == null) {
            logger.warn("尝试更新评论，但是不存在");
            return Status.NOT_EXISTS;
        }
        commentMapper.updateByPrimaryKeySelective(comment);
        logger.debug("修改评论成功");
        return Status.SUCCESS;
    }

    @Override
    public int delete(Comment comment) {
        Comment c = commentMapper.selectByPrimaryKey(comment.getId());
        if (c == null) {
            logger.warn("尝试删除评论，但是不存在");
            return Status.NOT_EXISTS;
        }
        commentMapper.deleteByPrimaryKey(comment.getId());
        logger.debug("删除评论成功");
        return Status.SUCCESS;
    }

    @Override
    public Comment get(int id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment == null) {
            logger.warn("评论 ID:" + id + " 不存在");
        } else {
            logger.debug("评论 ID:" + id + " 成功");
        }
        return comment;
    }

    @Override
    public void query(QueryBase queryBase) {

    }
}
