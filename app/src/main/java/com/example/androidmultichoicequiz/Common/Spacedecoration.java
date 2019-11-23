package com.example.androidmultichoicequiz.Common;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Spacedecoration extends RecyclerView.ItemDecoration {

    private int space;

    public Spacedecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left =outRect.right = outRect.bottom = outRect.left = space;

    }
}
