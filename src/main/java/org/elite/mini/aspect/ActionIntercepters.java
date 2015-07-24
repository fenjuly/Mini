package org.elite.mini.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.elite.mini.bean.Student;
import org.elite.mini.common.Response;
import org.elite.mini.mapper.StudentMapper;
import org.elite.mini.utils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by fenjuly
 * Date: 14/11/30
 * Time: 下午9:07
 */
@Aspect
public class ActionIntercepters {

    private Log logger = LogFactory.getLog(ActionIntercepters.class);

    @Resource(name="invalidOperationResponse")
    Response invalidResponse;

    @Autowired
    StudentMapper studentMapper;

    /**
     * 验证是否是合法用户
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("@annotation(org.elite.mini.annotation.StudentLoginAuthorized)")
    public Object checkStudentLoginAuthorized(ProceedingJoinPoint point) throws Throwable{
        try {
            logger.warn("enter method");
            HttpServletRequest request = (HttpServletRequest) point.getArgs()[0];
            String authentication = request.getHeader("Authentication");
            String[] temp = authentication.split("%");
            String studentAccount = temp[0];
            String encryptPassword = EncryptionUtil.encrypt(temp[1]);
            logger.warn(studentAccount + " and "+ temp[1]);

            Student student = studentMapper.selectByAccount(studentAccount);
            if(null != student && student.getPassword().equals(encryptPassword)){
                return point.proceed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return invalidResponse;
    }

}

