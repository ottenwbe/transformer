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

package de.ottenwbe.transformer.services;

import com.google.gson.Gson;
import de.ottenwbe.transformer.controller.JsonController;
import de.ottenwbe.transformer.data.XML;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

@Service
public class YamlConverter implements ConverterInterface {

    private static Log log = LogFactory.getLog(JsonController.class);

    @Override
    public String toYaml(String yamlString) {
        return yamlString;
    }

    @Override
    public String toJson(String yamlString) {
        log.trace(String.format("Convert yaml to json: %s", yamlString));
        Yaml yaml = new Yaml();
        Map transformerMap = (Map) yaml.load(yamlString);
        return new Gson().toJson(transformerMap);
    }

    @Override
    public String toXML(String yamlString) {
        log.trace(String.format("Convert yaml to xml: %s", yamlString));
        Yaml yaml = new Yaml();
        Map transformerMap = (Map) yaml.load(yamlString);
        return XML.toString(transformerMap);
    }
}
