# 🛡️ Componentes-Captcha - Generador y Verificador de CAPTCHA con Swing

Este proyecto proporciona un componente personalizado en Java Swing para la generación y verificación de CAPTCHA. Está diseñado para integrarse fácilmente en interfaces gráficas (GUI) que requieran una verificación básica anti-bot.

---

## ⚠ Ejecutar el componente en una versión JDK 23 o superior 

## 🧩 Componente principal

### 🔠 `CaptchaPanel` - Generador de CAPTCHA

CaptchaPanel es un componente gráfico personalizado en Java Swing diseñado para generar y validar captchas visuales. Este panel puede integrarse fácilmente en cualquier aplicación de escritorio Java que requiera verificación humana.

#### Funcionalidades:
* Generación automática de captchas visuales con letras, números o ambos (configurable).
* Validación automática del texto ingresado por el usuario.
* Regeneración de captchas al fallar la validación o al presionar un botón (opcional).
* **Configuración visual flexible:**
    * Tipo y tamaño de fuente
    * Estilo de letra (`PLAIN`, `BOLD`, `ITALIC`, `BOLD_ITALIC`)
    * Colores del texto, fondo y panel de entrada
    * Líneas decorativas de interferencia
    * Nivel de desenfoque aplicado al captcha
* **Etiquetas configurables:**
    * Texto, color y visibilidad del mensaje de entrada
    * Mensaje de validación (correcto / incorrecto)
* **Restricción de entrada:** El campo de texto acepta solo caracteres alfanuméricos (letras y números).
* Botón recargable opcional con símbolo personalizado y colores ajustables.

---

# CaptchaPanel  - Generador de CAPTCHA en Java

Este componente en Java genera una imagen CAPTCHA personalizada, utilizando `JPanel` de Swing, que puede integrarse fácilmente en interfaces gráficas de usuario (GUI). La imagen contiene texto aleatorio con ruido visual y un filtro de desenfoque para aumentar su seguridad.

## 🧩 Características

- ✅ Texto CAPTCHA configurable (letras, números o combinados).
- 🎨 Personalización de fuente, tamaño, estilo, colores y fondo.
- 🔁 Botón opcional para regenerar el CAPTCHA.
- 🌫️ Opción de desenfoque con diferentes niveles.
- 🖍️ Líneas decorativas para dificultar lectura automática.
- 📐 Ajuste dinámico de tamaño del panel y del CAPTCHA.

## ⚙️ Personalización y propiedades

Puedes modificar fácilmente el comportamiento del captcha a través de sus métodos `set...()`:

| Método                             | Descripción                                             |
|------------------------------------|---------------------------------------------------------|
| `setTipoCaptcha(...)`              | Define si el captcha tiene letras, números o ambos.     |
| `setCaptchaFontSize(...)`           | Cambia el tamaño de la fuente.                         |
| `setCaptchaColor(...)`            | Cambia el color del texto del captcha.                 |
| `setcaptchaColorFondo(...)`        | Cambia el fondo del captcha generado.                  |
| `setColorFondoPanelEntrada(...)`   | Cambia el color del panel donde se ingresa el texto.   |
| `setTextoLabelSuperior(...)`      | Cambia el texto superior ("Ingresa el captcha").        |
| `setColorTextoLabelSuperior(...)` | Cambia el color del texto superior.                   |
| `setColorTextoLabelResultado(...)`| Cambia el color del mensaje de validación.            |
| `setMostrarBotonRecargarCaptcha(...)`| Muestra/oculta el botón de recarga.                    |
| `setBotonColorFondo(...)`          | Cambia el color de fondo del botón.                     |
| `setBotonSimbolo(...)`           | Cambia el símbolo que aparece en el botón.              |
| `setCaptchaBorroso(...)`          | Activa/desactiva el desenfoque.                        |
| `setNivelBorroso(...)`            | Ajusta el nivel del desenfoque aplicado.               |
| `setDibujarLineas(...)`           | Activa o desactiva las líneas decorativas.            |
| `setCantidadLineas(...)`          | Define cuántas líneas se dibujan sobre el captcha.      |

