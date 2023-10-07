import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        int[] filter1 = {1, 1, 1, 0, 0, 0, -1, -1, -1};
        int[] filter2 = {1, 0, -1, 1, 0, -1, 1, 0, -1};
        int[] filter3 = {-1, -1, -1, -1, 8, -1, -1, -1, -1};
        int[] filter4 = {0, -1, 0, -1, 5, -1, 0, -1, 0};
        int[] filter5 = {0, 0, 0, -1, 1, 0, 0, 0, 0};
        int[] filter6 = {0, 1, 0, 1, -4, 1, 0, 1, 0};
        int[] filter7 = {-2, -1, 0, -1, 1, 1, 0, 1, 2};

        BufferedImage image = ImageIO.read
                (new File(
                        "C:\\Users\\Cliente\\Documents\\Faculdade Catolica da Paraíba\\4º Período\\PDI\\PDI-Convulacao\\src\\img\\lena-ruido.jpg"));


        Convolacao.convolacao(image,filter1);
        Convolacao.convolacao(image,filter2);
        Convolacao.convolacao(image,filter3);
        Convolacao.convolacao(image,filter4);
        Convolacao.convolacao(image,filter5);
        Convolacao.convolacao(image,filter6);
        Convolacao.convolacao(image,filter7);

    }
}