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
package com.pityubak.gamelibrary;

import com.pityubak.liberator.Liberator;
import com.pityubak.gamelibrary.components.RunnableComponent;
import com.pityubak.gamelibrary.components.SwingComponent;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Pityubak
 */
public final class GameBuilder {

    private final Liberator liberator;
    private final SwingComponent[] injectedClassList;
    private RunnableComponent component;

    public GameBuilder(Class<?>[] classes) {
        liberator = new Liberator(GameBuilder.class);

        this.injectedClassList = new SwingComponent[classes.length];

        registerInjectedClassList(classes);

        this.liberator.inject(classes);

        initializeSwingRegister();

    }

    public void run(int wait) {
        if (this.component != null) {
            this.component.getFrame().pack();
            this.component.getFrame().setLocationRelativeTo(null);
            this.component.getFrame().setVisible(true);

            SwingUtilities.invokeLater(() -> {
                Timer timer = new Timer(wait, (ActionEvent e)
                        -> this.component.run()
                );
                timer.start();

            });
        } else {
            throw new NullPointerException("RunnableComponent doesn't exist. ");
        }
    }

    private void initializeSwingRegister() {
        for (SwingComponent swingReg : injectedClassList) {
            if (swingReg != null) {

                swingReg.init();
                if (swingReg instanceof RunnableComponent) {
                    this.component = (RunnableComponent) swingReg;
                }
            } else {
                throw new NullPointerException("This " + swingReg + " is null");
            }
        }
    }

    private void registerInjectedClassList(Class<?>[] classes) {

        for (int i = 0; i < classes.length; i++) {

            this.injectedClassList[i] = (SwingComponent) this.liberator.inject(classes[i]);

        }

    }

}
