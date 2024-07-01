package com.wikimedieval.controller;

import com.wikimedieval.dao.MidiaDAO;
import com.wikimedieval.model.Midia;
import com.wikimedieval.model.MidiaTableModel;
import com.wikimedieval.utils.ViewsManager;
import com.wikimedieval.views.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

public class MidiaController {

    private final BuscarMidiaView buscarMidiaView;
    private final MidiaDAO midiaDAO;
    private final MidiaView midiaView;
    private List<Midia> midias;
    //private final Map<String, TableColumn> colunasDaTabela = new HashMap<>();

    public MidiaController(BuscarMidiaView buscarMidiaView, String tipo) {
        this.buscarMidiaView = buscarMidiaView;
        this.midiaDAO = new MidiaDAO();
        this.midiaView = new MidiaView();

        ViewsManager.INSTANCE.addTela("midiaView", this.buscarMidiaView);
        this.midiaView.setTipo(tipo);
        if (ViewsManager.INSTANCE.getUsuarioLogado() != null ) {
            this.midiaView.getLogInButton().setText(ViewsManager.INSTANCE.getUsuarioLogado().getNome());
            this.midiaView.getLogInButton().addActionListener(e -> {
                System.out.println("um dia vai ter logout");
            });
        }
        this.midiaView.getBuscarMidiaButton().addActionListener(e -> {
            this.midiaView.setVisible(false);
            this.buscarMidiaView.setVisible(true);
        });

        this.midiaView.getHomeButton().addActionListener(e -> {
            ViewsManager.INSTANCE.getTela("homeView").setVisible(true);
            this.midiaView.setVisible(false);
        });

        this.midiaView.getLogInButton().addActionListener(e -> {
            if (ViewsManager.INSTANCE.getUsuarioLogado() == null) {
                if (ViewsManager.INSTANCE.verificarTela("loginView")) {
                    final var tela = ViewsManager.INSTANCE.getTela("loginView");
                    tela.setVisible(true);
                    if (ViewsManager.INSTANCE.getUsuarioLogado() != null ) {
                        tela.getLogInButton().setText(ViewsManager.INSTANCE.getUsuarioLogado().getNome());
                        tela.getLogInButton().addActionListener(event -> {
                            System.out.println("um dia vai ter logout");
                        });
                    }
                    this.midiaView.setVisible(false);
                } else {
                    new LoginController(new LoginView(), (HomeView) ViewsManager.INSTANCE.getTela("homeView")).iniciar();
                    this.midiaView.setVisible(false);
                }
            }
        });

        this.midiaView.getAdicionarMidiaButton().addActionListener(e -> {
            if (ViewsManager.INSTANCE.getUsuarioLogado() != null &&
                Objects.equals(ViewsManager.INSTANCE.getUsuarioLogado().getTipoUsuario(), "admin")) {
                if ( !ViewsManager.INSTANCE.verificarTela("addMidiaView") ) {

                    new AddMidiaController(new AddMidiaView()).iniciar();
                } else {
                    ViewsManager.INSTANCE.getTela("addMidiaView").setVisible(true);
                }
                this.midiaView.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this.midiaView, "Usuário sem permissão!");
            }
        });

        this.midiaView.getDeletarMidiaButton().addActionListener(e -> {
            if  (ViewsManager.INSTANCE.getUsuarioLogado() != null && ViewsManager.INSTANCE.getUsuarioLogado().getTipoUsuario().equals("admin")) {
                final var index = this.midiaView.getMidiaTable().getSelectedRow();
                final var id = this.midias.get(index).getId();
                this.midiaDAO.deletarMidia(id);
                JOptionPane.showMessageDialog(this.midiaView, "Deletado com sucesso!");
                this.iniciar();
            } else {JOptionPane.showMessageDialog(this.midiaView, "Usuário sem permissão!");}
        });
    }

    private List<Midia> inserirNaTable(String tipo) {
        List<Midia> midias = this.midiaDAO.buscarMidiasPorTipo(tipo);
        MidiaTableModel model = new MidiaTableModel(midias);
        this.midiaView.getMidiaTable().setModel(model);
        return midias;
    }

    public void iniciar() {
        this.buscarMidiaView.setVisible(false);
        this.midiaView.setVisible(true);
        this.midias = this.inserirNaTable(this.midiaView.getTipo());
        this.midiaView.setContentPane(this.midiaView.getMainPanel());
        this.midiaView.setTitle("Midia Wiki Medieval");
        this.midiaView.setSize(ViewsManager.INSTANCE.getWidth(), ViewsManager.INSTANCE.getHeight());
        this.midiaView.setLocationRelativeTo(null);
    }
}