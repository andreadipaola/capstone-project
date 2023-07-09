package main.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import main.entities.enums.RoomStatus;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
public class Room {
	@Id
	@GeneratedValue
	@Column(name = "room_id")
	private UUID roomId;
	@Column(name = "room_number")
	private String roomNumber;
	private String floor;
	@Column(name = "room_status")
	@Enumerated(EnumType.STRING)
	private RoomStatus roomStatus;
	@Column(name = "is_smoking")
	private boolean isSmoking;

	@ManyToOne
	@JoinColumn(name = "room_type_id")
	private RoomType roomType;

	@Column(name = "date_added")
	private LocalDate dateAdded;

	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	public Room(String roomNumber, String floor, RoomStatus roomStatus, boolean isSmoking, RoomType roomType,
			Reservation reservation) {
		this.roomNumber = roomNumber;
		this.floor = floor;
		this.roomStatus = roomStatus;
		this.isSmoking = isSmoking;
		this.roomType = roomType;
		this.dateAdded = LocalDate.now();
		this.reservation = reservation;
	}

}
