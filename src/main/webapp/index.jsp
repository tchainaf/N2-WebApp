<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Agenda</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script>
        deletarContato = function(id) {
            if(window.confirm("Quer excluir o contato?")){
                document.createElement(id);
                document.forms[0].action = "/agenda";
                document.forms[0].method = "delete";
                document.forms[0].submit();
            }
        };

        listarContatos = function() {
            document.forms[0].action = "/agenda";
            document.forms[0].method = "get";
            document.forms[0].submit();
        };
    </script>
</head>
<body>
    <form>
    <div class="container">
        <div class="btn-toolbar">
            <button type="button" class="btn btn-primary" onclick='window.location="novoContato.jsp"'>Novo Contato</button>
        </div>
        <div class="well">
            <table class="table" id="agenda">
                <thead>
                    <tr>
                        <th hidden>Id</th>
                        <th>Nome</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th style="width: 40px;"></th>
                    </tr>
                </thead>

                <tbody>
                    <!--<c:forEach var="pessoa" items="${requestScope.contatos}">-->
                        <tr>
                            <td hidden></td><!--${pessoa.id}-->
                            <td>Nome da pessoa</td><!--${pessoa.nome}-->
                            <td>Telefone da pessoa</td><!--${pessoa.telefone}-->
                            <td>Email da pessoa</td><!--${pessoa.email}-->
                            <td>
                                <a href="infoContato.jsp"><i class="icon-pencil"></i></a>
                                <a href="#" onclick="deletarContato(0);"><i class="icon-remove"></i></a>
                            </td>
                        </tr>
                    <!--</c:forEach>-->
                </tbody>
            </table>
        </div>
    </div>
    </form>
</body>
</html>