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
public class JsonConverter implements Converter {

    @Autowired
    private XML xml;

    @Override
    public String toYaml(String jsonString) throws ConversionException {
        log.trace("Convert json to yaml: {}", jsonString);
        try {
            final ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> jsonObject = mapper.readValue(jsonString, Map.class);

            final ObjectMapper yamlMapper = new YAMLMapper();
            return yamlMapper.writeValueAsString(jsonObject);
        } catch (Exception e) {
            throw new ConversionException("Could not convert json to yaml.", e);
        }
    }

    @Override
    public String toJson(String jsonString) {
        log.trace("Convert json to json: {}", jsonString);
        return jsonString;
    }

    @Override
    public String toXML(String jsonString) throws ConversionException {
        log.trace("Convert json to xml: {}", jsonString);
        try {
            final ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> jsonObject = mapper.readValue(jsonString, Map.class);

            return xml.toString(jsonObject);
        } catch (Exception e) {
            throw new ConversionException("Could not convert json to xml.", e);
        }
    }
}
