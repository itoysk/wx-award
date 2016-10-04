package org.kevin.wx.entity;

/**
 * Created by itoysk on 2016/9/22.
 */
public class Award {
    private int id;
    private int level;
    private String name;
    private double rate;
    private int count;
    private int min_angle;
    private int max_angle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMin_angle() {
        return min_angle;
    }

    public void setMin_angle(int min_angle) {
        this.min_angle = min_angle;
    }

    public int getMax_angle() {
        return max_angle;
    }

    public void setMax_angle(int max_angle) {
        this.max_angle = max_angle;
    }

    @Override
    public String toString() {
        return level+":"+name;
    }
}
