package com.kevin.mirs.entity;


public class Movie {

    private Integer id;
    private String doubanId;
    private String name;
    private String doubanRating;
    private String imdbRating;
    private String releaseYear;
    private String directors;
    private String screenwriters;
    private String actors;
    private String types;
    private String officialWebsite;
    private String originPlace;
    private String releaseDate;
    private String languages;
    private String runtime;
    private String anotherNames;
    private String imdbLink;
    private String coverLink;
    private String synopsis;
    private String stillsPhotosLinks;
    private String posterPhotosLinks;
    private String wallpaperPhotosLinks;
    private String awards;
    private String alsoLikeMovies;
    private String reviews;
    private String shortPopComments;


    // 索引电影需要的字段
    public Movie(Integer id, String name, String releaseYear, String directors, String screenwriters, String actors, String types, String originPlace, String languages, String anotherNames, String coverLink, String synopsis) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
        this.directors = directors;
        this.screenwriters = screenwriters;
        this.actors = actors;
        this.types = types;
        this.originPlace = originPlace;
        this.languages = languages;
        this.anotherNames = anotherNames;
        this.coverLink = coverLink;
        this.synopsis = synopsis;
    }

    // 所有字段的构造器
    public Movie(Integer id, String doubanId, String name, String doubanRating, String imdbRating, String releaseYear, String directors, String screenwriters, String actors, String types, String officialWebsite, String originPlace, String releaseDate, String languages, String runtime, String anotherNames, String imdbLink, String coverLink, String synopsis, String stillsPhotosLinks, String posterPhotosLinks, String wallpaperPhotosLinks, String awards, String alsoLikeMovies, String reviews, String shortPopComments) {
        this.id = id;
        this.doubanId = doubanId;
        this.name = name;
        this.doubanRating = doubanRating;
        this.imdbRating = imdbRating;
        this.releaseYear = releaseYear;
        this.directors = directors;
        this.screenwriters = screenwriters;
        this.actors = actors;
        this.types = types;
        this.officialWebsite = officialWebsite;
        this.originPlace = originPlace;
        this.releaseDate = releaseDate;
        this.languages = languages;
        this.runtime = runtime;
        this.anotherNames = anotherNames;
        this.imdbLink = imdbLink;
        this.coverLink = coverLink;
        this.synopsis = synopsis;
        this.stillsPhotosLinks = stillsPhotosLinks;
        this.posterPhotosLinks = posterPhotosLinks;
        this.wallpaperPhotosLinks = wallpaperPhotosLinks;
        this.awards = awards;
        this.alsoLikeMovies = alsoLikeMovies;
        this.reviews = reviews;
        this.shortPopComments = shortPopComments;
    }

    public Integer getId() {
        return id;
    }

    public String getDoubanId() {
        return doubanId;
    }

    public String getName() {
        return name;
    }

    public String getDoubanRating() {
        return doubanRating;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getDirectors() {
        return directors;
    }

    public String getScreenwriters() {
        return screenwriters;
    }

    public String getActors() {
        return actors;
    }

    public String getTypes() {
        return types;
    }

    public String getOfficialWebsite() {
        return officialWebsite;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getLanguages() {
        return languages;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getAnotherNames() {
        return anotherNames;
    }

    public String getImdbLink() {
        return imdbLink;
    }

    public String getCoverLink() {
        return coverLink;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getStillsPhotosLinks() {
        return stillsPhotosLinks;
    }

    public String getPosterPhotosLinks() {
        return posterPhotosLinks;
    }

    public String getWallpaperPhotosLinks() {
        return wallpaperPhotosLinks;
    }

    public String getAwards() {
        return awards;
    }

    public String getAlsoLikeMovies() {
        return alsoLikeMovies;
    }

    public String getReviews() {
        return reviews;
    }

    public String getShortPopComments() {
        return shortPopComments;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", doubanId='" + doubanId + '\'' +
                ", name='" + name + '\'' +
                ", doubanRating='" + doubanRating + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", directors='" + directors + '\'' +
                ", screenwriters='" + screenwriters + '\'' +
                ", actors='" + actors + '\'' +
                ", types='" + types + '\'' +
                ", officialWebsite='" + officialWebsite + '\'' +
                ", originPlace='" + originPlace + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", languages='" + languages + '\'' +
                ", runtime='" + runtime + '\'' +
                ", anotherNames='" + anotherNames + '\'' +
                ", imdbLink='" + imdbLink + '\'' +
                ", coverLink='" + coverLink + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", stillsPhotosLinks='" + stillsPhotosLinks + '\'' +
                ", posterPhotosLinks='" + posterPhotosLinks + '\'' +
                ", wallpaperPhotosLinks='" + wallpaperPhotosLinks + '\'' +
                ", awards='" + awards + '\'' +
                ", alsoLikeMovies='" + alsoLikeMovies + '\'' +
                ", reviews='" + reviews + '\'' +
                ", shortPopComments='" + shortPopComments + '\'' +
                '}';
    }
}
