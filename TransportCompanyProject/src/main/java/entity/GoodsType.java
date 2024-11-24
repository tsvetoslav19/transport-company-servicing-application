package entity;

public enum GoodsType {
    ANIMATE("Animate",0),
    INANIMATE("Inanimate", 0);

    private String name;
    private int amount;

    GoodsType(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if(amount > 0) {
            this.amount = amount;
        }
        else {
            System.out.println("INVALID AMOUNT OF GOODS");
        }
    }
}
