package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import vn.daikon.myapplication.adapter.ListViewAdapter;
import vn.daikon.myapplication.model.Product;
import vn.daikon.myapplication.repo.State;

public class Main3Activity extends AppCompatActivity {
    State state;
    EditText et_1, et_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }
    private void init(){
        et_1 = (EditText) findViewById(R.id.et_1);
        et_2 = (EditText) findViewById(R.id.et_2);
        state = State.getInstance();

    }
    public void onClick(View view){
        String name = et_1.getText().toString();
        String age = et_2.getText().toString();
        state.addList(new Product(name,age,"1"));
        finish();
    }
}
