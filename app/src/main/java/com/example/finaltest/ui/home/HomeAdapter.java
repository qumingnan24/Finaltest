package com.example.finaltest.ui.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.finaltest.R;

import java.util.List;
import java.util.Map;

public class HomeAdapter extends BaseAdapter {

    private List<Map<String, Object>> mMaps;
    private LayoutInflater mInflater;
    private Context mContext;
    private Activity mActivity;
    LinearLayout.LayoutParams params;

    public HomeAdapter(Context context, Activity activity, List<Map<String, Object>> maps) {
        this.mMaps = maps;
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mActivity = activity;
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
    }

    public int getCount() {
        return mMaps.size();
    }

    public Object getItem(int position) {
        return mMaps.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final ItemViewTag viewTag;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.home_item, null);
            viewTag = new ItemViewTag((ImageView) convertView.findViewById(R.id.image));
            convertView.setTag(viewTag);
        } else {
            viewTag = (ItemViewTag) convertView.getTag();
        }
        viewTag.mImage.setImageResource((Integer) mMaps.get(position).get("image"));
        final View finalConvertView = convertView;
        viewTag.mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "张熙666", Toast.LENGTH_SHORT).show();
                LayoutInflater inflater = LayoutInflater.from(mContext);
                View imageDialog = inflater.inflate(R.layout.image_dialog, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setView(imageDialog);
                final AlertDialog alertDialog = builder.create();
                ImageView image = imageDialog.findViewById(R.id.image);
                image.setImageResource((Integer) mMaps.get(position).get("image"));
                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.cancel();
                    }
                });
                alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                alertDialog.show();
            }
        });
        return convertView;
    }

    class ItemViewTag {
        protected ImageView mImage;

        public ItemViewTag(ImageView mImage) {
            this.mImage = mImage;
        }
    }

}