package net.mycompany.mobile.dto;

import java.util.Date;

public class Schedule {
	
	private int id;
	private Movie movie;
	private Date date;
	private String time;
	private String screen;
	private double cost;

	public Schedule(int id) {		
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", movie=" + movie + ", date=" + date
				+ ", time=" + time + ", screen=" + screen + ", cost=" + cost
				+ "]";
	}

	
	
}
