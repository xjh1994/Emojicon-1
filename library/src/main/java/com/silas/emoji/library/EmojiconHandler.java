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
import android.text.Spannable;
import android.util.SparseIntArray;

/**
 * @author Silas Ma (silas_ma@163.com)
 */
public final class EmojiconHandler {
    private EmojiconHandler() {
    }

    private static final SparseIntArray sEmojisMap = new SparseIntArray(846);
    private static final SparseIntArray sSoftbanksMap = new SparseIntArray(471);

    static {
        sEmojisMap.put(0x1f609, R.drawable.emoji_1f609);
        sEmojisMap.put(0x1f618, R.drawable.emoji_1f618);
        sEmojisMap.put(0x1f619, R.drawable.emoji_1f619);
        sEmojisMap.put(0x1f61c, R.drawable.emoji_1f61c);
        sEmojisMap.put(0x1f61d, R.drawable.emoji_1f61d);
        sEmojisMap.put(0x1f633, R.drawable.emoji_1f633);
        sEmojisMap.put(0x1f601, R.drawable.emoji_1f601);
        sEmojisMap.put(0x1f60c, R.drawable.emoji_1f60c);
        sEmojisMap.put(0x1f612, R.drawable.emoji_1f612);
        sEmojisMap.put(0x1f623, R.drawable.emoji_1f623);
        sEmojisMap.put(0x1f622, R.drawable.emoji_1f622);
        sEmojisMap.put(0x1f602, R.drawable.emoji_1f602);
        sEmojisMap.put(0x1f62d, R.drawable.emoji_1f62d);
        sEmojisMap.put(0x1f630, R.drawable.emoji_1f630);
        sEmojisMap.put(0x1f629, R.drawable.emoji_1f629);
        sEmojisMap.put(0x1f628, R.drawable.emoji_1f628);
        sEmojisMap.put(0x1f631, R.drawable.emoji_1f631);
        sEmojisMap.put(0x1f620, R.drawable.emoji_1f620);
        sEmojisMap.put(0x1f621, R.drawable.emoji_1f621);
        sEmojisMap.put(0x1f624, R.drawable.emoji_1f624);
        sEmojisMap.put(0x1f606, R.drawable.emoji_1f606);
        sEmojisMap.put(0x1f637, R.drawable.emoji_1f637);
        sEmojisMap.put(0x1f634, R.drawable.emoji_1f634);
        sEmojisMap.put(0x1f632, R.drawable.emoji_1f632);
        sEmojisMap.put(0x1f627, R.drawable.emoji_1f627);
        sEmojisMap.put(0x1f4a9, R.drawable.emoji_1f4a9);
        sEmojisMap.put(0x1f525, R.drawable.emoji_1f525);
        sEmojisMap.put(0x1f4a2, R.drawable.emoji_1f4a2);
        sEmojisMap.put(0x1f4a6, R.drawable.emoji_1f4a6);
        sEmojisMap.put(0x1f44d, R.drawable.emoji_1f44d);
        sEmojisMap.put(0x1f44e, R.drawable.emoji_1f44e);
        sEmojisMap.put(0x1f44f, R.drawable.emoji_1f44f);
        sEmojisMap.put(0x1f44c, R.drawable.emoji_1f44c);
        sEmojisMap.put(0x1f44a, R.drawable.emoji_1f44a);
        sEmojisMap.put(0x1f46f, R.drawable.emoji_1f46f);
        sEmojisMap.put(0x270c, R.drawable.emoji_270c);
        sEmojisMap.put(0x270b, R.drawable.emoji_270b);
        sEmojisMap.put(0x1f450, R.drawable.emoji_1f450);
        sEmojisMap.put(0x1f446, R.drawable.emoji_1f446);
        sEmojisMap.put(0x1f447, R.drawable.emoji_1f447);
        sEmojisMap.put(0x1f449, R.drawable.emoji_1f449);
        sEmojisMap.put(0x1f448, R.drawable.emoji_1f448);
        sEmojisMap.put(0x1f64f, R.drawable.emoji_1f64f);
        sEmojisMap.put(0x261d, R.drawable.emoji_261d);
        sEmojisMap.put(0x1f4aa, R.drawable.emoji_1f4aa);
        sEmojisMap.put(0x1f483, R.drawable.emoji_1f483);
        sEmojisMap.put(0x1f48b, R.drawable.emoji_1f48b);
        sEmojisMap.put(0x1f337, R.drawable.emoji_1f337);
        sEmojisMap.put(0x1f339, R.drawable.emoji_1f339);
        sEmojisMap.put(0x1f381, R.drawable.emoji_1f381);
        sEmojisMap.put(0x1f4f7, R.drawable.emoji_1f4f7);
        sEmojisMap.put(0x1f4a3, R.drawable.emoji_1f4a3);
        sEmojisMap.put(0x1f4b5, R.drawable.emoji_1f4b5);
        sEmojisMap.put(0x1f3a4, R.drawable.emoji_1f3a4);
        sEmojisMap.put(0x1f3c6, R.drawable.emoji_1f3c6);
        sEmojisMap.put(0x1f378, R.drawable.emoji_1f378);
        sEmojisMap.put(0x1f382, R.drawable.emoji_1f382);
        sEmojisMap.put(0x1f51e, R.drawable.emoji_1f51e);
        sEmojisMap.put(0x1f4af, R.drawable.emoji_1f4af);
        sEmojisMap.put(0x1f6a9, R.drawable.emoji_1f6a9);


        sSoftbanksMap.put(0xe003, R.drawable.emoji_1f48b);
        sSoftbanksMap.put(0xe008, R.drawable.emoji_1f4f7);
        sSoftbanksMap.put(0xe00d, R.drawable.emoji_1f44a);
        sSoftbanksMap.put(0xe00e, R.drawable.emoji_1f44d);
        sSoftbanksMap.put(0xe00f, R.drawable.emoji_261d);
        sSoftbanksMap.put(0xe011, R.drawable.emoji_270c);
        sSoftbanksMap.put(0xe032, R.drawable.emoji_1f339);
        sSoftbanksMap.put(0xe03c, R.drawable.emoji_1f3a4);
        sSoftbanksMap.put(0xe059, R.drawable.emoji_1f620);
        sSoftbanksMap.put(0xe05a, R.drawable.emoji_1f4a9);
        sSoftbanksMap.put(0xe105, R.drawable.emoji_1f61c);
        sSoftbanksMap.put(0xe107, R.drawable.emoji_1f631);
        sSoftbanksMap.put(0xe112, R.drawable.emoji_1f381);
        sSoftbanksMap.put(0xe11d, R.drawable.emoji_1f525);
        sSoftbanksMap.put(0xe131, R.drawable.emoji_1f3c6);
        sSoftbanksMap.put(0xe14c, R.drawable.emoji_1f4aa);
        sSoftbanksMap.put(0xe207, R.drawable.emoji_1f51e);
        sSoftbanksMap.put(0xe22e, R.drawable.emoji_1f446);
        sSoftbanksMap.put(0xe22f, R.drawable.emoji_1f447);
        sSoftbanksMap.put(0xe230, R.drawable.emoji_1f448);
        sSoftbanksMap.put(0xe231, R.drawable.emoji_1f449);
        sSoftbanksMap.put(0xe429, R.drawable.emoji_1f46f);
        sSoftbanksMap.put(0xe304, R.drawable.emoji_1f337);
        sSoftbanksMap.put(0xe311, R.drawable.emoji_1f4a3);
        sSoftbanksMap.put(0xe331, R.drawable.emoji_1f4a6);
        sSoftbanksMap.put(0xe334, R.drawable.emoji_1f4a2);
        sSoftbanksMap.put(0xe34b, R.drawable.emoji_1f382);
        sSoftbanksMap.put(0xe404, R.drawable.emoji_1f601);
        sSoftbanksMap.put(0xe405, R.drawable.emoji_1f609);
        sSoftbanksMap.put(0xe406, R.drawable.emoji_1f623);
        sSoftbanksMap.put(0xe40a, R.drawable.emoji_1f606);
        sSoftbanksMap.put(0xe40b, R.drawable.emoji_1f628);
        sSoftbanksMap.put(0xe40c, R.drawable.emoji_1f637);
        sSoftbanksMap.put(0xe40d, R.drawable.emoji_1f633);
        sSoftbanksMap.put(0xe40e, R.drawable.emoji_1f612);
        sSoftbanksMap.put(0xe40f, R.drawable.emoji_1f630);
        sSoftbanksMap.put(0xe410, R.drawable.emoji_1f632);
        sSoftbanksMap.put(0xe411, R.drawable.emoji_1f62d);
        sSoftbanksMap.put(0xe412, R.drawable.emoji_1f602);
        sSoftbanksMap.put(0xe413, R.drawable.emoji_1f622);
        sSoftbanksMap.put(0xe416, R.drawable.emoji_1f621);
        sSoftbanksMap.put(0xe418, R.drawable.emoji_1f618);
        sSoftbanksMap.put(0xe41d, R.drawable.emoji_1f64f);
        sSoftbanksMap.put(0xe420, R.drawable.emoji_1f44c);
        sSoftbanksMap.put(0xe421, R.drawable.emoji_1f44e);
        sSoftbanksMap.put(0xe41f, R.drawable.emoji_1f44f);
        sSoftbanksMap.put(0xe422, R.drawable.emoji_1f450);
        sSoftbanksMap.put(0xe51f, R.drawable.emoji_1f483);
    }

