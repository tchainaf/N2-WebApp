package ftt.webapp.dao;

import ftt.webapp.model.Pessoa;
import ftt.webapp.util.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDAO extends PadraoDAO{

    public PessoaDAO() {
        conn = Database.getConnection();
    }

    public boolean Inserir(Pessoa pessoa) {
        try {
            CallableStatement stm = conn.prepareCall("{call SP_INSERE_PESSOA (?, ?, ?, ?, ?)}");

            stm.setString("NOME", pessoa.getNome());
            stm.setString("TELEFONE", pessoa.getTelefone());
            stm.setString("EMAIL", pessoa.getEmail());
            stm.setString("ENDERECO", pessoa.getEndereco());
            stm.setDate("DATANASC", new java.sql.Date(pessoa.getDataNasc().getDate()));

            stm.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Alterar(Pessoa pessoa) {
        try {
            CallableStatement stm = conn.prepareCall("{call SP_ATUALIZA_PESSOA (?, ?, ?, ?, ?, ?)}");

            stm.setInt("ID", pessoa.getId());
            stm.setString("NOME", pessoa.getNome());
            stm.setString("TELEFONE", pessoa.getTelefone());
            stm.setString("EMAIL", pessoa.getEmail());
            stm.setString("ENDERECO", pessoa.getEndereco());
            stm.setDate("DATANASC", new java.sql.Date(pessoa.getDataNasc().getDate()));

            stm.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Deletar(int id) {
        try {
            CallableStatement stm = conn.prepareCall("{call SP_EXCLUI_PESSOA (?)}");
            stm.setInt("ID", id);
            stm.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Pessoa Ler(int id) {
        try {
            CallableStatement stm = conn.prepareCall("{call SP_CONSULTA_PESSOA (?)}");
            stm.setInt("ID", id);
            ResultSet result = stm.executeQuery();
            result.next();

            Pessoa pessoa = new Pessoa();
            pessoa.setId(result.getInt("ID"));
            pessoa.setNome(result.getString("NOME"));
            pessoa.setTelefone(result.getString("TELEFONE"));
            pessoa.setEmail(result.getString("EMAIL"));
            pessoa.setEndereco(result.getString("ENDERECO"));
            pessoa.setDataNasc(result.getDate("DATANASC"));

            return pessoa;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Pessoa> Listar() {
        ObservableList<Pessoa> list = FXCollections.observableArrayList();
        try {
            CallableStatement stm = conn.prepareCall("{call SP_LISTA_PESSOA}");
            ResultSet result = stm.executeQuery();

            while (result.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(result.getInt("ID"));
                pessoa.setNome(result.getString("NOME"));
                pessoa.setTelefone(result.getString("TELEFONE"));
                pessoa.setEmail(result.getString("EMAIL"));
                pessoa.setEndereco(result.getString("ENDERECO"));
                pessoa.setDataNasc(result.getDate("DATANASC"));
                list.add(pessoa);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
