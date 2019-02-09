package dla.cs134.miracosta.edu;

/**
 * Represents an item being shipped. It has a weight, base cost, added cost, and total cost
 */
public class ShipItem
{
    private static final double WEIGHT_THRESHOLD = 16;
    private static final double WEIGHT_DIVISOR = 4;
    private static final double SURCHARGE = 0.5;
    private static final double BASE_COST = 3.0;

    private double weight;
    private double baseCost;
    private double addedCost;
    private double totalShippingCost;

    /**
     * Default constructor for a shipment item
     * sets all variables to 0 except for the base cost
     */
    //default constructor
    public ShipItem()
    {
        weight = 0;
        baseCost = BASE_COST;
        addedCost = 0;
        totalShippingCost = 0;
    }

    /**
     * Sets the weight of the item and calculates the added cost and total shipping cost
     *
     * @param weight weight of the item
     */
    //setter
    public void setWeight(double weight)
    {
        this.weight = weight;
        recalculateAmounts();
    }


    /**
     * Getter for the weight
     *
     * @return the weight of the item
     */
    //getters
    public double getWeight() {
        return weight;
    }

    /**
     * Getter for the base cost
     * @return the base cost of the item
     */
    public double getBaseCost() {
        return baseCost;
    }

    /**
     * Getter for the added cost
     * @return the surcharge for heavier items
     */
    public double getAddedCost() {
        return addedCost;
    }

    /**
     * Getter for the total shipping cost
     * @return the total cost of shipping the item
     */
    public double getTotalShippingCost() {
        return totalShippingCost;
    }

    /**
     * Called when the weight is changed. Updates the added amount and shipping total
     */
    private void recalculateAmounts()
    {
        double amountTimesOver;

        //if weight is over the threshold
        if(weight > WEIGHT_THRESHOLD)
        {
            //get the amount of weight that is over
            weight -= WEIGHT_THRESHOLD;

            //get the amount of times the weight goes over the weight limit
            amountTimesOver = Math.ceil(weight / WEIGHT_DIVISOR);

            addedCost = amountTimesOver * SURCHARGE;

        }
        else//when the weight is not over the threshold
        {
            addedCost = 0;
        }

        if(weight != 0) //if weight is not zero
        {
            totalShippingCost = baseCost + addedCost;
        }
        else //when weight is 0 then the shipping cost is 0
        {
            totalShippingCost = 0;
        }
    }
}