    public static boolean isSoftBankEmoji(char c) {
        return ((c >> 12) == 0xe);
    }

    private static int getEmojiResource(Context context, int codePoint) {
        return sEmojisMap.get(codePoint);
    }

    /**
     * 参数context没用到，程序里其他地方要调用这个方法，不需要传context参数
     * @param codePoint emoji的编码
     * @return emoji表情图片资源id
     */
    public static int getEmojiResource(int codePoint) {
        return sEmojisMap.get(codePoint);
    }

    public static int getSoftbankEmojiResource(char c) {
        return sSoftbanksMap.get(c);
    }

    /**
     * Convert emoji characters of the given Spannable to the according emojicon.
     *
     * @param context
     * @param text
     * @param emojiSize
     */
    public static void addEmojis(Context context, Spannable text, int emojiSize, int textSize) {
        addEmojis(context, text, emojiSize, textSize, 0, -1, false);
    }

    /**
     * Convert emoji characters of the given Spannable to the according emojicon.
     *
     * @param context
     * @param text
     * @param emojiSize
     * @param index
     * @param length
     */
    public static void addEmojis(Context context, Spannable text, int emojiSize, int textSize, int index, int length) {
        addEmojis(context, text, emojiSize, textSize, index, length, false);
    }

    /**
     * Convert emoji characters of the given Spannable to the according emojicon.
     *
     * @param context
     * @param text
     * @param emojiSize
     * @param useSystemDefault
     */
    public static void addEmojis(Context context, Spannable text, int emojiSize, int textSize, boolean useSystemDefault) {
        addEmojis(context, text, emojiSize, textSize, 0, -1, useSystemDefault);
    }

