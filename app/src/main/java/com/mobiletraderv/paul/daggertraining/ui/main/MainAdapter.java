package com.mobiletraderv.paul.daggertraining.ui.main;

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
import com.mobiletraderv.paul.daggertraining.model.persistUsers;
import com.mobiletraderv.paul.daggertraining.ui.mainoutlet.MainOutletActivity;


import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private static final String TAG = "MainAdapter";

    Intent intent;

    Context context;

    private List<persistUsers> replist = new ArrayList<>();

    public MainAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_rep_list_adapter, parent, false);
        return new ViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {

        persistUsers rs = replist.get(holder.getAdapterPosition());
        holder.modulesnames.setText(rs.fullname);
        holder.titles.setText(rs.edcode);
        Log.d(TAG, "onBindViewHolder: "+rs.fullname);
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

    public void setRepList(List<persistUsers>  replist) {
        this.replist = replist;
        notifyDataSetChanged();
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
                Log.d(TAG, "setListener: OnClickHewre");
                intent = new Intent(context, MainOutletActivity.class);
                intent.putExtra("USERID",replist.get(position).user_id);
                intent.putExtra("REPID",replist.get(position).rep_id);
                context.startActivity(intent);
            });
        }
    }



}
