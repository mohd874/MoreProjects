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
public class LineItem {
    
    private Product product;
    private int quentity;

    public LineItem() {
    }

    public

    Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuentity() {
        return quentity;
    }

    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }
    
    public double getTotal(){
        return (product.getPrice() * quentity);
    }
    
    public String getCurrencyFormattedPrice(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}
