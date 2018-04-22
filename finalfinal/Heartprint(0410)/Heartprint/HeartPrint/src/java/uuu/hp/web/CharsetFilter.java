/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.hp.web;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 *
 * @author Administrator
 */
@WebFilter(filterName = "CharsetFilter", urlPatterns = {"*.view","*.txt","*.aspx", "*.do","*.jsp"}, 
        initParams = {@WebInitParam(name = "charset", value = "UTF-8")},
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.ERROR})
public class CharsetFilter implements Filter {
    private String charset = "UTF-8";//沒有initParameter("charset")時才用這個預設值
    private FilterConfig config;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        String charset = config.getInitParameter("charset");
        if(charset!=null){
            this.charset = charset;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(charset);
        request.getParameterNames(); //鎖定請求中的form data的charset
        
        response.setCharacterEncoding(charset);
        response.getWriter();//鎖定回應中的text output stream的charset
        
        chain.doFilter(request, response); //交棒給後續元件
    }

    @Override
    public void destroy() {
        
    }
        
}
