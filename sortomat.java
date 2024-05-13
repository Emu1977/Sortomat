import java.util.*;
import java.awt.*;
import javax.swing.*;

public class sortomat { 

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return; // Wenn das Array leer oder null ist, gibt es nichts zu sortieren
        }
        sort(array, 0, array.length - 1); // Aufruf der Hilfsmethode sort mit dem gesamten Array
    }

    // Hilfsmethode für den eigentlichen Sortierprozess
    private static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return; // Basisfall: Wenn low >= high, ist das Array bereits sortiert
        }

        // Wahl des Pivot-Elements (hier: das mittlere Element)
        int pivot = array[(low + high) / 2];
        int i = low, j = high;

        // Partitionierung des Arrays
        while (i <= j) {
            // Elemente auf der linken Seite des Pivots suchen, die größer sind als das Pivot
            while (array[i] < pivot) {
                i++;
            }
            // Elemente auf der rechten Seite des Pivots suchen, die kleiner sind als das Pivot
            while (array[j] > pivot) {
                j--;
            }
            // Wenn ein Element auf der linken Seite größer ist als das Pivot und ein Element
            // auf der rechten Seite kleiner ist als das Pivot, tauschen wir sie aus
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        
        // Rekursiver Aufruf für die beiden Partitionen
        if (low < j) {
            sort(array, low, j);
        }
        if (high > i) {
            sort(array, i, high);
        }
    }
	
    public static void bubbleSort(int[] arr) {
        int n = arr.length; // Länge des Arrays

        // Äußere Schleife iteriert durch das gesamte Array
        for (int i = 0; i < n - 1; i++) {
            // Innere Schleife iteriert von 0 bis n - i - 1
            // Letztes Element wird bereits sortiert sein
            for (int j = 0; j < n - i - 1; j++) {
                // Vergleicht benachbarte Elemente
                if (arr[j] > arr[j + 1]) {
                    // Tauscht die Elemente, wenn sie in falscher Reihenfolge sind
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


	public static int[] arrerstellen(int n) {
	
		//es wird ein Array mit n Zufallszahlen erstellt
		int vArray[] = new int[n];
				
	 	Random rnd = new Random(); 
		
		for (int i = 0; i < n; i++) {
			vArray[i]=rnd.nextInt(100);
		}
		
		return vArray;
	}
	
	public static String arrdarstellen(int[] vArray) {
	    int n = vArray.length; // Assuming 'n' is the length of the array
	    int ie0, ien05, ienm1;
	    String e0, en05, enm1;
	    ie0 = Integer.valueOf(vArray[0]);
	    e0 = Integer.toString(ie0);
	    ien05 = Integer.valueOf(vArray[n / 2]);
	    en05 = Integer.toString(ien05); 
	    ienm1 = Integer.valueOf(vArray[n - 1]);
	    enm1 = Integer.toString(ienm1);
	    String arrdarst="E(0): " + e0 + ", E(n/2): " + en05 + ", E(n-1): " + enm1;
	    return arrdarst;
	}
	
	public static String arrdarstellen_label(int vArray[]) {
	    int n = vArray.length; // Assuming 'n' is the length of the array
	    String e0, en05, enme;
	    int ie0, ien05, ienme;
	    ie0 = Integer.valueOf(vArray[0]);
	    e0 = Integer.toString(ie0);
	    ien05 = Integer.valueOf(vArray[n / 2]);
	    en05 = Integer.toString(ien05);
	    ienme = Integer.valueOf(vArray[n - 1]);
	    enme = Integer.toString(ienme);
	    String drst="E(0): " + e0 + ", E(n/2): " + en05 + ", E(n-1): " + enme;
	    return drst;
	}
	
	public static void arrdarstellen2(int[] vArray) {
	    int n = vArray.length; // Assuming 'n' is the length of the array
	    System.out.print("Zufallszahlen: ");
	    for (int i=0; i < n; i++) {
	    	System.out.print(vArray[i]+" ");}
	}
	
	public static Boolean arrIstSortiert(int vArray[]) {
		//Prüft ob alle Elemente nach Größe sortiert sind
	    boolean sort = true;
	    for (int i = 1; i < vArray.length; i++) {
	        if (vArray[i - 1] > vArray[i]) {
	            sort = false;
	            break;
	        }
	    }
	    return sort;
	}
	
	public static void sortomatgui (int[] vArray) {
	        // Erzeugung eines Frames       
	    JFrame sortoFrame = new JFrame("Sortomat!");
	    sortoFrame.setDefaultCloseOperation(sortoFrame.EXIT_ON_CLOSE);
	    	// Wir setzen die Breite und die Höhe unseres Fensters 
	    sortoFrame.setSize(440,700);
        //ImageIcon ico = new ImageIcon("emu.gif");
        //ico.setImage(ico.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
	    ImageIcon imageIcon = new ImageIcon("emu.gif");
	    sortoFrame.setIconImage(imageIcon.getImage());
        sortoFrame.setLayout(null);
	    sortoFrame.setLocationRelativeTo(null);
	    //ico.setImage(ico.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        
        //final JTextArea taTitel;
        
        // Erzeugung des Titels mit einer Textarea
        JTextArea taTitel = new JTextArea();
        sortoFrame.add(taTitel);
        taTitel.setFont(new Font("Arial", Font.PLAIN, 16));
        taTitel.setBounds(15, 15, 410, 130);
        taTitel.setLineWrap(true);
        taTitel.setOpaque(false);
        taTitel.setWrapStyleWord(true);
        taTitel.setText("Sortomat!\n\nWettkampf zweier Sortieralgorhithmen, Bubblesort gegen Quicksort - welcher sortiert schneller...");
        taTitel.setEditable(false);
        
        //  Erzeugung der bPanels
        JPanel bPanel1 = new JPanel();
        sortoFrame.add(bPanel1);
        bPanel1.setBounds(10, 130, 410, 130);
        JLabel lElemente1 = new JLabel();
        lElemente1.setText("Runde 1 - Array [n=10^e]: e =");
        JTextField tfElemente1 = new JTextField("3", 1);
        bPanel1.setBackground(Color.GREEN.darker());
        bPanel1.add(lElemente1);
        bPanel1.add(tfElemente1);
        JLabel battleLabel1 = new JLabel();
	    bPanel1.add(battleLabel1);
	    battleLabel1.setBounds(10, 150, 410, 20);
	    battleLabel1.setHorizontalAlignment(JLabel.CENTER);
	    battleLabel1.setText(Integer.toString(vArray.length)+" Elemente (n): "+arrdarstellen(vArray));

        /*JPanel bPanel2 = new JPanel();
        sortoFrame.add(bPanel2);
        bPanel2.setBounds(10, 270, 410, 130);        
        JLabel lElemente2 = new JLabel();
        lElemente2.setText("Runde 2 - Array [n=10^e]: e =");
        JTextField tfElemente2 = new JTextField("6", 1);
        bPanel2.setBackground(Color.GREEN.darker());
        bPanel2.add(lElemente2);
        bPanel2.add(tfElemente2);
        
        JPanel bPanel3 = new JPanel();
        sortoFrame.add(bPanel3);
        bPanel3.setBounds(10, 410, 410, 130);        
        JLabel lElemente3 = new JLabel();
        lElemente3.setText("Runde 3 - Array [n=10^e]: e =");
        JTextField tfElemente3 = new JTextField("9", 1);
        bPanel3.setBackground(Color.GREEN.darker());
        bPanel3.add(lElemente3);
        bPanel3.add(tfElemente3);
        

 
		sortoFrame.add(bPanel1);
		bPanel1.add(lElemente1);
		bPanel1.add(tfElemente1);
        bPanel1.add(battleLabel1);

        //Erzeugung der Battlepanels
        //1.
        
        JPanel bPanel1 = new JPanel();
        bPanel1.setBounds(15, 130, 410, 130);

        JLabel lElemente1 = new JLabel();
        lElemente1.setText("Array [n=10^e]: e =");
        
        JTextField tfElemente1 = new JTextField("2", 2);
        
        //2.
        
        JLabel bLabel2 = new JLabel();
	    sortoFrame.add(bLabel2);
	    bLabel2.setBounds(10, 120, 520, 20);
	    bLabel2.setHorizontalAlignment(JLabel.CENTER);
	    bLabel2.setText(Integer.toString(vArray.length)+" Elemente (n): "+arrdarstellen(vArray));
 
		/*sortoFrame.add(bPanel2);
		bPanel2.add(lElemente2);
		bPanel2.add(tfElemente2);
        bPanel2.add(battleLabel2);*/
        
        //3.*/

        sortoFrame.setVisible(true);
	}
	
	public static void main(String[] args) {

		final int n=1000; //Anzahl der Zufallszahlen
		int vArray[] = arrerstellen(n); //Zufalsszahlen zum Sortieren

		sortomatgui(vArray);
		
		int qArray[] = new int[n];//eine Kopie für Qicksort
		int bArray[] = new int[n];//eine Kopie für Bubblesort
		
		for (int i=0; i<n; i++) {
			qArray[i] = vArray[i];
			bArray[i] = vArray[i];			
		}
				
		/*arrdarstellen2(vArray); //alle Zufallszahlen ausgeben
		
		System.out.println(""); 
		System.out.println("");*/
		
		//System.out.println("Quicksort:"); //Beginn der Ausgabe für Quicksort
		//arrdarstellen(qArray); //Überblick vor der Sortierung
		long timeStampq1=System.currentTimeMillis(); //Zeit vor Beginn
		quickSort(qArray);
		long timeStampq2=System.currentTimeMillis(); //Zeit wenn fertig
		//System.out.println("Dauer von Quicksort für das Sortieren von "+n+" Elemnten: "+(timeStampq2-timeStampq1)+" Milisekunden");
		//arrdarstellen(qArray); //Überblick nach der Sortierung
		
		//System.out.println("");
		
		//System.out.println("Bubblesort:"); //Beginn der Ausgabe für Bubblesort
		//arrdarstellen(bArray); //Überblick vor der Sortierung
		long timeStampb1=System.currentTimeMillis(); //Zeit vor Beginn
		bubbleSort(bArray);
		long timeStampb2=System.currentTimeMillis(); //Zeit wenn fertig
		//System.out.println("Dauer von Bubblesort für das Sortieren von "+n+" Elemnten: "+(timeStampb2-timeStampb1)+" Milisekunden");
		//arrdarstellen(bArray); //Überblick nach der Sortierung
		//System.out.println(arrIstSortiert(bArray));
		//String label=arrdarstellen_label(vArray);

		//System.out.println(arrdarstellen_label(vArray));
	}
}
