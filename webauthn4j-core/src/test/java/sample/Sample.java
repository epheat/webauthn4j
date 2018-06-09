package sample;

import com.webauthn4j.WebAuthnAuthenticationContext;
import com.webauthn4j.WebAuthnRegistrationContext;
import com.webauthn4j.authenticator.Authenticator;
import com.webauthn4j.client.Origin;
import com.webauthn4j.client.challenge.Challenge;
import com.webauthn4j.server.ServerProperty;
import com.webauthn4j.validator.WebAuthnAuthenticationContextValidator;
import com.webauthn4j.validator.WebAuthnRegistrationContextValidator;

public class Sample {

    public void registrationValidationSample() {
        // Client properties
        byte[] clientDataJSON = null /* set clientDataJSON */;
        byte[] attestationObject = null /* set attestationObject */;

        // Server properties
        Origin origin = null /* set origin */;
        String rpId = null /* set rpId */;
        Challenge challenge = null /* set challenge */;
        byte[] tokenBindingId = null /* set tokenBindingId */;
        ServerProperty serverProperty = new ServerProperty(origin, rpId, challenge, tokenBindingId);

        WebAuthnRegistrationContext registrationContext = new WebAuthnRegistrationContext(clientDataJSON, attestationObject, serverProperty, false);

        WebAuthnRegistrationContextValidator webAuthnRegistrationContextValidator =
                WebAuthnRegistrationContextValidator.createNullAttestationStatementValidator();

        webAuthnRegistrationContextValidator.validate(registrationContext);
    }

    public void authenticationValidationSample() {
        // Client properties
        byte[] credentialId = null /* set credentialId */;
        byte[] clientDataJSON = null /* set clientDataJSON */;
        byte[] authenticatorData = null /* set authenticatorData */;
        byte[] signature = null /* set signature */;

        // Server properties
        Origin origin = null /* set origin */;
        String rpId = null /* set rpId */;
        Challenge challenge = null /* set challenge */;
        byte[] tokenBindingId = null /* set tokenBindingId */;
        ServerProperty serverProperty = new ServerProperty(origin, rpId, challenge, tokenBindingId);

        WebAuthnAuthenticationContext authenticationContext =
                new WebAuthnAuthenticationContext(
                        credentialId,
                        clientDataJSON,
                        authenticatorData,
                        signature,
                        serverProperty,
                        true
                );
        Authenticator authenticator = null /* set authenticator */;

        WebAuthnAuthenticationContextValidator webAuthnAuthenticationContextValidator =
                new WebAuthnAuthenticationContextValidator();

        webAuthnAuthenticationContextValidator.validate(authenticationContext, authenticator);
    }
}