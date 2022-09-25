package com.athy.config;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1.配置好拦截器拦截那些请求
 * 2.把拦截器配置在容器中
 */

public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 进入目标方法之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("在进入handler之前拦截，做登录校验");

        Object attribute = request.getSession().getAttribute("loginUser");
        if(null != attribute){
            //放行
            return true;
        }
        System.out.println("没登录，请求被拦截!");
        //重定向到登录页
        request.setAttribute("msg","未登录请先登录。");
        request.getRequestDispatcher("/login/loginHTML").forward(request,response);
        //request.getSession().setAttribute("msg","请先登录！");
        //response.sendRedirect("/dubbo/login/");
        return false;
    }

    /**
     *目标方法执行之后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 最后执行
     * 如果所有拦截器都执行成功的话  会倒叙执行所有拦截器的afterCompletion()
     * 如果有一个拦截器执行失败  会调用之前执行成功的拦截器的afterCompletion()
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
