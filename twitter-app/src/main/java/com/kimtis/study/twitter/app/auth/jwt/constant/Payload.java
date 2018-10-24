package com.kimtis.study.twitter.app.auth.jwt.constant;

import com.kimtis.study.twitter.app.auth.jwt.exception.PayloadMismatchException;
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
public class Payload {

    private String userID;
    private String jti;
    private String iss;
    private long iat;
    private long exp;


    public Payload parse(String json){
        return JsonConverter.jsonToPayload(json);
    }
    /**
     * @Param Payload
     * example - Payload.builder().userID("a).....build();
     */
    public String toJsonString(Object value) throws IOException, PayloadMismatchException {
        if(value instanceof Payload){
            return JsonConverter.toJsonString(value);
        }else{
            throw new PayloadMismatchException("MisMatch Payload.");
        }
    }
}
