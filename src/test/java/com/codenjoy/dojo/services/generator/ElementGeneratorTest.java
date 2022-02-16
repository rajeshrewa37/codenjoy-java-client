package com.codenjoy.dojo.services.generator;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2012 - 2022 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.codenjoy.dojo.utils.SmokeUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.Arrays;

public class ElementGeneratorTest {

    @Rule
    public TestName test = new TestName();

    private String base = ".."; // чтобы указывало на CodingDojo/clients/

    @Test
    public void shouldGenerate_testGame_goLanguage() {
        assertEquals(new ElementGenerator("test", "go", base).generate());
    }

    @Test
    public void shouldGenerate_testGame_cppLanguage() {
        assertEquals(new ElementGenerator("test", "cpp", base).generate());
    }

    @Test
    public void shouldGenerate_testGame_jsLanguage() {
        assertEquals(new ElementGenerator("test", "js", base).generate());
    }

    @Test
    public void shouldGenerate_testGame_phpLanguage() {
        assertEquals(new ElementGenerator("test", "php", base).generate());
    }

    @Test
    public void shouldGenerate_testGame_javaLanguage() {
        assertEquals(new ElementGenerator("test", "java", base).generate());
    }

    @Test
    public void shouldGenerate_testGame_pythonLanguage() {
        assertEquals(new ElementGenerator("test", "python", base).generate());
    }

    @Test
    public void shouldGenerate_testGame_markdownLanguage() {
        assertEquals(new ElementGenerator("test", "md", base).generate());
    }

    @Test
    public void shouldGenerate_testAnotherGame_markdownLanguage() {
        assertEquals(new ElementGenerator("test-another", "md", base).generate());
    }

    @Test
    public void shouldGenerate_testGame_markdownHeaderLanguage() {
        assertEquals(new ElementGenerator("test", "md_header", base).generate());
    }

    @Test
    public void shouldGenerate_testGame_markdownFooterLanguage() {
        assertEquals(new ElementGenerator("test", "md_footer", base).generate());
    }

    @Test
    public void shouldGenerate_testGame_csharpLanguage() {
        assertEquals(new ElementGenerator("test", "csharp", base).generate());
    }

    @Test
    public void shouldGenerate_sampleGame_goLanguage() {
        assertEquals(new ElementGenerator("sample", "go", base).generate());
    }

    @Test
    public void shouldGenerate_sampleGame_cppLanguage() {
        assertEquals(new ElementGenerator("sample", "cpp", base).generate());
    }

    @Test
    public void shouldGenerate_sampleGame_jsLanguage() {
        assertEquals(new ElementGenerator("sample", "js", base).generate());
    }

    @Test
    public void shouldGenerate_sampleGame_phpLanguage() {
        assertEquals(new ElementGenerator("sample", "php", base).generate());
    }

    @Test
    public void shouldGenerate_sampleGame_javaLanguage() {
        assertEquals(new ElementGenerator("sample", "java", base).generate());
    }

    @Test
    public void shouldGenerate_sampleGame_pythonLanguage() {
        assertEquals(new ElementGenerator("sample", "python", base).generate());
    }

    @Test
    public void shouldGenerate_sampleGame_markdownLanguage() {
        assertEquals(new ElementGenerator("sample", "md", base).generate());
    }

    @Test
    public void shouldGenerate_mollymageGame_markdownLanguage() {
        assertEquals(new ElementGenerator("mollymage", "md", base).generate());
    }

    @Test
    public void shouldGenerate_mollymageGame_javaLanguage() {
        assertEquals(new ElementGenerator("mollymage", "java", base).generate());
    }

    @Test
    public void shouldGenerate_cliffordGame_markdownLanguage() {
        assertEquals(new ElementGenerator("clifford", "md", base).generate());
    }

    @Test
    public void shouldGenerate_cliffordGame_javaLanguage() {
        assertEquals(new ElementGenerator("clifford", "java", base).generate());
    }

    private void assertEquals(String actual) {
        SmokeUtils.assertSmokeFile(this.getClass().getSimpleName()
                + "/" + test.getMethodName() +  ".data",
                Arrays.asList(actual.split("\n")));
    }
}