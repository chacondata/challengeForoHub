Foro Hub

Resultado del Challenge Practicando Spring Framework: Foro Hub que consiste en la creación de una API REST usando Spring.
El objetivo es replicar la a nivel de Back End el funcionamiento de un Foro en el cual un grupo de personas (Usuarios) puedan
acudir a consultar sus dudas (Tópicos) sobre temas específicos (Cursos) esperando que otras personas generen posibles soluciones
a estas dudas (Respuestas). 

La API se centra especialmente en los Tópicos y permite a los usuarios:
•	Crear un nuevo tópico
•	Mostrar todos los tópicos creados
•	Mostrar un tópico específico
•	Actualizar un tópico
•	Eliminar un tópico

También permite:
•	Registrar Cursos
•	Registrar Respuestas a los Topicos
•	Listar los Cursos 
•	Validar las credenciales de los Usuarios (Login /Generar Token)

Las pruebas se realizaron con Insomnia. Generandose los respectivos request.

![image](https://github.com/user-attachments/assets/ed915f66-2ae1-44f6-97f7-4edc75d492f6)

La API REST presenta las siguientes funcionalidades
1.	API con rutas implementadas siguiendo las mejores prácticas del modelo REST;
2.	Validaciones realizadas según reglas de negocio;
3.	Implementación de una base de datos para la persistencia de la información;
4.	Servicio de autenticación/autorización para restringir el acceso a la información.
   
El proyecto se creo con Spring Initializr con las siguientes configuraciones:
•	Java (versión 17 )
•	Maven (versión 4)
•	Spring Boot
•	Proyecto en formato JAR

Se agregaron las siguientes dependencias
•	Lombok
•	Spring Web
•	Spring Boot DevTools
•	Spring Data JPA
•	Flyway Migration
•	MySQL Driver
•	Validation
•	Spring Security

La base de datos se creo en MySQL con una estructura como la que se muestra
![image](https://github.com/user-attachments/assets/4cbba1c8-3d5c-4946-8298-e77b8705680d)





