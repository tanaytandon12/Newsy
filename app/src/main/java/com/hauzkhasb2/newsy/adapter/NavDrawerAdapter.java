package com.hauzkhasb2.newsy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hauzkhasb2.newsy.R;
import com.hauzkhasb2.newsy.model.NavDrawerItem;
import com.hauzkhasb2.newsy.view.CircularImageView;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanay on 12/7/15.
 */
public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerAdapter.ViewHolder> {

    public static final int TYPE_HEADER = 1;
    public static final int TYPE_ITEM = 2;
    public static final int TYPE_ITEM_SUB = 3;
    private Context mContext;
    private ArrayList<NavDrawerItem> navDrawerItemList;
    private LayoutInflater mLayoutInflater;
    private View.OnClickListener mListener;
    private int selectedColor;

    public NavDrawerAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItemList, View.OnClickListener mOnClickListener) {
        this.mContext = context;
        this.navDrawerItemList = navDrawerItemList;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mListener = mOnClickListener;
        this.selectedColor = mContext.getResources().getColor(R.color.color_4998E0);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder viewHolder = null;
        View view = null;
        if (viewType == TYPE_HEADER) {
            view = mLayoutInflater.inflate(R.layout.layout_nav_drawer_heading, parent, false);
            viewHolder = new ViewHolder(view, viewType, null);
        } else if (viewType == TYPE_ITEM || viewType == TYPE_ITEM_SUB) {
            view = mLayoutInflater.inflate(R.layout.layout_nav_drawer_item, parent, false);
            viewHolder = new ViewHolder(view, viewType, mListener);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int itemType = getItemViewType(position);
        NavDrawerItem ndi = navDrawerItemList.get(position);
        if(itemType == TYPE_HEADER) {
            holder.tvUserName.setText(ndi.name);
            Picasso.with(mContext).load(ndi.imageUrl).into(holder.civUserPic);
        } else if(itemType == TYPE_ITEM || itemType == TYPE_ITEM_SUB) {
            holder.tvDrawerName.setText(ndi.name);
            if(ndi.isSelected) {
                holder.tvDrawerName.setTextColor(selectedColor);
            } else {
                holder.vSelected.setVisibility(View.INVISIBLE);
            }
            if(itemType == TYPE_ITEM_SUB) {
                holder.tvDrawerSub.setText(ndi.sub);
            }
        }
    }

    @Override
    public int getItemCount() {
        return navDrawerItemList.size();
    }

    // With the following method we check what type of view is being passed
    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return TYPE_HEADER;
        if(navDrawerItemList.get(position).sub != null)
            return TYPE_ITEM_SUB;
        return TYPE_ITEM;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName, tvDrawerName, tvDrawerSub;
        View vSelected;
        CircularImageView civUserPic;


        public ViewHolder(View view, int viewType, View.OnClickListener mOnClickListener) {
            super(view);
            view.setOnClickListener(mOnClickListener);
            if (viewType == NavDrawerAdapter.TYPE_HEADER) {
                tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
                civUserPic = (CircularImageView) view.findViewById(R.id.civ_user_pic);
            } else if(viewType == NavDrawerAdapter.TYPE_ITEM || viewType == NavDrawerAdapter.TYPE_ITEM_SUB) {
                tvDrawerName = (TextView) view.findViewById(R.id.tv_nav_name);
                vSelected = view.findViewById(R.id.v_selected);
                if (viewType == TYPE_ITEM_SUB) {
                    tvDrawerSub = (TextView) view.findViewById(R.id.tv_nav_sub);
                }
            }
        }
    }

}
