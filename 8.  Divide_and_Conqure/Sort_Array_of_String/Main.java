public class Main {

    public static void mergeSort(String str[], int si, int ei) {
        if(si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        mergeSort(str, si, mid);
        mergeSort(str, mid+1, ei);

        merge(str, si, mid, ei);
    }

    public static void merge(String str[], int si, int mid, int ei) {
        String temp[] = new String[ei-si+1];

        int i=si;
        int j=mid+1;
        int k=0;

        while(i <= mid && j <= ei) {
            if(str[i].compareTo(str[j]) < 0) {
                temp[k] = str[i];
                i++;
            }
            else {
                temp[k] = str[j];
                j++;
            }
            k++;
        }

        while(i <= mid) {
            temp[k++] = str[i++];
        }

        while(j <= ei) {
            temp[k++] = str[j++];
        }

        for(k=0, i=si; k<temp.length; k++, i++) {
            str[i] = temp[k];
        }
    }

    public static void main(String args[]) {
        String str[] = {"sun", "earth", "mars", "mercury"};

        mergeSort(str, 0, str.length - 1);

        System.out.print("[ ");
        for(int i=0; i<str.length; i++) {
            System.out.print("'" + str[i] + "'" + " ");
        }
        System.out.print("]");
    }
}