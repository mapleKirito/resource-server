package com.maple.resourceserver.base;
/***
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *          佛祖保佑             永无BUG
 */

import com.maple.resourceserver.utils.GsonUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 那条蠢鱼
 * @Date: 2020/8/22 19:24
 * @Description: # 描述
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_MESSAGE = "系统内部错误，请联系管理员！";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView ExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {

        String header = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equalsIgnoreCase(header)){
            Map<String,Object> error = new HashMap<>();
            error.put("code", 1);
//            error.put("message", ERROR_MESSAGE);
            error.put("message", e.getMessage());
            writeJson(response,error);
            return null;
        }else {
            ModelAndView mv = new ModelAndView("error/500");
//            mv.addObject("message", ERROR_MESSAGE);
            mv.addObject("message", e.getMessage());
            return mv;
        }

    }

    protected void writeJson(HttpServletResponse response, Map<String,Object> error){

        try {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(GsonUtil.GsonString(error));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}