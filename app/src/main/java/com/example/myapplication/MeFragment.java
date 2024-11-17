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

public class MeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);

        Button viewProfileButton = view.findViewById(R.id.view_profile_button);
        viewProfileButton.setOnClickListener(v ->
                Toast.makeText(getActivity(), "正在查看个人资料", Toast.LENGTH_SHORT).show()
        );

        return view;
    }
}