## 📷 Vista previa (simulada)

![Vista Previa del JPanel para el Captcha](Imagenes/CaptchaPanel.png)

## ⚙️ Propiedades Configurables

El componente `CaptchaPanel` permite una amplia personalización a través de sus métodos públicos. A continuación se detallan las propiedades configurables agrupadas por categoría:

### 🖋️ Texto del Captcha

| Propiedad           | Método                             | Descripción                                                                |
|---------------------|------------------------------------|----------------------------------------------------------------------------|
| Longitud del captcha | `setlargoDelCaptcha(int)`         | Define cuántos caracteres tendrá el captcha.                               |
| Tipo de caracteres  | `setTipoCaptcha(CaptchaTipo)`     | Puede ser `SOLO_LETRAS`, `SOLO_NUMEROS` o `COMBINADO`.                     |
| Fuente del texto    | `setTipoLetra(String)`            | Nombre de la fuente (ej: "Arial", "Verdana").                             |
| Estilo del texto    | `setEstilo(EstiloLetra)`          | `PLAIN`, `BOLD`, `ITALIC` o `BOLD_ITALIC`.                               |
| Tamaño de fuente    | `setCaptchaFontSize(int)`          | Define el tamaño del texto del captcha.                                  |

### 🎨 Colores

| Propiedad                   | Método                             | Descripción                                              |
|-----------------------------|------------------------------------|----------------------------------------------------------|
| Color del texto del captcha | `setCaptchaColor(Color)`          | Color del texto generado.                                |
| Color de fondo del captcha | `setcaptchaColorFondo(Color)`      | Fondo sobre el que se dibuja el captcha.                 |
| Color del panel de entrada  | `setColorFondoPanelEntrada(Color)` | Color del panel inferior con el campo de texto.          |
| Color del texto del label superior | `setColorTextoLabelSuperior(Color)` | Color del mensaje que guía al usuario.                  |
| Color del texto de resultado | `setColorTextoLabelResultado(Color)`| Color del mensaje de validación del captcha.             |
| Color del botón de recarga  | `setBotonColorFondo(Color)`        | Fondo del botón para regenerar captcha.                  |
| Color del texto del botón   | `setBotonColorTexto(Color)`        | Texto/icono del botón regenerador.                       |

### 📐 Tamaño

| Propiedad             | Método                          | Descripción                         |
|-----------------------|---------------------------------|-------------------------------------|
| Ancho de imagen captcha | `setcaptchaAnchoImagen(int)`    | Alto del área gráfica del captcha. |
| Largo de imagen captcha | `setcaptchaLargoImagen(int)`   | Ancho del área gráfica del captcha.|

### ✨ Efectos Visuales

| Propiedad               | Método                          | Descripción                               |
|-------------------------|---------------------------------|-------------------------------------------|
| Desenfoque activado     | `setCaptchaBorroso(boolean)`  | Aplica un desenfoque al texto si es `true`. |
| Nivel de desenfoque     | `setNivelBorroso(int)`        | Valor entre 1 y 4 (más alto, más borroso).  |
| Dibujar líneas decorativas | `setDibujarLineas(boolean)` | Dibuja líneas aleatorias en la imagen.    |
| Cantidad de líneas decorativas | `setCantidadLineas(int)`    | Número de líneas a dibujar.               |

### 🔄 Botón de recarga

| Propiedad             | Método                                    | Descripción                                  |
|-----------------------|-------------------------------------------|----------------------------------------------|
| Mostrar botón regenerar | `setMostrarBotonRecargarCaptcha(boolean)` | Muestra u oculta el botón de regenerar.       |
| Texto del botón       | `setBotonSimbolo(String)`                | Personaliza el icono o texto del botón.      |

## 🛠️ Detalles técnicos

### 🔧 Estructura general

El componente `CaptchaPanel` extiende `JPanel` y está compuesto por:

