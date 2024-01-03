package com.example.chat.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.chat.R;
import com.example.chat.databinding.FragmentUserDrawerBinding;
import com.example.chat.model.User;
import com.example.chat.ui.activity.AuthActivity;
import com.example.chat.ui.viewmodel.UserViewModel;
import com.example.chat.utils.Constant;

public class UserDrawerFragment extends Fragment implements View.OnClickListener {
    private FragmentUserDrawerBinding binding;
    private UserViewModel userViewModel;

    public UserDrawerFragment() {

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUserDrawerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userViewModel = new ViewModelProvider(getActivity()).get(UserViewModel.class);
        binding.logOutClick.setOnClickListener(this);
        binding.userProfileClick.setOnClickListener(this);
        userViewModel.getUserLiveData().observe(getActivity(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Glide.with(getActivity()).load(getResource(user.getUserPicture())).into(binding.drawerUserImage);

            }
        });
    }

    private Object getResource(String userPicture) {
        switch (userPicture) {
            case "1":
                return R.drawable.frame1;
            case "2":
                return R.drawable.frame2;
            case "3":
                return R.drawable.frame3;
            case "4":
                return R.drawable.frame4;
            case "5":
                return R.drawable.frame5;
            case "6":
                return R.drawable.frame6;
            case "7":
                return R.drawable.frame7;
            case "8":
                return R.drawable.frame8;
            case "null":
                return R.drawable.logo;
            default:
                return userPicture; // Return the original string value in the default case
        }
    }

    public void setCardBackgroundColor(int color) {
            binding.userDrawerCardView.setCardBackgroundColor(color);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.logOutClick.getId()) {
            Constant.clearData(getActivity());
            startActivity(new Intent(getActivity(), AuthActivity.class));
            requireActivity().finish();
        } else if (view.getId() == binding.userProfileClick.getId()) {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_mainFragment_to_profileFragment);
        }
    }
}