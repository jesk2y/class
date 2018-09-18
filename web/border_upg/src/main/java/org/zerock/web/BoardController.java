package org.zerock.web;

import lombok.extern.log4j.Log4j;
import org.zerock.dao.BoardDAO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PageDTO;
import org.zerock.domain.PageMaker;
import org.zerock.util.Converter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/board/*")
@Log4j
public class BoardController extends AbstractController {

    private BoardDAO dao = new BoardDAO();


    public String writeGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{

        System.out.println("writeGET.......................");

        return "write";
    }
    public String writePOST(HttpServletRequest req, HttpServletResponse resp)throws Exception{

        System.out.println("writePOST.......................");
       BoardVO vo = new BoardVO();

        req.setCharacterEncoding("UTF-8");
        System.out.println("Register..............");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String writer = req.getParameter("writer");

        vo.setTitle(title);
        vo.setContent(content);
        vo.setWriter(writer);

        dao.create(vo);

        return "redirect/board/list";
    }
    public String listGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        System.out.println("listGET.......................");
        log.fatal("Trace...");
        log.debug("debug...");
        log.info("info...");
        log.warn("warn...");
        log.error("error...");
        log.trace("trace...");


        PageDTO dto = PageDTO.of()
                .setPage(Converter.getInt(req.getParameter("page"),1))
                .setSize(Converter.getInt(req.getParameter("size"),10));

        BoardDAO dao = new BoardDAO();
        int total = dao.total();

        PageMaker pageMaker=new PageMaker(total,dto);

        req.setAttribute("pageMaker",pageMaker);
        req.setAttribute("list", dao.getList(dto));

        return "list";
    }

    public String readGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        System.out.println("readGET.......................");
        String bnoStr=req.getParameter("bno");
        String pageStr=req.getParameter("page");

        int bno=Converter.getInt(bnoStr,-1);

        if(bno==-1){
            throw new Exception("invalid data");
        }

        Cookie[] cookies=req.getCookies();
        Cookie viewCookie=null;
        boolean updateable=false;

        //"view"라는 이름의 쿠키가 있다면
        for(Cookie ck:cookies){
            if(ck.getName().equals("views")){
                viewCookie=ck;
                break;
            }
        }


        if(viewCookie==null){//쿠키가 없다면
            Cookie newCookie=new Cookie("views",bnoStr+"%");
            newCookie.setMaxAge(60*60*24);
            viewCookie=newCookie;
            System.out.println("-----------------------------------------");
            System.out.println(viewCookie);
            updateable=true;    //첨 본 글이므로 조회수 1 추가 가능

        }else{//쿠키가 있긴 있는데
            String cookieValue = viewCookie.getValue(); //51242%

            updateable=cookieValue.contains(bnoStr+'%')==false; //true - 첨 본 글
            if(updateable==true){   //쿠키값이 중복이 아니므로
                cookieValue=cookieValue+bnoStr+"%"; //새 게시물 쿠키 추가
                viewCookie.setValue(cookieValue);
            }
        }
        resp.addCookie(viewCookie);

        req.setAttribute("board",dao.getBoard(bno,updateable));
        req.setAttribute("page",pageStr);
        return "read";
    }
    public String modifyGET(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        System.out.println("modifyGET.......................");
        String bnoStr=req.getParameter("bno");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("bno: "+bnoStr);
        String pageStr=req.getParameter("page");
        int bno=Converter.getInt(bnoStr,-1);

        req.setAttribute("board",dao.getBoard(bno,false));
        req.setAttribute("page",pageStr);
        return "modify";
    }
    public String modifyPOST(HttpServletRequest req, HttpServletResponse resp)throws Exception {
        req.setCharacterEncoding("UTF-8");
        String pageStr=req.getParameter("page");


        String bnoStr=req.getParameter("bno");
        String title=req.getParameter("title");
        String content=req.getParameter("content");
        String writer=req.getParameter("writer");

        int bno=Integer.parseInt(bnoStr);

       BoardVO vo=new BoardVO();

        vo.setBno(bno);
        vo.setTitle(title);
        vo.setContent(content);
        vo.setWriter(writer);

        dao.modify(vo);

        return "redirect/board/list?page="+pageStr;
    }
    public String removePOST(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        System.out.println("REMOVE POST.......................");
        String bnoStr=req.getParameter("bno");
        Integer bno=Integer.parseInt(bnoStr);
        dao.delete(bno);

        return "redirect/board/list";
    }
    public String getBasic() {
        return "/board/";
    }
}