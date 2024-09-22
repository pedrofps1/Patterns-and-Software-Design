public class SelectionSort implements SortingStrategy{
    public void sort(Phone[] phones) {
        int n = phones.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (phones[j].getPrice() < phones[minIndex].getPrice()) {
                    minIndex = j;
                }
            }
            
            Phone temp = phones[minIndex];
            phones[minIndex] = phones[i];
            phones[i] = temp;
        }
    }
}