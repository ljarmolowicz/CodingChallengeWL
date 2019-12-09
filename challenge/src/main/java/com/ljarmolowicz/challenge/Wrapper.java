package com.ljarmolowicz.challenge;


public class Wrapper {
    
    private static final char NEWLINE = '\n';
    private static final char SPACE = ' ';
    
    /**
     * Wraps the input String by inserting a newline character {@code '\n'} such 
     * that each line does not exceed the maxLength specified.
     * <br>
     * To maintain word structure, the {@code '\n'} is inserted to replace the 
     * last occurrence of a space character {@code ' '} encountered on each line 
     * before the maxLength is exceeded
     * <br>
     * If no {@code ' '} is found before maxLength, then the {@code '\n'} is 
     * inserted and the line is split mid-word
     * <p>
     * If input is {@code null} or the {@code maxLength <= 0} then original 
     * input is returned
     * <p>
     * 
     * Examples:
     * <blockquote><pre>
     * wrap(null, 1) returns null
     * wrap("words", 0) returns "words"
     * wrap("words", -1) returns "words"
     * wrap("words", 2) returns "wo\nrd\ns"
     * wrap("words with spaces", 10) returns "words with\nspaces"
     * wrap("words with spaces", 3) returns "wor\nds\nwit\nh\nspa\nces"
     * wrap("words with spaces", 20) returns "words with spaces"
     * </pre></blockquote>
     * 
     * @param   input       The {@code String} to be wrapped
     * @param   maxLength   The max line length allowed before wrapping occurs
     * @return  a string that is wrapped with line lengths not in excess of the
     *          maxLength specified
     */
    public static String wrap(String input, int maxLength) {
        // invalid input, length, or input's length already within max
        if (input == null || maxLength <= 0 || input.length() <= maxLength) {
            return input;
        }
        
        final StringBuilder resultBuilder = new StringBuilder();
        // by tracking the index after where a '\n' is inserted, 
        // we can call substring only once per loop
        int indexAfterLastNewline = 0;
        
        while(indexAfterLastNewline + maxLength < input.length()) {
            
            int indexOfSpace = input.lastIndexOf(SPACE, indexAfterLastNewline + maxLength);
            int newLineIndex, spaceOffset;
            
            // space found between the last '\n' inserted and the max line length
            if (indexOfSpace > -1 && indexOfSpace >= indexAfterLastNewline) {
                newLineIndex = indexOfSpace;
                // needed to replace the space character with newline
                spaceOffset = 1; 
            } else {
                newLineIndex = indexAfterLastNewline + maxLength;
                // inserting newline so no offset
                spaceOffset = 0;
            }
            
            resultBuilder
                .append(input.substring(indexAfterLastNewline, newLineIndex))
                .append(NEWLINE);
            
            indexAfterLastNewline = newLineIndex + spaceOffset;
        }
        // be sure to append the last bit of text
        resultBuilder.append(input.substring(indexAfterLastNewline));
        return resultBuilder.toString();
    }
}
