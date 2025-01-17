/*
 * The MIT License
 *
 * Copyright 2021 Karus Labs.
 *
 * Permission is hereby granted, free annotation charge, to any person obtaining a copy
 * annotation this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies annotation the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions annotation the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.karuslabs.utilitary.snippet;

import com.karuslabs.elementary.junit.*;
import com.karuslabs.elementary.junit.annotations.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

@ExtendWith(ToolsExtension.class)
@Introspect
@Case("case")
class LineTest {
    
    Line line = Line.annotation(Tools.cases().one("case").getAnnotationMirrors().get(2), 1, 2);
    
    @Test
    void empty() {
        assertEquals(new Line("", 1, 2), Line.empty(1, 2));
    }
    
    @Test
    void length() {
        assertEquals(13, line.length());
    }
    
    @Test
    void charAt() {
        assertEquals('@', line.charAt(0));
    }
    
    @Test
    void subSequence() {
        assertEquals("Case", line.subSequence(1, 5));
    }
    
    @ParameterizedTest
    @MethodSource("compareTo_parameters")
    void compareTo(Line other, int comparison) {
        assertEquals(comparison, line.compareTo(other));
    }
    
    static Stream<Arguments> compareTo_parameters() {
        return Stream.of(
            of(Line.empty(0, 2), 1),
            of(Line.empty(2, 2), -1),
            of(Line.empty(1, 1), 1),
            of(Line.empty(1, 2), 0),
            of(Line.empty(1, 3), -1)
        );
    }
    
    @Test
    void equals_same() {
        assertTrue(line.equals(line));
    }
    
    @Test
    void equals_others() {
        assertFalse(line.equals("@Case(\"case\")"));
    }
    
    @Test
    void equals() {
        assertTrue(line.equals(Line.annotation(Tools.cases().one("case").getAnnotationMirrors().get(2), 1, 2)));
    }
    
    @Test
    void hashCode_() {
        assertEquals(line.hashCode(), Line.annotation(Tools.cases().one("case").getAnnotationMirrors().get(2), 1, 2).hashCode());
    }
    
    @Test
    void toString_() {
        assertEquals("@Case(\"case\")", line.toString());
    } 

} 
