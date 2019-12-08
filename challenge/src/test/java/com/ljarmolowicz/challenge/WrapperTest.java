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
        
        // Testing illogical inputs
        assertThat(wrap(null, 10), is(nullValue()));
        assertThat(wrap(SAMPLE_INPUT, -30), is(SAMPLE_INPUT));
        
        // Testing maxLength matching/exceeding input's length
        assertThat(wrap(SAMPLE_INPUT, 400), is(SAMPLE_INPUT));
        assertThat(wrap(SAMPLE_INPUT, 309), is(SAMPLE_INPUT));
        assertThat(wrap(SAMPLE_INPUT_NO_SPACES, 200), is(SAMPLE_INPUT_NO_SPACES));
        assertThat(wrap(SAMPLE_INPUT_NO_SPACES, 110), is(SAMPLE_INPUT_NO_SPACES));
        
        assertThat(wrap(SAMPLE_INPUT, 30), is(SAMPLE_OUTPUT_30));
        assertThat(wrap(SAMPLE_INPUT_NO_SPACES, 30), is(SAMPLE_OUTPUT_NO_SPACES_30));
        assertThat(wrap(SAMPLE_INPUT, 50), is(SAMPLE_OUTPUT_50));
        assertThat(wrap(SAMPLE_INPUT_NO_SPACES, 50), is(SAMPLE_OUTPUT_NO_SPACES_50));
    }
}
