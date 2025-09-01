package com.serendipity.buffer;

import java.util.Arrays;

public class GapBuffer {

    private int start;
    private int end;
    private char[] buffer;

    public GapBuffer(int size) {
        this.start = 0;
        this.end = size;
        this.buffer = new char[size];
    }

    // Initialize buffer with a default size 1024 if not provided
    public GapBuffer() {
        this(1024);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < this.buffer.length; i++) {
            if (this.start <= i && i < this.end) {
                sb.append('_');
            } else {
                sb.append(this.buffer[i]);
            }
        }

        return sb.toString();
    }

    public void insertChar(char c) {
        this.buffer[this.start++] = c;
    }

    public void moveGapTo(int cursor) {

        if (cursor < this.start) {
            int length = this.start - cursor;
            shiftGapToRight(cursor, length);
        }

        else if (cursor > this.start) {
            int length = cursor - this.end;
            shiftGapToLeft(cursor, length);
        }
    }

    /**
     *
     *
     */
    private void shiftGapToRight(int cursor, int length) {
        while (length-- > 0) {
            this.buffer[--this.end] = this.buffer[--this.start];
        }
    }

    private void shiftGapToLeft(int cursor, int length) {
        while (length-- > 0) {
            this.buffer[this.start++] = this.buffer[this.end++];
        }
    }

}
