package co.com.falabella.utils;

import co.com.falabella.connectionDB.ConnectionDB;
import co.com.falabella.models.Products;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductService {
    private static PreparedStatement PS;
    private static ResultSet RS;
    private static final String SQL_SELECT_SEARCH = "SELECT name_search FROM searchs";
    private static final String SQL_SELECT_QUESTION = "SELECT name_product_question, quantity_product_question FROM question";



    public ProductService(){
        PS = null;
    }


    public static Products getProductQuestion() {

        ConnectionDB connection = new ConnectionDB();
        Products product = null;
        try {
            if (connection.getConnection() != null){
                Statement s = connection.getConnection().createStatement();
                RS = s.executeQuery(SQL_SELECT_QUESTION);
                while (RS.next()){
                  product = Products.builder()
                           .productName(RS.getString(1))
                           .productQuantity(RS.getInt(2))
                           .build();

                }
                connection.desconectar();
            }

            connection.desconectar();

        } catch (SQLException e) {
            System.out.printf("error: " + e.getMessage());
            connection.desconectar();
        }
        return product;
    }


    public static void saveProduct(Products products) {

        ConnectionDB connection = new ConnectionDB();
        try {

            if (connection.getConnection() != null){
                PS = connection.getConnection().prepareStatement("Call sp_add_product(?,?)");
                PS.setString(1, products.getProductName());
                PS.setInt(2, products.getProductQuantity());
                PS.executeQuery();
                connection.desconectar();
            }

            connection.desconectar();
        } catch (SQLException e) {
            System.out.printf("error: " + e.getMessage());
            connection.desconectar();
        }
    }


    public static String getSearchProduct() {

        ConnectionDB connection = new ConnectionDB();
        String response = "";
        int row;
        try {
            if (connection.getConnection() != null){
                Statement s = connection.getConnection().createStatement();
                RS = s.executeQuery(SQL_SELECT_SEARCH);
                while (RS.next()){
                    response = RS.getString(1);
                }
                connection.desconectar();
            }

            connection.desconectar();

        } catch (SQLException e) {
            System.out.printf("error: " + e.getMessage());
            connection.desconectar();
        }

        return response;
    }


    public static void saveProductQuestion(Products products) {

        ConnectionDB connection = new ConnectionDB();
        try {
            if (connection.getConnection() != null){
                PS = connection.getConnection().prepareStatement("{Call sp_add_question(?,?)}");
                PS.setString(1, products.getProductName());
                PS.setInt(2, products.getProductQuantity());
                PS.executeQuery();
                connection.desconectar();
            }

            connection.desconectar();
        } catch (SQLException e) {
            System.out.printf("error: " + e.getMessage());
            connection.desconectar();
        }

    }
}
