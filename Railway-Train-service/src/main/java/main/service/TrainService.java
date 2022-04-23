package main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.models.Train;
import main.repository.TrainRepository;

@Service
public class TrainService {
	
	@Autowired
	TrainRepository trainRepository;

	public void addTrain(Train train) {
		trainRepository.save(train);
		
	}

	public List<Train> getAllTrains() {
		
		return trainRepository.findAll();
	}

	public void deleteTrainByTrainNo(Train train) {
		trainRepository.delete(train);
		
	}

	public String updateTrain(Train train) {
	    trainRepository.save(train);
		return "Updated Successfully";
	}
	
	
}
