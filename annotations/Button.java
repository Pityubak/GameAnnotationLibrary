/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pityubak.gamelibrary.annotations;

import com.pityubak.liberator.annotations.Register;
import com.pityubak.gamelibrary.misc.ColorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 *
 * @author Pityubak
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Register
public @interface Button {
    String text() default "Button1";
    int x() default 0;
    int y() default 0;
    boolean doubleBuffered() default false;
    int width() default 100;
    int height() default 50;
    ColorType fgColor() default ColorType.BLACK;
    ColorType bgColor() default ColorType.WHITE;
    String toolTipText() default "Tooltip1";
}
