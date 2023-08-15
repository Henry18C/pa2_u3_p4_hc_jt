package com.example.demo.hotel.service;

import java.util.List;

import com.example.demo.hotel.repository.modelo.Habitacion;
import com.example.demo.hotel.repository.modelo.Hotel;

public interface IHotelService {
	
	public List<Hotel> buscarInnerJoin();
	
	public List<Hotel> buscarOuterRightJoin();
	
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin();
	
	public List<Hotel> buscarOuterFullJoin();
	
	public List<Hotel> buscarWhereJoin();
	
	public List<Hotel> buscarOuterLeftJoin();
	
	public List<Hotel> buscarJoinFetch(); 

	public void guardar (Hotel hotel);


}
