package cat.itb.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button rollButton, resetButton;
    ImageView dado1, dado2;
    int d1,d2;
    int[] diceImage = {R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dado1 = findViewById(R.id.dado1);
        dado2 = findViewById(R.id.dado2);
        rollButton = findViewById(R.id.roll_button);
        resetButton = findViewById(R.id.resetButton);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollButton.setText("Dice Rolled");
                d1=girarDado(dado1);
                d2=girarDado(dado2);
                isJackpot();

            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dado1.setVisibility(View.INVISIBLE);
                dado2.setVisibility(View.INVISIBLE);
                rollButton.setText("Roll the dice");
            }
        });

        dado1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView dado = (ImageView) v;
                d1=girarDado(dado);
                isJackpot();
            }
        });

        dado2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView dado = (ImageView) v;
                d2=girarDado(dado);
                isJackpot();

            }
        });
    }
    public int girarDado(ImageView v){
        int max=5, min=1,range = (max - min) + 1;
        int resultat = (int)Math.floor((Math.random() * range) + min);
        v.setVisibility(View.VISIBLE);
        v.setImageResource(diceImage[resultat]);
        return resultat;
    }

    void isJackpot(){
        if (d1 == d2 && d2 == 5){
            Toast jackpot = Toast.makeText(MainActivity.this,"JACKPOT!",Toast.LENGTH_SHORT );
            jackpot.setGravity(Gravity.TOP|Gravity.CENTER,0,0);
            jackpot.show();

        }
    }
}
