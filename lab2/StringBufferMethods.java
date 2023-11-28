public class StringBufferMethods {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("Hello, ");

        // 1. append()
        stringBuffer.append("World!");
        System.out.println("\nAfter append(): " + stringBuffer);

        // 2. insert()
        stringBuffer.insert(7, "Java ");
        System.out.println("After insert(): " + stringBuffer);

        // 3. replace()
        stringBuffer.replace(0, 5, "Hola");
        System.out.println("After replace(): " + stringBuffer);

        // 4. delete()
        stringBuffer.delete(5, 10);
        System.out.println("After delete(): " + stringBuffer);

        // 5. charAt()
        char charAtIndex = stringBuffer.charAt(2);
        System.out.println("Character at index 2: " + charAtIndex);

        // 6. setCharAt()
        stringBuffer.setCharAt(0, 'H');
        System.out.println("After setCharAt(): " + stringBuffer);

        // 7. length()
        int length = stringBuffer.length();
        System.out.println("Length of the StringBuffer: " + length);

        // 8. capacity()
        int capacity = stringBuffer.capacity();
        System.out.println("Capacity of the StringBuffer: " + capacity);

        // 9. ensureCapacity()
        stringBuffer.ensureCapacity(30);
        System.out.println("After ensureCapacity(): " + stringBuffer);

        // 10. toString()
        String stringRepresentation = stringBuffer.toString();
        System.out.println("String representation: " + stringRepresentation);

        // 11. substring()
        String substringFromIndex = stringBuffer.substring(6);
        System.out.println("Substring from index 6: " + substringFromIndex);

        // 12. substring()
        String substringInRange = stringBuffer.substring(0, 4);
        System.out.println("Substring from index 0 to 4: \n" + substringInRange);
    }
}
