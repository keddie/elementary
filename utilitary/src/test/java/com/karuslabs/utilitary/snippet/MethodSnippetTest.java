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

import javax.lang.model.element.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ToolsExtension.class)
@Introspect
class MethodSnippetTest {
    
    ExecutableElement method = (ExecutableElement) Tools.cases().one("test");
    MethodSnippet snippet = MethodSnippet.of(method, 0);
    
    @Case("test")
    <T> void test(Line line, T a) throws NullPointerException {}
    
    @Test
    void toString_() {
        assertEquals("@Case(\"test\")\n<T> void test(Line line, T a) throws NullPointerException", snippet.toString());
    }
    
    @Test
    void values() {
        assertEquals("@Case(\"test\")", snippet.annotations.toString());
        assertEquals("<T>", snippet.typeParameters.toString());
        assertEquals("void", snippet.type.toString());
        assertEquals("test", snippet.name.toString());
        assertEquals("(Line line, T a)", snippet.parameters.toString());
        assertEquals(" throws NullPointerException", snippet.exceptions.toString());
    }

} 
