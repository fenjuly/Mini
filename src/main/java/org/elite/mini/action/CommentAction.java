package org.elite.mini.action;

import org.elite.mini.bean.Comment;
import org.elite.mini.common.Response;
import org.elite.mini.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenjuly
 * Date: 15/7/23
 * Time: 下午10:01
 */
@Controller
public class CommentAction {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value="/api/comment",method= RequestMethod.POST)
    public Object add(HttpServletRequest request, @RequestBody Comment comment) {
        int status;
        status = commentService.add(comment);
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value="/api/comment",method= RequestMethod.PATCH)
    public Object update(HttpServletRequest request, @RequestBody Comment comment) {
        int status;
        status = commentService.update(comment);
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value = "/api/comment/{id}", method = RequestMethod.DELETE)
    public Object delete(HttpServletRequest request, @PathVariable int id){
        int status;
        Comment comment = new Comment();
        comment.setId(id);
        status = commentService.delete(comment);
        return new Response(status);
    }
}
