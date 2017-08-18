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
import com.chris.horizontalbarsdemo.views.FiveColorBar;
import com.chris.horizontalbarsdemo.views.ShadingBar;
import com.chris.horizontalbarsdemo.views.SpotInfo;

import java.util.ArrayList;

/**
 * Created by win on 2017/8/18.
 */

public class FiveColorBarFragment extends Fragment {

    private ListView listView;


    FiveColorAdapter fiveColorAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.five_color_bar_fragment_lay,null,true);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView)view.findViewById(R.id.listview);
        fiveColorAdapter = new FiveColorAdapter(getActivity());
        listView.setAdapter(fiveColorAdapter);
        listView.post(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        });
    }

    private void initData()
    {
        ArrayList<SpotInfo> list = new ArrayList<>();
        for(int i = 0;i<20;i++)
        {
            SpotInfo info1 = new SpotInfo();
            info1.setSatisfactionBest((int)(Math.random()*1000) +"");
            info1.setSatisfactionGood((int)(Math.random()*1000) +"");
            info1.setSatisfactionNormal((int)(Math.random()*1000) +"");
            info1.setSatisfactionBad((int)(Math.random()*1000) +"");
            info1.setSatisfactionWorst((int)(Math.random()*1000) +"");

            info1.setSpotName("XXXX");
            info1.setSatisfactionScore((int)(Math.random()*10)+"");

            list.add(info1);
        }
        fiveColorAdapter.updateData(list);
    }

    public class FiveColorAdapter extends ArrayAdapter
    {
        private String TAG = "FiveColorAdapter";

        private ArrayList<SpotInfo> dataList;

        private Context context;

        public FiveColorAdapter(Context context)
        {
            super(context,0);
            this.context = context;
        }
        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }


        public void updateData(ArrayList<SpotInfo> list)
        {
            dataList = list;
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
            Holder vp = null;
            if (convertView == null) {
                vp = new Holder();
                convertView = LayoutInflater.from(context).inflate(R.layout.five_color_list_item, null);
                vp.colorBar = (FiveColorBar) convertView.findViewById(R.id.color_bar);
                convertView.setTag(vp);
            } else {
                vp = (Holder) convertView.getTag();
            }
            String spotName = dataList.get(position).getSpotName()+" "+dataList.get(position).getSatisfactionScore();

            int bestNum = Integer.parseInt(dataList.get(position).getSatisfactionBest());

            int goodNum = Integer.parseInt(dataList.get(position).getSatisfactionGood());

            int normalNum = Integer.parseInt(dataList.get(position).getSatisfactionNormal());

            int badNum = Integer.parseInt(dataList.get(position).getSatisfactionBad());

            int worstNum = Integer.parseInt(dataList.get(position).getSatisfactionWorst());



            vp.colorBar.setData(spotName,bestNum,goodNum,normalNum,badNum,worstNum);

            return convertView;
        }


        public class Holder {

            private FiveColorBar colorBar;

        }
    }
}