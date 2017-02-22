/*
 * Copyright 2017 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class HttpStatusCodeTest {

    @Test
    public void getStatusCode() {
        HttpStatusCode httpStatusCode = HttpStatusCode.NOT_FOUND;

        assertEquals(404, httpStatusCode.getStatusCode());
    }

    @Test
    public void getDescription() {
        HttpStatusCode httpStatusCode = HttpStatusCode.NOT_FOUND;

        assertEquals("Not Found", httpStatusCode.getDescription());
    }

    @Test
    public void asText() {
        HttpStatusCode httpStatusCode = HttpStatusCode.NOT_FOUND;

        assertEquals("404", httpStatusCode.asText());
    }

    @Test
    public void fromStatusCode() {
        int code = 404;
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(code);

        assertEquals(404, httpStatusCode.getStatusCode());
        assertEquals("Not Found", httpStatusCode.getDescription());
        assertEquals("404", httpStatusCode.asText());
    }

    @Test(expected = IllegalArgumentException.class)
    public void fromStatusCodeIllegalArgument() {
        int code = -1;
        HttpStatusCode httpStatusCode = HttpStatusCode.valueOf(code);

        assertNull(httpStatusCode);
    }

}
