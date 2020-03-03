package org.antogautjean;

import java.util.HashMap;

public class Stock {

    private String stockName;

    private HashMap<String, Product> stock = new HashMap<>(1);

    public Stock(String stockName){
        this.stockName = stockName;
    }

    public String getStockName(){
        return this.stockName;
    }

    public boolean addProduct(Product product){
        //tester si le produit existe deja dans la base de donnée
        try {
            this.stock.put(product.getCode(), product);
            return true;
        }
        catch (Exception e){
            e.getMessage();
            return false;
        }
    }
    // produit ou code du produit ???
    public boolean deleteProduct(String code){
        try {
            this.stock.remove(code);
            return true;
        }
        catch(Exception e){
            e.getMessage();
            return false;
        }
    }

    public boolean load(String csvFilePath){
        return false;
    }

    public boolean export(String csvFilePath){
        return false;
    }

    public String toString(){
        return "Il y a " + this.stock.size() + " produits en stock (valeur €)." ;
    }
}
