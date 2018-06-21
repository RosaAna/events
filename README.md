<<<<<<< HEAD
                                                              INDICACIONES

Este proyecto consta de tres carpetas.
1-worskpace:La carpeta eventsJaen (La aplicación)
2-events_img:Imagenes  que podrá cambiar siempre y cuando no coincida tanto el nombre como la extensión-Recuerde retirar las antigüas antes para evitar confictos de nombre.
3-events_json:Aquí se guardan los archivos de datos de la base de datos. Incluye una carpeta  para borrar datos antigüos ¡Ojo! Borra  la base de datos completa,le será útil para ver  de forma sencilla que los datos se han borrado y que no es problema del sistema.
 Deje las dos carpetas, la de imágenes y la de datos en el escritorio ya que esa es la ruta por defecto de la aplicación. Si tiene algún problema no dude en contactar con nuestro servicio técnico.

Una vez ejecutada la aplicación sólo podrá cargar un archivo de cada vista, si necesita recargar deberá reiniciar el sistema.

                                                          README APLICACION
=======
"# events" 
    README APLICACION
>>>>>>> 842434aa0a5ee262d60c8c702ce77ccf6cacfd3a

Aplicación de escritorio para la Empresa PinBravo S.L que gestionará uno de sus grandes eventos , el  'Event's Singels', concretamente aquí en Jaén.
Recoge por medio del explorador de archivos de java JFilechoose dos: clientes.json y productos.json  usando para ello la api de Gson quedando bloqueda la entrada de más archivos hasta una nueva ejecución de la aplicación.
La interfaz es muy sencilla son dos paneles, uno superior que es el barner con el logo del evento y
<<<<<<< HEAD
un segundo inferior que soporta un tabbebPaene con con siete pestañas que se corresponden con las opciones que tiene el usuario como:
Vista Información sólo con una imagen de fondo para que el usuario pueda informar al participante del programa del evento(Sólo cambiar la imagen desde el archivo en el que se guardan cada vez que cambie el programa, eso sí, no puede cambiar el nombre ni la extensión).
Vista de Fans en la que insertar, eliminar,  modificar  datos y crear  una lista de participantes (Volvemos aquí a usar de nuevo Gson para crear el archivo participantes.json a partir del la clase Participante)  de los que van a participar .
Le incorporamos todas esas funcionalidades además de JCalendar para insertar fácilmente la fecha de nacimiento, RadioButton  y un JComBobox dentro del Jtable que contiene los datos para facilitar la inscripción de los clientes al evento con sólo seleccionar  'SI'. 
Vista Ventas:El usuario sólo podrá insertar y anular la venta a partir de los datos existentes, sólo puede realizarla con los participantes y productos que hay en la base de datos, para ello selecciona en las Jtables de participantes y productos los datos que le facilita el comprador.
Para anular la venta selecciona venta existente en la Jtable y botón borrar que tiene la funcionalidad de eliminar la venta, actualizar la tabla y por medio de un trigger insertarla en la Jtable de devoluciones.
Vista Devoluciones:Dispone de dos Jbutton para devolver a ventas si el producto está en buen estado estado. La funcionalidad de este botón es la siguiente, cada producto devuelto tiene un estado que por defecto es en REVISION y éste le cambia el estado a CORRECTO y le suma una unidad a la cantidad del producto dicho por medio de los métodos correspondientes.
El otro JButton del que dispone es el de ir a pérdidas que borra el registro de esa tabla y por medio de un trigger lo envía a la tabla pérdidas.
También le incorporamos un JComBobox con dos opciones una para generar un pdf( con itextPDF) con los datos existentes en la tabla y otro para recoger incidencias que con sólo seleccionar la fila del producto  que ha generado la incidencia incorpora la imagen y el código del producto.
Con la particularidad de que se pueden generar tantos archivos como se desee o necesite ya que cada vez que se ejecuta crea un archivo diferente y numerado para ver así el orden en que fue creado.
Además cada vez que selecciona un registro de la Jtable puede ver la imagen del producto.
Vista Productos:Inserta un nuevo producto y borra desde la Jtable.
Vista Participantes:Contiene los buttons de imprimir para enviar a impresora,insertar producto y borrar producto.
Vista Administración: Consta de un SplitPane.
En el panel derecho contiene un Jtable con lo datos de los productos y clientes que han ido a pérdidas  con la particularidad de que al seleccionar una fila toma color rojo si ese participante ha devuelto a pérdidas más de tres productos, gris oscuro si fueron dos y gris claro si es uno.
Da el importe total de los productos enviados a pérdidas.
En el panel izquierdo vemos la imagen del producto y los datos completos de los participantes que lo han devuelto en ese estado al seleccionar cada registro del Jtable del panel derecho.
=======
un segundo inferior que soporta  JTabbeDPane con siete pestañas que se corresponden con las opciones que tiene el usuario como:

