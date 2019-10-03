package com.test.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangjiang on 2019/9/16.
 */
public class OneInterceptor implements HandlerInterceptor {
    @Override
         public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

               System.out.println("=====================");
                if (true) {
                        // returnErrorResponse(httpServletResponse, LeeJSONResult.errorMsg("被one拦截..."));
                     }

                 System.out.println("被one拦截...");

               return false;
             }
}
