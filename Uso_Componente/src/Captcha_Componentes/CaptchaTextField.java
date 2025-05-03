package Captcha_Componentes;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CaptchaTextField extends JTextField implements ActionListener 
{
    private CaptchaPanel captchaPanel;
    public CaptchaTextField() 
    {
        super(10);
        this.addActionListener(this);
        this.setText("");
        restringirEntrada();
    }

    public void setCaptchaPanel(CaptchaPanel captchaLabel) 
    {
        this.captchaPanel = captchaLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (captchaPanel != null) 
        {
            verificarCaptcha();
        } 
        else 
        {
            JOptionPane.showMessageDialog(this, "captchaPanel no asignado.");
        }
    }

    private void verificarCaptcha() 
    {
        String textoIngresado = getText().trim();
        String textoCaptcha = captchaPanel.getTexto_Captcha();

        if (textoIngresado.equalsIgnoreCase(textoCaptcha)) 
        {
            JOptionPane.showMessageDialog(this, "¡Captcha correcto!");
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "Captcha incorrecto. Se ha generado uno nuevo.");
            captchaPanel.generarCaptcha();
            this.setText("");
        }
    }
    
    private void restringirEntrada() 
    {
        this.addKeyListener(new KeyAdapter() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {
                char c = e.getKeyChar();
                if (!Character.isLetterOrDigit(c)) 
                {
                    e.consume(); // No se permite el carácter
                    Toolkit.getDefaultToolkit().beep(); // Sonido opcional de advertencia
                }
            }
        });
    }
}
