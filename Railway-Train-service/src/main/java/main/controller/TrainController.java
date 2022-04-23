package main.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.models.Train;
import main.models.Trains;
import main.service.TrainService;

@RestController
@RequestMapping("/trains")
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	//save train
	@PostMapping("/public/addTrain")
	public String addTrain(@RequestBody Train train) {
		trainService.addTrain(train);
		return "Saved";
	}
	//GET all trains
	@GetMapping("/public/getAllTrains")
	public List<Train> getAllTrains(){
		return trainService.getAllTrains();
	}
	//CAlling get all trains through microservice connection
	@GetMapping("/public/findAllTrains")
	public Trains findAllTrains() {
		List<Train> trainList=trainService.getAllTrains();
		Trains trains=new Trains();
		trains.setList(trainList);
		return trains;
	}
	//get all the trains between two stations
	@GetMapping("/public/getTrainBetween/{origin}:{destination}")
	public List<Train> getTrainBetweenTwoStations(@PathVariable String origin,@PathVariable String destination){
		List<Train> list=trainService.getAllTrains();
		 return list.stream().filter(data->data.getDepatureStation().equals(origin) && data.getArrivalStation().equals(destination)).collect(Collectors.toList());
	}
	
	//get train by train no
	@GetMapping("/public/getTrainByTrainNo/{trainNo}")
	public Train getTrainByTrainNo(@PathVariable String trainNo) {
		return trainService.getAllTrains().stream().filter(data->data.getTrainNo().equals(trainNo)).collect(Collectors.toList()).get(0);
	}
	
	//Delete Train
	@DeleteMapping("/public/deleteTrainByTrainNo/{trainNo}")
	public String deleteTrain(@PathVariable String trainNo) {
		Train train=trainService.getAllTrains().stream().filter(p->p.getTrainNo().equals(trainNo)).collect(Collectors.toList()).get(0);
		trainService.deleteTrainByTrainNo(train);
		
		return "Deleted SuccessFully";
	}
	//Update Train
	@PutMapping("/public/updateTrainByTrainNo/{trainNo}")
	public String updateTrainByTrainNo(@PathVariable String trainNo,@RequestBody Train train) {
		return trainService.updateTrain(train);
	}
	
}