- Un `JLabel` (`captchaImageLabel`) que contiene la imagen generada del CAPTCHA.
- Un `JButton` opcional (`captchaBotonRegenerar`) que permite regenerar el CAPTCHA manualmente.
- Un `Text Field` (`captchaTextField`) donde ingresara el CAPTCHA.
- Un `JLabel` (`labelSuperior`) donde mostrara un texto.
- Un `JLabel` (`labelResultado`) donde se mostrar si el CAPTCHA es correcto o incorrecto.

### 🖼️ Generación del CAPTCHA

El texto del CAPTCHA es generado aleatoriamente según el tipo configurado:

- `SOLO_LETRAS`
- `SOLO_NUMEROS`
- `COMBINADO`

El método `generarCaptcha()` crea:

- Un nuevo texto aleatorio.
- Una imagen (`BufferedImage`) que representa gráficamente el texto.

El resultado se dibuja utilizando `Graphics2D`.

### ✍️ Personalización tipográfica

El texto CAPTCHA se dibuja usando la clase `Font`, con opciones de:

- **Familia** (`captchaTipoLetra`)
- **Tamaño** (`captchaFontSize`)
- **Estilo** (`PLAIN`, `BOLD`, `ITALIC`, `BOLD_ITALIC`)

Se emplea `FontMetrics` para centrar el texto de forma horizontal y vertical.

### 🌈 Efectos visuales

#### 🎨 Líneas decorativas

Líneas aleatorias generadas con `Graphics2D.drawLine()` en posiciones y colores aleatorios, para dificultar la lectura automática.

Controlado mediante:

- `captchaDibujarLineas`
- `captchaCantidadLineas`

#### 🌫️ Desenfoque

Se aplica un filtro de convolución (`ConvolveOp`) sobre la imagen CAPTCHA con un **kernel promedio** para generar un efecto de desenfoque (blur).

- Nivel controlado mediante `captchaNivelBorroso` (0 a 4).

### 📏 Redimensionamiento

Las dimensiones del panel y la imagen se sincronizan usando `Dimension`.

El método `actualizarTamaño()` recalcula los límites del panel al modificar:

- `captchaAncho`
- `captchaLargo`

### 🔄 Botón regenerador

El botón `captchaBotonRegenerar` está oculto por defecto.

Si está habilitado con `setMostrarBotonRecargarCaptcha(true)`, permite regenerar el CAPTCHA manualmente.

Es totalmente personalizable:

- Color de fondo: `setBotonColorFondo`
- Color del texto: `setBotonColorTexto`
- Símbolo o texto: `setBotonSimbolo`
- Estilo visual fijo (borde y espaciado)

### 🎯 Revalidación y repintado

Cada vez que se actualiza una propiedad clave (como el texto, color o tamaño), se ejecutan:

- `generarCaptcha()`
- `revalidate()`
- `repaint()`


## 🧩 Métodos y Constructor de `CaptchaPanel`

### 🛠️ Constructor

#### `public CaptchaPanel()`
Crea una nueva instancia del componente CaptchaPanel, inicializando el layout, generando el primer CAPTCHA y configurando el botón de regeneración (si está habilitado). El JLabel con la imagen se centra automáticamente.

---

## 🛠️ Métodos Públicos

### 🎨 Personalización visual

| Método                             | Descripción                                     |
|------------------------------------|-------------------------------------------------|
| `setcaptchaColor(Color color)`     | Cambia el color del texto del CAPTCHA.        |
| `setcaptchaColorFondo(Color color)`| Cambia el color de fondo del CAPTCHA.        |
| `setCaptchaFontSize(int tamaño)`   | Cambia el tamaño de la fuente del CAPTCHA.     |
| `setTipoLetra(String fuente)`      | Define la fuente (familia tipográfica).       |
| `setEstilo(EstiloLetra estilo)`   | Cambia el estilo del texto (PLAIN, BOLD, etc.). |

---

### 🖋️ Texto del CAPTCHA

