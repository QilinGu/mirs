package com.kevin.mirs.entity;


public class EmailTemplate {

    private Integer id;
    private String title;
    private String content;
    private Integer sort;
    private String description;
    private String uniqueIdentity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUniqueIdentity() {
        return uniqueIdentity;
    }

    public void setUniqueIdentity(String uniqueIdentity) {
        this.uniqueIdentity = uniqueIdentity;
    }

    @Override
    public String toString() {
        return "EmailTemplate{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sort=" + sort +
                ", description='" + description + '\'' +
                ", uniqueIdentity='" + uniqueIdentity + '\'' +
                '}';
    }
}
