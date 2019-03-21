package hr.ferit.josip.hardwired;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class RecyclerProductsAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private NameClickInterface clickInterface;
    private List<String> names=new ArrayList<>();
    private List<String> imagesURL=new ArrayList<>();
    private List<String> siteURL=new ArrayList<>();

    public RecyclerProductsAdapter(NameClickInterface clickInterface) {
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView=LayoutInflater.from(parent.getContext()).inflate(R.layout.productcells, parent,false);
        return new CustomViewHolder(cellView,clickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder nameViewHolder, int position) {
        nameViewHolder.setName(names.get(position));
        nameViewHolder.setImage(imagesURL.get(position));
    }

    @Override
    public int getItemCount() {
        return names.size();
    }
    public void addData(List<String> data, List<String> imageURLs,List<String> websiteURLs){
        this.names.clear();
        this.names.addAll(data);
        this.imagesURL.clear();
        this.imagesURL.addAll(imageURLs);
        this.siteURL.clear();
        this.siteURL.addAll(websiteURLs);
        notifyDataSetChanged();
    }
}