| Método                             | Descripción                                                    |
|------------------------------------|----------------------------------------------------------------|
| `setlargoDelCaptcha(int cantidad)` | Define cuántos caracteres tendrá el CAPTCHA.                   |
| `getTexto_Captcha()`               | Devuelve el texto actual del CAPTCHA generado.                |
| `setTipoCaptcha(CaptchaTipo tipo)` | Define si el CAPTCHA tendrá letras, números o ambos.          |

---

### 🖼️ Imagen y tamaño

| Método                             | Descripción                                        |
|------------------------------------|----------------------------------------------------|
| `setcaptchaAltoImagen(int ancho)`  | Define la altura de la imagen del CAPTCHA.        |
| `setcaptchaLargoImagen(int largo)` | Define el ancho de la imagen del CAPTCHA.         |

---

### ✨ Efectos visuales

| Método                             | Descripción                                              |
|------------------------------------|----------------------------------------------------------|
| `setCaptchaBorroso(boolean activar)` | Habilita o desactiva el desenfoque.                     |
| `setNivelBorroso(int nivel)`       | Define el nivel de desenfoque (0-4).                      |
| `setDibujarLineas(boolean activar)` | Activa o desactiva líneas decorativas.                   |
| `setCantidadLineas(int cantidad)`   | Número de líneas decorativas aleatorias.       

---

### 🔄 Botón de recarga

| Método                                       | Descripción                                                 |
|----------------------------------------------|-------------------------------------------------------------|
| `setMostrarBotonRecargarCaptcha(boolean mostrar)` | Muestra u oculta el botón de regenerar CAPTCHA.            |
| `setBotonColorFondo(Color color)`            | Cambia el color de fondo del botón.                        |
| `setBotonColorTexto(Color color)`            | Cambia el color del texto del botón.                        |
| `setBotonSimbolo(String texto)`             | Cambia el símbolo o texto visible en el botón.             |

---

### 🕹️ Control directo

| Método                  | Descripción                                                 |
|-------------------------|-------------------------------------------------------------|
| `generarCaptcha()`      | Fuerza la regeneración de un nuevo texto e imagen CAPTCHA. |
| `getcaptchaImagenLabel()` | Devuelve el `JLabel` que contiene la imagen CAPTCHA.      |

---

## 🔒 Métodos Privados

Los siguientes métodos están encapsulados dentro de la clase y no están diseñados para uso externo, pero son fundamentales para el funcionamiento interno del componente CAPTCHA:

### 🖼️ Generación y visualización

* `generarTextoCaptcha(int tamaño)`
    Genera un texto aleatorio para el CAPTCHA, con el tipo definido (`SOLO_LETRAS`, `SOLO_NUMEROS`, `COMBINADO`).

    Utiliza un `StringBuilder` y una instancia de `Random` para crear el contenido.

* `generarImagen_delCaptcha(String texto)`
    Dibuja el texto sobre una imagen `BufferedImage` con el estilo, color y fuente definidos.

    También añade desenfoque y líneas decorativas si están habilitados.

* `aplicarDesfoque(BufferedImage imagen)`
    Si está activado el desenfoque, aplica una convolución con un kernel personalizado de difuminado.
    El tamaño del kernel depende del nivel de desenfoque configurado.

* `dibujarLineasDecorativas(Graphics2D g, int ancho, int alto)`
    Dibuja líneas aleatorias de colores dentro del área del CAPTCHA como medida anti-bot, si está habilitado.

### 🧱 UI y Layout

* `actualizarEstiloBoton()`
    Aplica el color de fondo, color del texto, símbolo y estilo visual del botón de recarga (`JButton`), incluyendo su borde.

* `actualizarTamaño()`
    Establece el nuevo tamaño del panel según el ancho y alto definidos y fuerza la actualización visual del layout.

---

## ⚙️ Propiedades de `CaptchaPanel`

El componente `CaptchaPanel` ofrece una amplia gama de propiedades configurables para controlar su comportamiento, diseño y estilo. A continuación se describen las principales:

### 🎨 Estilo visual

* `captchaColorLetras` (`Color`)
    Color del texto del CAPTCHA. Se puede modificar con `setcaptchaColor(Color)`.

