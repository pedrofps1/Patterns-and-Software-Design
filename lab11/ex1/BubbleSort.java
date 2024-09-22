
public class BubbleSort implements SortingStrategy{
    public void sort(Phone[] phones) {
        int n = phones.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (phones[j].getPrice() > phones[j + 1].getPrice()) {
                    Phone temp = phones[j];
                    phones[j] = phones[j + 1];
                    phones[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped)
                break;
        }
    }
}
