package com.kevin.mirs.vo;


public class Suggestion {

    private final String URL_PERFIX = "";

    String url;
    String name;
    String pic;

    public Suggestion(Integer id, String name, String pic) {
        this.url = URL_PERFIX + id;
        this.name = name;
        this.pic = pic;
    }


    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }


    public String getPic() {
        return pic;
    }


    @Override
    public String toString() {
        return "Suggestion{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