* `captchaColorFondo` (`Color`)
    Color de fondo del CAPTCHA. Se establece con `setcaptchaColorFondo(Color)`.

* `captchaFontSize` (`int`)
    Tamaño de fuente del texto CAPTCHA. Se modifica con `setCaptchaFontSize(int)`.

* `captchaTipoLetra` (`String`)
    Nombre de la fuente tipográfica (por ejemplo "Arial"). Se cambia con `setTipoLetra(String)`.

* `captchaEstilo` (`EstiloLetra`)
    Estilo de la fuente (`PLAIN`, `BOLD`, `ITALIC`, `BOLD_ITALIC`). Se modifica con `setEstilo(EstiloLetra)`.

### 🔡 Contenido del CAPTCHA

* `captchaTipo` (`CaptchaTipo`)
    Tipo de caracteres que se usarán: solo letras, solo números o una combinación. Modificable con `setTipoCaptcha(CaptchaTipo)`.

* `captchaLargoTexto` (`int`)
    Cantidad de caracteres que tendrá el CAPTCHA. Configurable con `setlargoDelCaptcha(int)`.

### 📏 Dimensiones

* `captchaAncho` (`int`)
    Altura de la imagen CAPTCHA. Modificable con `setcaptchaAltoImagen(int)`.

* `captchaLargo` (`int`)
    Ancho de la imagen CAPTCHA. Modificable con `setcaptchaLargoImagen(int)`.

### ✨ Efectos visuales

* `captchaBorroso` (`boolean`)
    Indica si se aplica efecto de desenfoque. Se habilita con `setCaptchaBorroso(boolean)`.

* `captchaNivelBorroso` (`int`)
    Nivel del desenfoque (de 1 a 4). Se ajusta con `setNivelBorroso(int)`.

* `captchaDibujarLineas` (`boolean`)
    Si se deben dibujar líneas aleatorias sobre la imagen para dificultar la lectura automatizada. Se activa con `setDibujarLineas(boolean)`.

* `captchaCantidadLineas` (`int`)
    Número de líneas decorativas aleatorias. Modificable con `setCantidadLineas(int)`.

### 🔄 Botón de regeneración

* `captchaMostrarBoton` (`boolean`)
    Muestra u oculta el botón para regenerar el CAPTCHA. Se activa con `setMostrarBotonRecargarCaptcha(boolean)`.

* `botonColorFondo` (`Color`)
    Color de fondo del botón de regenerar. Se modifica con `setBotonColorFondo(Color)`.

* `botonColorTexto` (`Color`)
    Color del texto (símbolo) del botón. Modificable con `setBotonColorTexto(Color)`.

* `botonSimbolo` (`String`)
    Texto o símbolo que se muestra en el botón. Cambiable con `setBotonSimbolo(String)`.

---

# 🖥️ Aplicacion_Componentes - Interfaz Gráfica de Prueba para CAPTCHA

`Aplicacion_Componentes` es una clase que extiende `JFrame` y actúa como una interfaz de prueba para los componentes personalizados `CaptchaLabel` y `CaptchaTextField`. Esta aplicación proporciona una ventana gráfica funcional que simula un escenario real de verificación de CAPTCHA usando Java Swing.

---

## 🎯 Funcionalidad principal

- Muestra un CAPTCHA generado aleatoriamente (`CaptchaLabel`).
- Permite al usuario ingresar el texto del CAPTCHA en un campo de texto (`CaptchaTextField`).
- Verifica automáticamente la entrada al presionar `Enter`.
- Ofrece un botón para **refrescar el CAPTCHA manualmente**.

---

## 🧩 Componentes usados

| Componente           | Descripción                                                                 |
|----------------------|-----------------------------------------------------------------------------|
| `CaptchaPanel`       | Componente gráfico que muestra el CAPTCHA generado.                        |

---

## ⚙️ Detalles de implementación

### 🏗️ Constructor

```java
public Aplicacion_Componentes()
```

