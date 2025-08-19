package gui;

import model.Raamat;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RaamatuTableModel extends AbstractTableModel {
    private List<Raamat> db;
    private String[] colNames = {"ID", "Pealkiri", "Autor", "Ilmumisaasta", "Zhanr", "Arvustus"};

    public RaamatuTableModel() {
    }

    public void setData(List<Raamat> db) {
        this.db = db;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return db.size(); //db on hetkel lihtsal üks list
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Raamat raamat = db.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return raamat.getId();
            case 1:
                return  raamat.getTitle();
            case 2:
                return  raamat.getAuthor();
            case 3:
                return raamat.getPublished();
            case 4:
                return raamat.getZhanr();
            case 5:
                return raamat.getArvustus();
        }
        return null;
    }
}
