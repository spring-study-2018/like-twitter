package com.kimtis.study.twitter.app.auth.jwt;

import com.kimtis.study.twitter.app.auth.jwt.constant.Header;
import com.kimtis.study.twitter.app.auth.jwt.constant.Payload;
import com.kimtis.study.twitter.app.auth.jwt.exception.PayloadMismatchException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Token {

    Header header;
    Payload payload;

    private final String secretKey = "secret";
    private final String seperator = ".";
    private final String keyInstance = "EC";
    private final String signInstance = "SHA256withECDSA";

    public String encode() throws IOException, PayloadMismatchException {
        String base64Header = new String(Base64.getEncoder().encode(header.toJsonString().getBytes(StandardCharsets.UTF_8)));
        String base64Payload = new String(Base64.getEncoder().encode(payload.toJsonString(payload).getBytes(StandardCharsets.UTF_8)));

        String signingData = base64Header + seperator + base64Payload;

        StringBuffer tokenBuffer = new StringBuffer();
        tokenBuffer.append(signingData).append(seperator).append(signedWith(signingData));

        return tokenBuffer.toString();
    }


    public Token decode(String token){

        String[] decodeArr = token.split(seperator);

        String json_Header = new String(Base64.getDecoder().decode(decodeArr[0]),StandardCharsets.UTF_8);
        String json_Payload = new String(Base64.getDecoder().decode(decodeArr[1]),StandardCharsets.UTF_8);

        header = new Header();
        header.parse(json_Header);

        payload = new Payload();
        payload.parse(json_Payload);

        return this;
    }

    private String signedWith(String signingData){
        KeyFactory kf = null;
        PrivateKey key = null;
        Signature sha256withECDSA = null;
        byte[] signed = null;

        try{
            kf = KeyFactory.getInstance(keyInstance);
            KeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(secretKey));

            key = kf.generatePrivate(keySpec);
            sha256withECDSA = Signature.getInstance(signInstance);
            sha256withECDSA.initSign(key);
            sha256withECDSA.update(signingData.getBytes(StandardCharsets.UTF_8));

            signed = sha256withECDSA.sign();

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch (SignatureException e) {
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return new String(Base64.getEncoder().encode(signed),StandardCharsets.UTF_8);
    }

}
