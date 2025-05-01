# Componentes-Captcha

# CaptchaLabel - Generador de CAPTCHA en Java

Este componente en Java genera una imagen CAPTCHA personalizada, utilizando `JLabel` de Swing, que puede integrarse fácilmente en interfaces gráficas de usuario (GUI). La imagen contiene texto aleatorio con ruido visual y un filtro de desenfoque para aumentar su seguridad.

## 🧩 Características

- ✅ Generación aleatoria de texto CAPTCHA (8 caracteres).
- 🎨 Renderizado gráfico con distorsión, ruido visual y color aleatorio por carácter.
- 🌫️ Aplicación de un filtro de desenfoque (blur) sobre la imagen.
- 🔁 Componente reutilizable con capacidad de regenerar CAPTCHA dinámicamente.
- 🧱 Basado en la biblioteca estándar de Java (AWT y Swing).

## 📷 Vista previa (simulada)

> ⚠️ Como este es un componente gráfico, el resultado se visualiza al integrarlo en una aplicación Java Swing.

## 📁 Estructura

# CaptchaTextField - Campo de texto con verificación de CAPTCHA en Java

Este componente extiende `JTextField` y se conecta a un `CaptchaLabel` para verificar automáticamente si el texto ingresado por el usuario coincide con el CAPTCHA generado.

## 🔐 Funcionalidad

- 📥 Campo de texto que escucha acciones (`Enter`) del usuario.
- 🔍 Verifica automáticamente el texto ingresado con el CAPTCHA.
- 🔄 Si la verificación falla, genera un nuevo CAPTCHA y limpia el campo.
- 🖥️ Diseñado para trabajar junto con el componente `CaptchaLabel`.
