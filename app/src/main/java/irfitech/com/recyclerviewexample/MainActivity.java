package irfitech.com.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Adapter.MyAdapter;
import Model.ListItem;
import MyLibraries.MyRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<ListItem> listItems = new ArrayList<>();
        ListItem item = new ListItem("Irfan");
        ListItem item1 = new ListItem("Irfan");
        ListItem item2 = new ListItem("Irfan");
        ListItem item3 = new ListItem("Irfan");
        ListItem item4 = new ListItem("Irfan");
        ListItem item5 = new ListItem("Irfan");
        ListItem item6 = new ListItem("Irfan");
        ListItem item7 = new ListItem("Irfan");
        ListItem item8 = new ListItem("Irfan");
        ListItem item9 = new ListItem("Irfan");
        ListItem item10 = new ListItem("Irfan");
        ListItem item11 = new ListItem("Irfan");
        listItems.add(item);
        listItems.add(item1);
        listItems.add(item2);
        listItems.add(item3);
        listItems.add(item4);
        listItems.add(item5);
        listItems.add(item6);
        listItems.add(item7);
        listItems.add(item8);
        listItems.add(item9);
        listItems.add(item10);
        listItems.add(item11);
        RecyclerView.Adapter adapter = new MyAdapter(this,listItems);
        rv.setAdapter(adapter);
    }
}
