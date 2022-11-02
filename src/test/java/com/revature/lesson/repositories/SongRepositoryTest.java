package com.revature.lesson.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.lesson.models.Song;
import com.revature.lesson.util.H2Util;

public class SongRepositoryTest {

    SongRepository songRepository = new SongRepository();

    @BeforeEach
    public void BeforeEach(){
        H2Util.generateTables();
    }

    @AfterEach
    public void AfterEach(){
        H2Util.dropAllTables();
    }

    @Test
    void testGetAllUsers() {
        //arrange
        Song song1 = new Song("Let it be", "Beatles");
        Song song2 = new Song("Imagine", "Beatles");
        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        
        for(Song song : songs){
            songRepository.createSong(song);
        }

        //act
        List<Song> actualResult = songRepository.getAllSongs();

        assertEquals(songs.size(), actualResult.size());

    }

    @Test
    void testCreateSong() {
        //arrange
        Song song = new Song("Let it be", "Beatles");

        //act
        songRepository.createSong(song);
        List<Song> songs = songRepository.getAllSongs();

        //assert
        assertEquals(1, songs.size());

    }
}
