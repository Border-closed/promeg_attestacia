public class toy {
    public String name;
    public int id;
    public int count;
    public int frequency;

    public toy (String name, int id, int count, int frequency) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.frequency = frequency;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getCount(){
        return count;
    }

    public int getFrequency(){
        return frequency;
    }

    public String toString() {
        return "Игрушка " + name + " в количестве " + count + " с вероятностью " + frequency;
    }

    public int change (int frequency){
        return frequency;
    }

    public int minus (){
        return frequency-1;
    }
}
