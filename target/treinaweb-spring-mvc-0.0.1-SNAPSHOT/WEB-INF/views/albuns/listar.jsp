<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Listagem de álbuns</h2>
<br />

<table class="table">
	<thead>
		<th>ID</th>
		<th>Nome do álbum</th>
		<th>Ano de lançamento</th>
		<th>Ações</th>
	</thead>
	<tbody>
		<c:if test="${!empty albuns}">
			<c:forEach items="${albuns}" var="album">
				<tr>
					<td>${album.id}</td>
					<td>${album.nome}</td>
					<td>${album.anoDeLancamento}</td>
					<td>
						<a href="/treinaweb-spring-mvc/albuns/alterar/${album.id}">Alterar</a>|
						<a href="/treinaweb-spring-mvc/albuns/excluir/${album.id}">Excluir</a>|
					</td>
				</tr>			
			</c:forEach>		
		</c:if>
	</tbody>
</table>
<br/>

<a href="/treinaweb-spring-mvc/albuns/adicionar" class="btn btn-outline-primary btn-lg">Adicionar novo Album</a>