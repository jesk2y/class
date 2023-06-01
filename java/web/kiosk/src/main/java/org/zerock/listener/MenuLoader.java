package org.zerock.listener;

import org.zerock.dao.QueryExecutor;
import org.zerock.domain.MenuVO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebListener
public class MenuLoader implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        final List<MenuVO> menuVOList = new ArrayList<>();
        final Map<Integer, MenuVO> menuVOMap = new HashMap<>();

        new QueryExecutor(){
            String sql = "select * from tbl_cmenu";
            public void doJob() throws SQLException {

                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                while(rs.next()){

                    MenuVO vo = new MenuVO();
                    vo.setCno(rs.getInt("cno"));
                    vo.setCname(rs.getString("cname"));
                    vo.setCprice(rs.getInt("cprice"));
                    menuVOList.add(vo);
                    menuVOMap.put(vo.getCno(),vo);

                }
            }
        }.executeAll();

//        for(int i = 0; i < 10; i++){
//            MenuVO vo = new MenuVO(i,"메뉴"+i, i*1000);
//            menuVOList.add(vo);
//            menuVOMap.put(i, vo);
//        }
        sce.getServletContext().setAttribute("menuList", menuVOList);
        sce.getServletContext().setAttribute("menuMap", menuVOMap);
    }
}