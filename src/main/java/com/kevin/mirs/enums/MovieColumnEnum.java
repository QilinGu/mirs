package com.kevin.mirs.enums;

/**
 * 将Movie的列名与数字对应起来，保证数据安全
 */
public enum MovieColumnEnum {
    ID(1, "id", 1.0F),
    DOUBAN_ID(2, "douban_id", 1.0F),
    NAME(3, "name", 10.0F),
    DOUBAN_RATING(4, "douban_rating", 1.0F),
    IMDB_RATING(5, "imdb_rating", 1.0F),
    RELEASE_YEAR(6, "release_year", 1.0F),
    DIRECTORS(7, "directors", 8.0F),
    SCREENWRITERS(8, "screenwriters", 7.0F),
    ACTORS(9, "actors", 6.0F),
    TYPES(10, "types", 2.0F),
    OFFICIAL_WEBSITE(11, "official_website", 1.0F),
    ORIGIN_PLACE(12, "origin_place", 2.0F),
    RELEASE_DATE(13, "release_date", 1.0F),
    LANGUAGES(14, "languages", 2.0F),
    RUNTIME(15, "runtime", 1.0F),
    ANOTHER_NAMES(16, "another_names", 9.0F),
    IMDB_LINK(17, "imdb_link", 1.0F),
    COVER_LINK(18, "cover_link", 1.0F),
    SYNOPSIS(19, "synopsis", 3.0F),
    STILLS_PHOTOS_LINKS(20, "stills_photos_links", 1.0F),
    POSTER_PHOTOS_LINKS(21, "poster_photos_links", 1.0F),
    WALLPAPER_PHOTOS_LINKS(22, "wallpaper_photos_links", 1.0F),
    AWARDS(24, "awards", 2.0F),
    ALSO_LIKE_MOVIES(25, "also_like_movies", 1.0F),
    REVIEWS(26, "reviews", 2.0F),
    SHORT_POP_COMMENTS(27, "short_pop_comments", 2.0F);


    private int index;
    private String name;
    private float boost;//权重

    MovieColumnEnum(int index, String column, float boost) {
        this.index = index;
        this.name = column;
        this.boost = boost;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public float getBoost() {
        return boost;
    }


    public static String columnOf(int index) {
        for (MovieColumnEnum movieColumnEnum : values()) {
            if(movieColumnEnum.getIndex() == index) {
                return movieColumnEnum.getName();
            }
        }
        return null;
    }

}
