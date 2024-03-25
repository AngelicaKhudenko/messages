package by.it_academy.jd2.messages.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/ui/*")
public class PathFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse) response;

        String contextPath=req.getContextPath();

        String basePath="";
        if (!contextPath.isEmpty()){
            basePath+=contextPath;
        }

        req.setAttribute("basePath",basePath);
        chain.doFilter(req,resp);
    }
}
