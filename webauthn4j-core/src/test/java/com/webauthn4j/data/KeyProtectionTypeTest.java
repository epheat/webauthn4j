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

package com.webauthn4j.data;

import com.webauthn4j.converter.exception.DataConversionException;
import com.webauthn4j.converter.util.JsonConverter;
import com.webauthn4j.converter.util.ObjectConverter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class KeyProtectionTypeTest {

    private final ObjectConverter objectConverter = new ObjectConverter();
    private final JsonConverter jsonConverter = objectConverter.getJsonConverter();

    @Test
    void create_test() {
        assertAll(
                () -> assertThat(KeyProtectionType.create(0x0001)).isEqualTo(KeyProtectionType.SOFTWARE),
                () -> assertThat(KeyProtectionType.create(0x0002)).isEqualTo(KeyProtectionType.HARDWARE),
                () -> assertThat(KeyProtectionType.create(0x0004)).isEqualTo(KeyProtectionType.TEE),
                () -> assertThat(KeyProtectionType.create(0x0008)).isEqualTo(KeyProtectionType.SECURE_ELEMENT),
                () -> assertThat(KeyProtectionType.create(0x0010)).isEqualTo(KeyProtectionType.REMOTE_HANDLE)
        );
    }

    @Test
    void getValue_test() {
        assertThat(KeyProtectionType.SOFTWARE.getValue()).isEqualTo(0x0001);
    }

    @Test
    void deserialize_test() {
        TestDTO dto = jsonConverter.readValue("{\"keyProtectionType\": 2}", TestDTO.class);
        assertThat(dto.keyProtectionType).isEqualTo(KeyProtectionType.HARDWARE);
    }

    @Test
    void deserialize_test_with_out_of_range_value() {
        assertThatThrownBy(
                () -> jsonConverter.readValue("{\"keyProtectionType\": \"-1\"}", TestDTO.class)
        ).isInstanceOf(DataConversionException.class);
    }

    @Test
    void deserialize_test_with_invalid_value() {
        assertThatThrownBy(
                () -> jsonConverter.readValue("{\"keyProtectionType\": \"\"}", TestDTO.class)
        ).isInstanceOf(DataConversionException.class);
    }

    @Test
    void deserialize_test_with_null() {
        TestDTO data = jsonConverter.readValue("{\"keyProtectionType\":null}", TestDTO.class);
        assertThat(data.keyProtectionType).isNull();
    }

    static class TestDTO {
        @SuppressWarnings("WeakerAccess")
        public KeyProtectionType keyProtectionType;
    }

}