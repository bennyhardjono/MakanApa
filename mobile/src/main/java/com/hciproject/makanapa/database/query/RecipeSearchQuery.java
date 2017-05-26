package com.hciproject.makanapa.database.query;

import com.hciproject.makanapa.database.dao.RecipeDAO;
import com.hciproject.makanapa.database.data.Data;
import com.hciproject.makanapa.database.model.RecipeModel;

import java.sql.SQLException;
import java.util.List;


public class RecipeSearchQuery extends Query
{
	private String mQuery;
	private long mSkip = -1l;
	private long mTake = -1l;


	public RecipeSearchQuery(String query)
	{
		mQuery = query;
	}


	public RecipeSearchQuery(String query, long skip, long take)
	{
		mQuery = query;
		mSkip = skip;
		mTake = take;
	}


	@Override
	public Data<List<RecipeModel>> processData() throws SQLException
	{
		Data<List<RecipeModel>> data = new Data<>();
		data.setDataObject(RecipeDAO.search(mQuery, mSkip, mTake));
		return data;
	}
}
