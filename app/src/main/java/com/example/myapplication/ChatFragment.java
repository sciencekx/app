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

public class ChatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        // 设置按钮点击事件
        Button sendMessageButton = view.findViewById(R.id.send_message_button);
        sendMessageButton.setOnClickListener(v ->
                Toast.makeText(getActivity(), "消息已发送！", Toast.LENGTH_SHORT).show()
        );

        return view;
    }
}
