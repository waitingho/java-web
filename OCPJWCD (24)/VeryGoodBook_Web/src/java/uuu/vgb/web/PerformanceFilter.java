/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.vgb.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
public class PerformanceFilter implements Filter {
    private FilterConfig config;
    private String prefix = "Perfomance Moniter: ";
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
        String prefix = config.getInitParameter("performance.prefix");
        if(prefix!=null){
            this.prefix = prefix;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        
        chain.doFilter(request, response); //交棒
        
        long end = System.currentTimeMillis();
        String logMsg = prefix + ((HttpServletRequest)request).getRequestURI() + " " + (end-begin) + " ms";
        config.getServletContext().log(logMsg);
    }

    @Override
    public void destroy() {
        
    }


}
