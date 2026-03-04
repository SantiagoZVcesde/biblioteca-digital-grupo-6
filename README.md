# Alquimia Literaria

Insentivar a la gente a entrar a un mundo de fantasías desde sus cómodos hogares.

---

## Introducción / Contexto

- Facilitar la accesibilidad a la lectura de libros mediante una plataforma digital intuitiva y moderna.  
- **Justificación:** Este proyecto es relevante porque fomenta el hábito lector en entornos digitales, aporta valor educativo al facilitar el acceso a contenido literario y permite aplicar conocimientos de desarrollo de software moderno en un contexto real.  
- **Dominio:** Plataforma web de lectura digital donde los usuarios podrán explorar libros, organizarlos y leerlos desde cualquier dispositivo.

---

## Objetivos

**Objetivo General**  
Desarrollar una plataforma web que facilite el acceso a la lectura digital mediante una experiencia intuitiva, accesible y atractiva para los usuarios.

---

**Objetivos Específicos**  
- Diseñar una arquitectura backend robusta basada en Spring Boot y arquitectura por capas.
- Implementar autenticación y gestión de usuarios.
- Crear un catálogo digital de libros con funcionalidades de búsqueda y filtrado.
- Desarrollar una interfaz frontend moderna y responsiva.
- Integrar una base de datos relacional para almacenamiento persistente de la información.

---

## Alcance del Proyecto (Scope)

**Qué se va a desarrollar:**  
- Registro e inicio de sesión de usuarios.  
- Catálogo digital de libros.
- Búsqueda y filtrado por título, autor o género.
- Vista detallada de cada libro.
- Sistema básico de lectura dentro de la plataforma.
- Panel administrativo básico para gestión de libros.
- API REST documentada.

---

**Qué NO se va a desarrollar en esta versión (fuera de alcance):**  
- Sistema de pagos o suscripciones.  
- Version Aplicacion movil.  
- Lectura offline.  
- Recomendaciones avanzadas con inteligencia artificial.
- Funcionalidades sociales (comentarios o comunidad).
- Audiolibros.

---

## Tecnologías y Herramientas (Tech Stack)

- **Backend:** Spring Boot 3.x, Java 21, Spring Data JPA, PostgreSQL
- **Frontend:** React
- **Base de datos:** Prisma, PostgreSQL en producción / H2
- **Otras herramientas:** Git, GitHub, Postman, Swagger, Docker (posible implementación futura)

---

## Integrantes del Equipo

| Nombre                  | Rol principal              | Usuario GitHub     |
|-------------------------|----------------------------|--------------------|
| Santiago Sánchez Rojas  | Líder / Backend            | @piolin666satan    |
| Santiago Zapata Villada | Frontend Lead              | @SantiagoZVcesde   |
| [Nombre 3]              | Backend / Base de datos    | @[usuario]         |
| [Nombre 4]              | [rol]                      | @[usuario]         |   

---

## Diagrama de Clases del Dominio (v1)

![Diagrama de Dominio v1](docs/diagrama-dominio-v1.png)  
*Diagrama inicial del modelo de dominio – versión 1. Se actualizará en futuras entregas.*

---

## 🚀 Instrucciones de Instalación y Ejecución

Sigue estos pasos para configurar el entorno de desarrollo y ejecutar el proyecto **Alquimia Literaria** localmente.

### Prerrequisitos

Asegúrate de tener instalado lo siguiente:

* **Java JDK 21:** Necesario para el backend. Verifica con `java -version`.
* **Maven:** Gestor de proyectos Java. Verifica con `mvn -v`.
* **PostgreSQL:** Versión 14 o superior.
* **Node.js & npm:** (Solo para la carpeta del frontend).
* **Git:** Para clonar el repositorio.

### Pasos para la Instalación

1.  **Clonar el repositorio**
    ```bash
    git clone [https://github.com/piolin666satan/biblioteca-digital-grupo-6.git](https://github.com/piolin666satan/biblioteca-digital-grupo-6.git)
    cd biblioteca-digital-grupo-6
    ```

2.  **Configurar la Base de Datos**
    Crea una base de datos en PostgreSQL llamada `alquimia_db`. Luego, ubica el archivo `src/main/resources/application.properties` (o crea un `application-dev.properties`) y configura tus credenciales:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/alquimia_db
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Compilar y Ejecutar el Backend (Spring Boot)**
    Desde la raíz del proyecto backend:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4.  **Configurar y Ejecutar el Frontend (React)**
    En una nueva terminal, navega a la carpeta del frontend:
    ```bash
    cd frontend-folder # Reemplaza con el nombre real de tu carpeta
    npm install
    npm run dev
    ```

### Acceso a la API
Una vez que el servidor esté corriendo, puedes consultar la documentación de los endpoints en:
`http://localhost:8080/swagger-ui/index.html`

### Ejecutar la Aplicación

Una vez configurada la base de datos, puedes ejecutar la aplicación:

**Modo desarrollo:**
```bash
npm run dev