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

Una vez pulsas uno, puedes exportarlo:
![Imagen_ExportAg](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/exporta_json_agente.PNG)

Pulsando arriba en la parte de roles te encontrarías:
![Imagen_AppH](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/ven_db_Hab.png)

Y si haces click en cualquier habilidad te saldría los datos con este formato:
![Imagen_AppH_click](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/ved_db_click_hab.png)

En caso de querer exportar la información, se le asigna un nombre y pulsas exportar:
![Imagen AppH Export](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/exporta_json_habilidad.PNG)

Si pulsas en roles:<br/>
![Imagen_AppR](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/ven_db_Rol.png)

Cuando pulses un rol, te saldrá algo como esto:
![Imagen_AppR_Click](https://github.com/DavBaquero/ProyectoAD_BD/blob/main/src/main/resources/img/ven_db_Rol_click.png)

## MANUAL TÉCNICO
En la paquete de Controller, están ubicados los controladores de las ventas y sus funciones *tratado en el 3.2*
En el paquete Modelo, están ubicados las clases y los métodos de funcionamiento de la aplicación *tratado en el 3.3*.

### 3.2 Package Controller
#### CreateUserController
`handleBtnCreateUser:` Este método se encarga de comprobar si el usuario se puede crear: en caso de que no coinicdan las contraseñas enseña un label diciendo que no coinciden, en caso de que ya exista el usuario el label mostrará que ya existe y sino saldrá al login para que puedas iniciar sesión.

`insertUser:` Es el encargado de hacer la query de insertar en la base de datos de ususario.

`checkPassword:` Es el encargado de cheackerar que la contraseña se repita para poder registrarse.

`checkUserName:` Es el método encargado de que no exista el nombre del ususario a la hora de crear.

`returnLogin:` Es el método que se encarga de que cuando se cree el nuevo usuario vuelva directamente al login.

`handleBtnVolver` En caso de que no se quiera crear usuario, está el botón de volver, ese es el método encargado de volver hacia el login.

***

#### UserSettingsController

`llenarComboBox:` Es el método encargado de llenar la ComboBox con los nombres de usuario.

`crearListener:` Es el método encargado de cargar los datos en los Text al seleccionar el combobox y el encargado de enviarlo si se realizan cambios.

`handleBtnBorrar:` Es el encargado de llamar al método que borra el ususario que se ha seleccionado usando.

`borrarUsuario:` Es el método que hace la query de borrar usuarios.

`handleBtnAdministrador:` Es el método encargado de asignar que un usuario sea administrador.

`asignarAdministrador:` Es el método encargado de usar la query de update para actualizar al administrador.

`handleBtnModificar:` Es el método encargado de que al darle a modificar, llame a la actualización.

`actualizarUsuario:` Es el método que se encarga de actualizar al usuario con una query Update.

`handleBtnVolver:` Es el método que se encarga del botón de volver al login. 
***

#### LoginController

`leer:` Se encarga de leer un hashmap con los usuarios y las contraseñas

`login:` Es el método encargado de hacer el login, para diferenciar si son administradores o no, justo al darle al botón de entrar.

`getNombreUsuario:` Es un getter para obtener el nombre de usuario.

`llenarAdministradores:` Es el método encargado de llenar un ArrayList con los ususarios que sean administradores.

`distinguirAdministrador:` Es un método encargado de diferenciar si administradores o si no son administradores.

`handleBtnCreateUser:` Es el método que cambia de ventana para crear un usuario.

`autentificacionUser:` Es un método que autentifica si el usuario está en la base de datos.
***

#### ViewNorUserController 

`initialize:` Método que se ejecuta nada más se inicia y inicializa todos los datos de los datos de las columnas.

`setLoginController:` Mantenemos la instancia del login para poder diferenciar entre administrador y usuario normal.

`credencialAdmin:` Método encargado de dar visibilidad al botón del administrador.

`getAgentesData:` Método encargado de recibir los datos de los agentes de la base de datos.

`handleRowClickAg:` Método que cambia los label al pulsar un agente.

`getHabData:` Método encargado de recibir los datos de las habilidades de la base de datos.

`handleRowClickHab:`  Método que cambia los label al pulsar una habilidad.

`getRolData:` Método encargado de recibir los datos de los roles de la base de datos.

`handleBtnVolver:` Es el método que se encarga del botón de volver al login.

`handleBtnExportarAgenteJson:` Método encargado de exportar los agentes a json.

`guardarAgentesEnJson:` Método encargado de crear la estructura del json para los agentes.

`convertirObservableListAArrayListAg:` Método para convertir la ObservableList a ArrayList, para poder exportar los datos de Agente.

`handleBtnExportarHab:` Método encargado de exportar las habilidades a json.

`guardarHabilidadEnJson:` Método encargado de crear la estructura del json para las habilidades.

`convertirObservableListAArrayListHab:` Método para convertir la ObservableList a ArrayList, para poder exportar los datos de Habilidades.

`handleBtnAdminUser:` Método que se encarga de realizar el cambio para el administrador

***

### 3.3 Package Model
#### AgenteDTO
`Contructor, getters y setters:` Esta clase se ha realizado para gestionar la carga de los agentes en la tabla y sus label.
***
#### Agente
`Contructor, getters y setters:` Esta clase se ha realizado almacenar los agentes.

#### HabilidadDTO
`Contructor, getters y setters:` Esta clase se ha realizado para gestionar la carga de las habilidades en la tabla y sus label.
***

#### Habilidad
`Contructor, getters y setters:` Esta clase se ha realizado almacenar las habilidades.
***

#### Habilidades
`Enum:` Es una clase de enum, para las habilidades, tiene sus respectivos `getters, constructor y comprobador`
***

#### RolDTO
`Contructor, getters y setters:` Esta clase se ha realizado para gestionar la carga de los roles en la tabla y sus label.
***

#### Rol
`Contructor, getters y setters:` Esta clase se ha realizado almacenar los roles.
***

#### Roles
`Enum:` Es una clase de enum, para las habilidades, tiene sus respectivos `getters, constructor y comprobador`
***

#### User
`Contructor, getters y setters:` Esta clase se ha realizado almacenar los roles.
***

#### ConnetBD
`connetUsuario:` Método realizado para conectarse a la base de datos de usuarios.

`selectUsuario:` Metodo realizado para seleccionar los usuarios con una query.

`procesarUsuarios:` Método realizado para almacenar los usuarios.

`connect:` Método realizado apra conectarse a la base de datos de valorant.

`getAgentesTab:` Método que se encarga de hacer una query combinando tablas para obtener los datos de la tabla agentes.

`getHabTab:` Método que se encarga de hacer una query combinando tablas para obtener los datos de la tabla habilidades.

`getRolTab:` Método que se encarga de hacer una query combinando tablas para obtener los datos de la tabla roles.

***

## REPARTO DE TAREAS
- Apartado de agentes: David
- Apartado de roles: David
- Apartado de habilidades: David
- Apartado de usuarios: Samuel
#### Este reparto ha sido así por la similitud de las tareas de agentes, roles y habilidades, para hacerlo más rápido y cómodo para ambos

- Parte gráfica: Ambos hemos contribuido en cuanto al diseño inicial y final de la aplicación
- Las bases de datos han sido distribuidas de la misma manera que en las clases, es decir, David se ha encargado de lo que tiene que ver con valorant y Samuel del usuario. 
- Los botones de exportar a json se ha encargado Samuel
- Control de errores visual en la aplicación se ha encargado David
- Readme se ha encargado David

***

## EXTRAS REALIZADOS
- Login con las premisas mínimas de seguridad
- Control de errores
- Damos espacio a la ordenacion de los datos y al almacenaje de estos.
  
***

## PROPUESTAS
Si en algún momento se continúa con la aplicación, se podría añadir la búsqueda de mapas y armas. Además de hacerla un poco más bonita a la vista

***

## CONTROL DE ERRORES

-Si el usuario introducido no existe, no avanza.
-Si al crear usuario ya existe, notifica al usuario.
-Si al crear usuario no coinciden las contraseñas, notifica al usuario.
-Una vez se borra un usuario, notifica al administrador, si da error también.
-Una vez se modifica a un usuario, notifica al administrador, si da error también.

***

## CONCLUSIÓN Y TIEMPO DEDICADO
El tiempo dedicado de David es aproximadamente de: 18h <br/>
El tiempo dedicado de Samuel es aproximadamente de : 18h

### 8.1  Conclusión:
Hemos aumentado nuestro control en cuanto al JavaFX y trabajar con ello, ya que ha sido más rápido y eficaz, además de que hemos puesto en práctica tanto el acceso a bases de datos como el control de errores en los códigos.
