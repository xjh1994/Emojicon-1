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

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.silas.emoji.library.emoji.Emojicon;
import com.silas.emoji.library.emoji.Page1;
import com.silas.emoji.library.emoji.Page2;
import com.silas.emoji.library.emoji.Page3;

import java.util.Arrays;
import java.util.List;

/**
 * @author Silas Ma (silas_ma@163.com)
 */
public class EmojiconsFragment extends Fragment implements ViewPager.OnPageChangeListener{

    private PagerAdapter mEmojisAdapter;
    private boolean mUseSystemDefault = false;
    private final int PAGE_SIZE = 3; // 总共有几页表情
    private int currentPagerPostion = 0; // ViewPager当前位置
    private int oldPagerPosition = 0; // 上一个位置

    private static final String USE_SYSTEM_DEFAULT_KEY = "useSystemDefaults";
    private LinearLayout dotsLayout;

    public static EmojiconsFragment newInstance(boolean useSystemDefault) {
        EmojiconsFragment fragment = new EmojiconsFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(USE_SYSTEM_DEFAULT_KEY, useSystemDefault);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emojicons, container, false);
        final ViewPager emojisPager = (ViewPager) view.findViewById(R.id.emojis_pager);
        dotsLayout = (LinearLayout)view.findViewById(R.id.dots_layout);

        emojisPager.setOnPageChangeListener(this);
        mEmojisAdapter = new EmojisPagerAdapter(getFragmentManager(), Arrays.asList(
                EmojiconGridFragment.newInstance(Page1.DATA, mUseSystemDefault),
                EmojiconGridFragment.newInstance(Page2.DATA, mUseSystemDefault),
                EmojiconGridFragment.newInstance(Page3.DATA, mUseSystemDefault)
        ));
        emojisPager.setAdapter(mEmojisAdapter);

        // 先显示第0页
        emojisPager.setCurrentItem(0, false);
        // 最初的指示器设置
        dotsLayout.removeAllViews();
        for(int i=0; i<PAGE_SIZE; i++) {
            ImageView iv = new ImageView(container.getContext());
            if(i == currentPagerPostion)
                iv.setBackgroundResource(R.mipmap.dot_sel);
            else
                iv.setBackgroundResource(R.mipmap.dot);

            DisplayMetrics displaysMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) container.getContext()
                    .getSystemService(Context.WINDOW_SERVICE);
            windowManager.getDefaultDisplay().getMetrics(displaysMetrics);
            float density = displaysMetrics.density;
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams((int)(8*density), (int)(8*density)); // 圆点尺寸
            lp.setMargins((int)(2*density), 0, (int)(2*density), 0);
            iv.setLayoutParams(lp);
            dotsLayout.addView(iv, i);
        }

        return view;
    }

    /**
     * 添加一个emoji表情
     * @param editText 所在的EditText控件
     * @param emojicon 要添加到EditText中的Emojicon对象
     */
    public static void input(EditText editText, Emojicon emojicon) {
        if (editText == null || emojicon == null) {
            return;
        }

        int start = editText.getSelectionStart();
        int end = editText.getSelectionEnd();
        if (start < 0) {
            editText.append(emojicon.getEmoji());
        } else {
            editText.getText().replace(Math.min(start, end), Math.max(start, end), emojicon.getEmoji(), 0, emojicon.getEmoji().length());
        }
    }

    /**
     * 删除一个emoji表情
     * @param editText 所在的EditText控件
     */
    public static void backspace(EditText editText) {
        KeyEvent event = new KeyEvent(0, 0, 0, KeyEvent.KEYCODE_DEL, 0, 0, 0, 0, KeyEvent.KEYCODE_ENDCALL);
        editText.dispatchKeyEvent(event);
    }

    @Override
    public void onPageScrolled(int i, float v, int i2) {
    }

    @Override
    public void onPageSelected(int position) {
        // 修改指示器的样式
        currentPagerPostion = position;
        dotsLayout.getChildAt(currentPagerPostion).setBackgroundResource(R.mipmap.dot_sel);
        dotsLayout.getChildAt(oldPagerPosition).setBackgroundResource(R.mipmap.dot);
        oldPagerPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(int i) {
    }

    private static class EmojisPagerAdapter extends FragmentStatePagerAdapter {
        private List<EmojiconGridFragment> fragments;

        public EmojisPagerAdapter(FragmentManager fm, List<EmojiconGridFragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    /**
     * A class, that can be used as a TouchListener on any view (e.g. a Button).
     * It cyclically runs a clickListener, emulating keyboard-like behaviour. First
     * click is fired immediately, next before initialInterval, and subsequent before
     * normalInterval.
     * <p/>
     * <p>Interval is scheduled before the onClick completes, so it has to run fast.
     * If it runs slow, it does not generate skipped onClicks.
     */
    public static class RepeatListener implements View.OnTouchListener {

        private Handler handler = new Handler();

        private int initialInterval;
        private final int normalInterval;
        private final View.OnClickListener clickListener;

        private Runnable handlerRunnable = new Runnable() {
            @Override
            public void run() {
                if (downView == null) {
                    return;
                }
                handler.removeCallbacksAndMessages(downView);
                handler.postAtTime(this, downView, SystemClock.uptimeMillis() + normalInterval);
                clickListener.onClick(downView);
            }
        };

        private View downView;

        /**
         * @param initialInterval The interval before first click event
         * @param normalInterval  The interval before second and subsequent click
         *                        events
         * @param clickListener   The OnClickListener, that will be called
         *                        periodically
         */
        public RepeatListener(int initialInterval, int normalInterval, View.OnClickListener clickListener) {
            if (clickListener == null)
                throw new IllegalArgumentException("null runnable");
            if (initialInterval < 0 || normalInterval < 0)
                throw new IllegalArgumentException("negative interval");

            this.initialInterval = initialInterval;
            this.normalInterval = normalInterval;
            this.clickListener = clickListener;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downView = view;
                    handler.removeCallbacks(handlerRunnable);
                    handler.postAtTime(handlerRunnable, downView, SystemClock.uptimeMillis() + initialInterval);
                    clickListener.onClick(view);
                    return true;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_OUTSIDE:
                    handler.removeCallbacksAndMessages(downView);
                    downView = null;
                    return true;
            }
            return false;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUseSystemDefault = getArguments().getBoolean(USE_SYSTEM_DEFAULT_KEY);
        } else {
            mUseSystemDefault = false;
        }
    }
}
