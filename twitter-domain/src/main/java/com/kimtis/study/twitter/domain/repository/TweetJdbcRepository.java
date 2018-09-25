package com.kimtis.study.twitter.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 *
 * Just Using Jdbc, test class
 * Planning Change to JPA
 */
@Repository
public class TweetJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //id save session..?
    private final int id=2;

    public Boolean post(String content){

        String insertSQL = "INSERT INTO TWEET(content,memberId) VALUES(?,?)";

        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertSQL);
                ps.setString(1,content);
                ps.setInt(2,id);
                return ps;
            }
        })>=0 ? true : false;
    }

    public Boolean delete(long tweetId){

        String deleteSQL = "DELETE FROM TWEET WHERE TWEETID=?";

        return jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(deleteSQL);
                ps.setLong(1,tweetId);
                return ps;
            }
        })>=0 ? true : false;

    }
}
