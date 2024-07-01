package com.wikimedieval;

import com.wikimedieval.controller.HomeController;
import com.wikimedieval.views.HomeView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        HomeView HomeView = new HomeView();
        final var homeController = new HomeController(HomeView);
        homeController.iniciar();
    }
}