package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //* пальто - 70 серебряных монет ( + скидка 77%)
    //    o шляпа - 25 серебряных монет ( + скидка 37%)
    //    o деловой̆костюм - 53 серебряных монет ( + скидка 44%
    //            o сорочка - 19 серебряных монет (нет скидки);
    //    o туфли - 41 серебряная монета ( + скидка 32%)
    //    На счету имеется 312 серебряных монет

    private int coat = 70;
    private int coatDiscount = 77;

    private int hat = 25;
    private int hatDiscount = 37;

    private int business_Suit = 53;
    private int business_SuitDiscount = 44;

    private int shirt = 19;

    private int shoes = 41;
    private int shoesDiscount = 32;

    private int money = 312;

    private double calculation() {
        double count = (coat * (100 - coatDiscount)
                + hat * (100 - hatDiscount)
                + business_Suit * (100 - business_SuitDiscount)
                + shirt + shoes * (100 - shoesDiscount)) / 100;
        return count;
    }

    private boolean possibility() {
        if (money - calculation() < 0) {
            return false;
        } else {
            return true;
        }
    }

    private double balance() {
        if (possibility()) {
            return money - calculation();
        } else {
            return -1;
        }
    }

    private TextView possibilityOut;
    private TextView balanceOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);

        if (possibility()) {
            possibilityOut.setText("Есть");
            balanceOut.setText("Да. Осталось " + balance() + " денег");
        } else {
            possibilityOut.setText("Нет");
            balanceOut.setText(" - ");
        }
    }
}