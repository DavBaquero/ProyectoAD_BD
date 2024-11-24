USE VALORANT;

INSERT INTO ROLES (NOMBRE_ROL, DESCRIP_ROL) VALUES 
('INICIADOR', 'Los iniciadores son especialistas en crear situaciones para iniciar combates, abriendo caminos para el equipo.'),
('CONTROLADOR', 'Los controladores son expertos en cortar la visión enemiga y facilitar el ataque y defensa en puntos estratégicos.'),
('DUELISTA', 'Los duelistas son asesinos autosuficientes que buscan enfrentamientos directos y son capaces de obtener múltiples eliminaciones por sí mismos.'),
('CENTINELA', 'Los centinelas son expertos en asegurar áreas y proteger a sus compañeros de equipo con herramientas defensivas.');


INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Phoenix', 'Phoenix proviene del Reino Unido y sus poderes estelares salen a relucir con su estilo de combate, que prende fuego al campo de batalla de forma deslumbrante. No le hacen falta refuerzos; es él quién se lanza al combate y marca el ritmo.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='Duelista'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Raze', 'Raze llega desde Brasil con ganas de hacer que todo salte por los aires. Con su estilo de juego basado en la fuerza bruta, destaca a la hora de barrer a grupos de enemigos atrincherados y de despejar áreas estrechas con explosión y sin compasión.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='Duelista'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Yoru', 'Yoru, nacido en Japón, abre agujeros en el tejido de la realidad para infiltrarse tras las líneas enemigas sin ser visto. Utiliza el engaño y la agresividad por igual para acabar con sus objetivos antes de que sepan qué ha pasado.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='Duelista'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Iso', 'Iso, el profesional a sueldo chino, entra en un estado de energía para acabar con sus rivales. Capaz de reconfigurar la energía ambiental para crear una protección a prueba de balas, avanza concentrado a su siguiente duelo a muerte.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='Duelista'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Jett', 'Jett viene de Corea del Sur, y su estilo de lucha ágil y evasivo le permite asumir grandes riesgos. Corre y salta de aquí para allá en las refriegas y hace trizas a los enemigos con una rapidez espectacular.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='Duelista'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Gekko', 'Gekko, de Los Ángeles, lidera una pequeña pandilla de calamitosas criaturas. Sus colegas toman la delantera para dispersar a los enemigos, mientras que Gekko los persigue para luego reagruparse y repetir el proceso.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='INICIADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Sova', 'Nacido en el eterno invierno de la tundra rusa, Sova destaca a la hora de localizar, perseguir y eliminar a los enemigos con una eficiencia y una precisión inclementes. Su arco personalizado junto con su sobrenatural capacidad de rastreamiento hacen que sea imposible escapar..', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='INICIADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Breach', 'Breach, el sueco biónico, dispara una serie de explosiones cinéticas controladas para abrirse paso por el territorio enemigo. Su capacidad para infligir daño y sembrar el caos garantiza que los combates siempre estén de su parte.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='INICIADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Skye', 'Skye y su manada de bestias se abren paso desde Australia y a través de territorio hostil. Sus creaciones obstaculizan los avances enemigos y su capacidad para curar a los demás se ocupa de que, a su lado, su equipo esté a salvo.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='INICIADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('KAY/O', 'KAY/O es una máquina de guerra construida con un único propósito: neutralizar a los radiantes. Su poder para suprimir habilidades enemigas incapacita a sus adversarios, lo que asegura la ventaja para él y sus aliados.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='INICIADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Fade', 'Fade, la cazarrecompensas turca, controla el poder de las pesadillas para poner al descubierto los secretos de los enemigos. Armada con el terror mismo, da caza a sus objetivos y revela sus miedos más profundos, para después acabar con ellos en la oscuridad.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='INICIADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Brimstone', 'De origen estadounidense, Brimstone cuenta con un arsenal de órbita que garantiza que su equipo siempre vaya por delante. Su capacidad para aportar herramientas de utilidad de una forma segura y precisa lo convierte en un comandante de primera línea sin igual.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CONTROLADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Omen', 'Omen es un fantasma de tiempos pasados que acecha en las sombras. Es capaz de cegar al enemigo, teleportarse a través del campo de batalla y sembrar el caos y la paranoia mientras sus rivales se preguntan dónde atacará la próxima vez.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CONTROLADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Astra', 'Astra, la agente ghanesa, controla las energías del cosmos para dar forma al campo de batalla a su antojo. Con pleno dominio de su forma astral y un gran talento para la anticipación estratégica, siempre va eones por delante de los movimientos de sus enemigos.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CONTROLADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Clove', 'Le agente escocese Clove no para de liarla, tanto en el fragor de la batalla como en el frío abrazo de la muerte. Le joven inmortal trae de cabeza a sus enemigos incluso desde el más allá, porque saben que en cualquier momento podría volver al mundo de los vivos.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CONTROLADOR'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Chamber', 'El diseñador de armas francés, siempre bien vestido y bien pertrechado, expulsa a los agresores con precisión letal. Chamber aprovecha su arsenal personalizado para resistir, elimina enemigos a distancia y crea la contingencia perfecta para cada plan.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CENTINELA'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Cypher', 'Cypher es un experto en información de Marruecos que se especializa en redes de vigilancia y es capaz de seguirle la pista al enemigo constantemente. No hay secreto a salvo ni maniobra que pase desapercibida. Cypher siempre está alerta.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CENTINELA'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Deadlock', 'Deadlock, la agente noruega, despliega un surtido de avanzados nanocables para defender el campo de batalla de cualquier asalto, por letal que sea. Nadie escapa a su atenta mirada ni sobrevive a su ferocidad implacable.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CENTINELA'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Vyse', 'La prodigiosa ferromante Vyse crea metal en estado líquido para aislar, atrapar y desarmar a sus enemigos. Gracias a su astucia y poder de manipulación, fuerza a sus oponentes a desconfiar incluso del campo de batalla.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CENTINELA'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Neon', 'Neon, una agente filipina, se lanza hacia la batalla a una velocidad trepidante, disparando descargas bioeléctricas tan rápido como las genera su cuerpo. Se adelanta para pillar a sus enemigos desprevenidos y acaba con ellos más rápido que una bala.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='DUELISTA'));


INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Reyna', 'Desde el corazón de México, Reyna llega para dominar los combates uno contra uno y cada asesinato que consigue la hace más fuerte. Su potencial es prácticamente infinito, y la destreza individual es el único factor determinante de su éxito.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='DUELISTA'));


INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Sage', 'Originaria de China, Sage destaca a la hora de crear espacios seguros para su equipo allá donde va. Sus capacidades especiales para revivir a compañeros caídos en batalla y para mantener a raya los asaltos enemigos la convierten en la calma en mitad de la tormenta para su equipo.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CENTINELA'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Killjoy', 'Killjoy es una brillante agente alemana que se encarga de tomar posiciones clave del campo de batalla con su arsenal de inventos. Si su daño no acaba con los enemigos, su horda de robots ayudará a su equipo a despejarlos en un abrir y cerrar de ojos.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CENTINELA'));

INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Viper', 'Viper es una química estadounidense con un amplio arsenal de dispositivos venenosos que le sirven para tomar el control del campo de batalla y cegar a los enemigos. Si las toxinas no acaban con su presa, la paranoia la rematará.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CONTROLADOR'));


INSERT INTO AGENTES (NOMBRE_AG, DESCRIP_AG, ID_ROL_AG) VALUES 
('Harbor', 'Desde las costas de la India, Harbor llega al campo de batalla armado con tecnología ancestral capaz de controlar el agua. Libera espumosos torrentes y demoledoras olas para escudar a sus aliados o machacar a quien se interponga en su camino.', 
(SELECT ID_ROL FROM ROLES WHERE NOMBRE_ROL='CONTROLADOR'));

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Jett'),
        'VENDAVAL',
        'Propulsa INSTANTÁNEAMENTE a Jett a mucha altura hacia arriba.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Jett'),
        'VIENTO DE COLA',
        'ACTIVA para preparar una ráfaga de viento durante un tiempo limitado. VUELVE A USAR el viento para propulsar a Jett en la dirección en la que se esté moviendo. Si Jett está quieta, se propulsa hacia delante. La carga de Viento de cola se reinicia cada dos asesinatos.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Jett'),
        'BORRASCA',
        'Lanza un proyectil INSTANTÁNEAMENTE que se expande para crear una nube que bloquea la visión brevemente al impactar contra una superficie. MANTENED PULSADO el botón de la habilidad para que el humo se curve en la dirección de la mira.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Jett'),
        'TORMENTA DE CUCHILLAS',
        'EQUIPA un conjunto de cuchillos volantes de alta precisión. DISPARA para lanzar un único cuchillo y recarga los cuchillos con un asesinato. ALTERNA EL MODO DE DISPARO para lanzar todos los cuchillos restantes, pero no se recargan con un asesinato.',
        'X');
        
INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Phoenix'),
        'COMBUSTIÓN',
        'EQUIPA una bola de fuego. DISPARAD para lanzar una bola de fuego que explota transcurrido un tiempo determinado o al impactar contra el suelo, lo que crea una zona de fuego persistente que inflige daño a los enemigos.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Phoenix'),
        'BOLA CURVA',
        'EQUIPA un orbe fulgurante que dibuja una trayectoria curva y explota poco después de haberlo lanzado. DISPARAD para lanzar el orbe fulgurante hacia la izquierda, lo que hará que detone y ciegue a cualquier jugador que lo vea. ALTERNAD EL MODO DE DISPARO para lanzar el orbe fulgurante hacia la derecha.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Phoenix'),
        'LLAMARADA',
        'EQUIPA una pared de llamas. DISPARAD para crear una línea de llamas que avanza hacia adelante, lo que forma una pared de fuego que bloquea la visión e inflige daño a los jugadores enemigos que la atraviesen. MANTENED PULSADO DISPARAR para curvar la pared en la dirección de la mira.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Phoenix'),
        'CENIZAS',
        'Coloca INSTANTANEAMENTE un marcador en la ubicación de Phoenix. Mientras esta habilidad esté activa, morir o dejar que se agote el temporizador hará que se termine la habilidad y devolverá a Phoenix a esta ubicación con toda la vida.',
        'X');
        
INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Raze'),
        'FARDO EXPLOSIVO',
        'Lanza AL INSTANTE un fardo explosivo que se adhiere a las superficies. VOLVED A USAR la habilidad después de que el fardo se adhiera para detonarlo y que dañe y desplace a todo aquello que alcance. Esta habilidad no inflige daño a Raze, pero sí que recibirá daño por caída si salta lo suficientemente alto.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Raze'),
        'BALAS DE PINTURA',
        'EQUIPA una granada de racimo. DISPARA para lanzar la granada, lo que causa daño y crea submuniciones que infligen daño a cualquiera que esté dentro del rango. ALTERNA EL MODO DE DISPARO para tirarlo. La carga de Balas de pintura se reinicia cada dos asesinatos.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Raze'),
        'BOT EXPLOSIVO',
        'EQUIPA un bot explosivo. DISPARAD para desplegar el bot y hacer que se desplace en línea recta por el terreno, rebotando por las paredes. El bot explosivo se fijará a los enemigos que encuentre en un cono frontal y los perseguirá. Si los alcanza, explotará e infligirá una gran cantidad de daño.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Raze'),
        'CIERRATELONES',
        'EQUIPA un lanzacohetes. DISPARA para lanzar un cohete que inflige un daño en área masivo al entrar en contacto con cualquier cosa.',
        'X');
        
INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Yoru'),
        'PUNTO CIEGO',
        'EQUIPA para arrancar un fragmento dimensional inestable de la realidad. DISPARA para lanzar el fragmento, lo que activa un destello que se carga al impactar contra una superficie sólida.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Yoru'),
        'INFILTRACIÓN',
        'EQUIPA un vínculo de grietas. DISPARA para lanzarlo hacia delante. ALTERNA EL MODO DE DISPARO para colocarlo en el sitio. ACTIVA para teleportarte a la ubicación del vínculo. USA para activar un teleportar falso.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Yoru'),
        'ENGAÑO',
        'EQUIPA un eco que se transforma en una imagen idéntica de Yoru al activarse. DISPARA para activar la imagen al instante y enviarla hacia delante. ALTERNA el modo de disparo para colocar un eco inactivo. USA para transformar un eco inactivo en una imagen y enviarla hacia delante. Las imágenes explotan con un destello al ser destruidas por enemigos.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Yoru'),
        'VIAJE INTERDIMENSIONAL',
        'EQUIPA una máscara que te permite ver entre dimensiones. DISPARA para adentrarte en la dimensión de Yoru. Los enemigos que estén fuera no podrán verte ni hacerte daño. REACTIVA la habilidad para salir antes de la dimensión de Yoru.',
        'X');
        
INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Iso'),
        'SOCAVAR',
        'EQUIPA un proyectil molecular. DISPARA para lanzarlo hacia delante, lo que aplica brevemente Fragilidad a todos los jugadores que toca. El proyectil puede atravesar objetos sólidos, incluso paredes.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Iso'),
        'DISPARO DOBLE',
        'INICIA un temporizador de concentración. Cuando termina, Iso entra en un estado de energía durante el cual los enemigos abatidos que ha asesinado o dañado generan un orbe de energía. Disparar al orbe otorga a Iso un escudo que absorbe una única vez el daño de cualquier fuente.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Iso'),
        'CONTINGENCIA',
        'EQUIPA para reunir energía prismática. DISPARA para enviar al frente un muro indestructible de energía que bloquea las balas.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Iso'),
        'CONTRATO DE ASESINATO',
        'EQUIPA una arena interdimensional. DISPARA para lanzar una columna de energía a través del campo de batalla que arrastra a Iso y al primer enemigo alcanzado a la arena. Allí os batís en duelo a muerte.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Gekko'),
        'DIZZY',
        'EQUIPA a Dizzy. DISPARA para lanzar a Dizzy volando hacia delante. Dizzy carga y libera explosiones de plasma hacia los enemigos en su campo de visión. El plasma ciega a los enemigos alcanzados. Cuando Dizzy desaparece, vuelve a su estado de glóbulo en reposo. INTERACTÚA para recuperar el glóbulo y obtener otra carga de Dizzy tras un breve enfriamiento.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Gekko'),
        'WINGMAN',
        'EQUIPA a Wingman. DISPARA para mandar a Wingman hacia delante en busca de enemigos. Wingman libera una explosión aturdidora en dirección al primer enemigo que ve. ALTERNA EL MODO DE DISPARO mientras apuntas a una zona de la Spike o a una Spike colocada para que Wingman la coloque o la desarme. Para colocarla, Gekko debe tener la Spike en su inventario. Cuando Wingman desaparece, vuelve a su estado de glóbulo en reposo. INTERACTÚA para recuperar el glóbulo y obtener otra carga de Wingman tras un breve enfriamiento.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Gekko'),
        'MOSH',
        'EQUIPA a Mosh. DISPARA para lanzar a Mosh como una granada. ALTERNA EL MODO DE DISPARO para lanzarlo por debajo del hombro. Al caer, Mosh se divide en varias copias en un área grande y, tras un breve lapso, explota.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Gekko'),
        'THRASH',
        'EQUIPA a Thrash. DISPARA para vincular tu mente con la de Thrash y manejarla a través del territorio enemigo. ACTÍVALA para embestir hacia delante y explotar, deteniendo a cualquier enemigo en un pequeño radio. Cuando Thrash desaparece, vuelve a su estado de glóbulo en reposo. INTERACTÚA para recuperar el glóbulo y obtener otra carga de Thrash tras un breve enfriamiento. Thrash puede recuperarse una vez.',
        'X');


INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Sova'),
        'FLECHA EXPLOSIVA',
        'EQUIPA un arco con una flecha explosiva. DISPARA para lanzar la flecha explosiva hacia delante. Explotará cuando impacte e infligirá daño a los enemigos cercanos. MANTÉN PULSADO para ampliar su alcance. ALTERNA EL MODO DE DISPARO para añadir hasta dos rebotes a la flecha.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Sova'),
        'PROYECTIL DE RECONOCIMIENTO',
        'EQUIPA un arco con un proyectil de reconocimiento. Se activará cuando impacte y revelará la posición de los enemigos que se encuentren en la línea de visión del proyectil. El proyectil puede ser destruido. MANTÉN PULSADO para ampliar su alcance. ALTERNA EL MODO DE DISPARO para añadir hasta dos rebotes a la flecha.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Sova'),
        'DRON DE RECONOCIMIENTO',
        'EQUIPA un dron de reconocimiento. DISPARA para desplegar el dron y controlar su movimiento. Cuando tengas el control del dron, DISPARA para lanzar un dardo marcador que revelará la ubicación de cualquier jugador alcanzado. Los enemigos pueden destruir el Dron de reconocimiento.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Sova'),
        'FURIA DEL CAZADOR',
        'EQUIPA un arco con tres proyectiles de energía de largo alcance que atraviesan paredes. DISPARAD para lanzar un proyectil de energía en línea recta frente a Sova que infligirá daño y revelará la posición de los enemigos que se encuentren a su paso. Esta habilidad puede VOLVERSE A USAR hasta dos veces más mientras el temporizador de la habilidad esté activo.',
        'X');


INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Breach'),
        'EXPLOSIÓN CEGADORA',
        'EQUIPA una carga explosiva cegadora. DISPARAD la carga para liberar una rápida explosión que atraviesa la pared. Cuando detona, la carga ciega a todos los jugadores que la estén mirando.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Breach'),
        'FALLA',
        'EQUIPA una bomba sísmica. MANTENED PULSADO DISPARAR para aumentar la distancia. SOLTAD para liberar un seísmo que aturdirá a todos los jugadores dentro de la zona y en una línea hasta ella.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Breach'),
        'RÉPLICA',
        'EQUIPA una carga explosiva de fusión. DISPARAD la carga para liberar una explosión que atraviesa la pared tras un retardo. La explosión inflige mucho daño a cualquiera que esté dentro del área afectada.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Breach'),
        'FRAGOR IMPARABLE',
        'EQUIPA una carga explosiva sísmica. DISPARAD para liberar un seísmo que se extenderá por una gran zona en forma de cono. El seísmo aturde y lanza por los aires a todos los jugadores que estén en el interior de la zona.',
        'X');


INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Skye'),
        'PRECURSOR',
        'EQUIPA un amuleto de lobo marsupial. DISPARA para desplegar al depredador y controlarlo. Mientras se está controlando al lobo, DISPARAR hace que salte hacia delante y explote, lo que aturde e inflige daño a los enemigos que golpee.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Skye'),
        'LUZ GUÍA',
        'EQUIPA un amuleto de lobo marsupial. DISPARA para desplegar al depredador y controlarlo. Mientras se está controlando al lobo, DISPARAR hace que salte hacia delante y explote, lo que aturde e inflige daño a los enemigos que golpee.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Skye'),
        'REFORESTACIÓN',
        'EQUIPA un amuleto de curación. MANTENER PULSADO canaliza la habilidad, que cura a los aliados que estén dentro del alcance y del campo de visión. Se puede volver a utilizar hasta que se quede sin curación disponible. Skye no se puede curar a sí misma.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Skye'),
        'BUSCADORES',
        'EQUIPA un amuleto de buscador. DISPARA para desplegar tres buscadores que localizan a los tres enemigos más cercanos. Si un buscador alcanza a su objetivo, limita su visión. Los enemigos pueden destruir a los buscadores.',
        'X');


INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'KAY/O'),
        'UNIDAD/FLASH',
        'EQUIPA una granada cegadora. DISPARA para lanzar la granada por arriba. ALTERNA EL MODO DE DISPARO para lanzar una granada más débil que explota rápidamente. La cegadora explota tras un breve tiempo y ciega a todo el que se encuentre en la línea de visión.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'KAY/O'),
        'PUNTO/CERO',
        'EQUIPA una cuchilla de supresión. DISPARA para lanzarla. La cuchilla se adhiere a la primera superficie a la que golpee, se carga y suprime a cualquiera que se encuentre en el radio de la explosión. Los enemigos pueden destruir la cuchilla.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'KAY/O'),
        'FRAG/MENTO',
        'EQUIPA un fragmento explosivo. DISPARA para lanzarlo. El fragmento se pega al suelo y explota varias veces, lo que inflige daño casi mortal en el centro con cada explosión.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'KAY/O'),
        'CMD/ANULAR',
        'Experimenta una sobrecarga INSTANTÁNEA de energía de radianita polarizada en forma de pulsos de gran radio que se emiten desde KAY/O. Los enemigos que reciban el impacto de pulsos quedan silenciados durante un breve periodo de tiempo. Cuando está sobrecargado, KAY/O obtiene Estimulante de combate y puede volver a estabilizarse si resulta derribado.',
        'X');


INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Fade'),
        'APRESAR',
        'Equipa un orbe hecho con tinta de pesadilla. DISPARA para lanzar el orbe que, tras un determinado periodo de tiempo, caerá en picado hacia el suelo. Al llegar al suelo, la tinta explotará y se creará una zona de la que los enemigos no podrán escapar por las vías habituales. VUELVE A ACTIVAR la habilidad para que el proyectil caiga antes en un punto de su trayectoria.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Fade'),
        'TORMENTO',
        'Equipa una pesadilla. DISPARA para lanzar el orbe que, tras un determinado periodo de tiempo, caerá en picado hacia el suelo. Al llegar al suelo, el orbe se convertirá en una pesadilla que revelará la ubicación de los enemigos que se encuentren en su línea de visión. Los enemigos pueden destruir la pesadilla. VUELVE A ACTIVAR la habilidad para que el proyectil caiga antes en un punto de su trayectoria.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Fade'),
        'ACECHADOR',
        'EQUIPA un Acechador. DISPARA para enviar al Acechador, que se desplazará en línea recta. El Acechador se adherirá a los enemigos o rastros situados en su cono de visión frontal y los perseguirá. Si los alcanza, reducirá sus campos de visión. MANTÉN PULSADO el botón de DISPARAR para dirigir al Acechador en la dirección de la mira.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Fade'),
        'OCASO',
        'EQUIPA el poder del miedo. DISPARA para emitir una oleada de energía terrorífica capaz de atravesar paredes. Esta energía deja un rastro hasta el oponente y, además, lo ensordece y aplica declive.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Omen'),
        'PARANOIA',
        'Dispara INSTANTÁNEAMENTE un proyectil sombrío hacia delante que reduce brevemente el alcance de la visión de todos los jugadores que toca. El proyectil puede atravesar paredes.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Omen'),
        'VELO TENEBROSO',
        'EQUIPA un orbe sombrío y te adentras en un mundo paralelo para colocarlo y marcar el objetivo de los orbes. PULSA la tecla de la habilidad para lanzar el orbe sombrío a la ubicación señalada, lo que genera una esfera sombría de larga duración que bloquea la visión. MANTÉN PULSADO el botón de disparar al apuntar para que el marcador se aleje más. MANTÉN PULSADO el DISPARO ALTERNATIVO al apuntar para que el marcador se acerque más. PULSA RECARGAR para cambiar al modo de apuntado normal.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Omen'),
        'APARICIÓN TENEBROSA',
        'EQUIPA una habilidad para caminar entre las sombras y muestra su indicador de alcance. DISPARAD para iniciar un breve periodo de canalización y después teleportaros a la ubicación señalada.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Omen'),
        'DESDE LAS SOMBRAS',
        'EQUIPA un mapa táctico. DISPARAD para empezar a teleportaros a la ubicación seleccionada. Mientras se teleporta, Omen aparecerá como una sombra que los enemigos pueden destruir para cancelar su teleportación.',
        'X');
        
INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Brimstone'),
        'INCENDIARIO',
        'EQUIPA un lanzagranadas incendiarias. DISPARAD una granada que detona cuando se detiene en el suelo, lo que genera una zona de fuego persistente que daña a los jugadores que estén en su interior.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Brimstone'),
        'CORTINA DE HUMO',
        'EQUIPA un mapa táctico. DISPARA para fijar ubicaciones en las que aparecerán nubes de humo de Brimstone. ALTERNA EL MODO DE DISPARO para confirmar. Esto liberará nubes de humo de larga duración que bloquearán la visión en la zona seleccionada.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Brimstone'),
        'BALIZA ESTIMULANTE',
        'EQUIPA una baliza estimulante. DISPARAD para lanzar la baliza estimulante frente a Brimstone. Al aterrizar, la baliza estimulante creará un campo que otorgará Disparo rápido a los jugadores.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Brimstone'),
        'GOLPE ORBITAL',
        'EQUIPA un mapa táctico. DISPARAD para lanzar un golpe orbital en la ubicación objetivo con un láser persistente, que provocará un gran daño prolongado a los jugadores que se encuentren en la zona seleccionada.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Astra'),
        'PULSO NOVA',
        'Coloca estrellas en Forma astral. ACTIVA una estrella para detonar un Pulso nova. El Pulso nova se carga brevemente y explota, lo que aturde a todos los jugadores en la zona.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Astra'),
        'NEBULOSA',
        'Coloca estrellas en Forma astral. ACTIVA una estrella para transformarla en una Nebulosa (humo). USA una estrella para disiparla, lo que recupera la estrella para poder volver a colocarla tras un tiempo. Disipar una estrella crea una breve Nebulosa falsa en su ubicación antes de recuperarla.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Astra'),
        'POZO GRAVITATORIO',
        'Coloca estrellas en Forma astral (X). ACTIVA una estrella para crear un Pozo gravitatorio. Atrae hacia el centro a todos los jugadores en la zona antes de que explote, lo que causa que todos los jugadores atrapados en el interior se vuelvan vulnerables.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Astra'),
        'FORMA ASTRAL / SEPARACIÓN CÓSMICA',
        'ACTIVA para entrar en Forma astral y poder colocar estrellas con el DISPARO. Las estrellas se pueden reactivar más tarde para transformarlas en un Pulso nova, una Nebulosa o un Pozo gravitatorio. Cuando Separación cósmica está cargada, usa el DISPARO ALTERNATIVO en Forma astral para empezar a apuntar y, a continuación, el DISPARO para e legir dos ubicaciones. Se creará una Separación cósmica infinita que conecte los dos puntos. Separación cósmica bloquea las balas y atenúa en gran medida los sonidos.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Clove'),
        'TEJEMANEIE',
        'EQUIPA un fragmento de esencia inmortal. DISPARA para lanzar el fragmento, que entrará en erupción tras un breve lapso de tiempo y aplicará declive de forma temporal a todos los objetivos que se encuentren en su interior.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Clove'),
        'TRETA',
        'EQUIPA para ver el campo de batalla. DISPARA para fijar ubicaciones en las que aparecerán las nubes de Clove. ALTERNA EL MODO DE DISPARO para confirmar. Esto liberará nubes que bloquearán la visión en las zonas seleccionadas. Clove puede usar esta habilidad tras morir.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Clove'),
        'CHUTE DE ENERGÍA',
        'Absorbe INSTANTÁNEAMENTE la fuerza vital de un enemigo caído al que Clove haya infligido daño o asesinado. Esto le otorga velocidad y vida de forma temporal.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Clove'),
        'NO ME VOY',
        'Tras morir, ACTIVA para resucitar. Al resucitar, Clove debe conseguir un asesinato o una asistencia de daño durante un periodo de tiempo determinado o morirá.',
        'X');        

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Chamber'),
        'CAZADOR DE CABEZAS',
        'ACTÍVALA para equipar una pistola pesada. Utiliza el botón de modo de DISPARO ALTERNATIVO para apuntar con la mira.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Chamber'),
        'RENDEZ-VOUS',
        'EQUIPA un anclaje de teleportación. DISPARA para colocarla en el suelo. Mientras esté en el suelo y al alcance, REACTIVA la habilidad para teleportarte rápidamente al anclaje. El anclaje se puede recoger para VOLVER A COLOCARLO.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Chamber'),
        'MARCA REGISTRADA',
        'EQUIPA una trampa que escanea en busca de enemigos. DISPARA para colocarla en el suelo. Cuando un enemigo visible entra en el alcance, la trampa inicia una cuenta atrás y, a continuación, desestabiliza el terreno a su alrededor, lo que crea un campo persistente que ralentiza a los jugadores que se encuentren en su interior. El anclaje se puede recoger para VOLVER A COLOCARLO.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Chamber'),
        'TOUR DE FORCE',
        'ACTÍVALA para invocar un poderoso rifle de francotirador personalizado que mata a los enemigos con cualquier impacto directo en la parte superior del cuerpo. ALTERNA EL MODO DE DISPARO para apuntar con la mira. Matar a un enemigo genera un campo persistente que ralentiza a los jugadores que se encuentren en su interior.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Neon'),
        'PROYECTIL ELECTRIZANTE',
        'Lanza INSTANTÁNEAMENTE un rayo de energía que rebota una vez. Al golpear cada superficie, el rayo electrifica el suelo bajo ella con una explosión aturdidora.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Neon'),
        'CAMBIO DE MARCHA',
        'Canaliza INSTANTÁNEAMENTE el poder de Neon para aumentar su velocidad. Cuando esté cargada, utilizad el DISPARO ALTERNATIVO para activar un deslizador eléctrico. La carga del deslizador se reinicia con cada dos asesinatos.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Neon'),
        'VÍA RÁPIDA',
        'DISPARA dos líneas de energía hacia delante por el suelo. Dichas líneas se desplazan una corta distancia o hasta chocar contra algún obstáculo. Entonces, las líneas se alzan para convertirse en muros de energía estática que bloquean la visión e infligen daño a los enemigos que los atraviesan.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Neon'),
        'SOBRECARGA',
        'Neon desata todo su poder y velocidad durante un breve periodo de tiempo. DISPARAD para canalizar su poder en un mortífero rayo móvil y preciso. Su duración se reinicia con cada asesinato.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Reyna'),
        'DEVORAR',
        'Los enemigos asesinados por Reyna dejan tras de sí orbes de alma que duran 3 segundos. Consume INSTANTÁNEAMENTE un orbe de alma cercano y se cura durante un breve periodo. Si se obtienen más de 100 puntos de vida con esta habilidad, la cantidad adicional se irá perdiendo con el tiempo. Si EMPERATRIZ está activa, esta habilidad se lanzará de forma automática y no consumirá el orbe.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Reyna'),
        'DESPRECIAR',
        'Consume INSTANTÁNEAMENTE un orbe de alma cercano y se vuelve intangible durante un breve periodo. Si EMPERATRIZ está activa, se vuelve invisible también.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Reyna'),
        'MIRADA LASCIVA',
        'EQUIPA un ojo etéreo e indestructible. ACTIVADLA para lanzar el ojo hacia delante una corta distancia. El ojo limitará la visión de todos los enemigos que lo miren.',
        'C'),
       ((SELECT ID_AG from AGENTES where NOMBRE_AG = 'Reyna'),
        'EMPERATRIZ',
        'Entra en un frenesí INSTANTÁNEO que aumenta drásticamente la velocidad de disparo, de equipamiento y de recarga. Conseguir un asesinato reinicia la duración.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Sage'),
        'ORBE DE RALENTIZACIÓN',
        'EQUIPA un orbe de ralentización. DISPARAD para lanzar hacia adelante un orbe de ralentización que explota al aterrizar, lo que genera un campo persistente que ralentiza a los jugadores que se encuentren en su interior.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Sage'),
        'ORBE DE SANACIÓN',
        'EQUIPA un orbe de sanación. DISPARAD con la mira sobre un aliado herido para curarlo durante un breve periodo. ALTERNAD EL MODO DE DISPARO si Sage ha recibido daño para que se cure a sí misma durante un breve periodo.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Sage'),
        'ORBE BARRERA',
        'EQUIPA un orbe barrera. DISPARAD para colocar una pared sólida. Alternad el MODO DE DISPARO para rotarla antes de crearla.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Sage'),
        'RESURRECCIÓN',
        'EQUIPA una habilidad de resurrección. DISPARAD con la mira sobre un aliado muerto para empezar a resucitarlo. Tras un breve periodo de canalización, el aliado resucitará con toda la vida.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Killjoy'),
        'BOT DE ALARMA',
        'EQUIPA un bot de alarma camuflado. DISPARA para desplegar un bot que dará caza a los enemigos que estén dentro del alcance. Tras alcanzar su objetivo, el bot explota y aplica vulnerabilidad. MANTÉN PULSADO EQUIPAR para recoger un bot desplegado.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Killjoy'),
        'TORRETA',
        'EQUIPA una torreta. DISPARA para desplegar una torreta que dispara a los enemigos en un cono de 180 grados. MANTÉN PULSADO EQUIPAR para recoger la torreta desplegada.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Killjoy'),
        'NANOENJAMBRE',
        'EQUIPA una granada de nanoenjambre. DISPARA para lanzar la granada. Cuando aterriza, la granada enjambre se camufla. ACTIVA el nanoenjambre para desplegar un enjambre de nanobots.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Killjoy'),
        'BLOQUEO',
        'EQUIPA el dispositivo de bloqueo. DISPARA para desplegar el dispositivo. Tras un largo periodo de carga, el dispositivo detiene a todos los enemigos que estén dentro del radio de efecto. Los enemigos pueden destruir el dispositivo.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Viper'),
        'NUBE VENENOSA',
        'EQUIPA una granada de gas. DISPARA para lanzar la granada, que permanecerá toda la ronda. VUELVE A USAR la habilidad para generar una nube de gas tóxico a cambio de combustible. La granada se puede recoger para VOLVER A COLOCARLA antes de que empiece la ronda y se puede VOLVER A USAR más de una vez durante la ronda.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Viper'),
        'PANTALLA TÓXICA',
        'EQUIPA un lanzagranadas de gas. DISPARAD para desplegar una larga hilera de granadas de gas que se pueden reactivar para crear un alto muro de gas tóxico a cambio de combustible. Se puede VOLVER A USAR más de una vez..',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Viper'),
        'VENENO DE SERPIENTE',
        'EQUIPA un lanzador químico. DISPARAD para lanzar un cartucho que se rompe al impactar contra el suelo, lo que genera una zona química persistente que daña a los enemigos.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Viper'),
        'POZO DE LA VÍBORA',
        'EQUIPA un pulverizador químico. DISPARAD para pulverizar una nube química en todas direcciones alrededor de Viper, lo que genera una gran nube que reduce el alcance de la visión y la vida máxima de los jugadores que se encuentren dentro de ella.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Harbor'),
        'CALA',
        'EQUIPA una esfera de agua protectora. DISPARA para lanzarla. ALTERNA EL MODO DE DISPARO para lanzarla por debajo del hombro. Al impactar contra el suelo, genera un escudo de agua destructible que bloquea las balas.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Harbor'),
        'MAREA ALTA',
        'EQUIPA una pared de agua. DISPARA para lanzarla hacia adelante por el suelo. MANTÉN PULSADO para guiar el agua en la dirección de la mira, atravesando los obstáculos del terreno y creando una pared por todo el recorrido. ALTERNA EL MODO DE DISPARO mientras trazas la pared para acabarla antes de tiempo. Los jugadores golpeados se ven ralentizados.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Harbor'),
        'CASCADA',
        'EQUIPA una ola de agua. DISPARA para enviarla hacia delante y hacer que atraviese las paredes. ÚSALA DE NUEVO para detener la ola. Los jugadores golpeados se ven ralentizados.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Harbor'),
        'AJUSTE DE CUENTAS',
        'EQUIPA todo el poder de tu artefacto. DISPARA para invocar un géiser que nace del suelo. Los enemigos de la zona serán objetivo de varios ataques del géiser. Los jugadores que se vean atrapados por un impacto quedan aturdidos.',
        'X');

INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Cypher'),
        'PRISIÓN CIBERNÉTICA',
        'Lanza INSTANTÁNEAMENTE una prisión cibernética frente a Cypher. ACTIVADLA para crear una zona que bloquea la visión de los enemigos que la atraviesan.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Cypher'),
        'CÁMARA ESPÍA',
        'EQUIPA una cámara espía, DISPARA para colocar la cámara espía en la ubicación objetivo. VUELVE A USAR esta habilidad para controlar la visión de la cámara. Cuando tengas control de la cámara, DISPARA para lanzar un dardo marcador que revelará la ubicación de cualquier jugador alcanzado. El anclaje se puede recoger para VOLVER A COLOCARLO.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Cypher'),
        'CABLE TRAMPA',
        'EQUIPA un cable trampa. DISPARAD para colocar un cable trampa destructible pero oculto en la ubicación objetivo. Creará una línea que se extiende entre la ubicación en la que se ha colocado y la pared opuesta. Los jugadores enemigos que atraviesen un cable trampa quedarán anclados, revelados y aturdidos tras un breve lapso si no logran destruir el dispositivo a tiempo. El cable trampa se puede recoger para VOLVER A COLOCARLO.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Cypher'),
        'HURTO NEURONAL',
        'Usadla INSTANTANEAMENTE sobre un enemigo muerto en vuestra mira para revelar la posición de todos los jugadores enemigos vivos.',
        'X');
        
INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Deadlock'),
        'SENSOR SÓNICO',
        'EQUIPA un Sensor sónico. DISPARA para desplegarlo. El sensor rastrea la zona en busca de enemigos que hagan ruido. Si detecta sonidos de pisadas, disparos o cualquier otro ruido considerable, aturde en área.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Deadlock'),
        'MALLA BARRERA',
        'EQUIPA un disco de Malla barrera. DISPARA para lanzarlo hacia delante. Al aterrizar, el disco genera barreras a partir de su punto de origen que detienen el movimiento de los personajes.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Deadlock'),
        'RED DE GRAVEDAD',
        'EQUIPA una granada de Red de gravedad. DISPARA para lanzarla. ALTERNA EL MODO DE DISPARO para lanzarla por debajo del hombro. La Red de gravedad explota al aterrizar, lo que fuerza a los enemigos alcanzados a agacharse y moverse lentamente.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Deadlock'),
        'ANIQUILACIÓN',
        'EQUIPA un acelerador de nanocables. DISPARA para emitir un pulso de nanocables que capturan al primer enemigo con el que entran en contacto. El enemigo atrapado se ve arrastrado y muere si llega al final del recorrido, a menos que sea liberado. La envoltura de los nanocables se puede destruir.',
        'X');
        
INSERT INTO HABILIDADES_AGENTES (ID_AG_PER, NOMBRE_HAB, DESCRIP_HAB, TIPO_HAB)
VALUES ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Vyse'),
        'CIZALLAS',
        'EQUIPA filamentos de metal líquido. DISPARA para colocar un muro trampa oculto. Cuando un enemigo lo atraviese, un muro indestructible surgirá del suelo a su paso. El muro dura un breve periodo de tiempo antes de disiparse.',
        'Q'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Vyse'),
        'ROSA METÁLICA',
        'EQUIPA un rosal. Apunta a una superficie y DISPARA para colocar un rosal invisible o ALTERNA EL MODO DE DISPARO para colocarlo atravesado. VUELVE A LANZARLO para cegar a todos los jugadores que estén mirando en su dirección.',
        'E'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Vyse'),
        'ZARZAL LACERANTE',
        'EQUIPA un amasijo de metal líquido. DISPARA para lanzarlo. Al aterrizar, el amasijo se vuelve invisible. Al ACTIVARSE, se extiende para formar un zarzal lacerante que ralentiza y daña a todos los jugadores que lo atraviesen.',
        'C'),
       ((SELECT ID_AG FROM AGENTES WHERE NOMBRE_AG = 'Vyse'),
        'JARDÍN DE ACERO',
        'EQUIPA una zarza de metal líquido. DISPARA para lanzar el metal que surge de tu interior como un torrente de espinas de metal, INUTILIZANDO las armas principales de los enemigos tras un breve tiempo de carga.',
        'X');        