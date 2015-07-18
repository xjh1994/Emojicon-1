/*
 * Copyright 2014 Hieu Rocker
 * Copyright 2015 Silas Ma
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.silas.emoji.library;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.silas.emoji.library.emoji.Emojicon;
import com.silas.emoji.library.emoji.Page1;

import java.util.Arrays;

/**
 * @author Silas Ma (www.pureerf.com)
 */
public class EmojiconGridFragment extends Fragment implements AdapterView.OnItemClickListener {
    private OnEmojiconClickedListener mOnEmojiconClickedListener;
    private OnEmojiconBackspaceClickedListener mOnEmojiconBackspaceClickedListener;
    private Emojicon[] mData;
    private boolean mUseSystemDefault = false;

    private static final String USE_SYSTEM_DEFAULT_KEY = "useSystemDefaults";

    protected static EmojiconGridFragment newInstance(Emojicon[] emojicons) {
        return newInstance(emojicons, false);
    }

    protected static EmojiconGridFragment newInstance(Emojicon[] emojicons, boolean useSystemDefault) {
        EmojiconGridFragment emojiGridFragment = new EmojiconGridFragment();
        Bundle args = new Bundle();
        args.putSerializable("emojicons", emojicons);
        args.putBoolean(USE_SYSTEM_DEFAULT_KEY, useSystemDefault);
        emojiGridFragment.setArguments(args);
        return emojiGridFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.emojicon_grid, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        GridView gridView = (GridView) view.findViewById(R.id.Emoji_GridView);
        Bundle bundle = getArguments();
        if (bundle == null) {
            mData = Page1.DATA;
            mUseSystemDefault = false;
        } else {
            Object[] o = (Object[]) getArguments().getSerializable("emojicons");
            mData = Arrays.asList(o).toArray(new Emojicon[o.length]);
            mUseSystemDefault = bundle.getBoolean(USE_SYSTEM_DEFAULT_KEY);
        }
        gridView.setAdapter(new EmojiAdapter(view.getContext(), mData, mUseSystemDefault));
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("emojicons", mData);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // 当Fragment已经Attach到Activity上是，获取监听器
        if (activity instanceof OnEmojiconClickedListener) {
            mOnEmojiconClickedListener = (OnEmojiconClickedListener) activity;
        } else if (getParentFragment() instanceof OnEmojiconClickedListener) {
            mOnEmojiconClickedListener = (OnEmojiconClickedListener) getParentFragment();
        } else {
            throw new IllegalArgumentException(activity + " must implement interface " + OnEmojiconClickedListener.class.getSimpleName());
        }
        if (getActivity() instanceof OnEmojiconBackspaceClickedListener) {
            mOnEmojiconBackspaceClickedListener = (OnEmojiconBackspaceClickedListener) getActivity();
        } else if(getParentFragment() instanceof  OnEmojiconBackspaceClickedListener) {
            mOnEmojiconBackspaceClickedListener = (OnEmojiconBackspaceClickedListener) getParentFragment();
        } else {
            throw new IllegalArgumentException(activity + " must implement interface " + OnEmojiconBackspaceClickedListener.class.getSimpleName());
        }
    }

    @Override
    public void onDetach() {
        mOnEmojiconClickedListener = null;
        mOnEmojiconBackspaceClickedListener = null;
        super.onDetach();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position == (mData.length-1)) { // 如果点击的是最后一个，回调删除emoji的方法
            if (mOnEmojiconBackspaceClickedListener != null) {
                mOnEmojiconBackspaceClickedListener.onEmojiconBackspaceClicked(view);
            }
        } else {
            if (mOnEmojiconClickedListener != null) {
                mOnEmojiconClickedListener.onEmojiconClicked((Emojicon) parent.getItemAtPosition(position));
            }
        }
    }

    /**
     * 点击了Emoji表情的监听器
     */
    public interface OnEmojiconClickedListener {
        void onEmojiconClicked(Emojicon emojicon);
    }

    /**
     * 删除Emoji表情的监听器
     */
    public interface OnEmojiconBackspaceClickedListener {
        void onEmojiconBackspaceClicked(View v);
    }
}
