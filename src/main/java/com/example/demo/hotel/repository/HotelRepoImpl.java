package com.example.demo.hotel.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.hotel.repository.modelo.Habitacion;
import com.example.demo.hotel.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepoImpl implements IHotelRepo{

	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		// TODO Auto-generated method stub
		//select * from Hotel h inner join Habitacion ha"
		// "on h.hote_id = ha.habi_id_hotel
		TypedQuery<Hotel> query= this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN  h.habitaciones ha", Hotel.class);
		//hago referencia a donde tengo mi relacion
		List<Hotel> ListaHoteles= query.getResultList();
		for (Hotel hotel : ListaHoteles) {
			hotel.getHabitaciones().size();//le soy la señal para que me traiga los hoteles con todas sus referencias
		}
		
		
		return ListaHoteles ;
	}

	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query= this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN  h.habitaciones ha", Hotel.class);
		//hago referencia a donde tengo mi relacion
		return query.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query= this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN  h.habitaciones ha", Hotel.class);
		//hago referencia a donde tengo mi relacion
		return query.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		TypedQuery<Habitacion> query= this.entityManager.createQuery("SELECT ha FROM Hotel h LEFT JOIN  h.habitaciones ha", Habitacion.class);
		//hago referencia a donde tengo mi relacion
		return query.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterFullJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query= this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN  h.habitaciones ha", Hotel.class);
		//hago referencia a donde tengo mi relacion
		
		
		return query.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		// TODO Auto-generated method stub
		//SELECT * FROM hotel h, habitacion ha  WHERE h.hote_id = ha.habi_id_hotel
		//SELECT h FROM Hotel h, Habitacion ha  WHERE h = ha.hotel
		//compara con los objetos hotel en el caso de un join where
		
		TypedQuery<Hotel> query= this.entityManager.createQuery("SELECT h  FROM Hotel h, Habitacion ha  WHERE h = ha.hotel ", Hotel.class);
		//hago referencia a donde tengo mi relacion
		return query.getResultList();
	}

	@Override
	public List<Hotel> seleccionarJoinFetch() {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> query= this.entityManager.createQuery("SELECT h FROM Hotel h  JOIN FETCH  h.habitaciones ha", Hotel.class);
		
		return query.getResultList() ;
	}

	@Override
	public void insertar(Hotel hotel) {
		// TODO Auto-generated method stub
		this.entityManager.persist(hotel);
	}
	}
	
	

	
	

