package com.yaxin.my.projects.web.admin.web.controller;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class BathController {
    protected void writeJSON(Object obj, Object code, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            Map<String, Object> result = new HashMap<>();
            result.put("code", code);
            result.put("data", obj);
            out.write(JSONObject.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeDataJSON(Object obj, HttpServletResponse response){
        this.writeJSON(obj, 1, response);
    }

    protected void writeMessage(String message, Object code, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            Map<String, Object> result = new HashMap<>();
            result.put("code", code);
            result.put("message", message);
            out.write(JSONObject.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
