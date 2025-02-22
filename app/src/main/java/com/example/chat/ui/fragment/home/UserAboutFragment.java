package com.example.chat.ui.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.chat.databinding.FragmentUserAboutBinding;

public class UserAboutFragment extends Fragment {
    private FragmentUserAboutBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUserAboutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

}