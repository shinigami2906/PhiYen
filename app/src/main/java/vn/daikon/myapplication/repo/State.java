package vn.daikon.myapplication.repo;

import android.content.SharedPreferences;
import android.util.Log;

import java.util.List;

import vn.daikon.myapplication.model.Product;

public class State {
    static State state = null;
    public static State getInstance(){
        if (state == null){
            state = new State();
        }
        return state;
    }
    private State(){};
    private UserRepo userRepo;
    private ProductRepo productRepo;
    public void setRepo(UserRepo userRepo, ProductRepo productRepo){
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        user = userRepo.getUser();

        list = productRepo.getAllProduct();

    }
    private String user;
    private List<Product> list;

    public List<Product> getList(){
        return list;
    }
    public void addList(Product product){
        this.list.add(product);
        productRepo.addProduct(product);
    }
    public void setUser(String user) {
        this.user = user;
        userRepo.setUser(user);
    }

    public String getUser() {
        return user;
    }
}
