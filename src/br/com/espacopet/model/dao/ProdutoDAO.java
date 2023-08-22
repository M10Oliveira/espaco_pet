package br.com.espacopet.model.dao;

import br.com.espacopet.model.domain.EStatusVenda;
import br.com.espacopet.model.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProdutoDAO{

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Produto produto) {
        final String sql = "INSERT INTO produto(nome, descricao, preco) VALUES(?,?,?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            //registra o produto
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setBigDecimal(3, produto.getPreco());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean alterar(Produto produto) {
        String sql = "UPDATE produto SET nome=?, descricao=?, preco=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setBigDecimal(3, produto.getPreco());
            stmt.setInt(4, produto.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean remover(Produto produto) {
        String sql = "DELETE FROM produto WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Produto> listar() {
        String sql =  "SELECT * FROM produto;";
        List<Produto> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Produto produto = populateSingleVO(resultado);
                retorno.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    /**
     * Este método retorna uma lista de Produto de acordo com a situação do estoque 
     * @param situacao - Enum ESituacao
     * @return uma List de Produtos
     */
    public List<Produto> listar(EStatusVenda situacao) {
        //String sql =  "SELECT * FROM produto p INNER JOIN estoque e ON p.id = e.id_produto WHERE e.situacao = ?;";
        String sql =  "SELECT * FROM produto p INNER JOIN estoque e ON p.id = e.id_produto WHERE e.situacao = ?;";
        List<Produto> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, situacao.name());
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Produto produto = populateSingleVO(resultado);
                retorno.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }    
    
    

    public Produto buscar(Produto produto) {
        //String sql =  "SELECT * FROM produto p INNER JOIN estoque e ON p.id = e.id_produto WHERE p.id = ?;";
        String sql =  "SELECT * FROM produto WHERE id = ?;";
        Produto retorno = new Produto();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                retorno = populateFullVO(resultado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    
    private Produto populateFullVO(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        //dados do produto
        produto.setId(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setPreco(rs.getBigDecimal("preco"));        
        return produto;
    }  
    
    private Produto populateSingleVO(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        //dados do produto
        produto.setId(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setPreco(rs.getBigDecimal("preco"));
        
        
        return produto;        
    }
    
}
