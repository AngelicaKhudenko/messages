package by.it_academy.jd2.messages.controller.filter;

import by.it_academy.jd2.messages.controller.utils.SessionUtils;
import by.it_academy.jd2.messages.core.dto.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*","/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse resp=(HttpServletResponse) response;

        String contextPath=req.getContextPath();
        HttpSession session=req.getSession();

        if (checkAdmin(session)){
            chain.doFilter(req,resp);
        } else{
            resp.sendRedirect(contextPath+"/");
        }
    }

    /**
     * Метод, проверяющий, является ли пользователь в текующей сессии администратором
     * @param session - сессия
     * @return true, если пользователь является администратором
     *         false, если пользователь не является администратором
     */
    private boolean checkAdmin(HttpSession session){

        if (session==null){
            return false;
        }

        if (SessionUtils.giveUser(session).isEmpty()){
            return false;
        }

        return UserRole.ADMIN.equals(SessionUtils.giveUser(session).get().getRole());
    }
}
