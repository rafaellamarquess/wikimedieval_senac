package com.wikimedieval.controller;

import com.wikimedieval.dao.MidiaDAO;
import com.wikimedieval.utils.ViewsManager;
import com.wikimedieval.views.AddMidiaView;
import com.wikimedieval.views.BuscarMidiaView;
import com.wikimedieval.views.HomeView;
import com.wikimedieval.views.LoginView;

import java.awt.event.ActionEvent;
import java.util.Arrays;

public class BuscarMidiaController {
    private BuscarMidiaView buscarMidiaView;
    private MidiaDAO midiaDAO;
    private final HomeView homeView;


    public BuscarMidiaController(BuscarMidiaView buscarMidiaView, HomeView homeView) {
        this.buscarMidiaView = buscarMidiaView;
        ViewsManager.INSTANCE.addTela("buscarMidiaView", this.buscarMidiaView);
        this.midiaDAO = new MidiaDAO();
        this.homeView = homeView;

        if (ViewsManager.INSTANCE.getUsuarioLogado() != null ) {
            this.buscarMidiaView.getLogInButton().setText(ViewsManager.INSTANCE.getUsuarioLogado().getNome());
            this.buscarMidiaView.getLogInButton().addActionListener(event -> {
                System.out.println("um dia vai ter logout");
            });
        }

        final String[] tipos = {"Livro", "Filme", "Videogame"};

        Arrays.asList(tipos).forEach(tipo -> this.buscarMidiaView.getDropDownMidia().addItem(tipo));
        this.buscarMidiaView.getDropDownMidia().addActionListener((ActionEvent e) -> {
            final var tipo = Arrays.asList(e.toString().split("=")).reversed().getFirst().split("]")[0];
                new MidiaController(this.buscarMidiaView, tipo ).iniciar();
        });

        this.buscarMidiaView.getHomeButton().addActionListener(e -> {
            ViewsManager.INSTANCE.getTela("homeView").setVisible(true);
            this.buscarMidiaView.setVisible(false);
        });
        this.buscarMidiaView.getLogInButton().addActionListener(e -> {
            if (ViewsManager.INSTANCE.verificarTela("loginView")) {
               final var tela = ViewsManager.INSTANCE.getTela("loginView");
               tela.setVisible(true);
               this.buscarMidiaView.setVisible(false);
                if (ViewsManager.INSTANCE.getUsuarioLogado() != null ) {
                    tela.getLogInButton().setText(ViewsManager.INSTANCE.getUsuarioLogado().getNome());
                    tela.getLogInButton().addActionListener(event -> {
                        System.out.println("um dia vai ter logout");
                    });
                }
            } else {
                new LoginController(new LoginView(), (HomeView) ViewsManager.INSTANCE.getTela("homeView")).iniciar();
                this.buscarMidiaView.setVisible(false);
            }
        });
    }

    public void iniciar() {
        buscarMidiaView.setVisible(true);
        this.homeView.setVisible(false);
        this.buscarMidiaView.setContentPane(this.buscarMidiaView.getMainPanel());
        this.buscarMidiaView.setTitle("Midia Wiki Medieval");
        this.buscarMidiaView.setSize(ViewsManager.INSTANCE.getWidth(), ViewsManager.INSTANCE.getHeight());
        this.buscarMidiaView.setLocationRelativeTo(null);
    }
}