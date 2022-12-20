package p2;

import p1.*;
import p1.Package;

class InsuredPackage extends p1.Package {
    float insurance;
    float totalCost;

    public InsuredPackage(float weight, char modeOfShipping) {
        super(weight, modeOfShipping);
        this.totalCost=setInsurance();
    }

    public float setInsurance() {
        if(this.cost>=0 && this.cost<=1)
            this.insurance = 2.45f;
        else if(this.cost>=1.01 && this.cost<=3)
            this.insurance = 3.95f;
        else if(this.cost>3.01)
            this.insurance = 5.55f;
        return this.cost+this.insurance;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Insurance cost: "+this.insurance);
        System.out.println("Total cost: "+this.totalCost);
    }
}

public class UsePackage {
}
