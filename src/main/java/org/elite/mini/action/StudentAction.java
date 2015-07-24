package org.elite.mini.action;

import org.elite.mini.bean.Student;
import org.elite.mini.common.Response;
import org.elite.mini.common.Status;
import org.elite.mini.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenjuly
 * Date: 15/7/23
 * Time: 上午12:26
 */
@Controller
public class StudentAction {

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(value="/api/student",method= RequestMethod.POST)
    public Object add(@RequestBody Student student) {
        int status;
            status = studentService.add(student);
        if (status == Status.SUCCESS) {
            return new Response(status, student.getId());
        }
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value="/api/student",method= RequestMethod.PATCH)
    public Object update(HttpServletRequest request, @RequestBody Student student) {
        int status;
        status = studentService.update(student);
        return new Response(status);
    }

    @ResponseBody
    @RequestMapping(value = "/api/student/{id}", method = RequestMethod.DELETE)
    public Object delete(HttpServletRequest request, @PathVariable int id){
        int status;
        Student student = new Student();
        student.setId(id);
        status = studentService.delete(student);
        return new Response(status);
    }
}
