# Chat-RMI-Java

Este es un proyecto creado en Netbeans que permite el envio de mensajes de varios usuarios a un servidor que posteriormente mediante un callback le hace llegar los mensajes a todos los usuarios conectados, ademas tiene un administrador que puede consultar cuantos usuarios hay conectados y cuantos mensajes por minuto llegan al servidor. Consta de 3 paquetes principales:

### Cliente
  * sop_rmi: Aqui encontrara la interfaz del usuario y su implementacion  que le permite al servidor hacer un callback de los mensajes y ademas notificar a los usuarios cuando un usuario nuevo se conecta
  * utilidades: Aqui encontrara las clase que le permite al cliente obtener la referencia del objeto remoto del servidor
  * vista: Aqui se encuentra la GUI del usuario
### Administrador
  * vista: GUI del administrador
  * utilidades: Aqui encontrara las clase que le permite al administrador obtener la referencia del objeto remoto del servidor
### Servidor
  * entities: En este paquete hay una clase para almacenar los mensajes y la fecha en la que llegan al servidor
  * sop_rmi: En este paquete se encuentra las interfaces y su implementacion de los objetos remotos que le permiten a los usuarios y al administrador conectarse
  * utilidades: Aqui se encuentran las clases para que el servidor pueda arrancar el RMI registry y ademas registrar sus objetos remotos
  

## Usage

Primero debe iniciar el servidor ejecutando el ServidorDeObjetos.java que esta en el paquete servidor, posteriormente puede iniciar el cliente o el administrador ejecutanto el ClienteDeObjetos.java que estan en cada paquete. Para cada ejecucion se pide por consola la direccion ip y puerto el RMI registry
