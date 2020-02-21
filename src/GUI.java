import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.sun.management.GarbageCollectionNotificationInfo;

import static java.util.concurrent.Executors.newSingleThreadScheduledExecutor;

public class GUI extends Application {
	int territory;
	SVGPath[] svgPath;
	Label[] id;
	ArrayList<String> cityID;
	int playerTurn =1;

	int bonusArmies=20;
	Group group = new Group();
	String title;
	Label info = new Label("");
	HBox humanInput = new HBox();
	Label l = new Label("enter number of armies: ");
//	TextField armiesInput = new TextField();
	Label l2 = new Label("enter where to place armies: ");
	TextField armiesPlace = new TextField();
	Button inputBtn = new Button("add");
	Button turn = new Button("Next Turn");

	Spinner<Integer> armiesInput = new Spinner<>(0,10,0,1);
	

	@Override
	public void start(Stage stage) throws FileNotFoundException {

		final File file1 = new File("/home/ziad/Risk/src/EgyptMap.txt");
		final File file2 = new File("/home/ziad/Risk/src/USAMap.txt");

		Label country = new Label("choose map: ");
		Label player1 = new Label("player 1: ");
		Label player2 = new Label("player 2: ");
		
		String countryChoice = "";
		
		ObservableList<String> options = FXCollections.observableArrayList(
				"human agent",
				"passive agent",
				"aggressive agent",
				"pacifist agent",
				"greedy agent",
				"A* agent",
				"realtime A* agent",
				"mini max agent");
		ObservableList<String> countryOptions = FXCollections.observableArrayList(
						"Egypt",
						"USA");
		
		ComboBox p1 = new ComboBox(options);
		ComboBox p2 = new ComboBox(options);
		ComboBox countryBox = new ComboBox(countryOptions);
		Button startBtn = new Button("Start");
		HBox hbox = new HBox();
		hbox.getChildren().add(country);
		hbox.getChildren().add(countryBox);
		hbox.getChildren().add(player1);
		hbox.getChildren().add(p1);
		hbox.getChildren().add(player2);
		hbox.getChildren().add(p2);
		hbox.getChildren().add(startBtn);
		hbox.setAlignment(Pos.CENTER);
		HBox.setMargin(player1, new Insets(10, 10, 10, 50));
		HBox.setMargin(player2, new Insets(10, 10, 10, 50));
		HBox.setMargin(startBtn, new Insets(10, 10, 10, 50));

		startBtn.setDisable(true);
		
		
		
		

		countryBox.setOnAction((e) -> {
			if (countryBox.getValue().toString().equals("Egypt")) {
				try {
					group.getChildren().clear();
					buildMap(file1);
					// Setting title to the Stage
					title = "Egypt map";
					stage.setTitle(title);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (countryBox.getValue().toString().equals("USA")) {
			try {
				group.getChildren().clear();
				buildMap(file2);
				// Setting title to the Stage
				title = "USA map";
				stage.setTitle(title);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	})	;

		p1.setOnAction((e) -> {
			if (!p1.getSelectionModel().isEmpty() && !p2.getSelectionModel().isEmpty()) {
				startBtn.setDisable(false);
			}
		});

		p2.setOnAction((e) -> {
			if (!p1.getSelectionModel().isEmpty() && !p2.getSelectionModel().isEmpty()) {
				startBtn.setDisable(false);
			}
		});

		// button handler
		startBtn.setOnAction((e) -> {
			System.out.println(p1.getValue());
			System.out.println(p2.getValue());
			// play(p1.getValue());
			// play(p2.getValue());
			startGame(p1.getValue().toString(), p2.getValue().toString(), stage.getTitle());
			if(p1.getValue().equals("human agent") || p2.getValue().equals("human agent")){
				humanInput.setDisable(false);
			}

		});
		
		VBox box = new VBox();
		box.getChildren().add(hbox);
		box.getChildren().add(group);
		box.getChildren().add(info);
		box.getChildren().add(humanInput);
		box.setAlignment(Pos.CENTER);

		// Creating a scene object
		Scene scene = new Scene(box, 600, 600);
		stage.setMaximized(true);
		

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();

	}

	public void buildMap(File file) throws FileNotFoundException {

		territory = countriesCount(file);
		Scanner input = new Scanner(file);
		input = new Scanner(file);

		id = new Label[territory];
		svgPath = new SVGPath[territory];
		cityID = new ArrayList<String>();

		for (int i = 0; i < territory; i++) {
			id[i] = new Label();
			svgPath[i] = new SVGPath();
			String[] name = input.next().split("\"");
			String cityName = name[1];
			System.out.println(cityName);
			cityID.add(cityName);
			
			String[] line = input.next().split("\"");
			String path = line[1];
			svgPath[i].setContent(path);
			svgPath[i].setStyle("-fx-fill: black; -fx-stroke: white; -fx-stroke-width:2; -fx-opacity: 0.3; ");
			final int ii = i;
			svgPath[i].setOnMouseEntered((e) -> {
					svgPath[ii].setStyle("-fx-fill: black; -fx-stroke: white; -fx-text-inner-color: white; -fx-stroke-width:2; -fx-opacity: 0.8; ");
//					id[ii].setTextFill(Color.BLACK);
				});
			
			svgPath[i].setOnMouseExited((e) -> {
					svgPath[ii].setStyle("-fx-fill: black; -fx-stroke: white; -fx-stroke-width:2; -fx-opacity: 0.3; ");
//					id[ii].setTextFill(Color.BLACK);
					});
			
			id[i].setTranslateX((svgPath[i].getLayoutBounds().getMaxX() + svgPath[i]
					.getLayoutBounds().getMinX()) / 2);
			id[i].setTranslateY((svgPath[i].getLayoutBounds().getMaxY() + svgPath[i]
					.getLayoutBounds().getMinY()) / 2);
			id[i].setStyle("-fx-font-size: 12");
			group.getChildren().add(svgPath[i]);
			group.getChildren().add(id[i]);
		}

	}

	public static int countriesCount(File file) throws FileNotFoundException {
		int count = 0;
		Scanner input = new Scanner(file);
		input.useDelimiter("\"");
		while (input.hasNext()) {
			System.out.println(input.next());
			count++;
		}
		count = count / 4;
		System.out.println(count);

		return count;
	}

	public void startGame(String agent1, String agent2, String selection) {
		Graph graph = new Graph();

		if(selection.equals("Egypt map")){
			graph.initializeEgypt();
			graph.map = Game.randomizeColours(graph.map);
			updateMap(graph.map);
		}else{
			graph.initializeUSA();
			graph.map = Game.randomizeColours(graph.map);
			updateMap(graph.map);
		}
		

//		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
//		Runnable task = new Runnable() {
//			public void run() {
//				updateMap(graph.map);
//			}
//		};
//		scheduler.schedule(task, 3, TimeUnit.SECONDS);
//		scheduler.shutdown();
		

			if (agent1.equals("human agent")) {

				info.setText("enter number of armies and click to a city to add them.");

				humanInput.getChildren().add(l);
				humanInput.getChildren().add(armiesInput);
				humanInput.getChildren().add(l2);
				humanInput.getChildren().add(armiesPlace);
				humanInput.getChildren().add(inputBtn);
				humanInput.getChildren().add(turn);
				humanInput.setDisable(true);
				humanInput.setAlignment(Pos.CENTER);


				inputBtn.setOnAction((e) -> {

					int armies = armiesInput.getValue();
					bonusArmies = bonusArmies - armies;
					int place = cityID.indexOf(armiesPlace.getText());
					graph.map.get(place).armies += armies;

					updateMap(graph.map);

					l2.setVisible(false);
					armiesInput.setVisible(false);
					inputBtn.setText("Attack");
					info.setText("choose a country to attack");
					inputBtn.setOnAction((o) -> {
						int cityToAttack = cityID.indexOf(armiesPlace.getText());
						for (int i = 0; i < graph.map.get(cityToAttack).neighbours.size(); i++) {
							if ((graph.map.get(cityToAttack).neighbours.get(i).color == Colour.RED) && (graph.map.get(cityToAttack).neighbours.get(i).armies > graph.map.get(cityToAttack).armies)) {
								graph.map.get(cityToAttack).color = Colour.RED;
								updateMap(graph.map);
							}


						}
					});
				});

				turn.setOnAction((e) -> {
							playerTurn = 0;
							inputBtn.setVisible(false);
							l.setVisible(false);
							armiesPlace.setVisible(false);
							info.setVisible(false);
							if (agent2.equals("pacifist agent")) {
								if (playerTurn == 0) {
									System.out.println("afefaefaefaefauogaeogfnhuoaefnhuoef");
									PacifistAgent pacifistAgent = new PacifistAgent();
									pacifistAgent.initializeMap(graph.map, Colour.BLUE);
									pacifistAgent.search(graph, Colour.RED);
								}
							} else if (agent2.equals("passive agent")) {
								PassiveAgent passiveAgent = new PassiveAgent();
								passiveAgent.initializeMap(graph.map, Colour.BLUE);
								passiveAgent.search(graph.map, Colour.BLUE);
							} else if (agent2.equals("aggressive agent")) {
								AggressiveAgent aggressiveAgent = new AggressiveAgent();
								aggressiveAgent.initializeMap(graph.map, Colour.BLUE);
								aggressiveAgent.search(graph, Colour.BLUE);
								aggressiveAgent.attack(graph, Colour.BLUE);
							}
							else if (agent2.equals("realtime A* agent")) {
								AStarRealTime aStarRealTime = new AStarRealTime();
								aStarRealTime.initializeMap(graph.map,Colour.BLUE);
								aStarRealTime.search(graph,Colour.BLUE);
								turn.setVisible(false);
								updateMap(graph.map);
							}
							else if (agent2.equals("greedy agent")) {
								GreedyAgent greedyAgent = new GreedyAgent();
								greedyAgent.initializeMap(graph.map,Colour.BLUE);
								greedyAgent.search(graph,Colour.BLUE);
								updateMap(graph.map);
							}

							else if (agent2.equals("A* agent")) {
								AStarAgent aStar = new AStarAgent();
								aStar.initializeMap(graph.map,Colour.BLUE);
								aStar.search(graph,Colour.BLUE);
								updateMap(graph.map);

							}



						}
				);


			}



		if (agent1.equals("aggressive agent")) {


			humanInput.getChildren().add(inputBtn);
			inputBtn.setText("simulate first");
			humanInput.getChildren().add(turn);


			inputBtn.setOnAction((e) -> {
				AggressiveAgent aggressiveAgent = new AggressiveAgent();
				aggressiveAgent.initializeMap(graph.map, Colour.BLUE);
				aggressiveAgent.search(graph, Colour.BLUE);
				aggressiveAgent.attack(graph, Colour.BLUE);

				updateMap(graph.map);


				inputBtn.setText("simulate nex turn");

			});

			turn.setOnAction((e) -> {
						playerTurn = 0;
						inputBtn.setVisible(false);
						l.setVisible(false);
						armiesPlace.setVisible(false);
						info.setVisible(false);
						if (agent2.equals("pacifist agent")) {
							if (playerTurn == 0) {
								System.out.println("afefaefaefaefauogaeogfnhuoaefnhuoef");
								PacifistAgent pacifistAgent = new PacifistAgent();
								pacifistAgent.initializeMap(graph.map, Colour.BLUE);
								pacifistAgent.search(graph, Colour.RED);
							}
						} else if (agent2.equals("passive agent")) {
							PassiveAgent passiveAgent = new PassiveAgent();
							passiveAgent.initializeMap(graph.map, Colour.BLUE);
							passiveAgent.search(graph.map, Colour.BLUE);
						} else if (agent2.equals("aggressive agent")) {
							AggressiveAgent aggressiveAgent = new AggressiveAgent();
							aggressiveAgent.initializeMap(graph.map, Colour.BLUE);
							aggressiveAgent.search(graph, Colour.BLUE);
							aggressiveAgent.attack(graph, Colour.BLUE);
						}
						else if (agent2.equals("realtime A* agent")) {
							AStarRealTime aStarRealTime = new AStarRealTime();
							aStarRealTime.initializeMap(graph.map,Colour.BLUE);
							aStarRealTime.search(graph,Colour.BLUE);
							turn.setVisible(false);
							updateMap(graph.map);
						}
						else if (agent2.equals("greedy agent")) {
							GreedyAgent greedyAgent = new GreedyAgent();
							greedyAgent.initializeMap(graph.map,Colour.BLUE);
							greedyAgent.search(graph,Colour.BLUE);
							updateMap(graph.map);
						}

						else if (agent2.equals("A* agent")) {
							AStarAgent aStar = new AStarAgent();
							aStar.initializeMap(graph.map,Colour.BLUE);
							aStar.search(graph,Colour.BLUE);
							updateMap(graph.map);

						}



					}
			);


		}






//		PacifistAgent pacifistAgent = new PacifistAgent()
// ;
////		PassiveAcgent passiveAgent = new PassiveAgent();
//		AggressiveAgent aggressiveAgent = new AggressiveAgent();
//		pacifistAgent.initializeMap(graph.map, Colour.RED);
////		passiveAgent.initializeMap(graph.map, Colour.BLUE);
//		aggressiveAgent.initializeMap(graph.map, Colour.BLUE);
//
//		updateMap(graph.map);
//
//
//		pacifistAgent.search(graph, Colour.RED);
////		aggressiveAgent.search(graph.map, Colour.BLUE);
////		aggressiveAgent.attack(graph.map, Colour.BLUE);
//		pacifistAgent.search(graph, Colour.RED);
//		aggressiveAgent.search(graph.map, Colour.BLUE);
	;

		
		
		
	}

	public boolean isGmaeOver(LinkedList<City> list) {
		for (City s : list) {
			if (!s.color.equals(list.get(0).color))
				return false;
		}
		return true;
	}

	public void updateMap(LinkedList<City> graph) {
		for (int i = 0; i < territory; i++) {
			if (graph.get(i).color == Colour.RED) {
				svgPath[i].setStyle("-fx-fill: red; -fx-stroke: white; -fx-stroke-width:2; -fx-opacity: 0.3; ");
				id[i].setText(cityID.get(i)+"\n" + graph.get(i).armies);
//				cityID[i].setText(""+graph.get(i).name);
				final int ii = i;
				svgPath[i].setOnMouseEntered((e) -> {
					svgPath[ii].setStyle("-fx-fill: red; -fx-stroke: white; -fx-stroke-width:2; -fx-opacity: 0.8; ");
					id[ii].setText(cityID.get(ii)+"\n" + graph.get(ii).armies);
						});
				svgPath[i].setOnMouseExited((e) -> {
					svgPath[ii].setStyle("-fx-fill: red; -fx-stroke: white; -fx-stroke-width:2; -fx-opacity: 0.3; ");
					id[ii].setText(cityID.get(ii)+"\n" + graph.get(ii).armies);
						});
			} else {
				
				svgPath[i].setStyle("-fx-fill: blue; -fx-stroke: white; -fx-stroke-width:2; -fx-opacity: 0.3; ");
				id[i].setText(cityID.get(i)+"\n" + graph.get(i).armies);
				final int ii = i;	
				svgPath[i].setOnMouseEntered((e) -> {
					svgPath[ii].setStyle("-fx-fill: blue; -fx-stroke: white; -fx-stroke-width:2; -fx-opacity: 0.8; ");
					id[ii].setText(cityID.get(ii)+"\n" + graph.get(ii).armies);
						});
				
				svgPath[i].setOnMouseExited((e) -> {
					svgPath[ii].setStyle("-fx-fill: blue; -fx-stroke: white; -fx-stroke-width:2; -fx-opacity: 0.3; ");
					id[ii].setText(cityID.get(ii)+"\n" + graph.get(ii).armies);
						});
			}
		}

	}

	public static void main(String args[]) {
		try {
			File file1 = new File(
					"/home/ziad/Risk/src/EgyptMap.txt");
			 File file2 = new
			 File("/home/ziad/Risk/src/USAMap.txt");
			int x = countriesCount(file1);
			// int y = countriesCount(file2);
			System.out.println("Egypt territories: " + x);
			// System.out.println("USA territories: "+y);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GUI gui = new GUI();
		// gui.startGame("sf","Sef");
		launch(args);
	}

}
