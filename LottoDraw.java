
// Import library to use Random
import java.util.Random;

/**
 * Simulates a lotto draw for fundraiser
 */
public class LottoDraw{

    // Instance of random class
    private Random random; 
    
    // List of all the lotto numbers available
    private StrLinkedList lottoNums;

    // The winning lotto numbers
    private StrLinkedList winNums;

    // The prize pool for the lotto
    private StrLinkedList prizePool;

    // The size of the ticket
    private int ticketSize;

    /**
     * Initializes a lotto draw object
     */
    public LottoDraw(){
        // Initialize variables
        random = new Random(); 
        lottoNums = new StrLinkedList();
        winNums = new StrLinkedList();
        prizePool = new StrLinkedList();
        ticketSize = 6;

        // Add numbers to the lotto
        addAllLottoNums();

        // Print out the lotto numbers
        System.out.print("Full Number List:");
        lottoNums.print();
        System.out.println("");

        // Draw the winning numbers
        drawWinNums();

        // Print out the winning numbers
        System.out.print("Winning Numbers:");
        winNums.print();
        System.out.println("");

        // Add prize-pool values
        addPrizePoolValues();

        // Print out the prize pool values
        System.out.print("Prize Money:");
        prizePool.print();
        System.out.println("");

        // Get and print the fundraiser profit
        fundraiserProfit();
    }

    /**
     * Adds all the win values into the prize pool list 
     */
    private void addPrizePoolValues(){
        prizePool.add("100000"); // 6 matches
        prizePool.add("10000");  // 5 matches
        prizePool.add("1000");   // 4 matches
        prizePool.add("100");    // 3 matches
        prizePool.add("10");     // 2 matches
        prizePool.add("0");      // 1 matches
        prizePool.add("0");      // 0 matches
    }

    /**
     * Adds all the wanted numbers into the lotto list
     */
    private void addAllLottoNums(){
        // Number of lotto numbers to add
        int numLottoNumbers = 40;

        // Add each number to the lotto numbers list
        for(int i=1; i<= numLottoNumbers; i++){
            lottoNums.add(String.valueOf(i));
        }   
    }

    /**
     * Draws the winning numbers for the lotto
     */
    private void drawWinNums(){
        // Number of winning numbers
        int numWinNums = ticketSize;

        // Shuffle the list
        shuffle(lottoNums, random);

        // Add to the winning ticket numbers
        for(int i = 0; i<numWinNums; i++){
            String num = lottoNums.getValueAt(i);
            winNums.add(num);
        }
    }

    /**
     * Get the profit from the lotto
     */
    private void fundraiserProfit(){
        // Number of tickets sold
        int numTickets = 100;

        // Price of a ticket
        double ticketPrice = 10.00;

        // Money won from the lotto tickets
        double ticketsProfit = 0.00;

        // The overall profit from running the lotto
        double fundraiserProfit = numTickets * ticketPrice;

        // Loop through the number of tickets to be generated
        for (int j = 0; j < numTickets; j++) {

            // Temporary list to hold a ticket
            StrLinkedList ticket = new StrLinkedList();

            // Shuffle the list
            shuffle(lottoNums, random);

            // Generate the a ticket
            for(int i = 0; i<ticketSize; i++){
                String num = lottoNums.getValueAt(i);
                ticket.add(num);
            }

            // Get the money won from the ticket 
            int prizeWon = getTicketProfit(ticket);

            // Add the prize money to the overall tickets profit
            ticketsProfit += prizeWon;

            // Print out the ticket
            System.out.print("Prize Won: $" + prizeWon + " Ticket: ");
            ticket.print();
        }

        // Print out the results of the fundraiser / lotto
        System.out.println("");
        System.out.println("Total number of tickets sold: " + numTickets);
        System.out.println("Total Earnings: " + fundraiserProfit);
        System.out.println("Total Prizes Won: " + ticketsProfit);

        // Calculate the profit made: tickets profit - prize money handed out
        fundraiserProfit = fundraiserProfit - ticketsProfit;

        System.out.println("Total Profit: " + fundraiserProfit);
    }

    /**
     * Gets the money won from the ticket given by comparing with the winning ticket
     * 
     * @param ticket The ticket to compare the winning ticket with
     * @return The amount of money won from the ticket
     */
    private int getTicketProfit(StrLinkedList ticket){
        int matches = 0;
        int prizeMoney = 0;
        // For each number in the ticket
        for(int i = 0; i<winNums.getLength(); i++){
            // If the number is contained in the winning lotto list
            if(winNums.hasValue(ticket.getValueAt(i))){
                // Increase the number of matches
                matches++;
            }
        }
        // Add to the prize money based on the number of matches
        prizeMoney = Integer.parseInt(prizePool.getValueAt(matches));
        //System.out.println(matches + " : " + prizePool.getValueAt(matches));

        return prizeMoney;
    }

    /**
    * Shuffles the given list using the Fisher-Yates shuffle algorithm.
    * @param list The list to be shuffled.
    * @param random The Random object used for generating random indices.
    */
    private void shuffle(StrLinkedList list, Random random) {
        // Shuffle the entire list of lotto numbers
        for (int i = list.getLength() - 1; i > 0; i--) {
            // Select a random element from the unshuffled portion of the list
            int index = random.nextInt(i + 1);
            // Swap the current element, i, with the randomly chosen element, index
            swap(list, i, index);
        }
    }

    /**
     * Swaps the elements at the specified indices in the given list.
     * @param list The list in which elements are to be swapped.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void swap(StrLinkedList list, int i, int j) {
        // Get nodes from the list
        Node nodeI = list.getNodeAt(i);
        Node nodeJ = list.getNodeAt(j);

        // Get the nodes values
        String iValue = nodeI.getValue();
        String jValue = nodeJ.getValue();

        // Swap the values between the nodes
        nodeI.setValue(jValue);
        nodeJ.setValue(iValue);
    }
}