package org.elite.mini.action;

import org.elite.mini.bean.Comment;
import org.elite.mini.bean.Relation;
import org.elite.mini.common.Response;
import org.elite.mini.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenjuly
 * Date: 15/7/24
 * Time: 上午9:42
 */
@Controller
public class RelationAction {

    @Autowired
    private RelationService relationService;

    @ResponseBody
    @RequestMapping(value="/api/relation",method= RequestMethod.POST)
    public Object add(HttpServletRequest request, @RequestBody Relation relation) {
        int status;
        status = relationService.add(relation);
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value="/api/relation",method= RequestMethod.PATCH)
    public Object update(HttpServletRequest request, @RequestBody Relation relation) {
        int status;
        status = relationService.update(relation);
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value = "/api/relation/{id}", method = RequestMethod.DELETE)
    public Object delete(HttpServletRequest request, @PathVariable int id){
        int status;
        Relation relation = new Relation();
        relation.setId(id);
        status = relationService.delete(relation);
        return new Response(status);
    }
}
