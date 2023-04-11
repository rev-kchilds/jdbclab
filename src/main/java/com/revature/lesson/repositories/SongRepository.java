package com.revature.lesson.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.lesson.util.ConnectionUtil;
import com.revature.lesson.models.Song;

public class SongRepository {
    
    public void createSong(Song song){
        //implement JDBC logic here
        
        try {

            Connection conn = ConnectionUtil.getConnection();

            String sql = "INSERT INTO songs (name, artist) VALUES (?,?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, song.getName());
            ps.setString(2, song.getArtist());

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        
    }

    public List<Song> getAllSongs(){
        List<Song> songs = new ArrayList<>();
        try {

            Connection conn = ConnectionUtil.getConnection();

            String sql = "SELECT * FROM songs;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                songs.add(new Song(rs.getInt("id"), rs.getString("name"), rs.getString("artist")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return songs;
    }
    
}
