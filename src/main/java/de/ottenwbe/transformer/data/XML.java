/**
 * Copyright (c) 2017 Beate Ottenwälder
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.ottenwbe.transformer.data;

import java.util.Map;

public class XML {

    static public String toString(Map map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            map.forEach((key, value) -> {
                openTag(sb, key);
                addValue(sb, value);
                closeTag(sb, key);
            });
        }
        return sb.toString();
    }

    private static void addValue(StringBuilder sb, Object value) {
        if (value instanceof Map) {
            sb.append(toString((Map) value));
        } else {
            sb.append(value);
        }
    }

    private static void closeTag(StringBuilder sb, Object key) {
        tag(sb, key, "</");
    }

    private static void openTag(StringBuilder sb, Object key) {
        tag(sb, key, "<");
    }

    private static void tag(StringBuilder sb, Object key, String str) {
        sb.append(str);
        sb.append(key);
        sb.append(">");
    }

}
