package com.example.elsa.nowmovie.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.elsa.nowmovie.R;
import com.example.elsa.nowmovie.adapter.MovieAdapter;

public class DiputarFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = new View(Pind);

        Pindah(View view);
    }

    public void Pindah(View view){
        Intent intent = new Intent(getContext(), DiputarFragmentList.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }





}
