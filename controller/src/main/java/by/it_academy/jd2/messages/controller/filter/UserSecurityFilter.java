package by.it_academy.jd2.messages.controller.filter;

import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/user/*","/api/message"})
public class UserSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse) response;

        String contextPath=req.getContextPath();
        HttpSession session=req.getSession();

        if ((session!=null)&&(SessionUtils.giveUser(session).isPresent())){
            chain.doFilter(req,resp);
        } else {
            resp.sendRedirect(contextPath+"/ui/signIn");
        }
    }
}
