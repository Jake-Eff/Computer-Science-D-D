public class FrequencyNode implements Comparable{
    
    private Character value;
    private int frequency;
    private FrequencyNode parent;
    private FrequencyNode childOne;
    private FrequencyNode childTwo;
    private int binary;

    public FrequencyNode(Character value, int frequency){
        this.value = value;
        this.frequency = frequency;
        this.parent = null;
        this.childOne = null;
        this.childTwo = null;
        this.binary = 0;
        
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

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
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

    public int getBinary() {
        return binary;
    }

    public void setBinary(int binary) {
        this.binary = binary;
    }

    
}