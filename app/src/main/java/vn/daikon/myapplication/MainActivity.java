package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.daikon.myapplication.repo.ProductRepo;
import vn.daikon.myapplication.repo.State;
import vn.daikon.myapplication.repo.UserRepo;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    EditText et;
    State state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);
        state = State.getInstance();
        state.setRepo(new UserRepo(getSharedPreferences("daumanhtuan",MODE_PRIVATE)), new ProductRepo(this));
        tv.setText("xin chao" + state.getUser());
    }

    public void onClick1(View view){
        if (et.getText().toString() != ""){
            state.setUser(et.getText().toString());
            tv.setText("xin chao " + state.getUser());
        }
    }
    public void onClick2(View view){
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}
