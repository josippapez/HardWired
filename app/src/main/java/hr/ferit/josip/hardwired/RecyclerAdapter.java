package hr.ferit.josip.hardwired;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private NameClickInterface clickInterface;
    private List<String> dataList=new ArrayList<>();

    public RecyclerAdapter(NameClickInterface clickInterface) {
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cellView=LayoutInflater.from(parent.getContext()).inflate(R.layout.cells, parent,false);
        return new CustomViewHolder(cellView,clickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder nameViewHolder, int position) {
        nameViewHolder.setName(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
    public void addData(List<String> data){
        this.dataList.clear();
        this.dataList.addAll(data);
        notifyDataSetChanged();
    }
}
