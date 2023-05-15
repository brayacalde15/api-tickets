## API_TICKETS

Cree un API de generar Tickets , el lenguaje que utilice fue java y el framework fue Spring boot.
El API permite crear,eliminar,editar y recuperar tickets ,Tambien se puede filtrar por todos los tickets o alguno en especifico.

## Instalación

1.  Primeramente deberas crear la base de Datos en Mysql.

    - Como crear Base de Datos dd MYSQL EN linux :

               1. Accede a la línea de comando MySQL debes ejecutar este comando en la terminal MYSQL -U ROOT -P.
               2. Crea la base de datos con el siguiente comando en la terminal
                  CREATE DATABASE <Nombre de la base de datos>; En este caso seria api_tickets.
               3. Para saber si se creo correctamente la base de datos deberas ejecutar este comando:
                  SHOW DATABASE;
               4. Vas a crear la tabla ticket y la tabla user con el siguiente query:

                  use api_tickets;

                  CREATE TABLE user(
                  user_id INT PRIMARY KEY auto_increment NOT NULL,
                  user_name VARCHAR(120) NOT NULL );

                  CREATE TABLE ticket(
                  ticket_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                  user_id INT NOT NULL,
                  creation_date TIMESTAMP NOT NULL,
                  updated_date TIMESTAMP NOT NULL ,
                  FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE ON UPDATE CASCADE
                  );

                  El comando use api_tickets es para elegir la base de datos que vas a usar.

               5. Luego deberas agregar la base de datos al backend :

               spring.jpa.hibernate.ddl-auto=update

      spring.datasource.url=jdbc:mysql://localhost:3306/api_tickets
      spring.datasource.username=root
      spring.datasource.password=12345678
      spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

      Este archivo lo encuentras en la ruta src/application.properties,en el password colocas el password que tu hayas agregado inicalmente en tu motor de base de datos.

      6. Dentro de la carpeta src vas a encontrar un archivo llamado main esa ruta que que se presenta ahi ya viene creada desde que creas el proyecto en spring boot luego vas a abrir la carpeta data.
         Dentro de la carpeta data hay otra carpeta llamada Models , ahi encontraras el modelo ticket y el modelo ticket information. En el modelo ticket encontramos lo siguiente :

      -package com.api.tickets.apitickets.data.models;

                 import java.sql.Timestamp;

                 import jakarta.persistence.Entity;
                 import jakarta.persistence.GeneratedValue;

                 import jakarta.persistence.Id;

                 @Entity


                 public class Ticket {
                      @Id
                     @GeneratedValue
                     private Integer ticketId;
                     private Integer userId;
                     private Timestamp creationDate;
                     private Timestamp updatedDate;
                     public Integer getTicketId() {
                         return ticketId;
                     }
                     public void setTicketId(Integer ticketId) {
                         this.ticketId = ticketId;
                     }
                     public Integer getUserId() {
                         return userId;
                     }
                     public void setUserId(Integer userId) {
                         this.userId = userId;
                     }
                     public Timestamp getCreationDate() {
                         return creationDate;
                     }
                     public void setCreationDate(Timestamp creationDate) {
                         this.creationDate = creationDate;
                     }
                     public Timestamp getUpdatedDate() {
                         return updatedDate;
                     }
                     public void setUpdatedDate(Timestamp updatedDate) {
                         this.updatedDate = updatedDate;
                     }



                 }

              En el modelo TicketInformation encontramos :

                   public class TicketInformation {

                   private int userId;

                    public int getUserId() {
                    return userId;
                    }

                    public void setUserId(int userId) {
                    this.userId = userId;
                    }

                  }

      7.  En el archivo ApiTicketsApplication.java encontras los endpoint que utilizamos para los procesos que vamos a realizar con los tickets , el archivo se llama :
          ApiTicketsApplication.java.

## EJECUTAR LA APLICACIÓN

1. Para poder correr la aplicación lo puedes hacer desde el proyecto o con este comando desde la terminal. El comando es : ./gradlew bootRun , este comando se utiliza para el sistema operativo  MacOs o para linux.

## COLECCION POSTMAN 

1. Este es el archivo que se debe importar en el PostMan :

   - api-tickets.postman_collection.json
