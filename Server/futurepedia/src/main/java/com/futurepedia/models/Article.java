package com.futurepedia.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.coffeemapper.ModelBase;

public class Article extends ModelBase {
    public String Name;
    public String Content;

    public Article() {
        super(0, null, null);
        this.Name = null;
        this.Content = null;
    }

    public Article(long id, String name, String content, LocalDateTime dateAdded, Timestamp lastModified) {
        // .. need to pass id, dateadded, lastmodified or use JSON Deserialization
        super(id, dateAdded, lastModified);
        this.Name = name;
        this.Content = content;
    }
}
