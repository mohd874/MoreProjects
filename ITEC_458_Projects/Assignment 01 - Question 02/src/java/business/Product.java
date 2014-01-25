/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import java.text.NumberFormat;
/**
 *
 * @author Saeed
 */
public class Product {

    private String category;
    private String code;
    private String description;
    private double price;

    public Product(){
        category = "";
        code = "";
        description = "";
        price = 0;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getCurrencyFormattedPrice(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
