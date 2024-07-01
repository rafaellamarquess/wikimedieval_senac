package com.wikimedieval.utils;

import com.wikimedieval.model.Usuario;
import com.wikimedieval.model.Views;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public enum ViewsManager{
    INSTANCE;

    private Usuario usuarioLogado;

    private final Map<String, Views> telasAtivas = new HashMap<>();
    private int height = 600;
    private int width = 1000;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void addTela(String nomeDaTela, Views tela) {
        this.telasAtivas.put(nomeDaTela, tela);
    }

    public Views getTela(String nomeDaTela) {
        this.telasAtivas.forEach((String nome, Views tela) -> {
//            if (nome != "loginView"  && this.usuarioLogado != null) {
//                tela.getLogInButton().setText(this.usuarioLogado.getNome());
//                tela.getLogInButton().addActionListener(event -> {
//                    System.out.println("um dia vai ter logout");
//                });
//            }

        });
        return this.telasAtivas.get(nomeDaTela);
    }
    public boolean verificarTela(String nomeDaTela) {
        return this.telasAtivas.containsKey(nomeDaTela);
    }
    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;

    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
