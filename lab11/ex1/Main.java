import java.util.Random;

public class Main {
    public static void main(String[] args){
        Phone[] phones = new Phone[1000];
        for(int i= 0; i < phones.length; i++){
            phones[i] = generateRandomPhone();
        }

        SortingStrategy BubbleSort = new BubbleSort();
        SortingStrategy InsertionSort = new InsertionSort();
        SortingStrategy SelectionSort = new SelectionSort();

        long startTimeBubble = System.currentTimeMillis();
        BubbleSort.sort(phones);
        long endTimeBubble = System.currentTimeMillis();
        long durationBubble = endTimeBubble - startTimeBubble;
        System.out.println("\nBubbleSort: " + durationBubble);

        long startTimeInsertion = System.currentTimeMillis();
        InsertionSort.sort(phones);
        long endTimeInsertion = System.currentTimeMillis();
        long durationInsertion = endTimeInsertion - startTimeInsertion;
        System.out.println("\nInsertionSort: " + durationInsertion);

        long startTimeSelection = System.currentTimeMillis();
        SelectionSort.sort(phones);
        long endTimeSelection = System.currentTimeMillis();
        long durationSelection = endTimeSelection - startTimeSelection;
        System.out.println("\nSelectionSort: " + durationSelection);
    }

    public static Phone generateRandomPhone() {
        Random random = new Random();
        
        String[] cpuOptions = {"Snapdragon 888", "Exynos 2100", "Apple A14 Bionic", "Kirin 9000", "Dimensity 1200", "Snapdragon 865", "Exynos 990", "Apple A13 Bionic", "Kirin 980"};
        double minPrice = 80.0;
        double maxPrice = 1300.0;
        int minMem = 2;
        int maxMem = 16;
        String[] cameraOptions = {"12 MP", "32 MP", "48 MP", "64 MP", "128 MP"};
        
        String randomCpu = cpuOptions[random.nextInt(cpuOptions.length)];
        double randomPrice = minPrice + (maxPrice - minPrice) * random.nextDouble();
        int randomMem = random.nextInt(maxMem - minMem + 1) + minMem;
        String randomCamera = cameraOptions[random.nextInt(cameraOptions.length)];
        
        // Create a new Phone instance with the random values
        Phone randomPhone = new Phone(randomCpu, randomPrice, randomMem, randomCamera);
        
        return randomPhone;
    }

}
