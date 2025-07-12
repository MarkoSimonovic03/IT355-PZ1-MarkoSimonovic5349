package com.metropolitan.IT355_PZ1_MarkoSimonovic5349.model;

public class Book {
    private String name;
    private String summary;
    private boolean isAvailable;
    private Author author;
    private Category category;

    public Book() {
    }

    public Book(String name, String summary, boolean isAvailable, Author author, Category category) {
        this.name = name;
        this.summary = summary;
        this.isAvailable = isAvailable;
        this.author = author;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", isAvailable=" + isAvailable +
                ", author=" + author +
                ", category=" + category +
                '}';
    }
}
