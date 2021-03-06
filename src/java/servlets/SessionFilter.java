/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fatma
 */
@WebFilter(urlPatterns = {"/home.jsp"})
public class SessionFilter implements Filter{

    @Override
    public void init(FilterConfig fc) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) sr;
        if(req.getSession(false)==null){
            HttpServletResponse resp = (HttpServletResponse) sr1;
            resp.sendRedirect("index.html");
        }
        else{
            fc.doFilter(sr, sr1);
        }
    }

    @Override
    public void destroy() {

    }
    
}



