public class MarkovPredictorTester {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(MarkovPredictor.predictNextState("Sunny", "weather.csv"));
            System.out.println(MarkovPredictor.predictNextState("Partly Cloudy", "weather.csv"));
            System.out.println(MarkovPredictor.predictNextState("Cloudy", "weather.csv"));
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(MarkovPredictor.predictNextState("Studying", "activites.csv"));
            System.out.println(MarkovPredictor.predictNextState("Reading", "activites.csv"));
            System.out.println(MarkovPredictor.predictNextState("Sleeping", "activites.csv"));
        }
    }
}
