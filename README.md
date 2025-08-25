# 📱 LectorAmigo

Aplicación móvil desarrollada en **Android Studio con Kotlin y Jetpack Compose** como parte de la asignatura **DSY2204 – Desarrollo de Aplicaciones Móviles** (Semana 2).

## Descripción

**LectorAmigo** es una app de accesibilidad para personas con discapacidad visual.  
Permite **registrar usuarios**, **iniciar sesión** y **recuperar contraseña** de manera simple, utilizando componentes de **Material Design** y **Jetpack Compose**.

El proyecto busca facilitar la comunicación (escribir y leer) en el entorno cotidiano de los usuarios, integrando accesibilidad y usabilidad.

##  Funcionalidades

- Pantalla de **Login** con validación de credenciales.
- Pantalla de **Registro** con almacenamiento en un **array/lista simulada** de hasta 5 usuarios.
- Pantalla de **Recuperar contraseña**, que busca el usuario y muestra su contraseña registrada.
- Pantalla de **Home** con mensaje de bienvenida y opción de cerrar sesión.
- **Navegación** entre pantallas usando `NavHost` y `NavController`.
- **Validaciones** de entrada (usuario vacío, contraseñas que no coinciden, límite de usuarios).
- **Animación Lottie** en la pantalla de login para mejorar la experiencia visual.

##  Tecnologías utilizadas

- [Android Studio](https://developer.android.com/studio)
- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Material Design 3](https://m3.material.io/)
- [Lottie for Compose](https://airbnb.io/lottie/#/android-compose)

##  Estructura del proyecto

```
app/
 ├── java/com/example/lectoramigo
 │   ├── MainActivity.kt        # Punto de entrada y NavHost
 │   └── pantallas/
 │       ├── login.kt           # Pantalla de login
 │       ├── registro.kt        # Pantalla de registro
 │       ├── recuperar.kt       # Pantalla de recuperar contraseña
 │       └── home.kt # Pantalla principal tras login
 └── res/
     ├── drawable/              # Iconos e imágenes
     ├── raw/                   # Animación Lottie (JSON)
     └── values/                # Colores, temas y estilos
```

##  Instalación y ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/VaneSuazoU/LectorAmigo.git
   ```
2. Abrir el proyecto en **Android Studio**.
3. Sincronizar dependencias de **Gradle**.
4. Ejecutar en un **emulador** o dispositivo físico Android.

##  Requerimientos cumplidos

- [x] Login, Registro y Recuperar contraseña.
- [x] Uso de Material Design y Jetpack Compose.
- [x] Almacenamiento de hasta 5 usuarios en array/lista.
- [x] Navegación entre pantallas con `NavHost`.
- [x] Documentación y repositorio GitHub.

##  Restricciones

- El almacenamiento de usuarios es **temporal en memoria** (no persistente).

##  Riesgos identificados

1. Pérdida de usuarios al cerrar la app (no persistencia).


##  Autora

- **Vanessa Suazo**  
  Ingeniería en Desarrollo de Software – Duoc UC.

