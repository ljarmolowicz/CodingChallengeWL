package com.ljarmolowicz.challenge;


public class Wrapper {
    
    private static final char NEWLINE = '\n';
    private static final char SPACE = ' ';
    
    /**
     * Wraps the input String by inserting a newline character {@code '\n'} such 
     * that each line does not exceed the maxLength specified.
     * <br>
     * To maintain word structure, the {@code '\n'} is inserted to replace the 
     * last occurrence of a space character {@code ' '} encountered before the 
     * maxLength is exceeded
     * <br>
     * If no {@code ' '} is found before maxLength, then the {@code '\n'} is 
     * inserted and the line is split word
     * <p>
     * If input is {@code null} or the {@code maxLength <= 0} then input is 
     * returned
     * <p>
     * 
     * Examples:
     * <blockquote><pre>
     * wrap(null, 1) returns null
     * wrap("words", 0) returns "words"
     * wrap("words", -1) returns "words"
     * wrap("words", 2) returns "wo\nrd\ns"
     * wrap("words with spaces", 10) returns "words with\nspaces"
     * wrap("words with spaces", 5) returns "words\nwith\nspace\ns"
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
        if (input == null || maxLength < 0 || input.length() <= maxLength) {
            return input;
        }
        
        final StringBuilder resultBuilder = new StringBuilder();
        // by tracking the last index where a '\n' is inserted, 
        // we can call substring only once per loop
        int lastNewLineIndex = 0;
        
        while(lastNewLineIndex + maxLength < input.length()) {
            
            int indexOfSpace = input.lastIndexOf(SPACE, lastNewLineIndex + maxLength);
            int newLineIndex, spaceOffset;
            
            // space found within max length
            if (indexOfSpace > -1) {
                newLineIndex = indexOfSpace;
                // needed to replace the space character with newline
                spaceOffset = 1; 
            }
            else {
                newLineIndex = lastNewLineIndex + maxLength;
                // inserting newline so no offset
                spaceOffset = 0;
            }
            
            resultBuilder
                .append(input.substring(lastNewLineIndex, newLineIndex))
                .append(NEWLINE);
            
            lastNewLineIndex = newLineIndex + spaceOffset;
        }
        // be sure to append the last bit of text
        resultBuilder.append(input.substring(lastNewLineIndex));
        return resultBuilder.toString();
    }
}
