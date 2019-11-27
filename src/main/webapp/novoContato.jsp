<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Novo Contato</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        .panel {
            max-width: 600px;
            margin: auto;
            margin-top: 5%;
        }
        .panel-heading {
            font-size: large;
        }
        button {
            margin: 0px 10px 0px 0px;
        }
    </style>
    <script>

    </script>
</head>
<body>
<form class="form-horizontal" method="post" action="/agenda">
    <div class="panel panel-primary">
        <div class="panel-heading">Novo Contato</div>

        <div class="panel-body">
            <div class="form-group">
                <div class="form-group">
                    <label class="col-md-5 control-label" for="id">ID:</label>
                    <div class="col-md-5">
                        <input id="id" name="id" type="number" class="form-control input-md" disabled>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-5 control-label" for="nome">Nome:</label>
                    <div class="col-md-5">
                        <input id="nome" name="nome" type="text" class="form-control input-md" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-5 control-label" for="tel">Telefone:</label>
                    <div class="col-md-5">
                        <input id="tel" name="tel" type="text" class="form-control input-md" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-5 control-label" for="email">E-Mail:</label>
                    <div class="col-md-5">
                        <input id="email" name="email" type="email" class="form-control input-md" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-5 control-label" for="end">Endereço:</label>
                    <div class="col-md-5">
                        <input id="end" name="end" type="text" class="form-control input-md" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-5 control-label" for="data">Data de Nascimento:</label>
                    <div class="col-md-5">
                        <input id="data" name="data" type="date" class="form-control input-md">
                    </div>
                </div>
                <div style="text-align:center;">
                    <button type="button" id="Voltar" name="Voltar" class="btn" onclick='window.location="index.jsp"'>Voltar</button>
                    <button type="reset" id="Limpar" name="Limpar" class="btn btn-danger">Limpar</button>
                    <button type="submit" id="Cadastrar" name="Cadastrar" class="btn btn-success">Cadastrar</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>