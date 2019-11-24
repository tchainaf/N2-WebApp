package ftt.webapp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import ftt.webapp.dao.PessoaDAO;
import ftt.webapp.model.Pessoa;

@WebServlet("/agenda")
public class AgendaApi extends HttpServlet {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    PessoaDAO dao;

    public AgendaApi() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        response.getWriter()
                .append(request.getParameter("id")).append(";")
                .append(request.getParameter("name")).append(";")
                .append(request.getParameter("tel")).append(";")
                .append(request.getParameter("email")).append(";")
                .append(request.getParameter("end")).append(";")
                .append(request.getParameter("dataNasc"));

        System.out.println(request);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Pessoa p = new Pessoa();
        String status = "OK";
        String message = "Pessoa inserida na agenda com sucesso!";
        String now = String.valueOf(new Date());

        try {
            p.setNome(request.getParameter("nome"));
            p.setTelefone(request.getParameter("tel"));
            p.setEmail(request.getParameter("email"));
            p.setEndereco(request.getParameter("end"));
            p.setDataNasc(formatter.parse(request.getParameter("data")));

            if (dao == null)
                dao = new PessoaDAO();

            dao.Inserir(p);

        } catch (Exception e) {
            status = "Error";
            message = e.getMessage();
            System.err.println(now +  " - Erro: " + message);
            System.err.println(now +  " - Erro: " + p);
            e.printStackTrace();
        }

        response.setContentType("application/json"); //MIME Type
        response.setCharacterEncoding("utf-8");

        JsonObject json = new JsonObject();

        json.addProperty("Status", status);
        json.addProperty("Message", message);
        json.addProperty("Time", now);

        response.getWriter().print(json.toString());
        response.flushBuffer();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}