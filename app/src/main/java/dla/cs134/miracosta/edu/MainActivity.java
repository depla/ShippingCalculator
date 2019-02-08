package dla.cs134.miracosta.edu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    //instantiate the member variables for the views
    private EditText weightEditText;
    private TextView baseCostTextView;
    private TextView addedCostTextView;
    private TextView totalShippingCostTextView;

    //member variables for our model
    private ShipItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize all member variables in onCreate
        weightEditText = findViewById(R.id.weightEditText);
        baseCostTextView = findViewById(R.id.baseCostTextView);
        addedCostTextView = findViewById(R.id.addedCostTextView);
        totalShippingCostTextView = findViewById(R.id.totalShippingCostTextView);

        //init our model
        item = new ShipItem();

        //set text views to show defaults
        baseCostTextView.setText(currency.format(item.getBaseCost()));
        addedCostTextView.setText(currency.format(item.getAddedCost()));
        totalShippingCostTextView.setText(currency.format(item.getTotalShippingCost()));

        //request focus for the edit text
        weightEditText.requestFocus();

        //set up text edit, add a textChangedListener
        weightEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //update model
                if (weightEditText.getText().toString().length() > 0)
                {
                    item.setWeight(Double.parseDouble(weightEditText.getText().toString()));
                }
                else
                {
                    item.setWeight(0.0);
                }

                //update the text views
                baseCostTextView.setText(currency.format(item.getBaseCost()));
                addedCostTextView.setText(currency.format(item.getAddedCost()));
                totalShippingCostTextView.setText(currency.format(item.getTotalShippingCost()));

            }

            @Override
            public void afterTextChanged(Editable s) {
                //do nothing
            }
        });

    }


}
