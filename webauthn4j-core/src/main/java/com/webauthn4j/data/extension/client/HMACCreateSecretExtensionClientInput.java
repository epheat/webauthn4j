/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.data.extension.client;

import com.webauthn4j.validator.exception.ConstraintViolationException;

import java.io.Serializable;

public class HMACCreateSecretExtensionClientInput implements ExtensionClientInput {

    public static final String ID = "hmac-secret";

    private Boolean hmacCreateSecret;

    public HMACCreateSecretExtensionClientInput(Boolean hmacCreateSecret) {
        this.hmacCreateSecret = hmacCreateSecret;
    }

    @Override
    public String getIdentifier() {
        return ID;
    }

    public Boolean getHmacCreateSecret(){
        return hmacCreateSecret;
    }

    @Override
    public Serializable getValue(String key) {
        if(!key.equals("hmacCreateSecret")){
            throw new IllegalArgumentException(String.format("%s is the only valid key.", getIdentifier()));
        }
        return hmacCreateSecret;
    }

    @Override
    public void validate() {
        if(hmacCreateSecret == null){
            throw new ConstraintViolationException("hmacCreateSecret must not be null");
        }
    }
}
