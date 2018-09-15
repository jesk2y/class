import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ImageMaker {

    //bad code
    public static void main(String[] args)throws Exception {

        BufferedImage image= new BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB);   //메모리공간에만 잠깐 만들어놓는 이미지

        File bgFile = new File("C:\\zzz\\album\\bg.jpg");
        BufferedImage bgImage = ImageIO.read(bgFile);

        Graphics graphics = image.getGraphics();
//        graphics.setColor(Color.PINK);
        graphics.drawImage(bgImage,0,0,null);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Calibri",Font.ITALIC,78));
        graphics.drawString("oliN",170,961);

//        graphics.fillRect(0,0,300,300);    //사각형으로 채움

        ImageIO.write(image, "jpg", new File("C:\\zzz\\album\\test.jpg"));

    }
}
