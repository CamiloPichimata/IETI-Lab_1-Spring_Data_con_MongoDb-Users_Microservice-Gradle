# Laboratorio 2: Spring Data con MongoDb

## Inovación y Emprendimiento con Tecnologías de Información

#### Camilo Andrés Pichimata Cárdenas

##### Septiembre del 2022

## Objetivos

- Explicar qué es MongoDB.

- Explicar la diferencia entre SQL y NoSQL.

- Crear un clúster de MongoDB en Atlas.

- Conectar su proyecto Spring Boot con un cluster MongoDB.

## Temas Principales

- NoSQL.

- MongoDB.

- Cluster.

## Desarrollo

### Parte 1: Creación de la cuenta en Atlas y primer clúster:

Se realizó el registro con la cuenta de GitHub, para esto se configuró el correo vinculado a GitHub como público, luego se aceptaron los términos de servicio y política de privacidad de la aplicación. 

<img src='img/account_created.png'>

Seguido a esto damos click en el botón `Build a Database`

<img src='img/database_selection.png'>

Seleccionamos la opción gratuita.

<img src='img/configuration_new_cluster.png'>

En este caso dejaremos las configuraciones de proveedor de nube, región y nivel del cluster seleccionadas por defecto

<img src='img/create_cluster.png'>

Asignamos un nombre al nuevo cluster y damos click en el botón `Create Cluster`

<img src='img/user_connection.png'>

Seleccionamos como nos gustaría validar la conexión al cluster, en este caso seleccionamos Usuario y Contraseña, seguido a esto ingresamos las credenciales y creamos un usuario dando click en el botón `Create User`

<img src='img/ip_access_list.png'>

Agregamos las direcciones IP desde las que nos conectaremos al cluster, nos desplazamos hacia abajo y damos click en el botón `Finish and Close`.

<img src='img/cluster_created.png'>

### Parte 2: Conexión del clúster MongoDB con Spring Boot

Para conectar el cluster creado anteriormente damos click en el botón `Connect`

<img src='img/cluster_connect.png'> 

Seleccionamos la segunda opción, `Connect your application`

<img src='img/cluster_connect-2.png'> 

En los menús desplegables, seleccionamos el driver para Java y la última versión disponible, luego damos click en el botón `Close`

<img src='img/cluster_connect-3.png'> 

Seguido a esto agregamos una variable de entorno al archivo ***application.properties*** con el fin de almacenar el URI de MongoDB agregando la siguiente línea: 

```conf
spring.data.mongodb.uri=${MONGODB_URI}
```

En IntelliJ Idea damos click derecho sobre la carpeta que contiene el proyecto y seleccionamos la opción `Modify Run Configuration...` con el fin de agregar la variable de entorno a las configuraciones de ejecución

<img src='img/cluster_connect-4.png'> 

Si damos click en el emoticón del campo de texto *Environment variables* se abre una nueva ventana (A la derecha) en la que podemos definir el link de conexión generado al escojer el driver y versión para Java, en este debemos reemplazar ***<password>*** por la contrasena especificada al crear el usuario ***camilopichimata***

<img src='img/cluster_connect-5.png'> 

Finalmente agregamos la dependencia *Spring Boot starter data MongoDB* al archivo ***build.gradle*** y ejecutamos la aplicación para verificar que la conexión se realizó satisfactoriamente 

```conf
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-mongodb'
}
```

Con el fin de evadir futuros problemas en la conexión a la base de datos, vamos a permitir que se pueda conectar al cluster desde cualquier dirección IP para esto estando en la pantalla principal de la interfaz de MongoDB en la parte izquierda seleccionamos la opción `Network Access`

<img src='img/network_access.png'> 

Damos click en el botón `+ADD IP ADDRESS`, en la ventana que aparece damos click en el botón `ALLOW ACCESS FROM ANYWHERE`, al hacer esto, se debe ver **0.0.0.0/0** en la lista de accesos.

<img src='img/network_access-2.png'> 

Finalmente damos click en el botón `Confirm` para guardar la configuración realizada y podremos ver que esta entrada aparece en el listado junto con la anteriormente especificada.

<img src='img/network_access-3.png'> 

### Parte 3: Implementación del servicio MongoDB


