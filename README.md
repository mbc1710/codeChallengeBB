# codeChallengeBB
code challenge entregables

comandos para crear imagen del api, cambiar el valor {sustituir ruta} por la de su local:
cd {sustituir ruta}/codeChallenge/docker/banco-base/
docker-compose build --no-cache

Ejecutar el comando para levantar los contenedores en la siguiente ruta: {sustituir ruta}/codeChallenge/docker/
cd ..
docker-compose --compatibility up -d

importar la colleccion a postman del archivo 
code challenge.postman_collection.json
ó
http://localhost:8080/api/swagger-ui/index.html

el codigo fuente esta en esta carpeta:
-codeChallenge
  -codeChallenge (codigo java del API)
  -docker (archivos docker)
    - sql (script base de datos)
    - banco-base (archivos para imagen de API)
    
![image](https://github.com/user-attachments/assets/b6e5bf00-430b-43aa-9dfa-b861e1668265)
