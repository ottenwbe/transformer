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

package de.ottenwbe.transformer.services;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import org.springframework.stereotype.Service;

import de.ottenwbe.transformer.data.ConversionException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class XMLConverter implements Converter {

    @Override
    public String toYaml(String xmlString) throws ConversionException {
        log.trace("Convert xml to yaml: {}", xmlString);
        try {
            final XmlMapper xmlMapper = new XmlMapper();
            Map<?, ?> transformerMap = xmlMapper.readValue(xmlString, Map.class);

            final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
            return yamlMapper.writeValueAsString(transformerMap);
        } catch (Exception e) {
            throw new ConversionException("Cannot convert xml to yaml", e);
        }
    }

    @Override
    public String toJson(String xmlString) throws ConversionException {
        log.trace("Convert xml to json: {}", xmlString);
        try {
            final XmlMapper xmlMapper = new XmlMapper();
            Map<?, ?> transformerMap = xmlMapper.readValue(xmlString, Map.class);

            final ObjectMapper jsonMapper = new ObjectMapper();
            return jsonMapper.writeValueAsString(transformerMap);
        } catch (Exception e) {
            throw new ConversionException("Cannot convert xml to json", e);
        }
    }

    @Override
    public String toXML(String xmlString) {
        log.trace("Convert xml to xml: {}", xmlString);
        return xmlString;
    }
}
