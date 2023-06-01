package org.zerock.web;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;


@WebServlet("/upload1")
@MultipartConfig(maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100) // 100 MB
public class UploadEx1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UploadEx1() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Collection<Part> parts = request.getParts();

        System.out.println(request.getParameter("mname"));
        System.out.println(request.getParameter("price"));

        parts.stream().forEach(part -> {

            System.out.println(part.getContentType());
            System.out.println(part.getSubmittedFileName());
            System.out.println("-----------------------");
            String uploadName = UUID.randomUUID() + "_" + part.getSubmittedFileName();

            try {
                InputStream in = part.getInputStream();
                FileOutputStream fos = new FileOutputStream("C:\\zzz\\upload\\" + uploadName);

                IOUtils.copy(in, fos);

                if (Extchecker.check(uploadName)) {
                    // Make Thumbnail image
                    BufferedImage bImage = ImageIO.read(new FileInputStream("C:\\zzz\\upload\\" + uploadName));
                    BufferedImage thumbnail = Scalr.resize(bImage, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, 150,
                            150, Scalr.OP_ANTIALIAS);

                    FileOutputStream thfos = new FileOutputStream("C:\\zzz\\upload\\s_" + uploadName);
                    ImageIO.write(thumbnail, "jpg", thfos);
                    thfos.close();
                }

                // 1. 밀리세컨즈를 붙여서 파일이름 중복막음
                // 2.uuid를 사용함
                in.close();
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });

    }

}
