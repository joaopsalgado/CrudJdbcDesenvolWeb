<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="aluno.jpa.Aluno"%>
<html>

  <head>
    <title>Aluno</title>
  </head>

  <body>
  	<div class="container" style="text-align: center; margin-top:40px">
    <h1>Lista de Alunos</h1>
    <form style="text-align:center">
      <table style="text-align: center; margin-left: 503px;">
        <tr>
          <td>Idade</td>
          <td><input name="idade"></td>
        </tr>
        <tr>
          <td>Nome:</td>
          <td><input name="nome"></td>
        </tr>
        <tr>
          <td>Sobrenome:</td>
          <td><input name="sobrenome"></td>
        </tr>
      </table>
      <button name="escolha" value="incluir">Incluir</button>
      <button name="escolha" value="excluir">Excluir</button>
      <button name="escolha" value="alterar">Alterar</button>
    </form>
    <b>${msg}</b>
    <hr>
    <table border="1" style="margin-left: 396px">
      <th>Idade</th>
        <th>Nome</th>
        <th>Sobrenome</th>
        <th>Ações</th>
      </tr>
      <%
      ArrayList<Aluno> alunos =
        (ArrayList<Aluno>) request.getAttribute("aluno");
      for (Aluno aluno : alunos) {
      %>
      <tr>
        <td><%=aluno.getIdade()%></td>
        <td><%=aluno.getNome()%></td>
        <td><%=aluno.getSobrenome()%></td>
        <td><a href="alunos?escolha=excluir&idade=<%=aluno.getIdade()%>">Excluir</a></td>
      </tr>
      <%}%>
    </table>
  </body>
</div>
</html>