    /**
     * Convert emoji characters of the given Spannable to the according emojicon.
     *
     * @param context
     * @param text
     * @param emojiSize
     * @param index
     * @param length
     * @param useSystemDefault
     */
    public static void addEmojis(Context context, Spannable text, int emojiSize, int textSize, int index, int length, boolean useSystemDefault) {
        if (useSystemDefault) {
            return;
        }

        int textLength = text.length();
        int textLengthToProcessMax = textLength - index;
        int textLengthToProcess = length < 0 || length >= textLengthToProcessMax ? textLength : (length+index);

        // remove spans throughout all text
        EmojiconSpan[] oldSpans = text.getSpans(0, textLength, EmojiconSpan.class);
        for (int i = 0; i < oldSpans.length; i++) {
            text.removeSpan(oldSpans[i]);
        }

        int skip;
        for (int i = index; i < textLengthToProcess; i += skip) {
            skip = 0;
            int icon = 0;
            char c = text.charAt(i);
            if (isSoftBankEmoji(c)) {
                icon = getSoftbankEmojiResource(c);
                skip = icon == 0 ? 0 : 1;
            }

            if (icon == 0) {
                int unicode = Character.codePointAt(text, i);
                skip = Character.charCount(unicode);
                if (unicode > 0xff) {
                    icon = getEmojiResource(context, unicode);
                }

                if (icon == 0 && i + skip < textLengthToProcess) {
                    int followUnicode = Character.codePointAt(text, i + skip);
                    if (followUnicode == 0x20e3) {
                        int followSkip = Character.charCount(followUnicode);
                        switch (unicode) {
//                            case 0x0031:
//                                icon = R.drawable.emoji_0031;
//                                break;
//                            case 0x0032:
//                                icon = R.drawable.emoji_0032;
//                                break;
//                            case 0x0033:
//                                icon = R.drawable.emoji_0033;
//                                break;
//                            case 0x0034:
//                                icon = R.drawable.emoji_0034;
//                                break;
//                            case 0x0035:
//                                icon = R.drawable.emoji_0035;
//                                break;
//                            case 0x0036:
//                                icon = R.drawable.emoji_0036;
//                                break;
//                            case 0x0037:
//                                icon = R.drawable.emoji_0037;
//                                break;
//                            case 0x0038:
//                                icon = R.drawable.emoji_0038;
//                                break;
//                            case 0x0039:
//                                icon = R.drawable.emoji_0039;
//                                break;
//                            case 0x0030:
//                                icon = R.drawable.emoji_0030;
//                                break;
//                            case 0x0023:
//                                icon = R.drawable.emoji_0023;
//                                break;
                            default:
                                followSkip = 0;
                                break;
                        }
                        skip += followSkip;
                    } else {
                        int followSkip = Character.charCount(followUnicode);
                        switch (unicode) {
//                            case 0x1f1ef:
//                                icon = (followUnicode == 0x1f1f5) ? R.drawable.emoji_1f1ef_1f1f5 : 0;
//                                break;
//                            case 0x1f1fa:
//                                icon = (followUnicode == 0x1f1f8) ? R.drawable.emoji_1f1fa_1f1f8 : 0;
//                                break;
//                            case 0x1f1eb:
//                                icon = (followUnicode == 0x1f1f7) ? R.drawable.emoji_1f1eb_1f1f7 : 0;
//                                break;
//                            case 0x1f1e9:
//                                icon = (followUnicode == 0x1f1ea) ? R.drawable.emoji_1f1e9_1f1ea : 0;
//                                break;
//                            case 0x1f1ee:
//                                icon = (followUnicode == 0x1f1f9) ? R.drawable.emoji_1f1ee_1f1f9 : 0;
//                                break;
//                            case 0x1f1ec:
//                                icon = (followUnicode == 0x1f1e7) ? R.drawable.emoji_1f1ec_1f1e7 : 0;
//                                break;
//                            case 0x1f1ea:
//                                icon = (followUnicode == 0x1f1f8) ? R.drawable.emoji_1f1ea_1f1f8 : 0;
//                                break;
//                            case 0x1f1f7:
//                                icon = (followUnicode == 0x1f1fa) ? R.drawable.emoji_1f1f7_1f1fa : 0;
//                                break;
//                            case 0x1f1e8:
//                                icon = (followUnicode == 0x1f1f3) ? R.drawable.emoji_1f1e8_1f1f3 : 0;
//                                break;
//                            case 0x1f1f0:
//                                icon = (followUnicode == 0x1f1f7) ? R.drawable.emoji_1f1f0_1f1f7 : 0;
//                                break;
                            default:
                                followSkip = 0;
                                break;
                        }
                        skip += followSkip;
                    }
                }
            }
            if (icon > 0) {
                text.setSpan(new EmojiconSpan(context, icon, emojiSize, textSize), i, i + skip, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }

}
