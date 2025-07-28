
    public class MyStringDrive {
    public static void main(String[] args) {

    
        MyString empty = new MyString();
        MyString fromString = new MyString("Java");
        MyString fromBuffer = new MyString(new StringBuffer("Buffer"));
        MyString fromBuilder = new MyString(new StringBuilder("Builder"));
        MyString fromCharArray = new MyString(new char[]{'H', 'e', 'l', 'l', 'o'});
        MyString fromCharRange = new MyString(new char[]{'a','b','c','d','e','f','g','h','i'}, 2, 4); // cdef

        
        System.out.println("Length: " + fromString.length()); // 4
        System.out.println("Is Empty: " + empty.isEmpty()); // true


        System.out.println("charAt(1): " + fromString.charAt(1)); // 'a'
        System.out.println("codePointAt(1): " + fromString.codePointAt(1)); // ASCII of 'a'
        System.out.println("codePointBefore(2): " + fromString.codePointBefore(2)); // ASCII of 'a'

        
        System.out.println("codePointCount(1, 3): " + fromString.codePointCount(1, 3)); // 2

        
        System.out.println("To Upper Case: " + fromString.toUpperCase());
        System.out.println("To Lower Case: " + fromString.toLowerCase());

        
        MyString sample = new MyString("programming");
        System.out.println("indexOf('g'): " + sample.indexOf('g'));
        System.out.println("indexOf('g', 5): " + sample.indexOf('g', 5));
        System.out.println("lastIndexOf('g'): " + sample.lastIndexOf('g'));

        
        MyString part1 = new MyString("Java ");
        MyString part2 = new MyString("Programming");
        System.out.println("Concatenated: " + part1.concat(part2)); // Java Programming


        MyString text = new MyString("Java is fun");
        System.out.println("Starts with 'Java': " + text.startsWith(new MyString("Java")));
        System.out.println("Starts with 'is' at index 5: " + text.startsWith(new MyString("is"), 5));
        System.out.println("Ends with 'fun': " + text.endsWith(new MyString("fun")));

       
        System.out.println("Contains 'is': " + text.contains(new MyString("is")));
        System.out.println("Contains 'hard': " + text.contains(new MyString("hard")));

        
        MyString str1 = new MyString("hello");
        MyString str2 = new MyString("HELLO");
        System.out.println("Equals: " + str1.equals(str2)); // false
        System.out.println("Equals Ignore Case: " + str1.equalsIgnoreCase(str2)); // true

        
        System.out.println("Content Equals StringBuffer: " + str1.contentEquals(new StringBuffer("hello")));

       
        MyString replaced = new MyString("banana").replace('a', '*');
        System.out.println("Replaced: " + replaced); // b*n*n*

       
        MyString longStr = new MyString("substringmethod");
        System.out.println("Substring from index 3: " + longStr.substring(3));
        System.out.println("Substring from index 3 to 8: " + longStr.substring(3, 8));

        MyString padded = new MyString("   trim this   ");
        System.out.println("Trimmed: '" + padded.trim() + "'");

        
        System.out.println("ToString Output: " + fromCharRange); // should print 'cdef'
    }
}


