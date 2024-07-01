package com.wikimedieval.views;

import com.wikimedieval.model.Usuario;
import com.wikimedieval.model.Views;

import javax.swing.*;

public class HomeView extends JFrame implements Views {
    public JPanel MainPanel;
    private JButton HomeButton;
    private JButton buscarMídiaButton;
    private JButton logInButton;
    private JTextField textField1;
    private JLabel bannerLabel;
    private JLabel titleLabel;
    private JPanel bannerPanel;
    private JPanel contatoPanel;

    public JButton getHomeButton() {
        return HomeButton;
    }

    public JButton getBuscarMídiaButton() {
        return buscarMídiaButton;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void DefaultCLoseOperation(int exitOnClose) {
    }

    public void updateUserStatus(String nome) {
    }
}