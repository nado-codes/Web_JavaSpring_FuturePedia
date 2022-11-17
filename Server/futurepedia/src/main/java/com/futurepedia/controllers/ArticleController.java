package com.futurepedia.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.futurepedia.models.Article;
import com.futurepedia.utils.MySQLJDBCUtil;

import nl.jiankai.mapper.ResultSetMapper;
import nl.jiankai.mapper.ResultSetMapperFactory;

@RestController
public class ArticleController {

    // .. Really not happy with this code ... tons of repeated stuff (DRY principle)
    // .. Want to refactor this ASAP
    @GetMapping("/articles")
    public List<Article> GetArticles() {
        String query = "{ call GetArticles() }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection();
                CallableStatement stmt = conn.prepareCall(query)) {

            rs = stmt.executeQuery();

            ResultSetMapper r = ResultSetMapperFactory.getResultSetMapperIdentity();
            List<Article> articles = r.map(rs, Article.class);

            return articles;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Collections.emptyList();
    }

    @GetMapping("/articles/id")
    public Article GetArticleById(long id) {
        String query = "{ call GetArticleById(?) }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection();
                CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setLong("in_id", id);

            rs = stmt.executeQuery();

            ResultSetMapper r = ResultSetMapperFactory.getResultSetMapperIdentity();
            List<Article> articles = r.map(rs, Article.class);

            return articles.size() > 0 ? articles.get(0) : null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @GetMapping("/articles/name")
    public Article GetArticleByName(String name) {
        String query = "{ call GetArticleByName(?) }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection();
                CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString("in_name", name);

            rs = stmt.executeQuery();

            ResultSetMapper r = ResultSetMapperFactory.getResultSetMapperIdentity();
            List<Article> articles = r.map(rs, Article.class);

            return articles.size() > 0 ? articles.get(0) : null;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    @PostMapping("/articles")
    public Article AddArticle() {
        // .. call "AddArticle" proc

        return null;
    }

    @PutMapping("/articles")
    public long UpdateArticle() {
        // .. call "UpdateArticle" proc

        return -1;
    }

    @DeleteMapping("/articles")
    public long DeleteArticle() {
        // .. call "DeleteArticle" proc

        return -1;
    }
}
