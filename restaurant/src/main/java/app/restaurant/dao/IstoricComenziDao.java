package app.restaurant.dao;

import java.util.List;
import app.restaurant.model.IstoricComenzi;

public interface IstoricComenziDao {
	public List<IstoricComenzi> getIstoricComenzi();
	public void addIstoricComenzi(IstoricComenzi istoric);
	//public void updateIstoricComenzi(IstoricComenzi istoric);
	public void removeIstoricComenzi(IstoricComenzi istoric);
}
