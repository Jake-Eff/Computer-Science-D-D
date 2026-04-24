public class FrequencyNode implements Comparable{
    
    private char value;
    private int frequency;
    private FrequencyNode parent;
    private FrequencyNode childOne;
    private FrequencyNode childTwo;
    private String binary;

    public FrequencyNode(char value, int frequency){
        this.value = value;
        this.frequency = frequency;
        this.parent = null;
        this.childOne = null;
        this.childTwo = null;
        this.binary = "";
        
    }

    public int compareTo(Object node){
        if(this.frequency < ((FrequencyNode) node).getFrequency()){
            return 1;
        } else if(this.frequency > ((FrequencyNode) node).getFrequency()){
            return -1;
        } else{
            return 0;
        }
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public FrequencyNode getParent() {
        return parent;
    }

    public void setParent(FrequencyNode parent) {
        this.parent = parent;
    }

    public FrequencyNode getChildOne() {
        return childOne;
    }

    public void setChildOne(FrequencyNode childOne) {
        this.childOne = childOne;
    }

    public FrequencyNode getChildTwo() {
        return childTwo;
    }

    public void setChildTwo(FrequencyNode childTwo) {
        this.childTwo = childTwo;
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

    
}