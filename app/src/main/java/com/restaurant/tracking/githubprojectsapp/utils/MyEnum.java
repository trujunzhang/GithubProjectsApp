package com.restaurant.tracking.githubprojectsapp.utils;

/**
 * Created by djzhang on 7/20/15.
 */
//public enum MyEnum {
//    HOGE(1),
//    FUGA(2);
//
//    private final int id;
//
//    private MyEnum(final int id) {
//        this.id = id;
//    }
//
//
//}


public enum MyEnum {
    EnumValue1,
    EnumValue2;

    public static MyEnum fromInteger(int x) {
        switch(x) {
            case 0:
                return EnumValue1;
            case 1:
                return EnumValue2;
        }
        return null;
    }
}
