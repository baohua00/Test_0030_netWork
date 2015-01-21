package com.example.test_0030_netWork.fragment;

import com.example.test_0030_netWork.R;
import com.example.test_0030_netWork.resource.Resource;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleFragment extends ListFragment {
	int mCurCheckPosition = 0;  
    int mShownCheckPosition = -1;  
  
    @Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);   
                                                          
        setListAdapter(new ArrayAdapter<String>(getActivity(),  
                android.R.layout.simple_list_item_activated_1,  
                Resource.TITLES)); //ʹ�þ�̬��������б�  
        if (savedInstanceState != null) {   
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
            mShownCheckPosition = savedInstanceState.getInt("shownChoice", -1);
        }   
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);   
            showDetails(mCurCheckPosition);  
    }  
  
    @Override  
    public void onSaveInstanceState(Bundle outState) {  
        super.onSaveInstanceState(outState);  
  
        outState.putInt("curChoice", mCurCheckPosition);  
        outState.putInt("shownChoice", mShownCheckPosition);  
    }  
  
    @Override  
    public void onListItemClick(ListView l, View v, int position, long id) {  
        showDetails(position);  
    }  
  
    /** 
     *��ʾlistview item ���� 
     */  
    void showDetails(int index) {  
        mCurCheckPosition = index;  
            getListView().setItemChecked(index, true);  
  
            if (mShownCheckPosition != mCurCheckPosition) {  
  
                DetailsFragment df = DetailsFragment.newInstance(index);  
                FragmentTransaction ft = getFragmentManager()  
                        .beginTransaction();  
                ft.replace(R.id.details, df);  
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                ft.addToBackStack(null);
                ft.commit();
                mShownCheckPosition = index;  
            }     
    }
}
