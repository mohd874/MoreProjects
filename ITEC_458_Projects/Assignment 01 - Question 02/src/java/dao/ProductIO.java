/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.*;
import java.util.*;
import business.*;
import java.util.ArrayList;

/**
 *
 * @author Saeed
 */
public class ProductIO {

    public static final String CATEGORY_SYSTEMS = "System";
    public static final String CATEGORY_SOFTWAR = "Software";
    public static final String CATEGORY_BOOKS = "Books";
    
    public static Product getProductByCode(String code, String filepath) {
        try {
            File file = new File(filepath);
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                t.nextToken();
                String productCode = t.nextToken();
                if (code.equalsIgnoreCase(productCode)) {
                    String description = t.nextToken();
                    double price = Double.parseDouble(t.nextToken());
                    Product p = new Product();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);
                    in.close();
                    return p;
                }
                line = in.readLine();
            }
            in.close();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Product> getProductsByCategory(String productCategory, String filepath) {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(filepath);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String category = t.nextToken();
                String code = t.nextToken();
                String description = t.nextToken();
                String priceAsString = t.nextToken();
                if (category.equalsIgnoreCase(productCategory)) {
                    double price = Double.parseDouble(priceAsString);
                    Product p = new Product();
                    p.setCategory(category);
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);
                    products.add(p);
                }
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Product> getProducts(String filepath) {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(filepath);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String category = t.nextToken();
                String code = t.nextToken();
                String description = t.nextToken();
                String priceAsString = t.nextToken();
                double price = Double.parseDouble(priceAsString);
                Product p = new Product();
                p.setCategory(category);
                p.setCode(code);
                p.setDescription(description);
                p.setPrice(price);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
