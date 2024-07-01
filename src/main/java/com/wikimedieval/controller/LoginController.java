package com.wikimedieval.controller;

import com.wikimedieval.dao.UsuarioDAO;
import com.wikimedieval.model.Usuario;
import com.wikimedieval.utils.ViewsManager;
import com.wikimedieval.views.BuscarMidiaView;
import com.wikimedieval.views.HomeView;
import com.wikimedieval.views.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView loginView;
    private UsuarioDAO usuarioDAO;
    private HomeView homeView;

    public LoginController(LoginView loginView, HomeView homeView) {
        this.loginView = loginView;

        ViewsManager.INSTANCE.addTela("loginView", this.loginView);
        this.usuarioDAO = new UsuarioDAO();
        this.homeView = homeView;

        this.loginView.getBuscarMidiaButton().addActionListener(e -> {
            if (ViewsManager.INSTANCE.verificarTela("buscarMidiaView")) {
                ViewsManager.INSTANCE.getTela("buscarMidiaView").setVisible(true);
                this.loginView.setVisible(false);
        } else {
            new BuscarMidiaController(new BuscarMidiaView(), this.homeView).iniciar();
        }
    });

        this.loginView.getEntrarButton().addActionListener( e -> {
                String email = loginView.getEmailField().getText();
                String senha = new String(loginView.getSenhaPasswordField().getPassword());
                Usuario usuario = usuarioDAO.getUsuarioByEmailAndPassword(email, senha);
                if (ViewsManager.INSTANCE.getUsuarioLogado() == null) {
                    JOptionPane.showMessageDialog(loginView, "Login bem-sucedido!");
                    ViewsManager.INSTANCE.setUsuarioLogado(usuario); // Define o usuário logado na HomeView
                    homeView.updateUserStatus(usuario.getNome()); // Atualiza o status do usuário
                    homeView.setVisible(true); // Esconde a tela de HomeView
                    homeView.getLogInButton().setText(usuario.getNome());
                    homeView.getLogInButton().addActionListener(event -> {
                        System.out.println("um dia vai ter logout");
                    });
                    //loginView.dispose();
                    loginView.setVisible(false);
                    homeView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(loginView, "Credenciais inválidas.");
                }
        });


        this.loginView.getCancelarButton().addActionListener(e -> {
                // Fechar a tela de login
                //loginView.dispose();
                loginView.setVisible(false);
                homeView.setVisible(true);
        });

        this.loginView.getHomeButton().addActionListener(e -> {
            ViewsManager.INSTANCE.getTela("homeView").setVisible(true);
            this.loginView.setVisible(false);
        });
    }

    public void iniciar() {
        homeView.setVisible(false);
        loginView.setVisible(true);
        this.loginView.setContentPane(this.loginView.getMainPanel());
        this.loginView.setTitle("Login Wiki Medieval");
        this.loginView.setSize(1000, 600);
        this.loginView.setLocationRelativeTo(null);
        this.loginView.setVisible(true);
    }
}
