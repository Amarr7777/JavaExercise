package LABexe.lab2;

public class StringFunctions {
    public static void main(String[] args) {
        String para = "We realized that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative. The alternative mentioned here is the Tata Nano, which soon after came as the world’s cheapest car on retail at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision to come up with a car like Tata Nano.";

        // String charAt()
        System.out.println("\n\n10th character: " + para.charAt(9));

        
        // String compareTo()
        String para2 = "Hi I'm Amar";
        int diff = para2.compareTo(para);
        if (diff == 0) {
            System.out.println("\n\nBoth the strings are equal");
        } else {
            System.out.println("\n\nThe Strings are different");
        }


        // String concat()
        String concatString = para.concat(para2);
        System.out.println("\n\nAfter concatenation:\n\n" + concatString);

        // String contains()
        System.out.println("\n\nContains 'thriving': " + para.contains("thriving"));

        // String endsWith()
        System.out.println("\n\nEnds with 'Nano.': " + para.endsWith("Nano."));

        // String equals()
        String para3 = "We realized that while our workers were thriving, the surrounding villages were still suffering. It became our goal to uplift their quality of life as well. I remember seeing a family of 4 on a motorbike in the heavy Bombay rain — I knew I wanted to do more for these families who were risking their lives for lack of an alternative. The alternative mentioned here is the Tata Nano, which soon after came as the world’s cheapest car on retail at a starting price of only Rs 1 lakh. These were the words of Ratan Tata in a recent post by Humans of Bombay which formed the basis of his decision to come up with a car like Tata Nano.";
        System.out.println("\n\nEquals para and para3: " + para.equals(para3));

        // equalsIgnoreCase()
        System.out.println("\n\nEqualsIgnoreCase para and para2: " + para.equalsIgnoreCase(para2));

        // String format()
        String formattedString = String.format("Formatted String: %s, %d", "Hello", 42);
        System.out.println("\n\n" + formattedString);

        // String getBytes()
        byte[] byteArray = para.getBytes();
        System.out.println("\n\nGet Bytes:\n\n");
        for (byte b : byteArray) {
            System.out.print(b + " ");
        }

        // String getChars()
        char[] charArray = new char[50];
        para.getChars(10, 60, charArray, 0);
        System.out.println("\n\nGet Chars from index 10 to 60:\n\n");
        for (char c : charArray) {
            System.out.print(c);
        }

        // String indexOf()
        int index = para.indexOf("Tata");
        System.out.println("\n\nIndex of 'Tata': " + index);

        // String intern()
        String internedString = para.intern();
        System.out.println("\n\nInterned String:\n\n" + internedString);

        // String isEmpty()
        System.out.println("\n\nIs String empty? " + para.isEmpty());

        // String join()
        String[] wordsArray = para.split(" ");
        String joinedString = String.join("-", wordsArray);
        System.out.println("\n\nJoined with '-':\n\n" + joinedString);

        // String lastIndexOf()
        int lastIndex = para.lastIndexOf("the");
        System.out.println("\n\nLast index of 'the': " + lastIndex);

        // String length()
        System.out.println("\n\nString length of paragraph is " + para.length());

        // String replace()
        String replacedString = para.replace('a', 'b');
        System.out.println("\n\nAfter replacing 'a' with 'b':\n\n" + replacedString);

        // String replaceAll()
        String replaceAll = para.replaceAll("Tata", "TATA");
        System.out.println("\n\nAfter replacing all 'Tata' with 'TATA':\n\n" + replaceAll);

        // String split()
        System.out.println("\n\nSplit using '-':");
        String[] splitArray = para.split("-");
        for (String s : splitArray) {
            System.out.println(s);
        }

        // String startsWith()
        System.out.println("\n\nStarts with 'We': " + para.startsWith("We"));
        System.out.println("Starts with 'the': " + para.startsWith("the"));

        // String substring()
        String substring = para.substring(10, 30);
        System.out.println("\n\nSubstring from index 10 to 30:\n\n" + substring);

        // String toCharArray()
        charArray = para.toCharArray();
        System.out.println("\n\nTo Char Array:\n\n");
        for (char c : charArray) {
            System.out.print(c);
        }

        // String toLowerCase()
        String lowerPara = para.toLowerCase();
        System.out.println("\n\nTo LowerCase:\n\n" + lowerPara);

        // String toUpperCase()
        String upperPara = para.toUpperCase();
        System.out.println("\n\nTo UpperCase:\n\n" + upperPara);

        // String trim()
        String trimmedPara = para.trim();
        System.out.println("\n\nTrimmed Paragraph:\n\n" + trimmedPara);

        // String valueOf()
        int value = 42;
        String valueString = String.valueOf(value);
        System.out.println("\n\nString representation of value 42:\n\n" + valueString);
    }
}
