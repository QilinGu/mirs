package com.kevin.mirs.entity;


public class Movie {

    private String id;
    private String name;
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
    private String IMDbLink;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getScreenwriters() {
        return screenwriters;
    }

    public void setScreenwriters(String screenwriters) {
        this.screenwriters = screenwriters;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getOfficalWebsite() {
        return officialWebsite;
    }

    public void setOfficalWebsite(String officialWebsite) {
        this.officialWebsite = officialWebsite;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getAnotherNames() {
        return anotherNames;
    }

    public void setAnotherNames(String anotherNames) {
        this.anotherNames = anotherNames;
    }

    public String getIMDbLink() {
        return IMDbLink;
    }

    public void setIMDbLink(String IMDbLink) {
        this.IMDbLink = IMDbLink;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getStillsLink() {
        return stillsLink;
    }

    public void setStillsLink(String stillsLink) {
        this.stillsLink = stillsLink;
    }

    public String getStillsPhotosLinks() {
        return stillsPhotosLinks;
    }

    public void setStillsPhotosLinks(String stillsPhotosLinks) {
        this.stillsPhotosLinks = stillsPhotosLinks;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public String getPosterPhotosLinks() {
        return posterPhotosLinks;
    }

    public void setPosterPhotosLinks(String posterPhotosLinks) {
        this.posterPhotosLinks = posterPhotosLinks;
    }

    public String getWallpaperLink() {
        return wallpaperLink;
    }

    public void setWallpaperLink(String wallpaperLink) {
        this.wallpaperLink = wallpaperLink;
    }

    public String getWallpaperPhotosLinks() {
        return wallpaperPhotosLinks;
    }

    public void setWallpaperPhotosLinks(String wallpaperPhotosLinks) {
        this.wallpaperPhotosLinks = wallpaperPhotosLinks;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getAlsoLikeMovies() {
        return alsoLikeMovies;
    }

    public void setAlsoLikeMovies(String alsoLikeMovies) {
        this.alsoLikeMovies = alsoLikeMovies;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAllQuestionsLink() {
        return allQuestionsLink;
    }

    public void setAllQuestionsLink(String allQuestionsLink) {
        this.allQuestionsLink = allQuestionsLink;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getReviewsLink() {
        return reviewsLink;
    }

    public void setReviewsLink(String reviewsLink) {
        this.reviewsLink = reviewsLink;
    }

    public String getShortPopComments() {
        return shortPopComments;
    }

    public void setShortPopComments(String shortPopComments) {
        this.shortPopComments = shortPopComments;
    }

    public String getShortNewComments() {
        return shortNewComments;
    }

    public void setShortNewComments(String shortNewComments) {
        this.shortNewComments = shortNewComments;
    }

    public String getShortCommentsLink() {
        return shortCommentsLink;
    }

    public void setShortCommentsLink(String shortCommentsLink) {
        this.shortCommentsLink = shortCommentsLink;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
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
                ", IMDbLink='" + IMDbLink + '\'' +
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
