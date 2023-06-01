import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageMaker {

    //bad code
    public static void main(String[] args)throws Exception {

        BufferedImage image = new BufferedImage(1000,1000,
                                                  BufferedImage.TYPE_INT_RGB );

        File bgFile = new File("C:\\zzz\\album\\bg.jpg");
        BufferedImage bgImage = ImageIO.read( bgFile );

        Graphics graphics = image.getGraphics();
        graphics.drawImage(bgImage,0,0, null);

        graphics.setColor(Color.pink);

        graphics.setFont(new Font("TimesRoman", Font.ITALIC, 100));
        graphics.drawString("Hello World",200,500);

        ImageIO.write(image, "jpg", new File("C:\\zzz\\album\\test.jpg"));


    }

}
