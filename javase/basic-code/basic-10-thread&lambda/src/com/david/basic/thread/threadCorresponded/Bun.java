package com.david.basic.thread.threadCorresponded;

/**
 * 资源类:包子类
 设置包子的属性
 皮
 陷
 包子的状态: 有 true,没有 false
 * @author david
 * @create 2019-04-18 23:41
 */
public class Bun {
    private String skin;
    private String xian;
    private boolean flag=false;

    public Bun() {
    }

    public Bun(String skin, String xian, boolean flag) {
        this.skin = skin;
        this.xian = xian;
        this.flag = flag;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Bun{" +
                "skin='" + skin + '\'' +
                ", xian='" + xian + '\'' +
                ", flag=" + flag +
                '}';
    }
}
