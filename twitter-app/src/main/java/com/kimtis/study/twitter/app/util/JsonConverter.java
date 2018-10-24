package com.kimtis.study.twitter.app.util;

import com.kimtis.study.twitter.app.auth.jwt.constant.Header;
import com.kimtis.study.twitter.app.auth.jwt.constant.Payload;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonConverter {

    public static String toJsonString(Object value) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.writeValueAsString(value);
    }

    public static Header jsonToHeader(String json){
        ObjectMapper mapper = new ObjectMapper();
        Header header = null;
        try {
           header = mapper.readValue(json, Header.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return header;
    };

    public static Payload jsonToPayload(String json){
        ObjectMapper mapper = new ObjectMapper();
        Payload payload = null;
        try {
            payload = mapper.readValue(json, Payload.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return payload;
    };
}
