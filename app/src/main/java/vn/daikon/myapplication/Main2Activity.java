package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import vn.daikon.myapplication.adapter.ListViewAdapter;
import vn.daikon.myapplication.repo.State;
import vn.daikon.myapplication.repo.UserRepo;

public class Main2Activity extends AppCompatActivity {

    State state;
    TextView tv;
    ListView lv;
    ListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    private void init(){
        tv = (TextView) findViewById(R.id.tv);
        lv = (ListView) findViewById(R.id.lv);

        state = State.getInstance();
        tv.setText("Xin chao " + state.getUser());
        adapter = new ListViewAdapter(state.getList());
        lv.setAdapter(adapter);
    }

    public void onClick(View view){
        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
        startActivity(intent);
    }
}
