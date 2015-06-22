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

package com.silas.emoji.library.emoji;

/**
 * Emoji面板第一页显示的图标
 * @author Silas Ma (silas_ma@163.com)
 */
public class Page1 {
    public static final Emojicon[] DATA = new Emojicon[]{
            Emojicon.fromCodePoint(0x1f60c),
            Emojicon.fromCodePoint(0x1f61c),
            Emojicon.fromCodePoint(0x1f61d),
            Emojicon.fromCodePoint(0x1f62d),
            Emojicon.fromCodePoint(0x1f601),
            Emojicon.fromCodePoint(0x1f602),
            Emojicon.fromCodePoint(0x1f606),
            Emojicon.fromCodePoint(0x1f609),
            Emojicon.fromCodePoint(0x1f612),
            Emojicon.fromCodePoint(0x1f618),
            Emojicon.fromCodePoint(0x1f619),
            Emojicon.fromCodePoint(0x1f620),
            Emojicon.fromCodePoint(0x1f621),
            Emojicon.fromCodePoint(0x1f622),
            Emojicon.fromCodePoint(0x1f623),
            Emojicon.fromCodePoint(0x1f624),
            Emojicon.fromCodePoint(0x1f627),
            Emojicon.fromCodePoint(0x1f628),
            Emojicon.fromCodePoint(0x1f629),
            Emojicon.fromCodePoint(0x1f630),
            Emojicon.fromCodePoint(0x00000)
            // 最后一个就是用来占位置的，适配器用的时ArrayAdapter，
            // 让适配器长度加一个，以放置删除键
    };
}
