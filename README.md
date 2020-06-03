## Resumen

Proyectos utilizados para explicar la configuraci�n del servidor de registro y descubrimiento Eureka

## ServicioClientes

Proyecto SpringBoot que publica un servicio REST en el que los recursos son los Clientes.

El servicio escucha en el puerto 8090 y el api es:

* get clientes
* get clientes/{login}
* post clientes
* put clientes/{login}
* delete clientes/{login}

Esta aplicaci�n utiliza una base de datos H2. El el fichero de configuraci�n se indica que est� en c:/H2

## Servicio pedidos

Proyecto SpringBoot que publica un servicio REST en el que los recursos son los Pedidos

Escucha en el 8100 de localhost y el api es:

* get pedidos
* get pedidos/{id}
* post pedidos
* put pedidos/{id} (no implementado en la l�gica de negocio)
* delete pedidos/{id} (nom implementado en la l�gica de negocio)

Esta aplicaci�n utiliza una base de datos H2. El el fichero de configuraci�n se indica que est� en c:/H2

##EurekaServer

Proyecto SpringBoot que levanta el servidor Eureka en el puerto 8084 de localhost

##Instrucciones para arrancar las aplicaciones

* Colocar las bases de datos en C:/H2 (si se colocan en otro sitio modificar los ficheros application.properties)
* Ejecutar los main (est�n en el paquete com.curso de los tres proyectos)
* Enviar una petici�n POST a localhost:8100 con content/type 'application/json' y el siguiente documento en el body:

{
	"codigo"  : "PED-0",
	"fecha"   : "Hoy",
	"estado"  : "Pendiente",
	"cliente" : {
		"login" : "monty@hotmail.com"
	}
}

