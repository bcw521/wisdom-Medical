package com.example.wisdommedical.interceptors;

import com.example.wisdommedical.common.Result;
import com.example.wisdommedical.utils.JWTUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class JWTinterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        String token = request.getHeader("token");
        Result result = JWTUtil.verifyToken(token);
        if (result.isSuccess()){
            return true;
        }else {
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(String.valueOf(result));
            return false;
        }
    }
}
