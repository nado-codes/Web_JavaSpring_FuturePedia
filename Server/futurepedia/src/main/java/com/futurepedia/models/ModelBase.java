package com.futurepedia.models;

import java.sql.Date;
import java.sql.Timestamp;

public class ModelBase {
    public final long Id;
    public final Date DateAdded; 
    public final Timestamp LastModified;

    public ModelBase(long id, Date dateAdded, Timestamp lastmodified) {
        this.Id = id;
        this.DateAdded = dateAdded;
        this.LastModified = lastmodified;
    }
}
