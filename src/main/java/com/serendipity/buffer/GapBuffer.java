package com.serendipity.buffer;

/**
 * This is the main Gap Buffer class that will hold the text of the editor.
 *
 * @author Aaron
 */
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

    /**
     * Provide a visual representation of the current buffer which
     * includes the current position and length of the gap.
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < this.buffer.length; i++) {

            // Underscore will help visualize the gap inside the buffer
            if (this.start <= i && i < this.end)
                sb.append('_');
                
            // Show the character
            else
                sb.append(this.buffer[i]);
        }

        return sb.toString();
    }


    /**
     * Appends the character at the of beginning of the Gap Buffer.
     * It will automatically expand to twice the size if the buffer is
     * already full, calling the resize method.
     *
     * @param c Character to append to the buffer
     */
    public void insertChar(char c) {

        // Grow gapBuffer size if buffer there is no more buffer
        if (this.start == this.end)
            this.resize();

        this.buffer[this.start++] = c;
    }

    /**
     * Calling this method slides the gap to the cursor position within the buffer
     * to ensure correct insertion placement of characters.
     *
     * @param cursor Index position of the cursor where the gap should be moved to
     */
    public void moveGapTo(int cursor) {

        if (cursor < this.start) {
            int length = this.start - cursor;
            shiftGapToLeft(cursor, length);
        }

        else if (cursor > this.start) {
            int length = cursor - this.end;
            shiftGapToRight(cursor, length);
        }
    }

    // Design implementation of moving gap to desired direction
    private void shiftGapToLeft(int cursor, int length) {
        
        // Length indicates number of steps to take until start pointer is on cursor position.
        // Buffer slowly moves to the left.
        while (length-- > 0) {
            this.buffer[--this.end] = this.buffer[--this.start];
        }
    }

    // Design implementation of moving gap to desired direction
    private void shiftGapToRight(int cursor, int length) {

        // Length indicates number of steps to take until start pointer is on cursor position.
        // Buffer slowly moves to the right.
        while (length-- > 0) {
            this.buffer[this.start++] = this.buffer[this.end++];
        }
    }

    // Doubles the current size of the buffer and maitains gap position within the buffer
    private void resize() {
        int newSize = this.buffer.length * 2;
        char[] newBuffer = new char[newSize];

        int leftSize = this.start;
        int rightSize = this.buffer.length - this.end;

        System.arraycopy(this.buffer, 0, newBuffer, 0, leftSize);
        System.arraycopy(this.buffer, this.end, newBuffer, newSize - rightSize, rightSize);

        // Update pointers
        this.start = leftSize;
        this.end = newSize - rightSize;
        this.buffer = newBuffer;
    }

    /**
     * Removes character to the left of the cursor.
     */
    public void backspace() {
        removeInternal(true);
    }

    /**
     * Removes character to the right of the cursor.
     */
    public void delete() {
        removeInternal(false);

    }

    /**
     * Removes the character on either left or right of the cursor.
     *
     * @param left Indicates whether the left character should be removed. A false value
     * would indicate removal of the character on the right hand side of the cursor
     */
    private void removeInternal(boolean left) {
        if (left)
            // Ensure start pointer does not reach negative
            this.start = Math.max(this.start - 1, 0);

        else
            // Ensure end pointer does not exceed buffer size
            this.end = Math.min(this.end + 1, this.buffer.length);
    }

    /**
     * Returns the buffer content without the gap. This method disregards the values
     * within the gap start and end and provides only relevant text content.
     * 
     * @return sb The stringified buffer content excluding characters within the gap
     */
    public String getText() {
        StringBuilder sb = new StringBuilder();
        sb.append(buffer, 0, this.start);
        sb.append(buffer, this.end, this.buffer.length - this.end);

        return sb.toString();
    }

    /**
     * Removes all contents within the buffer by resetting pointer indices to the start and
     * end of the entire buffer. Buffer array will still hold the values but the buffer will
     * disregard those values, logically emptying the buffer in constant time.
     */
    public void clearBuffer() {
        this.start = 0;
        this. end = this.buffer.length;
    }

    /**
     * Returns how long the contents of the buffer is, regardless of the gap size.
     *
     * @return length Integer representation of the buffer content length
     */
    public int length() {
        return this.start + (this.buffer.length - this.end);
    }

    /**
     * Inserts an entire string to the buffer. This method is useful for pasting
     * text into the editor.
     *
     * @param text The input string to be inserted in the buffer
     */
    public void insertString(String text) {
        for (char c : text.toCharArray()) {
            this.insertChar(c);
        }
    }
}
