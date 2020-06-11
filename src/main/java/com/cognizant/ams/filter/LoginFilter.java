package com.cognizant.ams.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录过滤器
 */
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * 保存不拦截的url
     */
    private static List<String> passUrls = new ArrayList<>();

    /**
     * 上下文
     */
    private String ctxPath = null;

    /**
     * 重定向url
     */
    private static String redirectUrl = "";


    /**
     * 过滤器初始化方法
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        // 获取web.xml中的初始化参数
        String ignoreURL = "*";
        redirectUrl = "logon.html";
        // 保存不拦截的url
        String[] ignoreURLArray = ignoreURL.split(",");
        for (String url : ignoreURLArray) {
            passUrls.add(url.trim());
        }
        ctxPath = filterConfig.getServletContext().getContextPath();
        System.out.println("ctx = " + ctxPath);
        LOGGER.info("不拦截的URL包括:");
        for (String url : passUrls) {
            LOGGER.info(url);
        }
    }


    /**
     * 过滤器方法
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 请求的url
        String url = request.getRequestURI();
        // 相对路径
        String subUrl = url.substring(ctxPath.length() + 1);

        for (String urlStr : passUrls) {
            // 如果匹配, 则放行
            if (subUrl.indexOf(urlStr) > -1) {
                filterChain.doFilter(request, response);
                return;
            }
        }

        // 获得session
        HttpSession session = request.getSession();
        // 从session中获取SessionKey对应值,若值不存在,则重定向到redirectUrl
        Object user = session.getAttribute("username");
        if (user != null) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(ctxPath + "/" + redirectUrl);
        }
    }


    @Override
    public void destroy() {

    }
}
