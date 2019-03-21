package hr.ferit.josip.hardwired;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView tvName;
    private NameClickInterface clickInterface;
    private ImageView ivImage;

    public CustomViewHolder(View itemView, NameClickInterface nameClickInterface) {
        super(itemView);
        tvName=itemView.findViewById(R.id.tvName);
        this.clickInterface=nameClickInterface;
        this.ivImage=itemView.findViewById(R.id.ivProductPicture);
        itemView.setOnClickListener(this);
    }

    public void setName(String name){
        tvName.setText(name);
    }

    @Override
    public void onClick(View view) {
        clickInterface.onNameClick(getAdapterPosition());
    }

    public void setImage(String s) {
        Glide.with(itemView)
                .asBitmap()
                .load(s)
                .into(ivImage);

    }
}

