package org.zerock.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
@WebServlet("/getFile")
public class GetFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetFileServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getParameter("fname");

        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (ext.equals("jpg")) {
            response.setContentType("image/jpeg");
        } else { // jpg파일이 아니면
            response.setContentType("application/octet-stream"); // 다운로드받음
            response.setHeader("Content-disposition", "attachment; filename="+ fileName);
            //파일이 getFile.확장자명로 받아지는거 방지
            //문제점 : 한글이름파일은 깨져서 받아짐

        }

        response.setContentType("image.jpeg");

        OutputStream os = response.getOutputStream();
        InputStream in = new FileInputStream("C:\\zzz\\upload\\" + fileName);
        IOUtils.copy(in, os);

    }

}
