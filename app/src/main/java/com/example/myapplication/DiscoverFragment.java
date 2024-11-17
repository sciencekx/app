package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DiscoverFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        Button browseButton = view.findViewById(R.id.browse_button);
        browseButton.setOnClickListener(v ->
                Toast.makeText(getActivity(), "正在浏览推荐内容", Toast.LENGTH_SHORT).show()
        );

        return view;
    }
}

