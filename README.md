# Dockerized API
Este es un proyecto de demostración para una API REST de Spring Boot con una base de datos PostgreSQL. El proyecto está configurado para ser ejecutado en contenedores Docker.

## Estructura del Proyecto
El proyecto sigue la estructura estándar de un proyecto Maven:

- **`src/main/java:`** Contiene el código fuente de la aplicación.
- **`pom.xml:`** El archivo de configuración de Maven.
- **`Dockerfile:`** El archivo Dockerfile para construir la imagen Docker de la aplicación.
- **`docker-compose.yml:`** El archivo de configuración de Docker Compose para ejecutar la aplicación y la base de datos en contenedores Docker.

## Variables de Entorno
El proyecto utiliza las siguientes variables de entorno para la configuración de la base de datos:

- `ENV_DATABASE_NAME:` El nombre de la base de datos.
- `ENV_DATABASE_USERNAME:` El nombre de usuario de la base de datos.
- `ENV_DATABASE_PASSWORD:` La contraseña de la base de datos.

>  [!NOTE]
> Debes crear un archivo .env en el directorio raíz del proyecto con las variables de entorno mencionadas anteriormente.

## Ejecución del Proyecto
Para ejecutar este proyecto, necesitarás tener Docker y Docker Compose instalados en tu máquina. Una vez que los tengas instalados, puedes seguir los siguientes pasos:

**Ejecuta el siguiente comando:**

```bash
docker compose up -d
```

Este comando construirá las imágenes y redes de Docker para la API de Spring Boot y la base de datos PostgreSQL con un volumen externo al contenedor que asegura la persistencia de los datos, y luego iniciará los contenedores.

## Endpoints de la API
A continuación, se describe el esquema del objeto a neviar y los endpoints de la API definidos en el controlador `DirectoryController`:

### Esquema del objeto a enviar
```json
{
   "name": "Angelo Torella",
   "emails": [
           "email1@example.com",
           "email2@example.com"
   ]
}
```
### GET /status 
Nos permite verificar que el API ya esta en funcionamiento y llegan las peticiones.

### GET /directories/{id}
Este endpoint devuelve un directorio específico basado en su ID. Si el directorio con el ID especificado no existe, devuelve un mensaje de error.

### POST /directories
Este endpoint crea un nuevo directorio. Acepta un cuerpo de solicitud que contiene los detalles del directorio a crear.

### PUT /directories/{id}
Este endpoint modifica un directorio existente basado en su ID. Acepta un cuerpo de solicitud que contiene los nuevos detalles del directorio. Si el directorio con el ID especificado no existe, devuelve un mensaje de error.

### PATCH /directories/{id}
Este endpoint modifica parcialmente un directorio existente basado en su ID. Acepta un cuerpo de solicitud que contiene los detalles del directorio a modificar. Si el directorio con el ID especificado no existe, devuelve un mensaje de error.

### DELETE /directories/{id}
Este endpoint elimina un directorio existente basado en su ID. Si el directorio con el ID especificado no existe, devuelve un mensaje de error.

### GET /directories
Este endpoint devuelve una lista paginada de todos los directorios. Acepta un parámetro de consulta page que indica el número de página a recuperar.

#### Es esquema del listado de objeto
```json
{
   "count": 1,
   "next": "link a siguiente página",
   "previous": "link a página previa",
   "results": [
        {
            "id": 1,
            "name": "Angelo Torella",
            "emails": [
                "email1@example.com",
                "email2@example.com"
            ]
        },
    ]
}
```