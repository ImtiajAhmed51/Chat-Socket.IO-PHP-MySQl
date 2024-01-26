package com.example.chat.ui.fragment.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.chat.databinding.FragmentRequestsBinding;
import com.example.chat.utils.Constant;
import com.example.chat.utils.DimensionUtils;

public class RequestsFragment extends Fragment implements View.OnClickListener {
    private FragmentRequestsBinding binding;
    private String title;
    private int type;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRequestsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Constant.setTopMargin(binding.requestsFragmentMargin, DimensionUtils.getStatusBarHeight(requireActivity()));
        Constant.setBottomMargin(binding.requestsCardViewMargin, DimensionUtils.getNavigationBarHeight(requireActivity()));
        initializeArguments();

        binding.requestsTitle.setText(title);
        binding.requestsBackPressed.setOnClickListener(this);


    }
    private void initializeArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            title = arguments.getString("title");
            type = arguments.getInt("type");

        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==binding.requestsBackPressed.getId()){
            requireActivity().onBackPressed();
        }
    }
}