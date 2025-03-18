package com.modernjava.textblocks;

public class TextBlocks {



    public static String multiLineString() {

        var multiLine = "This is a\n" +
                "    multiline string\n" +
                "with newlines inside";

        return  multiLine;
    }
    public static String multiLineStringV2() {
        //green vertical line is the starting point of the line.

        return """
                    This is a
                    multiline string
                    with newlines inside
                """;
    }

    public static  String multiLineStringWithFormat(String name) {
        return  """
                    Hello, %s!
                    This is a
                        multiline string
                    with newlines inside \
                 """.formatted(name);
    }

    public static String json() {

        return """
                {
                	"order_id": 123456,
                	"status": "DELIVERED",
                	"final_charge": 999.99,
                	"order_line_items": [{
                		"item_name": "iphone 14",
                		"quantity": 1
                	}]
                }
                """
                ;
    }

    public static String sql() {

        return """
                SELECT * FROM employee
                WHERE first_name = 'Dilip'
                AND last_name = 'Sundarraj'
                """;
    }


    public static void main(String[] args) {

        System.out.println("multiLineString = " + multiLineString());
        System.out.println("multiLineStringV2 = \n" + multiLineStringV2());
        System.out.println("multiLineStringV2 Strip Indent = \n" + multiLineStringV2());
        System.out.println("multiLineStringV2With Format = " + multiLineStringWithFormat("Dilip"));
        var home = "Dilip\"s Home '";
        System.out.println("home = " + home);

        var newHome = """
                Dilip"s Home '
                """;
        System.out.println("newHome = " + newHome);

        var sql = sql();
        System.out.println("sql = " + sql);

        System.out.println("json = " + json());
    }
}
