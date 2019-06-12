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
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.ottenwbe.transformer.data.ConversionException;
import de.ottenwbe.transformer.data.XML;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class YamlConverter implements Converter {

    @Autowired
    XML xml;

    @Override
    public String toYaml(String yamlString) {
        log.trace("Convert yaml to yaml: {}", yamlString);
        return yamlString;
    }

    @Override
    public String toJson(String yamlString) throws ConversionException {
        try {
            log.trace("Convert yaml to json: {}", yamlString);
            final YAMLMapper yamlMapper = new YAMLMapper();
            Map<?, ?> transformerMap = yamlMapper.readValue(yamlString, Map.class);

            final ObjectMapper jsonMapper = new ObjectMapper();
            return jsonMapper.writeValueAsString(transformerMap);
        } catch (Exception e) {
            throw new ConversionException("Cannot convert yaml to json", e);
        }
    }

    @Override
    public String toXML(String yamlString) throws ConversionException {
        log.trace("Convert yaml to xml: {}", yamlString);
        try {
            final YAMLMapper yamlMapper = new YAMLMapper();
            Map<?, ?> transformerMap = yamlMapper.readValue(yamlString, Map.class);

            return xml.toString(transformerMap);
        } catch (Exception e) {
            throw new ConversionException("Cannot convert yaml to xml", e);
        }
    }
}
