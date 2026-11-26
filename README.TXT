PROYECTOBYTE - PRUEBA TÉCNICA ANDROID
Katherine Mariela Diéguez Urbina

DESCRIPCIÓN

Aplicación Android desarrollada en Kotlin que consta de dos pantallas:

1. LoginActivity: formulario de usuario y contraseña con validaciones.
   Si los datos son válidos, navega a StatementActivity.

2. StatementActivity: muestra un Toolbar con el título y un botón de logout, un mensaje de
   bienvenida al usuario, el fragmento FragmentStatement y un botón "Confirmar".
   Tanto el logout como "Confirmar" cierran la sesión y regresan al login.

FragmentStatement contiene un RecyclerView con los últimos movimientos
de la cuenta, obtenidos mediante una petición GET al endpoint:
https://91f7b927-de7a-401b-8a73-f0fd9b35764d.mock.pstmn.io/user/statements

REQUISITOS

- Android Studio Rabbit 2
- JDK 17 o superior (incluido con Android Studio)
- SDK mínimo: Android 7.0 (API 24)
- Emulador o dispositivo físico con conexión a internet


INSTRUCCIONES PARA EJECUTAR

1. Clonar el repositorio:
   git clone https://github.com/kdieguez/ProyectoByte.git
   (o en Android Studio: File > New > Project from Version Control y pegar la URL)

2. Abrir la carpeta "ProyectoByte" en Android Studio.

3. Esperar a que termine la sincronización de Gradle (Gradle Sync) que descargará automáticamente
   las dependencias.

4. Seleccionar un emulador o conectar un dispositivo físico.

5. Presionar Run.

El dispositivo necesita conexión a internet para cargar los movimientos.
Si no hay conexión o el servidor falla, la app muestra un mensaje de error.


CREDENCIALES DE PRUEBA

El usuario y la contraseña aceptan cualquier valor que cumpla con las validaciones:

- Usuario y contraseña son obligatorios.
- El usuario debe tener al menos 8 caracteres.
- La contraseña debe tener al menos 6 caracteres.


ESTRUCTURA DEL PROYECTO

app/src/main/java/com/example/proyectobyte/
  - LoginActivity.kt      Pantalla de login, validaciones y navegación.
  - StatementActivity.kt  Toolbar, bienvenida, contenedor del fragment y botón Confirmar.
  - FragmentStatement.kt  Contiene el RecyclerView y consume el endpoint.
  - MovimientoAdapter.kt  Adapter del RecyclerView (formato de monto, fecha y color según
                          DEBIT/CREDIT).
  - Movimiento.kt         Modelos de datos (Movimiento y StatementResponse) que representan el JSON.
  - StatementApi.kt       Definición del endpoint (Retrofit) y cliente.

app/src/main/res/
  - layout/               Layouts de actividades, fragment e item.
  - values/colors.xml     Colores del diseño.
  - values/strings.xml    Textos de la aplicación.
  - menu/                 Menú del Toolbar (botón logout).
  - drawable/             Logo e ícono de logout.


LIBRERÍAS UTILIZADAS

- Retrofit 2 + Gson Converter: consumo del endpoint y conversión del JSON a objetos Kotlin.
- Kotlin Coroutines (lifecycleScope): petición de red fuera del hilo principal, cancelada
  automáticamente si se cierra la pantalla.
- Material Components: TextInputLayout, MaterialToolbar y botones.
- AndroidX RecyclerView y Fragment.