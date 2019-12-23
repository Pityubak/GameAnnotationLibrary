/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pityubak.gamelibrary.annotations;

import com.pityubak.gamelibrary.misc.PredefinedAction;
import com.pityubak.liberator.annotations.Register;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Pityubak
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(Bindings.class)
@Register
public @interface Binding {

    String actionName() default "";

    String targetName() default "";

    String parent() default "";

    int speed() default 0;

    PredefinedAction actionType();
    
    String targetVar() default "";
    
    Class<?> filter() default Binding.class;
    
    String[] resetComponents() default {};
}
