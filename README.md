
# Proyecto Simulación de Cajero Automático

Este proyecto es una simulación de un cajero automático simple en Java. El proyecto sigue un modelo basado en diferentes paquetes para organizar las clases relacionadas con el cajero, las cuentas y los servicios disponibles.

## Estructura del Proyecto

El proyecto está dividido en los siguientes paquetes:

- **`modelo`**: Contiene las clases que representan el modelo de negocio, como `Cuenta`, `Cliente` y `Transaccion`.
- **`servicio`**: Contiene las clases que gestionan la lógica del negocio, como `ServicioCajero` y `ServicioCuenta`.
- **`interfaz`**: Contiene las clases relacionadas con la interacción del usuario, como `PantallaCajero`, `TecladoCajero` e `InterfazUsuario`.
- **`excepciones`**: Contiene clases para gestionar excepciones personalizadas, como `FondosInsuficientesException`.
- **`utilidades`**: Incluye clases utilitarias como `Validaciones` para manejo de validaciones comunes.

## Requisitos del Sistema

- Java Development Kit (JDK) 8 o superior
- Un entorno de desarrollo como IntelliJ IDEA, Eclipse o cualquier otro IDE que soporte Java.

## Configuración del Proyecto

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/tu_usuario/proyecto_cajero.git
   ```

2. **Importar el proyecto en tu IDE**:

   Si usas IntelliJ IDEA o Eclipse, puedes importar el proyecto como un proyecto de Java estándar.

3. **Configurar las dependencias**:

   No se requieren dependencias externas para este proyecto.

4. **Compilar el proyecto**:

   Si estás utilizando la terminal, asegúrate de estar en el directorio raíz del proyecto y ejecuta:

   ```bash
   javac -d bin $(find . -name "*.java")
   ```

5. **Ejecutar el programa**:

   Puedes ejecutar el programa principal utilizando la siguiente línea de comandos en la carpeta `bin`:

   ```bash
   java proyecto_cajero.Main
   ```

## Uso del Programa

1. El usuario debe ingresar su PIN para iniciar sesión.
2. Una vez autenticado, el usuario podrá realizar las siguientes operaciones:
   - Consultar saldo
   - Realizar un retiro
   - Hacer un depósito
   - Salir del cajero

### Ejemplo de Uso

```bash
Ingrese su PIN: ****
¡Bienvenido!

Seleccione una opción:
1. Consultar saldo
2. Retirar dinero
3. Depositar dinero
4. Salir
```

## Excepciones

El proyecto gestiona las siguientes excepciones personalizadas:

- **FondosInsuficientesException**: Se lanza cuando el saldo disponible en la cuenta no es suficiente para realizar un retiro.

## Estructura del Código

El proyecto está organizado de la siguiente manera:

```plaintext
src/
├── excepciones/
│   └── FondosInsuficientesException.java
├── interfaz/
│   ├── InterfazUsuario.java
│   ├── PantallaCajero.java
│   └── TecladoCajero.java
├── modelo/
│   ├── Cliente.java
│   ├── Cuenta.java
│   └── Transaccion.java
├── servicio/
│   ├── ServicioCajero.java
│   └── ServicioCuenta.java
└── utilidades/
    └── Validaciones.java
```

## Contribuciones

1. Haz un **fork** del proyecto.
2. Crea una nueva rama para tu funcionalidad (`git checkout -b nueva-funcionalidad`).
3. Realiza los cambios y crea un **commit** (`git commit -m 'Agrega nueva funcionalidad'`).
4. Empuja tus cambios (`git push origin nueva-funcionalidad`).
5. Crea un nuevo **Pull Request**.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para obtener más detalles.
