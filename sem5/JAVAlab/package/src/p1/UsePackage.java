package p1;

class Package {
    float weight, cost;
    char modeOfShipping;

    public Package(float weight, char modeOfShipping) {
        this.weight = weight;
        this.modeOfShipping = modeOfShipping;
        calculateCost();
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void calculateCost () {
        switch (this.modeOfShipping) {
            case 'A':
                if(this.weight >=1 && this.weight <=8) {
                    setCost(2);
                } else if (this.weight<=16) {
                    setCost(3);
                } else if (this.weight>=17) {
                    setCost(4.5f);
                }
                break;
            case 'T':
                if(this.weight >=1 && this.weight <=8) {
                    setCost(1.5f);
                } else if (this.weight<=16) {
                    setCost(2.35f);
                } else if (this.weight>=17) {
                    setCost(3.25f);
                }
                break;
            case 'M':
                if(this.weight >=1 && this.weight <=8) {
                    setCost(0.5f);
                } else if (this.weight<=16) {
                    setCost(1.5f);
                } else if (this.weight>=17) {
                    setCost(2.15f);
                }
                break;
            default:
                System.out.print("Invalid mode of shipping!");
        }
    }

    public void display(){
        System.out.println("Weight: "+this.weight);
        System.out.println("Mode: "+this.modeOfShipping);
        System.out.println("Cost: "+this.cost);
    }
}



public class UsePackage {
    public static void main(String[] args) {
        InsuredPackage p1 = new InsuredPackage(14,'M');
        p1.display();
    }
}