package org.elite.mini.action;

import org.elite.mini.bean.Comment;
import org.elite.mini.bean.Microblog;
import org.elite.mini.common.Response;
import org.elite.mini.service.MicroblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenjuly
 * Date: 15/7/24
 * Time: 上午9:31
 */
@Controller
public class MicroblogAction {

    @Autowired
    private MicroblogService microblogService;

    @ResponseBody
    @RequestMapping(value="/api/microblog",method= RequestMethod.POST)
    public Object add(HttpServletRequest request, @RequestBody Microblog microblog) {
        int status;
        status = microblogService.add(microblog);
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value="/api/microblog",method= RequestMethod.PATCH)
    public Object update(HttpServletRequest request, @RequestBody Microblog microblog) {
        int status;
        status = microblogService.update(microblog);
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value = "/api/microblog/{id}", method = RequestMethod.DELETE)
    public Object delete(HttpServletRequest request, @PathVariable int id){
        int status;
        Microblog microblog = new Microblog();
        microblog.setId(id);
        status = microblogService.delete(microblog);
        return new Response(status);
    }
}
