package com.sebas.curso.springboot.app.interceptor.springboot_interceptor.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Component("loadingTimeHandlerInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = ((HandlerMethod) handler);
        logger.info("LoadingTimeInterceptor: preHandle() entering ...." + handlerMethod.getMethod().getName());
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);

//        Map<String, String> jsonMap = new HashMap<>();
//        jsonMap.put("error", "You do not have access to this resource");
//        jsonMap.put("date", LocalDateTime.now().toString());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = objectMapper.writeValueAsString(jsonMap);
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        response.getWriter().write(jsonString);
//        return false;

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = ((HandlerMethod) handler);
        long start = (long) request.getAttribute("start");
        long end = System.currentTimeMillis();
        long result = end - start;
        logger.info("Elapse time: " + result + " miliseconds");
        logger.info("LoadingTimeInterceptor: postHandle() going out ...." + handlerMethod.getMethod().getName());
    }
}
