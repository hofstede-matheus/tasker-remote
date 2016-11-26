package hofstedematheus.tasker_remote.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hofstedematheus.tasker_remote.R;

/**
 * Created by he4dless on 26/11/2016.
 */


public class MainCardsAdapter extends RecyclerView.Adapter<MainCardsAdapter.MyViewHolder> {
    String[] names;

    public MainCardsAdapter(String[] names) {
        this.names = names;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, desc;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.card_TV_name);
            desc = (TextView) view.findViewById(R.id.card_TV_desc);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_card_tiny, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(names[position]);
        holder.desc.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}