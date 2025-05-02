package Captcha_Componentes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaptchaTextField extends JTextField implements ActionListener 
{
    private CaptchaLabel captchaLabel;
    public CaptchaTextField() 
    {
        super(10); // ancho del campo de texto
        this.addActionListener(this); // se registra como listener
        this.setText("");
    }

    public void setCaptchaLabel(CaptchaLabel captchaLabel) 
    {
        this.captchaLabel = captchaLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (captchaLabel != null) 
        {
            verificarCaptcha();
        } 
        else 
        {
            JOptionPane.showMessageDialog(this, "CaptchaLabel no asignado.");
        }
    }

    private void verificarCaptcha() 
    {
        String textoIngresado = getText().trim();
        String textoCaptcha = captchaLabel.getTexto_Captcha();

        if (textoIngresado.equalsIgnoreCase(textoCaptcha)) 
        {
            JOptionPane.showMessageDialog(this, "¡Captcha correcto!");
        }
        else 
        {
            JOptionPane.showMessageDialog(this, "Captcha incorrecto. Se ha generado uno nuevo.");
            captchaLabel.generarCaptcha();
            this.setText("");
        }
    }
}
