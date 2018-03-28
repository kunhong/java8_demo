package com.jsonPath;

import com.jayway.jsonpath.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.jayway.jsonpath.JsonPath.parse;
import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;
import static com.jayway.jsonpath.JsonPath.using;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JsonPathExample {

    public static void main(String[] args) {
        JsonFile jsonFile = new JsonFile("store.json");
        String json = jsonFile.getFileWithUtil();

        Object document = Configuration.defaultConfiguration().jsonProvider().parse(json);

        List<String> authors = JsonPath.read(document, "$.store.book[*].author");
        authors.stream()
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        ReadContext ctx = JsonPath.parse(json);
        List<String> authorsOfBooksWithISBN = ctx.read("$.store.book[?(@.isbn)].author");
        authorsOfBooksWithISBN.stream()
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        List<Map<String, Object>> expensiveBooks = JsonPath
                .using(Configuration.defaultConfiguration())
                .parse(json)
                .read("$.store.book[?(@.price > 10)]", List.class);
        expensiveBooks.stream()
                .forEach(System.out::println);

        System.out.println("----------------------------------");

        String date_json = "{\"date_as_long\" : 1411455611975}";
        Date date = JsonPath.parse(date_json).read("$['date_as_long']", Date.class);
        System.out.println("date = [" + date + "]");

        System.out.println("----------------------------------");

        Book book = JsonPath.parse(json).read("$.store.book[2]", Book.class);
        System.out.println("book = [" + book + "]");

        System.out.println("Inline Predicates ----------------------------------");
        List<Map<String, Object>> books = JsonPath.parse(json)
                .read("$.store.book[?(@.price < 10)]");
        books.stream()
                .forEach(System.out::println);
        /*
        * {category=reference, author=Nigel Rees, title=Sayings of the Century, price=8.95}
            {category=fiction, author=Herman Melville, title=Moby Dick, isbn=0-553-21311-3, price=8.99}
        */

        System.out.println("----------------------------------");

        books = JsonPath.parse(json)
                .read("$.store.book[?(@.price < 10 && @.category == 'fiction')]");
        books.stream()
                .forEach(System.out::println); // {category=fiction, author=Herman Melville, title=Moby Dick, isbn=0-553-21311-3, price=8.99}

        System.out.println("Filter Predicates ----------------------------------");
        Filter cheapFictionFilter = filter(
                where("category").is("fiction").and("price").lte(10D)
        );

        Filter fooOrBar = filter(
                where("foo").exists(true)).or(where("bar").exists(true)
        );

        Filter fooAndBar = filter(
                where("foo").exists(true)).and(where("bar").exists(true)
        );

        // Notice the placeholder ? for the filter in the path
        // When multiple filters are provided they are applied in order where the number of placeholders must match the number of provided filters.
        // You can specify multiple predicate placeholders in one filter operation [?, ?], both predicates must matc
        books = parse(json).read("$.store.book[?]", cheapFictionFilter);
        books.stream()
                .forEach(System.out::println); // {category=fiction, author=Herman Melville, title=Moby Dick, isbn=0-553-21311-3, price=8.99}

        System.out.println("Roll Your Own ----------------------------------");
        // Third option is to implement your own predicates
        Predicate booksWithISBN = new Predicate() {
            @Override
            public boolean apply(PredicateContext predicateContext) {
                return predicateContext.item(Map.class).containsKey("isbn");
            }
        };

        List<String> isbnList = JsonPath.parse(json)
                .read("$.store.book[?].isbn", List.class, booksWithISBN);
        isbnList.stream()
                .forEach(System.out::println);

        System.out.println("Path vs Value----------------------------------");
        // Value is the default
        Configuration conf = Configuration.builder()
                .options(Option.AS_PATH_LIST).build();

        List<String> pathList = using(conf).parse(json).read("$..author");
        assertThat(pathList, contains(
                "$['store']['book'][0]['author']",
                "$['store']['book'][1]['author']",
                "$['store']['book'][2]['author']",
                "$['store']['book'][3]['author']"));



    }
}
