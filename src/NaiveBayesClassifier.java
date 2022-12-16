import java.util.ArrayList;
import java.util.HashMap;

public class NaiveBayesClassifier {
    HashMap<String, Float> priorHypothesisProbabilityMap = new HashMap<String, Float>();
    HashMap<String, ArrayList<HashMap<String, Float>>> conditionalHypothesisProbabilityMap = new HashMap<String, ArrayList<HashMap<String, Float>>>();

    public NaiveBayesClassifier(String[][] trainingData) {
        estimateProbabilitiesFromTrainingData(trainingData);
    }

    /**
     *
     * @param trainingData in the format e1, E2, E3, .., En, H
     */
    private void estimateProbabilitiesFromTrainingData(String[][] trainingData) {
        // re-calculating P(H) and by consequence also counting the entries for each hypothesis
        for (String[] vector : trainingData) {
            String hypothesis = vector[vector.length - 1];

            if (!priorHypothesisProbabilityMap.containsKey(hypothesis))
                priorHypothesisProbabilityMap.put(hypothesis, 1F / trainingData.length);
            else
                priorHypothesisProbabilityMap.put(hypothesis, priorHypothesisProbabilityMap.get(hypothesis) + (1F / trainingData.length));
        }

        // now that we have counted the hypotheses, we can calculate the conditional probabilities
        for(String[] vector : trainingData) {
            String hypothesis = vector[vector.length - 1];
            int hypothesisCount = (int) (priorHypothesisProbabilityMap.get(hypothesis) * trainingData.length);
            if (!conditionalHypothesisProbabilityMap.containsKey(hypothesis)) {
                conditionalHypothesisProbabilityMap.put(hypothesis, new ArrayList<HashMap<String, Float>>());
            }

            ArrayList<HashMap<String, Float>> evidenceList = conditionalHypothesisProbabilityMap.get(hypothesis);
            for (int i = 0 ; i < vector.length - 1 ; i++) {
                if (i == evidenceList.size())
                    evidenceList.add(new HashMap<String, Float>());

                HashMap<String, Float> conditionMap = evidenceList.get(i);
                String condition = vector[i];

                if (!conditionMap.containsKey(condition))
                    conditionMap.put(condition, 1F / hypothesisCount);
                else
                    conditionMap.put(condition, conditionMap.get(condition) + (1F / hypothesisCount));
            }
        }
    }

    /**
     *
     * @return the most likely hypothesis as a string
     */
    public String classify(String[] vector) {
        String maxProbabilityHypothesis = null;
        float maxProbability = 0F;

        for (String hypothesis : priorHypothesisProbabilityMap.keySet()) {
            float probability = priorHypothesisProbabilityMap.get(hypothesis);
            for (int i = 0 ; i < vector.length ; i++) {
                String condition = vector[i];
                probability *= conditionalHypothesisProbabilityMap.get(hypothesis).get(i).get(condition);
            }
            if (probability > maxProbability) {
                maxProbability = probability;
                maxProbabilityHypothesis = hypothesis;
            }
        }

        System.out.println("The estimator estimates hypothesis " + maxProbabilityHypothesis + " with a probability of " + maxProbability);

        return maxProbabilityHypothesis;
    }

    public static void main(String args[]) {
        String[][] trainingSet = {
            // Outlook, Temperature, Humidity, Wind -> Play Tennis
            {"Sunny", "Hot", "High", "Weak", "No"},
            {"Sunny", "Hot", "High", "Strong", "No"},
            {"Overcast", "Hot", "High", "Weak", "Yes"},
            {"Rain", "Mild", "High", "Weak", "Yes"},
            {"Rain", "Cool", "Normal", "Weak", "Yes"},
            {"Rain", "Cool", "Normal", "Strong", "No"},
            {"Overcast", "Cool", "Normal", "Strong", "Yes"},
            {"Sunny", "Mild", "High", "Weak", "No"},
            {"Sunny", "Cool", "Normal", "Weak", "Yes"},
            {"Rain", "Mild", "Normal", "Weak", "Yes"},
            {"Sunny", "Mild", "Normal", "Strong", "Yes"},
            {"Overcast", "Mild", "High", "Strong", "Yes"},
            {"Overcast", "Hot", "Normal", "Weak", "Yes"},
            {"Rain", "Mild", "High", "Strong", "No"}
        };

        String[] newInstance = {"Sunny", "Cool", "High", "Strong"};

        NaiveBayesClassifier naiveBayesClassifier = new NaiveBayesClassifier(trainingSet);
        naiveBayesClassifier.classify(newInstance);
    }
}
