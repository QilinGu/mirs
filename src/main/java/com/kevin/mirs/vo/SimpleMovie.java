package com.kevin.mirs.vo;


public class SimpleMovie {

    private Integer id;
    private String name;
    private String doubanRating;
    private String imdbRating;
    private String releaseYear;
    private String directors;
    private String screenwriters;
    private String actors;
    private String types;
    private String originPlace;
    private String languages;
    private String runtime;
    private String coverLink;
    private String synopsis;

    public SimpleMovie(Integer id, String name, String doubanRating, String imdbRating, String releaseYear, String directors, String screenwriters, String actors, String types, String originPlace, String languages, String runtime, String coverLink, String synopsis) {
        this.id = id;
        this.name = name;
        this.doubanRating = doubanRating;
        this.imdbRating = imdbRating;
        this.releaseYear = releaseYear;
        this.directors = directors;
        this.screenwriters = screenwriters;
        this.actors = actors;
        this.types = types;
        this.originPlace = originPlace;
        this.languages = languages;
        this.runtime = runtime;
        this.coverLink = coverLink;
        this.synopsis = synopsis;
    }

    public Integer getId() {
        return id;
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

    public String getOriginPlace() {
        return originPlace;
    }

    public String getLanguages() {
        return languages;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getCoverLink() {
        return coverLink;
    }

    public String getSynopsis() {
        return synopsis;
    }

    @Override
    public String toString() {
        return "SimpleMovie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doubanRating='" + doubanRating + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", directors='" + directors + '\'' +
                ", screenwriters='" + screenwriters + '\'' +
                ", actors='" + actors + '\'' +
                ", types='" + types + '\'' +
                ", originPlace='" + originPlace + '\'' +
                ", languages='" + languages + '\'' +
                ", runtime='" + runtime + '\'' +
                ", coverLink='" + coverLink + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
