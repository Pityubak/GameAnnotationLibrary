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
@Target(ElementType.FIELD)
@Register
public @interface Message {


    String message();

    int width() default 0;

    int height() default 0;

    ColorType color() default ColorType.BLACK;
}
