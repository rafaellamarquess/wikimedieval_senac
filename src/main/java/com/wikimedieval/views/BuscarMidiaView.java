package com.wikimedieval.views;

import com.wikimedieval.model.Views;

import javax.swing.*;

public class BuscarMidiaView extends JFrame implements Views {
    private JPanel MainPanel;
    private JButton homeButton;
    private JTextField textField1;
    private JButton logInButton;
    private JButton buscarMidiaButton;
    private JComboBox<String> dropDownMidia;

    public JPanel getMainPanel() {
        return MainPanel;
    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public JButton getBuscarMidiaButton() {
        return buscarMidiaButton;
    }

    public JComboBox<String> getDropDownMidia() {
        return dropDownMidia;
    }


}
