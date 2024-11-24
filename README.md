# AUTORES: *David Baquero y Samuel*

## Repositorio github: https://github.com/DavBaquero/ProyectoAD_BD.git
***

# Índice
1. [INTRODUCCIÓN](#introducción)
2. [MANUAL USUARIO](#manual-usuario)
3. [MANUAL TÉCNICO](#manual-técnico)
4. [REPARTO DE TAREAS](#reparto-de-tareas)
5. [EXTRAS REALIZADOS](#extras-realizados)
6. [PROPUESTAS](#propuestas)
7. [CONTROL DE ERRORES](#control-de-errores)
8. [CONCLUSIÓN Y TIEMPO DEDICADO](#conclusión-y-tiempo-dedicado)

***

## INTRODUCCIÓN:
 ### OBJETIVO DEL PROYECTO:
El objetivo del proyecto es hacer una aplicación con interfaz gráfica, que acceda a una base de datos de MySql en localhost. Nuestro caso es de valorant y la estructura de las bases de datos, ya que la de usuario y la de la información de los agente y habilidad van por separado, es la siguiente: <br/>
![Imagen database](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/EsquemaDatabase.png)


***

## MANUAL USUARIO

***


Este punto se divide en 3, usado el jar, usando el IDE o compilador y el funcionamiento genérico.
Antes de entrar al funcionamiento, se debe hacer:

```bash
git clone https://github.com/DavBaquero/ProyectoAD_BD.git ruta/donde/quieres/clonar
```

***

### 3.1 Funcionamiento con el jar
Tienes que usar en la cmd el comando 


***

### 3.2 Funcionamiento desde el IDE o compilador
Para ejecutar el programa es necesario entrar a la carpeta y ejecutar el archivo "Main.java".

***

### 3.3 Funcionamiento genérico
Una vez entras al la aplicación encontrarás esta ventana de inicio de sesión:

![Imagen login vacio](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/LoginVacio.png)

Si el usuario usuario no existe o no es correcto entonces aparecerá esto:
![Imagen_login_error](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/LoginError.png)

Entonces, podemos crear un usuario, dandole al botón de crear usuario: <br/>
![Imagen crear vacio](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/CrearVacio.png)

Está contemplado el hecho de que se repita el nombre, que no coincidan las contraseñas:

![Imagen_crear_fallo](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/CrearConFal.png)

![Imagen_crear_U_E](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/UsuarioExiste.png)

En caso de que tengas usuario y inicies sesion, te enonctraras la siguiente ventana: <br/>

![Imagen_AppAG](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/Ventana_DB.png)

Pulsas en cualquier agente y te saldría esto:

![Imagen_AppAG_click](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/ven_db_Cllick.png)

Pulsando arriba en la parte de roles te encontrarías:
![Imagen_AppH](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/ven_db_Hab.png)

Y si haces click en cualquier habilidad te saldría los datos con este formato:
![Imagen_AppH_click](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/ved_db_click_hab.png)

Si pulsas en roles:<br/>
![Imagen_AppR](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/ven_db_Rol.png)

Cuando pulses un rol, te saldrá algo como esto:
![Imagen_AppR_Click](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/ven_db_Rol_click.png)

## MANUAL TÉCNICO
En la paquete de Controller, están ubicados los controladores de las ventas y sus funciones *tratado en el 4.2*
En el paquete Modelo, están ubicados las clases y los métodos de funcionamiento de la aplicación *tratado en el 4.3*.

***

### 4.1 Requisitos de uso
Es necesario tener instalado **javafx** y el **jdk de java 17**.

***

### 4.2 Paquete Controller

#### LoginController

`leer:` Este método se encarga de leer y dividir usuario y contraseña de un [archivo txt](https://github.com/Samuyo/ProyectJSON_AD/blob/main/src/main/resources/BD/users.txt) que guarda los usuarios y se lo pasa a un `HashMap`.

`autentificacionUser:` Entra al `HashMap` y verifica que el valor de la contraseña es igual a la contraseña que se le pasa más adelante en el método `handleBtnEnter`.

`handleBtnEnter`: Este metodo es el del botón Enter, antes de activarse, obtiene el texto que se le pasa por teclado a la aplicación, tanto del usuario como de la contraseña, si el método `autentificacionUser` devuelve `True`, entonces entra, carga, obtiene el estado y muestra la pantalla de `Search`.

#### AgentesController

`handlebtnReturn:` Es el botón encargado de volver al apartado de busqueda de agentes. Básicamente, carga la venta de `search.fxml`, obitiene el estado en el que está y luego muesta la ventana.

`accesoAPI:` Es el método encargado de acceder a la API por un objeto `URL`, hace un `GET` y obtiene la respuesta. Después comprueba que la respuesta sea igual que lo que hay, si es así, lee cada linea y la guarda en String.

`procesarRespuesta:` Es el método que se encarga de procesar la respuesta del método anterior. Primero crea un `JSONObject` y un `JSONArray`. Por cada agente en el array obtiene sus datos, añadiendo después todo como un objeto de la clase `Character` y por último lo añade al `ArrayList`.

`setAgentes:` Es el método que utilizamos para llamar a todos los cambios al buscar un agente.

`setNomeAge` cambia el `Label` de el nombre.

`lblDescAg` cambia el `Label` de la descripción.

`lblRolAg` cambia el `Label` de el rol.

`lblAbil1Ag` cambia el `Label` de la primera habilidad.

`lblAbil2Ag` cambia el `Label` de la segunda habilidad.

`lblAbil3Ag` cambia el `Label` de la tercera habilidad.

`lblAbil3Ag` cambia el `Label` de la cuarta habilidad.

`getAgentes` se utiliza para llamar a la funcion `getAgentesJSON` y devolver la lista con datos.

`getAgentesJSON`Es el método que vincula `procesarRespuesta` y `accesoAPI` para pasarle la respuesta de `accesoAPI` a `procesarRespuesta`

#### SearchController

`handlebtnBuscar` Es el método encargado de buscar un agente, pero antes de ello verifica que esté con el metodo `buscarAgente`. Si no es null, entonces carga, obtiene el controllador de la proxima ventana para usar el método `setAgentes` *Se explica arriba*, después obtiene el estado de la ventana y la muestra.

`buscarAgente` Este método recibe un `String` del método `handlebtnBuscar` y agrega cada agente a un objeto `AgentsController`.

`handlebtnSalir` Es el método encargado de cargar, obtener el estado y mostrar la ventana de login. Básicamente funciona como un `Cerrar sesión`.

`getAgentesJSON`


***

### 4.3 Paquete Model

#### Character
`Getters` y `Contructor`

#### User
`saveUser:` Es el método encargado de escribir los usuarios que existen dentro del el archivo [txt](https://github.com/Samuyo/ProyectJSON_AD/blob/main/src/main/resources/BD/users.txt).


***

## REPARTO DE TAREAS
- Paquete Modelo: Samuel
- Paquete Controller:
  Funcionamiento con la interfaz gráfica: David
  Acceso a JSON: Ambos, principalmente Samuel ya que tuvimos un problema y fue quien lo arregló
- README.MD: David
- Main: David
- Diseño de interfaz: Ambos

***

## EXTRAS REALIZADOS
Por revisar cuáles hemos hecho

***

## PROPUESTAS
Si en algún momento se continúa con la aplicación, se podría añadir la búsqueda de mapas y armas. En cuanto a las skins podría ser una función mucho más adelante en las armas.

***

## CONTROL DE ERRORES
Por el momento:
 - Si se introduce el nombre de un agente que no existe, la aplicación no busca nada.
 - Si el usuario con el que se intenta iniciar no existe, la aplicación no entrará.

***

## CONCLUSIÓN Y TIEMPO DEDICADO
El tiempo dedicado de David es aproximadamente de: 20h (por ahora) <br/>
El tiempo dedicado de Samuel es aproximadamente de : 20h

### 9.1  Conclusión:
Con este proyecto hemos aprendido: a hacer interfaces y vincularlas en java, ya que de momento solo sabíamos en Python, hemos aprendido a entrar a archivos json en red, hemos practicado control de versiones en distintas ramas y nos ha servido como repaso para el examen de este temario.
