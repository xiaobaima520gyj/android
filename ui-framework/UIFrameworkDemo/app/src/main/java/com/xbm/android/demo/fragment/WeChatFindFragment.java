package com.xbm.android.demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xbm.android.demo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeChatFindFragment extends Fragment {


    public WeChatFindFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_we_chat_find, container, false);
    }

}
