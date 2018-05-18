package com.example.angela.paint2;

import android.graphics.Path;

public class FingerPath {

    public int color;
    public boolean blur;
    public int brushSize;
    public Path path; // drawn path

    // Type of brush
    public FingerPath(int color, boolean blur, int brushSize, Path path) {
        this.color = color;
        this.blur = blur;
        this.brushSize= brushSize;
        this.path = path;
    }
}