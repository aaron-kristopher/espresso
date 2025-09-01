package com.serendipity;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.*;

import java.io.*;

import com.serendipity.buffer.GapBuffer;

public class App {


    public static void main(String[] args) {
        GapBuffer gb = new GapBuffer(25);
        gb.insertChar('H');
        gb.insertChar('e');
        gb.insertChar('l');
        gb.insertChar('l');
        gb.insertChar('o');
        gb.insertChar(' ');
        gb.insertChar('W');
        gb.insertChar('o');
        gb.insertChar('r');
        gb.insertChar('l');
        gb.insertChar('d');
        gb.insertChar('!');
        gb.moveGapTo(6);
        gb.insertChar('m');
        gb.insertChar('y');
        gb.insertChar(' ');
        gb.moveGapTo(25);
        gb.insertChar('?');
        gb.insertChar('!');
        gb.insertChar('?');
        gb.insertChar(' ');
        gb.insertChar('H');
        gb.insertChar('e');
        gb.insertChar('l');
        gb.insertChar('l');
        gb.insertChar('o');
        gb.insertChar(' ');
        gb.insertChar(' ');
        gb.insertChar('H');
        gb.insertChar('e');
        gb.insertChar('l');
        gb.insertChar('l');
        gb.insertChar('o');
        gb.insertChar(' ');
        gb.moveGapTo(14);
        System.out.println(gb);
    }

    // public static void main(String[] args) {
    //     Terminal terminal = null;
    //
    //     try {
    //         terminal = new DefaultTerminalFactory().createTerminal();
    //         final TextGraphics textGraphics = terminal.newTextGraphics();
    //
    //         // Open a new buffer just like in vim
    //         terminal.enterPrivateMode();
    //         int cursorX = 0;
    //         int cursorY = 0;
    //
    //         KeyStroke keyStroke = terminal.readInput();
    //         StringBuffer content = new StringBuffer();
    //
    //         while (keyStroke.getKeyType() != KeyType.Escape) {
    //
    //             switch (keyStroke.getKeyType()) {
    //                 case ArrowUp:
    //                     cursorY = Math.max(cursorY - 1, 0);
    //                     break;
    //                 case ArrowDown:
    //                     cursorY++;
    //                     break;
    //                 case ArrowLeft:
    //                     cursorX = Math.max(cursorX - 1, 0);
    //                     break;
    //                 case ArrowRight:
    //                     cursorX++;
    //                     break;
    //                 default:
    //                     content.append(keyStroke.getCharacter());
    //                     break;
    //             }
    //
    //             terminal.setCursorPosition(cursorX, cursorY);
    //             textGraphics.putString(0, 0, content.toString());
    //
    //             terminal.flush();
    //             keyStroke = terminal.readInput();
    //         }
    //
    //     } catch (Exception e){
    //         System.err.println("Unexpected error occured: " + e.getMessage());
    //     } finally {
    //         if (terminal != null) {
    //             try {
    //                 terminal.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    // }
}
