package com.andersmurillo92.posts.utils;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.recyclerview.widget.RecyclerView;

import com.andersmurillo92.posts.R;

public class Animations {

    public Animations() {
        super();
    }

    public void runRecyclerAnimation(RecyclerView recyclerView) {

        Context context = recyclerView.getContext();
        AnimationUtils.loadLayoutAnimation(context, R.anim.recycler_item_anim);
        LayoutAnimationController controller;

        controller = AnimationUtils.loadLayoutAnimation(context, R.anim.recycler_item_anim);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}