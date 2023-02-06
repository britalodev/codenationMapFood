## Detalhes técnicos

### Configuração do ambiente de Desenvolvimento

Primeiro faça o clone do projeto.

**Carga de dados**  
Para realizar a primeira carga de dados no MongoDB com os dados fornecidos nos CSVs, 
execute o seguinte comando na pasta raíz do projeto:
```aidl
docker-compose up
```
Este comando fará com que o MongoDB e a Aplicação MapFood sejam rodados. Em seguida acesse:

[Carga](http://localhost:8080/mapfood/load)

**Testar a aplicação**  
Em desenvolvimento, rode seguinte comando para testar a a aplicação:
```aidl
mvn clean install
```

### Swagger

Para acessar o Swagger certifique-se que a aplicação está rodando e em seguida acesse:

[Swagger](http://localhost:8080/mapfood/swagger-ui.html)


--- ----
🇬🇧🇬🇧🇬🇧
## Technical details

### Development environment setup

First clone the project.

**Data load**
To perform the first data load into MongoDB with the data provided in the CSVs,
run the following command in the root folder of the project:
``` aidl
docker-compose up
```
This command will run MongoDB and the MapFood Application. Then go to:

[Load](http://localhost:8080/mapfood/load)

**Test the application**
In development, run the following command to test the application:
``` aidl
mvn clean install
```

### Swagger

To access Swagger make sure the application is running and then access:

[Swagger](http://localhost:8080/mapfood/swagger-ui.html)
