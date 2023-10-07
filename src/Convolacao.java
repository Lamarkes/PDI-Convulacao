import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Convolacao {

    static final String CAMINHO_PADRAO = "C:\\Users\\Cliente\\Documents\\Faculdade Catolica da Paraíba\\4º Período\\PDI\\PDI-Convulacao\\src\\";

    public static void convolacao(BufferedImage image, int[] filter) throws IOException {


        int largura = image.getWidth();
        int altura = image.getHeight();

        BufferedImage novaImagem = new BufferedImage(largura,altura,BufferedImage.TYPE_INT_RGB);

        for (int linha = 1; linha < largura - 1; linha++) {
            for (int coluna = 1; coluna < altura - 1; coluna++) {


                int pixel1 = image.getRGB(linha-1, coluna-1);
                Color cor1 = new Color(pixel1);
                int px1 = cor1.getRed();

                int pixel2 = image.getRGB(linha-1,coluna);
                Color cor2 = new Color(pixel2);
                int px2 = cor2.getRed();

                int pixel3 = image.getRGB(linha-1,coluna+1);
                Color cor3 = new Color(pixel3);
                int px3 = cor3.getRed();

                int pixel4 = image.getRGB(linha,coluna-1);
                Color cor4 = new Color(pixel4);
                int px4 = cor4.getRed();

                int pixel5 = image.getRGB(linha,coluna);
                Color cor5 = new Color(pixel5);
                int px5 = cor5.getRed();

                int pixel6 = image.getRGB(linha,coluna+1);
                Color cor6 = new Color(pixel6);
                int px6 = cor6.getRed();

                int pixel7 = image.getRGB(linha+1,coluna-1);
                Color cor7 = new Color(pixel7);
                int px7 = cor7.getRed();

                int pixel8 = image.getRGB(linha+1,coluna);
                Color cor8 = new Color(pixel8);
                int px8 = cor8.getRed();

                int pixel9 = image.getRGB(linha+1,coluna+1);
                Color cor9 = new Color(pixel9);
                int px9 = cor9.getRed();

                double novoPixel = 0.0;

                novoPixel += (px1 * filter[0]);
                novoPixel += (px2 * filter[1]);
                novoPixel += (px3 * filter[2]);
                novoPixel += (px4 * filter[3]);
                novoPixel += (px5 * filter[4]);
                novoPixel += (px6 * filter[5]);
                novoPixel += (px7 * filter[6]);
                novoPixel += (px8 * filter[7]);
                novoPixel += (px9 * filter[8]);

                if (novoPixel > 255){
                    novoPixel = 255;
                }
                if (novoPixel < 0){
                    novoPixel = 0;
                }

                int novoValor = (int) novoPixel;
                Color novaCor = new Color(novoValor, novoValor, novoValor);
                novaImagem.setRGB(linha, coluna, novaCor.getRGB());
            }
        }
        String caminho = CAMINHO_PADRAO + "img/result.jpg";
        ImageIO.write(novaImagem, "jpg", new File(caminho));
        JFrame janela = new JFrame();
        ImageIcon icon = new ImageIcon(novaImagem);
        JLabel label = new JLabel(icon);
        janela.add(label);
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }




}
