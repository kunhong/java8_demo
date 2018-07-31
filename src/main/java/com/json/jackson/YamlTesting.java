package com.json.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.File;

// https://dzone.com/articles/read-yaml-in-java-with-jackson
// https://www.programcreek.com/java-api-examples/?api=com.fasterxml.jackson.dataformat.yaml.YAMLFactory
// https://github.com/projectodd/yaml-schema
public class YamlTesting {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            User user = mapper.readValue(new File("src/main/resources/user.yaml"), User.class);
            // ReflectionToStringBuilder is just a util class to print a Java Object to a String
            System.out.println(ReflectionToStringBuilder.toString(user,ToStringStyle.MULTI_LINE_STYLE));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

//com.json.jackson.User@7d0587f1[
//        name=Test User
//        age=30
//        address={line1=My Address Line 1, line2=Address line 2, city=Washington D.C., zip=20000}
//        roles={User,Editor}
//        ]