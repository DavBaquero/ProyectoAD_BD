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
El tiempo dedicado de David es aproximadamente de: 17h <br/>
El tiempo dedicado de Samuel es aproximadamente de : 17h

### 8.1  Conclusión:
Hemos aumentado nuestro control en cuanto al JavaFX y trabajar con ello, ya que ha sido más rápido y eficaz, además de que hemos puesto en práctica tanto el acceso a bases de datos como el control de errores en los códigos.
