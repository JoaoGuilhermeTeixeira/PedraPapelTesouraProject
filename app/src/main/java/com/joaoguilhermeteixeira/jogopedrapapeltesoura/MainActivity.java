package com.joaoguilhermeteixeira.jogopedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecinarPedra(View view){

        verificarganhador("Pedra");

    }  
    
    public void selecinarPapel(View view){

        verificarganhador("Papel");

    }   
    
    public void selecinarTesoura(View view){

        verificarganhador("Tesoura");

    }

    private void verificarganhador(String escolhadoUsuario){

        String escolhaApp = gerarEscolhaAleatoria();
        TextView textResultado = findViewById(R.id.Text_Resultado);

        if(
            (escolhaApp == "Pedra" && escolhadoUsuario == "Tesoura") ||
            (escolhaApp == "Papel" && escolhadoUsuario == "Pedra") ||
            (escolhaApp == "Tesoura" && escolhadoUsuario == "Papel")
        )
        {
            textResultado.setText( "Eu Ganhei! Você Perdeu :(");

        }else if(
                (escolhadoUsuario == "Pedra" && escolhaApp == "Tesoura") ||
                (escolhadoUsuario == "Papel" && escolhaApp == "Pedra") ||
                (escolhadoUsuario == "Tesoura" && escolhaApp == "Papel")
        ){
            textResultado.setText( "Você Venceu!!! :)");


        }else{
            textResultado.setText( "Empatamos ;) Jogue Novamente");


        }

        //System.out.println("Item Clicado:" + escolhadoUsuario);
    }


    private String gerarEscolhaAleatoria() {

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio = new Random().nextInt(3); // "Random gera um Número aleatório com ".nextInt()"

        String escolhaApp = opcoes[numeroAleatorio];

        ImageView imageApp = findViewById(R.id.image_app);
        switch (escolhaApp){

            case "Pedra":
                imageApp.setImageResource(R.drawable.pedra);
                break;

            case "Papel":
                imageApp.setImageResource(R.drawable.papel);
                break;

            case "Tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;

        }

        return escolhaApp;

    }




}