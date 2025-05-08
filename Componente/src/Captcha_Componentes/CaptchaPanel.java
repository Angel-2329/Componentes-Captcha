
package Captcha_Componentes;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;

public class CaptchaPanel extends JPanel 
{
    private final JLabel captchaImageLabel;
    private final JLabel labelSuperior;
    private final JLabel labelResultado;
    private final JTextField captchaTextField;
    private final JPanel captchaInputPanel;
    private Color captchaColorInputPanel = Color.WHITE;
    private String TextoLabelS = "Ingresa el captcha:";
    private Color ColorLabelS = Color.BLUE;
    private Color ColorLabelI = new Color(0, 128, 0);
    private String captchaText;
    private BufferedImage captchaImage;
    private int captchaFontSize = 20;
    private Color captchaColorLetras = Color.BLACK;
    private Color captchaColorFondo = Color.WHITE;
    private int captchaLargoTexto = 6;
    private CaptchaTipo captchaTipo = CaptchaTipo.COMBINADO;
    private int captchaAncho = 60;
    private int captchaLargo = 250;
    private boolean captchaBorroso = true;
    private int captchaNivelBorroso = 1;
    private boolean captchaDibujarLineas = true;
    private int captchaCantidadLineas = 8;
    private String captchaTipoLetra = "Arial";
    private EstiloLetra captchaEstilo = EstiloLetra.BOLD;
    private final JButton captchaBotonRegenerar;
    private boolean captchaMostrarBoton = false;
    private Color botonColorFondo = Color.LIGHT_GRAY;
    private Color botonColorTexto = Color.BLACK;
    private String botonSimbolo = "↻";

    public CaptchaPanel() 
    {
        this.setLayout(new BorderLayout());
        captchaImageLabel = generarLabel ();
        captchaImageLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(captchaImageLabel, BorderLayout.CENTER);
        captchaBotonRegenerar = new JButton(botonSimbolo);
        captchaBotonRegenerar.setToolTipText("Recargar Captcha");
        captchaBotonRegenerar.addActionListener(e -> generarCaptcha());
        captchaBotonRegenerar.setVisible(captchaMostrarBoton);
        actualizarEstiloBoton();
        this.add(captchaBotonRegenerar, BorderLayout.EAST);
        labelSuperior = new JLabel(TextoLabelS);
        labelSuperior.setForeground(ColorLabelS);
        labelSuperior.setAlignmentX(Component.CENTER_ALIGNMENT);
        captchaTextField = new JTextField(10);
        captchaTextField.addActionListener(e -> verificarCaptcha());
        labelResultado = new JLabel(" ");
        labelResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelResultado.setForeground(Color.DARK_GRAY);
        captchaInputPanel = new JPanel();
        captchaInputPanel.setBackground(captchaColorInputPanel);
        captchaInputPanel.setLayout(new BoxLayout(captchaInputPanel, BoxLayout.Y_AXIS));
        captchaInputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        captchaInputPanel.add(labelSuperior);
        captchaInputPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        captchaInputPanel.add(captchaTextField);
        captchaInputPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        captchaInputPanel.add(labelResultado);
        this.add(captchaInputPanel, BorderLayout.SOUTH);
        restringirEntradaAlfanumerica(captchaTextField);
        generarCaptcha();
    }
    
    private void verificarCaptcha() 
    {
        String textoIngresado = captchaTextField.getText().trim();
        String textoCaptcha = captchaText;
        if (textoIngresado.equalsIgnoreCase(textoCaptcha)) 
        {
            labelResultado.setText("✅ ¡Captcha correcto!");
            labelResultado.setForeground(ColorLabelI);
        } 
        else 
        {
            labelResultado.setText("❌ Captcha incorrecto. Se ha generado uno nuevo.");
            labelResultado.setForeground(Color.RED);
            generarCaptcha();
            captchaTextField.setText("");
        }
    }
    
    public JLabel generarLabel ()
    {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        BufferedImage imagen = generarImagen_delCaptcha(generarTextoCaptcha(captchaLargoTexto));
        label.setIcon(new ImageIcon(imagen));
        Dimension size = new Dimension(captchaLargo, captchaAncho);
        label.setPreferredSize(size);
        label.setMinimumSize(size);
        label.setMaximumSize(size);
        label.setSize(size);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        label.setBorder(border);
        return label;
    }
    
    private void actualizarEstiloBoton() 
    {
        if (captchaBotonRegenerar != null) 
        {
            captchaBotonRegenerar.setBackground(botonColorFondo);
            captchaBotonRegenerar.setForeground(botonColorTexto);
            captchaBotonRegenerar.setText(botonSimbolo);
            captchaBotonRegenerar.setFocusPainted(false);
            captchaBotonRegenerar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        }
    }
    
    
    public void RepintarLabel ()
    {
        labelResultado.setForeground(ColorLabelI);
        labelSuperior.setForeground(ColorLabelS);
        labelSuperior.setText(TextoLabelS);
        captchaInputPanel.setBackground(captchaColorInputPanel);
    }
    public void setColorFondoPanelEntrada(Color color) 
    {
        captchaColorInputPanel = color;
        RepintarLabel ();
    }

