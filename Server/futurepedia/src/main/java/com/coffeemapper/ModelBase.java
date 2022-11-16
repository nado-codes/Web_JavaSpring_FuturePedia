package com.coffeemapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ModelBase {
    public long Id;
    public LocalDateTime DateAdded;
    public Timestamp LastModified;

    public ModelBase(long id, LocalDateTime dateAdded, Timestamp lastmodified) {
        this.Id = id;
        this.DateAdded = dateAdded;
        this.LastModified = lastmodified;
    }
}
