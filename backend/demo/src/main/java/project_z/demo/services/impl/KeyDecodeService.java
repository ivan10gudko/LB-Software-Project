package project_z.demo.services.impl;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KeyDecodeService {
    private PublicKey cachedKey;
    public PublicKey loadEcPublicKeyFromJwk(String jwkJson) {
        try {
            JsonNode jwk = new com.fasterxml.jackson.databind.ObjectMapper()
                    .readTree(jwkJson);

            String xStr = jwk.get("x").asText();
            String yStr = jwk.get("y").asText();

            byte[] xBytes = Base64.getUrlDecoder().decode(xStr);
            byte[] yBytes = Base64.getUrlDecoder().decode(yStr);

            BigInteger x = new BigInteger(1, xBytes);
            BigInteger y = new BigInteger(1, yBytes);

            ECPoint w = new ECPoint(x, y);

            // 1) Отримуємо параметри кривої P-256
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("EC");
            parameters.init(new ECGenParameterSpec("secp256r1"));

            ECParameterSpec ecSpec = parameters.getParameterSpec(ECParameterSpec.class);

            // 2) Створюємо ECPublicKeySpec
            ECPublicKeySpec pubSpec = new ECPublicKeySpec(w, ecSpec);

            // 3) Генеруємо PublicKey
            return KeyFactory.getInstance("EC").generatePublic(pubSpec);

        } catch (Exception e) {
            throw new RuntimeException("Failed to decode EC JWK", e);
        }
    }
      




}
