package com.wikimedieval.views;

import com.wikimedieval.model.Views;

import javax.swing.*;

public class MidiaView extends JFrame implements Views {
    private String tipo;
    private JButton homeButton;
    private JButton buscarMidiaButton;
    private JTextField pesquisarTextField;
    private JButton logInButton;
    private JTable midiaTable;
    private JPanel MainPanel;
    private JScrollPane scrollPaneTable;
    private JButton deletarMidiaButton;
    private JButton adicionarMidiaButton;

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JTable getMidiaTable() {
        return midiaTable;
    }

    public JButton getBuscarMidiaButton() {
        return buscarMidiaButton;
    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public JButton getDeletarMidiaButton() {
        return deletarMidiaButton;
    }

    public JButton getAdicionarMidiaButton() {
        return adicionarMidiaButton;
    }
}


