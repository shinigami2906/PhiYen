package vn.daikon.myapplication.repo;

import android.content.SharedPreferences;
import android.util.Log;

public class UserRepo {

    private SharedPreferences repo = null;
    public UserRepo(SharedPreferences repo){
        this.repo = repo;

    }
    public String getUser(){
        String x = repo.getString("daumanhtuan",null);
        return x;
    }
    public void setUser(String user){
        Log.d("daumnhtuan",user);
        repo.edit().putString("daumanhtuan",user).apply();
    }
}
