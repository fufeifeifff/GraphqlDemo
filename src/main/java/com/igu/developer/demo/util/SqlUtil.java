package com.igu.developer.demo.util;


import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
/**
* @Author:fffu
* @Description:sql功能工具类
* @Date:2018/10/25 10:41
*/

public class SqlUtil {

    public static String orderByHql(HttpServletRequest request, String aliasName) {
        // For sortable
        String sortOrder = request.getParameter("order[0][column]");
        String sortDir = request.getParameter("order[0][dir]");
        String sortColumnName = request.getParameter("columns[" + sortOrder + "][data]");

        return "convert(" + (StringUtils.length(aliasName) > 0 ? (aliasName + ".") : "") + sortColumnName + ", gbk) " + sortDir;
    }



    public static String orderByHql(HttpServletRequest request) {
        // For sortable
        String sortOrder = request.getParameter("order[0][column]");
        String sortDir = request.getParameter("order[0][dir]");
        String sortColumnName = request.getParameter("columns[" + sortOrder + "][name]");
        if (StringUtils.isNotBlank(sortColumnName)) {
            return "convert(" + sortColumnName.replaceAll("::", ".") + ", gbk) " + sortDir;
        } else {
            String sortColumnDate = request.getParameter("columns[" + sortOrder + "][data]");
            return "convert(" + sortColumnDate + ", gbk) " + sortDir;
        }
    }

    public static String orderByHql(String field, String direct) {
        return "convert(" + field + ", gbk) " + direct;
    }

    public static String orderBySql(HttpServletRequest request) {
        return orderBySql(request, "");
    }

    public static Map<String, Object> orderBy(HttpServletRequest request,String aliasName) {
        Map<String, Object> params = new HashMap<>();
        String sortOrder = request.getParameter("order[0][column]");
        String sortDir = request.getParameter("order[0][dir]");
        String sortColumnName = request.getParameter("columns[" + sortOrder + "][name]");
        if(StringUtils.isBlank(sortColumnName)){
            sortColumnName = "ID";
        }
        params.put("orderBy",aliasName+"."+sortColumnName+" "+sortDir);
        return params;
    }

    public static String orderBySql(HttpServletRequest request, String aliasName) {
        // For sortable
        String sortOrder = request.getParameter("order[0][column]");
        String sortDir = request.getParameter("order[0][dir]");
        String sortColumnName = request.getParameter("columns[" + sortOrder + "][name]");
        if (StringUtils.isNotBlank(sortColumnName)) {
            return "convert(" + sortColumnName.replaceAll("::", ".") + " using gbk) " + sortDir;
        } else {
            String sortColumnDate = request.getParameter("columns[" + sortOrder + "][data]");

            return "convert(" + (StringUtils.length(aliasName) > 0 ? (aliasName + ".") : "") + sortColumnDate + " using gbk) " + sortDir;
        }
    }

    public static String orderBySql(String field, String direct) {
        return "convert(" + field + " using gbk) " + direct;
    }

    public static Pageable pageable(Integer start, Integer pageSize) {
        int ps = pageSize == null ? 10 : pageSize;
        int page = start == null ? 0 : start / pageSize;
        return new PageRequest(page, ps);
    }

    public static Pageable pageable(Integer start, Integer pageSize, Sort sort) {
        int ps = pageSize == null ? 10 : pageSize;
        int page = start == null ? 0 : start / pageSize;
        return new PageRequest(page, ps, sort);
    }
}

