package com.example.test_0030_netWork.fragment;

import com.example.test_0030_netWork.DisplayActivity;
import com.example.test_0030_netWork.R;
import com.example.test_0030_netWork.SoundActivity;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragment extends Fragment implements OnItemClickListener {  
    
    
    //�˵�������ֻ������һ��ListView�� 
    private ListView menuList;  
       
    //ListView���������� 
    private ArrayAdapter<String> adapter;  
       
    //�������ListView�����ݣ�����ͼ�ֻ�����������ݡ� 
    private String[] menuItems = { "Sound", "Display" };  
       
    //�Ƿ���˫ҳģʽ�����һ��Activity�а���������Fragment������˫ҳģʽ�� 
    private boolean isTwoPane;  
       
    //��Activity��Fragment��������ʱ����ʼ���������е����ݡ� 
    @Override
    public void onAttach(Activity activity) {  
        super.onAttach(activity);  
        adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, menuItems);  
    }  
       
    //����menu_fragment�����ļ���ΪListView�������������������˼����¼��� 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {  
        View view = inflater.inflate(R.layout.menu_fragment, container, false);  
        menuList = (ListView) view.findViewById(R.id.menu_list);  
        menuList.setAdapter(adapter);  
        menuList.setOnItemClickListener(this);  
        return view;  
    }  
       
    //��Activity������Ϻ󣬳��Ի�ȡһ�²����ļ����Ƿ���details_layout���Ԫ�أ������˵����ǰ 
    //��˫ҳģʽ�����û��˵����ǰ�ǵ�ҳģʽ�� 
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        if (getActivity().findViewById(R.id.details_layout) != null) {  
            isTwoPane = true;  
        } else {  
            isTwoPane = false;  
        }  
    }  
       
    //����ListView�ĵ���¼�������ݵ�ǰ�Ƿ���˫ҳģʽ�����жϡ������˫ҳģʽ����ᶯ̬���Fragment�� 
    //�������˫ҳģʽ�������µ�Activity�� 
    @Override
    public void onItemClick(AdapterView<?> arg0, View view, int index, long arg3) {  
        if (isTwoPane) {  
            Fragment fragment = null;  
            if (index == 0) {  
                fragment = new SoundFragment();  
            } else if (index == 1) {  
                fragment = new DisplayFragment();  
            }  
            getFragmentManager().beginTransaction().replace(R.id.details_layout, fragment).commit();  
        } else {  
            Intent intent = null;  
            if (index == 0) {  
                intent = new Intent(getActivity(), SoundActivity.class);  
            } else if (index == 1) {  
                intent = new Intent(getActivity(), DisplayActivity.class);  
            }  
            startActivity(intent);  
        }  
    }  
       
}