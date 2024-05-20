package se.ex2.module34_36;

public enum ColorCode2 {
    R("紅色"),
    B("黑色"),
    G("綠色"),
    U("未定");

    private final String name;

    ColorCode2(String name) {
        this.name = name;
    }

    public String getName2() {
        return name;
    }
}
