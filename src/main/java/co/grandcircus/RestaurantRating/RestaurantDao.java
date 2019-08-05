package co.grandcircus.RestaurantRating;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.RestaurantRating.Restaurant;

@Repository
@Transactional
public class RestaurantDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public List<Restaurant> findAll(){
		return em.createQuery("FROM Restaurant", Restaurant.class).getResultList();
	}
	
	public void upRate(long id) {
		Restaurant item = em.getReference(Restaurant.class, id);
		double increase = item.getRating() + 0.5;
		if(increase > 5) {
			item.setRating(5);
		}else {
			item.setRating(increase);
		}
		
		em.merge(item);
	}
	
	public void downRate(long id) {
		Restaurant item = em.getReference(Restaurant.class, id);
		double decrease = item.getRating() - 0.5;
		if(decrease < 0) {
			item.setRating(0);
		}else {
			item.setRating(decrease);
		}
		em.merge(item);
	}
	
}