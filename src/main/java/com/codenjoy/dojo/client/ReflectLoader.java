package com.codenjoy.dojo.client;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 - 2021 Codenjoy
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

import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.RandomDice;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;

public class ReflectLoader {

    private static final String JAVA_PACKAGE_FORMAT = "com.codenjoy.dojo.games.%s";
    private static final String SCALA_PACKAGE_FORMAT = "com.codenjoy.dojo.games.%s.scala";

    public static Solver loadJavaSolver(String game) {
        return loadSolver(String.format(JAVA_PACKAGE_FORMAT, game));
    }

    public static Solver loadScalaSolver(String game) {
        return loadSolver(String.format(SCALA_PACKAGE_FORMAT, game));
    }

    private static Solver loadSolver(String packageName) {
        try {
            return (Solver) load(Solver.class, packageName)
                    .getDeclaredConstructor(Dice.class)
                    .newInstance(new RandomDice());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading Solver for: " + packageName);
        }
    }

    public static ClientBoard loadJavaBoard(String game) {
        return loadBoard(String.format(JAVA_PACKAGE_FORMAT, game));
    }

    public static ClientBoard loadScalaBoard(String game) {
        return loadBoard(String.format(SCALA_PACKAGE_FORMAT, game));
    }

    private static ClientBoard loadBoard(String packageName) {
        try {
            return (ClientBoard) load(ClientBoard.class, packageName)
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading Solver for: " + packageName);
        }
    }

    private static Class<?> load(Class<?> type, String packageName) {
        return new Reflections(packageName)
                .getSubTypesOf(type)
                .stream()
                .filter(clazz -> !Modifier.isAbstract(clazz.getModifiers()))
                .filter(clazz -> !Modifier.isInterface(clazz.getModifiers()))
                .filter(clazz -> Modifier.isPublic(clazz.getModifiers()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(type.getSimpleName() + " not found for: " + packageName));
    }
}
