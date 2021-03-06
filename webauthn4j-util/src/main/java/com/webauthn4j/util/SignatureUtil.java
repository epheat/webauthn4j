/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webauthn4j.util;

import java.security.NoSuchAlgorithmException;
import java.security.Signature;

/**
 * A Utility class for signature calculation
 */
public class SignatureUtil {

    private static final Signature ES256 = createSignature("SHA256withECDSA");
    private static final Signature RS256 = createSignature("SHA256withRSA");

    private SignatureUtil() {
    }

    public static Signature getRS256() {
        return RS256;
    }

    public static Signature getES256() {
        return ES256;
    }

    public static Signature createSignature(String algorithm) {
        AssertUtil.notNull(algorithm, "algorithm is required; it must not be null");
        try {
            return Signature.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
