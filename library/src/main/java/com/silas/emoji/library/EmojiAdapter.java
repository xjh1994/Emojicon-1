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
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.silas.emoji.library.emoji.Emojicon;

import java.util.List;

/**
 * EmojiconGridFragment 用的适配器
 * @author Silas Ma (www.pureerf.com)
 */
public class EmojiAdapter extends ArrayAdapter<Emojicon> {
    private boolean mUseSystemDefault = false;

    public EmojiAdapter(Context context, List<Emojicon> data) {
        super(context, R.layout.emojicon_item, data);
        mUseSystemDefault = false;
    }

    public EmojiAdapter(Context context, List<Emojicon> data, boolean useSystemDefault) {
        super(context, R.layout.emojicon_item, data);
        mUseSystemDefault = useSystemDefault;
    }

    public EmojiAdapter(Context context, Emojicon[] data) {
        super(context, R.layout.emojicon_item, data);
        mUseSystemDefault = false;
    }

    public EmojiAdapter(Context context, Emojicon[] data, boolean useSystemDefault) {
        super(context, R.layout.emojicon_item, data);
        mUseSystemDefault = useSystemDefault;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = View.inflate(getContext(), R.layout.emojicon_item, null);
            ViewHolder holder = new ViewHolder();
            holder.icon = (EmojiconTextView) v.findViewById(R.id.emojicon_icon);
            holder.back = (ImageView) v.findViewById(R.id.emojis_backspace);
            holder.icon.setUseSystemDefault(mUseSystemDefault);
            v.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) v.getTag();
        // 最后一个，显示删除键
        if(position == (getCount()-1)) {
            holder.icon.setVisibility(View.GONE);
            holder.back.setVisibility(View.VISIBLE);
        } else {
            // 不是最后一个，显示emoji表情
            Emojicon emoji = getItem(position);
            holder.icon.setText(emoji.getEmoji());
            holder.icon.setVisibility(View.VISIBLE);
            holder.back.setVisibility(View.GONE);
        }

        return v;
    }

    class ViewHolder {
        EmojiconTextView icon;
        ImageView back;
    }
}