package hr.ferit.josip.hardwired;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NameClickInterface{

    private RecyclerView rvLayout;
    private RecyclerAdapter recycleAdapter;
    private List<String> categories=new ArrayList<>();
    private ArrayList<String> productsnames=new ArrayList<>();
    private ArrayList<String> imagesURL=new ArrayList<>();
    private ArrayList<String> siteURL=new ArrayList<>();
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvLayout=findViewById(R.id.rvLayout);
        rvLayout.setLayoutManager(new LinearLayoutManager(this));
        recycleAdapter=new RecyclerAdapter(this);
        rvLayout.setAdapter(recycleAdapter);
        categories.addAll(Arrays.asList(getResources().getStringArray(R.array.categories)));
        recycleAdapter.addData(categories);
    }

    @Override
    public void onNameClick(int position) {
        Intent intent=new Intent(this, CategoryActivity.class);
        productsnames.clear();
        imagesURL.clear();
        siteURL.clear();
        if (position==0){
            productsnames.addAll(Arrays.asList(getResources().getStringArray(R.array.processorNames)));
            imagesURL.addAll(Arrays.asList(getResources().getStringArray(R.array.processorPictures)));
            siteURL.addAll(Arrays.asList(getResources().getStringArray(R.array.categoryProcessors)));
            name="Processors";

        }
        else if (position==1){
            productsnames.addAll(Arrays.asList(getResources().getStringArray(R.array.graphicscardNames)));
            imagesURL.addAll(Arrays.asList(getResources().getStringArray(R.array.graphicscardPictures)));
            siteURL.addAll(Arrays.asList(getResources().getStringArray(R.array.categoryGraphicsCard)));
            name="Graphic Cards";

        }
        else if (position==2) {
            productsnames.addAll(Arrays.asList(getResources().getStringArray(R.array.powerunitsNames)));
            imagesURL.addAll(Arrays.asList(getResources().getStringArray(R.array.powerunitsPictures)));
            siteURL.addAll(Arrays.asList(getResources().getStringArray(R.array.categoryPowerunits)));
            name="Power Units";

        }
        else if (position==3) {
            productsnames.addAll(Arrays.asList(getResources().getStringArray(R.array.ramMemoryName)));
            imagesURL.addAll(Arrays.asList(getResources().getStringArray(R.array.ramMemoryPictures)));
            siteURL.addAll(Arrays.asList(getResources().getStringArray(R.array.categoryRamMemory)));
            name="RAM Memory";

        }else if (position==4) {
            productsnames.addAll(Arrays.asList(getResources().getStringArray(R.array.storageNames)));
            imagesURL.addAll(Arrays.asList(getResources().getStringArray(R.array.storagePictures)));
            siteURL.addAll(Arrays.asList(getResources().getStringArray(R.array.categoryStoragememory)));
            name="Storage";

        }
        intent.putStringArrayListExtra("products",productsnames);
        intent.putStringArrayListExtra("imagesURL",imagesURL);
        intent.putStringArrayListExtra("siteURL",siteURL);
        intent.putExtra("title",name);
        startActivity(intent);
    }
}