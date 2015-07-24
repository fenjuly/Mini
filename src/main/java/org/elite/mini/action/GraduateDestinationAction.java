package org.elite.mini.action;

import org.elite.mini.bean.GraduateDestination;
import org.elite.mini.common.Response;
import org.elite.mini.service.GraduateDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenjuly
 * Date: 15/7/23
 * Time: 下午8:52
 */
@Controller
public class GraduateDestinationAction {

    @Autowired
    private GraduateDestinationService graduateDestinationService;

    @ResponseBody
    @RequestMapping(value="/api/graduatedestination",method= RequestMethod.POST)
    public Object add(HttpServletRequest request, @RequestBody GraduateDestination graduateDestination) {
        int status;
        status = graduateDestinationService.add(graduateDestination);
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value="/api/graduatedestination",method= RequestMethod.PATCH)
    public Object update(HttpServletRequest request, @RequestBody GraduateDestination graduateDestination) {
        int status;
        status = graduateDestinationService.update(graduateDestination);
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value = "/api/graduatedestination/{id}", method = RequestMethod.DELETE)
    public Object delete(HttpServletRequest request, @PathVariable int id){
        int status;
        GraduateDestination graduateDestination = new GraduateDestination();
        graduateDestination.setId(id);
        status = graduateDestinationService.delete(graduateDestination);
        return new Response(status);
    }
}
