/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ljarmolowicz.challenge;

/**
 *
 * @author ljarm
 */
public class WrapperTestConstants {
    // SAMPLE_INPUT is 309 characters long.
    protected static final String SAMPLE_INPUT = 
        "This is a paragraph of text for testing the functionality of the wrap " + 
        "function found within the Wrapper class. We can use this as the input " + 
        "and test using various maxLength values to determine correct functionality. " + 
        "The output of the function should then be compared with the various " + 
        "output constants present.";
    
    protected static final String SAMPLE_OUTPUT_30 = 
        "This is a paragraph of text\n" + 
        "for testing the functionality\n" + 
        "of the wrap function found\n" + 
        "within the Wrapper class. We\n" + 
        "can use this as the input and\n" + 
        "test using various maxLength\n" + 
        "values to determine correct\n" + 
        "functionality. The output of\n" + 
        "the function should then be\n" + 
        "compared with the various\n" + 
        "output constants present.";
    
    protected static final String SAMPLE_OUTPUT_50 = 
        "This is a paragraph of text for testing the\n" + 
        "functionality of the wrap function found within\n" + 
        "the Wrapper class. We can use this as the input\n" + 
        "and test using various maxLength values to\n" + 
        "determine correct functionality. The output of the\n" + 
        "function should then be compared with the various\n" + 
        "output constants present.";
    
    // SAMPLE_INPUT_NO_SPACES is 110 characters long.
    protected static final String SAMPLE_INPUT_NO_SPACES = 
        "Thisisaparagraphoftextfortestingthefunctionalityofthewrap" + 
        "functionfoundwithintheWrapperclassusinganospaceinput.";
    
    protected static final String SAMPLE_OUTPUT_NO_SPACES_30 = 
        "Thisisaparagraphoftextfortesti\n" + 
        "ngthefunctionalityofthewrapfun\n" + 
        "ctionfoundwithintheWrapperclas\n" + 
        "susinganospaceinput.";
    
    protected static final String SAMPLE_OUTPUT_NO_SPACES_50 = 
        "Thisisaparagraphoftextfortestingthefunctionalityof\n" + 
        "thewrapfunctionfoundwithintheWrapperclassusinganos\n" + 
        "paceinput.";
}
