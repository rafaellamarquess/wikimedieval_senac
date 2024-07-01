package com.wikimedieval.views;

import com.wikimedieval.model.Views;

import javax.swing.*;


public class LoginView extends JFrame implements Views {

    private JButton homeButton;
    private JButton buscarMidiaButton;
    private JButton loginButton;
    private JTextField textField1;
    private JPanel MainPanel;
    private JTextField emailField;
    private JPasswordField senhaPasswordField;
    private JButton entrarButton;
    private JButton cancelarButton;
    private JPanel loginPanel;

    public JButton getHomeButton() {
        return homeButton;
    }

    public JButton getBuscarMidiaButton() {
        return buscarMidiaButton;
    }

    public JButton getLogInButton() {
        return loginButton;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getSenhaPasswordField() {
        return senhaPasswordField;
    }

    public JButton getEntrarButton() {
        return entrarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }
}
