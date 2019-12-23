/*
 * The MIT License
 *
 * Copyright 2019 Pityubak.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.pityubak.gamelibrary.service;

import com.pityubak.gamelibrary.misc.ColorType;
import java.awt.Color;

/**
 *
 * @author Pityubak RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, WHITE, BLACK, GRAY,
 * LIGHT_GRAY, DARK_GRAY, ORANGE, PINK
 *
 * LIME, OLIVE, PURPLE, TEAL, NAVY, MAROON, DARK_RED, BROWN, FIREBRICK, CRIMSON,
 * TOMATO, CORAL, INDIAN_RED, LIGHT_CORAL, DARK_SALMON, SALMON, LIGHT_SALMON,
 * ORANGE_RED, DARK_ORANGE, GOLD, DARK_GOLDEN_ROD, GOLDEN_ROD, LIGHT_GOLDEN_ROD,
 * PALE_GOLDEN_ROD, DARK_KHAKI, KHAKI, YELLOW_GREEN, DARK_OLIVE_GREEN,
 * OLIVE_DRAB, LAWN_GREEN, CHART_REUSE, GREEN_YELLOW, DARK_GREEN, FORREST_GREEN,
 * LIME_GREEN, LIGHT_GREEN, PALE_GREEN, DARK_SEA_GREEN, MEDIUM_SPRING_GREEN,
 * SPRING_GREEN, SEA_GREEN, MEDIUM_AQUA_MARINE, MEDIUM_SEA_GREEN,
 * LIGHT_SEA_GREEN, DARK_SLATE_GRAY, DARK_CYAN, AQUA, LIGHT_CYAN,
 * DARK_TURQUOISE, TURQUOISE, MEDIUM_TURQUOISE, PALE_TURQUOISE, AQUA_MARINE,
 * POWDER_BLUE, CADET_BLUE, STEEL_BLUE, CORN_FLOWER_BLUE, DEEP_SKY_BLUE,
 * DODGER_BLUE, LIGHT_BLUE, SKY_BLUE, LIGHT_SKY_BLUE, MIDNIGHT_BLUE, DARK_BLUE,
 * MEDIUM_BLUE, ROYAL_BLUE, BLUE_VIOLET, INDIGO, DARK_SLATE_BLUE, SLATE_BLUE,
 * MEDIUM_SLATE_BLUE, MEDIUM_PURPLE, DARK_MAGENTA, DARK_VIOLET, DARK_ORCHID,
 * MEDIUM_ORCHID, THISTLE, PLUM, VIOLET, ORCHID, MEDIUM_VIOLET_RED,
 * PALE_VIOLET_RED, DEEP_PINK, HOT_PINK, LIGHT_PINK, ANTIQUE_WHITE, BEIGE,
 * BISQUE, BLANCHED_ALMOND, WHEAT, CORN_SILK, LEMON_CHIFFON,
 * LIGHT_GOLDEN_ROD_YELLOW, LIGHT_YELLOW, SADDLE_BROWN, SIENNA, CHOCOLATE, PERU,
 * SANDY_BROWN, BURLY_WOOD, TAN, ROSY_BROWN, MOCCASIN, NAVAJO_WHITE, PEACH_PUFF,
 * MISTY_ROSE, LEVANDER_BlUSH, LINEN, OLD_LACE, PAPAYA_WHIP, SEA_SHELL,
 * MINT_CREAM, SLATE_GRAY, LIGHT_SLATE_GRAY, LIGHT_STEEL_BLUE, LAVENDAR,
 * FLORAL_WHITE, ALICE_BLUE, GHOST_WHITE, HONEYDEW, IVORY, AZURE, SNOW,
 * GAINSBORO, WHITE_SMOKE, SILVER
 */
public class ColorConvertService {

    private ColorConvertService() {
    }

