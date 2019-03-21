package hr.ferit.josip.hardwired;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements NameClickInterface {

    private RecyclerView rvLayout;
    private RecyclerProductsAdapter recycleAdapter;
    private ArrayList<String> productNames=new ArrayList<>();
    private ArrayList<String> imageURLs=new ArrayList<>();
    private ArrayList<String> siteURL=new ArrayList<>();
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        rvLayout=findViewById(R.id.rvCategoryLayout);
        rvLayout.setLayoutManager(new LinearLayoutManager(this));
        recycleAdapter=new RecyclerProductsAdapter(this);
        rvLayout.setAdapter(recycleAdapter);
        productNames.addAll(getIntent().getExtras().getStringArrayList("products"));
        imageURLs.addAll(getIntent().getExtras().getStringArrayList("imagesURL"));
        siteURL.addAll(getIntent().getExtras().getStringArrayList("siteURL"));
        title=getIntent().getExtras().getString("title");
        setTitle(title);
        recycleAdapter.addData(productNames,imageURLs,siteURL);
    }

    @Override
    public void onNameClick(int position) {
        Intent intentbrowser=new Intent(Intent.ACTION_VIEW, Uri.parse(siteURL.get(position)));
        startActivity(intentbrowser);
    }
}
