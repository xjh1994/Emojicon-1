/*
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

package com.silas.emoji.example;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.silas.emoji.library.EmojiconEditText;
import com.silas.emoji.library.EmojiconGridFragment;
import com.silas.emoji.library.EmojiconsFragment;
import com.silas.emoji.library.emoji.Emojicon;

/**
 * @author Silas Ma (www.pureerf.com)
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener,
        EmojiconGridFragment.OnEmojiconClickedListener, EmojiconGridFragment.OnEmojiconBackspaceClickedListener {

    private InputMethodManager imm;

    private EmojiconEditText editText;
    private ImageView imageEmojiKey;
    private FrameLayout emojicons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        editText = (EmojiconEditText) findViewById(R.id.et);
        imageEmojiKey = (ImageView) findViewById(R.id.image_emoji_key);
        imageEmojiKey.setBackgroundResource(R.mipmap.emoji);
        imageEmojiKey.setTag(R.mipmap.emoji);
        imageEmojiKey.setOnClickListener(this);
        emojicons = (FrameLayout) findViewById(R.id.flayout_emojicons);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flayout_emojicons, EmojiconsFragment.newInstance(false))
                .commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_emoji_key:
                if ((Integer) imageEmojiKey.getTag() == R.mipmap.emoji) {
                    showEmojicons();
                } else if ((Integer) imageEmojiKey.getTag() == R.mipmap.keyboard) {
                    showKeyboard();
                }
                break;
        }
    }


    /**
     * 显示Emoji输入面板
     */
    private void showEmojicons() {
        imageEmojiKey.setBackgroundResource(R.mipmap.keyboard);
        imageEmojiKey.setTag(R.mipmap.keyboard);
        emojicons.setVisibility(View.VISIBLE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    /**
     * 显示软键盘
     */
    public void showKeyboard() {
        imageEmojiKey.setBackgroundResource(R.mipmap.emoji);
        imageEmojiKey.setTag(R.mipmap.emoji);
        emojicons.setVisibility(View.GONE);
        imm.showSoftInput(getCurrentFocus(), InputMethodManager.SHOW_FORCED);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if((Integer)imageEmojiKey.getTag() == R.mipmap.keyboard) { // 说明弹出了emoji面板
                emojicons.setVisibility(View.GONE);
                imageEmojiKey.setBackgroundResource(R.mipmap.emoji);
                imageEmojiKey.setTag(R.mipmap.emoji);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onEmojiconBackspaceClicked(View v) {
        if(editText != null)
            EmojiconsFragment.backspace(editText);
    }

    @Override
    public void onEmojiconClicked(Emojicon emojicon) {
        if(editText != null)
            EmojiconsFragment.input(editText, emojicon);
    }

}
