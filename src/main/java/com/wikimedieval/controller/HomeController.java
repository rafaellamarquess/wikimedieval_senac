package com.wikimedieval.controller;

import com.wikimedieval.utils.ViewsManager;
import com.wikimedieval.views.BuscarMidiaView;
import com.wikimedieval.views.HomeView;
import com.wikimedieval.views.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController extends HomeView {

    private final HomeView homeView;

    public HomeController (HomeView homeView) {
        this.homeView = homeView;
        ViewsManager.INSTANCE.addTela("homeView", this.homeView);

        this.homeView.getBuscarMídiaButton().addActionListener(e -> {
            new BuscarMidiaController(new BuscarMidiaView(), homeView).iniciar();
        });

        this.homeView.getLogInButton().addActionListener(e -> {
            new LoginController(new LoginView(), homeView).iniciar();
        });
    }

    public void iniciar() {
        homeView.setContentPane(homeView.MainPanel);
        homeView.setTitle("Wiki Medieval");
        homeView.setSize(1000, 600);
        homeView.setLocationRelativeTo(null);
        homeView.DefaultCLoseOperation(JFrame.EXIT_ON_CLOSE);
        homeView.setVisible(true);
    }
}

