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

---

## 🚀 Instrucciones de Instalación y Ejecución

Sigue estos pasos exactamente en el orden indicado para configurar el entorno de desarrollo y asegurar el cumplimiento de los requisitos técnicos:

### 1. Clonar el repositorio

Abre tu terminal y ejecuta el siguiente comando para obtener el código fuente:

```bash

git clone [https://github.com/piolin666satan/biblioteca-digital-grupo-6.git](https://github.com/piolin666satan/biblioteca-digital-grupo-6.git)

```

### 2. Entrar al directorio

Accede a la carpeta raíz del proyecto antes de ejecutar cualquier comando de configuración:

cd biblioteca-digital-grupo-6

### 3. Configurar la Base de Datos

Para que Spring Boot 3.2.5 gestione la persistencia, debes configurar el archivo src/main/resources/application.properties. A continuación se presentan los dos escenarios requeridos:

Escenario A: Configuración para PostgreSQL (Producción/Local)

spring.datasource.url=jdbc:postgresql://localhost:5432/alquimia_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Escenario B: Configuración para H2 (Base de datos en memoria para pruebas)

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

### 4. Ejecutar la Aplicación

Una vez configurada la base de datos, compila y ejecuta el backend utilizando el Wrapper de Maven incluido en el proyecto:

# En sistemas Unix/Linux/macOS:

./mvnw spring-boot:run

# En sistemas Windows:

mvnw.cmd spring-boot:run
Nota: El servidor se iniciará por defecto en el puerto 8080. Puedes verificar que la API está activa accediendo a la documentación de Swagger en http://localhost:8080/swagger-ui/index.html.