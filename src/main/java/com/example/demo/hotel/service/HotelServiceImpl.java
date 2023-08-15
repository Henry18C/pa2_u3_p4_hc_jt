package com.example.demo.hotel.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hotel.repository.IHotelRepo;
import com.example.demo.hotel.repository.modelo.Habitacion;
import com.example.demo.hotel.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepo hotelRepo;
	
	
	@Override
	public List<Hotel> buscarInnerJoin() {
		// TODO Auto-generated method stub
		return hotelRepo.seleccionarInnerJoin();
	}

	@Override
	public List<Hotel> buscarOuterRightJoin() {
		// TODO Auto-generated method stub
		return hotelRepo.seleccionarOuterRightJoin();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLeftJoin() {
		// TODO Auto-generated method stub
		return hotelRepo.seleccionarHabitacionOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarOuterFullJoin() {
		// TODO Auto-generated method stub
		return hotelRepo.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> buscarWhereJoin() {
		// TODO Auto-generated method stub
		return hotelRepo.seleccionarWhereJoin();
	}

	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		// TODO Auto-generated method stub
		return hotelRepo.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarJoinFetch() {
		// TODO Auto-generated method stub
		return hotelRepo.seleccionarJoinFetch();
	}

	@Override
	public void guardar(Hotel hotel) {
		// TODO Auto-generated method stub
		
	List<Habitacion> habitaciones= hotel.getHabitaciones();
		
	for (Habitacion habitacion : habitaciones) {
		habitacion.setValorIncluidoIva(habitacion.getValor().multiply(new BigDecimal(0.12)));
	}
	
		this.hotelRepo.insertar(hotel);
	}

	
	

}
