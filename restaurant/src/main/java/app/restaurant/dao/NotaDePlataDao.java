package app.restaurant.dao;

import java.util.List;
import app.restaurant.model.NotaDePlata;

public interface NotaDePlataDao {
	public List<NotaDePlata> getChitante();
	public void addNota(NotaDePlata nota);
	public void updateNota(NotaDePlata nota);
	public void removeNota(NotaDePlata nota);
}
