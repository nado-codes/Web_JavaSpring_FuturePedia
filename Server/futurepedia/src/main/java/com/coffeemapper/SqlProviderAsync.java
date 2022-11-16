package com.coffeemapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.futurepedia.utils.MySQLJDBCUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;

import nl.jiankai.mapper.ResultSetMapper;

public class SqlProviderAsync {
    /// <summary>
    /// Dictates the type of CRUD operation being performed, and therefore which
    /// parameters to keep or omit depending on selected property conventions
    /// </summary>
    public enum CRUDType {
        Create,
        Read,
        Update,
        Delete
    }

    private final String _connectionString;

    public SqlProviderAsync(String connectionString, Object template) {
        _connectionString = connectionString;
        // PropertyConventions = new List<PropertyConventionBase>();
    }

    // .. REMOVE ALL THE ASYNC STUFF .. we dont need it for now

    // QUERIES

    // .. EXECUTE SCALAR

    public Object ExecuteScalarAsync(String command, CRUDType crudType, String parameterName, Object parameterValue) {
        Map<String, Object> myMap = new HashMap<String, Object>();
        myMap.put(parameterName, parameterValue);
        // ExecuteScalarAsync(command, crudType, myMap);
        return null;
    }

    public Object ExecuteScalarAsync(String command, CRUDType crudType, HashMap<String, Object> parameters) {

        /*
         * try ( cmd = OpenConnection(command, crudType, parameters))
         * {
         * var data = await cmd.ExecuteScalarAsync();
         * return data;
         * }
         */

        /*
         * String query = "{ call GetArticles() }";
         * ResultSet rs;
         * 
         * try (Connection conn = MySQLJDBCUtil.getConnection();
         * CallableStatement stmt = conn.prepareCall(query)) {
         * 
         * rs = stmt.executeQuery();
         * 
         * ResultSetMapper r = ResultSetMapperFactory.getResultSetMapperIdentity();
         * List<Article> articles = r.map(rs, Article.class);
         * 
         * return articles;
         * } catch (SQLException ex) {
         * System.out.println(ex.getMessage());
         * }
         * 
         * return Collections.emptyList();
         */
        return null;
    }

    // SQL CONNECTION

    /**
     * Open a SQL connection to call a stored procedure. Passed parameters will be
     * filtered depending on the specified CRUDType
     *
     * @return a Connection object
     * @throws SQLException
     */
    private Connection OpenConnection(String command, CRUDType crudType, HashMap<String, Object> parameters) {
        /*
         * var cmd = new SqlCommand(command) { CommandType = CommandType.StoredProcedure
         * };
         * cmd.Connection = new SqlConnection(_connectionString);
         * var parametersWithoutConvention = parameters?.Where(x =>
         * !ParameterHasConvention(x.Key, crudType));
         * parametersWithoutConvention?.ToList().ForEach( p =>
         * cmd.Parameters.AddWithValue(p.Key,p.Value));
         * cmd.Connection.Open();
         * return cmd;
         */
        Connection conn = null;
        try (FileInputStream f = new FileInputStream("db.properties")) {

            // load the properties file
            Properties pros = new Properties();
            pros.load(f);

            // assign db parameters
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");

            // create a connection to the database
            // conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}