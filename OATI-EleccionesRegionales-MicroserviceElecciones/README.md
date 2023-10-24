<br />
<div align="center">
<h3 align="center">ELECCIONES REGIONALES</h3>
  <p align="center">
      En este microservicios de elecciones se guarda, modifica y elimina las entidades participantes de la elección, como son los candidatos selectos y sus partidos, además de contener los sufragios por parte de los ciudadanos, todo esto mediante la autorización de un token generado por el microservicio de usuarios, además este microservicio es capaz de listar los votos y dado el caso dar un resultado final, y esto contruido bajo la arquitectura de Puertos y Adaptadores (Hexagonal).
   </p>
</div>

### Construido con

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)


<!-- GETTING STARTED -->
## Getting Started

Para correr de forma local este proyecto verifique la siguiete información y siga los pasos.

### Prerequisitos

* JDK 17 [https://jdk.java.net/java-se-ri/17](https://jdk.java.net/java-se-ri/17)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)
* MySQL [https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)

### Herramientas recomendadas
* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

### Instalación
Estando ya ubicado en el microservicio de elecciones después de clonar el repositorio:
1. Ejecute el script de "scriptCreateDB" en la ubicación (src/main/resources/scriptCreateDB.sql).
4. Actualice la información de la configuración de la conexión de la base de datos
   ```yml
   # src/main/resources/application-dev.yml
   spring:
      datasource:
          url: jdbc:mysql://localhost/elecciones_dbelecciones
          username: root
          password: <your-password>
   ```
5. Después de que las tablas estén creadas ejecute src/main/resources/scriptInitialDBFill.sql , contiene la un llenado inicial de la base de datos.
6. Abra Swagger UI y busque el endpoint que quiera usar, recuerde que necesita tener un token generado del microservicio de usuarios.


<!-- USAGE -->
## Utilización

1. Click derecho en la clase OATIApplication y seleccione "Run".
2. Abra [http://localhost:8091/swagger-ui/index.html](http://localhost:8090/swagger-ui/index.html) en su navegador para interactuar con el microservicio de Elecciones.

<!-- ROADMAP -->
## Tests

- Click derecho en la carpeta de test y seleccione Run.

## Funcionalidad
![img.png](ResourseReadme/ModeloRelacional.png)