Pre-Requisitos:
1. maven instalado https://maven.apache.org/download.cgi
2. servidor utilizado tom cat versao >= 9.0
3. servico de banco de dados (postgres/mysql) ou pd levantar u mcontainer docker com docker run -d --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=12345 -e -p 5432:5432 postgres:latest
4. (opcional ferramenta de interface de banco de dados) docker run --link postgres:db -p 8081:8081 adminer

Rodar:
1. em algum serviço de banco de dados rode o script para criação do banco que esta na pasta java-funcionarios -> java resources -> META-INF -> sql.sql
2. faça o download do projeto
3. no arquivo pom.xml clique com btn direito do mouse escolha a opção runAs e click em maven install
4. se acontecer algum problema durente a instalação vc pode clicar com bnt direito do mouse e vai em maven e clica em upload projet ![image](https://github.com/SSar4/p/assets/33840492/814b125d-0c57-4892-a40c-5aa140a2c0a5)
5. configurar o servidor. depois da instalação do tom cat na aba servers da um duplo click no nome do servidor ![image](https://github.com/SSar4/p/assets/33840492/789c18ad-e86c-490f-a29d-1356c59c426f)
6. em server location marca a 2 opção e em server option tbm ![image](https://github.com/SSar4/p/assets/33840492/18f52252-fdac-4d9b-aafa-3decc937f441)
7. depois clica na raiz do projeto click em run as e escolher a opção run on server
8. se o eclipse nao abrir a aba do navegador automaticamente voce pode ir em http://localhost:8080/java-funcionarios/index.xhtml
