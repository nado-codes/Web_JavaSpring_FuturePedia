package com.futurepedia.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Article extends ModelBase {
    public final String content;

    public Article(long id, String content, Date dateAdded, Timestamp lastModified) {
        // .. need to pass id, dateadded, lastmodified or use JSON Deserialization
        super(id, dateAdded, lastModified);
        this.content = content;
    }
}
