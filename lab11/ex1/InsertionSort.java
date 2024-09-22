
public class InsertionSort implements SortingStrategy{
    public void sort(Phone[] phones) {
        int n = phones.length;
        
        for (int i = 1; i < n; i++) {
            Phone key = phones[i];
            int j = i - 1;
            
            while (j >= 0 && phones[j].getPrice() > key.getPrice()) {
                phones[j + 1] = phones[j];
                j = j - 1;
            }
            
            phones[j + 1] = key;
        }
    }
}
