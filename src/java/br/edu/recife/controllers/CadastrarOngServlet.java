/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.recife.controllers;

import br.edu.ifpe.recife.model.negocio.Ong;
import br.edu.ifpe.recife.model.repositorios.RepositorioOng;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALUNO
 */
@WebServlet(name = "CadastrarOngServlet", urlPatterns = {"/CadastrarOngServlet"})
public class CadastrarOngServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        Long cnpj = Long.parseLong(request.getParameter("cnpj"));
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");;
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String especialidade = request.getParameter("especialidade");
        
        Ong ong = new Ong();
        
        ong.setCodigo(codigo);
        ong.setCnpj(cnpj);
        ong.setSenha(senha);
        ong.setNome(nome);
        ong.setEndereco(endereco);
        ong.setEmail(email);
        ong.setTelefone(telefone);
        ong.setEspecialidade(especialidade);
         
        RepositorioOng.create(ong);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastrarOngServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ong: " + nome + " <br>Cadastro com sucesso!</h1>");
            out.println("<h2>Especialidade: " + especialidade + "</h2>");
            out.println("<h3>Cadastro com sucesso!</h3>");
            out.println("<a href='CadastroDeOng.html'>Cadastrar nova Ong");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
