# **Proyecto de Gestión de Productos en Spring Boot**

Este proyecto es una aplicación básica de gestión de productos que utiliza un CRUD (Crear, Leer, Actualizar, Eliminar) para manejar un catálogo de productos. La aplicación está construida con Spring Boot y utiliza una lista en memoria para almacenar los productos, sin necesidad de una base de datos externa.

# **Características:**
CRUD Completo: Operaciones básicas de creación, lectura, actualización y eliminación de productos.
Identificadores Únicos con UUID: Cada producto tiene un identificador único generado automáticamente con UUID.
Gestión en Memoria: Los productos se almacenan temporalmente en una lista en memoria.
Endpoints REST: Los productos pueden ser gestionados a través de llamadas HTTP utilizando controladores REST.

# **Tecnologías:**
Spring Boot: Framework principal para la construcción de la API REST.
Java 11+: Lenguaje de programación utilizado.
UUID: Identificadores únicos universales generados automáticamente para cada producto.

# **Endpoints de la API:**
GET /productos: Obtiene una lista de todos los productos.

GET /productos/{id}: Obtiene un producto específico por su id (UUID).

POST /productos: Crea un nuevo producto. El id se genera automáticamente.

PUT /productos/{id}: Actualiza un producto existente por su id.

DELETE /productos/{id}: Elimina un producto por su id.
