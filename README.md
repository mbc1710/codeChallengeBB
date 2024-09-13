# codeChallengeBB
code challenge entregables

1.- comandos para crear imagen del api, cambiar el valor {sustituir ruta} por la de su local:
  cd {sustituir ruta}/codeChallenge/docker/banco-base/
  docker-compose build --no-cache

2.- Ejecutar el comando para levantar los contenedores en la siguiente ruta: {sustituir ruta}/codeChallenge/docker/
  cd ..
  docker-compose --compatibility up -d

3.- importar la colleccion a postman del archivo 
  code challenge.postman_collection.json
  ó
  http://localhost:8080/api/swagger-ui/index.html

4.- Comando para ver la el topico del kafka:
docker exec -it kafka
kafka-console-consumer --bootstrap-server kafka:9092 --topic payments-topic --from-beginning


el codigo fuente esta en esta carpeta:
-codeChallenge
  -codeChallenge (codigo java del API)
  -docker (archivos docker)
    - sql (script base de datos)
    - banco-base (archivos para imagen de API)

Datos de conexion a la BD: password es password
![image](https://github.com/user-attachments/assets/b6e5bf00-430b-43aa-9dfa-b861e1668265)
