package com.management.client.unit;

import lombok.Getter;

public enum WeatherTypeEnum {
    A("晴","今天天气晴朗呀,我的小仙女可以出去玩耍啦，心情也要和天气一样好哦"),
    B("多云","今天多云我滴小仙女穿个薄外套吧，出门记得带伞哦，可能会下雨！"),
    C("阴","今天是阴天，让我给你带来阳光吧☀"),
    D("阵雨","今天是阵雨哦，出门记得带伞，淋湿了我会心疼的哦"),
    E("雷阵雨","今天是阵雨哦，出门记得带伞，淋湿了我会心疼的哦"),
    F("小雨","今天是小雨哦，出门记得带伞，淋湿了我会心疼的哦"),
    G("中雨","今天是中雨哦，出门记得带伞，淋湿了我会心疼的哦"),
    H("大雨","今天是大雨哦，出门记得带伞，淋湿了我会心疼的哦"),
    J("暴雨","今天是暴雨哦，就不要出门啦，在家躺尸也是一个不错的选择哦！"),
    K("阵雪","阵雪是不可能滴"),
    L("雨夹雪","宝贝我们一起去玩雪吧，雨夹雪也是很难得的呀！"),
    Z("小雪","让我们一起去玩雪吧！快收拾好东西哦"),
    X("中雪","中雪不可能滴"),
    V("大雪","大雪不可能滴"),
    N("暴雪","暴雪不可能滴"),
    M("雾","宝贝今天起雾了哦，出行慢点。"),
    O("沙尘","宝贝出门戴口罩哦");

    @Getter
    private String code;
    @Getter
    private String name;


    WeatherTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
    WeatherTypeEnum() {
    }

    public String getWeatherName(String code){
        String name = "这个天气好奇怪，我还没有想好哦,但是我有在想我的小宝宝呀！";
        for (WeatherTypeEnum weather : WeatherTypeEnum.values()){
            if (weather.getCode().equals(code)){
                name = weather.getName();
            }
        }
        return name;
    }
}
