
package Captcha_Componentes;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;

public class CaptchaLabel extends JLabel 
{
    private String Texto_del_Captcha;
    private BufferedImage Imagen_del_Captcha;

    public CaptchaLabel() 
    {
        Dimension size = new Dimension(200, 60);
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
        generarCaptcha();
    }

    public void generarCaptcha() 
    {
        Texto_del_Captcha = generarTextoCaptcha(6);
        Imagen_del_Captcha = generarImagen_delCaptcha(Texto_del_Captcha);
        repaint();
    }

    public String getTexto_Captcha() 
    {
        return Texto_del_Captcha;
    }

    private String generarTextoCaptcha (int Tamaño) 
    {
        String characteres = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        StringBuilder CaptchaGenerado = new StringBuilder();
        Random rand = new Random();
        for (int x = 0; x < Tamaño; x++) 
        {
            CaptchaGenerado.append(characteres.charAt(rand.nextInt(characteres.length())));
        }
        return CaptchaGenerado.toString();
    }

    private BufferedImage generarImagen_delCaptcha(String text) 
    {
        int ancho = 200;
        int alto = 60;
        BufferedImage imagenCaptcha = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        Graphics2D pincel = imagenCaptcha.createGraphics();
        pincel.setColor(Color.LIGHT_GRAY);
        pincel.fillRect(0, 0, ancho, alto);
        pincel.setFont(new Font("Arial", Font.BOLD, 40));
        Random rand = new Random();
        for (int i = 0; i < text.length(); i++) 
        {
            int x = 30 * i + rand.nextInt(5);
            int y = 40 + rand.nextInt(10);
            pincel.setColor(new Color(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100)));
            pincel.drawString(String.valueOf(text.charAt(i)), x, y);
        }
        for (int i = 0; i < 8; i++) 
        {
            pincel.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            int x1 = rand.nextInt(ancho);
            int y1 = rand.nextInt(alto);
            int x2 = rand.nextInt(ancho);
            int y2 = rand.nextInt(alto);
            pincel.drawLine(x1, y1, x2, y2);
        }
        pincel.dispose();
        float[] kernel = {
            1f / 9, 1f / 9, 1f / 9,
            1f / 9, 1f / 9, 1f / 9,
            1f / 9, 1f / 9, 1f / 9
        };
        java.awt.image.Kernel blurKernel = new java.awt.image.Kernel(3, 3, kernel);
        java.awt.image.ConvolveOp op = new java.awt.image.ConvolveOp(blurKernel);
        BufferedImage imagenBorroso = op.filter(imagenCaptcha, null);
        return imagenBorroso;
    }
    
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        if (Imagen_del_Captcha != null) 
        {
            g.drawImage(Imagen_del_Captcha, 0, 0, null);
        }
    }
}
