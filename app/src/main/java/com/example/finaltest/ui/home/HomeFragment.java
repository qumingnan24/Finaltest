package com.example.finaltest.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.finaltest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private int[] images = {R.drawable.picture_1, R.drawable.picture_2, R.drawable.picture_3, R.drawable.picture_4, R.drawable.picture_5};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridview = root.findViewById(R.id.gridview);
        List<Map<String, Object>> imageList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 60; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", images[i % images.length]);
            imageList.add(map);
            HomeAdapter homeAdapter = new HomeAdapter(requireContext(), requireActivity(), imageList);
            gridview.setAdapter(homeAdapter);
        }
        return root;
    }
}