    public static Color convert(ColorType type) {
        switch (type) {
            case RED:
                return Color.RED;
            case BLUE:
                return Color.BLUE;
            case YELLOW:
                return Color.YELLOW;
            case CYAN:
                return Color.CYAN;
            case MAGENTA:
                return Color.MAGENTA;
            case WHITE:
                return Color.WHITE;
            case BLACK:
                return Color.BLACK;
            case GRAY:
                return Color.GRAY;
            case LIGHT_GRAY:
                return Color.LIGHT_GRAY;
            case DARK_GRAY:
                return Color.DARK_GRAY;
            case ORANGE:
                return Color.ORANGE;
            case GREEN:
                return new Color(0, 128, 0);
            case PINK:
                return Color.PINK;
            case LIME:
                return new Color(0, 255, 0);
            case OLIVE:
                return new Color(128, 128, 0);
            case PURPLE:
                return new Color(128, 0, 128);
            case TEAL:
                return new Color(0, 128, 128);
            case NAVY:
                return new Color(0, 0, 128);
            case MAROON:
                return new Color(128, 0, 0);
            case DARK_RED:
                return new Color(139, 0, 0);
            case BROWN:
                return new Color(165, 42, 42);
            case FIREBRICK:
                return new Color(178, 34, 34);
            case CRIMSON:
                return new Color(220, 20, 60);
            case TOMATO:
                return new Color(255, 99, 71);
            case CORAL:
                return new Color(255, 127, 80);
            case INDIAN_RED:
                return new Color(205, 92, 92);
            case LIGHT_CORAL:
                return new Color(240, 128, 128);
            case DARK_SALMON:
                return new Color(233, 150, 122);
            case SALMON:
                return new Color(250, 128, 114);
            case LIGHT_SALMON:
                return new Color(255, 160, 122);
            case ORANGE_RED:
                return new Color(255, 69, 0);
            case DARK_ORANGE:
                return new Color(255, 140, 0);
            case GOLD:
                return new Color(255, 215, 0);
            case DARK_GOLDEN_ROD:
                return new Color(184, 134, 11);
            case GOLDEN_ROD:
                return new Color(218, 165, 32);
            case PALE_GOLDEN_ROD:
                return new Color(238, 232, 170);
            case DARK_KHAKI:
                return new Color(189, 183, 107);
            case KHAKI:
                return new Color(240, 230, 140);
            case YELLOW_GREEN:
                return new Color(154, 205, 50);
            case DARK_OLIVE_GREEN:
                return new Color(85, 107, 47);
            case OLIVE_DRAB:
                return new Color(107, 142, 35);
            case LAWN_GREEN:
                return new Color(124, 252, 0);
            case CHART_REUSE:
                return new Color(127, 255, 0);
            case GREEN_YELLOW:
                return new Color(173, 255, 47);
            case DARK_GREEN:
                return new Color(0, 100, 0);
            case FORREST_GREEN:
                return new Color(34, 139, 34);
            case LIME_GREEN:
                return new Color(50, 205, 50);
            case LIGHT_GREEN:
                return new Color(144, 238, 144);
            case PALE_GREEN:
                return new Color(152, 251, 152);
            case DARK_SEA_GREEN:
                return new Color(143, 188, 143);
            case MEDIUM_SPRING_GREEN:
                return new Color(0, 250, 154);
            case SPRING_GREEN:
                return new Color(0, 255, 127);
            case SEA_GREEN:
                return new Color(46, 139, 87);
            case MEDIUM_AQUA_MARINE:
                return new Color(102, 205, 170);
            case MEDIUM_SEA_GREEN:
                return new Color(60, 179, 113);
            case LIGHT_SEA_GREEN:
                return new Color(32, 178, 170);
            case DARK_SLATE_GRAY:
                return new Color(47, 79, 79);
            case DARK_CYAN:
                return new Color(0, 139, 139);
            case AQUA:
                return new Color(0, 255, 255);
            case LIGHT_CYAN:
                return new Color(224, 255, 255);
            case DARK_TURQUOISE:
                return new Color(0, 206, 209);
            case TURQUOISE:
                return new Color(64, 224, 208);
            case MEDIUM_TURQUOISE:
                return new Color(72, 209, 204);
            case PALE_TURQUOISE:
                return new Color(175, 238, 238);
            case AQUA_MARINE:
                return new Color(127, 255, 212);
            case POWDER_BLUE:
                return new Color(176, 224, 230);
            case CADET_BLUE:
                return new Color(95, 158, 160);
            case STEEL_BLUE:
                return new Color(70, 130, 180);
            case CORN_FLOWER_BLUE:
                return new Color(100, 149, 237);
            case DEEP_SKY_BLUE:
                return new Color(0, 191, 255);
            case DODGER_BLUE:
                return new Color(30, 144, 255);
            case LIGHT_BLUE:
                return new Color(173, 216, 230);
            case SKY_BLUE:
                return new Color(135, 206, 235);
            case LIGHT_SKY_BLUE:
                return new Color(135, 206, 250);
            case MIDNIGHT_BLUE:
                return new Color(25, 25, 112);
            case DARK_BLUE:
                return new Color(0, 0, 139);
            case MEDIUM_BLUE:
                return new Color(0, 0, 205);
            case ROYAL_BLUE:
                return new Color(65, 105, 225);
            case BLUE_VIOLET:
                return new Color(138, 43, 226);
            case INDIGO:
                return new Color(75, 0, 130);
            case DARK_SLATE_BLUE:
                return new Color(72, 61, 139);
            case SLATE_BLUE:
                return new Color(106, 90, 205);
            case MEDIUM_SLATE_BLUE:
                return new Color(123, 104, 238);
            case MEDIUM_PURPLE:
                return new Color(147, 112, 219);
            case DARK_MAGENTA:
                return new Color(139, 0, 139);
            case DARK_VIOLET:
                return new Color(148, 0, 211);
            case DARK_ORCHID:
                return new Color(153, 50, 204);
            case MEDIUM_ORCHID:
                return new Color(186, 85, 211);
            case THISTLE:
                return new Color(216, 191, 216);
            case PLUM:
                return new Color(221, 160, 221);
            case VIOLET:
                return new Color(238, 130, 238);
            case ORCHID:
                return new Color(218, 112, 214);
            case MEDIUM_VIOLET_RED:
                return new Color(199, 21, 133);
            case PALE_VIOLET_RED:
                return new Color(219, 112, 147);
            case DEEP_PINK:
                return new Color(255, 20, 147);
            case HOT_PINK:
                return new Color(255, 105, 180);
            case LIGHT_PINK:
                return new Color(255, 182, 193);
            case ANTIQUE_WHITE:
                return new Color(250, 235, 215);
            case BEIGE:
                return new Color(245, 245, 220);
            case BISQUE:
                return new Color(255, 228, 196);
            case BLANCHED_ALMOND:
                return new Color(255, 235, 205);
            case WHEAT:
                return new Color(245, 222, 179);
            case CORN_SILK:
                return new Color(255, 248, 220);
            case LEMON_CHIFFON:
                return new Color(255, 250, 205);
            case LIGHT_GOLDEN_ROD_YELLOW:
                return new Color(250, 250, 210);
            case LIGHT_YELLOW:
                return new Color(255, 255, 224);
            case SADDLE_BROWN:
                return new Color(139, 69, 19);
            case SIENNA:
                return new Color(160, 82, 45);
            case CHOCOLATE:
                return new Color(210, 105, 30);
            case PERU:
                return new Color(205, 133, 63);
            case SANDY_BROWN:
                return new Color(244, 164, 96);
            case BURLY_WOOD:
                return new Color(222, 184, 135);
            case TAN:
                return new Color(210, 180, 140);
            case ROSY_BROWN:
                return new Color(188, 143, 143);
            case MOCCASIN:
                return new Color(255, 228, 181);
            case NAVAJO_WHITE:
                return new Color(255, 222, 173);
            case PEACH_PUFF:
                return new Color(255, 218, 185);
            case MISTY_ROSE:
                return new Color(255, 228, 225);
            case LAVENDER_BLUSH:
                return new Color(255, 240, 245);
            case LINEN:
                return new Color(250, 240, 230);
            case OLD_LACE:
                return new Color(253, 245, 230);
            case PAPAYA_WHIP:
                return new Color(255, 239, 213);
            case SEA_SHELL:
                return new Color(255, 245, 238);
            case MINT_CREAM:
                return new Color(245, 255, 250);
            case SLATE_GRAY:
                return new Color(112, 128, 144);
            case LIGHT_SLATE_GRAY:
                return new Color(119, 136, 153);
            case LIGHT_STEEL_BLUE:
                return new Color(176, 196, 222);
            case LAVENDER:
                return new Color(230, 230, 250);
            case FLORAL_WHITE:
                return new Color(255, 250, 240);
            case ALICE_BLUE:
                return new Color(240, 248, 255);
            case GHOST_WHITE:
                return new Color(248, 248, 255);
            case HONEYDEW:
                return new Color(240, 255, 240);
            case IVORY:
                return new Color(255, 255, 240);
            case AZURE:
                return new Color(240, 255, 255);
            case SNOW:
                return new Color(255, 250, 250);
            case SILVER:
                return new Color(192, 192, 192);
            case GAINSBORO:
                return new Color(220, 220, 220);
            case WHITE_SMOKE:
                return new Color(245, 245, 245);

            default:
                return Color.BLACK;

        }
    }
}
