package com.sebas.curso.springboot.calendar.interceptor.springboot_calendar_interceptor.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Component("calendarInterceptor")
public class CalendarInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private Integer open;
    @Value("${config.calendar.close}")
    private Integer close;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(String.format("Current hour: %d", hour));

        if (hour >= open && hour < close) {
            StringBuilder message = new StringBuilder("Welcome to the customer service scheduled");
            message.append(", we attendance from");
            message.append(open);
            message.append(" hours. ");
            message.append("to ");
            message.append(close);
            message.append(" hours").append(System.lineSeparator());
            message.append("Thanks for you visited us.");

            request.setAttribute("message", message.toString());

            return true;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();

        StringBuilder message = new StringBuilder("Close, out of attendance schedule.").append(System.lineSeparator());
        message.append("Visit us from ").append(open).append("hours").append(" to ").append(close).append("hours.").append(System.lineSeparator());
        message.append("Thank you!.");
        data.put("message", message.toString());
        data.put("date", LocalDateTime.now().toString());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        String jsonResponse = objectMapper.writeValueAsString(data);
        response.getWriter().write(jsonResponse);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
