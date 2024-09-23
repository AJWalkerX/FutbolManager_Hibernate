package com.ajwalker.repository;

import com.ajwalker.entity.Manager;
import com.ajwalker.entity.Player;
import com.ajwalker.entity.Team;
import jakarta.persistence.NoResultException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ajwalker.utility.HibernateConnection.em;

public class PlayerRepository extends RepositoryManager<Player,Long>{
	private static PlayerRepository instance;
	private PlayerRepository() {
		super(Player.class);
	}
	public static  PlayerRepository getInstance() {
		if (instance == null) {
			instance = new PlayerRepository();
		}
		return instance;
	}
	
	public List<Player> findByTeam(Team team) {
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Player> cq = cb.createQuery(Player.class);
			Root<Player> root = cq.from(Player.class);
			cq.select(root).where(cb.equal(root.get("team"), team));
			
			return em.createQuery(cq).getResultList();
		}
		
		catch (RuntimeException e) {
			System.err.println("findByUsernameAndPassword metodunda hata..." + e.getMessage());
		}
		return new ArrayList<Player>();
		
	}
}