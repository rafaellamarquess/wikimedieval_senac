package com.wikimedieval.views;

import com.wikimedieval.model.Views;

import javax.swing.*;

public class AddMidiaView extends JFrame implements Views {
    private JButton homeButton;
    private JButton buscarMidiaButton;
    private JButton logInButton;
    private JTextField pesquisarTextField;
    private JPanel MainPanel;
    private JTextField txtTipoMidia;
    private JTextField txtTitulo;
    private JTextField txtDescricao;
    private JTextField txtAutorDiretor;
    private JTextField txtAnoLancamento;
    private JButton cancelarMidiaButton;
    private JButton salvarMidiaButton;
    private JPanel addMidiaPanel;


    public JButton getHomeButton() {
        return homeButton;
    }

    public JButton getBuscarMidiaButton() {
        return buscarMidiaButton;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public JTextField getPesquisarTextField() {
        return pesquisarTextField;
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JTextField getTxtTipoMidia() {
        return txtTipoMidia;
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public JTextField getTxtDescricao() {
        return txtDescricao;
    }

    public JTextField getTxtAutorDiretor() {
        return txtAutorDiretor;
    }

    public JTextField getTxtAnoLancamento() {
        return txtAnoLancamento;
    }

    public JButton getCancelarMidiaButton() {
        return cancelarMidiaButton;
    }

    public JButton getSalvarMidiaButton() {return salvarMidiaButton;}

    public JPanel getAddMidiaPanel() {
        return addMidiaPanel;
    }

}