Vista Información en la que sólo con una imagen de fondo para que el usuario pueda informar al participante del programa del evento(Puede cambiar la imagen desde el archivo en el que se guardan cada vez que cambie el programa, eso sí, no puede cambiar el nombre ni la extensión).

Vista de Fans en la que insertar, eliminar,  modificar  datos y crear  una lista de participantes (Volvemos aquí a usar de nuevo Gson para crear el archivo participantes.json a partir de la clase Participante)  de los que van a participar .
Le incorporamos todas esas funcionalidades además de JCalendar para insertar fácilmente la fecha de nacimiento, RadioButton  y un JComBobox dentro del Jtable que contiene los datos para facilitar la inscripción de los clientes al evento con sólo seleccionar la opción deseada.

Vista Ventas en la que usuario sólo podrá insertar y anular la venta a partir de los datos existentes, sólo puede realizarla con los participantes y productos que hay en la base de datos, para ello selecciona en las Jtables de participantes y productos los datos que le facilita el comprador.
Para anular la venta selecciona venta existente en la Jtable y botón borrar que tiene la funcionalidad de eliminar la venta, actualizar la tabla y por medio de un trigger insertarla en la Jtable de devoluciones.

Vista Devoluciones que dispone de dos Jbuttons para devolver a ventas si el producto está en buen estado estado. La funcionalidad de este botón es la siguiente, cada producto devuelto tiene un estado que por defecto es en REVISION y éste le cambia el estado a CORRECTO y le suma una unidad a la cantidad del producto dicho por medio de los métodos correspondientes.
El otro JButton del que dispone es el de ir a pérdidas que borra el registro de esa tabla y por medio de un trigger lo envía a la tabla pérdidas.
También le incorporamos un JComBobox con dos opciones una para generar un pdf( con itextPDF) con los datos existentes en la tabla y otro para recoger incidencias sólo con seleccionar la fila del producto  que ha generado la incidencia ya incorpora la imagen y el código del producto al archivo.
Con la particularidad de que se pueden generar tantos como se desee o necesite ya que cada vez que se ejecuta crea un archivo diferente y numerado para ver así el orden en que fue creado.
Además cada vez que selecciona un registro de la Jtable puede ver la imagen del producto.

Vista Productos:Inserta un nuevo producto y borra desde la Jtable.

Vista Participantes que contiene los buttons de imprimir para enviar a impresora,insertar producto y borrar producto.

Vista Administración que consta de un SplitPane:
-En el panel derecho contiene un Jtable con lo datos de los productos y clientes que han ido a pérdidas  con la particularidad de que al seleccionar una fila toma color rojo si ese participante ha devuelto a pérdidas más de tres productos, gris oscuro si fueron dos y gris claro si es uno.
Da el importe total de los productos enviados a pérdidas.
-En el panel izquierdo vemos la imagen del producto y los datos completos de los participantes que lo han devuelto en ese estado al seleccionar cada registro del Jtable del panel derecho.

>>>>>>> 842434aa0a5ee262d60c8c702ce77ccf6cacfd3a
La base de datos events.db con sqlite controla que no se pueda introducir ningún producto, participante o fan repetido por medio de PK.
También controla que ningún cliente pueda comprar un producto dos veces el mismo día por medio de la PK(dni, código_producto, fecha).
Inserta los registros de las anulaciones(delete) de la tabla ventas en la tabla devoluciones y las devoluciones a pérdidas(delete)  en la tabla devoluciones en la tabla pérdidas por medio de los triggers correspondientes.

