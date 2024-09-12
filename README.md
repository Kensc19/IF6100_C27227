# IF6100_C27227

- Laboratorio 1 Configuración
- Se crea proyecto y configuran algunos archivos.


- Laboratorio 2 
- Configuración de bases de datos 
- User Entity

- Laboratorio 3
- **HelloController.java**: Actualizado para reflejar cambios en el flujo de registro de usuarios.
- **RegisterUserHandler.java**: Modificaciones en la interfaz para soportar la nueva lógica de validación y mapeo.
- **RegisterUserHandlerimpl.java**: Se implementaron métodos adicionales de validación (`validateInvalidFields`, `validateUserExists`, y `validateEmail`) y se mejoró el mapeo de la entidad de usuario.
- **UserRepository.java**: Se agregó una consulta nativa para `findByName` y se incluyó el método `countByEmail` para optimizar la verificación de existencia de correos electrónicos.
- **application.properties**: Configuraciones actualizadas para soportar las nuevas características y consultas del repositorio.
