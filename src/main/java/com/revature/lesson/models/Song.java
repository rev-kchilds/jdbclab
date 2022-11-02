package com.revature.lesson.models;

import java.util.Objects;

public class Song {
    private int id;
    private String name;
    private String artist;


    public Song() {
    }

    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public Song(int id, String name, String artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Song id(int id) {
        setId(id);
        return this;
    }

    public Song name(String name) {
        setName(name);
        return this;
    }

    public Song artist(String artist) {
        setArtist(artist);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Song)) {
            return false;
        }
        Song song = (Song) o;
        return id == song.id && Objects.equals(name, song.name) && Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, artist);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", artist='" + getArtist() + "'" +
            "}";
    }


}
