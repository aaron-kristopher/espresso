package com.serendipity.buffer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GapBufferTest {

    @Test
    public void testInsertChar() {
        GapBuffer buffer = new GapBuffer(8);
        buffer.insertChar('h');
        buffer.insertChar('i');
        assertEquals("hi", buffer.getText());
    }

    @Test
    public void testBackspace() {
        GapBuffer buffer = new GapBuffer(8);
        buffer.insertChar('h');
        buffer.insertChar('e');
        buffer.insertChar('l');
        buffer.insertChar('l');
        buffer.insertChar('o');
        buffer.insertChar('w');
        buffer.backspace();
        buffer.moveGapTo(0);
        buffer.backspace();
        assertEquals("hello", buffer.getText());
    }

    @Test
    public void testDelete() {
        GapBuffer buffer = new GapBuffer(8);
        buffer.insertChar('h');
        buffer.insertChar('e');
        buffer.insertChar('l');
        buffer.insertChar('l');
        buffer.insertChar('o');
        buffer.insertChar('w');
        buffer.moveGapTo(5);
        buffer.delete();
        buffer.moveGapTo(8);
        buffer.delete();
        assertEquals("hello", buffer.getText());
    }
}
