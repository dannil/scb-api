/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.exception;

/**
 * <p>Base exception for all client exceptions.</p>
 * 
 * @since 0.0.2
 */
public class SCBClientException extends RuntimeException {

    private static final long serialVersionUID = -2428718528932238427L;

    /**
     * <p>Default constructor.</p>
     */
    public SCBClientException() {
        super();
    }

    /**
     * <p>Overloaded constructor.</p>
     * 
     * @param message
     *            the message
     */
    public SCBClientException(String message) {
        super(message);
    }

    /**
     * <p>Overloaded constructor.</p>
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public SCBClientException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * <p>Overloaded constructor.</p>
     * 
     * @param cause
     *            the cause
     */
    public SCBClientException(Throwable cause) {
        super(cause);
    }

}
