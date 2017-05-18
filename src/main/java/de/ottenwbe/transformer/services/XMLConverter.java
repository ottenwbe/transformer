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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import de.ottenwbe.transformer.controller.JsonController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class XMLConverter implements ConverterInterface {

    private static Log log = LogFactory.getLog(JsonController.class);

    @Override
    public String toYaml(String xmlString) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            JsonNode node = xmlMapper.readTree(xmlString);

            ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
            return yamlMapper.writeValueAsString(node);

        } catch (Exception e) {
            log.error("Cannot convert xml to yaml", e);
        }
        return "";
    }

    @Override
    public String toJson(String xmlString) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            JsonNode node = xmlMapper.readTree(xmlString);

            ObjectMapper jsonMapper = new ObjectMapper();
            return jsonMapper.writeValueAsString(node);

        } catch (Exception e) {
            log.error("Cannot convert xml to json", e);
        }
        return "";
    }

    @Override
    public String toXML(String xmlString) {
        return xmlString;
    }
}
