<h1>Desafio T&eacute;cnico</h1>

<p>&nbsp;</p>

<p>Desenvolva uma API RESTful para possibilitar a leitura da lista de indicados e vencedores&nbsp;da categoria Pior Filme do Golden Raspberry Awards.</p>

<p>Ler o arquivo CSV dos filmes e inserir os dados em uma base de dados ao iniciar a aplica&ccedil;&atilde;o.</p>

<p>Obter o produtor com maior intervalo entre dois pr&ecirc;mios consecutivos, e o que obteve dois pr&ecirc;mios mais r&aacute;pido.</p>

<p>O documento completo que cont&eacute;m todas as informa&ccedil;&otilde;es do desafio encontram-se na raiz do projeto com a descri&ccedil;&atilde;o &quot;Especifica&ccedil;&atilde;o Backend.pdf&quot;.</p>

<p>&nbsp;</p>

<h2>Principais tecnologias utilizadas/requeridas para executar o projeto:</h2>

<ul>
	<li>Java vers&atilde;o 8</li>
	<li>Maven&nbsp;vers&atilde;o3.8.1</li>
	<li>Spring boot</li>
	<li>Spring MVC</li>
	<li>Spring data JPA</li>
	<li>H2 Database Engine</li>
</ul>

<p>&nbsp;</p>

<h2>Para executar o projeto</h2>

<h3>1. Pelo Prompt de Comando</h3>

<p>Navege at&eacute; a pasta raiz do programa</p>

<p>Execute o comando para iniciar o programa:&nbsp;mvn spring-boot:run</p>

<p>Execute o comando para acessar o endpoint:&nbsp;curl -X GET http://localhost:8080/film/findWinningProducersWithMinAndMaxRange</p>

<p>&nbsp;</p>

<h3>2. Pelo Maven</h3>

<p>Navege at&eacute; a pasta raiz do programa</p>

<p>Execute o comando para limpar a pasta target: ./mvnw clean</p>

<p>Execute o comando para gerar o pacote do programa:&nbsp;./mvn package</p>

<p>Execute o comando: java -jar target/&lt;nome-do-progamra-empacotado.jar&gt;</p>

<p>Execute o comando para acessar o endpoint:&nbsp;curl -X GET http://localhost:8080/film/findWinningProducersWithMinAndMaxRange</p>

<p>&nbsp;</p>

<h3>3. Pela IDE</h3>

<p>Abra a IDE</p>

<p>Execute o programa atrav&eacute;s do &quot;Play&quot;/&quot;Run&quot; de sua IDE de desenvolvimento preferida.</p>

<p>Execute o comando para acessar o endpoint:&nbsp;curl -X GET http://localhost:8080/film/findWinningProducersWithMinAndMaxRange</p>

<p>&nbsp;</p>

<h2>Intefaces para acessar o programa:</h2>

<h3>1. Postman ou Insomnia</h3>

<p>Execute o programa atrav&eacute;s do &quot;Play&quot;/&quot;Run&quot; de sua IDE de desenvolvimento preferida.</p>

<p>Abra o programa API Client</p>

<p>Escolhar o verbo GET</p>

<p>Digite na URL:&nbsp;http://localhost:8080/film/findWinningProducersWithMinAndMaxRange</p>

<p>Envie a requisi&ccedil;&atilde;o atrav&eacute;s do bot&atilde;o SEND</p>

<p>&nbsp;</p>

<h3>2. Swagger</h3>

<p>Execute o programa atrav&eacute;s do &quot;Play&quot;/&quot;Run&quot; de sua IDE de desenvolvimento preferida.</p>

<p>Abra um navegador de internet</p>

<p>Acesse o seguinte endere&ccedil;o:&nbsp;http://localhost:8080/swagger-ui/index.html#/</p>

<p>Clique em&nbsp;film-controller</p>

<p>Clique em GET</p>

<p>Clique em &quot;Try it out&quot;</p>

<p>Clique em &quot;Execute&quot;</p>

<p>&nbsp;</p>

<h2>Para executar os Teste</h2>

<h3>1. Pelo Maven</h3>

<p>Navege at&eacute; a pasta raiz do programa</p>

<p>Execute o seguinte comando: ./mvnw test</p>

<p>&nbsp;</p>

<h3>2. Pela IDE</h3>

<p>Abra a IDE</p>

<p>Execute os testes atrav&eacute;s do &quot;Play&quot;/&quot;Run&quot; de sua IDE de desenvolvimento preferida.</p>