    public Color getColorFondoPanelEntrada() 
    {
        return captchaColorInputPanel;
    }
    
    public void setTextoLabelSuperior(String texto) 
    {
        TextoLabelS = texto;
        RepintarLabel ();
    }

    public String getTextoLabelSuperior() 
    {
        return TextoLabelS;
    }
   
    public void setColorTextoLabelSuperior(Color color) 
    {
        ColorLabelS = color;
        RepintarLabel ();
    }

    public Color getColorTextoLabelSuperior() 
    {
        return ColorLabelS;
    }

    public void setColorTextoLabelResultado(Color color) 
    {
        ColorLabelI = color;
        RepintarLabel ();
    }

    public Color getColorTextoLabelResultado() 
    {
        return ColorLabelS;
    }
    
    public JLabel getcaptchaImageLabel ()
    {
        return captchaImageLabel;
    }
    
    public void setMostrarBotonRecargarCaptcha(boolean mostrar) 
    {
        this.captchaMostrarBoton = mostrar;
        captchaBotonRegenerar.setVisible(mostrar);
        this.revalidate();
        this.repaint();
    }

    public boolean isMostrarBotonRecargarCaptcha() 
    {
        return captchaMostrarBoton;
    }

    public String getTipoLetra() 
    {
        return captchaTipoLetra;
    }

    public void setTipoLetra(String tipoLetra) 
    {
        this.captchaTipoLetra = tipoLetra;
        repaint();
    }
    
    public enum CaptchaTipo 
    {
        SOLO_LETRAS,
        SOLO_NUMEROS,
        COMBINADO
    }
    
    public CaptchaTipo getTipoCaptcha() 
    {
        return captchaTipo;
    }

    public void setTipoCaptcha(CaptchaTipo tipoCaptcha) 
    {
        this.captchaTipo = tipoCaptcha;
        generarCaptcha();
    }

    public enum EstiloLetra 
    {
        PLAIN,
        BOLD,
        ITALIC,
        BOLD_ITALIC
    }
    
    public EstiloLetra getEstilo ()
    {
        return captchaEstilo;
    }
    
    public void setEstilo (EstiloLetra EstiloCaptcha)
    {
        this.captchaEstilo = EstiloCaptcha;
        generarCaptcha();
    }
    
    public int getCaptchaFontSize ()
    {
        return captchaFontSize;
    }
    
    public void setCaptchaFontSize (int Tamaño)
    {
        captchaFontSize = Tamaño;
        generarCaptcha();
    }
    
    public int getcaptchaAnchoImagen ()
    {
        return captchaAncho;
    }
    
    public void setcaptchaAnchoImagen (int Tamaño)
    {
        captchaAncho = Tamaño;
        actualizarTamaño ();
    }
    
    public int getcaptchaLargoImagen ()
    {
        return captchaLargo;
    }
    
    public void setcaptchaLargoImagen (int Tamaño)
    {
        captchaLargo = Tamaño;
        actualizarTamaño ();
    }
    
    public Color getCaptchaColor()
    {
        return captchaColorLetras;
    }
    
    public void setCaptchaColor (Color ColorNuevo)
    {
        captchaColorLetras = ColorNuevo;
        generarCaptcha();
    }
    
    public Color getcaptchaColorFondo()
    {
        return captchaColorFondo;
    }
    
    public void setcaptchaColorFondo (Color ColorNuevo)
    {
        captchaColorFondo = ColorNuevo;
        generarCaptcha();
    }
    
    public int getLargoDelCaptcha() 
    {
    return captchaLargoTexto;
    }

    public void setLargoDelCaptcha(int largo) 
    {
        this.captchaLargoTexto = largo;
        generarCaptcha();
    }

    public void generarCaptcha() 
    {
        captchaText = generarTextoCaptcha(captchaLargoTexto);
        captchaImage = generarImagen_delCaptcha(captchaText);
        captchaImageLabel.setIcon(new ImageIcon(captchaImage));
        labelResultado.setText("");
    }

    public String getTexto_Captcha() 
    {
        return captchaText;
    }
    
    public boolean isCaptchaBorroso() 
    {
        return captchaBorroso;
    }

    public void setCaptchaBorroso(boolean captchaBorroso) 
    {
        this.captchaBorroso = captchaBorroso;
        generarCaptcha();
    }

    public int getNivelBorroso() 
    {
        return captchaNivelBorroso;
    }

    public void setNivelBorroso(int nivelBorroso) 
    {
        this.captchaNivelBorroso = Math.max(0, Math.min(nivelBorroso, 4));
        generarCaptcha();
    }
    
    public boolean isDibujarLineas() 
    {
        return captchaDibujarLineas;
    }

