<h1>API rest TGAREST</h1>
Esta api está desarrollada en Java con Spring Boot. Es parte del proyecto de la aplicación movil desarrollada en Flutter "texasgrill_app". Ya que este es mi primer proyecto en Spring Boot se ha introducido ciertas funcionalidades como
la autenticación con spring security usando JWT. Esta funcionalidad solo sirve token de acceso, aunque más tarde se pretende implementar los refresh token. Este proyecto ha sido desarrollado solo por mí y pretendo seguir avanzando y haciendolo más
grande con el tiempo.
<hr/>
<h3>Configuración del proyecto</h3>
Para poder probarlo primero tienes que ejecutar el script sql que se encuentra en la raíz del proyecto para generar la estructura y los datos de la base de datos.
Luego tendrás que configurar el archivo "application.properties" del proyecto spring.<br/>
spring.jpa.database=mysql<br/>
spring.jpa.hibernate.ddl-auto=none<br/>
server.port=3030 ----> Introducir un el puerto que se desee.<br/>
server.address=192.168.184.27 ----> la ip de tu maquina donde estará en funcionamiento la API.<br/>
spring.jpa.show-sql: true<br/>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver<br/>
spring.datasource.url=jdbc:mysql://localhost:3306/tga_db ------> la ruta donde estará la base de datos con el puerto donde se tiene configurado<br/>
spring.datasource.username=root ------> usuario de la base de datos<br/>
spring.datasource.password= qqklwjdqoi --------> contraseña del usuario correspondiente para la base de datos<br/>
