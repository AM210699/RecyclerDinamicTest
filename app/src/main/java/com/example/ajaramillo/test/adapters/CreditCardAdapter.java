package com.example.ajaramillo.test.adapters;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ajaramillo.test.R;
import com.example.ajaramillo.test.pojo.CreditCard;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CreditCardAdapter extends RecyclerView.Adapter<CreditCardAdapter.CreditCardsViewHolder> implements View.OnClickListener{

    ArrayList<CreditCard> ListCreditCards;

    private View.OnClickListener listener;



    public CreditCardAdapter(ArrayList<CreditCard> listCreditCards) {
        ListCreditCards = listCreditCards;
    }

    @NonNull
    @Override
    public CreditCardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        view.setOnClickListener(this);



        return new CreditCardsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CreditCardsViewHolder holder, int i) {

        holder.Name.setText(ListCreditCards.get(i).getName());
        holder.Information.setText(ListCreditCards.get(i).getInformation());
        holder.Photo.setImageResource(ListCreditCards.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return ListCreditCards.size();
    }

    public void setOnClickListener(View.OnClickListener listener){

                this.listener = listener;

    }

    @Override
    public void onClick(View v) {

        if(listener != null){

            listener.onClick(v);
        }


    }

    public class CreditCardsViewHolder extends RecyclerView.ViewHolder {

        TextView Information, Name;
        ImageView Photo;


        public CreditCardsViewHolder(@NonNull View itemView) {
            super(itemView);

            Name =(TextView) itemView.findViewById(R.id.nameId);
            Information = (TextView) itemView.findViewById(R.id.infoId);
            Photo = (ImageView) itemView.findViewById(R.id.imageId);

        }
    }
}
