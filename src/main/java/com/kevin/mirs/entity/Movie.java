package com.kevin.mirs.entity;


public class Movie {

    private String id;
    private String douban_id;
    private String name;
    private String doubanRating;
    private String imdbRating;
    private String year;
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
    private String stillsLink;
    private String stillsPhotosLinks;
    private String posterLink;
    private String posterPhotosLinks;
    private String wallpaperLink;
    private String wallpaperPhotosLinks;
    private String awards;
    private String alsoLikeMovies;
    private String questions;
    private String allQuestionsLink;
    private String reviews;
    private String reviewsLink;
    private String shortPopComments;
    private String shortNewComments;
    private String shortCommentsLink;


    public String getId() {
        return id;
    }

    public String getDouban_id() {
        return douban_id;
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

    public String getYear() {
        return year;
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

    public String getStillsLink() {
        return stillsLink;
    }

    public String getStillsPhotosLinks() {
        return stillsPhotosLinks;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public String getPosterPhotosLinks() {
        return posterPhotosLinks;
    }

    public String getWallpaperLink() {
        return wallpaperLink;
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

    public String getQuestions() {
        return questions;
    }

    public String getAllQuestionsLink() {
        return allQuestionsLink;
    }

    public String getReviews() {
        return reviews;
    }

    public String getReviewsLink() {
        return reviewsLink;
    }

    public String getShortPopComments() {
        return shortPopComments;
    }

    public String getShortNewComments() {
        return shortNewComments;
    }

    public String getShortCommentsLink() {
        return shortCommentsLink;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", douban_id='" + douban_id + '\'' +
                ", name='" + name + '\'' +
                ", doubanRating='" + doubanRating + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", year='" + year + '\'' +
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
                ", stillsLink='" + stillsLink + '\'' +
                ", stillsPhotosLinks='" + stillsPhotosLinks + '\'' +
                ", posterLink='" + posterLink + '\'' +
                ", posterPhotosLinks='" + posterPhotosLinks + '\'' +
                ", wallpaperLink='" + wallpaperLink + '\'' +
                ", wallpaperPhotosLinks='" + wallpaperPhotosLinks + '\'' +
                ", awards='" + awards + '\'' +
                ", alsoLikeMovies='" + alsoLikeMovies + '\'' +
                ", questions='" + questions + '\'' +
                ", allQuestionsLink='" + allQuestionsLink + '\'' +
                ", reviews='" + reviews + '\'' +
                ", reviewsLink='" + reviewsLink + '\'' +
                ", shortPopComments='" + shortPopComments + '\'' +
                ", shortNewComments='" + shortNewComments + '\'' +
                ", shortCommentsLink='" + shortCommentsLink + '\'' +
                '}';
    }
}
