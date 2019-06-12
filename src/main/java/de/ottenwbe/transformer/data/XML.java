/** 
* MIT License
* 
* Copyright (c) 2017-2019 Beate Ottenwälder
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
* 
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
import org.springframework.stereotype.Service;

@Service
public class XML {

    public String toString(Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("<root>");
        toString(sb, map);
        sb.append("</root>");
        return sb.toString();
    }

    private void toString(StringBuilder sb, Map<?, ?> map) {
        if (map != null) {
            map.forEach((key, value) -> {
                openTag(sb, key);
                addValue(sb, value);
                closeTag(sb, key);
            });
        }
    }

    private void addValue(StringBuilder sb, Object value) {
        if (value instanceof Map) {
            toString(sb, (Map<?, ?>) value);
        } else {
            sb.append(value);
        }
    }

    private void closeTag(StringBuilder sb, Object value) {
        tag(sb, value, "</");
    }

    private void openTag(StringBuilder sb, Object value) {
        tag(sb, value, "<");
    }

    private void tag(StringBuilder sb, Object value, String openSymbol) {
        sb.append(openSymbol);
        sb.append(value);
        sb.append(">");
    }

}
