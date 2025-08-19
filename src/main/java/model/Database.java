package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
    // seda klassi kasutan alguses raamatute info salvestamisesk arraylisti (ajutine database)
    private List<Raamat> raamatud;
    private Connection con;

    public Database() {
        raamatud = new LinkedList<Raamat>();
    }

    public void connect() throws Exception {
        if (con != null) return;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url = "jdbc:mysql://localhost:3306/raamatud";
        con = DriverManager.getConnection(url, "root", "MinuSQL123");
        System.out.println("Connected: " + con);
    }
    public void disconnect() throws SQLException {
        if (con != null) {
            con.close();
        }

    }

    public void save() throws SQLException {
        String checkSQL = "Select count(*) as count from raamatud where id=?";
        PreparedStatement checkStmt = con.prepareStatement(checkSQL);

        String insertSQL = "insert into raamatud (id, pealkiri, autor, ilmumisaasta, zhanr, arvustus) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStatement = con.prepareStatement(insertSQL);

        String updateSQL = "update raamatud set pealkiri=?, autor=?, ilmumisaasta=?, zhanr=?, arvustus=? where id=?";
        PreparedStatement updateStatement = con.prepareStatement(updateSQL);

        for (Raamat raamat: raamatud) {
            int id = raamat.getId();
            String pealkiri = raamat.getTitle();
            String autor = raamat.getAuthor();
            String ilmumisaasta = raamat.getPublished();
            ZhanrCategory zhanr = raamat.getZhanr();
            ArvustusCategory arvustus = raamat.getArvustus();

            checkStmt.setInt(1, id);
            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();
            int count = checkResult.getInt(1);

            if (count==0) {
                System.out.println("Inserting raamat with ID " + id);
                insertStatement.setInt(1, id);
                insertStatement.setString(2, pealkiri);
                insertStatement.setString(3, autor);
                insertStatement.setString(4, ilmumisaasta);
                insertStatement.setString(5, zhanr.name());
                insertStatement.setString(6, arvustus.name());
                insertStatement.executeUpdate();
            }
            else {
                System.out.println("Updating raamat with ID " + id);
                int col = 1;

                updateStatement.setString(col++, pealkiri);
                updateStatement.setString(col++, autor);
                updateStatement.setString(col++, ilmumisaasta);
                updateStatement.setString(col++, zhanr.name());
                updateStatement.setString(col++, arvustus.name());
                updateStatement.setInt(col++, id);
                updateStatement.executeUpdate();
            }
            //System.out.println("Count for raamat with ID " + id + " is " + count);

        }
        insertStatement.close();
        checkStmt.close();
    }

    public void load() throws SQLException {
        raamatud.clear();

        String sql = "select id, pealkiri, autor, ilmumisaasta, zhanr, arvustus from raamatud order by pealkiri";

        Statement selectStatement = con.createStatement();
        ResultSet results = selectStatement.executeQuery(sql);
        while (results.next()) {
            int id = results.getInt("id");
            String nimi = results.getString("pealkiri");
            String kirjanik = results.getString("autor");
            String aasta = results.getString("ilmumisaasta");
            String teema = results.getString("zhanr");
            String hinnang = results.getString("arvustus");
            //System.out.println(id);

            Raamat raamat = (new Raamat(id, nimi, kirjanik, aasta, ZhanrCategory.valueOf(teema), ArvustusCategory.valueOf(hinnang)));
            raamatud.add(raamat);
            System.out.println(raamat);
        }
        results.close();

        selectStatement.close();

    }



    public void addraamat(Raamat raamat) {
        raamatud.add(raamat);
    }

    public void removeRaamat(int index) {
        raamatud.remove(index);
    }

    public List<Raamat> getRaamatud() {
        return Collections.unmodifiableList(raamatud);
    }

}//klassi lõpp
