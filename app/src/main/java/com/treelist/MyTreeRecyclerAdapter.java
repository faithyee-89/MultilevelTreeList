package com.treelist;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.multilevel.treelist.Node;
import com.multilevel.treelist.TreeRecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by zhangke on 2017-1-14.
 */
public class MyTreeRecyclerAdapter extends TreeRecyclerAdapter {
    private static final String TAG = "SimpleTreeRecyclerAdapt";
    protected LayoutInflater inflater;
    //目前项目支持4级的ui
    public static final int ITEM_TYPE_FILE = 0;
    public static final int ITEM_TYPE_FOLDER = 1;

    public MyTreeRecyclerAdapter(Context context) {
        super(context, new ArrayList<>(), 0);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == ITEM_TYPE_FOLDER) {
            view = this.inflater.inflate(R.layout.item_select_device_rv_folder_type, parent, false);
            return new TypeViewHolder(view) {
                @Override
                public void bindHolder(Node node, int position, TypeViewHolder viewHolder) {
                    this.setText(R.id.name_tv, node.getName());
                    if (node.isExpand()) {
                        this.setImageResource(R.id.arrow_iv, R.mipmap.ic_arrow_up_white);
                    } else {
                        this.setImageResource(R.id.arrow_iv, R.mipmap.ic_arrow_down_white);
                    }
                    this.getView(R.id.rl_select).setOnClickListener(v -> {
                        if (node.isChecked()) {
                            node.setChecked(false);
                            setChildChecked(node, false);
                            viewHolder.setCheckBoxCheckState(R.id.cb_select, false);
                        }else {
                            node.setChecked(true);
                            setChildChecked(node, true);
                            viewHolder.setCheckBoxCheckState(R.id.cb_select, true);
                        }
                        notifyDataSetChanged();
                    });
                    this.setCheckBoxCheckState(R.id.cb_select, node.isChecked());
                }
            };
        } else {
            view = this.inflater.inflate(R.layout.item_select_device_rv_file_type, parent, false);
            return new TypeViewHolder(view) {
                @Override
                public void bindHolder(Node node, int position, TypeViewHolder viewHolder) {
                    this.setText(R.id.name_tv, node.getName());
                    this.getView(R.id.rl_select).setOnClickListener(v -> {
                        if (node.isChecked()) {
                            node.setChecked(false);
                            viewHolder.setCheckBoxCheckState(R.id.cb_select, false);
                        }else {
                            node.setChecked(true);
                            viewHolder.setCheckBoxCheckState(R.id.cb_select, true);
                        }
                    });
                    this.setCheckBoxCheckState(R.id.cb_select, node.isChecked());
                }
            };
        }
    }

    @Override
    public void onBindViewHolder(final Node node, RecyclerView.ViewHolder holder, int position) {
        ((TypeViewHolder) holder).bindHolder(mNodes.get(position), position, (TypeViewHolder)holder);
        // 设置内边距
        holder.itemView.setPadding(node.getLevel() * dip2px(37), 0, 0, 0);
    }

    public int dip2px(float dipValue) {
        DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
        return (int) (dipValue * dm.density + 0.5F);
    }

    @Override
    public int getItemViewType(int position) {
        return super.mNodes.get(position).getType();
    }
}