    public void setDibujarLineas(boolean dibujarLineas) 
    {
        this.captchaDibujarLineas = dibujarLineas;
        generarCaptcha();
    }

    public int getCantidadLineas() 
    {
        return captchaCantidadLineas;
    }

    public void setCantidadLineas(int cantidadLineas) 
    {
        this.captchaCantidadLineas = Math.max(0, cantidadLineas);
        generarCaptcha();
    }
    
    public void setBotonColorFondo(Color color) 
    {
        this.botonColorFondo = color;
        actualizarEstiloBoton();
    }

    public void setBotonColorTexto(Color color) 
    {
        this.botonColorTexto = color;
        actualizarEstiloBoton();
    }

    public void setBotonSimbolo(String simbolo) 
    {
        this.botonSimbolo = simbolo;
        actualizarEstiloBoton();
    }
    
    private void restringirEntradaAlfanumerica(JTextField captchaTextField) 
    {
        captchaTextField.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
                char c = e.getKeyChar();
                if (!Character.isLetterOrDigit(c)) 
                {
                    e.consume();
                }
            }
        });
    }

    private String generarTextoCaptcha (int Tamaño) 
    {
        String characteres;
        switch (captchaTipo) 
        {
            case SOLO_LETRAS:
                characteres = "ABCDEFGHJKLMNPQRSTUVWXYZ";
                break;
            case SOLO_NUMEROS:
                characteres = "0123456789";
                break;
            case COMBINADO:
            default:
                characteres = "0123456789ABCDEFGHJKLMNPQRSTUVWXYZ0123456789";
                break;
        }
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
        Font fuente;
        switch (captchaEstilo)
        {
            case BOLD:
            default:
                fuente = new Font(captchaTipoLetra, Font.BOLD, captchaFontSize);
                break;
            case ITALIC:
                fuente = new Font(captchaTipoLetra, Font.ITALIC, captchaFontSize);
                break;
            case PLAIN:
                fuente = new Font(captchaTipoLetra, Font.PLAIN, captchaFontSize);
                break;
            case BOLD_ITALIC:
                fuente = new Font(captchaTipoLetra, Font.BOLD + Font.ITALIC, captchaFontSize);
                break;     
        }
        int ancho = captchaLargo;
        int alto = captchaAncho;
        BufferedImage imagenCaptcha = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        Graphics2D pincel = imagenCaptcha.createGraphics();
        pincel.setColor(captchaColorFondo);
        pincel.fillRect(0, 0, ancho, alto);
        pincel.setFont(fuente);
        FontMetrics metrics = pincel.getFontMetrics();
        int textoWidth = metrics.stringWidth(text);
        int startX = (ancho - textoWidth) / 2;
        int baselineY = (alto - metrics.getHeight()) / 2 + metrics.getAscent();
        pincel.setColor(captchaColorLetras);
        Random rand = new Random();
        int currentX = startX;
        for (int i = 0; i < text.length(); i++) 
        {
            char c = text.charAt(i);
            int charWidth = metrics.charWidth(c);
            int offsetY = rand.nextInt(10) - 5; 
            pincel.drawString(String.valueOf(c), currentX, baselineY + offsetY);
            currentX += charWidth;
        }
        dibujarLineasDecorativas(pincel, ancho, alto);
        pincel.dispose();
        return aplicarDesenfoque(imagenCaptcha);
    }
    
    private BufferedImage aplicarDesenfoque(BufferedImage imagen) 
    {
        if (!captchaBorroso || captchaNivelBorroso <= 0) 
        {
            return imagen;
        }
        int size = 3 + 2 * (captchaNivelBorroso - 1);
        float[] kernelData = new float[size * size];
        float valor = 1f / (size * size);
        for (int i = 0; i < kernelData.length; i++) 
        {
            kernelData[i] = valor;
        }
        java.awt.image.Kernel kernel = new java.awt.image.Kernel(size, size, kernelData);
        java.awt.image.ConvolveOp op = new java.awt.image.ConvolveOp(kernel, java.awt.image.ConvolveOp.EDGE_NO_OP, null);
        return op.filter(imagen, null);
    }
    
    private void actualizarTamaño() 
    {
        Dimension size = new Dimension(captchaLargo, captchaAncho);
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setSize(size);
        revalidate();
        repaint();
    }
    
    private void dibujarLineasDecorativas(Graphics2D g, int captchaLargo, int captchaAncho) 
    {
        if (!captchaDibujarLineas || captchaCantidadLineas <= 0) 
        {
            return;
        }

        Random rand = new Random();
        for (int i = 0; i < captchaCantidadLineas; i++) {
            g.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            int x1 = rand.nextInt(captchaLargo);
            int y1 = rand.nextInt(captchaAncho);
            int x2 = rand.nextInt(captchaLargo);
            int y2 = rand.nextInt(captchaAncho);
            g.drawLine(x1, y1, x2, y2);
        }
    }
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        if (captchaImage != null) 
        {
            g.drawImage(captchaImage, 0, 0, null);
        }
    }
}
