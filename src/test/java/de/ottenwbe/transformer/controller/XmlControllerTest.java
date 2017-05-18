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

package de.ottenwbe.transformer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XmlControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testToJson() {

        String expectedJson = "{\"a\":{\"b\":\"1\"}}";
        String testXml = "<root><a><b>1</b></a></root>";

        HttpEntity<String> request = new HttpEntity<>(testXml);

        ResponseEntity<String> response = this.restTemplate.postForEntity("/xml/to-json", request, String.class);

        assertThat(response.getBody()).isEqualTo(expectedJson);
    }

    @Test
    public void testToYaml() {

        String expectedYaml = "---\na:\n  b: \"1\"\n";
        String testXml = "<root><a><b>1</b></a></root>";

        HttpEntity<String> request = new HttpEntity<>(testXml);

        ResponseEntity<String> response = this.restTemplate.postForEntity("/xml/to-yaml", request, String.class);

        assertThat(response.getBody()).isEqualTo(expectedYaml);
    }

}