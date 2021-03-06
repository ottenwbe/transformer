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

package de.ottenwbe.transformer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestClientException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class XmlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testToJson() throws RestClientException, Exception {

        final String expectedJson = "{\"a\":{\"b\":\"1\"}}";
        final String testXml = "<root><a><b>1</b></a></root>";

        mockMvc.perform(post("/xml/to-json").contentType(MediaType.APPLICATION_XML).content(testXml))
                .andExpect(status().isOk()).andExpect(content().string(expectedJson));
    }

    @Test
    public void testToYaml() throws Exception {

        final String expectedYaml = "---\na:\n  b: \"1\"\n";
        final String testXml = "<root><a><b>1</b></a></root>";

        mockMvc.perform(post("/xml/to-yaml").contentType(MediaType.APPLICATION_XML).content(testXml))
                .andExpect(status().isOk()).andExpect(content().string(expectedYaml));
    }

    @Test
    public void testToXML() throws Exception {

        final String testXml = "<root><a><b>1</b></a></root>";

        mockMvc.perform(post("/xml/to-xml").contentType(MediaType.APPLICATION_XML).content(testXml))
                .andExpect(status().isOk()).andExpect(content().string(testXml));
    }

    @Test
    public void noConversionOfFaultyXmlToYaml() throws Exception {

        final String testXml = "asdf";

        mockMvc.perform(post("/xml/to-yaml").content(testXml)).andExpect(status().isBadRequest());
    }

    @Test
    public void noConversionOfFaultyXmlToJson() throws Exception {

        final String testXml = "asdf";

        mockMvc.perform(post("/xml/to-json").content(testXml)).andExpect(status().isBadRequest());
    }
}