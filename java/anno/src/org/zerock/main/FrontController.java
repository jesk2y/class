package org.zerock.main;

import org.zerock.anno.GetMapping;
import org.zerock.anno.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
    private Map<String, Object> controllerMap;

    public FrontController(){   //FrontController의 Map 정의
        controllerMap = new HashMap<>();

        try{
            Class clz =
                    Class.forName("org.zerock.web.BoardController");
            RequestMapping r1 = (RequestMapping) clz.getAnnotation(RequestMapping.class);
            controllerMap.put(r1.value(), clz.newInstance());
            // <클래스에 설정한 value값, 클래스 주소값>
        }catch (Exception e){e.printStackTrace();}
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getRequestURI();
        System.out.println(path);

        Iterator<String> it = controllerMap.keySet().iterator();
        //요소들을 읽어오는 인터페이스

        while(it.hasNext()){
            String value = it.next(); // 키값 가져옴

            System.out.println("==========");
            System.out.println(value);
            System.out.println(path.indexOf(value));
            //없으면 -1나옴

            if(path.indexOf(value) >= 0){// path(주소창에 입력한 값)에 value(/board/)가 포함되어 있으면
                Object obj = controllerMap.get(value);  //bc 클래스 주소값 가져옴

                String getPost = req.getMethod();   //GET, POST

                Class anno = null;

                if(getPost.equals("GET")){
                    anno = GetMapping.class;        //anno가 뜻하는게 무엇인지 모르겠음
                }

                Method[] ms = obj.getClass().getDeclaredMethods();
                // 주소값으로 메소드들 가져옴

                for(Method m:ms){
                    GetMapping mapping = (GetMapping) m.getAnnotation(anno);

                    if(mapping.value().equals(path)){
                        System.out.println(m);  //메소드 이름 출력
                        try{
                            Class[] paramTypes = m.getParameterTypes();

                            System.out.println(Arrays.toString(paramTypes));

                            String reqName = "page";

                            m.invoke(obj,req.getParameter(reqName));

                        }catch(Exception e){
                            e.printStackTrace();
                        }

                    }
                }
                break;
            }
        }

    }
}
