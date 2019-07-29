package com.mobiletraderv.paul.daggertraining.ui.mainoutlet;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobiletraderv.paul.daggertraining.R;
import com.mobiletraderv.paul.daggertraining.model.OutletsLists;
import com.mobiletraderv.paul.daggertraining.ui.quest.QuestActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainOutletAdapter extends RecyclerView.Adapter<MainOutletAdapter.ViewHolder>{

    private static final String TAG = "MainOutletAdapter";

    Intent intent;

    Context context;

    private List<OutletsLists> replist = new ArrayList<>();

    public MainOutletAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MainOutletAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customer_rep_list_adapter, parent, false);
        return new ViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull MainOutletAdapter.ViewHolder holder, int position) {

        OutletsLists rs = replist.get(holder.getAdapterPosition());
        holder.modulesnames.setText(rs.outletn);
        holder.titles.setText(rs.urno);
        holder.setListener(position);
    }

    @Override
    public int getItemCount() {
        if (replist != null && !replist.isEmpty()) {
            return replist.size();
        } else {
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setCustList(List<OutletsLists>  replist) {
        this.replist = replist;
        notifyDataSetChanged();
    }

    public OutletsLists returnOject(int position) {
        if (replist != null && !replist.isEmpty()){
            if(replist.size() > 0){
                return replist.get(position);
            }
        }
        return null;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.modulesnames)
        TextView modulesnames;

        @BindView(R.id.titles)
        TextView titles;

        @BindView(R.id.handleClickListener)
        LinearLayout handleClickListener;

        public ViewHolder(View mview) {
            super(mview);
            ButterKnife.bind(this, mview);
        }

        public void setListener(int position) {
            handleClickListener.setOnClickListener(v->{
                intent = new Intent(context, QuestActivity.class);
                intent.putExtra("CONTN",replist.get(position).contn);
                intent.putExtra("CONTP",replist.get(position).contp);
                intent.putExtra("OUTLETADD",replist.get(position).outletadd);
                intent.putExtra("OUTLETID",replist.get(position).outletid);
                intent.putExtra("OUTLETN",replist.get(position).outletn);
                intent.putExtra("REPID",replist.get(position).repid);
                intent.putExtra("URNO",replist.get(position).urno);
                intent.putExtra("USERID",replist.get(position).userid);
                Log.d(TAG, "setListener: OnClickHewre"+replist.get(position).repid+' '+
                                replist.get(position).userid +' '+replist.get(position).outletid
                        );
                context.startActivity(intent);
            });
        }
    }
}
