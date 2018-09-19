package org.zerock.dao;

import java.sql.SQLException;

public interface Executor {
    public abstract void doJob() throws SQLException;
}
