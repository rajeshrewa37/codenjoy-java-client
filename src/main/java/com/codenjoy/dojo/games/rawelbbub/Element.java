package com.codenjoy.dojo.games.rawelbbub;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 Codenjoy
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


import com.codenjoy.dojo.services.printer.CharElement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public enum Element implements CharElement {

    WATER(' ',       "An empty space where hero can move."),

    REEFS('☼',       "Underwater reefs. They cannot be destroyed."),

    EXPLOSION('Ѡ',   "Explosion site. It disappears in a second."),

	OIL('#',         "Oil leak, hitting which the hero partially loses control. " +
                     "During the passage, the field of view is limited and " +
                     "the hero will repeat the old commands for several " +
                     "ticks in a row, ignoring the current commands."),

    SEAWEED('%',     "Seaweed hide heroes which can continue to shoot at the " +
                     "same time. The fired shells are also not visible under the " +
                     "weed. Only prizes can be seen from behind seaweed."),

    RIVER('~',       "The river does not allow to pass through itself without " +
                     "the PRIZE_WALKING_ON_WATER prize, but the shells fly freely " +
                     "through the water. Hero stuck in the middle of the water, " +
                     "after canceling the PRIZE_WALKING_ON_WATER prize, can move " +
                     "1 cell in the water only every N ticks."),

	WALL('╬', 3,     "A wall that hasn't been shot yet. It takes 3 shots to completely destroy."),

    WALL_DESTROYED_DOWN('╩', 2,        "Partially destroyed wall. For complete destruction, 2 shot is required."),
    WALL_DESTROYED_UP('╦', 2,          "Partially destroyed wall. For complete destruction, 2 shot is required."),
    WALL_DESTROYED_LEFT('╠', 2,        "Partially destroyed wall. For complete destruction, 2 shot is required."),
    WALL_DESTROYED_RIGHT('╣', 2,       "Partially destroyed wall. For complete destruction, 2 shot is required."),

    WALL_DESTROYED_DOWN_TWICE('╨', 1,  "Partially destroyed wall. For complete destruction, 1 shot is required."),
    WALL_DESTROYED_UP_TWICE('╥', 1,    "Partially destroyed wall. For complete destruction, 1 shot is required."),
    WALL_DESTROYED_LEFT_TWICE('╞', 1,  "Partially destroyed wall. For complete destruction, 1 shot is required."),
    WALL_DESTROYED_RIGHT_TWICE('╡', 1, "Partially destroyed wall. For complete destruction, 1 shot is required."),

    WALL_DESTROYED_LEFT_RIGHT('│', 1,  "Partially destroyed wall. For complete destruction, 1 shot is required."),
    WALL_DESTROYED_UP_DOWN('─', 1,     "Partially destroyed wall. For complete destruction, 1 shot is required."),

    WALL_DESTROYED_UP_LEFT('┌', 1,     "Partially destroyed wall. For complete destruction, 1 shot is required."),
    WALL_DESTROYED_RIGHT_UP('┐', 1,    "Partially destroyed wall. For complete destruction, 1 shot is required."),
    WALL_DESTROYED_DOWN_LEFT('└', 1,   "Partially destroyed wall. For complete destruction, 1 shot is required."),
    WALL_DESTROYED_DOWN_RIGHT('┘', 1,  "Partially destroyed wall. For complete destruction, 1 shot is required."),

    WALL_DESTROYED(' ', 0, "Partially destroyed wall. For complete destruction, 2 shot is required."),

    BULLET('•',            "Completely destroyed wall. Wall will recover over time."),

    HERO_UP('▲',           "Your hero is pointing up."),
    HERO_RIGHT('►',        "Your hero is pointing right."),
    HERO_DOWN('▼',         "Your hero is pointing down."),
    HERO_LEFT('◄',         "Your hero is pointing left."),

    OTHER_HERO_UP('˄',     "Enemy hero is pointing up."),
    OTHER_HERO_RIGHT('˃',  "Enemy hero is pointing right."),
    OTHER_HERO_DOWN('˅',   "Enemy hero is pointing down."),
    OTHER_HERO_LEFT('˂',   "Enemy hero is pointing left."),

    AI_UP('?',        "AI is pointing up."),
    AI_RIGHT('»',     "AI is pointing right."),
    AI_DOWN('¿',      "AI is pointing down."),
    AI_LEFT('«',      "AI is pointing left."),

    AI_PRIZE('◘',     "AI can also be a prize, then it is highlighted " +
                           "by this sprite every few ticks."),

    PRIZE('!',             "The dropped prize after the destruction of the prize " +
                           "AI flickers on the field every even tick of the game " +
                           "with this sprite."),

    PRIZE_IMMORTALITY('1',      "A prize that gives the hero temporary invulnerability."),

    PRIZE_BREAKING_WALLS('2',   "A prize that allows you to temporarily destroy any walls " +
                                "with 1 shot, even indestructible ones (but not the border " +
                                "of the field)."),

    PRIZE_WALKING_ON_WATER('3', "A prize that allows the hero to temporarily walk on water."),

    PRIZE_VISIBILITY('4',       "A prize that allows the hero to temporarily see all " +
                                "enemies under the trees and their bullets."),

    PRIZE_NO_SLIDING('5',       "A prize that allows the hero to temporarily not slide " +
                                "on the ice.");

    private static List<Element> result = null;

    public static Collection<Element> getWalls() {
        if (result == null) {
            result = Arrays.stream(values())
                    .filter(e -> e.name().startsWith(WALL.name()))
                    .collect(toList());
        }
        return result;
    }

    private final char ch;
    private final String info;
    private final int power;

    Element(char ch, String info) {
        this(ch, -1, info);
    }

    Element(char ch, int power, String info) {
        this.ch = ch;
        this.info = info;
        this.power = power;
    }

    @Override
    public char ch() {
        return ch;
    }

    @Override
    public String info() {
        return info;
    }

    public int power() {
        return power;
    }

    @Override
    public String toString() {
        return String.valueOf(ch);
    }

    public static Element valueOf(char ch) {
        for (Element el : Element.values()) {
            if (el.ch == ch) {
                return el;
            }
        }
        throw new IllegalArgumentException("No such element for " + ch);
    }
}