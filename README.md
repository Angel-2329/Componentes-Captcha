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

## ⚙️ Detalles técnicos

- **Fuente utilizada:** Arial, 40pt, negrita.
- **Colores:** Aleatorios por carácter, usando tonos oscuros.
- **Ruido visual:** 8 líneas dibujadas con colores aleatorios para dificultar la lectura automatizada.
- **Desenfoque:** Aplicado mediante `ConvolveOp` con un kernel de 3x3 (promedio), para suavizar la imagen.
- **Tamaño del componente:** 200x60 píxeles.
- **Caracteres válidos:** Letras mayúsculas sin ambigüedad (`A-Z` sin `O`, `I`) y números (`2-9`, sin `0`, `1`).

## 🧩 Métodos y Constructor de `CaptchaLabel`

### 🛠️ Constructor

#### `public CaptchaLabel()`
Crea una instancia del componente CAPTCHA con tamaño fijo de `200x60` píxeles. Establece un borde negro y genera un CAPTCHA inicial automáticamente al momento de crear el objeto.

---

### 🔄 Métodos públicos

#### `public void generarCaptcha()`
Genera un nuevo texto aleatorio de CAPTCHA y lo convierte en una imagen con ruido y desenfoque. Llama a `repaint()` para actualizar la visualización del componente.

#### `public String getTexto_Captcha()`
Devuelve el texto actual generado del CAPTCHA, útil para verificar la entrada del usuario en otro componente.

---

### 🔒 Métodos privados

#### `private String generarTextoCaptcha(int Tamaño)`
Genera una cadena aleatoria con la longitud indicada. Los caracteres válidos son letras mayúsculas sin ambigüedad (`A-Z` sin `O`, `I`) y números (`2-9`), lo que facilita la legibilidad por humanos.

#### `private BufferedImage generarImagen_delCaptcha(String text)`
Convierte el texto CAPTCHA en una imagen:
- Pinta el fondo con gris claro.
- Dibuja cada carácter con una posición y color aleatorio.
- Añade 8 líneas de ruido visual con colores aleatorios.
- Aplica un desenfoque con un `Kernel` de 3x3 para dificultar su lectura por bots.

---

### 🎨 Método sobreescrito

#### `protected void paintComponent(Graphics g)`
Sobrescribe el método de `JLabel` para dibujar la imagen generada del CAPTCHA sobre el componente. Se asegura de que la imagen se actualice cada vez que se llama a `repaint()`.

---

# CaptchaTextField - Campo de texto con verificación de CAPTCHA en Java

Este componente extiende `JTextField` y se conecta a un `CaptchaLabel` para verificar automáticamente si el texto ingresado por el usuario coincide con el CAPTCHA generado.

## 🔐 Funcionalidad

- 📥 Campo de texto que escucha acciones (`Enter`) del usuario.
- 🔍 Verifica automáticamente el texto ingresado con el CAPTCHA.
- 🔄 Si la verificación falla, genera un nuevo CAPTCHA y limpia el campo.
- 🖥️ Diseñado para trabajar junto con el componente `CaptchaLabel`.

  
## 🔗 Dependencia

Este componente **requiere** una instancia de `CaptchaLabel` para funcionar correctamente.

## 🚀 Cómo usar

### Crear e integrar los componentes

```java
CaptchaLabel captcha = new CaptchaLabel();
CaptchaTextField textField = new CaptchaTextField();
textField.setCaptchaLabel(captcha);

JPanel panel = new JPanel();
panel.add(captcha);
panel.add(textField);
```
## 🧾 Comportamiento

- El usuario escribe el texto del CAPTCHA.
- Al presionar `Enter`, se compara el texto ingresado con el generado.
- Se muestra un `JOptionPane` con el resultado:

  - ✅ **Correcto:** se notifica al usuario.
  - ❌ **Incorrecto:** se genera uno nuevo y se reinicia el campo.

## ⚙️ Detalles técnicos

- **Herencia:** extiende `JTextField`.
- **Listener:** implementa `ActionListener` para detectar eventos de texto.
- **Comparación:** insensible a mayúsculas/minúsculas (`equalsIgnoreCase`).
- **Integración:** usa el método `setCaptchaLabel(CaptchaLabel label)` para vincular CAPTCHA.
