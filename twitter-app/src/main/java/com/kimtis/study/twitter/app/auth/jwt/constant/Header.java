package com.kimtis.study.twitter.app.auth.jwt.constant;

import com.kimtis.study.twitter.app.auth.jwt.exception.HeaderMismatchException;
import com.kimtis.study.twitter.app.util.JsonConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Header {

    private String alg = "ES256";
    private String typ = "JWT";

    public Header parse(String json){
        return JsonConverter.jsonToHeader(json);
    }


    public String toJsonString() throws IOException {
        return JsonConverter.toJsonString(Header.builder().build());
    }

    /**
     * @Param Header
     * example - Header.builder().userID("a).....build();
     */
    private String toJsonString(Object value) throws IOException, HeaderMismatchException {
        if(value instanceof Payload){
            return JsonConverter.toJsonString(value);
        }else{
            throw new HeaderMismatchException("Mis Match Header.");
        }
    }
}
