package com.hciproject.makanapa.database.query;

import com.hciproject.makanapa.database.dao.RecipeDAO;
import com.hciproject.makanapa.database.data.Data;
import com.hciproject.makanapa.database.model.RecipeModel;

import java.sql.SQLException;
import java.util.List;


public class RecipeReadFavoritesQuery extends Query
{
	private long mSkip = -1l;
	private long mTake = -1l;


	public RecipeReadFavoritesQuery()
	{
	}


	public RecipeReadFavoritesQuery(long skip, long take)
	{
		mSkip = skip;
		mTake = take;
	}


	@Override
	public Data<List<RecipeModel>> processData() throws SQLException
	{
		Data<List<RecipeModel>> data = new Data<>();
		data.setDataObject(RecipeDAO.readFavorites(mSkip, mTake));
		return data;
	}
}
