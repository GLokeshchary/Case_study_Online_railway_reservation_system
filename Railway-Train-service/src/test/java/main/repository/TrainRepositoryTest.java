package main.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import main.models.Train;

@TestMethodOrder(OrderAnnotation.class)
class TrainRepositoryTest {

	@Autowired
	private TrainRepository trainRepository;
	
	
	
	@Test
	@Order(1)
	void saveTrainTest() {
		Train train=new Train(null, "12704", "Samparkrathi", "Hyderabad", "Delhi", LocalTime.of(8, 30, 00), LocalTime.of(9, 30, 00), null, null, false, false, "GENERAL");
		trainRepository.save(train);
		assertThat(train.getTrainNo()).isNotNull();
	}

}
