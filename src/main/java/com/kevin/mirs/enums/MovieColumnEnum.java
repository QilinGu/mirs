package com.kevin.mirs.enums;

/**
 * 将Movie的列名与数字对应起来，保证数据安全
 */
public enum MovieColumnEnum {
    ID(1, "id"),
    DOUBAN_ID(2, "douban_id"),
    NAME(3, "name"),
    DOUBAN_RATING(4, "douban_rating"),
    IMDB_RATING(5, "imdb_rating"),
    RELEASE_YEAR(6, "release_year"),
    DIRECTORS(7, "directors"),
    SCREENWRITERS(8, "screenwriters"),
    ACTORS(9, "actors"),
    TYPES(10, "types"),
    OFFICIAL_WEBSITE(11, "official_website"),
    ORIGIN_PLACE(12, "origin_place"),
    RELEASE_DATE(13, "release_date"),
    LANGUAGES(14, "languages"),
    RUNTIME(15, "runtime"),
    ANOTHER_NAMES(16, "another_names"),
    IMDB_LINK(17, "imdb_link"),
    COVER_LINK(18, "cover_link"),
    SYNOPSIS(19, "synopsis"),
    STILLS_PHOTOS_LINKS(20, "stills_photos_links"),
    POSTER_PHOTOS_LINKS(21, "poster_photos_links"),
    WALLPAPER_PHOTOS_LINKS(22, "wallpaper_photos_links"),
    AWARDS(24, "awards"),
    ALSO_LIKE_MOVIES(25, "also_like_movies"),
    REVIEWS(26, "reviews"),
    SHORT_POP_COMMENTS(27, "short_pop_comments");


    private int index;
    private String name;

    MovieColumnEnum(int index, String column) {
        this.index = index;
        this.name = column;
    }

    public int getNum() {
        return index;
    }

    public String getName() {
        return name;
    }


    public static String columnOf(int index) {
        for (MovieColumnEnum movieColumnEnum : values()) {
            if(movieColumnEnum.getNum() == index) {
                return movieColumnEnum.getName();
            }
        }
        return null;
    }

}
