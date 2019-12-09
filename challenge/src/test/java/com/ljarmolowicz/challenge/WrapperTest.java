package com.ljarmolowicz.challenge;

import static com.ljarmolowicz.challenge.WrapperTestConstants.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;
import static com.ljarmolowicz.challenge.Wrapper.wrap;

public class WrapperTest {
    
    @Test
    public void wrapTest() {
        
        // Testing javadoc examples
        assertThat(wrap(null, 1), is(nullValue()));
        assertThat(wrap("words", 0), is("words"));
        assertThat(wrap("words", -1), is("words"));
        assertThat(wrap("words", 2), is("wo\nrd\ns"));
        assertThat(wrap("words with spaces", 10), is("words with\nspaces"));
        assertThat(wrap("words with spaces", 3), is("wor\nds\nwit\nh\nspa\nces"));
        assertThat(wrap("words with spaces", 20), is("words with spaces"));
        
        // Edge case where double spaces are present
        assertThat(
            wrap("words  including  double  spaces", 5), 
            is("words\n\ninclu\nding \ndoubl\ne \nspace\ns")
        );
        
        // Testing maxLength matching input's length
        assertThat(wrap(SAMPLE_INPUT, 309), is(SAMPLE_INPUT));
        assertThat(wrap(SAMPLE_INPUT_NO_SPACES, 110), is(SAMPLE_INPUT_NO_SPACES));
        
        // Testing more realistic parameters
        assertThat(wrap(SAMPLE_INPUT, 30), is(SAMPLE_OUTPUT_30));
        assertThat(wrap(SAMPLE_INPUT_NO_SPACES, 30), is(SAMPLE_OUTPUT_NO_SPACES_30));
        assertThat(wrap(SAMPLE_INPUT, 50), is(SAMPLE_OUTPUT_50));
        assertThat(wrap(SAMPLE_INPUT_NO_SPACES, 50), is(SAMPLE_OUTPUT_NO_SPACES_50));
    }
}
