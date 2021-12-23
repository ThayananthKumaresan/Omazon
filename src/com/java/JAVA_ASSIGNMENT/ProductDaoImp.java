package com.java.JAVA_ASSIGNMENT;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class ProductDaoImp implements ProductDao {

    public static ArrayList<Product> productDatabase = new ArrayList<>();

    private static final String DELETE = "UPDATE product SET productDeletedFlag =? WHERE productID=?";
    private static final String FIND_BY_SELLER = "SELECT * FROM product WHERE productDeletedFlag=? and productSellerID=?";
    private static final String FIND_ALL = "SELECT * FROM product WHERE productDeletedFlag=? ";
    private static final String FIND_BY_ID = "SELECT * FROM product WHERE productID=?";
    private static final String FIND_SELLER_BY_ID = "SELECT userName FROM product,seller WHERE productDeletedFlag=? and" +
            " productID=? and productSellerID =sellerID ";
    private static final String INSERT = "INSERT INTO product (productName, " +
            "productDescription, productCategory, productPrice, productStockCount, " +
            "productSalesCount,productSellerID,productDeletedFlag) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE product SET productName=?, productDescription=?, " +
            "productCategory=?, productPrice=?, productStockCount=?, productSalesCount=? WHERE productID=?";
    private static final String UPDATE_PRODUCT_STOCK = "UPDATE product SET productStockCount=? WHERE productID=?";
    private static final String UPDATE_PRODUCT_SALES = "UPDATE product SET productSalesCount=? WHERE productID=?";


    @Override
    public Product getProduct(int productID) {


        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;
        Product product = new Product();

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_BY_ID);

            stmnt.setInt(1, productID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductSalesCount(rs.getInt("productSalesCount"));
                product.setProductStockCount(rs.getInt("productStockCount"));
                product.setProductSellerID(rs.getInt("productSellerID"));

            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return product;


    }

    @Override
    public String getProductSellerUsername(int productID) {


        String sellerUsername="";
        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_SELLER_BY_ID);

            stmnt.setBoolean(1, false);
            stmnt.setInt(2, productID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                    sellerUsername =rs.getString("userName");
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        return sellerUsername;
    }

    @Override
    public ArrayList<Product> getListOfProductsOfThisSeller(int sellerID) {


        ArrayList<Product> listOfProductOfThisSeller = new ArrayList<>();

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_BY_SELLER);

            stmnt.setBoolean(1, false);
            stmnt.setInt(2, sellerID);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductSalesCount(rs.getInt("productSalesCount"));
                product.setProductStockCount(rs.getInt("productStockCount"));

                listOfProductOfThisSeller.add(product);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


//        for (int i = 0; i < productDatabase.size(); i++) {
//            if (productDatabase.get(i).getProductSellerID() == sellerID) {
//                listOfProductOfThisSeller.add(productDatabase.get(i));
//            }
//        }
//
        if (listOfProductOfThisSeller.size() == 0) {
            return null;
        } else {
            return listOfProductOfThisSeller;
        }

    }

    @Override
    public ArrayList<Product> getListOfAllProduct() {

        ArrayList<Product> listOfAllProduct = new ArrayList<>();

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(FIND_ALL);

            stmnt.setBoolean(1, false);
            rs = stmnt.executeQuery(); // Executing the sql query

            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("productID"));
                product.setProductName(rs.getString("productName"));
                product.setProductDescription(rs.getString("productDescription"));
                product.setProductCategory(rs.getString("productCategory"));
                product.setProductPrice(rs.getDouble("productPrice"));
                product.setProductSalesCount(rs.getInt("productSalesCount"));
                product.setProductStockCount(rs.getInt("productStockCount"));
                product.setProductSellerID(rs.getInt("productSellerID"));

                listOfAllProduct.add(product);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        return listOfAllProduct;
    }


    @Override
    public ArrayList<Product> getTop3SellingProduct() {


        ArrayList<Product> listOfAllProductInDatabase = getListOfAllProduct();


        int n = listOfAllProductInDatabase.size();
        Product tempProduct;
        for (int i = 0; i < n; i++) {
//TODO : third on the list is the error
            for (int j = 1; j < (n - i); j++) {
                if (listOfAllProductInDatabase.get(j - 1).getProductSalesCount() < listOfAllProductInDatabase.get(j).getProductSalesCount()) {
                    //swap elements
                    tempProduct = listOfAllProductInDatabase.get(j - 1);
                    listOfAllProductInDatabase.set(j - 1, listOfAllProductInDatabase.get(j));
                    listOfAllProductInDatabase.set(j, tempProduct);
                }

            }
        }


        ArrayList<Product> top3SellingProducts = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            top3SellingProducts.add(listOfAllProductInDatabase.get(i));
        }

        return top3SellingProducts;
    }

    @Override
    public ArrayList<Product> getListOfProductsBasedOnCategory(String categoryName) {

        ArrayList<Product> listOfProductsBasedOnCategory = new ArrayList<>();
        ArrayList<Product> listOfAllProductInDatabase = getListOfAllProduct();

        for (int i = 1; i < listOfAllProductInDatabase.size(); i++) {
            if (listOfAllProductInDatabase.get(i).getProductCategory().equals(categoryName)) {
                listOfProductsBasedOnCategory.add(listOfAllProductInDatabase.get(i));
            }
        }

        if (listOfProductsBasedOnCategory.size() == 0) {
            return null;
        } else {
            return listOfProductsBasedOnCategory;
        }
    }


    @Override
    public void addProduct(Product product) {

        productDatabase.add(product);

        ResultSet rs = null;
        Connection conn;
        PreparedStatement stmnt;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stmnt.setString(1, product.getProductName());
            stmnt.setString(2, product.getProductDescription());
            stmnt.setString(3, product.getProductCategory());
            stmnt.setDouble(4, product.getProductPrice());
            stmnt.setInt(5, product.getProductStockCount());
            stmnt.setInt(6, product.getProductSalesCount());
            stmnt.setInt(7, product.getProductSellerID());
            stmnt.setBoolean(8, false);

            stmnt.executeUpdate(); // Executing the sql query

            rs = stmnt.getGeneratedKeys();

            if (rs.next()) {
                product.setProductID(rs.getInt(1)); //Setting the product ID

            }
            System.out.println("Successfully add product");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    @Override
    public void updateProduct(Product product) {

        for (int j = 0; j < productDatabase.size(); j++) {

            if (product.getProductID() == productDatabase.get(j).getProductID()) {
                productDatabase.set(j, product);
            }
        }

        PreparedStatement stmnt = null;
        Connection conn = null;

        try {

            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE);
            stmnt.setString(1, product.getProductName());
            stmnt.setString(2, product.getProductDescription());
            stmnt.setString(3, product.getProductCategory());
            stmnt.setDouble(4, product.getProductPrice());
            stmnt.setInt(5, product.getProductStockCount());
            stmnt.setInt(6, product.getProductSalesCount());
            stmnt.setInt(7, product.getProductID());

            stmnt.executeUpdate();
            System.out.println("Updated Product Successfully");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {

            try {
                if (stmnt != null) stmnt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }


    }

    @Override
    public void deleteProduct(Product product) {
        productDatabase.remove(product);

        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(DELETE);
            stmnt.setBoolean(1, true);
            stmnt.setInt(2, product.getProductID());

            stmnt.executeUpdate();
            System.out.println("Deleted your product Successfully");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (stmnt != null) stmnt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    @Override
    public void addProductStock(Product product, int stockCountToAdd) {

        for (int j = 0; j < productDatabase.size(); j++) {

            if (product.getProductID() == productDatabase.get(j).getProductID()) {
                productDatabase.get(j).setProductStockCount(productDatabase.get(j).getProductStockCount() + stockCountToAdd);
            }
        }



        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE_PRODUCT_STOCK);
            stmnt.setInt(1, product.getProductStockCount()+stockCountToAdd);
            stmnt.setInt(2, product.getProductID());

            stmnt.executeUpdate();
            System.out.println("Updated ProductStock Successfully");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {

            try {
                if (stmnt != null) stmnt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }







    }

    @Override
    public void reduceProductStock(Product product, int stockCountToReduce) {

        for (int j = 0; j < productDatabase.size(); j++) {

            if (product.getProductID() == productDatabase.get(j).getProductID()) {
                productDatabase.get(j).setProductStockCount(productDatabase.get(j).getProductStockCount() - stockCountToReduce);
            }
        }


        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE_PRODUCT_STOCK);
            stmnt.setInt(1, product.getProductStockCount()- stockCountToReduce);
            stmnt.setInt(2, product.getProductID());

            stmnt.executeUpdate();
            System.out.println("Updated ProductStock Successfully");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {

            try {
                if (stmnt != null) stmnt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }





    }

    @Override
    public void addProductSalesCount(Product product, int salesCountToAdd) {

        for (int j = 0; j < productDatabase.size(); j++) {

            if (product.getProductID() == productDatabase.get(j).getProductID()) {
                productDatabase.get(j).setProductSalesCount(productDatabase.get(j).getProductSalesCount() + salesCountToAdd);
            }
        }



        PreparedStatement stmnt = null;
        Connection conn = null;

        try {
            conn = MySQLJDBCUtil.getConnection();
            stmnt = conn.prepareStatement(UPDATE_PRODUCT_SALES);
            stmnt.setInt(1, product.getProductSalesCount() + salesCountToAdd);
            stmnt.setInt(2, product.getProductID());

            stmnt.executeUpdate();
            System.out.println("Updated Product SalesCount Successfully");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {

            try {
                if (stmnt != null) stmnt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }





    }

}

