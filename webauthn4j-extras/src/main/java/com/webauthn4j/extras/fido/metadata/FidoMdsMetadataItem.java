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

package com.webauthn4j.extras.fido.metadata;

import com.webauthn4j.extras.fido.metadata.toc.StatusReport;
import com.webauthn4j.response.attestation.authenticator.AAGUID;

import java.time.LocalDate;
import java.util.List;

public interface FidoMdsMetadataItem extends MetadataItem {

    String getAaid();

    AAGUID getAaguid();

    List<String> getAttestationCertificateKeyIdentifiers();

    String getHash();

    List<StatusReport> getStatusReports();

    LocalDate getTimeOfLastStatusChange();

}