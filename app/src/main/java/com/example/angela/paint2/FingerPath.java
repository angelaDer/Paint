package com.example.angela.paint2;

import android.graphics.Path;

public class FingerPath {

    public int color;
    public boolean blur;
    public int brushSize;
    public Path path; // drawn path
    private int mR;
    private int mG;
    private int mB;

    // Type of brush
    public FingerPath(int R, int G, int B, boolean blur, int brushSize, Path path) {
        this.mR = R;
        this.mG = G;
        this.mB = B;
        this.blur = blur;
        this.brushSize= brushSize;
        this.path = path;
    }


    public int getmR() {
        return mR;
    }

    public int getmG() {
        return mG;
    }

    public int getmB() {
        return mB;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isBlur() {
        return blur;
    }

    public void setBlur(boolean blur) {
        this.blur = blur;
    }

    public int getBrushSize() {
        return brushSize;
    }

    public void setBrushSize(int brushSize) {
        this.brushSize = brushSize;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}