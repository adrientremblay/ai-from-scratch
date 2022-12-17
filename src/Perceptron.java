public class Perceptron {
    float[] weights;
    float threshold;
    float learningRate;

    public Perceptron(int inputsCount) {
        weights = new float[inputsCount];
        threshold = 0.55f;
        learningRate = 0.05f;
    }

    public Perceptron(int inputsCount, float threshold, int learningRate) {
        this(inputsCount);
        this.threshold = threshold;
        this.learningRate = learningRate;
    }

    public void train(int[][] inputList, int[] expectedList) {
        if (inputList.length != expectedList.length)
            return;

        int epoch = 1;
        while (true) {
            boolean allGood = true;

            for (int i = 0 ; i < inputList.length ; i++)
                allGood = allGood && feed(inputList[i], expectedList[i]);

            if (allGood)
                break;

            epoch++;
        }

        System.out.println("Finished training after " + epoch + " epochs");
        for (int i = 0 ; i < weights.length ; i++) {
            System.out.println("w" + (i+1) + "= " + weights[i]);
        }
    }

    public boolean feed(int[] inputs, int expected) {
        if (inputs.length != weights.length)
            return false;

        float result = 0;
        for (int i = 0 ; i < inputs.length ; i++)
            result += inputs[i] * weights[i];

        if ((result >= threshold && expected == 1) || (result < threshold && expected == 0))
            return true;

        for (int i = 0 ; i < inputs.length ; i++)
            if (inputs[i] == 1)
                weights[i] = result >= threshold ? weights[i] - learningRate : weights[i] + learningRate;

        return false;
    }

    public int classify(int... inputs) {
        if (inputs.length != weights.length)
            return 0;

        float result = 0;
        for (int i = 0 ; i < inputs.length ; i++)
            result += inputs[i] * weights[i];

        return result >= threshold ? 1 : 0;
    }

    public static void main(String args[]) {
        Perceptron p = new Perceptron(4);

        int[][] training_inputs = {
                {1,1,0,1},
                {1,1,1,0},
                {0,0,1,0},
                {0,1,0,1},
                {1,0,1,1},
                {0,1,1,1}
        };

        int[] training_outputs = {0,1,0,0,1,0};

        p.train(training_inputs, training_outputs);

    }
}
