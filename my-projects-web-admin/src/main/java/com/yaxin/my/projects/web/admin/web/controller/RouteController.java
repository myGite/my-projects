package com.yaxin.my.projects.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/route")
public class RouteController {
    private static final Map<String, String> ROUTE_MAP = new HashMap<>();
    static{
        ROUTE_MAP.put("login","login");
        ROUTE_MAP.put("main", "main");
        ROUTE_MAP.put("register","register");
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        String page = request.getParameter("page");
        return ROUTE_MAP.get(page);
    }
}
