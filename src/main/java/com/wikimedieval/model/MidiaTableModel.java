package com.wikimedieval.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MidiaTableModel extends AbstractTableModel {
    private final List<Midia> midias;
    private final String[] colunas = {"Título", "Descrição", "Autor/Diretor", "Ano de Lançamento"};

    public MidiaTableModel(List<Midia> midias) {
        this.midias = midias;
    }

    @Override
    public int getRowCount() {
        return midias.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Midia midia = midias.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> midia.getTitulo();
            case 1 -> midia.getDescricao();
            case 2 -> midia.getAutor_diretor();
            case 3 -> midia.getAno_lancamento();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

//    public List<Midia> getMidias() {
//        return midias;
//    }
}
