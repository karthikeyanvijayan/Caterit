package karthik.com.caterit.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

import karthik.com.caterit.MainActivity;
import karthik.com.caterit.R;

import static karthik.com.caterit.R.drawable.ic_shopping_cart;

public class AppOnboardActivity extends AhoyOnboarderActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_app_onboard);


        String[] onboardTitles = this.getResources().getStringArray(R.array.onboard_titles);
        String[] onboardDesc = this.getResources().getStringArray(R.array.onboard_desc);
        Integer[] icons = new Integer[]{
                R.drawable.ic_dining,
                ic_shopping_cart,
                R.drawable.ic_menu_share
        };

        List<AhoyOnboarderCard> pages = new ArrayList<>();

        for (int i = 0; i < onboardTitles.length; i++) {

            AhoyOnboarderCard ahoyOnboarderCard = new AhoyOnboarderCard(onboardTitles[i],
                    onboardDesc[i], icons[i]);
            ahoyOnboarderCard.setBackgroundColor(R.color.colorWhite20);
            pages.add(ahoyOnboarderCard);
        }

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.colorPrimary);
            page.setDescriptionColor(R.color.colorWhite);
        }

        setFinishButtonTitle("Get Started");
        showNavigationControls(true);
//
//        List<Integer> colorList = new ArrayList<>();
//        colorList.add(R.color.colorPrimary);
//        colorList.add(R.color.colorBlueGrey);
//        colorList.add(R.color.colorPrimaryLight);
//
//        setColorBackground(colorList);
        setImageBackground(R.drawable.image_bg3);

        setInactiveIndicatorColor(R.color.white);
        setActiveIndicatorColor(R.color.colorPrimary);

        setOnboardPages(pages);


    }

    @Override
    public void onFinishButtonPressed() {
        Intent loginIntent = new Intent(this, MainActivity.class);
        startActivity(loginIntent);
    }
}
