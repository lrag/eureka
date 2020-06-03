## Resumen

Proyectos utilizados para explicar la configuración del servidor de registro y descubrimiento Eureka

## ServicioClientes

Proyecto SpringBoot que publica un servicio REST en el que los recursos son los Clientes.

El servicio escucha en el puerto 8090 y el api es:

* get clientes
* get clientes/{login}
* post clientes
* put clientes/{login}
* delete clientes/{login}

Esta aplicación utiliza una base de datos H2. El el fichero de configuración se indica que está en c:/H2

## Servicio pedidos

Proyecto SpringBoot que publica un servicio REST en el que los recursos son los Pedidos

Escucha en el 8100 de localhost y el api es:

* get pedidos
* get pedidos/{id}
* post pedidos
* put pedidos/{id} (no implementado en la lógica de negocio)
* delete pedidos/{id} (nom implementado en la lógica de negocio)

Esta aplicación utiliza una base de datos H2. El el fichero de configuración se indica que está en c:/H2

##EurekaServer

Proyecto SpringBoot que levanta el servidor Eureka en el puerto 8084 de localhost

##Instrucciones para arrancar las aplicaciones

* Colocar las bases de datos en C:/H2 (si se colocan en otro sitio modificar los ficheros application.properties)
* Ejecutar los main (están en el paquete com.curso de los tres proyectos)
* Enviar una petición POST a localhost:8100 con content-type 'application/json' y el siguiente documento en el body:

{
	"codigo"  : "PED-0",
	"fecha"   : "Hoy",
	"estado"  : "Pendiente",
	"cliente" : {
		"login" : "monty@hotmail.com"
	}
}

