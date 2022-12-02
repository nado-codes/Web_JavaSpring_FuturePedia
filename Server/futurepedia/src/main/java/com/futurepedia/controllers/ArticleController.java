package com.futurepedia.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RestController;
import com.futurepedia.models.Article;
import com.futurepedia.utils.MySQLJDBCUtil;

import nl.jiankai.mapper.ResultSetMapper;
import nl.jiankai.mapper.ResultSetMapperFactory;

@RestController
@RequestMapping("/articles")
@CrossOrigin(origins = "http://localhost:3000/")
public class ArticleController {

    /*
     * @ModelAttribute
     * public void setResponseHeader(HttpServletResponse response) {
     * response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
     * response.setHeader(
     * "Access-Control-Allow-Headers",
     * "Origin, X-Requested-With, Content-Type, Accept");
     * }
     */

    // .. Really not happy with this code ... tons of repeated stuff (DRY principle)
    // .. Want to refactor this ASAP

    // .. GET
    @GetMapping("articles/")
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

    @GetMapping("/id")
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

    @GetMapping("/name")
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

    // .. POST, PUT, DELETE

    @PostMapping("articles/")
    public Article AddArticle() {
        // .. call "AddArticle" proc

        return null;
    }

    @PutMapping("/")
    public long UpdateArticle(@RequestBody Article article) {
        // .. call "UpdateArticle" proc
        String query = "{ call UpdateArticle(?,?,?) }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection();
                CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setLong("in_id", article.Id);
            stmt.setString("in_name", article.Name);
            stmt.setString("in_content", article.Content);

            rs = stmt.executeQuery();

            // ResultSetMapper r = ResultSetMapperFactory.getResultSetMapperIdentity();
            // Integer rowsUpdated = r.map(rs, Integer.class);

            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return -1;
    }

    @DeleteMapping("/")
    public long DeleteArticle() {
        // .. call "DeleteArticle" proc

        return -1;
    }
}
