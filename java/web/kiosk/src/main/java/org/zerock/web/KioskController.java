package org.zerock.web;

import org.zerock.domain.MenuVO;
import org.zerock.domain.OrderVO;
import org.zerock.listener.MenuLoader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/kiosk")
public class KioskController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if(req.getSession().getAttribute("member") == null){
//            resp.sendRedirect("/login");
//            return;
//        }

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/menuList.jsp");

        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] ord = req.getParameterValues("ord");

        List<OrderVO> orderVOList = new ArrayList<>();
        for (String str:ord) {
            MenuLoader loader = new MenuLoader();

            OrderVO vo = new OrderVO(str);
            if(vo.getQty() == 0){
                continue;
            }
            orderVOList.add(vo);
        }
        System.out.println(orderVOList);
        req.setAttribute("orderList", orderVOList);

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/orderResult.jsp");

        dispatcher.forward(req,resp);
    }
}