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

import com.pityubak.liberator.annotations.MethodBox;
import com.pityubak.liberator.annotations.MethodElement;
import com.pityubak.liberator.builder.NormalizedPath;
import com.pityubak.liberator.misc.ModificationFlag;
import com.pityubak.gamelibrary.annotations.Fill;
import com.pityubak.gamelibrary.components.SwingEntity;
import com.pityubak.gamelibrary.misc.ColorType;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import com.pityubak.gamelibrary.annotations.EntityList;
import com.pityubak.gamelibrary.misc.FillType;
import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author Pityubak
 */
@MethodBox
public final class CollectionGenerator {

    @MethodElement(flag = ModificationFlag.PRIORITY_NORMAL)
    public List<String> getKeys(Fill fill) {
        if (fill.value().equals(FillType.KEY)) {
            Field[] fields = java.awt.event.KeyEvent.class.getDeclaredFields();
            List<String> reValue = new ArrayList<>();
            int i = 0;
            for (Field f : fields) {
                i++;
                if (Modifier.isStatic(f.getModifiers())) {
                    String name = f.getName();
                    if (name.startsWith("VK_") && !name.matches("DEAD") && i < 128) {
                        name = name.replace("VK_", "");
                        reValue.add(name);

                    }
                }
            }
            return reValue;
        } else {
            return Arrays.stream(ColorType.values()).map(Enum::name).collect(Collectors.toList());
        }
    }

    @MethodElement
    public List<SwingEntity> getEntityList(EntityList ent) {
        List<SwingEntity> entityList = new ArrayList<>();

        try {

            URL url = this.getClass().getResource(ent.path());
            String path = url.getPath();
            if (path.contains(".jar")) {
                path = new NormalizedPath(path).getNormalizedPath();
                try (JarFile jarFile = new JarFile(path)) {
                    Enumeration<JarEntry> entries = jarFile.entries();
                    while (entries.hasMoreElements()) {
                        JarEntry entry = entries.nextElement();
                        String entryName = entry.getName();
                        String realPathName = ent.path().substring(1);
                        if (!entryName.contains(ent.filter())
                                && entry.getRealName().contains(realPathName)
                                && !entry.getRealName().equals(realPathName)) {

                            SwingEntity entity = new SwingEntity();
                            entity.setWidth(ent.width());
                            entity.setHeight(ent.height());
                            entity.setDrawingType(ent.draw());
                            ImageIcon icon = new ImageIcon(this.getClass().getResource("/" + entry.getRealName()));
                            entity.setImage(icon.getImage());
                            entity.setColor(ent.color());
                            String[] temp = entryName.split("/");
                            entity.setImageName(temp[1]);
                            entityList.add(entity);

                        }
                    }
                }
            } else {
                this.getResourceFromIDE(path, ent, entityList);
            }

        } catch (IOException ex) {
            System.err.println("From collection generator: " + ex);
        }
        return entityList;
    }

    private void getResourceFromIDE(String parent, EntityList ent, List<SwingEntity> entityList) {
        File[] files = new File(parent).listFiles();
        if (files != null) {
            for (File file : files) {

                if (!file.getName().contains(ent.filter())) {
                    SwingEntity entity = new SwingEntity();
                    entity.setWidth(ent.width());
                    entity.setHeight(ent.height());
                    entity.setDrawingType(ent.draw());
                    ImageIcon icon = new ImageIcon(this.getClass().getResource(ent.path() + file.getName()));
                    entity.setImage(icon.getImage());
                    entity.setColor(ent.color());
                    entity.setImageName(file.getName());
                    entityList.add(entity);

                }
            }
        }
    }

}