### 🧪 Logica de verificación
El campo de texto (CaptchaTextField) se conecta al CaptchaLabel para que, al presionar Enter, verifique automáticamente el texto ingresado.
Si la verificación falla, el propio componente se encarga de mostrar un mensaje y generar un nuevo CAPTCHA.

### 🖼️ Diseño gráfico
La ventana contiene los siguientes elementos organizados con GroupLayout dentro de un JPanel:
Imagen CAPTCHA al centro.
Campo de texto justo debajo.
Botón para refrescar el CAPTCHA en la parte inferior.
🎨 Fondo rosado claro (RGB: 255, 204, 204) y botón verde claro para mejorar la visibilidad del CAPTCHA.

## 📷 Vista previa (simulada)

![Vista Previa del JLabel para el Captcha](Imagenes/JFrame_Componentes.png)
---
# 📦 Instalación de los Componentes CAPTCHA
1. **Clona o copia los archivos de clase:**
   - `CaptchaLabel.java`
   - `CaptchaTextField.java`

2. **Agrega las clases a tu proyecto Java Swing** dentro del paquete `Captcha_Componentes` o el nombre de paquete que prefieras (recuerda modificar las importaciones si cambias el nombre).

3. **Crea una ventana o formulario** (`JFrame`) donde usarás los componentes.

4. **Agrega e inicializa los componentes en tu clase principal:**

```java
CaptchaLabel captcha = new CaptchaLabel();
CaptchaTextField textField = new CaptchaTextField();
textField.setCaptchaLabel(captcha); // Conexión entre el campo y la imagen

JPanel panel = new JPanel();
panel.add(captcha);
panel.add(textField);
```
## 🧩 Agregar Componentes a la Paleta de NetBeans

Esta guía te explica cómo integrar los componentes personalizados `CaptchaLabel` y `CaptchaTextField` en la paleta de NetBeans para que puedas arrastrarlos y usarlos visualmente desde el GUI Builder.

---
### 1. Compila el proyecto ###

Asegúrate de que tu proyecto esté compilado correctamente para que NetBeans pueda detectar las clases:

![Compilar el proyecto de los Componentes](Imagenes/Compilacion_Componentes.png)

---

### 2. Abre la paleta de componentes

1. Abre cualquier formulario (`.java`) que use Swing con el diseñador gráfico.
2. En el borde derecho, ubica la **Paleta** (si no se ve, ve a `Window → Palette`).

![Abre la Paleta](Imagenes/Paleta.png)

![Abrir el administrador de la Paleta](Imagenes/Agregar_Componentes.png)

---

### 3. Agrega un nuevo componente

1. En la parte superior de la paleta, haz clic en el icono **"Agregar desde archivo JAR o Clase"** (ícono de engranaje o clic derecho sobre la paleta → `Add from JAR...` o `Add from Project Class`).
2. Selecciona la clase personalizada:
   - Busca `CaptchaLabel.class` o `CaptchaTextField.class` desde el directorio `build/classes/Captcha_Componentes` o donde esté compilado tu `.class`.
   - También puedes navegar hasta el archivo `.java` si eliges “Add from Project Class”.

![Busca el JRar](Imagenes/Agregar_Componentes2.png)

![Seleciona los Componentes que deseas agregar](Imagenes/Agregar_Componentes3.png)

---

### 4. Selecciona la categoría

- NetBeans te preguntará en qué categoría de la paleta agregar los componentes.
- Puedes crear una nueva, por ejemplo: `Captcha Componentes`.

![Selecciona la categoria](Imagenes/Agregar_Componentes4.png)

---

### 5. ¡Listo! Usa tus componentes

- Ahora podrás arrastrar `CaptchaLabel` y `CaptchaTextField` directamente desde la paleta al formulario visual.
- El código generado automáticamente usará tus clases personalizadas.

![Yapuedes ocupar los componentes](Imagenes/Final.png)

---
## 🔗 Link del video: https://youtu.be/-SWGKzD9weU

---

# Autores

- Méndez García Ángel de Jesús
- Pérez Jiménez Santiago Enmanuel 
