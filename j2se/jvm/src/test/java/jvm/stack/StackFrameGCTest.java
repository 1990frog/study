package jvm.stack;

import org.testng.annotations.Test;

public class StackFrameGCTest {
    @Test
    void testTest1() {
        StackFrameGC stackFrameGC = new StackFrameGC();
        stackFrameGC.test1();
    }
}
