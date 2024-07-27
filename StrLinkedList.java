
/**
 * Linked list of strings
 * */
public class StrLinkedList{

    // Head of the linked list
    private Node head;

    // Initialize a string linked list object
    public StrLinkedList(){
        head = null;
    }


    /**
     * Returns whether the list is empty or not
     * 
     * @return True if the list is empty; otherwise returns false
     */
    public boolean isEmpty(){
        // if the start of the list is null return true
        if(head == null){
            return true;
        }
        // else return false
        return false;
    }


    /**
     * Returns a count of the number of values in the linked list; zero if the list is empty.
     * 
     * @return The number of values in the list
     */
    public int getLength(){
        // set count to 0 and set current to head to count from start of the list
        Node current = head;
        int count = 0;

        // while not at the end of the list
        while(current != null){
            // add 1 to count
            count++;
            // move to next value
            current = current.getNext();
        }
        // return number of values in list
        return count;
    }

    /**
     * Returns whether the linked list contains a node whose value is the same as s.
     *
     * @param s The string to find in the list
     * @return True if the list contains the value; false otherwise.
     */
    public boolean hasValue(String s){
        // Set current to the start of the list
        Node current = head;
        // While not at the end of the list
        while(current != null){
            // If the current nodes value is the same as s return true
            if(current.getValue() == s){
                return true;
            }
            // Else go to the next node
            current = current.getNext();
        }
        // If value not in the list return false
        return false;
    }

    /**
     * Returns the string that's at position i in the list.
     * 
     * @param i Position of node to find
     * @return String at position i or null if position i doesn't exist
     */
    public String getValueAt(int i){
        // set count to 0 and set current to head to count from start of the list
        Node current = head;
        int count = 0;

        // While not at the end of the list
        while(current != null && i >= 0){
            // If the count is equal to i then we have found the correct node
            if(count == i){
                return current.getValue();
            }
            // Else go to the next node
            current = current.getNext();
            count++;
        }
        // If i is greater than list
        return "NOT FOUND";
    }


     /**
     * Finds and gets the node at a position in the list
     * 
     * @param i Position of node to find
     * @return The node if it exists else returns null
     */
    public Node getNodeAt(int i){
        // set count to 0 and set current to head to count from start of the list
        Node current = head;
        int count = 0;

        // While not at the end of the list
        while(current != null && i >= 0){
            // If the count is equal to i then we have found the correct node
            if(count == i){
                return current;
            }
            // Else go to the next node
            current = current.getNext();
            count++;
        }
        // If i is greater than list
        return null;
    }


    /**
     * Adds a new node to the head of the list.
     * 
     * @param s The value of the new node
     */
    public void add(String s){
        // Create a new node
        Node newNode = new Node(s);

        // If the list isn't empty then make newNode point to the head
        if(head != null){
            newNode.setNext(head);
        }

        // Make the head point to newNode
        head = newNode;
    }

    /**
     * Removes the first node with a string value equal to s. The order of nodes remains unaffected.
     * Note: To remove current you need to have the previous and future values (previous and current get these values)
     * 
     * @param s String value of node to find and remove
     */
    public void remove(String s){
        // Set previous to the start of the list
        Node previous = head;

        // If there is nothing in the list
        if(previous == null){
            return;
        }

        // If the value is at the very start of the list
        if(previous.getValue() == s){
            // Make the head point to the next node
            head = previous.getNext();
            return;
        }

        // Set current to the node that is next using previous
        Node current = previous.getNext();

        // While not at the end of the list
        while(current != null){

            // If the current node value is the same as s
            if(current.getValue() == s){
                // Remove the node
                previous.setNext(current.getNext());
                break;
            }
            // If the current node value is not the same as s
            else{
                // Move the current and previous up the list by 1
                previous = current;
                current = current.getNext();
            }
        }
    }

    /**
     * Prints out the node values that are inside the list in order
     */
    public void print(){
        // Start from the beginning of the list
        Node current = head;
        // Loop through the entire list from the start
        while(current != null){
            // Print out the value of the current node
            System.out.print(current.getValue() + "->");
            current = current.getNext();
        }
        System.out.println();
    }
}