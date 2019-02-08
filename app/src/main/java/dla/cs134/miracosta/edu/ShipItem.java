package dla.cs134.miracosta.edu;

public class ShipItem
{
    private static final double WEIGHT_THRESHOLD = 16;
    private static final double WEIGHT_DIVISOR = 4;
    private static final double SURCHARGE = 0.5;

    private double weight;
    private double baseCost;
    private double addedCost;
    private double totalShippingCost;

    //default constructor
    public ShipItem()
    {
        weight = 0;
        baseCost = 3;
        addedCost = 0;
        totalShippingCost = 0;
    }

    //constructor with all variables
    public ShipItem(double w, double b, double a, double t)
    {
        weight = w;
        baseCost = b;
        addedCost = a;
        totalShippingCost = t;
    }

    //setter
    public void setWeight(double weight)
    {
        this.weight = weight;
        recalculateAmounts();
    }


    //getters
    public double getWeight() {
        return weight;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public double getAddedCost() {
        return addedCost;
    }

    public double getTotalShippingCost() {
        return totalShippingCost;
    }


    private void recalculateAmounts()
    {
        double amountTimesOver;

        if(weight > WEIGHT_THRESHOLD)
        {
            //get the amount of weight that is over
            weight -= WEIGHT_THRESHOLD;

            //round down
            amountTimesOver = Math.ceil(weight / WEIGHT_DIVISOR);

            addedCost = amountTimesOver * SURCHARGE;

        }
        else
        {
            addedCost = 0;
        }

        if(weight != 0)
        {
            totalShippingCost = baseCost + addedCost;
        }
        else
        {
            totalShippingCost = 0;
        }
    }
}
