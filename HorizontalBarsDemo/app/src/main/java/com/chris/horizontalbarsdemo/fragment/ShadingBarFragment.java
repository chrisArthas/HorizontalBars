package com.chris.horizontalbarsdemo.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.chris.horizontalbarsdemo.R;
import com.chris.horizontalbarsdemo.views.ShadingBar;
import com.chris.horizontalbarsdemo.views.SpotInfo;

import java.util.ArrayList;

/**
 * Created by win on 2017/8/18.
 */

public class ShadingBarFragment extends Fragment {

    private ListView listView;


    ShadingAdapter shadingAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.shading_bar_fragment_lay,null,true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView)view.findViewById(R.id.listview);
        shadingAdapter =  new ShadingAdapter(getActivity());
        listView.setAdapter(shadingAdapter);
        initData();
    }

    private void initData()
    {
        ArrayList<SpotInfo> list = new ArrayList<>();
        for(int i = 0;i<20;i++)
        {
            SpotInfo info1 = new SpotInfo();

            info1.setWeekAttentionAlgorithm((int)(Math.random()*10000)+"");

            info1.setSpotName("xxxxxx");

            list.add(info1);
        }
        shadingAdapter.updateData(list,10000);
    }

    public class ShadingAdapter extends ArrayAdapter {
        private String TAG = "ShadingAdapter";

        private ArrayList<SpotInfo> dataList;

        private Context context;

        private int MAX_NUM = 2000;


        public ShadingAdapter(Context context)
        {
            super(context,0);
            this.context = context;
        }
        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }


        public void updateData(ArrayList<SpotInfo> list, int maxNum)
        {
            dataList = list;
            MAX_NUM = maxNum;
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            if(dataList == null)
            {
                return 0;
            }else
            {
                return dataList.size();
            }
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ShadingAdapter.Holder vp = null;
            if (convertView == null) {
                vp = new Holder();
                convertView = LayoutInflater.from(context).inflate(R.layout.shading_list_item, null);
                vp.shadingBar = (ShadingBar) convertView.findViewById(R.id.shaidng_bar);
                convertView.setTag(vp);
            } else {
                vp = (ShadingAdapter.Holder) convertView.getTag();
            }
            String weekNum = "";
            String spotName = dataList.get(position).getSpotName();

            weekNum = dataList.get(position).getWeekAttentionAlgorithm();

            vp.shadingBar.setData(Integer.parseInt(weekNum),MAX_NUM,spotName);

            return convertView;
        }


        public class Holder {

            private ShadingBar shadingBar;

        }
    }
}