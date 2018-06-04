# AndroidRecyclerViewExample
Step #1:
Create an Activity and Drag RecyclerView to its layout. For example, Activity is MainActivity.java and its layout is MainLayout.xml.
So, Add RecyclerView to MainLayout.xml

Step #2:
Create A row layout for the RecyclerView. As we do for Custom ListViews. Here is the example.

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent" android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="12dp"
    >

    <android.support.v7.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        >

        <TextView
            android:id="@+id/textView"
            android:padding="12dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="TextView" />
    </android.support.v7.widget.CardView>

</LinearLayout>

Step #3: Create Adapter Class, in our case MyAdapter.java is the adapter class, that extends RecyclerView.Adapter<MyAdapter.ViewHolder>


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(Context context, List ListItems) {
        this.context = context;
        this.listItems = ListItems;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.name.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}

Step #4: Add ViewHolder Class, nested in, to MyAdapter Class. The ViewHolder Class will hold items of the View/layout.
So our Adapter will now become like: 

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(Context context, List ListItems) {
        this.context = context;
        this.listItems = ListItems;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        ListItem item = listItems.get(position);
        holder.name.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.textView);

        }

        @Override
        public void onClick(View v) {
            TextView tx = (TextView) v.findViewById(R.id.textView);
            String text = tx.getText().toString();
            int pos = getAdapterPosition();
            ListItem item = listItems.get(pos);
            Toast.makeText(context,item.getName()+ " pos: "+Integer.toString(pos),Toast.LENGTH_LONG).show();
        }
    }
}

Step #5: Now create ListItems class for the items. In this case, we are having only one TextView in our layout. So, our ListItems class
will look like:

public class ListItem {
    private String name;

    public ListItem(String name)
    {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

Step #6: Initialize the RecyclerView in the Main Activity and add adapter, in our case MyAdapter, to the RecyclerView.
Our Main Activity will look like:


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

Note: item,item1, item2 ....item11 are the items added to recyclerView through MyAdapter.
