package com.wikimedieval.controller;

import com.wikimedieval.dao.MidiaDAO;
import com.wikimedieval.model.Views;
import com.wikimedieval.utils.ViewsManager;
import com.wikimedieval.views.AddMidiaView;
import com.wikimedieval.model.Midia;
import com.wikimedieval.views.BuscarMidiaView;
import com.wikimedieval.views.HomeView;
import com.wikimedieval.views.LoginView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddMidiaController {
    private AddMidiaView addMidiaView;
    private MidiaDAO midiaDAO;
    private BuscarMidiaView buscarMidiaView;
    private BuscarMidiaController buscarMidiaController;

    public AddMidiaController(AddMidiaView addMidiaView) {
        this.addMidiaView = addMidiaView;
        ViewsManager.INSTANCE.addTela("addMidiaView", this.addMidiaView);
        this.midiaDAO = new MidiaDAO();
        this.buscarMidiaView = new BuscarMidiaView();
        if (ViewsManager.INSTANCE.getUsuarioLogado() != null ) {
            this.addMidiaView.getLogInButton().setText(ViewsManager.INSTANCE.getUsuarioLogado().getNome());
            this.addMidiaView.getLogInButton().addActionListener(event -> {
                System.out.println("um dia vai ter logout");
            });
        }

        this.addMidiaView.getSalvarMidiaButton().addActionListener(e ->{
                if (Objects.equals(ViewsManager.INSTANCE.getUsuarioLogado().getTipoUsuario(), "admin")) {
                    String titulo = addMidiaView.getTxtTitulo().getText();
                    String tipo = addMidiaView.getTxtTipoMidia().getText();
                    String descricao = addMidiaView.getTxtDescricao().getText();
                    String autor_diretor = addMidiaView.getTxtAutorDiretor().getText();
                    int ano_lancamento = Integer.parseInt(addMidiaView.getTxtAnoLancamento().getText());
                    Midia midia = new Midia(titulo, tipo, descricao, autor_diretor, ano_lancamento);
                    midiaDAO.adicionarMidia(midia);
                    JOptionPane.showMessageDialog(addMidiaView, "Mídia adicionada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(AddMidiaController.this.addMidiaView, "Apenas o Administrador pode adicionar mídias!");
                }
                ViewsManager.INSTANCE.getTela("homeView").setVisible(true);
                AddMidiaController.this.addMidiaView.setVisible(false);
        });


        this.addMidiaView.getCancelarMidiaButton().addActionListener( e -> {
            ViewsManager.INSTANCE.getTela("homeView").setVisible(true);
            this.addMidiaView.setVisible(false);
        });

        this.addMidiaView.getHomeButton().addActionListener(e -> {
            ViewsManager.INSTANCE.getTela("homeView").setVisible(true);
            this.addMidiaView.setVisible(false);
        });

        this.addMidiaView.getBuscarMidiaButton().addActionListener(e -> {
            ViewsManager.INSTANCE.getTela("buscarMidiaView").setVisible(true);
            this.addMidiaView.setVisible(false);
        });

        this.addMidiaView.getLogInButton().addActionListener(e -> {
            if (ViewsManager.INSTANCE.verificarTela("loginView")) {
                final var tela = ViewsManager.INSTANCE.getTela("loginView");
                tela.setVisible(true);
                if (ViewsManager.INSTANCE.getUsuarioLogado() != null ) {
                    tela.getLogInButton().setText(ViewsManager.INSTANCE.getUsuarioLogado().getNome());
                    tela.getLogInButton().addActionListener(event -> {
                        System.out.println("um dia vai ter logout");
                    });
                }
                this.addMidiaView.setVisible(false);
            } else {
                new LoginController(new LoginView(), (HomeView) ViewsManager.INSTANCE.getTela("homeView")).iniciar();
                this.addMidiaView.setVisible(false);
            }
        });

    }

    public void iniciar() {
        buscarMidiaView.setVisible(false);
        addMidiaView.setVisible(true);
        this.addMidiaView.setContentPane(this.addMidiaView.getMainPanel());
        this.addMidiaView.setTitle("Adicionar Mídia");
        this.addMidiaView.setSize(1000, 600);
        this.addMidiaView.setLocationRelativeTo(null);
        this.addMidiaView.setVisible(true);
    }
}
