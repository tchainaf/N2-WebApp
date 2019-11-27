package ftt.webapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ftt.webapp.dao.PessoaDAO;
import ftt.webapp.model.Pessoa;
import javafx.collections.ObservableList;

@WebServlet("/agenda")
public class AgendaApi extends HttpServlet {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    PessoaDAO dao;

    public AgendaApi() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            if (dao == null)
                dao = new PessoaDAO();

            if (request.getParameter("id") == null) {
                ObservableList<Pessoa> lista = dao.Listar();
                request.setAttribute("contatos", lista);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                Pessoa p = dao.Ler(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("pessoa", p);
                request.getRequestDispatcher("/infoContato.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Pessoa p = new Pessoa();

        try {
            p.setNome(request.getParameter("nome"));
            p.setTelefone(request.getParameter("tel"));
            p.setEmail(request.getParameter("email"));
            p.setEndereco(request.getParameter("end"));
            p.setDataNasc(formatter.parse(request.getParameter("data")));

            if (dao == null)
                dao = new PessoaDAO();

            if(dao.Inserir(p)){
                response.sendRedirect("index");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Pessoa p = new Pessoa();

        try {
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setNome(request.getParameter("nome"));
            p.setTelefone(request.getParameter("tel"));
            p.setEmail(request.getParameter("email"));
            p.setEndereco(request.getParameter("end"));
            p.setDataNasc(formatter.parse(request.getParameter("data")));

            if (dao == null)
                dao = new PessoaDAO();

            if(dao.Alterar(p)){
                response.sendRedirect("index");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            if (dao == null)
                dao = new PessoaDAO();

            if(dao.Deletar(Integer.parseInt(request.getParameter("id")))){
                response.sendRedirect("index");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}