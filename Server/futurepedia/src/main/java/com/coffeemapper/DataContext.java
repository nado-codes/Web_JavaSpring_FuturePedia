package com.coffeemapper;

public class DataContext<TEntity extends ModelBase> {

    private final SqlProviderAsync _sqlProviderAsync = null;

    // private String modelName = (new TEntity()).getClass().getName();
    private final String modelNamePlural = null;
    private Class<TEntity> cls;

    // public List<PropertyConventionBase> PropertyConventions =>
    // _sqlProviderAsync.PropertyConventions;

    /// <summary>
    /// Create a new DataContext accepting a <paramref name="connectionString"/>
    /// for use with models of type <paramref name="TEntity"/>
    /// </summary>
    /// <param name="connectionString"></param>
    public DataContext(String connectionString) {
        // var pluralizer = new Pluralizer();
        // modelNamePlural = pluralizer.Pluralize(modelName);
        cls.getName();

        // _sqlProviderAsync = new SqlProviderAsync(connectionString);
    }

    /*
     * /// <summary>
     * /// Retrieve all of the rows in the database for a given model.
     * /// Note: Requires stored procedure "Get[modelName](s/es)" e.g. "GetTest(s)".
     * /// </summary>>
     * /// <param name="id"></param>
     * /// <returns>All entities of type <paramref name="TEntity"/></returns>
     * public async Task<IEnumerable<TEntity>>
     * 
     * GetAllAsync()
     * {
     * var data = await
     * _sqlProviderAsync.ExecuteReaderAsync($"Get{modelNamePlural}");
     * 
     * return data.Select(d => NadoMapper.MapPropsToSingle<TEntity>(d));
     * }
     * 
     * /// <summary>
     * /// Retrieve a single row from the database by <paramref name="id"/>.
     * /// Note: Requires stored procedure "Get[modelName]ById " e.g. "GetTestById".
     * /// </summary>>
     * /// <param name="id"></param>
     * /// <returns>An entity of type <paramref name="TEntity"/> corresponding to
     * /// <paramref name="id"/></returns>
     * public async Task<TEntity> GetSingleByIdAsync(long id) =>
     * 
     * await GetSingleAsync("id",id);
     * 
     * /// <summary>
     * /// Retrieve a single row from the database by <paramref name="name"/>.
     * /// Note: Requires stored procedure "Get[modelName]ByName " e.g.
     * "GetTestByName".
     * /// </summary>>
     * /// <param name="name"></param>
     * /// <returns>An entity of type <paramref name="TEntity"/> corresponding to
     * <paramref name="name"/></returns>
     * public async Task<TEntity> GetSingleByNameAsync(string name) =>
     * 
     * await GetSingleAsync("name", name);
     * 
     * /// <summary>
     * /// Retrieve a single row from the database based on some parameter
     * (<paramref name="parameterName"/> and <paramref name="parameterValue"/>)
     * /// Note: Requires stored procedure "Get[modelName]By[parameterName]" e.g.
     * "GetTestByName".
     * /// </summary>>
     * /// <param name="parameterName"></param>
     * /// <param name="parameterValue"></param>
     * /// <returns>An entity of type <paramref name="TEntity"/> corresponding to
     * <paramref name="parameterName"/></returns>
     * public async Task<TEntity> GetSingleAsync(string parameterName, object
     * parameterValue)
     * {
     * var procName =
     * $"Get{modelName}By{parameterName.ToUpper()[0] + parameterName.Substring(1)}";
     * 
     * var data = await _sqlProviderAsync.ExecuteReaderAsync(procName,
     * parameterName, parameterValue);
     * var single = data.FirstOrDefault();
     * 
     * return NadoMapper.MapSingle<TEntity>(single);
     * }
     * 
     * /// <summary>
     * /// Create a new row in the database containing the parameters of <paramref
     * /// name="model" /> and return it's id.
     * /// Note: Requires stored procedure "Add[modelName]" e.g. "AddTest"
     * /// </summary>
     * /// <param name="model"></param>
     * /// <exception cref="T:System.ArgumentException"/>
     * /// <returns>An id of type <see cref="T:System.Int64"/></returns>
     * public async Task<long>
     * 
     * AddAsync(TEntity model)
     * {
     * var parameters = NadoMapper.ReflectPropsFromSingle(model);
     * var id = await _sqlProviderAsync.ExecuteScalarAsync($"Add{modelName}",
     * CRUDType.Create, parameters);
     * 
     * return Convert.ToInt64(id);
     * }
     * 
     * /// <summary>
     * /// Update a row (or rows) in the database based on the parameters specified
     * in
     * /// <paramref name="model" /> and return the number of rows that were
     * updated.
     * /// Note: Requires stored procedure "Update[modelName] e.g. "UpdateTest"
     * /// </summary>
     * /// <param name="model"></param>
     * /// <returns>Number of rows updated as a <see
     * cref="T:System.Int64"/></returns>
     * public async Task<long>
     * 
     * UpdateAsync(TEntity model)
     * => await _sqlProviderAsync.ExecuteNonQueryAsync($"Update{modelName}",
     * CRUDType.Update, NadoMapper.ReflectPropsFromSingle(model));
     * 
     * /// <summary>
     * /// Delete a row from the database corresponding to the <paramref name="Id"/>
     * and <paramref name="LastModified"/> of <paramref name="model"/>
     * /// Note: Requires stored procedure "Delete[modelName] e.g. "DeleteTest"
     * /// </summary>
     * /// <param name="model"></param>
     * /// <returns>Number of rows updated as a <see
     * cref="T:System.Int64"/></returns>
     * public async Task<long>
     * 
     * DeleteAsync(TEntity model)
     * => await _sqlProviderAsync.ExecuteNonQueryAsync($"Delete{modelName}",
     * CRUDType.Update, new Dictionary<string, object>()
     * {
     * {"id",model.Id},
     * {"lastModified",model.LastModified}
     * });
     */
}
