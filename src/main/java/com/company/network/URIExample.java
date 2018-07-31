package com.company.network;



import com.company.data.Member;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

// https://www.leveluplunch.com/java/examples/construct-build-uri/
public class URIExample {
    public static void main(String[] args) {
        construct_uri_jersey();
        construct_uri_encoded_jersey();
        construct_uri_template_jersey();
        construct_uri_parameter_jersey();

        try {
            contruct_uri_apache();
            contruct_uri_encoded_apache();
            contruct_uri_parameters_apache();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        construct_uri_spring();
        construct_uri_encoded_spring();
        construct_uri_template_spring();
        construct_uri_queryparmeter_spring();
    }

    public static void construct_uri_jersey () {

        UriBuilder builder = UriBuilder
                .fromPath("www.leveluplunch.com")
                .scheme("http")
                .path("java/examples/");

        URI uri = builder.build();
        System.out.println(uri); // http:/www.leveluplunch.com/java/examples/
    }

    public static void construct_uri_encoded_jersey () {

        UriBuilder builder = UriBuilder
                .fromPath("www.leveluplunch.com")
                .scheme("http")
                .path("java/examples/?sample=uri encode");

        URI uri = builder.build();
        System.out.println(uri); // http:/www.leveluplunch.com/java/examples/%3Fsample=uri%20encode
    }

    public static void construct_uri_template_jersey () {

        UriBuilder builder = UriBuilder
                .fromPath("www.leveluplunch.com")
                .path("/{lanuage}/{type}/");

        URI uri = builder.build("java", "examples");
        System.out.println(uri); // www.leveluplunch.com/java/examples/
    }

    public static void construct_uri_parameter_jersey () {

        UriBuilder builder = UriBuilder
                .fromPath("www.leveluplunch.com")
                .path("/{lanuage}/{type}/")
                .queryParam("test", "a", "b");

        URI uri = builder.build("java", "examples");
        System.out.println(uri); // www.leveluplunch.com/java/examples/?test=a&test=b
    }

    public static void contruct_uri_apache () throws URISyntaxException {

        URIBuilder builder = new URIBuilder()
                .setScheme("http")
                .setHost("www.leveluplunch.com")
                .setPath("/java/examples/");

        URI uri = builder.build();
        System.out.println(uri); // http://www.leveluplunch.com/java/examples/
    }

    public static void contruct_uri_encoded_apache () throws URISyntaxException {

        URIBuilder builder = new URIBuilder()
                .setScheme("http")
                .setHost("www.leveluplunch.com")
                .setPath("/java/examples/?sample=uri encode");

        URI uri = builder.build();
        System.out.println(uri); // http://www.leveluplunch.com/java/examples/%3Fsample=uri%20encode
    }

    public static void contruct_uri_parameters_apache () throws URISyntaxException {

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("test", "a"));
        nameValuePairs.add(new BasicNameValuePair("test", "b"));

        URIBuilder builder = new URIBuilder()
                .setScheme("http")
                .setHost("www.leveluplunch.com")
                .setParameters(nameValuePairs);

        URI uri = builder.build();
        System.out.println(uri); // http://www.leveluplunch.com?test=a&test=b
    }

    public static void construct_uri_spring () {

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .scheme("http").host("www.leveluplunch.com").path("/java/examples/")
                        .build();

        System.out.println(uriComponents.toUriString()); // http://www.leveluplunch.com/java/examples/
    }

    public static void construct_uri_encoded_spring () {

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .scheme("http").host("www.leveluplunch.com")
                        .path("/java/examples/?sample=uri encode")
                        .build()
                        .encode();

        System.out.println(uriComponents.toUriString()); // http://www.leveluplunch.com/java/examples/%3Fsample=uri%20encode
    }

    public static void construct_uri_template_spring () {

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .scheme("http")
                        .host("www.leveluplunch.com")
                        .path("/{lanuage}/{type}/")
                        .build()
                        .expand("java", "examples")
                        .encode();

        System.out.println(uriComponents.toUriString()); // http://www.leveluplunch.com/java/examples/
    }

    public static void construct_uri_queryparmeter_spring () {

        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .scheme("http")
                        .host("www.leveluplunch.com")
                        .path("/{lanuage}/{type}/")
                        .queryParam("test", "a", "b")
                        .build()
                        .expand("java", "examples")
                        .encode();

        System.out.println(uriComponents.toUriString()); // http://www.leveluplunch.com/java/examples/?test=a&test=b
    }
}


