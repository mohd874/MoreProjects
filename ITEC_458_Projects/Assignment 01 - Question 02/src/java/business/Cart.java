/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author Saeed
 */
public class Cart {

    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }
    
    public int getCount(){
        return items.size();
    }
    
    public String getGrandTotal(){
        double total = 0;
        for (LineItem lineItem : items) {
            total += lineItem.getTotal();
        }
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(total);
    }
    
    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuentity();
        
        for (LineItem i : items) {
            if (i.getProduct().getCode().equals(code)) {
                i.setQuentity(quantity);
                return;
            }
        }
        items.add(item);
    }
    
    public void removeItem(LineItem item) {
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
}
