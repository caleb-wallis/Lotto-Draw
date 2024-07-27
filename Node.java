
/**
 * Node for a linked list of strings
 * */
public class Node{

    // Value of the node
    private String value;
    // The node that this node points to
    private Node next;

    /**
     * Sets the value of the node
     * 
     * @param string the string that the value will become
     * */
    public void setValue(String string){
        value = string;
    }

    /**
     * Sets the node that this node is pointing to
     * 
     * @param node the node that this node will point to
     * */
    public void setNext(Node node){
        next = node;
    }

    /**
     * Gets the value of this node
     * 
     * @return The value of the node
     * */
    public String getValue(){
        return value;
    }

    /**
     * Gets the node that this node is pointing to
     * 
     * @return The next node from the current node
     * */
    public Node getNext(){
        return next;
    }

    /**
     * Initializes a Node Object
     * */
    public Node(String s){
        setValue(s);
    }
}